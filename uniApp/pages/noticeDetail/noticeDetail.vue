<template>
	<view >
		
		<view class="noticeTitle">{{noticeDetail.noticeTitle}}</view>
		<view class="other">
			<text>发布时间：{{new Date(noticeDetail.noticeTime).toLocaleDateString()}} </text>
			<text>责任编辑：{{noticeDetail.noticePeo}} </text>
			<text>已被浏览 {{noticeDetail.viewNum}} 次</text>
		</view>
		<textarea :value=noticeDetail.noticeContent placeholder="" />
		<button class="mini-btn" type="warn" @click="delNotice" v-show="role==2">删除</button>
	</view>
</template>

<script>
	import {config_url} from '../../default/get_url.js'
	export default {
		data() {
			return {
				noticeDetail:[],
				noticeId:"",
				role:""
			}
		},
		methods: {
			delNotice:function(){
				let that = this;
				uni.showModal({
					title:"提示",
					content:"确定删除此通知吗",
					success(res) {
						if(res.confirm){
							uni.request({
								url: config_url.baseurl + '/delNoticeById', 
								data: {
									noticeId:that.noticeId
								},
								method:'POST',
								header: {
									'Access-Control-Allow-Credentials':true,
									'Access-Control-Allow-Origin':'http://localhost:8080/#/',
									'Content-type':'application/x-www-form-urlencoded'
								},
								success(res) {
									console.log(res.data);
									if(res.data.delMsg==1){
										uni.navigateBack({})
									}else{
										uni.showModal({
											title:"提示",
											content:"删除失败"
										})
									}
								}
							})
						}else{
							
						}
					}
				})
			}
			},
		onLoad(e) {
			let that = this;
			var noticeId = e.noticeId;
			that.noticeId = noticeId;
			console.log("noticeId:", noticeId)
			
			uni.request({
				url: config_url.baseurl + '/findNoticeById', 
				data: {
					noticeId: noticeId
				},
				method:'POST',
				header: {
					'Access-Control-Allow-Credentials':true,
					'Access-Control-Allow-Origin':'http://localhost:8080/#/',
					'Content-type':'application/x-www-form-urlencoded'
				},
				success(res) {
					console.log(res.data);
					that.noticeDetail=res.data
				}
			})
			uni.getStorage({
				key: 'role',
				success (res) {
					that.role = res.data
				},
				fail(res) {
					console.log(res)
				}
			})
		},
	}
</script>

<style>
.noticeTitle{
	text-align: center;
	font-weight: 900;
	padding: 3px;
	margin-left: 15rpx;
	margin-right: 15rpx;
	font-size: 20px;
	color: #282828;
	border-bottom: 2px solid #DBDBDB;
}
.other{
	line-height: 45rpx;
	padding: 5rpx;
	font-size: 18rpx;
	color: #787878;
	text-align: center;
}
.other text{
	margin-left: 10rpx;
	margin-right: 10rpx;
	font-size: larger;
}
textarea{
	margin-left: 2%;
	margin-right: 2%;
	width: 94%;
	height: 1000upx;
	padding: 15rpx;
	padding-top: 5rpx;
	font-size: 18px;
}
button{
	width: 80%;
}
</style>
