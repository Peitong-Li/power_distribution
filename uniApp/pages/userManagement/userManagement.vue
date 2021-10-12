<template>
	<view style="padding-top: 10rpx;box-sizing: border-box;">
		
		<uni-search-bar v-model="searchName" placeholder="请输入需要查找的用户名"></uni-search-bar>
		
		<view class="userLabel">
			<view style="width: 20%;">用户名</view>
			<view style="width: 15%;">权限</view>
			<view style="width: 15%;">更改</view>
			<view style="width: 15%;">状态</view>
			<view style="width: 15%;">封停</view>
		</view>
		<view class="userItem" v-for="(item,index) in filterUserList" v-bind:class=" index%2==0 ? itemClass_1 : itemClass_2 " :data-userId="item.userId" >
			<view style="width: 20%;">{{item.userName}}</view>
			<view style="width: 15%;">{{item.role}}</view>
			<view style="width: 15%;">
				<text style="background-color: #C8C7CC;border-radius: 5rpx;" 
				:data-userId="item.userId"  :data-role="item.role" :data-index='index' @click="updateUserRole">更改</text>
			</view>
			<view style="width: 15%;" content="123">{{item.state_c}}</view>
			<view style="width: 15%;">
				<text style="background-color: #F56C6C;border-radius: 5rpx;" v-if="item.state==1"  
				:data-userId="item.userId"  :data-state="item.state" :data-index='index' @click="updateUserState">冻结</text>
				<text style="background-color: #4CD964;border-radius: 5rpx;" v-if="item.state==0"  
				:data-userId="item.userId"  :data-state="item.state" :data-index='index' @click="updateUserState">解封</text>
			</view>
		</view>	
		
	</view>
</template>

<script>
	import {config_url} from '../../default/get_url.js'
	export default {
		data() {
			return {
				searchName:"",
				userList:[],
				itemClass_1:"itemClass_1",
				itemClass_2:"itemClass_2"
			}
		},
		computed:{
			filterUserList(){
				//1、获取数据
				let {searchName, userList} = this;
				//2、取出数组中的值
				let arr = [...userList];
				//3、过滤
				if(searchName.trim()){
					arr = userList.filter(u => u.userName.indexOf(searchName) !== -1);
				}
				return arr;
			}
		},
		
		methods: {
			
			updateUserState(e){
				let that = this;
				console.log(e.currentTarget.dataset)
				
				var userId = e.currentTarget.dataset.userId;
				var state = e.currentTarget.dataset.state;
				var index = e.currentTarget.dataset.index;
				uni.request({
					url: config_url.baseurl + 'updateUserState', 
					data: {//参数
						userId:userId,
						state:Number(!state)
					},
					// dataType:'json',
					method:'POST',//请求方式  或GET，必须为大写
					header: {
						'Access-Control-Allow-Credentials':true,
						'Access-Control-Allow-Origin':'http://localhost:8080/#/',
						'Content-type':'application/x-www-form-urlencoded'
					},
					success(res) {
						console.log(res.data);
						if(res.data.updateMsg==1){
							that.filterUserList[index].state=Number(!state)
						}
						
					}
				})
			},
			updateUserRole(e){
				let that = this;
				console.log(e.currentTarget.dataset);
				var userId = e.currentTarget.dataset.userId;
				var role = e.currentTarget.dataset.role;
				var index = e.currentTarget.dataset.index;
				uni.request({
					url: config_url.baseurl + 'updateUserRole', 
					data: {//参数
						userId:userId,
						role:Number(!role)
					},
					// dataType:'json',
					method:'POST',//请求方式  或GET，必须为大写
					header: {
						'Access-Control-Allow-Credentials':true,
						'Access-Control-Allow-Origin':'http://localhost:8080/#/',
						'Content-type':'application/x-www-form-urlencoded'
					},
					success(res) {
						console.log(res.data);
						if(res.data.updateMsg==1){
							that.filterUserList[index].role=Number(!role)
						}
						
					}
				})
			}
		},
		beforeCreate() {
			let that = this;
			uni.request({
				url: config_url.baseurl + 'findAllUsers', 
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
					that.userList = res.data
					for (var i = 0; i < that.userList.length; i++) {
						if(that.userList[i].state == 0){
							that.userList[i].state_c = "不可用";
						}else{
							that.userList[i].state_c = "可用";
						}
					}
					
				
				}
			})
		},
	}
</script>

<style>
.userLabel{
	width: 95%;
	border-radius: 10upx;
	height: 75rpx;
	background-color: #C0C0C0;
	display: flex;
	justify-content: space-between;
	margin: 0 auto;
}
.userLabel>view{
	height: 75rpx;
	line-height: 75rpx;
	font-size: 30rpx;
	/* background-color: #007AFF; */
	text-align: center;
}
.userItem{
	width: 95%;
	border-radius: 10upx;
	height: 70rpx;
	background-color: #F1F1F1;
	display: flex;
	justify-content: space-between;
	margin: 0 auto;
}
.userItem>view{
	height: 70rpx;
	line-height: 70rpx;
	text-align: center;
	font-size: 35rpx;
}
.itemClass_1{
	background-color: #F1F1F1;
}
.itemClass_2{
	background-color: #F8F8F8;
}
input{
	border-radius: 10upx;
	width: 50%;
	margin: 0rpx auto;
	height: 60upx;
	border-bottom: 5rpx solid #007AFF;
	text-align: center;
}
</style>
