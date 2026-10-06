from flask import Flask

from routes.auth import auth_bp
from routes.user import user_bp
from routes.coupon import coupon_bp
from routes.redeem import redeem_bp
from routes.qrcode import qrcode_bp
from routes.page import page_bp
from routes.activity import activity_bp
from routes.verify_log import verify_log

app = Flask(__name__)

app.secret_key = "test-secret-key"


app.register_blueprint(auth_bp)
app.register_blueprint(user_bp)
app.register_blueprint(coupon_bp)
app.register_blueprint(redeem_bp)
app.register_blueprint(qrcode_bp)
app.register_blueprint(page_bp)
app.register_blueprint(activity_bp)
app.register_blueprint(verify_log)

if __name__ == '__main__':
    app.run(
        host='0.0.0.0',
        port=5000,
        debug=True
    )