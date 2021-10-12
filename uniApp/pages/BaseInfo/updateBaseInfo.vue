<template>
	<view style="width: 95%;">
		<!-- 台区选择 -->
		<view class="top_text">
			<text>当前台区：{{courtName}}</text>
		</view>
		<view  class="top_text">
			<text>更新日期 : {{time}}</text>
		</view>
		
		<view v-for="(item, index) in infoList">
			<text style="padding-top: 2%;">{{item.k_name}}</text>
			<input type="text" v-model="item.k_value"/>
		</view>
		
		
		<button type="primary" @click="updateBaseInfo">更新</button>

		
	</view>
	
</template>

<script>
	import {config_url} from '../../default/get_url.js'
	export default {
		data() {
			return {
				time: "",
				state_res: "请输入所有变量后, 点击发布自动生成结果.......",
				infoList: [],
				courtId: 0,
				courtName: ''
			}
		},
		methods: {
			updateBaseInfo(){
				let that = this;
				for (var i = 0; i < that.infoList.length; i++) {
					if(that.infoList[i].k_value == ""){
						uni.showToast({
							icon: "error",
							title: "请补全信息！"
						})
						return;
					}
				}
	
				var error_line_loss = Math.abs(that.infoList[5].k_value - that.infoList[6].k_value)
				
				var state_res = 0
				if(error_line_loss < 0.5){
					that.infoList[10].k_value = "优秀";
					state_res = 5;
				}else if(error_line_loss >= 0.5 && error_line_loss < 1){
					that.infoList[10].k_value = "良好";
					state_res = 4;
				}else if(error_line_loss >= 1 && error_line_loss < 1.5){
					that.infoList[10].k_value = "合格";
					state_res = 3;
				}else if(error_line_loss >= 1.5 && error_line_loss < 2){
					that.infoList[10].k_value = "较差";
					state_res = 2;
				}else if(error_line_loss >= 2){
					that.infoList[10].k_value = "差";
					state_res = 1;
				}
				uni.showToast({
					title: "评估结果 : '" + that.infoList[10].k_value + "' \n正在上传服务器!",
					duration: 2000,
					
				})
				
				uni.request({
					url: config_url.baseurl + 'updateBaseInfo', 
					data: {
						"courtId": that.courtId,
						"courtName": that.courtName,
						"capacity": that.infoList[0].k_value,
						"radius": that.infoList[1].k_value,
						"load_rate": that.infoList[2].k_value,
						"power_sale": that.infoList[3].k_value,
						"power_apply": that.infoList[4].k_value,
						"pre_line_loss": that.infoList[6].k_value,
						"real_line_loss": that.infoList[5].k_value,
						"error_line_loss": error_line_loss,
						"load_unbalance_rate": that.infoList[7].k_value,
						"power_reliability": that.infoList[8].k_value,
						"voltage_pass_percent": that.infoList[9].k_value,
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
		onLoad(res) {
			var that = this;
			that.infoList = JSON.parse(decodeURIComponent(res.infoList));
			that.courtName = res.courtName;
			that.courtId = res.courtId;
			that.time = res.time;
			console.log(that.courtName)
			console.log(that.time)
			console.log(that.infoList)
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
	width: 100%;height: 60rpx;margin-top: 20rpx;
	line-height: 60rpx;
	display: flex;
	justify-content: space-between;
	flex-wrap: wrap;
}

.text{
	font-size: medium;
	font-weight: bold;
}

text{
	margin-left: 3%;
	padding-top: 5%;
}

input{
	width: 100%;
	height: 70rpx;
	line-height: 70rpx;
	padding: 15rpx;
	box-sizing: border-box;
	margin-top: 10rpx;
	margin-bottom: 10rpx;
	margin-left: 3%;
	border: 1rpx solid #C0C0C0;
	border-radius: 10rpx;
}
.top_text{
	margin-top: 2%;
	margin-bottom: 2%;
	font-size: 35upx;
	font-weight: 700;
}
</style>
