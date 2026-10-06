from functools import total_ordering

from flask import Blueprint, jsonify, request, session
from  database.db import get_connection
from datetime import datetime

activity_bp = Blueprint('activity',__name__)
@activity_bp.route('/api/activities', methods=['GET'])

def get_activities():
    conn = get_connection()
    cursor = conn.cursor()
    cursor.execute(
        'SELECT * FROM activities'
    )
    activities = cursor.fetchall()
    data = []
    for activity in activities:
        data.append({
            'id': activity[0],
            'name': activity[1],
            'start_time': str(activity[2]),
            'end_time': str(activity[3]),
            'status': activity[4],
            'created_by': activity[5],
            'created_at': str(activity[6])
        })
    return jsonify(data)

@activity_bp.route('/api/activities/<int:activity_id>', methods=['GET'])
def get_activity(activity_id):
    conn = get_connection()
    cursor = conn.cursor()

    cursor.execute('SELECT * FROM activities WHERE id = %s',
                   (activity_id,)
                   )
    activity = cursor.fetchone()
    cursor.close()
    conn.close()

    if activity is None:
        return jsonify({
            'msg':'活动不存在'
        }),404

    return jsonify({
        'id': activity[0],
        'name': activity[1],
        'start_time': str(activity[2]),
        'end_time': str(activity[3]),
        'status': activity[4],
        'created_by': activity[5],
        'created_at': str(activity[6])
    })


@activity_bp.route('/api/activities', methods=['POST'])
def create_activity():
    data = request.get_json(silent=True) or {}
    name = data.get('name')
    start_time = data.get('start_time')
    end_time = data.get('end_time')

    if not name or not start_time or not end_time:
        return jsonify({
            'msg':'缺少活动信息'
        }),400
    admin_id = session.get('admin_id')

    if admin_id is None:
        return jsonify({
            'msg':'请先登录'
        }),401

    conn = get_connection()
    cursor = conn.cursor()
    cursor.execute(
        'SELECT * FROM admins WHERE id=%s',
        (admin_id,)
    )
    admin = cursor.fetchone()

    if admin is None:
        cursor.close()
        conn.close()
        return jsonify({
            'msg':'管理员不存在'
        }),404
    cursor.execute(
        '''INSERT INTO activities
        (name, start_time, end_time, status, created_by, created_at)
        VALUES (%s, %s, %s, %s, %s, NOW())''',
        (name,start_time,end_time,0,admin_id)
    )
    conn.commit()

    activity_id = cursor.lastrowid

    cursor.close()
    conn.close()

    return jsonify({
        'msg': '活动创建成功',
        'activity_id': activity_id
    }), 201

@activity_bp.route('/api/activities/<int:activity_id>', methods=['PUT'])
def update_activity(activity_id):
    data = request.get_json(silent=True) or {}
    name = data.get('name')
    start_time = data.get('start_time')
    end_time = data.get('end_time')

    if not name or not start_time or not end_time:
        return jsonify({
            'msg':'缺少活动信息'
        }),400

    admin_id = session.get('admin_id')

    if admin_id is None:
        return jsonify({
            'msg':'请先登录'
        }),401

    conn = get_connection()
    cursor = conn.cursor()

    cursor.execute(
        'SELECT * FROM activities WHERE id = %s',
        (activity_id,)
    )

    activity = cursor.fetchone()

    if activity is None:
        return jsonify({
            'msg':'活动不存在'
        }),404

    cursor.execute(
        '''
        UPDATE activities SET name = %s, start_time = %s, end_time = %s WHERE id = %s
        ''',
        (name, start_time, end_time, activity_id)
    )
    conn.commit()

    cursor.close()
    conn.close()

    return jsonify({
        'msg':'活动修改成功'
    })

@activity_bp.route('/api/activities/<int:activity_id>/status', methods=['PUT'])
def update_activity_status(activity_id):
    admin_id = session.get('admin_id')
    if admin_id is None:
        return jsonify({
            'msg':'请先登录'
        }),401

    conn = get_connection()
    cursor = conn.cursor()

    cursor.execute(
        'SELECT * FROM activities WHERE id = %s',
        (activity_id,)
    )
    activity = cursor.fetchone()
    if activity is None:
        return jsonify({
            'msg':'活动不存在'
        }),404

    cursor.execute(
        'UPDATE activities SET status = 1 WHERE id = %s',
        (activity_id,)
    )
    conn.commit()
    cursor.close()
    conn.close()
    return jsonify({
        'msg':'活动已结束'
    })

@activity_bp.route('/api/activities/<int:activity_id>/stats', methods=['GET'])
def get_activity_status(activity_id):
    conn = get_connection()
    cursor = conn.cursor()

    cursor.execute(
        'SELECT * FROM activities WHERE id = %s',
        (activity_id,)
     )

    activity = cursor.fetchone()

    if activity is None:
        return jsonify({
            'msg':'活动不存在'
        }),404
    cursor.execute(
        '''
        SELECT COUNT(*)FROM coupons WHERE activity_id = %s
        ''',
        (activity_id,)
    )

    total_coupons = cursor.fetchone()[0]

    cursor.execute('''
    SELECT COUNT(*) FROM coupons WHERE id = %s AND status = 1''',
    (activity_id,)
)
    verified_coupons = cursor.fetchone()[0]
    cursor.close()
    conn.close()
    return jsonify({
        'activity_id': activity_id,
        'total_coupons': total_coupons,
        'verified_coupons': verified_coupons,
        'unverified_coupons': total_coupons - verified_coupons,
    })