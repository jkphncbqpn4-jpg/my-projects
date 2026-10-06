import os

from flask import Blueprint, jsonify, send_file

qrcode_bp = Blueprint('qrcode', __name__)

BASE_DIR = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
QR_DIR = os.path.join(BASE_DIR, 'qrcodes')


@qrcode_bp.route('/api/qrcode/<token>')
def get_qrcode(token):
    qrcode_path = os.path.join(QR_DIR, token + '.png')

    if not os.path.exists(qrcode_path):
        return jsonify({
            'msg':'二维码不存在'
        }),404

    return send_file(qrcode_path, mimetype='image/png')