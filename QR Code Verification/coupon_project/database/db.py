import pymysql

def get_connection():
    conn = pymysql.connect(
        host='localhost',
        port=3306,
        user='root',
        passwd='123456',
        db='coupon_system',
        charset='utf8mb4'
    )
    return conn