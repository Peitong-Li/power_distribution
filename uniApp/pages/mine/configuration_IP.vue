<template>
	<view>
		<input style="background-color:#E5E5E5; border-radius: 10upx;height: 100upx; margin-top: 20upx;" type="text" v-model="IP"/>
		<button style="width: 50%; margin-top: 10upx;" type="primary" @click="confirmIP">确定</button>
	</view>
</template>

<script>
	import {config_url} from '../../default/get_url.js'
	export default{
		data(){
			return{
				IP:"请输入配置IP"
			}
		},
		methods: {
			confirmIP() {
				configIp(this.IP)
				console.log(config_url.baseurl)
				uni.showToast({
					title: "配置成功！",
					icon: "success",
					duration: 2000
				})
				uni.switchTab({
					url: "../index/index"
				})
			}
		}
	}
</script>

<style>
</style>
