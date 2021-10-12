<template>
	<view class="body">
		<form @submit="Regist" @reset="">
			
			<view class="user">
				<image class="Icon" src="../../static/user.png"></image>
				<input class="userName" name="userName" type="text" placeholder="请输入用户名"  v-model="userName">
			</view>
			<view class="pwd">
				<image class="Icon" src="../../static/pwd.png"></image>
				<input class="userPwd"  name="userPwd" type="password" placeholder="请输入密码" v-model="userPwd">
			</view>
			<view class="pwd">
				<image class="Icon" src="../../static/pwd.png" mode=""></image>
				<input class="userPwd2"  name="userPwd2" type="password" placeholder="请再次输入密码" v-model="userPwd2">
			</view>
			<view class="tele">
				<image class="Icon" src="../../static/pwd.png" mode=""></image>
				<input class="Phone"  name="Phone" type="number" maxlength="11" placeholder="请输入手机号" v-model="Phone">
			</view>
			
			
			
			
			<button class="btn_submit" form-type="submit" :disabled="disabled" :loading='loading' style="height: 80rpx;">{{registText}}</button>
			
		</form>
		
		
	</view>
			
		
</template>

<script>
	import {config_url} from '../../default/get_url.js'
	export default {
		data() {
			return {
				userName:"",
				userPwd:"",
				userPwd2:"",
				Phone:"",
				disabled:false,
				loading:false,
				registText:"注册"
			}
		},
		methods: {
		
			Regist:function(e){
				
				let that = this;
				let Name = e.detail.value.userName;
				let Pwd = e.detail.value.userPwd;
				let Pwd2 = e.detail.value.userPwd2;
				let Phone = e.detail.value.Phone;
			
				let flag = this.checkName(Name) && this.checkPwd(Pwd,Pwd2) && this.checkPhone(Phone);
				if(flag){
					console.log("验证成功")
					that.setRegistData1();
					setTimeout(function () {
						console.log(e.detail.value.userName)
						uni.request({
							url: config_url.baseurl + 'regist', 
							// url: 'http://1.116.84.92:8080/regist', 
							data: {//参数
								userName: e.detail.value.userName,
								userPwd: e.detail.value.userPwd,
								phone: e.detail.value.Phone
							},
							// dataType:'json',
							method:'POST',
							header: {
								'Access-Control-Allow-Credentials':true,
								// 'Access-Control-Allow-Origin':'http://localhost:8080/#/',
								'Content-type':'application/x-www-form-urlencoded'
							},
							success(res) {
								console.log(res)
								if(res.data.registMsg=="1"){
									uni.showModal({
										title: '提示',
										showCancel: false,
										content: '注册成功'          
									});
									uni.navigateTo({
										url:"../login/login"
									})
								}else if(res.data.registMsg=="0"){
									uni.showModal({
										title: '提示',
										showCancel: false,
										content: '注册失败'          
									});
									that.setLoginData2();
								}else if(res.data.registMsg=="2"){
									uni.showModal({
										title: '提示',
										showCancel: false,
										content: '用户名重复'          
									});
									that.setRegistData2();
								}else if(res.data.registMsg=="3"){
									uni.showModal({
										title: '提示',
										showCancel: false,
										content: '电话已注册或不可用'          
									});
									that.setRegistData2();
								}else if(res.data.registMsg=="4"){
									uni.showModal({
										title: '提示',
										showCancel: false,
										content: '用户名及电话已注册或不可用'          
									});
									that.setRegistData2();
								}
							},
							fail(res) {
								console.log(res);
								uni.showModal({
									title: '提示',
									showCancel: false,
									content: '网络超时'          
								});
								that.setRegistData2();
							}
							
						})

					}, 1000); //延迟时间 这里是1秒
					
					
				}
			},
			checkName:function(Name){
				var nameReg = /^[\u4E00-\u9FA5A-Za-z0-9_]{3,6}$/;
				if(Name.trim()==""){   //判断用户是否输入
					uni.showModal({
						title: '提示',
						showCancel: false,
						content: '请输入用户名'
					})
					return false;
				}else if(!Name.trim().match(nameReg)){//判断用户名是否合法
					uni.showModal({
						title: '提示',
						showCancel: false,
						content: '用户名不合法'
					})
					return false;
				}else{  
					
					return true;
				}
			},
			checkPwd:function(Pwd,Pwd2){
				var pwdReg = /^\d{6}$/;
				if(Pwd==""){
					uni.showModal({
						title: '提示',
						showCancel: false,
						content: '请输入密码'
					})
					return false;
				}else if(!Pwd.trim().match(pwdReg)){
					uni.showModal({
						title: '提示',
						showCancel: false,
						content: '密码格式不正确'
					})
					return false;
				}else if(Pwd!=Pwd2){
					uni.showModal({
						title: '提示',
						showCancel: false,
						content: '密码不一致'
					})
					return false;
				}else{
					return true;
				}
			},
			checkPhone:function(Phone){
				var phoneReg = /^1[3-9]\d{9}$/;
				if(Phone==""){
					uni.showModal({
						title: '提示',
						showCancel: false,
						content: '请输入手机号'
					})
					return false;
				}else if(!Phone.match(phoneReg)){
					uni.showModal({
						title: '提示',
						showCancel: false,
						content: '手机格式不正确'
					})
					return false;
				}else{
					
					return true;
				}
			},
			setRegistData1:function(){
				this.disabled = true;
				this.loading = true;
				this.registText = "注册中"
			},
			setRegistData2:function(){
				this.disabled = false;
				this.loading = false;
				this.registText = "注册"
			},

		},		
	}
</script>

<style>
.user,.pwd,.tele{
	height: 80rpx;
	border-bottom:  1px solid #DBDBDB;
	margin-bottom: 30rpx;
}
.user:hover,.pwd:hover,.tele:hover{
	border-bottom:  1px solid #00AAFF;
}
.Icon{
	margin: 10rpx;
	width: 60rpx;
	height: 60rpx;
	float: left;
	margin-right: 20rpx;
}

.userName,.userPwd,.userPwd2,.Phone{
	float: left;
	height: 80rpx;
}

.body{
	padding: 65rpx ;

}
.btn_submit{
	background-color: #00aaff;
	border-radius: 50rpx;
}

</style>
