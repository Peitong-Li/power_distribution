<template>
	<view style="width: 95%;margin: 0 auto;">
		<!-- 台区选择 -->
		<view class="box_1">
			<text class="text">已选台区</text>
			<view class="courtsSelect">
				<picker style="" @change="courtsSelect" :value="courtSelectIndex" :range="courtNameList">
					<view class="picker_class_view">{{courtNameList[courtSelectIndex]}}</view>
				</picker>
			</view>
		</view>
		<!-- 时间选择 -->
		<view class="box_1">
			<text class="text">已选时间</text>
			<view class="courtsSelect">
				<picker style="" @change="timeSelect" :value="timeSelectIndex" :range="courtTimeList">
					<view class="picker_class_view">{{courtTimeList[timeSelectIndex]}}</view>
				</picker>
			</view>

		</view>
		<!-- 基本信息 -->
		<view
			style="padding: 15rpx;padding-top: 0rpx ;background-color: #C0C0C0;border-radius: 10rpx;margin-top: 20rpx;">
			<!-- 标题 -->
			<view class="item" style="border-bottom: 1px solid #333333;">
				<text style="font-size: medium;font-weight: bold;">基本信息</text>
				<text style="font-size: medium;font-weight: bold;float: right;margin-right: 30rpx;">值</text>
			</view>
			<view v-for="(item,index) in infoList" class="item" v-bind:class=" index%2==0 ? itemClass_1 : itemClass_2 ">
				<text class="text_1">{{item.k_name}}</text>
				<text class="text_2">{{item.k_value}}</text>
			</view>
		</view>
		<view class="content">
			<view class="charts-box">
				<qiun-data-charts type="line" :chartData="chartsDataLine1" :echartsH5="true" :echartsApp="true" />
			</view>
			<view class="charts-box">
				<qiun-data-charts type="line" :opts="{extra:{line:{type:'curve'}}}"
					:eopts="{seriesTemplate:{smooth:true}}" :chartData="chartsDataLine1" :echartsH5="true"
					:echartsApp="true" />
			</view>
		</view>
	</view>

</template>

<script>
	import {config_url} from '../../default/get_url.js'
	
	export default {
		data() {
			return {
				chartsDataLine1: {
					"Line": {
						"categories": [],
						"series": [{
							"name": "预测线损",
							"data": []
						}, {
							"name": "真实线损",
							"data": []
						}, {
							"name": "误差线损",
							"data": []
						}]
					}
				},
				preLineloss: [],
				realLineloss: [],
				errorLineloss: [],
				baseInfoList: [],
				courtIdList: [-1],
				courtNameList: ["请选择台区"],
				courtTimeList: ["请选择时间"],
				infoList: [{
						k_name: "售电量/kwh",
						k_value: "无"
					},
					{
						k_name: "供电量/kwh",
						k_value: "无"
					},
					{
						k_name: "预测线损率/%",
						k_value: "无"
					},
					{
						k_name: "实际线损率/%",
						k_value: "无"
					},
					{
						k_name: "误差线损率/%",
						k_value: "无"
					},
					{
						k_name: "是否异常",
						k_value: "无"
					},
				],
				itemClass_1: "itemClass_1",
				itemClass_2: "itemClass_2",
				courtId: -1,
				courtSelectIndex: 0,
				timeSelectIndex: 0,
			}
		},
		methods: {
			timeSelect(e) {
				let that = this;
				var courtId = that.courtId;
				if (courtId == -1) {
					uni.showToast({
						icon: "error",
						title: "请先选择台区！"
					})
					return;
				}
				that.timeSelectIndex = e.target.value
				uni.showToast({
					title: that.courtTimeList[that.timeSelectIndex]
				})
				if (that.timeSelectIndex > 0) {
					var data = that.baseInfoList
					that.infoList[0].k_value = data[that.timeSelectIndex - 1].power_sale;
					that.infoList[1].k_value = data[that.timeSelectIndex - 1].power_apply;
					that.infoList[2].k_value = data[that.timeSelectIndex - 1].pre_line_loss;
					that.infoList[3].k_value = data[that.timeSelectIndex - 1].real_line_loss;
					that.infoList[4].k_value = data[that.timeSelectIndex - 1].error_line_loss;
					var a = ["否", "是"];
					if (data[that.timeSelectIndex - 1].state_res <= 2) {
						that.infoList[5].k_value = a[0];
					} else {
						that.infoList[5].k_value = a[1];
					}
					return;
				}
				that.infoList[0].k_value = "无";
				that.infoList[1].k_value = "无";
				that.infoList[2].k_value = "无";
				that.infoList[3].k_value = "无";
				that.infoList[4].k_value = "无";
				that.infoList[5].k_value = "无";
			},
			getChartData(type) {
				var that = this;
				if(type){
					var tempData = that.chartsDataLine1.Line;
					tempData.categories = ["请选择台区"];
				}else{
					var tempData = that.chartsDataLine1;
					var tempList = [].concat(that.courtTimeList);
					tempList.splice(0,1);
					tempData.categories = tempList;
				}
				tempData.series[0].data = that.preLineloss
				tempData.series[1].data = that.realLineloss
				tempData.series[2].data = that.errorLineloss
				that.chartsDataLine1 = tempData
			},
			courtsSelect(e) {
				
				let that = this;
				that.courtSelectIndex = e.target.value;
				uni.showToast({
					title: that.courtNameList[that.courtSelectIndex]
				})
				
				if (that.courtSelectIndex > 0) {
					that.timeSelectIndex = 0;
					that.courtTimeList = ["请选择时间"];
					that.preLineloss = [];
					that.realLineloss = [];
					that.errorLineloss = [];
					that.courtId = that.courtIdList[that.courtSelectIndex];
					var courtId = that.courtId;

					uni.request({
						url: config_url.baseurl + 'findBaseInfoByCourtId',
						data: {
							courtId: courtId
						},
						method: 'POST',
						header: {
							'Access-Control-Allow-Credentials': true,
							'Access-Control-Allow-Origin': 'http://localhost:8080/#/',
							'Content-type': 'application/x-www-form-urlencoded'
						},
						success(res) {
							that.baseInfoList = res.data.data;
							that.sortbaseInfoList()
							for (var i = 0; i < that.baseInfoList.length; i++) {
								that.courtTimeList.push(that.baseInfoList[i].time);
								that.preLineloss.push(that.baseInfoList[i].pre_line_loss);
								that.realLineloss.push(that.baseInfoList[i].real_line_loss);
								that.errorLineloss.push(that.baseInfoList[i].error_line_loss);
							}
							setTimeout(() => {
								that.getChartData(false);
							}, 1000);
						}
					})
					return;
				}
			},
			sortbaseInfoList(){
				var that = this;
				that.baseInfoList.sort(function(a,b){
					var tempA = a.time.split("-")
					var tempB = b.time.split("-")
					a = tempA[0]+tempA[1]+tempA[2]
					b = tempB[0]+tempB[1]+tempB[2]
					return a - b;
				});
			},
		},
		onReady() {
			setTimeout(() => {
				this.getChartData(true);
			}, 1000);
		},
		beforeCreate() {	
			uni.showToast({
				icon: 'none',
				title: "请先选择台区再选择时间！",
				duration: 2000
			});
			let that = this;
			uni.request({
				url: config_url.baseurl + 'getBaseInfoCourtIdAndCourName',
				method: 'POST', //请求方式  或GET，必须为大写
				header: {
					'Access-Control-Allow-Credentials': true,
					'Access-Control-Allow-Origin': 'http://localhost:8080/#/',
					'Content-type': 'application/x-www-form-urlencoded'
				},
				success(res) {
					that.baseInfoList = res.data.data;
					for (var i = 0; i < that.baseInfoList.length; i++) {
						that.courtNameList.push(that.baseInfoList[i].courtName);
						that.courtIdList.push(that.baseInfoList[i].courtId);
					}
				}
			});
		},
	}
