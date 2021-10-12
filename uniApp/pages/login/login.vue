<template>
	<view class="body">
		<form @submit="Login" @reset="">
			
			<view class="user">
				<image class="Icon" src="../../static/user.png"></image>
				<input id="userName" name="userName" type="text" placeholder="用户名"  v-model="userName">
			</view>
			
			<view class="pwd">
				<image class="Icon" src="../../static/pwd.png"></image>
				<input id="userPwd"  name="userPwd" type="password" placeholder="密码" v-model="userPwd">
			</view>
			
			<button form-type="submit" class="btn_submit" :disabled="disabled" :loading='loading'
			 style="height: 80rpx;">{{loginText}}</button>
			 
		</form>
		
		<view class="text">
			<text class="forget"  >忘记密码</text>
			<text class="regist" @click="toRegist">注册</text>
		</view>
		<!-- <button id="submitBtn" @click="Login" type="primary" style="width: 80%;height: 80rpx;">登录</button> -->
	</view>
			
		
</template>

<script>
	import {config_url} from '../../default/get_url.js'
	export default {
		data() {
			return {
				userName:"",
				userPwd:"",
				disabled:false,
				loading:false,
				loginText:"登录"
				
			}
		},
		created() {
			// uni.setStorage({
			// 	key:"userName",
			// 	data:"yjww"
			// })
		},
		methods: {
		
			Login:function(e){
				let that = this;
				let Name = e.detail.value.userName;
				let Pwd = e.detail.value.userPwd;
				let flag = this.checkName(Name) && this.checkPwd(Pwd);
				if(flag){
					that.setLoginData1();
					setTimeout(function () {
						uni.request({
							url: config_url.baseurl + 'login_2',
							data: {//参数
								userName: e.detail.value.userName,
								userPwd: e.detail.value.userPwd
							},
							// dataType:'json',
							method:'POST',//请求方式  或GET，必须为大写
							header: {
								'Content-type':'application/x-www-form-urlencoded'
							},
							success(res) {
								console.log(res.data);
								var role = res.data.role
								if(res.data.msg=="1"){
									uni.showModal({
										title: '提示',
										showCancel: false,
										content: '登录成功' ,
										success(result) {
											if(result.confirm){
												console.log('confirm')
											}
										}
									});
									uni.setStorage({    //用户名
										key:"userName",
										data:Name
									})
									uni.setStorage({  //角色
										key:"role",
										data:role
									})
									that.setLoginData2();
									uni.switchTab({
										url:"../index/index"
									})
									
								}else if(res.data.msg=="2"){
									uni.showModal({
										title: '提示',
										showCancel: false,
										content: '账号异常，请联系管理员'          
									});
									that.setLoginData2();
									
								}
								
								
								else{
									uni.showModal({
										title: '提示',
										showCancel: false,
										content: '用户名密码错误'          
									});
									that.setLoginData2();
								}
							},
							fail(res) {
								console.log(res);
								uni.showModal({
									title: '提示',
									showCancel: false,
									content: '登录超时'          
								});
								that.setLoginData2();
							}
							
						})

					}, 1000); //延迟时间 这里是1秒
					
					
				}
			},
			checkName:function(Name){
				if(Name.trim()==""){
					uni.showModal({
						title: '提示',
						showCancel: false,
						content: '请输入用户名'
					})
					return false;
				}else{
					return true;
				}
			},
			checkPwd:function(Pwd){
				if(Pwd.trim()==""){
					uni.showModal({
						title: '提示',
						showCancel: false,
						content: '请输入密码'
					})
					return false;
				}else{
					return true;
				}
			},
			setLoginData1:function(){
				this.disabled = true;
				this.loading = true;
				this.loginText = "登录中"
			},
			setLoginData2:function(){
				this.disabled = false;
				this.loading = false;
				this.loginText = "登录"
			},
			toRegist:function(){
				uni.navigateTo({
					url:"../regist/regist"
				})
			}
		},
		

		
		
	}
</script>

<style>
.user,.pwd{
	height: 80rpx;
	border-bottom:  1px solid #DBDBDB;
	margin-bottom: 30rpx;
}
.user:hover,.pwd:hover{
	border-bottom:  1px solid #00AAFF;
}
#userName,#userPwd{
	float: left;
	height: 80rpx;
}

.Icon{
	margin: 10rpx;
	width: 60rpx;
	height: 60rpx;
	float: left;
	margin-right: 20rpx;
}



.body{
	padding: 65rpx;

}
.text{
	display: flex;
	justify-content: space-between;
	margin-top: 20rpx;
}
.btn_submit{
	background-color: #00aaff;
	border-radius: 50rpx;
}

</style>
