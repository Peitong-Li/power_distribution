<template>
	<view style="background-color: #F1F1F1;position: fixed;width: 100%;height: 100%;">
		
		<view class="item" style="margin-top: 20rpx;" @click="toUpdatePwd">
			<view class="itemText">
				修改密码
			</view>
			<image class="rightArrow" src="../../static/mine/right_arrow.png"></image>
		</view>
		<view class="item" style="margin-top: 20rpx;">
			<view class="itemText">
				关于
			</view>
			<image class="rightArrow" src="../../static/mine/right_arrow.png"></image>
		</view>
		<view class="item" style="margin-top: 20rpx;" @click="loginOut">
			<view style="text-align: center;">
				退出登录
			</view>
		</view>
		
		
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			toUpdatePwd(){
				uni.navigateTo({
					url:"../setting_updatePwd/setting_updatePwd"
				})
			},
			loginOut(){
				uni.showModal({
					title:"提示",
					content:"确定退出登录?",
					success(res) {
						console.log(res)
						if(res.confirm){
							uni.clearStorage()
							uni.navigateBack({})
							
						}
					}
				})
			}
		}
	}
</script>

<style>

.item{
	height: 110rpx;
	line-height: 110rpx;
	background-color: #FFFFFF;
	/* border-bottom:  1rpx solid #333333; */
}
.itemText{
	float: left;
	margin-left: 40rpx;
	font-size: medium;
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


</style>
