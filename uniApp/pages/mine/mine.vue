<template>
	<view style="background-color: #F1F1F1;position: fixed;width: 100%;height: 100%;">
		
		<view class="user_card">
			<image class="userImage" src="../../static/logo.png"></image>
			<view class="userText" v-if="userName == '' ">
				<text @click="toLogin">登录</text>
				<text @click="toRegist" style="margin-left: 30rpx;">注册</text>
			</view>
			
			<view class="userText" v-else>
				你好，<text>{{userName}}</text>
			</view>
		</view>
		
		<view style="margin-top: 20rpx;">
			<view class="item" @click="todeviceStatistics">
				<image class="itemIcon" src="../../static/mine/list_logo.png" mode=""></image>
				<view class="itemText">
					设备统计
				</view>
				<image class="rightArrow" src="../../static/mine/right_arrow.png"></image>
			</view>
			<view class="item"  @click="tonoticeList">
				<image class="itemIcon" src="../../static/mine/list_logo.png" mode=""></image>
				<view class="itemText">
					通知公告
				</view>
				<image class="rightArrow" src="../../static/mine/right_arrow.png"></image>
			</view>
			<view class="item" @click="toXiansun">
				<image class="itemIcon" src="../../static/mine/list_logo.png" mode=""></image>
				<view class="itemText">
					线损分析
				</view>
				<image class="rightArrow" src="../../static/mine/right_arrow.png"></image>
			</view>
			<view class="item" @click="toIP">
				<image class="itemIcon" src="../../static/mine/list_logo.png" mode=""></image>
				<view class="itemText">
					配置服务器IP
				</view>
				<image class="rightArrow" src="../../static/mine/right_arrow.png"></image>
			</view>
		</view>

		<view style="margin-top: 20rpx;" @click="toSetting">
			<view class="item">
				<image class="itemIcon" src="../../static/mine/list_logo.png" mode=""></image>
				<view class="itemText">
					设置
				</view>
				<image class="rightArrow" src="../../static/mine/right_arrow.png"></image>
			</view>
		</view>
		<view class="t">
			
		</view>
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				userName:""
			}
		},
		methods: {
			
			toLogin:function(){
				uni.navigateTo({
					url:"../login/login"
				})
			},
			toRegist:function(){
				uni.navigateTo({
					url:"../regist/regist"
				})
			},
			todeviceStatistics(){
				uni.navigateTo({
					url: '../deviceStatistics/deviceStatistics'
				})
			},
			tonoticeList(){
				uni.navigateTo({
					url: '../noticeList/noticeList'
				})
			},
			toXiansun(){
				uni.navigateTo({
					url: '../BaseInfo/XianSun'
				})
			},
			toIP(){
				uni.navigateTo({
					url: 'configuration_IP'
				})
			},
			toSetting:function(){
				let that = this;
				if(that.userName == ''){
					//判断是否登录
					uni.showModal({
						title:"提示",
						content:"请先登录",
						showCancel:false
					})
				}else{
					//登录则跳转
					uni.navigateTo({
						url:"../setting/setting"
					})
				}
				
			},
			
		},
	
		onShow() {
			let that = this;
			uni.getStorage({
				key:"userName",
				success (res) {
					that.userName = res.data;
				},
				fail() {
					that.userName = "";
				}
			})
		},
	}
</script>

<style>
	
.user_card{
	background-color: #FFFFFF;
	height: 200rpx;
	line-height: 200rpx;
}
.userImage{
	width: 130rpx;
	height: 130rpx;
	border-radius: 200rpx;
	/* position: relative;
	top: 50%; 
	transform: translateY(-50%);
	margin-left: 40rpx;
	margin-right: 40rpx; */
	margin: 35rpx;
	margin-left: 40rpx;
	float: left;
}
.userText{
	float: left;
	margin-left: 10rpx;
	font-size: 40rpx;
	font-weight: 600;
	font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
}
.rightArrow{
	width: 30rpx;
	height: 30rpx;
	position: relative;
	top: 50%; /*偏移*/
	transform: translateY(-50%);
	margin-right: 40rpx;
	float: right;
}
.item{
	height: 120rpx;
	line-height: 120rpx;
	background-color: #FFFFFF;
	/* border-bottom:  1rpx solid #333333; */
}
.itemIcon{
	
	width: 50rpx;
	height: 50rpx;
	margin: 35rpx;
	margin-left: 45rpx;
	float: left;
}
.itemText{
	float: left;
	font-size: medium;
}

	
	#triangle-up{
	    width:0;
	    height:0;
	    border-left:50px solid transparent;
	    border-right:50px solid transparent;
	    border-bottom:100px solid red;
		background-color: #007AFF;
	}

</style>
