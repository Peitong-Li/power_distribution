<template>
	<view  style="width: 95%;margin: 0 auto;">
		<!-- 台区选择 -->
		<view class="box_1">
			<text class="text" >台区名称</text>
			<select class="courtsSelect" @change="courtsSelect" ref="courtsId" >
				<option  value="0" data-id="123">全部台区</option>
				<option  v-for="(item, index) in courtsList" 
						:data-id="item.courtsId" :data-name="item.courtsName"   :value="item.courtsId">{{item.courtsName}}
				</option>
						
			</select>
		</view>
		
		<!-- 区域选择 -->
<!-- 		<view class="box_2">
			<text class="text">区域选择</text>
			<select class="areaNameSelect" @click="areaNameSelect" ref="areaName">
				<option  value="">全部区域</option>
				<option  value="中压侧">中压侧</option>
				<option  value="配变侧">配变侧</option>
				<option  value="低压侧">低压侧</option>
				<option  value="线路侧">线路侧</option>
				<option  value="用户侧">用户侧</option>
			</select>
		</view> -->
		<view style="padding: 15rpx;padding-top: 0rpx ;background-color: #C0C0C0;border-radius: 10rpx;margin-top: 20rpx;">
			<!-- 标题 -->
			<view class="item" style="border-bottom: 1px solid #333333;">
				<text style="font-size: medium;font-weight: bold;">统计项</text>
				<text style="font-size: medium;font-weight: bold;float: right;margin-right: 30rpx;width: 10%;">数量</text>
			</view> 
			<view v-for="(item,index) in deviceList" class="item" v-bind:class=" index%2==0 ? itemClass_1 : itemClass_2 ">
				<text class="text_1">{{item.deviceName}}</text>
				<text class="text_2">{{item.deviceCount}}</text>
			</view> 	
		</view>	
	</view>
</template>

<script>
	import {config_url} from '../../default/get_url.js'
	export default {
		data() {
			return {
				courtsList:[],
				deviceList:[
					{deviceName:"智能变压器",deviceCount:0},
					{deviceName:"智能环境传感器",deviceCount:0},
					{deviceName:"台区总表",deviceCount:0},
					{deviceName:"熔断器",deviceCount:0},
					{deviceName:"智能开关",deviceCount:0},
					{deviceName:"单相表",deviceCount:0},
					{deviceName:"LTU开关",deviceCount:0},
					{deviceName:"换相开关",deviceCount:0},
					{deviceName:"电动汽车充电设施",deviceCount:0},
					{deviceName:"光伏用户",deviceCount:0},
					{deviceName:"无偿补偿装置",deviceCount:0},
					{deviceName:"电缆感知设备",deviceCount:0},
					{deviceName:"三相表",deviceCount:0},
					{deviceName:"智能终端",deviceCount:0}
				],
				itemClass_1:"itemClass_1",
				itemClass_2:"itemClass_2"
			}
		},
		methods: {
			courtsSelect(e){
				let that = this;
				var courtsId = this.$refs.courtsId.value
				uni.request({
					url: config_url.baseurl + 'countDeviceByCourtsId', 
					data: {//参数
						courtsId:courtsId
					},
					// dataType:'json',
					method:'POST',//请求方式  或GET，必须为大写
					header: {
						'Access-Control-Allow-Credentials':true,
						'Access-Control-Allow-Origin':'http://localhost:8080/#/',
						'Content-type':'application/x-www-form-urlencoded'
					},
					success(res) {
						that.deviceList[0].deviceCount = res.data[0];
						that.deviceList[1].deviceCount = res.data[1];
						that.deviceList[2].deviceCount = res.data[2];
						that.deviceList[3].deviceCount = res.data[3];
						that.deviceList[4].deviceCount = res.data[4];
						that.deviceList[5].deviceCount = res.data[5];
						that.deviceList[6].deviceCount = res.data[6];
						that.deviceList[7].deviceCount = res.data[7];
						that.deviceList[8].deviceCount = res.data[8];
						that.deviceList[9].deviceCount = res.data[9];
						that.deviceList[10].deviceCount = res.data[10];
						that.deviceList[11].deviceCount = res.data[11];
						that.deviceList[12].deviceCount = res.data[12];
						that.deviceList[13].deviceCount = res.data[13];
					}
				})
				
				
				
			}
			
		},
		beforeCreate() {
			let that = this;
			uni.request({
				url: config_url.baseurl + 'findAllCourts', 
				data: {//参数
				
				},
				// dataType:'json',
				method:'POST',//请求方式  或GET，必须为大写
				header: {
					'Access-Control-Allow-Credentials':true,
					'Access-Control-Allow-Origin':'http://localhost:8080/#/',
					'Content-type':'application/x-www-form-urlencoded'
				},
				success(res) {
					that.courtsList = res.data;
				}
			});
			uni.request({
				url: config_url.baseurl + 'countDeviceByCourtsId', 
				data: {//参数
					courtsId:0
				},
				// dataType:'json',
				method:'POST',//请求方式  或GET，必须为大写
				header: {
					'Access-Control-Allow-Credentials':true,
					'Access-Control-Allow-Origin':'http://localhost:8080/#/',
					'Content-type':'application/x-www-form-urlencoded'
				},
				success(res) {
					that.deviceList[0].deviceCount = res.data[0];
					that.deviceList[1].deviceCount = res.data[1];
					that.deviceList[2].deviceCount = res.data[2];
					that.deviceList[3].deviceCount = res.data[3];
					that.deviceList[4].deviceCount = res.data[4];
					that.deviceList[5].deviceCount = res.data[5];
					that.deviceList[6].deviceCount = res.data[6];
					that.deviceList[7].deviceCount = res.data[7];
					that.deviceList[8].deviceCount = res.data[8];
					that.deviceList[9].deviceCount = res.data[9];
					that.deviceList[10].deviceCount = res.data[10];
					that.deviceList[11].deviceCount = res.data[11];
					that.deviceList[12].deviceCount = res.data[12];
					that.deviceList[13].deviceCount = res.data[13];
				}
			})
			
			
		},
	}
</script>

<style>
.box_1{
	width: 100%;height: 60rpx;line-height: 60rpx;
	background-color: #C0C0C0;
	border-radius: 10rpx;
	padding-left: 15rpx;
	padding-right: 10rpx;
	box-sizing: border-box;
	margin-top: 20rpx;
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
}
.box_1>view{
	width: 34%;height: 45rpx;margin-top: 8rpx;background-color: #F8F8F8;border-radius: 10rpx;
	line-height: 45rpx;float: left;
}



.box_2{
	background-color: #C0C0C0;
	border-radius: 10rpx;
	padding-left: 15rpx;
	padding-right: 10rpx;
	box-sizing: border-box;
	/* border-bottom: 1rpx solid #333333; */
	width: 100%;height: 60rpx;margin-top: 20rpx;
	line-height: 60rpx;
	
}

.areaNameSelect{
	width: 35%;
	height: 50rpx;
	margin-bottom: 20rpx;
	border-radius: 10rpx;
	float: left;
	margin-top: 6rpx;
	font-size: small;
	margin-left: 25rpx;box-sizing: border-box; 
}
.item{
	border-bottom: 1px solid #333333;
	height: 60rpx;
	line-height: 60rpx;
}
.itemClass_1{
	background-color: #F1F1F1;
}
.itemClass_2{
	background-color: #F8F8F8;
}
.text_1{
	font-size: medium;
}
.text_2{
	font-size: medium;float: right;margin-right: 30rpx;width: 10%;
}

</style>
