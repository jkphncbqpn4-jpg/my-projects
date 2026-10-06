<template>
	<view>
		<view>学生信息</view>
		<view>学号:{{ studentNo }}</view>
		<view>姓名:{{ name }}</view>
		<view>{{ message }}</view>
	</view>
</template>

<script setup>
	import {
		ref,
		onMounted
	} from 'vue'

	const studentNo = ref('')
	const name = ref('')
	const message =ref('')

	onMounted(() => {
		const userId = uni.getStorageSync('user_id')
		console.log('当前 user_id:',userId)
		uni.request({
			url: 'http://172.17.135.110:5000/api/users/' + userId,
			method: 'GET',
			success:(res) => {
				console.log('学生信息',res)

				if (res.statusCode ===200) {
					studentNo.value = res.data.student_no
					name.value = res.data.name
				} else {
					message.value = res.data.msg
				}
			},
			fail:(err) => {
				console.log('请求失败:',err)
				message.value = '请求失败'
			}

		})
	})
	const goCoupons = () => {
		uni.navigateTo({
			url: '/pages/coupons/coupons'
		})
	}
</script>

<style>
</style>
