<template>
	<view style="padding-top: 20rpx;">
		
		<view class="box_1">
			<text class="text" >台区名称</text>
			<select class="courtsSelect" @change="courtsSelect" ref="courtsId" >
				<option  value="" data-id="123">---------</option>
				<option  v-for="(item, index) in courtsList" 
						:data-id="item.courtsId" :data-name="item.courtsName"   :value="item.courtsId">{{item.courtsName}}
				</option>
			</select>
		</view>
		
		<view class="itemCard"   v-for="(item, index) in checkList" v-if="courtsId==''|| item.courtsId ==courtsId ">
			<view style="margin-top: 0rpx;height: 50rpx;line-height: 50rpx;border-bottom: 1rpx solid #C0C0C0;">
				<view class="cardText">台区名称：</view><view class="cardText_2">{{item.courtsName}}</view>
				<view class="cardTime">{{new Date(item.checkTime).toLocaleDateString()}}</view>
			</view>
			<view style="margin-top: 0rpx;height: 50rpx;line-height: 50rpx;background-color: ;">
				<view class="cardText">巡检项目：</view><view class="cardText_2">{{item.checkName}}</view>
				<view class="cardBtn" :data-checkId="item.checkId" @click="toDetail">详情</view>
			</view>
		</view>	
	</view>
</template>

<script>
	import {config_url} from '../../default/get_url.js'
	export default {
		data() {
			return {
				checkList:[],
				courtsList:[],
				courtsId:"",
				role:""
			}
		},
		methods: {
			toDetail(e){
				var checkId = e.target.dataset.checkid
				uni.navigateTo({
					url:'../checkDetail/checkDetail?checkId=' + checkId
				})
			},
			courtsSelect(e){
				let that = this;
				that.courtsId = that.$refs.courtsId.value
			}
		},
		onNavigationBarButtonTap(e){
			let that = this;
			if(that.role == '1' || that.role == '2'){
				uni.navigateTo({
					url:"../checkAdd/checkAdd"
				})
			}else{
				uni.showModal({
					title:"提示",
					content:"非巡检人员不能添加"
				})
			}
			
		},
		onShow() {
			let that = this;
			uni.request({
				url: config_url.baseurl + 'findAllCheck', 
				data: {//参数
				
				},
				method:'POST',//请求方式  或GET，必须为大写
				header: {
					'Access-Control-Allow-Credentials':true,
					'Access-Control-Allow-Origin':'http://localhost:8080/#/',
					'Content-type':'application/x-www-form-urlencoded'
				},
				success(res) {
					that.checkList = res.data
				}
			})
			uni.request({
				url: config_url.baseurl + 'findAllCourts', 
				data: {//参数
				
				},
				method:'POST',//请求方式  或GET，必须为大写
				header: {
					'Access-Control-Allow-Credentials':true,
					'Access-Control-Allow-Origin':'http://localhost:8080/#/',
					'Content-type':'application/x-www-form-urlencoded'
				},
				success(res) {
					that.courtsList = res.data;
				}
			})
			uni.getStorage({
				key: 'role',
				success (res) {
					that.role = res.data
				},
				fail(res) {
				}
			})
		}
		
		
	}
</script>

<style>
.box_1{
	width: 95%;height: 60rpx;
	margin: 0 auto;
	line-height: 60rpx;
	background-color: #C0C0C0;
	border-radius: 10rpx;
	margin-top: 0rpx;
	margin-bottom: 20rpx;
	/* display: flex;
	justify-content: space-between;
	flex-wrap: nowrap; */
}
.courtsSelect{
	width: 35%;
	height: 50rpx;
	margin-bottom: 20rpx;
	border-radius: 10rpx;
	float: left;
	margin-top: 6rpx;
	font-size: small;
	margin-left: 25rpx;box-sizing: border-box; 
}
.text{
	font-size: medium;
	font-weight: bold;
	float: left;
	margin-left: 15rpx;
}
.box_1>view{
	width: 34%;height: 45rpx;margin-top: 8rpx;background-color: #F8F8F8;border-radius: 10rpx;
	line-height: 45rpx;float: left;
}


.itemCard{
	width: 95%;height: 120rpx;background-color: #F1F1F1;
	margin: 0rpx auto;
	margin-bottom: 20rpx;
	border-radius: 15rpx;
	padding: 10rpx;
	box-sizing: border-box;
}
.cardText{
	font-size: 30rpx;
	float: left;
	font-weight: 600;
}
.cardText_2{
	font-size: 30rpx;
	float: left;
}
.cardTime{
	font-size: 30rpx;
	float: right;
}
.cardBtn{
	width: 80rpx;
	height: 40rpx;
	line-height: 40rpx;
	margin-top: 6rpx;
	text-align: center;
	font-size: 30rpx;
	font-weight: bold;
	float: right;
	background-color: #4CD964;
	border-radius: 10rpx;
}


.addBtn{
	width: 95%;
	position:fixed;
	bottom: 0rpx;
	//居中
	left: 50%;
	transform: translate(-50%, -50%);   
}

</style>
