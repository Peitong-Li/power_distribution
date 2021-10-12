<template>
	<view style="padding: 10rpx;">
		<text>通知标题</text>
		<input type="text"  v-model="title"/>
		<text>责任编辑</text>
		<input type="text"  v-model="peo"/>
		<text>通知内容</text>
		<textarea value=""   v-model="content" maxlength="800"  />
		
		<button type="default" @click="saveNotice">发布</button>
	</view>
	
</template>

<script>
	import {config_url} from '../../default/get_url.js'
	export default {
		data() {
			return {
				title:"",
				peo:"",
				content:""
			}
		},
		methods: {
			saveNotice(){
				let that = this;
				console.log(new Date().toLocaleDateString())
				
				if(this.title==''||this.peo==''||this.content==''){
					uni.showModal({
						title:"提示",content:"信息不全"
					})
					return 0;
				}
				
				var json = {};
				
				uni.request({
						url: config_url.baseurl + 'addNotice', 
					data: {
						noticeTitle: that.title,
						noticeContent: that.content,
						noticePeo: that.peo
					},
					method:'POST',
					header: {
						'Access-Control-Allow-Credentials':true,
						'Access-Control-Allow-Origin':'http://localhost:8080/#/',
						'Content-type':'application/x-www-form-urlencoded'
					},
					success(res) {
						if(res.data.stateCode==1){
							uni.showToast({
								title: res.data.info,
								icon: "success",
								duration: 2000
							})
							setInterval(function(){
								uni.navigateBack({
									
								})
							}, 2000)
						}else{
							uni.showToast({
								title: res.data.info,
								icon: "error",
								duration: 2000
							})
						}
					}
				})	
			}
		}
	}
	
	
	
</script>

<style>
text{
	margin-left: 15rpx;
}
input{
	width: 100%;
	height: 70rpx;
	line-height: 70rpx;
	padding: 15rpx;
	box-sizing: border-box;
	margin-top: 10rpx;
	margin-bottom: 10rpx;
	border: 1rpx solid #C0C0C0;
	border-radius: 10rpx;
}
textarea{
	width: 100%;
	height: 800rpx;
	padding: 15rpx;
	box-sizing: border-box;
	margin-top: 10rpx;
	margin-bottom: 10rpx;
	border: 1rpx solid #C0C0C0;
	border-radius: 10rpx;
}
button{
	
	width: 100%;
}
</style>
