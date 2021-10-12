<template>
	<view class="content" style="background-color: #F1F1F1;position: fixed;width: 100%;height: 100%;">
		
		<swiper :indicator-dots="true" :autoplay="true" :interval="3000" :duration="1000">
			<swiper-item v-for="(item, index) in srcUrl">
				<image :src="item" mode="aspectFill" ></image>
			</swiper-item>
		</swiper>
		
		<view class="box_1">
			<text class="text_1">通知公告</text>
			<text class="text_2" @click="toMore">更多 >></text>
		</view>
		
		<view class="item" v-for="(item,index) in noticeList" :data-noticeId="item.noticeId" @click="toDetail">
			<view class="item_text">
				{{item.noticeTitle}}
			</view>
			<view class="item_time">
				{{new Date(item.noticeTime).toLocaleDateString()}}
			</view>
		</view>
		
	</view>
</template>

<script>
	import {config_url} from '../../default/get_url.js'
	export default {
		data() {
			return {
				srcUrl:[
					'../../static/index_swiper/1.jpg',
					'../../static/index_swiper/2.jpg',
					'../../static/index_swiper/3.jpg',
				],
				noticeList:[],
			}
		},
		onLoad() {

		},
		methods: {
			toMore(){
				uni.navigateTo({
					url:"../noticeList/noticeList"
				})
			},
			toDetail(e){
				var noticeId = e.currentTarget.dataset.noticeid
				
				uni.navigateTo({
					url:"../noticeDetail/noticeDetail?noticeId="+noticeId
				})
			},
			sortNotices(){
				var that = this;
				that.noticeList.sort(function(a,b){
					var tempA = a.noticeTime.split("-")
					var tempB = b.noticeTime.split("-")
					a = tempA[0]+tempA[1]+tempA[2]
					b = tempB[0]+tempB[1]+tempB[2]
					return b - a;
				});
			},
		},
		onShow() {
			let that = this;
			uni.request({
				url: config_url.baseurl + 'findAllNotice', 
				data: {//参数
				},
				method:'POST',
				header: {
					'Access-Control-Allow-Credentials':true,
					'Access-Control-Allow-Origin':'http://localhost:8080/#/',
					'Content-type':'application/x-www-form-urlencoded'
				},
				success(res) {
					that.noticeList = res.data;
					that.sortNotices()
				}
			})

			uni.getStorage({
				key:'role',
				success(res) {
					that.role = res.data
				}
			})
		}
	}
</script>

<style>

swiper{
	margin: 0 auto;
	background-color: #fff;
}
image{
	width: 100%;
}
a{
	display: block;
	position: absolute;
	left: 50%;
	bottom: 15%;
	transform: translate(-50%);
	
}
.box_1{
	margin: 10rpx;
	height: 57rpx;
	border-bottom: 2rpx solid #DBDBDB;
	display: flex;
	justify-content: space-between;
}
.box_1 .text_1{
	line-height: 60rpx;
	font-weight: 600;
	border-bottom: 3rpx solid #00AAFF;
	font-size: large;
}
.box_1 .text_2{
	height: 60rpx;
	line-height: 60rpx;
	font-size: small;
	color: #999999;
}
.item{
	height: 50rpx;
	line-height: 50rpx;
	border-bottom: 1px dotted #C8C7CC;
	margin: 0rpx auto;
	display: flex;
	justify-content: space-between;
	margin: 10rpx;
}
.item_text{
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	font-size: 30rpx;
}
.item_time{
	margin-left: 20rpx;
	font-size: 25rpx;
}
</style>
