import datetime
import secrets
import qrcode
import os

from flask import Blueprint, jsonify, request
from database.db import get_connection
from routes.auth import get_current_admin

coupon_bp = Blueprint('coupon', __name__)

BASE_DIR = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
QR_DIR = os.path.join(BASE_DIR, 'qrcodes')

os.makedirs(QR_DIR, exist_ok=True)


@coupon_bp.route('/coupon/<token>')
def coupons(token):
    conn = get_connection()

    cursor = conn.cursor()
    cursor.execute(
        "SELECT * FROM coupons WHERE token = %s", (token,)
    )
    data = cursor.fetchone()

    cursor.close()
    conn.close()

    if data is None:
        return jsonify({
            "msg": "券不存在"
        }),404

    return jsonify({
        "id": data[0],
        "user_id": data[1],
        "activity_id": data[2],
        "token": data[3],
        "status": data[4],
        "valid_from": str(data[5]),
        "valid_to": str(data[6]),
        "issued_by": data[7],
        "created_at": str(data[8]),
        "verified_at": str(data[9])
    })


@coupon_bp.route('/api/coupon', methods=['POST'])
def coupon():
    data = request.get_json(silent=True) or {}

    user_id = data.get("user_id")
    activity_id = data.get("activity_id")
    issued_by = get_current_admin()

    if issued_by is None:
        return jsonify({
            'msg':'请先登录'
        }),401

    conn = get_connection()
    cursor = conn.cursor()

    cursor.execute(
        'SELECT * FROM admins WHERE id = %s',
        (issued_by,)
    )

    admin = cursor.fetchone()

    if admin is None:
        cursor.close()
        conn.close()

        return jsonify({
            'msg':'管理员不存在'
        }),404

    else:
        cursor.execute(
            'SELECT * FROM users WHERE id = %s',
            (user_id,)
        )

        user = cursor.fetchone()

        if user is None:
            cursor.close()
            conn.close()

            return jsonify({
                'msg':'用户不存在'
            }),404

    cursor.execute(
        'SELECT * FROM activities WHERE id = %s',
        (activity_id,)
    )

    activity = cursor.fetchone()

    if activity is None:
        cursor.close()
        conn.close()

        return jsonify({
            'msg':'活动不存在'
        }),404

    if activity[4] == 1:
        cursor.close()
        conn.close()

        return jsonify({
            'msg':'活动已结束'
        }),400

    else:
        now = datetime.datetime.now()

        if now < activity[2]:
            cursor.close()
            conn.close()

            return jsonify({
                'msg':'活动还未开始'
            }),400

        if now > activity[3]:
            cursor.close()
            conn.close()

            return jsonify({
                'msg':'活动已结束'
            }),400

    token = secrets.token_urlsafe(16)

    valid_from = activity[2]
    valid_to = activity[3]

    img = qrcode.make(token)

    qr_path = os.path.join(QR_DIR, token + '.png')
    img.save(qr_path)

    cursor.execute('''
    INSERT INTO coupons
    (user_id,activity_id,token,valid_from,valid_to,issued_by,created_at)
    VALUES (%s,%s,%s,%s,%s,%s,NOW())''',
    (user_id,activity_id,token,valid_from,valid_to,issued_by)
    )

    conn.commit()

    cursor.close()
    conn.close()

    return jsonify({
        'msg':'发券成功',
        'token': token,
        'qr_code': f'/api/qrcode/{token}'
    }),201