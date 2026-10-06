<template>
	<view>
		<button @click="goRegiest">
			学生注册
		</button>
	</view>
</template>
<script setup>
	const goRegiest = () => {
		uni.navigateTo({
			url:'/pages/register/register'
		})
	}
</script>

<style>

</style>
