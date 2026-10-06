from flask import Blueprint,jsonify
from database.db import get_connection

verify_log = Blueprint('verify_log',__name__)

@verify_log.route('/api/verify-log',methods=['GET'])
def get_verify_log():
    conn = get_connection()
    cursor = conn.cursor()

    cursor.execute('''
    SELECT
        verify_logs.id,
        verify_logs.coupon_id,
        verify_logs.device_id,
        verify_logs.result,
        verify_logs.message,
        verify_logs.created_at,
        coupons.token
        FROM verify_logs 
        LEFT JOIN coupons 
            ON verify_logs.coupon_id = coupons.id
        ORDER BY verify_logs.created_at DESC
    '''
)
    logs = cursor.fetchall()

    data = []

    for log in logs:
        data.append({
            'id':log[0],
            'coupon_id':log[1],
            'device_id':log[2],
            'result':log[3],
            'message':log[4],
            'created_at':log[5],
            'token':log[6]
        })

        cursor.close()
        conn.close()
        return jsonify(data)
    
