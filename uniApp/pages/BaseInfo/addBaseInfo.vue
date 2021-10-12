<template>
	<view style="width: 95%;margin: 0 auto;">
		<!-- 台区选择 -->
		<view class="box_2">
			<text class="text">选择台区</text>
			<picker class="picker_class" @change="courtsSelect" :value="courtIndex" :range="courtNameList">
				<view class="picker_view">{{courtNameList[courtIndex]}}</view>
			</picker>
		</view>
		
		<text style="" style="padding-top: 5%; font-size: 120%;">日期 : {{time}}</text>
		<view style="width: 50%;">
			<button style="border-radius: 10upx; margin-top: 1%;" @click="openCalendar">选择日期</button>
		</view>
		<view style="">
			<uni-calendar @confirm="confirmTime" v-model="time" ref="calendar" :insert="false" :lunar="true" 
				:start-date="'2020-1-1'" :end-date="end_date"></uni-calendar>
			
			<text style="padding-top: 2%;">台区容量/MVA :</text>
			<input type="text"  v-model="capacity"/>
			
			<text>台区供电半径/km :</text>
			<input type="text"  v-model="radius"/>
			
			<text style="padding-top: 2%;">变压负载率/% :</text>
			<input type="text"  v-model="load_rate"/>
			
			<text>售电量/kwh :</text>
			<input type="text"  v-model="power_sale"/>
			
			<text style="padding-top: 2%;">供电量/kwh :</text>
			<input type="text"  v-model="power_apply"/>
			
			<text>预测线损率/% :</text>
			<input type="text"  v-model="pre_line_loss"/>
			
			<text style="padding-top: 2%;">真实线损率/% :</text>
			<input type="text"  v-model="real_line_loss"/>
			
			<text style="padding-top: 2%;">负荷不平衡度/% :</text>
			<input type="text"  v-model="load_unbalance_rate"/>
			
			<text>供电可靠率/% :</text>
			<input type="text"  v-model="power_reliability"/>
			
			<text>电压合格率/% :</text>
			<input type="text"  v-model="voltage_pass_percent"/>
			
			<text>状态评估结果 :</text>
			<input type="text"  v-model="state_res"/>
		</view>
		<button type="primary" @click="addBaseInfo">发布</button>
		
		
	</view>
	
</template>

