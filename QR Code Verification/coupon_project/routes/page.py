from flask import Blueprint, render_template

page_bp = Blueprint('page', __name__)


@page_bp.route('/redeem')
def redeem_page():
    return render_template('redeem.html')