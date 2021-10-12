<template>
	<view >
		
		
		<view class="item" v-for="(item,index) in noticeList" :data-noticeId="item.noticeId" @click="toDetail">
			<view class="item_text">
				{{item.noticeTitle}}
			</view>
			<view class="item_time">
				{{new Date(item.noticeTime).toLocaleDateString()}}
			</view>
		</view>
		
		<button type="primary" v-show="role==2" @click="toAdd">添加</button>
		
	</view>
</template>

<script>
	import {config_url} from '../../default/get_url.js'
	export default {
		data() {
			return {
				noticeList:[],
				role:''
			}
		},
		methods: {
			toAdd(){
				let that = this;
				uni.navigateTo({
					url:"../noticeAdd/noticeAdd"
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
.item{
	width: 98%;
	height: 70rpx;
	line-height: 70rpx;
	border-bottom: 1px dotted #C8C7CC;
	margin: 0rpx auto;
	display: flex;
	justify-content: space-between;
	
}
.item:active{
	background-color: #F1F1F1;
}
.item_text{
	/* height: 50rpx; */
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	font-size: 35rpx;
}
.item_time{
	margin-left: 20rpx;
	font-size: 30rpx;
}
button{
	width: 80%;
	margin-top: 5%;
}
</style>
