<template>
	<view>
		<view>我的优惠券</view>
		<view v-if="coupons.length === 0">
			暂无优惠券
		</view>
		<view v-for="coupon in coupons" :key="coupon.id">
			<view>
				优惠券 ID：{{ coupon.id }}
			</view>
			<view>
				活动 ID：{{ coupon.activity_id }}
			</view>
			<view>
				Token：{{ coupon.token }}
			</view>
			<view>
				状态：
				{{ coupon.status === 0 ? '未核销' : '已核销' }}
			</view>
			<view>
				有效期：
				{{ coupon.valid_from }}
				~
				{{ coupon.valid_to }}
			</view>
			<view>
				----------------
			</view>
		</view>
	</view>
</template>

<script setup>
	import {
		ref,
		onMounted
	} from 'vue'

	const coupons = ref([])

	onMounted(() => {
		const userId = uni.getStorageSync('user_id')
		console.log('当前 user_id:', userId)
		uni.request({
			url: 'http://172.17.135.110:5000/api/users/' + userId + '/coupons',
			method: 'GET',

			success: (res) => {
				console.log("优惠券信息:", res)

				if (res.statusCode === 200) {
					coupons.value = res.data
				}
			},

			fail: (err) => {
				console.log('请求失败:', err)
			}
		})
	})
</script>

<style>
</style>
