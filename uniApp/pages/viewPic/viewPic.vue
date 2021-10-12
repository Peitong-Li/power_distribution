<template>
	<view>
		<view>图片查看</view>
		<view class="box">
			<image class="img" src="../../static/5433009.jpg" mode=""></image>
		</view>
			
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			
		}
	}
</script>

<style>
.box{
	width: 50%;
	height: 300rpx;
	background-color: yellow;
}
.img{
	/* width: 50%; */
	height: 100%;
	width: 100%;
	object-fit: contain;
}
</style>