<script>
	import {config_url} from '../../default/get_url.js'
	export default {
		data() {
			return {
				end_date: "2021-10-9",
				capacity:75.00,
				radius: 30.00,
				load_rate:75.00,
				power_sale: 115,
				power_apply: 135,
				pre_line_loss:2.65,
				real_line_loss:2.45,
				time: "",
				load_unbalance_rate:5.35,
				power_reliability: 94.60,
				voltage_pass_percent: 95.94,
				state_res: "请输入所有变量后, 点击发布自动生成结果.......",
				courtNameList: ["点击选择台区"],
				courtIdList: [-1],
				courtIndex: 0,
				courtId: 0
			}
		},
		methods: {
			confirmTime(e){
				var that = this;
				that.time = e.fulldate;
			},
			openCalendar(){
				this.$refs.calendar.open();
			},
			courtsSelect(e){
				var that = this;
				that.courtIndex = e.target.value;
				uni.showToast({
					title: that.courtNameList[that.courtIndex]
				})
				if(that.courtIndex > 0){
					that.courtId = that.courtIdList[that.courtIndex];
					return;
				}
				uni.showToast({
					icon: "error",
					title: "请选择台区!"
				})
			},
			addBaseInfo(){
				let that = this;
				if(that.courtIndex == 0){
					uni.showToast({
						icon: "error",
						title: "请选择台区！"
					})
					return;
				}
				
				var infoIsNotFinish = false;
				if(that.time == ''){
					uni.showToast({
						icon: "error",
						title: "请选择日期！"
					})
					return;
				}
				
				if(that.capacity != '' && that.load_rate != "" && that.power_sale != "" && that.power_apply != ""
				 && that.pre_line_loss != "" && that.real_line_loss != "" && that.load_unbalance_rate != "" && that.power_reliability != "" && that.radius != ""
				  && that.voltage_pass_percent != ""){
					infoIsNotFinish = true;
				}else {
					uni.showToast({
						icon: "error",
						title: "请补全信息！"
					})
					return;
				}
	
				var error_line_loss = Math.abs(that.pre_line_loss - that.real_line_loss)
				var state_res = 0
				if(error_line_loss < 0.5){
					that.state_res = "优秀";
					state_res = 5;
				}else if(error_line_loss >= 0.5 && error_line_loss < 1){
					that.state_res = "良好";
					state_res = 4;
				}else if(error_line_loss >= 1 && error_line_loss < 1.5){
					that.state_res = "合格";
					state_res = 3;
				}else if(error_line_loss >= 1.5 && error_line_loss < 2){
					that.state_res = "较差";
					state_res = 2;
				}else if(error_line_loss >= 2){
					that.state_res = "差";
					state_res = 1;
				}
				uni.showToast({
					title: "评估结果 :  " + that.state_res + "    正在上传服务器!",
					duration: 2000,
					
				})
				
				uni.request({
					url: config_url.baseurl + 'addBaseInfo', 
					data: {
						"courtId": that.courtId,
						"courtName": that.courtNameList[that.courtIndex],
						"capacity": that.capacity,
						"radius": that.radius,
						"load_rate": that.load_rate,
						"power_sale": that.power_sale,
						"power_apply": that.power_apply,
						"pre_line_loss": that.pre_line_loss,
						"real_line_loss": that.real_line_loss,
						"error_line_loss": error_line_loss,
						"load_unbalance_rate": that.load_unbalance_rate,
						"power_reliability": that.power_reliability,
						"voltage_pass_percent": that.voltage_pass_percent,
						"state_res": state_res,
						"time": that.time
					},
					method:'POST',
					header: {
						'Access-Control-Allow-Credentials':true,
						'Access-Control-Allow-Origin':'http://localhost:8080/#/',
						'Content-type':'application/x-www-form-urlencoded'
					},
					success(res) {
						var icon = "";
						if(res.data.stateCode == 0){
							icon = "error";
						}else {
							icon = "success";
							setTimeout(function(){
								uni.navigateBack({
									
								})
							}, 2000);
						}
						uni.showToast({
							title: res.data.info,
							icon: icon,
							duration: 3000
						})
					}
				})
			}
		},
		beforeCreate() {
			var that = this;
			var date = new Date();
			var year = date.getFullYear();
			var month = date.getMonth()+1;
			var day = date.getDate();
			var endDay = year.toString() + "-" + month.toString() + "-" + day.toString()
			that.end_date = endDay
			
			uni.request({
				url: config_url.baseurl + 'findAllCourts', 
				data: {
				},
				method:'POST',
				header: {
					'Access-Control-Allow-Credentials':true,
					'Access-Control-Allow-Origin':'http://localhost:8080/#/',
					'Content-type':'application/x-www-form-urlencoded'
				},
				success(res) {
					for (var i = 0; i < res.data.length; i++) {
						that.courtNameList.push(res.data[i].courtsName)
						that.courtIdList.push(res.data[i].courtsId)
					}
				}
			})
		}
	}
	
	
	
</script>

<style>	

.box_2{
	background-color: #C0C4CC;
	border-radius: 10rpx;
	padding-left: 15rpx;
	padding-right: 10rpx;
	box-sizing: border-box;
	/* border-bottom: 1rpx solid #333333; */
	width: 100%;
	height: 60rpx;margin-top: 20rpx;
	line-height: 60rpx;
	display: flex;
	justify-content: space-between;
	flex-wrap: wrap;
}

.text{
	font-size: medium;
	font-weight: bold;
	float: left;
}

.picker_class{
	width: 50%;
	text-align: center;
	font-size: small;
	margin-left: 20rpx;
	box-sizing: border-box; 
	float: right;
}

.picker_view{
	background-color: #DCDFE6;
	border-radius: 20rpx;
}


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
	height: 300rpx;
	padding: 15rpx;
	box-sizing: border-box;
	margin-top: 10rpx;
	margin-bottom: 10rpx;
	border: 1rpx solid #C0C0C0;
	border-radius: 10rpx;
}

</style>
