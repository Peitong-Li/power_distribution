<template>
	<view style="background-color: #F1F1F1;position: fixed;width: 100%;height: 100%;">
		
		<view class="pwd">
			<text>新密码：</text>
			<input type="password"  value=""  placeholder="请输入密码" v-model="newPwd"/>
		</view>
		<view class="pwd">
			<text>新密码：</text>
			<input type="password" value="" placeholder="请确认密码" v-model="newpwd_2"/>
		</view>
		<button @click="updatePwd" style="width: 90%;margin-top: 35rpx;">保存</button>
		
		
	</view>
</template>

<script>
	import {config_url} from '../../default/get_url.js'
	export default {
		data() {
			return {
				userName:"",
				newPwd:"",
				newpwd_2:""
			}
		},
		methods: {
			updatePwd:function(){
				let that = this;
				var pwdReg = /^\d{6}$/;
				if(this.newPwd==""){
					uni.showModal({
						title: '提示',
						showCancel: false,
						content: '请输入密码'
					})
					return ;
				}
				if(!this.newPwd.trim().match(pwdReg)){
					uni.showModal({
						title: '提示',
						showCancel: false,
						content: '密码格式不正确'
					})
					return ;
				}
				if(this.newPwd!=this.newpwd_2){
					uni.showModal({
						title: '提示',
						showCancel: false,
						content: '密码不一致'
					})
					return ;
				}
				uni.getStorage({
					key:"userName",
					success(res){
						that.userName = res.data
					}
				})
				uni.showLoading({
					title:"正在保存"
				})
				// uni.hideLoading()
				uni.request({
					url: config_url.baseurl + 'updateUserPwd', 
					data: {//参数
						userName: that.userName,
						newPwd: that.newPwd
					},
					// dataType:'json',
					method:'POST',//请求方式  或GET，必须为大写
					header: {
						'Access-Control-Allow-Credentials':true,
						'Access-Control-Allow-Origin':'http://localhost:8080/#/',
						'Content-type':'application/x-www-form-urlencoded'
					},
					success(res){
						if(res.data.updateMsg == 1){
							uni.hideLoading();
							uni.showModal({
								content:"修改成功"
							})
						}else{
							uni.showModal({
								content:"修改失败"
							})
						}
						
					}
				})
				
				
			}
		}
	}
</script>

<style>
.pwd{
	width: 90%;
	margin: 0 auto;
	margin-top: 25rpx;
}
text{
	display: block;
	font-size: large;
	margin-bottom: 10rpx;
}
input{
	border-bottom: 1rpx solid #555555;
}
input:hover{
	border-bottom: 1rpx solid #007AFF;
}
</style>
