<template>
	<view class="center">
		<view class="center_top">
			<view class="mask"></view>
		</view>
		<view class="center_box_bg">
			<view class="profily">
				<view class="base">
				</view>
				<view class="order_status">
					<view class="status" v-for="item in status1" @click="toFunction(item)">
						<image class="icon" :src="item.url" mode="aspectFill"></image>
						<text>{{item.name}}</text>
					</view>
				</view>
				<view class="order_status">
					<view class="status" v-for="item in status2" @click="toFunction(item)">
						<image class="icon" :src="item.url" mode="aspectFill"></image>
						<text>{{item.name}}</text>
					</view>
				</view>
				<view class="order_status">
					<view class="status" v-for="item in status3" @click="toFunction(item)" v-show="role == '2'">
						<image class="icon" :src="item.url" mode="aspectFill"></image>
						<text>{{item.name}}</text>
					</view>
				</view>
			</view>
			<view class="baiban">

			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				role: 0,
				status1: [{
						key: "../uploadPic/uploadPic",
						name: '台区创建',
						url: '../../static/functionLogo/upload.png'
					},
					{
						key: "../viewCourts/viewCourts",
						name: '供电侧查看',
						url: '../../static/functionLogo/power_apply.png'
					},
					{
						key: "../deviceMan/deviceMan",
						name: '台区设备管理',
						url: '../../static/functionLogo/deviceManage.png'
					}
				],
				status2: [{
						key: "../checkList/checkList",
						name: '故障巡检',
						url: '../../static/functionLogo/check.png'
					},
					{
						key: "../deviceStatistics/deviceStatistics",
						name: '设备统计',
						url: '../../static/functionLogo/static.png'
					},
					{
						key: "../BaseInfo/index",
						name: '基本信息',
						url: '../../static/functionLogo/baseInfo.png'
					}
				],
				status3: [{
						key: "../BaseInfo/XianSun",
						name: '线损分析',
						url: '../../static/functionLogo/xiansun.png'
					},
					{
						key: "../userManagement/userManagement",
						name: '用户管理',
						url: '../../static/functionLogo/userManage.png'
					},
					{
						key: "../noticeList/noticeList",
						name: '通知公告',
						url: '../../static/functionLogo/notice.png'
					}
				],
			};
		},
		methods:{
			toFunction(item){
				let that = this;
				if(that.role=== ""){
					uni.showModal({
						title:"提示",
						content:"请先登录"
					})
				}else{
					uni.navigateTo({
						url: item.key
					})
				}
			}
		},
		onShow() {
			let that = this;
			uni.getStorage({
				key: 'role',
				success (res) {
					that.role = res.data
				},
				fail(res) {
					uni.showToast({
						title: "请登录",
						icon: "error"
					})
				}
			})
		}
	}
</script>

<style lang="scss">
	page {
		height: 100%;
	}

	.profily,
	.profily_header {
		border-radius: 8px;
	}

	.center {
		height: 100%;

		&_top {
			height: 18%;
			background: url('../../static/functionLogo/background.png') no-repeat 0% 50%;
			background-size: cover;

			// background: #E6E6E6;
			.mask {
				background: rgba(0, 0, 0, .4);
				height: 100%;
			}
		}

		&_box_bg {
			background: #F9F9F9;
			position: relative;

			.profily {
				position: absolute;
				width: 90%;
				// border:1px solid #F7F7F7;
				margin: 0 auto;
				top: -100upx;
				left: 5%;
				background: #FEFEFE;
				padding: 35upx;
				box-sizing: border-box;
				box-shadow: 0px 2px 5px #EDEDED;
			}
		}
	}

	.base {
		display: flex;
		align-items: center;
		border-bottom: 2px solid #F6F6F6;
		padding-bottom: 3upx;
		position: relative;
		.profily_header {
			height: 120upx;
			width: 120upx;
			background-image: url('../../static/functionLogo/background.png');
			background-size: 100%;
		}

		text {
			margin-left: 20px;
			font-size: 30upx;
		}
		
		image{
			position: absolute;
			height: 40upx;
			width: 40upx;
			right: 0px;
			top:0px;
		}
	}

	.order_status {
		display: flex;
		justify-content: space-between;
		margin-top: 20upx;

		.status {
			width: 300upx;
			height: 150upx;
			font-size: 30upx;
			text-align: center;
			letter-spacing: .5px;
			display: flex;
			flex-direction: column;
			.icon {
				width: 80upx;
				height: 80upx;
				margin: 0 auto;
				margin-top: 10%;
				margin-bottom: 5px;
				
			}
		}
	}

	.baiban {
		background: #FEFEFE;
		height: 300upx;
	}

	.center_menu {
		width: 100%;
		display: inline-block;

		.menu_item {
			font-size: 28upx;
			letter-spacing: 1px;
			padding: 14px 5%;
			background: #FEFEFE;
			overflow: hidden;
			box-sizing: border-box;
			display: flex;
			align-items: center;
			position: relative;
			border-bottom: 1px solid #EFEFEF;

			&:hover {
				background: #F6F6F6 !important;
			}

			&::after {
				content: '';
				width: 30upx;
				height: 30upx;
				position: absolute;
				right: 5%;
				background: url('../../static/functionLogo/background.png') no-repeat;
				background-size: 100%;
			}

			text:nth-of-type(1) {
				margin-left: 10px;
			}

			image {
				width: 40upx;
				height: 40upx;
			}

			&:nth-of-type(4) {
				margin-top: 10px;
			}
		}
	}
</style>
