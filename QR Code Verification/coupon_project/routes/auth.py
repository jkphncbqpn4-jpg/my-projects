from flask import Blueprint, jsonify, request, session
from database.db import get_connection
from werkzeug.security import check_password_hash

auth_bp = Blueprint('auth', __name__)


def get_current_admin():
    admin_id = session.get('admin_id')

    if admin_id is None:
        return None
    return admin_id


@auth_bp.route('/api/login', methods=['POST'])
def login():
    data = request.get_json(silent=True) or {}
    username = data.get("username")
    password = data.get("password")

    if not username or not password:
        return jsonify({
            'msg':'缺少用户名或密码'
        }),400

    conn = get_connection()
    cursor = conn.cursor()
    cursor.execute(
        'SELECT * FROM admins WHERE username = %s',
        (username,)
    )

    admin = cursor.fetchone()
    if admin is None:
        cursor.close()
        conn.close()

        return jsonify({
            'msg':'用户名错误'
        }),401
    if not check_password_hash(admin[2], password):
        cursor.close()
        conn.close()
        return jsonify({
            'msg':'密码错误'
        }),401

    cursor.close()
    conn.close()

    session['admin_id'] = admin[0]

    return jsonify({
        'msg': '登录成功',
        'admin_id': admin[0],
        'username': admin[1],
        'name': admin[3]
    })


@auth_bp.route('/api/logout', methods=['POST'])
def logout():
    session.clear()

    return jsonify({
        'msg':'退出成功'
    }),200