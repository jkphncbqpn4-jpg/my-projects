<template>
	<view>
		<view>学生注册</view>
		<input v-model="studentNo" placeholder="请输入学号">
		<input v-model="name" placeholder="请输入姓名">
		<button @click="register">注册</button>
		<view>{{message}}</view>
	</view>
</template>

<script setup>
	import {
		ref
	} from 'vue'

	const studentNo = ref('')
	const name = ref('')
	const message = ref('')

	const register = () => {
		uni.request({
			url: 'http://172.17.135.110:5000/api/users',
			method: 'POST',

			data: {
				student_no: studentNo.value,
				name: name.value
			},

			header: {
				'Content-Type': 'application/json'
			},

			success: (res) => {
				console.log('服务器响应', res)

				if (res.statusCode == 201) {
					message.value ='注册成功'

					uni.setStorageSync('user_id', res.data.user_id)
					uni.navigateTo({
						url:'/pages/user/user'
					})
				}
			},

			fail: (err) => {
				console.log('请求失败', err)
				message.value = '请求失败'
			}
		})
	}
</script>

<style>
</style>
