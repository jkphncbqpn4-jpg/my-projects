from flask import Blueprint, request, jsonify
from database.db import get_connection

user_bp = Blueprint('user', __name__)


@user_bp.route('/api/users', methods=['POST'])
def create_user():
    data = request.get_json(silent=True) or {}
    student_no = data.get('student_no')
    name = data.get('name')

    if not student_no or not name:
        return jsonify({
            'msg':'缺少学生信息'
        }),400

    conn = get_connection()
    cursor = conn.cursor()

    cursor.execute(
        'SELECT * FROM users WHERE student_no = %s',
        (student_no,)
    )

    user = cursor.fetchone()

    if user is not None:
        cursor.close()
        conn.close()

        return jsonify({
            'msg':'学号已经存在'
        }),400

    cursor.execute('''
    INSERT INTO users 
    (student_no, name, created_at)
     VALUES (%s, %s, NOW())
     ''', (student_no, name)
    )

    conn.commit()

    user_id = cursor.lastrowid

    cursor.close()
    conn.close()

    return jsonify({
        'msg':'学生注册成功',
        'user_id': user_id
    }),201

@user_bp.route('/api/users/<int:user_id>', methods=['GET'])
def get_user(user_id):
    conn = get_connection()
    cursor = conn.cursor()

    cursor.execute(
        'SELECT * FROM users WHERE id = %s',
        (user_id,)
    )

    user = cursor.fetchone()

    cursor.close()
    conn.close()

    if user is None:
        return jsonify({
            'msg':'学生不存在'
        }),404

    return jsonify({
        'id': user[0],
        'student_no': user[1],
        'name': user[2],
        'created_at': str(user[3])
    })

@user_bp.route('/api/users/<int:user_id>/coupons', methods=['GET'])
def get_coupons(user_id):
    conn = get_connection()
    cursor = conn.cursor()

    cursor.execute(
        'SELECT * FROM users WHERE id = %s',
        (user_id,)
    )

    user = cursor.fetchone()

    if user is None:

        cursor.close()
        conn.close()

        return jsonify({
            'msg':'学生不存在'
        }),404

    cursor.execute('''
    SELECT
        id,
        activity_id,
        token,
        status,
        valid_from,
        valid_to,
        issued_by,
        created_at,
        verified_at
    FROM coupons
    WHERE user_id = %s
    ORDER BY created_at DESC
    ''',
    (user_id,)
)
    coupons = cursor.fetchall()

    cursor.close()
    conn.close()

    data = []

    for coupon in coupons:
        data.append({
            'id': coupon[0],
            'activity_id': coupon[1],
            'token': coupon[2],
            'status': coupon[3],
            'valid_from': str(coupon[4]) if coupon[4] else None,
            'valid_to': str(coupon[5]) if coupon[5] else None,
            'issued_by': coupon[6],
            'created_at': str(coupon[7]),
            'verified_at': str(coupon[8]) if coupon[8] else None
        })

    return jsonify(data)
