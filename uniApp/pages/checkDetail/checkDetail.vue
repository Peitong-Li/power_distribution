<template>
	<view style="padding-top: 20rpx;">
		
		<view class="box_2" >
			<view class="box_text">台区名称</view>
			<view class="box_2_input">
				<input type="text"  :value="checkDetail.courtsName" />
			</view>
		</view>
		<view class="box_2" >
			<view class="box_text">巡检名称</view>
			<view class="box_2_input">
				<input type="text" name="checkName" :value="checkDetail.checkName" />
			</view>
		</view>
		
		<view class="box_3">
			<view class="box_text">巡检内容</view>
			<view class="box_3_input">
				<textarea name="checkContent" value="" v-model="checkDetail.checkContent" style="width: 100%;height: 180rpx;margin: 0 auto;;"/>
			</view>
		</view>
		
		<view class="box_4">
			<view class="box_text">巡检结果</view>
			<view class="box_4_input">
				<textarea name="checkResult" value="" v-model="checkDetail.checkResult" style="width: 100%;height: 180rpx;margin: 0 auto;"/>
			</view>
		</view>
		<div class="box_5">
			<div class="box_text">巡检时间</div>
			<view class="box_2_input">
				<input type="text" :value="checkDetail.checkTime" />
			</view>
		</div>
		<view class="box_2" >
			<view class="box_text">巡检人员</view>
			<view class="box_2_input">
				<input type="text" v-model="checkDetail.checkPeo" name="checkPeo" value="" />
			</view>
		</view>
	
	
	
	
	
	</view>
</template>

<script>
	import {config_url} from '../../default/get_url.js'
	import dyDatePicker from '../../components/lanxiujuan-dyDate/lanxiujuan-dyDate.vue'
	export default {
		components: {
			dyDatePicker
		},
		data() {
			return {
				checkId: -1,
				checkDetail:{}
			}
		},
		methods: {		
		},
		beforeCreate() {
		},
		onLoad(e) {
			let that = this;
			this.checkId = e.checkId;
			uni.request({
				url: config_url.baseurl + 'findCheckById',
				data: {//参数
					checkId: that.checkId
				},
				method:'POST',//请求方式  或GET，必须为大写
				header: {
					'Access-Control-Allow-Credentials':true,
					'Access-Control-Allow-Origin':'http://localhost:8080/#/',
					'Content-type':'application/x-www-form-urlencoded'
				},
				success(res) {
					that.checkDetail = res.data.data
					that.checkDetail.checkTime = new Date(that.checkDetail.checkTime).toLocaleDateString()
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
	/* background-color: #C0C0C0; */
	border-radius: 10rpx;

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
.box_2{
	width: 95%;
	
	margin: 20rpx auto;
	overflow: hidden;
	line-height: 60rpx;
	border-radius: 10rpx;
}
.box_text{
	font-size: medium;
	font-weight: bold;
	float: left;
}
.box_2_input{
	width: 80%;
	height: 60rpx;
	margin: 0 auto;
	border: 1rpx solid #DBDBDB;
	border-radius: 10rpx;
	float: right;
}
.box_2_input>input{
	height: 60rpx;
	line-height: 60rpx;
	margin-left: 15rpx;
}

.box_3,.box_4,.box_5{
	width: 95%;
	overflow: hidden;
	/* background-color: #007AFF; */
	margin: 20rpx auto;
	line-height: 60rpx;
	border-radius: 10rpx;
}
.box_3_input,.box_4_input{
	width: 80%;
	height: 190rpx;
	margin: 0 auto;
	/* background-color: #C8C7CC; */
	border: 1rpx solid #DBDBDB;
	border-radius: 10rpx;
	float: right;
	padding-top: 9rpx;
	padding-left: 15rpx;
	padding-right: 15rpx;
	box-sizing: border-box;
}
.box_5_input{
	width: 80%;
	height: 60rpx;
	line-height: 60rpx;
	margin: 0 auto;
	/* background-color: #C8C7CC; */
	border-radius: 10rpx;
	float: right;
	padding-top: 9rpx;
	box-sizing: border-box;
	border: 1rpx solid #DBDBDB;
	padding-left: 20rpx;
	text-align: left;
}

</style>




	
