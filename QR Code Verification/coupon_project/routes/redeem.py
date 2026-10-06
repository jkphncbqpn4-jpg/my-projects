import datetime

from flask import Blueprint, jsonify, request

from database.db import get_connection
from config import DEVICE_ID, DEVICE_KEY

redeem_bp = Blueprint('redeem', __name__)


@redeem_bp.route('/api/redeem', methods=['POST'])
def redeem():
    data = request.get_json(silent=True) or {}

    token = data.get("token")

    if not token:
        return jsonify({
            'msg': '缺少优惠券 token'
        }), 400

    conn = get_connection()
    cursor = conn.cursor()

    cursor.execute(
        '''
         SELECT * FROM devices 
         WHERE id = %s AND device_key = %s
        ''',
        (DEVICE_ID, DEVICE_KEY)
    )

    device = cursor.fetchone()

    if device is None:
        cursor.close()
        conn.close()

        return jsonify({
            'msg':'设备不存在'
        }),404

    if device[3] == 0:
        cursor.close()
        conn.close()

        return jsonify({
            'msg': '设备已停用'
        }),403

    cursor.execute(
        "SELECT * FROM coupons WHERE token = %s",
        (token,)
    )

    coupon = cursor.fetchone()

    if coupon is None:

        cursor.execute(
            'INSERT INTO verify_logs'
            '(coupon_id,device_id,result,message,created_at)'
            'VALUES (%s, %s, %s, %s,NOW())',
            (None,DEVICE_ID,'failed','券不存在')
        )

        conn.commit()
        cursor.close()
        conn.close()

        return jsonify({
            'msg':'券不存在'
        }),404

    elif coupon[4] ==1:
        cursor.close()
        conn.close()

        return jsonify({
            'msg':'券已经核销'
        }),400

    else:
        now = datetime.datetime.now()

        if now < coupon[5]:
            cursor.close()
            conn.close()

            return jsonify({
                'msg':'券还没到有效期'
            }),400

        elif now > coupon[6]:
            cursor.close()
            conn.close()

            return jsonify({
                'msg':'券已过期'
            }),400

        cursor.execute(
            'UPDATE coupons SET status = 1,verified_at = NOW() where id = %s',
            (coupon[0],)
        )

        cursor.execute(
            'INSERT INTO verify_logs'
            '(coupon_id, device_id, result, message,created_at)'
            ' VALUES (%s,%s,%s,%s,NOW())',
            (coupon[0],DEVICE_ID,'success','核销成功')
        )

        conn.commit()

        cursor.close()
        conn.close()

        return jsonify({
            'msg':'核销成功',
        })