</script>

<style>
	.box_1 {
		width: 100%;
		height: 60rpx;
		line-height: 60rpx;
		background-color: #C0C0C0;
		border-radius: 10rpx;
		padding-left: 15rpx;
		padding-right: 10rpx;
		box-sizing: border-box;
		margin-top: 20rpx;
	}

	.picker_class_view {
		width: 100%;
		text-align: center;
		background-color: #FFFFFF;
		border-radius: 10rpx;
	}

	picker {
		width: 100%,
	}

	.courtsSelect {
		width: 35%;
		height: 50rpx;
		margin-bottom: 20rpx;
		border-radius: 10rpx;
		float: left;
		margin-top: 6rpx;
		font-size: small;
		margin-left: 5%;
		box-sizing: border-box;
	}

	.text {
		font-size: medium;
		font-weight: bold;
		float: left;
	}

	.box_1>view {
		width: 35%;
		height: 45rpx;
		margin-top: 8rpx;
		background-color: #F8F8F8;
		border-radius: 10rpx;
		line-height: 45rpx;
		float: left;
	}



	.box_2 {
		background-color: #C0C0C0;
		border-radius: 10rpx;
		padding-left: 15rpx;
		padding-right: 10rpx;
		box-sizing: border-box;
		/* border-bottom: 1rpx solid #333333; */
		width: 100%;
		height: 60rpx;
		margin-top: 20rpx;
		line-height: 60rpx;

	}

	.areaNameSelect {
		width: 35%;
		height: 50rpx;
		margin-bottom: 20rpx;
		border-radius: 10rpx;
		float: left;
		margin-top: 6rpx;
		font-size: small;
		margin-left: 25rpx;
		box-sizing: border-box;
	}

	.item {
		border-bottom: 1px solid #333333;
		height: 60rpx;
		line-height: 60rpx;
	}

	.itemClass_1 {
		background-color: #F1F1F1;
	}

	.itemClass_2 {
		background-color: #F8F8F8;
	}

	.text_1 {
		font-size: medium;
	}

	.text_2 {
		font-size: medium;
		float: right;
		margin-right: 30rpx;
	}

	.content {
		display: flex;
		flex-direction: column;
		flex: 1;
	}

	.charts-box {
		width: 100%;
		height: 300px;
	}
</style>
