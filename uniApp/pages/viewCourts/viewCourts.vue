<template>
	<view style="width: 95%;margin: 0 auto;">
		
		<scroll-view scroll-x="true" style="height: 410rpx;margin-bottom: 40rpx;border: 1rpx dotted #333333;">
			<image :src="srcUrl" :style="imgStyle" mode="" @click="tapImg"></image>
		</scroll-view>
		
		<!-- 台区选择 -->
		<view class="box_1">
			<text class="text" >台区名称</text>
			<select class="courtsSelect" @change="courtsSelect" ref="courtsId" >
				<option  value="" data-id="123">---------</option>
				<option  v-for="(item, index) in courtsList" 
						:data-id="item.courtsId" :data-name="item.courtsName"   :value="item.courtsId">{{item.courtsName}}
						<!-- <text>{{item.courtsId}}</text> -->
				</option>
						
			</select>
			<!-- <button class="chooseBtn" @click="chooseImage">选择图片</button> -->
		</view>
		
		<!-- 区域选择 -->
		<view class="box_2">
			<text class="text">区域选择</text>
			<select class="areaNameSelect" @change="areaNameSelect" ref="areaName">
				<option  value="">---------</option>
				<option  value="中压侧">中压侧</option>
				<option  value="配变侧">配变侧</option>
				<option  value="低压侧">低压侧</option>
				<option  value="线路侧">线路侧</option>
				<option  value="用户侧">用户侧</option>
			</select>
		</view>
		
		<!-- 设备列表 -->
		<view style="padding: 15rpx;padding-top: 0rpx;background-color: #DBDBDB;border-radius: 10rpx;margin-top: 20rpx;">
			<!-- 标题 -->
			<view class="item" style="border-bottom: 1px solid #333333;">
				<view style="width: 14%;font-weight: bold;">标号</view>
				<view style="width: 45%;font-weight: bold;">设备名称</view>
				<view style="width: 20%;font-weight: bold;">所属侧</view>
				<view style="width: 12%;font-weight: bold;float: right;margin-right: 0rpx;">查看</view>
			</view>
			<!-- 智能变压器 -->
			<view v-for="(item, index) in Transformer" class="item" v-bind:class=" index%2==0 ? itemClass_1 : itemClass_2 "  v-if="areaName==''|| item.areaName ==areaName ">
				<view  style="width: 14%;">{{item.sign}}</view>
				<view  style="width: 45%;">智能变压器</view>
				<view  style="width: 20%;">{{item.areaName}}</view>
				<view  style="width: 10%;float: right;margin-right: 0rpx;">
					<image :data-index="index" data-name="Transformer"  :data-id="item.id" src="../../static/look.png" @click="viewDeviceInfo" style="width: 40rpx;height: 40rpx;margin: 5rpx;"></image>
				</view> 
			</view>
			
			
			<!-- 智能环境传感器-->
			<view v-for="(item, index) in EvSensor" class="item" v-bind:class=" index%2==0 ? itemClass_1 : itemClass_2 " v-if="areaName==''|| item.areaName ==areaName ">
				<view  style="width: 14%;">{{item.sign}}</view>
				<view  style="width: 45%;">智能环境传感器</view>
				<view  style="width: 20%;">{{item.areaName}}</view>
				<view  style="width: 10%;float: right;margin-right: 0rpx;">
					<image :data-index="index" data-name="EvSensor" :data-id="item.id" src="../../static/look.png"   @click="viewDeviceInfo"style="width: 40rpx;height: 40rpx;margin: 5rpx;"></image>
				</view>
			</view>
			<!-- 台区总表 -->
			<view v-for="(item, index) in AreaMeter" class="item"  v-bind:class=" index%2==0 ? itemClass_1 : itemClass_2 " v-if="areaName==''|| item.areaName ==areaName ">
				<view  style="width: 14%;">{{item.sign}}</view>
				<view  style="width: 45%;">台区总表</view>
				<view  style="width: 20%;">{{item.areaName}}</view>
				<view  style="width: 10%;float: right;margin-right: 0rpx;">
					<image :data-index="index" data-name="AreaMeter" :data-id="item.id" src="../../static/look.png"  @click="viewDeviceInfo" style="width: 40rpx;height: 40rpx;margin: 5rpx;"></image>
				</view> 
			</view>
			<!-- 熔断器 -->
			<view v-for="(item, index) in Fuse" class="item" v-bind:class=" index%2==0 ? itemClass_1 : itemClass_2 "  v-if="areaName==''|| item.areaName ==areaName ">
				<view  style="width: 14%;">{{item.sign}}</view>
				<view  style="width: 45%;">熔断器</view>
				<view  style="width: 20%;">{{item.areaName}}</view>
				<view  style="width: 10%;float: right;margin-right: 0rpx;">
					<image :data-index="index" data-name="Fuse" :data-id="item.id" src="../../static/look.png"  @click="viewDeviceInfo" style="width: 40rpx;height: 40rpx;margin: 5rpx;"></image>
				</view> 
			</view>
			<!-- 智能开关 -->
			<view v-for="(item, index) in IntelligentSwitch" class="item"  v-bind:class=" index%2==0 ? itemClass_1 : itemClass_2 " v-if="areaName==''|| item.areaName ==areaName ">
				<view  style="width: 14%;">{{item.sign}}</view>
				<view  style="width: 45%;">智能开关</view>
				<view  style="width: 20%;">{{item.areaName}}</view>
				<view  style="width: 10%;float: right;margin-right: 0rpx;">
					<image :data-index="index" data-name="IntelligentSwitch" :data-id="item.id" src="../../static/look.png"   @click="viewDeviceInfo"style="width: 40rpx;height: 40rpx;margin: 5rpx;"></image>
				</view> 
			</view>
			<!-- 单相表 -->
			<view v-for="(item, index) in UniphaseMeter" class="item" v-bind:class=" index%2==0 ? itemClass_1 : itemClass_2 "  v-if="areaName==''|| item.areaName ==areaName ">
				<view  style="width: 14%;">{{item.sign}}</view>
				<view  style="width: 45%;">单相表</view>
				<view  style="width: 20%;">{{item.areaName}}</view>
				<view  style="width: 10%;float: right;margin-right: 0rpx;">
					<image :data-index="index" data-name="UniphaseMeter" :data-id="item.id" src="../../static/look.png"  @click="viewDeviceInfo" style="width: 40rpx;height: 40rpx;margin: 5rpx;"></image>
				</view> 
			</view>
			<!-- LTU开关 -->
			<view v-for="(item, index) in LTUSwitch" class="item" v-bind:class=" index%2==0 ? itemClass_1 : itemClass_2 " v-if="areaName==''|| item.areaName ==areaName ">
				<view  style="width: 14%;">{{item.sign}}</view>
				<view  style="width: 45%;">LTU开关</view>
				<view  style="width: 20%;">{{item.areaName}}</view>
				<view  style="width: 10%;float: right;margin-right: 0rpx;">
					<image :data-index="index" data-name="LTUSwitch" :data-id="item.id" src="../../static/look.png"  @click="viewDeviceInfo"  style="width: 40rpx;height: 40rpx;margin: 5rpx;"></image>
				</view> 
			</view>
			<!-- 换相开关 -->
			<view v-for="(item, index) in ChangePhaseSwitch" class="item" v-bind:class=" index%2==0 ? itemClass_1 : itemClass_2 "  v-if="areaName==''|| item.areaName ==areaName ">
				<view  style="width: 14%;">{{item.sign}}</view>
				<view  style="width: 45%;">换相开关</view>
				<view  style="width: 20%;">{{item.areaName}}</view>
				<view  style="width: 10%;float: right;margin-right: 0rpx;">
					<image :data-index="index" data-name="ChangePhaseSwitch" :data-id="item.id" src="../../static/look.png"  @click="viewDeviceInfo" style="width: 40rpx;height: 40rpx;margin: 5rpx;"></image>
				</view> 
			</view>
			<!-- 电动汽车充电设施 -->
			<view v-for="(item, index) in ChargingFacility" class="item" v-bind:class=" index%2==0 ? itemClass_1 : itemClass_2 "  v-if="areaName==''|| item.areaName ==areaName ">
				<view  style="width: 14%;">{{item.sign}}</view>
				<view  style="width: 45%;">电动汽车充电设施</view>
				<view  style="width: 20%;">{{item.areaName}}</view>
				<view  style="width: 10%;float: right;margin-right: 0rpx;">
					<image :data-index="index" data-name="ChargingFacility" :data-id="item.id"  @click="viewDeviceInfo" src="../../static/look.png" style="width: 40rpx;height: 40rpx;margin: 5rpx;"></image>
				</view> 
			</view>
			<!-- 光伏用户 -->
			<view v-for="(item, index) in PvUser" class="item" v-bind:class=" index%2==0 ? itemClass_1 : itemClass_2 "  v-if="areaName==''|| item.areaName ==areaName ">
				<view  style="width: 14%;">{{item.sign}}</view>
				<view  style="width: 45%;">光伏用户</view>
				<view  style="width: 20%;">{{item.areaName}}</view>
				<view  style="width: 10%;float: right;margin-right: 0rpx;">
					<image :data-index="index" data-name="PvUser" :data-id="item.id"  @click="viewDeviceInfo" src="../../static/look.png" style="width: 40rpx;height: 40rpx;margin: 5rpx;"></image>
				</view> 
			</view>
			<!-- 无功补偿装置 -->
			<view v-for="(item, index) in CompensationDevice" class="item" v-bind:class=" index%2==0 ? itemClass_1 : itemClass_2 " v-if="areaName==''|| item.areaName ==areaName ">
				<view  style="width: 14%;">{{item.sign}}</view>
				<view  style="width: 45%;">无功补偿装置</view>
				<view  style="width: 20%;">{{item.areaName}}</view>
				<view  style="width: 10%;float: right;margin-right: 0rpx;">
					<image :data-index="index" data-name="CompensationDevice" :data-id="item.id" @click="viewDeviceInfo" src="../../static/look.png" style="width: 40rpx;height: 40rpx;margin: 5rpx;"></image>
				</view> 
			</view>
			<!-- 电缆感知设备 -->
			<view v-for="(item, index) in CableSensingDevice"class="item" v-bind:class=" index%2==0 ? itemClass_1 : itemClass_2 "  v-if="areaName==''|| item.areaName ==areaName ">
				<view  style="width: 14%;">{{item.sign}}</view>
				<view  style="width: 45%;">电缆感知设备</view>
				<view  style="width: 20%;">{{item.areaName}}</view>
				<view  style="width: 10%;float: right;margin-right: 0rpx;">
					<image :data-index="index" data-name="CableSensingDevice" :data-id="item.id" @click="viewDeviceInfo" src="../../static/look.png" style="width: 40rpx;height: 40rpx;margin: 5rpx;"></image>
				</view> 
			</view>
			<!-- 三相表 -->
			<view v-for="(item, index) in ThreePhaseMeter" class="item" v-bind:class=" index%2==0 ? itemClass_1 : itemClass_2 " v-if="areaName==''|| item.areaName ==areaName ">
				<view  style="width: 14%;">{{item.sign}}</view>
				<view  style="width: 45%;">三相表</view>
				<view  style="width: 20%;">{{item.areaName}}</view>
				<view  style="width: 10%;float: right;margin-right: 0rpx;">
					<image :data-index="index" data-name="ThreePhaseMeter" :data-id="item.id" @click="viewDeviceInfo" src="../../static/look.png" style="width: 40rpx;height: 40rpx;margin: 5rpx;"></image>
				</view> 
			</view>
			<!-- 智能终端 -->
			<view v-for="(item, index) in Terminal" class="item" v-bind:class=" index%2==0 ? itemClass_1 : itemClass_2 "  v-if="areaName==''|| item.areaName ==areaName ">
				<view  style="width: 14%;">{{item.sign}}</view>
				<view  style="width: 45%;">智能终端</view>
				<view  style="width: 20%;">{{item.areaName}}</view>
				<view  style="width: 10%;float: right;margin-right: 0rpx;">
					<image :data-index="index" data-name="Terminal" :data-id="item.id" @click="viewDeviceInfo" src="../../static/look.png" style="width: 40rpx;height: 40rpx;margin: 5rpx;"></image>
				</view> 
			</view>
		</view>
		
		
		<!-- 表单（查看） -->
		<!-- 表单--1智能变压器 -->
		<form @submit="formSubmit" @reset="formReset" id="Form_Transformer" :style="TransformerFormStyle">
			<view>
				<view class="" style="display: inline-block;width: 60%;margin-bottom: 10rpx;">
					<text class="text">智能变压器</text>
				</view>
				<image class="icon" src="../../static/close.png"  @click="formCancel" mode=""></image>
				<!-- <image class="icon_add" src="../../static/addDevice.png" @click="addDevice" mode=""></image> -->
			</view>
			<view class="formItem">
				<view class="formItem_1">设备标号</view>
				<view class="formItem_2"><input name="sign" type="number" :value="Transformer_Item_Info.sign" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">所属侧</view>
				<view style="width: 40%;height: 50rpx;float: left;margin: 5rpx;">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					 ref="areaName_Transformer" :value="Transformer_Item_Info.areaName">
						<option  value="中压侧">中压侧</option>
						<option  value="配变侧">配变侧</option>
						<option  value="低压侧">低压侧</option>
						<option  value="线路侧">线路侧</option>
						<option  value="用户侧">用户侧</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_A" type="number" :value="Transformer_Item_Info.voltage_A" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_B" type="number" :value="Transformer_Item_Info.voltage_B"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_C" type="number" :value="Transformer_Item_Info.voltage_C"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">AB线电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_AB" type="number" :value="Transformer_Item_Info.voltage_AB"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">BC线电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_BC" type="number":value="Transformer_Item_Info.voltage_BC" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">CA线电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_CA" type="number" :value="Transformer_Item_Info.voltage_CA"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_A" type="number"  :value="Transformer_Item_Info.current_A"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_B" type="number" :value="Transformer_Item_Info.current_B"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_C" type="number" :value="Transformer_Item_Info.current_C"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">分接头档位</view>
				<view class="formItem_2">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					 @click="ceSelect" ref="switchState_Transformer" :value="Transformer_Item_Info.switchState">
						<option  value="合闸">合闸</option>
						<option  value="分闸">分闸</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">桩头温度</view><view class="formItem_3">℃</view>
				<view class="formItem_2"><input name="poleTemperature" type="number" :value="Transformer_Item_Info.poleTemperature"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">油温</view><view class="formItem_3">℃</view>
				<view class="formItem_2"><input name="oilTemperature" type="number" :value="Transformer_Item_Info.oilTemperature"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">内部压力</view><view class="formItem_3">P</view>
				<view class="formItem_2"><input name="insidePressure" type="number" :value="Transformer_Item_Info.insidePressure"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">油位</view><view class="formItem_3">cm</view>
				<view class="formItem_2"><input name="oilPosition" type="number" :value="Transformer_Item_Info.oilPosition"></view>
			</view>
			<!-- <button form-type="submit" class="formBtn">修改</button> -->
			<!-- <button form-type="reset" class="formBtn">重置</button> -->
			<!-- <button type="default" class="formBtn" @click="formCancel">关闭</button> -->
		</form>
		<!-- 表单--2智能环境传感器 -->
		<form @submit="formSubmit" @reset="formReset" id="Form_EvSensor" :style="EvSensorFormStyle">
			<view>
				<view class="" style="display: inline-block;width: 60%;margin-bottom: 10rpx;">
					<text class="text">智能环境传感器</text>
				</view>
				<image class="icon" src="../../static/close.png"  @click="formCancel" mode=""></image>
			</view>
			
			<view class="formItem">
				<view class="formItem_1">设备标号</view>
				<view class="formItem_2"><input name="sign" type="number" :value="EvSensor_Item_Info.sign"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">所属侧</view>
				<view style="width: 40%;height: 50rpx;float: left;margin: 5rpx;">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					  ref="areaName_EvSensor" :value="EvSensor_Item_Info.areaName" >
						<option  value="中压侧">中压侧</option>
						<option  value="配变侧">配变侧</option>
						<option  value="低压侧">低压侧</option>
						<option  value="线路侧">线路侧</option>
						<option  value="用户侧">用户侧</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">温度</view><view class="formItem_3">℃</view>
				<view class="formItem_2"><input name="temperature"  type="number" :value="EvSensor_Item_Info.temperature"></view>
				
			</view>
			<view class="formItem">
				<view class="formItem_1">湿度</view><view class="formItem_3">℃</view>
				<view class="formItem_2"><input name="humidity" type="number" :value="EvSensor_Item_Info.humidity" ></view>
			</view>
			
		</form>
		<!-- 表单--3台区总表 -->
		<form @submit="formSubmit" @reset="formReset" id="Form_AreaMeter" :style="AreaMeterFormStyle">
			<view>
				<view class="" style="display: inline-block;width: 60%;margin-bottom: 10rpx;">
					<text class="text">台区总表</text>
				</view>
				<image class="icon" src="../../static/close.png"  @click="formCancel" mode=""></image>
			</view>
			<view class="formItem">
				<view class="formItem_1">设备标号</view>
				<view class="formItem_2"><input name="sign" type="number" :value="AreaMeter_Item_Info.sign"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">所属侧</view>
				<view style="width: 40%;height: 50rpx;float: left;margin: 5rpx;">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					 ref="areaName_AreaMeter" :value="AreaMeter_Item_Info.areaName">
						<option  value="中压侧">中压侧</option>
						<option  value="配变侧">配变侧</option>
						<option  value="低压侧">低压侧</option>
						<option  value="线路侧">线路侧</option>
						<option  value="用户侧">用户侧</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_A" type="number" :value="AreaMeter_Item_Info.voltage_A"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_B" type="number" :value="AreaMeter_Item_Info.voltage_B"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_C" type="number" :value="AreaMeter_Item_Info.voltage_C"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_A" type="number"  :value="AreaMeter_Item_Info.current_A"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_B" type="number" :value="AreaMeter_Item_Info.current_B"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_C" type="number" :value="AreaMeter_Item_Info.current_C"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_A" type="number" :value="AreaMeter_Item_Info.activePower_A"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_B" type="number" :value="AreaMeter_Item_Info.activePower_B"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_C" type="number" :value="AreaMeter_Item_Info.activePower_C"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">总有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_Total" type="number" :value="AreaMeter_Item_Info.activePower_Total"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_A" type="number" :value="AreaMeter_Item_Info.reactivePower_A"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_B" type="number" :value="AreaMeter_Item_Info.reactivePower_B"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_C" type="number" :value="AreaMeter_Item_Info.reactivePower_C" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">总无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_Total" type="number" :value="AreaMeter_Item_Info.reactivePower_Total"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相视在功率</view><view class="formItem_3">KVA</view>
				<view class="formItem_2"><input name="apparentPower_A" type="number" :value="AreaMeter_Item_Info.apparentPower_A"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相视在功率</view><view class="formItem_3">KVA</view>
				<view class="formItem_2"><input name="apparentPower_B" type="number" :value="AreaMeter_Item_Info.apparentPower_B"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相视在功率</view><view class="formItem_3">KVA</view>
				<view class="formItem_2"><input name="apparentPower_C" type="number" :value="AreaMeter_Item_Info.apparentPower_C"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">总视在功率</view><view class="formItem_3">KVA</view>
				<view class="formItem_2"><input name="apparentPower_Total" type="number" :value="AreaMeter_Item_Info.apparentPower_Total"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">配变负载率</view><view class="formItem_3">%</view>
				<view class="formItem_2"><input name="distributionLoadRate" type="number" :value="AreaMeter_Item_Info.distributionLoadRate" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">电压合格率</view><view class="formItem_3">%</view>
				<view class="formItem_2"><input name="voltagePassRate" type="number" :value="AreaMeter_Item_Info.voltagePassRate"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">温湿度</view><view class="formItem_3">℃</view>
				<view class="formItem_2"><input name="humiture" type="number" :value="AreaMeter_Item_Info.humiture"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">环境瓦斯浓度</view><view class="formItem_3">%</view>
				<view class="formItem_2"><input name="gasConcentration" type="number" :value="AreaMeter_Item_Info.gasConcentration"></view>
			</view>
			
		
		</form>
		<!-- 表单--14智能终端 -->
		<form @submit="formSubmit" @reset="formReset" id="Form_Terminal" :style="TerminalFormStyle">
			<view>
				<view class="" style="display: inline-block;width: 60%;margin-bottom: 10rpx;">
					<text class="text">智能终端</text>
				</view>
				<image class="icon" src="../../static/close.png"  @click="formCancel" mode=""></image>
			</view>
			<view class="formItem">
				<view class="formItem_1">设备标号</view>
				<view class="formItem_2"><input name="sign" type="number" :value="Terminal_Item_Info.sign"  ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">所属侧</view>
				<view style="width: 40%;height: 50rpx;float: left;margin: 5rpx;">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					 ref="areaName_Terminal" :value="Terminal_Item_Info.areaName"  >
						<option  value="中压侧">中压侧</option>
						<option  value="配变侧">配变侧</option>
						<option  value="低压侧">低压侧</option>
						<option  value="线路侧">线路侧</option>
						<option  value="用户侧">用户侧</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_A" type="number"  :value="Terminal_Item_Info.voltage_A"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_B" type="number"  :value="Terminal_Item_Info.voltage_B"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_C" type="number"  :value="Terminal_Item_Info.voltage_C"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_A" type="number"  :value="Terminal_Item_Info.current_A" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_B" type="number"  :value="Terminal_Item_Info.current_B"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_C" type="number" :value="Terminal_Item_Info.current_C" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_A" type="number"  :value="Terminal_Item_Info.activePower_A" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_B" type="number"  :value="Terminal_Item_Info.activePower_B" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_C" type="number"  :value="Terminal_Item_Info.activePower_C" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">总有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_Total" type="number"  :value="Terminal_Item_Info.activePower_Total"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_A" type="number"  :value="Terminal_Item_Info.reactivePower_A"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_B" type="number"  :value="Terminal_Item_Info.reactivePower_B"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_C" type="number"  :value="Terminal_Item_Info.reactivePower_C"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">总无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_Total" type="number"  :value="Terminal_Item_Info.reactivePower_Total"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相视在功率</view><view class="formItem_3">KVA</view>
				<view class="formItem_2"><input name="apparentPower_A" type="number"  :value="Terminal_Item_Info.apparentPower_A"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相视在功率</view><view class="formItem_3">KVA</view>
				<view class="formItem_2"><input name="apparentPower_B" type="number"  :value="Terminal_Item_Info.apparentPower_B" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相视在功率</view><view class="formItem_3">KVA</view>
				<view class="formItem_2"><input name="apparentPower_C" type="number"  :value="Terminal_Item_Info.apparentPower_C"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">总视在功率</view><view class="formItem_3">KVA</view>
				<view class="formItem_2"><input name="apparentPower_Total" type="number"  :value="Terminal_Item_Info.apparentPower_Total"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">配变负载率</view><view class="formItem_3">%</view>
				<view class="formItem_2"><input name="distributionLoadRate" type="number"  :value="Terminal_Item_Info.distributionLoadRate" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">电压合格率</view><view class="formItem_3">%</view>
				<view class="formItem_2"><input name="voltagePassRate" type="number"  :value="Terminal_Item_Info.voltagePassRate" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">温湿度</view><view class="formItem_3">℃</view>
				<view class="formItem_2"><input name="humiture" type="number"   :value="Terminal_Item_Info.humiture"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">环境瓦斯浓度</view><view class="formItem_3">%</view>
				<view class="formItem_2"><input name="gasConcentration" type="number"  :value="Terminal_Item_Info.gasConcentration"></view>
			</view>
			
			
		</form>
		<!-- 表单--4熔断器 -->
		<form @submit="formSubmit" @reset="formReset" id="Form_Fuse" :style="FuseFormStyle">
			<view>
				<view class="" style="display: inline-block;width: 60%;margin-bottom: 10rpx;">
					<text class="text">熔断器</text>
				</view>
				<image class="icon" src="../../static/close.png"  @click="formCancel" mode=""></image>
			</view>
			<view class="formItem">
				<view class="formItem_1">设备标号</view>
				<view class="formItem_2"><input name="sign" type="number" :value="Fuse_Item_Info.sign"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">所属侧</view>
				<view style="width: 40%;height: 50rpx;float: left;margin: 5rpx;">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					ref="areaName_Fuse" :value="Fuse_Item_Info.areaName" >
						<option  value="中压侧">中压侧</option>
						<option  value="配变侧">配变侧</option>
						<option  value="低压侧">低压侧</option>
						<option  value="线路侧">线路侧</option>
						<option  value="用户侧">用户侧</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage" type="number" :value="Fuse_Item_Info.voltage"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current" type="number" :value="Fuse_Item_Info.current" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">开关</view>
				<view class="formItem_2">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					 @click="ceSelect" ref="switchState_Fuse" id="switchState_Fuse" :value="Fuse_Item_Info.switchState">
						<option  value="合闸">合闸</option>
						<option  value="分闸">分闸</option>
					</select>
				</view>
			</view>
			<!-- <view style="width: 100%;">
				<button form-type="submit" class="formBtn">添加</button>
				<button form-type="reset" class="formBtn">重置</button>
			</view> -->
			
		</form>
		<!-- 表单--5智能智能开关 -->
		<form @submit="formSubmit" @reset="formReset" id="Form_IntelligentSwitch" :style="IntelligentSwitchFormStyle">
			<view>
				<view class="" style="display: inline-block;width: 60%;margin-bottom: 10rpx;">
					<text class="text">智能智能开关</text>
				</view>
				<image class="icon" src="../../static/close.png"  @click="formCancel" mode=""></image>
			</view>
			<view class="formItem">
				<view class="formItem_1">设备标号</view>
				<view class="formItem_2"><input name="sign" type="number" :value="IntelligentSwitch_Item_Info.sign"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">所属侧</view>
				<view style="width: 40%;height: 50rpx;float: left;margin: 5rpx;">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					 ref="areaName_IntelligentSwitch" :value="IntelligentSwitch_Item_Info.areaName">
						<option  value="中压侧">中压侧</option>
						<option  value="配变侧">配变侧</option>
						<option  value="低压侧">低压侧</option>
						<option  value="线路侧">线路侧</option>
						<option  value="用户侧">用户侧</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_A" type="number" :value="IntelligentSwitch_Item_Info.voltage_A"></view>
				
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_B" type="number" :value="IntelligentSwitch_Item_Info.voltage_B" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_C" type="number" :value="IntelligentSwitch_Item_Info.voltage_C"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_A" type="number"  :value="IntelligentSwitch_Item_Info.current_A"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_B" type="number"  :value="IntelligentSwitch_Item_Info.current_B" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_C" type="number" :value="IntelligentSwitch_Item_Info.current_C"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">分接头档位</view>
				<view class="formItem_2">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					 @click="ceSelect" ref="switchState_IntelligentSwitch" :value="IntelligentSwitch_Item_Info.switchState">
						<option  value="合闸">合闸</option>
						<option  value="分闸">分闸</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">触头温度</view><view class="formItem_3">℃</view>
				<view class="formItem_2"><input name="contactTemperature" type="number" :value="IntelligentSwitch_Item_Info.contactTemperature"></view>
			</view>

			
		</form>
		<!-- 表单--7LTU开关 -->
		<form @submit="formSubmit" @reset="formReset" id="Form_LTUSwitch" :style="LTUSwitchFormStyle">
			<view>
				<view class="" style="display: inline-block;width: 60%;margin-bottom: 10rpx;">
					<text class="text">LTU开关</text>
				</view>
				<image class="icon" src="../../static/close.png"  @click="formCancel" mode=""></image>
			
			</view>
			<view class="formItem">
				<view class="formItem_1">设备标号</view>
				<view class="formItem_2"><input name="sign" type="number" :value="LTUSwitch_Item_Info.sign" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">所属侧</view>
				<view style="width: 40%;height: 50rpx;float: left;margin: 5rpx;">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					 ref="areaName_LTUSwitch" :value="LTUSwitch_Item_Info.areaName" >
						<option  value="中压侧">中压侧</option>
						<option  value="配变侧">配变侧</option>
						<option  value="低压侧">低压侧</option>
						<option  value="线路侧">线路侧</option>
						<option  value="用户侧">用户侧</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_A" type="number" :value="LTUSwitch_Item_Info.voltage_A" ></view>
				
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_B" type="number" :value="LTUSwitch_Item_Info.voltage_B" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_C" type="number" :value="LTUSwitch_Item_Info.voltage_C"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_A" type="number"  :value="LTUSwitch_Item_Info.current_A"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_B" type="number"  :value="LTUSwitch_Item_Info.current_B"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_C" type="number" :value="LTUSwitch_Item_Info.current_C"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">分接头档位</view>
				<view class="formItem_2">
					<select style="height: 50rpx;float: left;border-radius: 10rpx;"
					 ref="switchState_LTUSwitch" :value="LTUSwitch_Item_Info.switchState">
						<option  value="合闸">合闸</option>
						<option  value="分闸">分闸</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">触头温度</view><view class="formItem_3">℃</view>
				<view class="formItem_2"><input name="contactTemperature" type="number" :value="LTUSwitch_Item_Info.contactTemperature"></view>
			</view>
		
		</form>
		<!-- 表单--6单相表 -->
		<form @submit="formSubmit" @reset="formReset" id="Form_UniphaseMeter" :style="UniphaseMeterFormStyle">
			<view>
				<view class="" style="display: inline-block;width: 60%;margin-bottom: 10rpx;">
					<text class="text">单相表</text>
				</view>
				<image class="icon" src="../../static/close.png"  @click="formCancel" mode=""></image>
		
			</view>
			<view class="formItem">
				<view class="formItem_1">设备标号</view>
				<view class="formItem_2"><input name="sign" type="number" :value="UniphaseMeter_Item_Info.sign" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">所属侧</view>
				<view style="width: 40%;height: 50rpx;float: left;margin: 5rpx;">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					 ref="areaName_UniphaseMeter" :value="UniphaseMeter_Item_Info.areaName">
						<option  value="中压侧">中压侧</option>
						<option  value="配变侧">配变侧</option>
						<option  value="低压侧">低压侧</option>
						<option  value="线路侧">线路侧</option>
						<option  value="用户侧">用户侧</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">电压</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="voltage" type="number" :value="UniphaseMeter_Item_Info.voltage"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current" type="number" :value="UniphaseMeter_Item_Info.current"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="power" type="number" :value="UniphaseMeter_Item_Info.power"></view>
			</view>
			<!-- <view style="width: 100%;">
				<button form-type="submit" class="formBtn">添加</button>
				<button form-type="reset" class="formBtn">重置</button>
			</view>
			 -->
		</form>
		<!-- 表单--8换相开关 -->
		<form @submit="formSubmit" @reset="formReset" id="Form_ChangePhaseSwitch" :style="ChangePhaseSwitchFormStyle">
			<view>
				<view class="" style="display: inline-block;width: 60%;margin-bottom: 10rpx;">
					<text class="text">换相开关</text>
				</view>
				<image class="icon" src="../../static/close.png"  @click="formCancel" mode=""></image>
		
			</view>
			<view class="formItem">
				<view class="formItem_1">设备标号</view>
				<view class="formItem_2"><input name="sign" type="number" :value="ChangePhaseSwitch_Item_Info.sign"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">所属侧</view>
				<view style="width: 40%;height: 50rpx;float: left;margin: 5rpx;">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					 ref="areaName_ChangePhaseSwitch" :value="ChangePhaseSwitch_Item_Info.areaName">
						<option  value="中压侧">中压侧</option>
						<option  value="配变侧">配变侧</option>
						<option  value="低压侧">低压侧</option>
						<option  value="线路侧">线路侧</option>
						<option  value="用户侧">用户侧</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_A" type="number" :value="ChangePhaseSwitch_Item_Info.voltage_A"></view>
				
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_A" type="number"  :value="ChangePhaseSwitch_Item_Info.current_A"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_B" type="number" :value="ChangePhaseSwitch_Item_Info.voltage_B"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_B" type="number" :value="ChangePhaseSwitch_Item_Info.current_B"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_C" type="number" :value="ChangePhaseSwitch_Item_Info.voltage_C"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_C" type="number" :value="ChangePhaseSwitch_Item_Info.current_C"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">换相开关</view>
				<view class="formItem_2">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					 @click="ceSelect" ref="switchState_ChangePhaseSwitch" :value="ChangePhaseSwitch_Item_Info.switchState">
						<option  value="合闸">合闸</option>
						<option  value="分闸">分闸</option>
					</select>
				</view>
			</view>
			
			<!-- <view style="width: 100%;">
				<button form-type="submit" class="formBtn">添加</button>
				<button form-type="reset" class="formBtn">重置</button>
			</view> -->
		</form>
		<!-- 表单--9电动汽车充电设施 -->
		<form @submit="formSubmit" @reset="formReset" id="Form_ChargingFacility" :style="ChargingFacilityFormStyle">
			<view>
				<view class="" style="display: inline-block;width: 60%;margin-bottom: 10rpx;">
					<text class="text">电动汽车充电设施</text>
				</view>
				<image class="icon" src="../../static/close.png"  @click="formCancel" mode=""></image>
			</view>
			<view class="formItem">
				<view class="formItem_1">设备标号</view>
				<view class="formItem_2"><input name="sign" type="number" :value="ChargingFacility_Item_Info.sign"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">所属侧</view>
				<view style="width: 40%;height: 50rpx;float: left;margin: 5rpx;">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					 ref="areaName_ChargingFacility" :value="ChargingFacility_Item_Info.areaName">
						<option  value="中压侧">中压侧</option>
						<option  value="配变侧">配变侧</option>
						<option  value="低压侧">低压侧</option>
						<option  value="线路侧">线路侧</option>
						<option  value="用户侧">用户侧</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_A" type="number" :value="ChargingFacility_Item_Info.voltage_A"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_B" type="number" :value="ChargingFacility_Item_Info.voltage_B"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_C" type="number" :value="ChargingFacility_Item_Info.voltage_C"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_A" type="number"  :value="ChargingFacility_Item_Info.current_A"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_B" type="number" :value="ChargingFacility_Item_Info.current_B"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_C" type="number" :value="ChargingFacility_Item_Info.current_C"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_A" type="number" :value="ChargingFacility_Item_Info.activePower_A"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_B" type="number" :value="ChargingFacility_Item_Info.activePower_B"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_C" type="number" :value="ChargingFacility_Item_Info.activePower_C"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">总有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_Total" type="number" :value="ChargingFacility_Item_Info.activePower_Total"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_A" type="number" :value="ChargingFacility_Item_Info.reactivePower_A"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_B" type="number" :value="ChargingFacility_Item_Info.reactivePower_B"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_C" type="number" :value="ChargingFacility_Item_Info.reactivePower_C"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">总无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_Total" type="number" :value="ChargingFacility_Item_Info.reactivePower_Total"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">正向有功总电能示值</view><view class="formItem_3">kWh</view>
				<view class="formItem_2"><input name="totalEnergyValue_PositiveActive" type="number" :value="ChargingFacility_Item_Info.totalEnergyValue_PositiveActive"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">正向无功总电能示值</view><view class="formItem_3">kvarh</view>
				<view class="formItem_2"><input name="totalEnergyValue_PositiveReactive" type="number" :value="ChargingFacility_Item_Info.totalEnergyValue_PositiveReactive" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">反向有功总电能示值</view><view class="formItem_3">kWh</view>
				<view class="formItem_2"><input name="totalEnergyValue_NegativeActive" type="number" :value="ChargingFacility_Item_Info.totalEnergyValue_NegativeActive"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">反向无功总电能示值</view><view class="formItem_3">kvarh</view>
				<view class="formItem_2"><input name="totalEnergyValue_NegativeReactive" type="number" :value="ChargingFacility_Item_Info.totalEnergyValue_NegativeReactive"></view>
			</view>
			
			
			<view class="formItem">
				<view class="formItem_1">功率因数</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="powerFactor" type="number" :value="ChargingFacility_Item_Info.powerFactor"></view>
			</view>
			
			
		<!-- 	
			<view style="width: 100%;">
				<button form-type="submit" class="formBtn">添加</button>
				<button form-type="reset" class="formBtn">重置</button>
			</view> -->
		</form>
		<!-- 表单--10光伏用户 -->
		<form @submit="formSubmit" @reset="formReset" id="Form_PvUser" :style="PvUserFormStyle">
			<view>
				<view class="" style="display: inline-block;width: 60%;margin-bottom: 10rpx;">
					<text class="text">光伏用户</text>
				</view>
				<image class="icon" src="../../static/close.png"  @click="formCancel" mode=""></image>
			
			</view>
			<view class="formItem">
				<view class="formItem_1">设备标号</view>
				<view class="formItem_2"><input name="sign" type="number" :value="PvUser_Item_Info.sign"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">所属侧</view>
				<view style="width: 40%;height: 50rpx;float: left;margin: 5rpx;">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					 ref="areaName_PvUser" :value="PvUser_Item_Info.areaName">
						<option  value="中压侧">中压侧</option>
						<option  value="配变侧">配变侧</option>
						<option  value="低压侧">低压侧</option>
						<option  value="线路侧">线路侧</option>
						<option  value="用户侧">用户侧</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">光伏板电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage" type="number" :value="PvUser_Item_Info.voltage"></view>
				
			</view>
			<view class="formItem">
				<view class="formItem_1">光伏板电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current" type="number"  :value="PvUser_Item_Info.current"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">光伏板功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="power" type="number"  :value="PvUser_Item_Info.power"></view>
			</view>
			
			<!-- <view style="width: 100%;">
				<button form-type="submit" class="formBtn">添加</button>
				<button form-type="reset" class="formBtn">重置</button>
			</view> -->
		</form>
		<!-- 表单--11无功补偿装置 -->
		<form @submit="formSubmit" @reset="formReset" id="Form_CompensationDevice" :style="CompensationDeviceFormStyle">
			<view>
				<view class="" style="display: inline-block;width: 60%;margin-bottom: 10rpx;">
					<text class="text">无功补偿装置</text>
				</view>
				<image class="icon" src="../../static/close.png"  @click="formCancel" mode=""></image>
			</view>
			<view class="formItem">
				<view class="formItem_1">设备标号</view>
				<view class="formItem_2"><input name="sign" type="number" :value="CompensationDevice_Item_Info.sign"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">所属侧</view>
				<view style="width: 40%;height: 50rpx;float: left;margin: 5rpx;">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					 ref="areaName_CompensationDevice" :value="CompensationDevice_Item_Info.areaName">
						<option  value="中压侧">中压侧</option>
						<option  value="配变侧">配变侧</option>
						<option  value="低压侧">低压侧</option>
						<option  value="线路侧">线路侧</option>
						<option  value="用户侧">用户侧</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_A" type="number" :value="CompensationDevice_Item_Info.voltage_A"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_B" type="number" :value="CompensationDevice_Item_Info.voltage_B"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_C" type="number" :value="CompensationDevice_Item_Info.voltage_C"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">AB相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_AB" type="number" :value="CompensationDevice_Item_Info.voltage_AB"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">BC相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_BC" type="number" :value="CompensationDevice_Item_Info.voltage_BC"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">CA相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_CA" type="number" :value="CompensationDevice_Item_Info.voltage_CA"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_A" type="number"  :value="CompensationDevice_Item_Info.current_A"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_B" type="number" :value="CompensationDevice_Item_Info.current_B"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_C" type="number" :value="CompensationDevice_Item_Info.current_C"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_A" type="number" :value="CompensationDevice_Item_Info.activePower_A"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_B" type="number" :value="CompensationDevice_Item_Info.activePower_B"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_C" type="number" :value="CompensationDevice_Item_Info.activePower_C"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">总有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_Total" type="number" :value="CompensationDevice_Item_Info.activePower_Total"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_A" type="number" :value="CompensationDevice_Item_Info.reactivePower_A"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_B" type="number" :value="CompensationDevice_Item_Info.reactivePower_B"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_C" type="number" :value="CompensationDevice_Item_Info.reactivePower_C"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">总无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_Total" type="number" :value="CompensationDevice_Item_Info.reactivePower_Total"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相功率因数</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="powerFactor_A" type="number" :value="CompensationDevice_Item_Info.powerFactor_A"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相功率因数</view><view class="formItem_3">KVA</view>
				<view class="formItem_2"><input name="powerFactor_B" type="number" :value="CompensationDevice_Item_Info.powerFactor_B"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相功率因数</view><view class="formItem_3">KVA</view>
				<view class="formItem_2"><input name="powerFactor_C" type="number" :value="CompensationDevice_Item_Info.powerFactor_C"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">总相功率因数</view><view class="formItem_3">KVA</view>
				<view class="formItem_2"><input name="powerFactor_Total" type="number" :value="CompensationDevice_Item_Info.powerFactor_Total"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">额定容量</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="ratedCapacity" type="number" :value="CompensationDevice_Item_Info.ratedCapacity"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">投切状态</view><view class="formItem_3"></view>
				<view class="formItem_2">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					 @click="ceSelect" ref="cuttingState" id="cuttingState" :value="CompensationDevice_Item_Info.cuttingState">
						<option  value="运行">运行</option>
						<option  value="停止">停止</option>
					</select>
				</view>
			</view>
			<!-- <view style="width: 100%;">
				<button form-type="submit" class="formBtn">添加</button>
			<button form-type="reset" class="formBtn">重置</button>
			</view> -->
			
		</form>
		<!-- 表单--13三相表 -->
		<form @submit="formSubmit" @reset="formReset" id="Form_ThreePhaseMeter" :style="ThreePhaseMeterFormStyle">
			<view>
				<view class="" style="display: inline-block;width: 60%;margin-bottom: 10rpx;">
					<text class="text">三相表</text>
				</view>
				<image class="icon" src="../../static/close.png"  @click="formCancel" mode=""></image>
				
			</view>
			<view class="formItem">
				<view class="formItem_1">设备标号</view>
				<view class="formItem_2"><input name="sign" type="number" :value="ThreePhaseMeter_Item_Info.sign" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">所属侧</view>
				<view style="width: 40%;height: 50rpx;float: left;margin: 5rpx;">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					 ref="areaName_ThreePhaseMeter" :value="ThreePhaseMeter_Item_Info.areaName">
						<option  value="中压侧">中压侧</option>
						<option  value="配变侧">配变侧</option>
						<option  value="低压侧">低压侧</option>
						<option  value="线路侧">线路侧</option>
						<option  value="用户侧">用户侧</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_A" type="number" :value="ThreePhaseMeter_Item_Info.voltage_A"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_B" type="number" :value="ThreePhaseMeter_Item_Info.voltage_B"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_C" type="number" :value="ThreePhaseMeter_Item_Info.voltage_C"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_A" type="number"  :value="ThreePhaseMeter_Item_Info.current_A"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_B" type="number" :value="ThreePhaseMeter_Item_Info.current_B"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_C" type="number" :value="ThreePhaseMeter_Item_Info.current_C"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_A" type="number" :value="ThreePhaseMeter_Item_Info.activePower_A"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_B" type="number" :value="ThreePhaseMeter_Item_Info.activePower_B"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_C" type="number" :value="ThreePhaseMeter_Item_Info.activePower_C"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">总有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_Total" type="number" :value="ThreePhaseMeter_Item_Info.activePower_Total"></view>
			</view>
			
			
			<!-- <button form-type="submit" class="formBtn">添加</button>
			<button form-type="reset" class="formBtn">重置</button> -->
		</form>
		<!-- 表单--12电缆感知设备 -->
		<form @submit="formSubmit" @reset="formReset" id="Form_CableSensingDevice" :style="CableSensingDeviceFormStyle">
			<view>
				<view class="" style="display: inline-block;width: 60%;margin-bottom: 10rpx;">
					<text class="text">电缆感知设备</text>
				</view>
				<image class="icon" src="../../static/close.png"  @click="formCancel" mode=""></image>
			<!-- 	<image class="icon_add" src="../../static/addDevice.png" @click="addDevice" mode=""></image>
				<image class="icon_del" src="../../static/del.png" @click="delDevice" mode=""></image> -->
			</view>
			<view class="formItem">
				<view class="formItem_1">设备标号</view>
				<view class="formItem_2"><input name="sign" type="number" :value="CableSensingDevice_Item_Info.sign"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">所属侧</view>
				<view style="width: 40%;height: 50rpx;float: left;margin: 5rpx;">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					  ref="areaName_CableSensingDevice" :value="CableSensingDevice_Item_Info.areaName">
						<option  value="中压侧">中压侧</option>
						<option  value="配变侧">配变侧</option>
						<option  value="低压侧">低压侧</option>
						<option  value="线路侧">线路侧</option>
						<option  value="用户侧">用户侧</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">温度</view><view class="formItem_3">℃</view>
				<view class="formItem_2"><input name="temperature" type="number" :value="CableSensingDevice_Item_Info.temperature"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">有害气体</view><view class="formItem_3"></view>
				<view class="formItem_2"><input name="harmfulGas" type="text" :value="CableSensingDevice_Item_Info.harmfulGas"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">可燃气体</view><view class="formItem_3"></view>
				<view class="formItem_2"><input name="combustibleGas" type="text" :value="CableSensingDevice_Item_Info.combustibleGas"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">位移</view><view class="formItem_3">cm</view>
				<view class="formItem_2"><input name="displacement" type="number" :value="CableSensingDevice_Item_Info.displacement"></view>
			</view>
			<!-- <button form-type="submit" class="formBtn">添加</button>
			<button form-type="reset" class="formBtn">重置</button> -->
		</form>
		<!--  -->
		<!--  -->
		<!--  -->
		<!-- 表单（添加）-->
		<!-- 表单--1智能变压器 -->
		<form @submit="formAddSubmit" @reset="formReset"  :style="TransformerFormStyle_add">
			<view style="width: 100%;display: block;">
				<text class="text" style="display: block;width: 60%;margin-bottom: 15rpx;">智能变压器</text>
				<image class="icon" src="../../static/close.png"  @click="formCancel" mode=""></image>
			</view>
			<view class="formItem">
				<view class="formItem_1">设备标号</view>
				<view class="formItem_2"><input name="sign" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">所属侧</view>
				<view style="width: 40%;height: 50rpx;float: left;margin: 5rpx;">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					 ref="areaName_Transformer_add" >
						<option  value="中压侧">中压侧</option>
						<option  value="配变侧">配变侧</option>
						<option  value="低压侧">低压侧</option>
						<option  value="线路侧">线路侧</option>
						<option  value="用户侧">用户侧</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_A" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_B" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_C" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">AB线电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_AB" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">BC线电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_BC" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">CA线电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_CA" type="number"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_A" type="number"  ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_B" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_C" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">分接头档位</view>
				<view class="formItem_2">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					 @click="ceSelect" ref="switchState_Transformer_add">
						<option  value="合闸">合闸</option>
						<option  value="分闸">分闸</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">桩头温度</view><view class="formItem_3">℃</view>
				<view class="formItem_2"><input name="poleTemperature" type="number"></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">油温</view><view class="formItem_3">℃</view>
				<view class="formItem_2"><input name="oilTemperature" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">内部压力</view><view class="formItem_3">P</view>
				<view class="formItem_2"><input name="insidePressure" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">油位</view><view class="formItem_3">cm</view>
				<view class="formItem_2"><input name="oilPosition" type="number" ></view>
			</view>

		</form>
		<!-- 表单--2智能环境传感器 -->
		<form @submit="formAddSubmit" @reset="formReset" :style="EvSensorFormStyle_add">
			<view style="width: 100%;display: block;">
				<text class="text" style="display: block;width: 60%;margin-bottom: 15rpx;">智能环境传感器</text>
				<image class="icon" src="../../static/close.png"  @click="formCancel" mode=""></image>
			</view>
			<view class="formItem">
				<view class="formItem_1">设备标号</view>
				<view class="formItem_2"><input name="sign" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">所属侧</view>
				<view style="width: 40%;height: 50rpx;float: left;margin: 5rpx;">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					 ref="areaName_EvSensor_add" >
						<option  value="中压侧">中压侧</option>
						<option  value="配变侧">配变侧</option>
						<option  value="低压侧">低压侧</option>
						<option  value="线路侧">线路侧</option>
						<option  value="用户侧">用户侧</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">温度</view><view class="formItem_3">℃</view>
				<view class="formItem_2"><input name="temperature" type="number" ></view>
				
			</view>
			<view class="formItem">
				<view class="formItem_1">湿度</view><view class="formItem_3">℃</view>
				<view class="formItem_2"><input name="humidity" type="number" ></view>
			</view>
			
			<button form-type="submit" class="formBtn">添加</button>
			<button form-type="reset" class="formBtn">重置</button>
		</form>
		<!-- 表单--3台区总表 -->
		<form @submit="formAddSubmit" @reset="formReset" :style="AreaMeterFormStyle_add">
			<view style="width: 100%;display: block;">
				<text class="text" style="display: block;width: 60%;margin-bottom: 15rpx;">台区总表</text>
				<image class="icon" src="../../static/close.png"  @click="formCancel" mode=""></image>
			</view>
			<view class="formItem">
				<view class="formItem_1">设备标号</view>
				<view class="formItem_2"><input name="sign" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">所属侧</view>
				<view style="width: 40%;height: 50rpx;float: left;margin: 5rpx;">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					 ref="areaName_AreaMeter_add" >
						<option  value="中压侧">中压侧</option>
						<option  value="配变侧">配变侧</option>
						<option  value="低压侧">低压侧</option>
						<option  value="线路侧">线路侧</option>
						<option  value="用户侧">用户侧</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_A" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_B" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_C" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_A" type="number"  ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_B" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_C" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_A" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_B" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_C" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">总有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_Total" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_A" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_B" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_C" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">总无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_Total" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相视在功率</view><view class="formItem_3">KVA</view>
				<view class="formItem_2"><input name="apparentPower_A" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相视在功率</view><view class="formItem_3">KVA</view>
				<view class="formItem_2"><input name="apparentPower_B" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相视在功率</view><view class="formItem_3">KVA</view>
				<view class="formItem_2"><input name="apparentPower_C" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">总视在功率</view><view class="formItem_3">KVA</view>
				<view class="formItem_2"><input name="apparentPower_Total" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">配变负载率</view><view class="formItem_3">%</view>
				<view class="formItem_2"><input name="distributionLoadRate" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">电压合格率</view><view class="formItem_3">%</view>
				<view class="formItem_2"><input name="voltagePassRate" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">温湿度</view><view class="formItem_3">℃</view>
				<view class="formItem_2"><input name="humiture" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">环境瓦斯浓度</view><view class="formItem_3">%</view>
				<view class="formItem_2"><input name="gasConcentration" type="number" ></view>
			</view>
			
			<button form-type="submit" class="formBtn">添加</button>
			<button form-type="reset" class="formBtn">重置</button>
		</form>
		<!-- 表单--14智能终端 -->
		<form @submit="formAddSubmit" @reset="formReset" :style="TerminalFormStyle_add">
			<view style="width: 100%;display: block;">
				<text class="text" style="display: block;width: 60%;margin-bottom: 15rpx;">智能终端</text>
				<image class="icon" src="../../static/close.png"  @click="formCancel" mode=""></image>
			</view>
			<view class="formItem">
				<view class="formItem_1">设备标号</view>
				<view class="formItem_2"><input name="sign" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">所属侧</view>
				<view style="width: 40%;height: 50rpx;float: left;margin: 5rpx;">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					 ref="areaName_Terminal_add" >
						<option  value="中压侧">中压侧</option>
						<option  value="配变侧">配变侧</option>
						<option  value="低压侧">低压侧</option>
						<option  value="线路侧">线路侧</option>
						<option  value="用户侧">用户侧</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_A" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_B" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_C" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_A" type="number"  ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_B" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_C" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_A" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_B" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_C" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">总有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_Total" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_A" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_B" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_C" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">总无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_Total" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相视在功率</view><view class="formItem_3">KVA</view>
				<view class="formItem_2"><input name="apparentPower_A" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相视在功率</view><view class="formItem_3">KVA</view>
				<view class="formItem_2"><input name="apparentPower_B" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相视在功率</view><view class="formItem_3">KVA</view>
				<view class="formItem_2"><input name="apparentPower_C" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">总视在功率</view><view class="formItem_3">KVA</view>
				<view class="formItem_2"><input name="apparentPower_Total" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">配变负载率</view><view class="formItem_3">%</view>
				<view class="formItem_2"><input name="distributionLoadRate" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">电压合格率</view><view class="formItem_3">%</view>
				<view class="formItem_2"><input name="voltagePassRate" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">温湿度</view><view class="formItem_3">℃</view>
				<view class="formItem_2"><input name="humiture" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">环境瓦斯浓度</view><view class="formItem_3">%</view>
				<view class="formItem_2"><input name="gasConcentration" type="number" ></view>
			</view>
			
			
			<button form-type="submit" class="formBtn">添加</button>
			<button form-type="reset" class="formBtn">重置</button>
			<button type="default" class="formBtn" @click="formCancel">取消</button>
		</form>
		<!-- 表单--4熔断器 -->
		<form @submit="formAddSubmit" @reset="formReset"  :style="FuseFormStyle_add">
			<view style="width: 100%;display: block;">
				<text class="text" style="display: block;width: 60%;margin-bottom: 15rpx;">熔断器</text>
				<image class="icon" src="../../static/close.png"  @click="formCancel" mode=""></image>
			</view>
			<view class="formItem">
				<view class="formItem_1">设备标号</view>
				<view class="formItem_2"><input name="sign" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">所属侧</view>
				<view style="width: 40%;height: 50rpx;float: left;margin: 5rpx;">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					  ref="areaName_Fuse_add" >
						<option  value="中压侧">中压侧</option>
						<option  value="配变侧">配变侧</option>
						<option  value="低压侧">低压侧</option>
						<option  value="线路侧">线路侧</option>
						<option  value="用户侧">用户侧</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">开关</view>
				<view class="formItem_2">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					 @click="ceSelect" ref="switchState_Fuse_add" >
						<option  value="合闸">合闸</option>
						<option  value="分闸">分闸</option>
					</select>
				</view>
			</view>
			<view style="width: 100%;">
				<button form-type="submit" class="formBtn">添加</button>
				<button form-type="reset" class="formBtn">重置</button>
			</view>
			
		</form>
		<!-- 表单--5智能智能开关 -->
		<form @submit="formAddSubmit" @reset="formReset"  :style="IntelligentSwitchFormStyle_add">
			<view style="width: 100%;display: block;">
				<text class="text" style="display: block;width: 60%;margin-bottom: 15rpx;">智能开关</text>
				<image class="icon" src="../../static/close.png"  @click="formCancel" mode=""></image>
			</view>
			<view class="formItem">
				<view class="formItem_1">设备标号</view>
				<view class="formItem_2"><input name="sign" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">所属侧</view>
				<view style="width: 40%;height: 50rpx;float: left;margin: 5rpx;">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					 ref="areaName_IntelligentSwitch_add" >
						<option  value="中压侧">中压侧</option>
						<option  value="配变侧">配变侧</option>
						<option  value="低压侧">低压侧</option>
						<option  value="线路侧">线路侧</option>
						<option  value="用户侧">用户侧</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_A" type="number" ></view>
				
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_B" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_C" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_A" type="number"  ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_B" type="number"  ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_C" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">分接头档位</view>
				<view class="formItem_2">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					 @click="ceSelect" ref="switchState_IntelligentSwitch_add" >
						<option  value="合闸">合闸</option>
						<option  value="分闸">分闸</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">触头温度</view><view class="formItem_3">℃</view>
				<view class="formItem_2"><input name="contactTemperature" type="number"></view>
			</view>
		
			<button form-type="submit" class="formBtn">添加</button>
			<button form-type="reset" class="formBtn">重置</button>
			<button type="default" class="formBtn" @click="formCancel">取消</button>
		</form>
		<!-- 表单--7LTU开关 -->
		<form @submit="formAddSubmit" @reset="formReset"  :style="LTUSwitchFormStyle_add">
			<view style="width: 100%;display: block;">
				<text class="text" style="display: block;width: 60%;margin-bottom: 15rpx;">LTU开关</text>
				<image class="icon" src="../../static/close.png"  @click="formCancel" mode=""></image>
			</view>
			<view class="formItem">
				<view class="formItem_1">设备标号</view>
				<view class="formItem_2"><input name="sign" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">所属侧</view>
				<view style="width: 40%;height: 50rpx;float: left;margin: 5rpx;">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					 ref="areaName_LTUSwitch_add" >
						<option  value="中压侧">中压侧</option>
						<option  value="配变侧">配变侧</option>
						<option  value="低压侧">低压侧</option>
						<option  value="线路侧">线路侧</option>
						<option  value="用户侧">用户侧</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_A" type="number" ></view>
				
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_B" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_C" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_A" type="number"  ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_B" type="number"  ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_C" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">分接头档位</view>
				<view class="formItem_2">
					<select style="height: 50rpx;float: left;border-radius: 10rpx;"
					 ref="switchState_LTUSwitch_add" >
						<option  value="合闸">合闸</option>
						<option  value="分闸">分闸</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">触头温度</view><view class="formItem_3">℃</view>
				<view class="formItem_2"><input name="contactTemperature" type="number"></view>
			</view>
		
			<button form-type="submit" class="formBtn">添加</button>
			<button form-type="reset" class="formBtn">重置</button>
		</form>
		<!-- 表单--6单相表 -->
		<form @submit="formAddSubmit" @reset="formReset" :style="UniphaseMeterFormStyle_add">
			<view style="width: 100%;display: block;">
				<text class="text" style="display: block;width: 60%;margin-bottom: 15rpx;">单相表</text>
				<image class="icon" src="../../static/close.png"  @click="formCancel" mode=""></image>
			</view>
			<view class="formItem">
				<view class="formItem_1">设备标号</view>
				<view class="formItem_2"><input name="sign" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">所属侧</view>
				<view style="width: 40%;height: 50rpx;float: left;margin: 5rpx;">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					 ref="areaName_UniphaseMeter_add" >
						<option  value="中压侧">中压侧</option>
						<option  value="配变侧">配变侧</option>
						<option  value="低压侧">低压侧</option>
						<option  value="线路侧">线路侧</option>
						<option  value="用户侧">用户侧</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">电压</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="voltage" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="power" type="number" ></view>
			</view>
			<view style="width: 100%;">
				<button form-type="submit" class="formBtn">添加</button>
				<button form-type="reset" class="formBtn">重置</button>
			</view>
			
		</form>
		<!-- 表单--8换相开关 -->
		<form @submit="formAddSubmit" @reset="formReset" :style="ChangePhaseSwitchFormStyle_add">
			<view style="width: 100%;display: block;">
				<text class="text" style="display: block;width: 60%;margin-bottom: 15rpx;">换相开关</text>
				<image class="icon" src="../../static/close.png"  @click="formCancel" mode=""></image>
			</view>
			<view class="formItem">
				<view class="formItem_1">设备标号</view>
				<view class="formItem_2"><input name="sign" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">所属侧</view>
				<view style="width: 40%;height: 50rpx;float: left;margin: 5rpx;">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					 ref="areaName_ChangePhaseSwitch_add" >
						<option  value="中压侧">中压侧</option>
						<option  value="配变侧">配变侧</option>
						<option  value="低压侧">低压侧</option>
						<option  value="线路侧">线路侧</option>
						<option  value="用户侧">用户侧</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_A" type="number" ></view>
				
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_A" type="number"  ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_B" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_B" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_C" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_C" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">换相开关</view>
				<view class="formItem_2">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					 @click="ceSelect" ref="switchState_ChangePhaseSwitch_add" >
						<option  value="合闸">合闸</option>
						<option  value="分闸">分闸</option>
					</select>
				</view>
			</view>
			
			<view style="width: 100%;">
				<button form-type="submit" class="formBtn">添加</button>
				<button form-type="reset" class="formBtn">重置</button>
				<button type="default" class="formBtn" @click="formCancel">取消</button>
			</view>
		</form>
		<!-- 表单--9电动汽车充电设施 -->
		<form @submit="formAddSubmit" @reset="formReset" :style="ChargingFacilityFormStyle_add">
			<view style="width: 100%;display: block;">
				<text class="text" style="display: block;width: 60%;margin-bottom: 15rpx;">电动汽车充电设施</text>
				<image class="icon" src="../../static/close.png"  @click="formCancel" mode=""></image>
			</view>
			<view class="formItem">
				<view class="formItem_1">设备标号</view>
				<view class="formItem_2"><input name="sign" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">所属侧</view>
				<view style="width: 40%;height: 50rpx;float: left;margin: 5rpx;">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					 ref="areaName_ChargingFacility_add" >
						<option  value="中压侧">中压侧</option>
						<option  value="配变侧">配变侧</option>
						<option  value="低压侧">低压侧</option>
						<option  value="线路侧">线路侧</option>
						<option  value="用户侧">用户侧</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_A" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_B" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_C" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_A" type="number"  ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_B" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_C" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_A" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_B" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_C" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">总有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_Total" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_A" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_B" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_C" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">总无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_Total" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">正向有功总电能示值</view><view class="formItem_3">kWh</view>
				<view class="formItem_2"><input name="totalEnergyValue_PositiveActive" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">正向无功总电能示值</view><view class="formItem_3">kvarh</view>
				<view class="formItem_2"><input name="totalEnergyValue_PositiveReactive" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">反向有功总电能示值</view><view class="formItem_3">kWh</view>
				<view class="formItem_2"><input name="totalEnergyValue_NegativeActive" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">反向无功总电能示值</view><view class="formItem_3">kvarh</view>
				<view class="formItem_2"><input name="totalEnergyValue_NegativeReactive" type="number" ></view>
			</view>
			
			
			<view class="formItem">
				<view class="formItem_1">功率因数</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="powerFactor" type="number" ></view>
			</view>
			
			
			
			<view style="width: 100%;">
				<button form-type="submit" class="formBtn">添加</button>
				<button form-type="reset" class="formBtn">重置</button>
			</view>
		</form>
		<!-- 表单--10光伏用户 -->
		<form @submit="formAddSubmit" @reset="formReset"  :style="PvUserFormStyle_add">
			<view style="width: 100%;display: block;">
				<text class="text" style="display: block;width: 60%;margin-bottom: 15rpx;">光伏用户</text>
				<image class="icon" src="../../static/close.png"  @click="formCancel" mode=""></image>
			</view>
			<view class="formItem">
				<view class="formItem_1">设备标号</view>
				<view class="formItem_2"><input name="sign" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">所属侧</view>
				<view style="width: 40%;height: 50rpx;float: left;margin: 5rpx;">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					  ref="areaName_PvUser_add" >
						<option  value="中压侧">中压侧</option>
						<option  value="配变侧">配变侧</option>
						<option  value="低压侧">低压侧</option>
						<option  value="线路侧">线路侧</option>
						<option  value="用户侧">用户侧</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">光伏板电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage" type="number" ></view>
				
			</view>
			<view class="formItem">
				<view class="formItem_1">光伏板电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current" type="number"  ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">光伏板功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="power" type="number"  ></view>
			</view>
			
			<view style="width: 100%;">
				<button form-type="submit" class="formBtn">添加</button>
				<button form-type="reset" class="formBtn">重置</button>
			</view>
		</form>
		<!-- 表单--11无功补偿装置 -->
		<form @submit="formAddSubmit" @reset="formReset" :style="CompensationDeviceFormStyle_add">
			<view style="width: 100%;display: block;">
				<text class="text" style="display: block;width: 60%;margin-bottom: 15rpx;">无功补偿装置</text>
				<image class="icon" src="../../static/close.png"  @click="formCancel" mode=""></image>
			</view>
			<view class="formItem">
				<view class="formItem_1">设备标号</view>
				<view class="formItem_2"><input name="sign" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">所属侧</view>
				<view style="width: 40%;height: 50rpx;float: left;margin: 5rpx;">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					 @click="ceSelect" ref="areaName_CompensationDevice_add" >
						<option  value="中压侧">中压侧</option>
						<option  value="配变侧">配变侧</option>
						<option  value="低压侧">低压侧</option>
						<option  value="线路侧">线路侧</option>
						<option  value="用户侧">用户侧</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_A" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_B" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_C" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">AB相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_AB" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">BC相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_BC" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">CA相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_CA" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_A" type="number"  ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_B" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_C" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_A" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_B" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_C" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">总有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_Total" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_A" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_B" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_C" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">总无功功率</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="reactivePower_Total" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相功率因数</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="powerFactor_A" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相功率因数</view><view class="formItem_3">KVA</view>
				<view class="formItem_2"><input name="powerFactor_B" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相功率因数</view><view class="formItem_3">KVA</view>
				<view class="formItem_2"><input name="powerFactor_C" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">总相功率因数</view><view class="formItem_3">KVA</view>
				<view class="formItem_2"><input name="powerFactor_Total" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">额定容量</view><view class="formItem_3">kVar</view>
				<view class="formItem_2"><input name="ratedCapacity" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">投切状态</view><view class="formItem_3"></view>
				<view class="formItem_2">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					 @click="ceSelect" ref="cuttingState_add" id="cuttingState">
						<option  value="运行">运行</option>
						<option  value="停止">停止</option>
					</select>
				</view>
			</view>
			<view style="width: 100%;">
				<button form-type="submit" class="formBtn">添加</button>
			<button form-type="reset" class="formBtn">重置</button>
			<button type="default" class="formBtn" @click="formCancel">取消</button>
			</view>
			
		</form>
		<!-- 表单--13三相表 -->
		<form @submit="formAddSubmit" @reset="formReset"  :style="ThreePhaseMeterFormStyle_add">
			<view style="width: 100%;display: block;">
				<text class="text" style="display: block;width: 60%;margin-bottom: 15rpx;">三相表</text>
				<image class="icon" src="../../static/close.png"  @click="formCancel" mode=""></image>
			</view>
			<view class="formItem">
				<view class="formItem_1">设备标号</view>
				<view class="formItem_2"><input name="sign" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">所属侧</view>
				<view style="width: 40%;height: 50rpx;float: left;margin: 5rpx;">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					  ref="areaName_ThreePhaseMeter_add" >
						<option  value="中压侧">中压侧</option>
						<option  value="配变侧">配变侧</option>
						<option  value="低压侧">低压侧</option>
						<option  value="线路侧">线路侧</option>
						<option  value="用户侧">用户侧</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_A" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_B" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电压</view><view class="formItem_3">V</view>
				<view class="formItem_2"><input name="voltage_C" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_A" type="number"  ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_B" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相电流</view><view class="formItem_3">A</view>
				<view class="formItem_2"><input name="current_C" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">A相有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_A" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">B相有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_B" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">C相有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_C" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">总有功功率</view><view class="formItem_3">kW</view>
				<view class="formItem_2"><input name="activePower_Total" type="number" ></view>
			</view>
			
			
			<button form-type="submit" class="formBtn">添加</button>
			<button form-type="reset" class="formBtn">重置</button>
		</form>
		<!-- 表单--12电缆感知设备 -->
		<form @submit="formAddSubmit" @reset="formReset"  :style="CableSensingDeviceFormStyle_add">
			<view style="width: 100%;display: block;">
				<text class="text" style="display: block;width: 60%;margin-bottom: 15rpx;">电缆感知设备</text>
				<image class="icon" src="../../static/close.png"  @click="formCancel" mode=""></image>
			</view>
			<view class="formItem">
				<view class="formItem_1">设备标号</view>
				<view class="formItem_2"><input name="sign" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">所属侧</view>
				<view style="width: 40%;height: 50rpx;float: left;margin: 5rpx;">
					<select class="ceSelect" style="height: 50rpx;float: left;border-radius: 10rpx;"
					  ref="areaName_CableSensingDevice_add" >
						<option  value="中压侧">中压侧</option>
						<option  value="配变侧">配变侧</option>
						<option  value="低压侧">低压侧</option>
						<option  value="线路侧">线路侧</option>
						<option  value="用户侧">用户侧</option>
					</select>
				</view>
			</view>
			<view class="formItem">
				<view class="formItem_1">温度</view><view class="formItem_3">℃</view>
				<view class="formItem_2"><input name="temperature" type="number" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">有害气体</view><view class="formItem_3"></view>
				<view class="formItem_2"><input name="harmfulGas" type="text" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">可燃气体</view><view class="formItem_3"></view>
				<view class="formItem_2"><input name="combustibleGas" type="text" ></view>
			</view>
			<view class="formItem">
				<view class="formItem_1">位移</view><view class="formItem_3">cm</view>
				<view class="formItem_2"><input name="displacement" type="number" ></view>
			</view>
			<button form-type="submit" class="formBtn">添加</button>
			<button form-type="reset" class="formBtn">重置</button>
		</form>
		
		
		
		
		
		
		
	</view>
</template>

<script>
	import {config_url} from '../../default/get_url.js'
	export default {
		data() {
			return {
				itemClass_1:"itemClass_1",
				itemClass_2:"itemClass_2",
				srcUrl:"",
				imgStyle:{},
				courtsName:"",
				courtsId:"",
				areaName:"",//选择查看的台区
				deviceName:"",//需要修改的设备
				deviceIndex:"",//需要修改的设备在所在列表中的Index
				deviceId:"",//需要修改的设备Id
				//台区列表
				courtsList:[],
				//表单样式
				EvSensorFormStyle:{display:"none"},
				TransformerFormStyle:{display:"none"},
				AreaMeterFormStyle:{display:"none"},
				FuseFormStyle:{display:"none"},
				IntelligentSwitchFormStyle:{display:"none"},
				UniphaseMeterFormStyle:{display:"none"},
				LTUSwitchFormStyle:{display:"none"},
				ChangePhaseSwitchFormStyle:{display:"none"},
				ChargingFacilityFormStyle:{display:"none"},
				PvUserFormStyle:{display:"none"},
				CompensationDeviceFormStyle:{display:"none"},
				CableSensingDeviceFormStyle:{display:"none"},
				ThreePhaseMeterFormStyle:{display:"none"},
				TerminalFormStyle:{display:"none"},
				//表单（添加）样式
				EvSensorFormStyle_add:{display:"none"},
				TransformerFormStyle_add:{display:"none"},
				AreaMeterFormStyle_add:{display:"none"},
				FuseFormStyle_add:{display:"none"},
				IntelligentSwitchFormStyle_add:{display:"none"},
				UniphaseMeterFormStyle_add:{display:"none"},
				LTUSwitchFormStyle_add:{display:"none"},
				ChangePhaseSwitchFormStyle_add:{display:"none"},
				ChargingFacilityFormStyle_add:{display:"none"},
				PvUserFormStyle_add:{display:"none"},
				CompensationDeviceFormStyle_add:{display:"none"},
				CableSensingDeviceFormStyle_add:{display:"none"},
				ThreePhaseMeterFormStyle_add:{display:"none"},
				TerminalFormStyle_add:{display:"none"},
				
				//设备列表
				Transformer:[],			//1-智能变压器
				EvSensor:[],			//2-智能环境传感器
				AreaMeter:[],			//3-台区总表
				Fuse:[],				//4-熔断器
				IntelligentSwitch:[],	//5-智能开关
				UniphaseMeter:[],		//6-单相表
				LTUSwitch:[],			//7-带低压监测单元的开关
				ChangePhaseSwitch:[],	//8-换相开关
				ChargingFacility:[],	//9-电动汽车充电设施
				PvUser:[],				//10-光伏用户
				CompensationDevice:[],	//11-无偿补偿装置
				CableSensingDevice:[],	//12-电缆感知设备
				ThreePhaseMeter:[],		//13-三相表
				Terminal:[],			//14-智能终端
				//设备列表项
				Transformer_Item_Info:{},
				EvSensor_Item_Info:{},			
				AreaMeter_Item_Info:{},			
				Fuse_Item_Info:{},				
				IntelligentSwitch_Item_Info:{},	
				UniphaseMeter_Item_Info:{}	,	
				LTUSwitch_Item_Info:{},			
				ChangePhaseSwitch_Item_Info:{},	
				ChargingFacility_Item_Info:{},	
				PvUser_Item_Info:{},				
				CompensationDevice_Item_Info:{},	
				CableSensingDevice_Item_Info:{},	
				ThreePhaseMeter_Item_Info:{},		
				Terminal_Item_Info:{},			
				
				
				
			}
		},
		methods: {
			tapImg(e){
				let that =this;
				uni.previewImage({
				  urls: [that.srcUrl], // 需要预览的图片http链接列表
				  current: 0, // 当前显示图片的http链接
					longPressActions: {
				 		itemList: ['保存图片'] //长按预览图片时显示的操作菜单
				 	}
				})
			},
			courtsSelect(e){
				let that =this;
				if(this.$refs.courtsId.value!=""){
					uni.request({
						
						url: config_url.baseurl + 'findAllDeviceByCourtsId', 
						data: {//参数
							courtsId: this.$refs.courtsId.value
						},
						dataType:'json',
						method:'POST',//请求方式  或GET，必须为大写
						header: {
							'Access-Control-Allow-Credentials':true,
							'Access-Control-Allow-Origin':'http://localhost:8080/#/',
							'Content-type':'application/x-www-form-urlencoded'
						},
						success(res){
							that.srcUrl = config_url.baseurl + "courtsImages/"+res.data.courts.courtsImageUrl;
							uni.getImageInfo({
								src:that.srcUrl,
								success(res) {
									that.imgStyle={"width": res.width*2+"rpx","height": res.height*2+"rpx"}
								}
							})
							that.Transformer=res.data.transformerList;
							that.EvSensor=res.data.evSensorList;
							that.AreaMeter=res.data.areaMeterList;
							that.Fuse=res.data.fuseList;
							that.IntelligentSwitch=res.data.intelligentSwitchList;
							that.UniphaseMeter=res.data.uniphaseMeterList;
							that.LTUSwitch=res.data.ltuSwitchList;
							that.ChangePhaseSwitch=res.data.changePhaseSwitchList;
							that.ChargingFacility=res.data.chargingFacilityList;
							that.PvUser=res.data.pvUserList;
							that.CompensationDevice=res.data.compensationDeviceList;
							that.CableSensingDevice=res.data.cableSensingDeviceList;
							that.ThreePhaseMeter=res.data.threePhaseMeterList;
							that.Terminal=res.data.terminalList;
						}
					
					})
				
				}	
			
			},
		
			test(){
				let that = this
				uni.request({
					url: config_url.baseurl + 'power_distribution/test', 
					data: {//参数
						Transformers:JSON.stringify(that.Transformer),
						EvSensors:  JSON.stringify(that.EvSensor),
						AreaMeters:JSON.stringify(that.AreaMeter),
						Terminals:JSON.stringify(that.Terminal),
						Fuses:JSON.stringify(that.Fuse),
						IntelligentSwitchs:JSON.stringify(that.IntelligentSwitch),
						UniphaseMeters:JSON.stringify(that.UniphaseMeter),
						LTUSwitchs:JSON.stringify(that.LTUSwitch),
						ChangePhaseSwitchs:JSON.stringify(that.ChangePhaseSwitch),
						ChargingFacilitys:JSON.stringify(that.ChargingFacility),
						PvUsers:JSON.stringify(that.PvUser),
						CompensationDevices:JSON.stringify(that.CompensationDevice),
						CableSensingDevices:JSON.stringify(that.CableSensingDevice),
						ThreePhaseMeters:JSON.stringify(that.ThreePhaseMeter)
					},
					dataType:'json',
					method:'POST',//请求方式  或GET，必须为大写
					header: {
						'Access-Control-Allow-Credentials':true,
						'Access-Control-Allow-Origin':'http://localhost:8080/#/',
						'Content-type':'application/x-www-form-urlencoded'
					},
					success(res) {
					},
					fail(res) {
						
					}
				})
			},
			
			//判断选择的是那哪个设备，并给出相应的表单
			deviceSelect(e){
				if(this.$refs.deviceName.value==""){
					this.TransformerFormStyle_add.display="none";
					this.EvSensorFormStyle_add.display="none"
					this.AreaMeterFormStyle_add.display="none"
					this.FuseFormStyle_add.display="none"
					this.IntelligentSwitchFormStyle_add.display="none"
					this.UniphaseMeterFormStyle_add.display="none"
					this.LTUSwitchFormStyle_add.display="none"
					this.ChangePhaseSwitchFormStyle_add.display="none"
					this.ChargingFacilityFormStyle_add.display="none"
					this.PvUserFormStyle_add.display="none"
					this.CompensationDeviceFormStyle_add.display="none"
					this.CableSensingDeviceFormStyle_add.display="none"
					this.ThreePhaseMeterFormStyle_add.display="none"
					this.TerminalFormStyle_add.display="none"
				}else if(this.$refs.deviceName.value=="智能变压器"){// document.getElementById("deviceName").value)
					this.TransformerFormStyle_add.display="block";
					this.EvSensorFormStyle_add.display="none"
				    this.AreaMeterFormStyle_add.display="none"
				    this.FuseFormStyle_add.display="none"
				    this.IntelligentSwitchFormStyle_add.display="none"
				    this.UniphaseMeterFormStyle_add.display="none"
				    this.LTUSwitchFormStyle_add.display="none"
				    this.ChangePhaseSwitchFormStyle_add.display="none"
				    this.ChargingFacilityFormStyle_add.display="none"
				    this.PvUserFormStyle_add.display="none"
				    this.CompensationDeviceFormStyle_add.display="none"
				    this.CableSensingDeviceFormStyle_add.display="none"
				    this.ThreePhaseMeterFormStyle_add.display="none"
				    this.TerminalFormStyle_add.display="none"
				}else if(this.$refs.deviceName.value=="智能环境传感器"){
					this.TransformerFormStyle_add.display="none";
					this.EvSensorFormStyle_add.display="block"
					this.AreaMeterFormStyle_add.display="none"
					this.FuseFormStyle_add.display="none"
					this.IntelligentSwitchFormStyle_add.display="none"
					this.UniphaseMeterFormStyle_add.display="none"
					this.LTUSwitchFormStyle_add.display="none"
					this.ChangePhaseSwitchFormStyle_add.display="none"
					this.ChargingFacilityFormStyle_add.display="none"
					this.PvUserFormStyle_add.display="none"
					this.CompensationDeviceFormStyle_add.display="none"
					this.CableSensingDeviceFormStyle_add.display="none"
					this.ThreePhaseMeterFormStyle_add.display="none"
					this.TerminalFormStyle_add.display="none"
				}else if(this.$refs.deviceName.value=="台区总表"){
					this.TransformerFormStyle_add.display="none";
					this.EvSensorFormStyle_add.display="none"
					this.AreaMeterFormStyle_add.display="block"
					this.FuseFormStyle_add.display="none"
					this.IntelligentSwitchFormStyle_add.display="none"
					this.UniphaseMeterFormStyle_add.display="none"
					this.LTUSwitchFormStyle_add.display="none"
					this.ChangePhaseSwitchFormStyle_add.display="none"
					this.ChargingFacilityFormStyle_add.display="none"
					this.PvUserFormStyle_add.display="none"
					this.CompensationDeviceFormStyle_add.display="none"
					this.CableSensingDeviceFormStyle_add.display="none"
					this.ThreePhaseMeterFormStyle_add.display="none"
					this.TerminalFormStyle_add.display="none"
				}else if(this.$refs.deviceName.value=="熔断器"){
					this.TransformerFormStyle_add.display="none";
					this.EvSensorFormStyle_add.display="none"
					this.AreaMeterFormStyle_add.display="none"
					this.FuseFormStyle_add.display="block"
					this.IntelligentSwitchFormStyle_add.display="none"
					this.UniphaseMeterFormStyle_add.display="none"
					this.LTUSwitchFormStyle_add.display="none"
					this.ChangePhaseSwitchFormStyle_add.display="none"
					this.ChargingFacilityFormStyle_add.display="none"
					this.PvUserFormStyle_add.display="none"
					this.CompensationDeviceFormStyle_add.display="none"
					this.CableSensingDeviceFormStyle_add.display="none"
					this.ThreePhaseMeterFormStyle_add.display="none"
					this.TerminalFormStyle_add.display="none"
				}else if(this.$refs.deviceName.value=="智能开关"){
					this.TransformerFormStyle_add.display="none";
					this.EvSensorFormStyle_add.display="none"
					this.AreaMeterFormStyle_add.display="none"
					this.FuseFormStyle_add.display="none"
					this.IntelligentSwitchFormStyle_add.display="block"
					this.UniphaseMeterFormStyle_add.display="none"
					this.LTUSwitchFormStyle_add.display="none"
					this.ChangePhaseSwitchFormStyle_add.display="none"
					this.ChargingFacilityFormStyle_add.display="none"
					this.PvUserFormStyle_add.display="none"
					this.CompensationDeviceFormStyle_add.display="none"
					this.CableSensingDeviceFormStyle_add.display="none"
					this.ThreePhaseMeterFormStyle_add.display="none"
					this.TerminalFormStyle_add.display="none"
				}else if(this.$refs.deviceName.value=="单相表"){
					this.TransformerFormStyle_add.display="none";
					this.EvSensorFormStyle_add.display="none"
					this.AreaMeterFormStyle_add.display="none"
					this.FuseFormStyle_add.display="none"
					this.IntelligentSwitchFormStyle_add.display="none"
					this.UniphaseMeterFormStyle_add.display="block"
					this.LTUSwitchFormStyle_add.display="none"
					this.ChangePhaseSwitchFormStyle_add.display="none"
					this.ChargingFacilityFormStyle_add.display="none"
					this.PvUserFormStyle_add.display="none"
					this.CompensationDeviceFormStyle_add.display="none"
					this.CableSensingDeviceFormStyle_add.display="none"
					this.ThreePhaseMeterFormStyle_add.display="none"
					this.TerminalFormStyle_add.display="none"
				}else if(this.$refs.deviceName.value=="LTU开关"){
					this.TransformerFormStyle_add.display="none";
					this.EvSensorFormStyle_add.display="none"
					this.AreaMeterFormStyle_add.display="none"
					this.FuseFormStyle_add.display="none"
					this.IntelligentSwitchFormStyle_add.display="none"
					this.UniphaseMeterFormStyle_add.display="none"
					this.LTUSwitchFormStyle_add.display="block"
					this.ChangePhaseSwitchFormStyle_add.display="none"
					this.ChargingFacilityFormStyle_add.display="none"
					this.PvUserFormStyle_add.display="none"
					this.CompensationDeviceFormStyle_add.display="none"
					this.CableSensingDeviceFormStyle_add.display="none"
					this.ThreePhaseMeterFormStyle_add.display="none"
					this.TerminalFormStyle_add.display="none"
				}else if(this.$refs.deviceName.value=="换相开关"){
					this.TransformerFormStyle_add.display="none";
					this.EvSensorFormStyle_add.display="none"
					this.AreaMeterFormStyle_add.display="none"
					this.FuseFormStyle_add.display="none"
					this.IntelligentSwitchFormStyle_add.display="none"
					this.UniphaseMeterFormStyle_add.display="none"
					this.LTUSwitchFormStyle_add.display="none"
					this.ChangePhaseSwitchFormStyle_add.display="block"
					this.ChargingFacilityFormStyle_add.display="none"
					this.PvUserFormStyle_add.display="none"
					this.CompensationDeviceFormStyle_add.display="none"
					this.CableSensingDeviceFormStyle_add.display="none"
					this.ThreePhaseMeterFormStyle_add.display="none"
					this.TerminalFormStyle_add.display="none"
				}else if(this.$refs.deviceName.value=="电动汽车充电设施"){
					this.TransformerFormStyle_add.display="none";
					this.EvSensorFormStyle_add.display="none"
					this.AreaMeterFormStyle_add.display="none"
					this.FuseFormStyle_add.display="none"
					this.IntelligentSwitchFormStyle_add.display="none"
					this.UniphaseMeterFormStyle_add.display="none"
					this.LTUSwitchFormStyle_add.display="none"
					this.ChangePhaseSwitchFormStyle_add.display="none"
					this.ChargingFacilityFormStyle_add.display="block"
					this.PvUserFormStyle_add.display="none"
					this.CompensationDeviceFormStyle_add.display="none"
					this.CableSensingDeviceFormStyle_add.display="none"
					this.ThreePhaseMeterFormStyle_add.display="none"
					this.TerminalFormStyle_add.display="none"
				}else if(this.$refs.deviceName.value=="光伏用户"){
					this.TransformerFormStyle_add.display="none";
					this.EvSensorFormStyle_add.display="none"
					this.AreaMeterFormStyle_add.display="none"
					this.FuseFormStyle_add.display="none"
					this.IntelligentSwitchFormStyle_add.display="none"
					this.UniphaseMeterFormStyle_add.display="none"
					this.LTUSwitchFormStyle_add.display="none"
					this.ChangePhaseSwitchFormStyle_add.display="none"
					this.ChargingFacilityFormStyle_add.display="none"
					this.PvUserFormStyle_add.display="block"
					this.CompensationDeviceFormStyle_add.display="none"
					this.CableSensingDeviceFormStyle_add.display="none"
					this.ThreePhaseMeterFormStyle_add.display="none"
					this.TerminalFormStyle_add.display="none"
				}else if(this.$refs.deviceName.value=="无功补偿装置"){
					this.TransformerFormStyle_add.display="none";
					this.EvSensorFormStyle_add.display="none"
					this.AreaMeterFormStyle_add.display="none"
					this.FuseFormStyle_add.display="none"
					this.IntelligentSwitchFormStyle_add.display="none"
					this.UniphaseMeterFormStyle_add.display="none"
					this.LTUSwitchFormStyle_add.display="none"
					this.ChangePhaseSwitchFormStyle_add.display="none"
					this.ChargingFacilityFormStyle_add.display="none"
					this.PvUserFormStyle_add.display="none"
					this.CompensationDeviceFormStyle_add.display="block"
					this.CableSensingDeviceFormStyle_add.display="none"
					this.ThreePhaseMeterFormStyle_add.display="none"
					this.TerminalFormStyle_add.display="none"
				}else if(this.$refs.deviceName.value=="电缆感知设备"){
					this.TransformerFormStyle_add.display="none";
					this.EvSensorFormStyle_add.display="none"
					this.AreaMeterFormStyle_add.display="none"
					this.FuseFormStyle_add.display="none"
					this.IntelligentSwitchFormStyle_add.display="none"
					this.UniphaseMeterFormStyle_add.display="none"
					this.LTUSwitchFormStyle_add.display="none"
					this.ChangePhaseSwitchFormStyle_add.display="none"
					this.ChargingFacilityFormStyle_add.display="none"
					this.PvUserFormStyle_add.display="none"
					this.CompensationDeviceFormStyle_add.display="none"
					this.CableSensingDeviceFormStyle_add.display="block"
					this.ThreePhaseMeterFormStyle_add.display="none"
					this.TerminalFormStyle_add.display="none"
				}else if(this.$refs.deviceName.value=="三相表"){
					this.TransformerFormStyle_add.display="none";
					this.EvSensorFormStyle_add.display="none"
					this.AreaMeterFormStyle_add.display="none"
					this.FuseFormStyle_add.display="none"
					this.IntelligentSwitchFormStyle_add.display="none"
					this.UniphaseMeterFormStyle_add.display="none"
					this.LTUSwitchFormStyle_add.display="none"
					this.ChangePhaseSwitchFormStyle_add.display="none"
					this.ChargingFacilityFormStyle_add.display="none"
					this.PvUserFormStyle_add.display="none"
					this.CompensationDeviceFormStyle_add.display="none"
					this.CableSensingDeviceFormStyle_add.display="none"
					this.ThreePhaseMeterFormStyle_add.display="block"
					this.TerminalFormStyle_add.display="none"
				}else if(this.$refs.deviceName.value=="智能终端"){
					this.TransformerFormStyle_add.display="none";
					this.EvSensorFormStyle_add.display="none"
					this.AreaMeterFormStyle_add.display="none"
					this.FuseFormStyle_add.display="none"
					this.IntelligentSwitchFormStyle_add.display="none"
					this.UniphaseMeterFormStyle_add.display="none"
					this.LTUSwitchFormStyle_add.display="none"
					this.ChangePhaseSwitchFormStyle_add.display="none"
					this.ChargingFacilityFormStyle_add.display="none"
					this.PvUserFormStyle_add.display="none"
					this.CompensationDeviceFormStyle_add.display="none"
					this.CableSensingDeviceFormStyle_add.display="none"
					this.ThreePhaseMeterFormStyle_add.display="none"
					this.TerminalFormStyle_add.display="block"
				}
			},
			
			// 查看设备信息  并绑定查看的是什么设备、及对应设备的Id、及所在列表的Index、（可进行相应设备的修改）
			viewDeviceInfo(e){
				let that =this;
				var deviceName = e.currentTarget.dataset.name;
				var index = e.currentTarget.dataset.index;
				var deviceId = e.currentTarget.dataset.id;
				this.deviceName = deviceName;//绑定正在查看的设备，并可进行修改操作
				this.deviceIndex = index; //对应列表的Index  修改时更新列表
				this.deviceId = deviceId;//对应设备的Id
				//1.判断需要查看哪个设备
				if(deviceName=="Transformer"){
					this.TransformerFormStyle.display="block";
					this.EvSensorFormStyle.display="none"
					this.AreaMeterFormStyle.display="none"
					this.FuseFormStyle.display="none"
					this.IntelligentSwitchFormStyle.display="none"
					this.UniphaseMeterFormStyle.display="none"
					this.LTUSwitchFormStyle.display="none"
					this.ChangePhaseSwitchFormStyle.display="none"
					this.ChargingFacilityFormStyle.display="none"
					this.PvUserFormStyle.display="none"
					this.CompensationDeviceFormStyle.display="none"
					this.CableSensingDeviceFormStyle.display="none"
					this.ThreePhaseMeterFormStyle.display="none"
					this.TerminalFormStyle.display="none"
					that.Transformer_Item_Info = that.Transformer[index]
				}else if(deviceName=="EvSensor"){
					this.TransformerFormStyle.display="none";
					this.EvSensorFormStyle.display="block"
					this.AreaMeterFormStyle.display="none"
					this.FuseFormStyle.display="none"
					this.IntelligentSwitchFormStyle.display="none"
					this.UniphaseMeterFormStyle.display="none"
					this.LTUSwitchFormStyle.display="none"
					this.ChangePhaseSwitchFormStyle.display="none"
					this.ChargingFacilityFormStyle.display="none"
					this.PvUserFormStyle.display="none"
					this.CompensationDeviceFormStyle.display="none"
					this.CableSensingDeviceFormStyle.display="none"
					this.ThreePhaseMeterFormStyle.display="none"
					this.TerminalFormStyle.display="none"
					that.EvSensor_Item_Info = that.EvSensor[index]
				}else if(deviceName=="AreaMeter"){
					this.TransformerFormStyle.display="none";
					this.EvSensorFormStyle.display="none"
					this.AreaMeterFormStyle.display="block"
					this.FuseFormStyle.display="none"
					this.IntelligentSwitchFormStyle.display="none"
					this.UniphaseMeterFormStyle.display="none"
					this.LTUSwitchFormStyle.display="none"
					this.ChangePhaseSwitchFormStyle.display="none"
					this.ChargingFacilityFormStyle.display="none"
					this.PvUserFormStyle.display="none"
					this.CompensationDeviceFormStyle.display="none"
					this.CableSensingDeviceFormStyle.display="none"
					this.ThreePhaseMeterFormStyle.display="none"
					this.TerminalFormStyle.display="none"
					that.AreaMeter_Item_Info = that.AreaMeter[index]
				}else if(deviceName=="Fuse"){
					this.TransformerFormStyle.display="none";
					this.EvSensorFormStyle.display="none"
					this.AreaMeterFormStyle.display="none"
					this.FuseFormStyle.display="block"
					this.IntelligentSwitchFormStyle.display="none"
					this.UniphaseMeterFormStyle.display="none"
					this.LTUSwitchFormStyle.display="none"
					this.ChangePhaseSwitchFormStyle.display="none"
					this.ChargingFacilityFormStyle.display="none"
					this.PvUserFormStyle.display="none"
					this.CompensationDeviceFormStyle.display="none"
					this.CableSensingDeviceFormStyle.display="none"
					this.ThreePhaseMeterFormStyle.display="none"
					this.TerminalFormStyle.display="none"
					that.Fuse_Item_Info = that.Fuse[index]
				}else if(deviceName=="IntelligentSwitch"){
					this.TransformerFormStyle.display="none";
					this.EvSensorFormStyle.display="none"
					this.AreaMeterFormStyle.display="none"
					this.FuseFormStyle.display="none"
					this.IntelligentSwitchFormStyle.display="block"
					this.UniphaseMeterFormStyle.display="none"
					this.LTUSwitchFormStyle.display="none"
					this.ChangePhaseSwitchFormStyle.display="none"
					this.ChargingFacilityFormStyle.display="none"
					this.PvUserFormStyle.display="none"
					this.CompensationDeviceFormStyle.display="none"
					this.CableSensingDeviceFormStyle.display="none"
					this.ThreePhaseMeterFormStyle.display="none"
					this.TerminalFormStyle.display="none"
					that.IntelligentSwitch_Item_Info = that.IntelligentSwitch[index]
				}else if(deviceName=="UniphaseMeter"){
					this.TransformerFormStyle.display="none";
					this.EvSensorFormStyle.display="none"
					this.AreaMeterFormStyle.display="none"
					this.FuseFormStyle.display="none"
					this.IntelligentSwitchFormStyle.display="none"
					this.UniphaseMeterFormStyle.display="block"
					this.LTUSwitchFormStyle.display="none"
					this.ChangePhaseSwitchFormStyle.display="none"
					this.ChargingFacilityFormStyle.display="none"
					this.PvUserFormStyle.display="none"
					this.CompensationDeviceFormStyle.display="none"
					this.CableSensingDeviceFormStyle.display="none"
					this.ThreePhaseMeterFormStyle.display="none"
					this.TerminalFormStyle.display="none"
					that.UniphaseMeter_Item_Info = that.UniphaseMeter[index]
				}else if(deviceName=="LTUSwitch"){
					this.TransformerFormStyle.display="none";
					this.EvSensorFormStyle.display="none"
					this.AreaMeterFormStyle.display="none"
					this.FuseFormStyle.display="none"
					this.IntelligentSwitchFormStyle.display="none"
					this.UniphaseMeterFormStyle.display="none"
					this.LTUSwitchFormStyle.display="block"
					this.ChangePhaseSwitchFormStyle.display="none"
					this.ChargingFacilityFormStyle.display="none"
					this.PvUserFormStyle.display="none"
					this.CompensationDeviceFormStyle.display="none"
					this.CableSensingDeviceFormStyle.display="none"
					this.ThreePhaseMeterFormStyle.display="none"
					this.TerminalFormStyle.display="none"
					that.LTUSwitch_Item_Info = that.LTUSwitch[index]
				}else if(deviceName=="ChangePhaseSwitch"){
					this.TransformerFormStyle.display="none";
					this.EvSensorFormStyle.display="none"
					this.AreaMeterFormStyle.display="none"
					this.FuseFormStyle.display="none"
					this.IntelligentSwitchFormStyle.display="none"
					this.UniphaseMeterFormStyle.display="none"
					this.LTUSwitchFormStyle.display="none"
					this.ChangePhaseSwitchFormStyle.display="block"
					this.ChargingFacilityFormStyle.display="none"
					this.PvUserFormStyle.display="none"
					this.CompensationDeviceFormStyle.display="none"
					this.CableSensingDeviceFormStyle.display="none"
					this.ThreePhaseMeterFormStyle.display="none"
					this.TerminalFormStyle.display="none"
					that.ChangePhaseSwitch_Item_Info = that.ChangePhaseSwitch[index]
				}else if(deviceName=="ChargingFacility"){
					this.TransformerFormStyle.display="none";
					this.EvSensorFormStyle.display="none"
					this.AreaMeterFormStyle.display="none"
					this.FuseFormStyle.display="none"
					this.IntelligentSwitchFormStyle.display="none"
					this.UniphaseMeterFormStyle.display="none"
					this.LTUSwitchFormStyle.display="none"
					this.ChangePhaseSwitchFormStyle.display="none"
					this.ChargingFacilityFormStyle.display="block"
					this.PvUserFormStyle.display="none"
					this.CompensationDeviceFormStyle.display="none"
					this.CableSensingDeviceFormStyle.display="none"
					this.ThreePhaseMeterFormStyle.display="none"
					this.TerminalFormStyle.display="none"
					that.ChargingFacility_Item_Info = that.ChargingFacility[index]
				}else if(deviceName=="PvUser"){
					this.TransformerFormStyle.display="none";
					this.EvSensorFormStyle.display="none"
					this.AreaMeterFormStyle.display="none"
					this.FuseFormStyle.display="none"
					this.IntelligentSwitchFormStyle.display="none"
					this.UniphaseMeterFormStyle.display="none"
					this.LTUSwitchFormStyle.display="none"
					this.ChangePhaseSwitchFormStyle.display="none"
					this.ChargingFacilityFormStyle.display="none"
					this.PvUserFormStyle.display="block"
					this.CompensationDeviceFormStyle.display="none"
					this.CableSensingDeviceFormStyle.display="none"
					this.ThreePhaseMeterFormStyle.display="none"
					this.TerminalFormStyle.display="none"
					that.PvUser_Item_Info = that.PvUser[index]
				}else if(deviceName=="CompensationDevice"){
					this.TransformerFormStyle.display="none";
					this.EvSensorFormStyle.display="none"
					this.AreaMeterFormStyle.display="none"
					this.FuseFormStyle.display="none"
					this.IntelligentSwitchFormStyle.display="none"
					this.UniphaseMeterFormStyle.display="none"
					this.LTUSwitchFormStyle.display="none"
					this.ChangePhaseSwitchFormStyle.display="none"
					this.ChargingFacilityFormStyle.display="none"
					this.PvUserFormStyle.display="none"
					this.CompensationDeviceFormStyle.display="block"
					this.CableSensingDeviceFormStyle.display="none"
					this.ThreePhaseMeterFormStyle.display="none"
					this.TerminalFormStyle.display="none"
					that.CompensationDevice_Item_Info = that.CompensationDevice[index]
				}else if(deviceName=="CableSensingDevice"){
					this.TransformerFormStyle.display="none";
					this.EvSensorFormStyle.display="none"
					this.AreaMeterFormStyle.display="none"
					this.FuseFormStyle.display="none"
					this.IntelligentSwitchFormStyle.display="none"
					this.UniphaseMeterFormStyle.display="none"
					this.LTUSwitchFormStyle.display="none"
					this.ChangePhaseSwitchFormStyle.display="none"
					this.ChargingFacilityFormStyle.display="none"
					this.PvUserFormStyle.display="none"
					this.CompensationDeviceFormStyle.display="none"
					this.CableSensingDeviceFormStyle.display="block"
					this.ThreePhaseMeterFormStyle.display="none"
					this.TerminalFormStyle.display="none"
					that.CableSensingDevice_Item_Info = that.CableSensingDevice[index]
				}else if(deviceName=="ThreePhaseMeter"){
					this.TransformerFormStyle.display="none";
					this.EvSensorFormStyle.display="none"
					this.AreaMeterFormStyle.display="none"
					this.FuseFormStyle.display="none"
					this.IntelligentSwitchFormStyle.display="none"
					this.UniphaseMeterFormStyle.display="none"
					this.LTUSwitchFormStyle.display="none"
					this.ChangePhaseSwitchFormStyle.display="none"
					this.ChargingFacilityFormStyle.display="none"
					this.PvUserFormStyle.display="none"
					this.CompensationDeviceFormStyle.display="none"
					this.CableSensingDeviceFormStyle.display="none"
					this.ThreePhaseMeterFormStyle.display="block"
					this.TerminalFormStyle.display="none"
					that.ThreePhaseMeter_Item_Info = that.ThreePhaseMeter[index]
				}else if(deviceName=="Terminal"){
					this.TransformerFormStyle.display="none";
					this.EvSensorFormStyle.display="none"
					this.AreaMeterFormStyle.display="none"
					this.FuseFormStyle.display="none"
					this.IntelligentSwitchFormStyle.display="none"
					this.UniphaseMeterFormStyle.display="none"
					this.LTUSwitchFormStyle.display="none"
					this.ChangePhaseSwitchFormStyle.display="none"
					this.ChargingFacilityFormStyle.display="none"
					this.PvUserFormStyle.display="none"
					this.CompensationDeviceFormStyle.display="none"
					this.CableSensingDeviceFormStyle.display="none"
					this.ThreePhaseMeterFormStyle.display="none"
					this.TerminalFormStyle.display="block"
					that.Terminal_Item_Info = that.Terminal[index]
				}
				
			},
			
			//选择需要查看的台区
			areaNameSelect(){
				this.areaName = this.$refs.areaName.value
			},
			
			//修改设备参数 并更新到本地
			formSubmit(e){
				let that = this;
				if(this.deviceName=="Transformer"){
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_Transformer.value   			//变压器所属侧
					json.switchState = this.$refs.switchState_Transformer.value			//分接头挡位
					json.id = that.deviceId
					this.Transformer[this.deviceIndex] = json;//更新设备列表
					//发送请求更新设备参数
					uni.request({
						url: config_url.baseurl + 'updateDevice', //仅为示例，并非真实接口地址。
						data: {//参数
							deviceId: parseInt(that.deviceId),
							Transformer: JSON.stringify(json),
						},
						// dataType:'json',
						method:'POST',//请求方式  或GET，必须为大写
						header: {
							'Access-Control-Allow-Credentials':true,
							'Access-Control-Allow-Origin':'http://localhost:8080/#/',
							'Content-type':'application/x-www-form-urlencoded'
						},
						success(res) {
							uni.showModal({
								title:"提示",
								content:"修改成功"
							})
						},
						fail() {
							uni.showModal({
								title:"提示",
								content:"修改失败"
							})
						}
					})
					
					
				}else if(this.deviceName=="EvSensor"){
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_EvSensor.value   			//变压器所属侧
					json.id = that.deviceId
					this.EvSensor[this.deviceIndex] = json;//更新设备列表
					//发送请求更新设备参数
					uni.request({
						url: config_url.baseurl + 'updateDevice', //仅为示例，并非真实接口地址。
						data: {//参数
							deviceId: parseInt(this.deviceId),
							EvSensor: JSON.stringify(json),
						},
						// dataType:'json',
						method:'POST',//请求方式  或GET，必须为大写
						header: {
							'Access-Control-Allow-Credentials':true,
							'Access-Control-Allow-Origin':'http://localhost:8080/#/',
							'Content-type':'application/x-www-form-urlencoded'
						},
						success(res) {
							uni.showModal({
								title:"提示",
								content:"修改成功"
							})
						},
						fail() {
							uni.showModal({
								title:"提示",
								content:"修改失败"
							})
						}
					})
					
					// this.EvSensorFormStyle.display="none"
				}else if(this.deviceName=="AreaMeter"){
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_AreaMeter.value   			//变压器所属侧
					json.id = that.deviceId
					this.AreaMeter[this.deviceIndex] = json;//更新设备列表
					//发送请求更新设备参数
					uni.request({
						url: config_url.baseurl + 'updateDevice', //仅为示例，并非真实接口地址。
						data: {//参数
							deviceId: parseInt(this.deviceId),
							AreaMeter: JSON.stringify(json),
						},
						// dataType:'json',
						method:'POST',//请求方式  或GET，必须为大写
						header: {
							'Access-Control-Allow-Credentials':true,
							'Access-Control-Allow-Origin':'http://localhost:8080/#/',
							'Content-type':'application/x-www-form-urlencoded'
						},
						success(res) {
							uni.showModal({
								title:"提示",
								content:"修改成功"
							})
						},
						fail() {
							uni.showModal({
								title:"提示",
								content:"修改失败"
							})
						}
					})
					// this.AreaMeterFormStyle.display="none"
				}else if(this.deviceName=="Fuse"){
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_Fuse.value   			//变压器所属侧
					json.switchState = this.$refs.switchState_Fuse.value			//开关状态
					json.id = that.deviceId
					
					this.Fuse[this.deviceIndex] = json;//更新设备列表
					//发送请求更新设备参数
					uni.request({
						url: config_url.baseurl + 'updateDevice', //仅为示例，并非真实接口地址。
						data: {//参数
							deviceId: parseInt(this.deviceId),
							Fuse: JSON.stringify(json),
						},
						// dataType:'json',
						method:'POST',//请求方式  或GET，必须为大写
						header: {
							'Access-Control-Allow-Credentials':true,
							'Access-Control-Allow-Origin':'http://localhost:8080/#/',
							'Content-type':'application/x-www-form-urlencoded'
						},
						success(res) {
							uni.showModal({
								title:"提示",
								content:"修改成功"
							})
						},
						fail() {
							uni.showModal({
								title:"提示",
								content:"修改失败"
							})
						}
					})
					// this.FuseFormStyle.display="none"
				}else if(this.deviceName=="IntelligentSwitch"){
					
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_IntelligentSwitch.value   			//变压器所属侧
					json.switchState = this.$refs.switchState_IntelligentSwitch.value			//开关状态
					json.id = that.deviceId
					this.IntelligentSwitch[this.deviceIndex] = json;//更新设备列表
					//发送请求更新设备参数
					uni.request({
						url: config_url.baseurl + 'updateDevice', //仅为示例，并非真实接口地址。
						data: {//参数
							deviceId: parseInt(this.deviceId),
							IntelligentSwitch: JSON.stringify(json),
						},
						// dataType:'json',
						method:'POST',//请求方式  或GET，必须为大写
						header: {
							'Access-Control-Allow-Credentials':true,
							'Access-Control-Allow-Origin':'http://localhost:8080/#/',
							'Content-type':'application/x-www-form-urlencoded'
						},
						success(res) {
							uni.showModal({
								title:"提示",
								content:"修改成功"
							})
						},
						fail() {
							uni.showModal({
								title:"提示",
								content:"修改失败"
							})
						}
					})
					// this.IntelligentSwitchFormStyle.display="none"
				}else if(this.deviceName=="UniphaseMeter"){
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_UniphaseMeter.value   			//变压器所属侧
					json.id = that.deviceId
					this.UniphaseMeter[this.deviceIndex] = json;//更新设备列表
					//发送请求更新设备参数
					uni.request({
						url: config_url.baseurl + 'updateDevice', //仅为示例，并非真实接口地址。
						data: {//参数
							deviceId: parseInt(this.deviceId),
							UniphaseMeter: JSON.stringify(json),
						},
						// dataType:'json',
						method:'POST',//请求方式  或GET，必须为大写
						header: {
							'Access-Control-Allow-Credentials':true,
							'Access-Control-Allow-Origin':'http://localhost:8080/#/',
							'Content-type':'application/x-www-form-urlencoded'
						},
						success(res) {
							uni.showModal({
								title:"提示",
								content:"修改成功"
							})
						},
						fail() {
							uni.showModal({
								title:"提示",
								content:"修改失败"
							})
						}
					})
					// this.UniphaseMeterFormStyle.display="none"
				}else if(this.deviceName=="LTUSwitch"){
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_LTUSwitch.value   			//变压器所属侧
					json.id = that.deviceId
					json.switchState = this.$refs.switchState_LTUSwitch.value
					this.LTUSwitch[this.deviceIndex] = json;//更新设备列表
					//发送请求更新设备参数
					uni.request({
						url: config_url.baseurl + 'updateDevice', //仅为示例，并非真实接口地址。
						data: {//参数
							deviceId: parseInt(this.deviceId),
							LTUSwitch: JSON.stringify(json),
						},
						// dataType:'json',
						method:'POST',//请求方式  或GET，必须为大写
						header: {
							'Access-Control-Allow-Credentials':true,
							'Access-Control-Allow-Origin':'http://localhost:8080/#/',
							'Content-type':'application/x-www-form-urlencoded'
						},
						success(res) {
							uni.showModal({
								title:"提示",
								content:"修改成功"
							})
						},
						fail() {
							uni.showModal({
								title:"提示",
								content:"修改失败"
							})
						}
					})
					// this.LTUSwitchFormStyle.display="none"
				}else if(this.deviceName=="ChangePhaseSwitch"){
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_ChangePhaseSwitch.value   			//变压器所属侧
					json.id = that.deviceId
					json.switchState = this.$refs.switchState_ChangePhaseSwitch.value
					this.ChangePhaseSwitch[this.deviceIndex] = json;//更新设备列表
					//发送请求更新设备参数
					uni.request({
						url: config_url.baseurl + 'updateDevice', //仅为示例，并非真实接口地址。
						data: {//参数
							deviceId: parseInt(this.deviceId),
							ChangePhaseSwitch: JSON.stringify(json),
						},
						// dataType:'json',
						method:'POST',//请求方式  或GET，必须为大写
						header: {
							'Access-Control-Allow-Credentials':true,
							'Access-Control-Allow-Origin':'http://localhost:8080/#/',
							'Content-type':'application/x-www-form-urlencoded'
						},
						success(res) {
							uni.showModal({
								title:"提示",
								content:"修改成功"
							})
						},
						fail() {
							uni.showModal({
								title:"提示",
								content:"修改失败"
							})
						}
					})
					// this.ChangePhaseSwitchFormStyle.display="none"
				}else if(this.deviceName=="ChargingFacility"){
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_ChargingFacility.value   			//变压器所属侧
					json.id = that.deviceId
					this.ChargingFacility[this.deviceIndex] = json;//更新设备列表
					//发送请求更新设备参数
					uni.request({
						url: config_url.baseurl + 'updateDevice', //仅为示例，并非真实接口地址。
						data: {//参数
							deviceId: parseInt(this.deviceId),
							ChargingFacility: JSON.stringify(json),
						},
						// dataType:'json',
						method:'POST',//请求方式  或GET，必须为大写
						header: {
							'Access-Control-Allow-Credentials':true,
							'Access-Control-Allow-Origin':'http://localhost:8080/#/',
							'Content-type':'application/x-www-form-urlencoded'
						},
						success(res) {
							uni.showModal({
								title:"提示",
								content:"修改成功"
							})
						},
						fail() {
							uni.showModal({
								title:"提示",
								content:"修改失败"
							})
						}
					})
					// this.ChargingFacilityFormStyle.display="none"
				}else if(this.deviceName=="PvUser"){
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_PvUser.value   			//变压器所属侧
					json.id = that.deviceId
					this.PvUser[this.deviceIndex] = json;//更新设备列表
					//发送请求更新设备参数
					uni.request({
						url: config_url.baseurl + 'updateDevice', //仅为示例，并非真实接口地址。
						data: {//参数
							deviceId: parseInt(this.deviceId),
							PvUser: JSON.stringify(json),
						},
						// dataType:'json',
						method:'POST',//请求方式  或GET，必须为大写
						header: {
							'Access-Control-Allow-Credentials':true,
							'Access-Control-Allow-Origin':'http://localhost:8080/#/',
							'Content-type':'application/x-www-form-urlencoded'
						},
						success(res) {
							uni.showModal({
								title:"提示",
								content:"修改成功"
							})
						},
						fail() {
							uni.showModal({
								title:"提示",
								content:"修改失败"
							})
						}
					})
					// this.PvUserFormStyle.display="none"
				}else if(this.deviceName=="CompensationDevice"){
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_CompensationDevice.value   			//变压器所属侧
					json.cuttingState = this.$refs.cuttingState.value
					json.id = that.deviceId
					
					this.CompensationDevice[this.deviceIndex] = json;//更新设备列表
					//发送请求更新设备参数
					uni.request({
						url: config_url.baseurl + 'updateDevice', //仅为示例，并非真实接口地址。
						data: {//参数
							deviceId: parseInt(this.deviceId),
							CompensationDevice: JSON.stringify(json),
						},
						method:'POST',//请求方式  或GET，必须为大写
						header: {
							'Access-Control-Allow-Credentials':true,
							'Access-Control-Allow-Origin':'http://localhost:8080/#/',
							'Content-type':'application/x-www-form-urlencoded'
						},
						success(res) {
							uni.showModal({
								title:"提示",
								content:"修改成功"
							})
						},
						fail() {
							uni.showModal({
								title:"提示",
								content:"修改失败"
							})
						}
					})
					// this.CompensationDeviceFormStyle.display="none"
				}else if(this.deviceName=="CableSensingDevice"){
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_CableSensingDevice.value   			//变压器所属侧
					json.id = that.deviceId
					this.CableSensingDevice[this.deviceIndex] = json;//更新设备列表
					//发送请求更新设备参数
					uni.request({
						url: config_url.baseurl + 'updateDevice', //仅为示例，并非真实接口地址。
						data: {//参数
							deviceId: parseInt(this.deviceId),
							CableSensingDevice: JSON.stringify(json),
						},
						// dataType:'json',
						method:'POST',//请求方式  或GET，必须为大写
						header: {
							'Access-Control-Allow-Credentials':true,
							'Access-Control-Allow-Origin':'http://localhost:8080/#/',
							'Content-type':'application/x-www-form-urlencoded'
						},
						success(res) {
							uni.showModal({
								title:"提示",
								content:"修改成功"
							})
						},
						fail() {
							uni.showModal({
								title:"提示",
								content:"修改失败"
							})
						}
					})
					// this.CableSensingDeviceFormStyle.display="none"
				}else if(this.deviceName=="ThreePhaseMeter"){
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_ThreePhaseMeter.value   			//变压器所属侧
					json.id = that.deviceId
					this.ThreePhaseMeter[this.deviceIndex] = json;//更新设备列表
					//发送请求更新设备参数
					uni.request({
						url: config_url.baseurl + 'updateDevice', //仅为示例，并非真实接口地址。
						data: {//参数
							deviceId: parseInt(this.deviceId),
							ThreePhaseMeter: JSON.stringify(json),
						},
						// dataType:'json',
						method:'POST',//请求方式  或GET，必须为大写
						header: {
							'Access-Control-Allow-Credentials':true,
							'Access-Control-Allow-Origin':'http://localhost:8080/#/',
							'Content-type':'application/x-www-form-urlencoded'
						},
						success(res) {
							uni.showModal({
								title:"提示",
								content:"修改成功"
							})
						},
						fail() {
							uni.showModal({
								title:"提示",
								content:"修改失败"
							})
						}
					})
					// this.ThreePhaseMeterFormStyle.display="none"
				}else if(this.deviceName=="Terminal"){
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_Terminal.value   			//变压器所属侧
					json.id = that.deviceId
					this.Terminal[this.deviceIndex] = json;//更新设备列表
					//发送请求更新设备参数
					uni.request({
						url: config_url.baseurl + 'updateDevice', //仅为示例，并非真实接口地址。
						data: {//参数
							deviceId: parseInt(this.deviceId),
							Terminal: JSON.stringify(json),
						},
						// dataType:'json',
						method:'POST',//请求方式  或GET，必须为大写
						header: {
							'Access-Control-Allow-Credentials':true,
							'Access-Control-Allow-Origin':'http://localhost:8080/#/',
							'Content-type':'application/x-www-form-urlencoded'
						},
						success(res) {
							uni.showModal({
								title:"提示",
								content:"修改成功"
							})
						},
						fail() {
							uni.showModal({
								title:"提示",
								content:"修改失败"
							})
						}
					})
					// this.TerminalFormStyle.display="none"
				}
				

			},
			
			//添加设备 并添加到本地
			formAddSubmit(e){
				let that = this;
				//先判断是否选择了台区（未选择台区则不允许添加）
				if(this.$refs.courtsId.value!=""){
					
					if(this.$refs.deviceName.value=="智能变压器"){
					this.TransformerFormStyle_add.display="none"
					var json = {};
					json = e.detail.value;
					json.areaName = this.$refs.areaName_Transformer_add.value;   			//变压器所属侧
					json.courtsId = this.$refs.courtsId.value;//台区Id
					json.switchState = this.$refs.switchState_Transformer_add.value	;		//分接头挡位
					//发送请求添加设备
					uni.request({
						url: config_url.baseurl + 'addDevice', //仅为示例，并非真实接口地址。
						data: {//参数
							deviceJson:JSON.stringify(json),
							deviceName:"Transformer"
						},
						dataType:'json',
						method:'POST',//请求方式  或GET，必须为大写
						header: {
							'Access-Control-Allow-Credentials':true,
							'Access-Control-Allow-Origin':'http://localhost:8080/#/',
							'Content-type':'application/x-www-form-urlencoded'
						},
						success(res) {
							if(res.data.addMsg=="1"){//成功返回设备id 并添加到本地
							// json.id
								that.Transformer.push(res.data.Transformer)//添加到本地
								uni.showModal({
									title:"提示",content:"添加成功"
								})
							}
						},
						fail(res) {
							uni.showModal({
								title:"提示",content:"添加成功"
							})
						}
					})
					
					
				}else if(this.$refs.deviceName.value=="智能环境传感器"){
					this.EvSensorFormStyle_add.display="none"
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_EvSensor_add.value   			//变压器所属侧
					json.courtsId = this.$refs.courtsId.value;//台区Id
					//发送请求添加设备
					uni.request({
						url: config_url.baseurl + 'addDevice', //仅为示例，并非真实接口地址。
						data: {//参数
							deviceJson:JSON.stringify(json),
							deviceName:"EvSensor"
						},
						dataType:'json',
						method:'POST',//请求方式  或GET，必须为大写
						header: {
							'Access-Control-Allow-Credentials':true,
							'Access-Control-Allow-Origin':'http://localhost:8080/#/',
							'Content-type':'application/x-www-form-urlencoded'
						},
						success(res) {
							if(res.data.addMsg=="1"){
								that.EvSensor.push(res.data.EvSensor)//添加到本地
								uni.showModal({
									title:"提示",content:"添加成功"
								})
							}
						},
						fail(res) {
							uni.showModal({
								title:"提示",content:"添加成功"
							})
						}
					})
					
				
					
				}else if(this.$refs.deviceName.value=="台区总表"){
					this.AreaMeterFormStyle_add.display="none"
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_AreaMeter_add.value   			//变压器所属侧
					json.courtsId = this.$refs.courtsId.value;//台区Id
					//发送请求添加设备
					uni.request({
						url: config_url.baseurl + 'addDevice', //仅为示例，并非真实接口地址。
						data: {//参数
							deviceJson:JSON.stringify(json),
							deviceName:"AreaMeter"
						},
						dataType:'json',
						method:'POST',//请求方式  或GET，必须为大写
						header: {
							'Access-Control-Allow-Credentials':true,
							'Access-Control-Allow-Origin':'http://localhost:8080/#/',
							'Content-type':'application/x-www-form-urlencoded'
						},
						success(res) {
							if(res.data.addMsg=="1"){
								that.AreaMeter.push(res.data.AreaMeter)
								uni.showModal({
									title:"提示",content:"添加成功"
								})
							}
						},
						fail(res) {
							uni.showModal({
								title:"提示",content:"添加成功"
							})
						}
					})
					
					
					
					
				}else if(this.$refs.deviceName.value=="熔断器"){
					this.FuseFormStyle_add.display="none"
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_Fuse_add.value   			//变压器所属侧
					json.switchState = this.$refs.switchState_Fuse_add.value			//开关状态
					json.courtsId = this.$refs.courtsId.value;//台区Id
					//发送请求添加设备
					uni.request({
						url: config_url.baseurl + 'addDevice', //仅为示例，并非真实接口地址。
						data: {//参数
							deviceJson:JSON.stringify(json),
							deviceName:"Fuse"
						},
						dataType:'json',
						method:'POST',//请求方式  或GET，必须为大写
						header: {
							'Access-Control-Allow-Credentials':true,
							'Access-Control-Allow-Origin':'http://localhost:8080/#/',
							'Content-type':'application/x-www-form-urlencoded'
						},
						success(res) {
							if(res.data.addMsg=="1"){
								that.Fuse.push(res.data.Fuse)
								uni.showModal({
									title:"提示",content:"添加成功"
								})
							}
						},
						fail(res) {
							uni.showModal({
								title:"提示",content:"添加成功"
							})
						}
					})
					
					
				}else if(this.$refs.deviceName.value=="智能开关"){
					this.IntelligentSwitchFormStyle.display="none"
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_IntelligentSwitch_add.value   			//变压器所属侧
					json.switchState = this.$refs.switchState_IntelligentSwitch_add.value			//开关状态
					json.courtsId = this.$refs.courtsId.value;//台区Id
					//发送请求添加设备
					uni.request({
						url: config_url.baseurl + 'addDevice', //仅为示例，并非真实接口地址。
						data: {//参数
							deviceJson:JSON.stringify(json),
							deviceName:"IntelligentSwitch"
						},
						dataType:'json',
						method:'POST',//请求方式  或GET，必须为大写
						header: {
							'Access-Control-Allow-Credentials':true,
							'Access-Control-Allow-Origin':'http://localhost:8080/#/',
							'Content-type':'application/x-www-form-urlencoded'
						},
						success(res) {
							if(res.data.addMsg=="1"){
								that.IntelligentSwitch.push(res.data.IntelligentSwitch)
								uni.showModal({
									title:"提示",content:"添加成功"
								})
							}
						},
						fail(res) {
							uni.showModal({
								title:"提示",content:"添加成功"
							})
						}
					})
					
					
				}else if(this.$refs.deviceName.value=="单相表"){
					this.UniphaseMeterFormStyle_add.display="none"
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_UniphaseMeter_add.value   			//变压器所属侧
					json.courtsId = this.$refs.courtsId.value;//台区Id
					 //发送请求添加设备
					uni.request({
					 	url: config_url.baseurl + 'addDevice', //仅为示例，并非真实接口地址。
					 	data: {//参数
					 		deviceJson:JSON.stringify(json),
					 		deviceName:"UniphaseMeter"
					 	},
					 	dataType:'json',
					 	method:'POST',//请求方式  或GET，必须为大写
					 	header: {
					 		'Access-Control-Allow-Credentials':true,
					 		'Access-Control-Allow-Origin':'http://localhost:8080/#/',
					 		'Content-type':'application/x-www-form-urlencoded'
					 	},
					 	success(res) {
					 		if(res.data.addMsg=="1"){
					 			that.UniphaseMeter.push(res.data.UniphaseMeter)
					 			uni.showModal({
					 				title:"提示",content:"添加成功"
					 			})
					 		}
					 	},
					 	fail(res) {
					 		uni.showModal({
					 			title:"提示",content:"添加成功"
					 		})
					 	}
					 })   
					
				
				
				}else if(this.$refs.deviceName.value=="LTU开关"){
					this.LTUSwitchFormStyle_add.display="none"
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_LTUSwitch_add.value   			//变压器所属侧
					json.courtsId = this.$refs.courtsId.value;//台区Id
					json.switchState = this.$refs.switchState_LTUSwitch_add.value
					//发送请求添加设备
					uni.request({
					 	url: config_url.baseurl + 'addDevice', //仅为示例，并非真实接口地址。
					 	data: {//参数
					 		deviceJson:JSON.stringify(json),
					 		deviceName:"LTUSwitch"
					 	},
					 	dataType:'json',
					 	method:'POST',//请求方式  或GET，必须为大写
					 	header: {
					 		'Access-Control-Allow-Credentials':true,
					 		'Access-Control-Allow-Origin':'http://localhost:8080/#/',
					 		'Content-type':'application/x-www-form-urlencoded'
					 	},
					 	success(res) {
					 		if(res.data.addMsg=="1"){
					 			that.LTUSwitch.push(res.data.LTUSwitch)
					 			uni.showModal({
					 				title:"提示",content:"添加成功"
					 			})
					 		}
					 	},
					 	fail(res) {
					 		uni.showModal({
					 			title:"提示",content:"添加成功"
					 		})
					 	}
					 })   
					
					
				}else if(this.$refs.deviceName.value=="换相开关"){
					this.ChangePhaseSwitchFormStyle_add.display="none"
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_ChangePhaseSwitch_add.value   			//变压器所属侧
					json.courtsId = this.$refs.courtsId.value;//台区Id
					json.switchState = this.$refs.switchState_ChangePhaseSwitch_add.value
					//发送请求添加设备
					uni.request({
					 	url: config_url.baseurl + 'addDevice', //仅为示例，并非真实接口地址。
					 	data: {//参数
					 		deviceJson:JSON.stringify(json),
					 		deviceName:"ChangePhaseSwitch"
					 	},
					 	dataType:'json',
					 	method:'POST',//请求方式  或GET，必须为大写
					 	header: {
					 		'Access-Control-Allow-Credentials':true,
					 		'Access-Control-Allow-Origin':'http://localhost:8080/#/',
					 		'Content-type':'application/x-www-form-urlencoded'
					 	},
					 	success(res) {
					 		if(res.data.addMsg=="1"){
					 			that.ChangePhaseSwitch.push(res.data.ChangePhaseSwitch)
					 			uni.showModal({
					 				title:"提示",content:"添加成功"
					 			})
					 		}
					 	},
					 	fail(res) {
					 		uni.showModal({
					 			title:"提示",content:"添加成功"
					 		})
					 	}
					 })   
					
					
				}else if(this.$refs.deviceName.value=="电动汽车充电设施"){
					this.ChargingFacilityFormStyle_add.display="none"
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_ChargingFacility_add.value   			//变压器所属侧
					json.courtsId = this.$refs.courtsId.value;//台区Id
					//发送请求添加设备
					uni.request({
					 	url: config_url.baseurl + 'addDevice', //仅为示例，并非真实接口地址。
					 	data: {//参数
					 		deviceJson:JSON.stringify(json),
					 		deviceName:"ChargingFacility"
					 	},
					 	dataType:'json',
					 	method:'POST',//请求方式  或GET，必须为大写
					 	header: {
					 		'Access-Control-Allow-Credentials':true,
					 		'Access-Control-Allow-Origin':'http://localhost:8080/#/',
					 		'Content-type':'application/x-www-form-urlencoded'
					 	},
					 	success(res) {
					 		if(res.data.addMsg=="1"){
					 			that.ChargingFacility.push(res.data.ChargingFacility)
					 			uni.showModal({
					 				title:"提示",content:"添加成功"
					 			})
					 		}
					 	},
					 	fail(res) {
					 		uni.showModal({
					 			title:"提示",content:"添加成功"
					 		})
					 	}
					 }) 
					
					
				}else if(this.$refs.deviceName.value=="光伏用户"){
					this.PvUserFormStyle_add.display="none"
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_PvUser_add.value   			//变压器所属侧
					json.courtsId = this.$refs.courtsId.value;//台区Id
					//发送请求添加设备
					uni.request({
					 	url: config_url.baseurl + 'addDevice', //仅为示例，并非真实接口地址。
					 	data: {//参数
					 		deviceJson:JSON.stringify(json),
					 		deviceName:"PvUser"
					 	},
					 	dataType:'json',
					 	method:'POST',//请求方式  或GET，必须为大写
					 	header: {
					 		'Access-Control-Allow-Credentials':true,
					 		'Access-Control-Allow-Origin':'http://localhost:8080/#/',
					 		'Content-type':'application/x-www-form-urlencoded'
					 	},
					 	success(res) {
					 		if(res.data.addMsg=="1"){
					 			that.PvUser.push(res.data.PvUser)
					 			uni.showModal({
					 				title:"提示",content:"添加成功"
					 			})
					 		}
					 	},
					 	fail(res) {
					 		uni.showModal({
					 			title:"提示",content:"添加成功"
					 		})
					 	}
					 }) 
					
					
				}else if(this.$refs.deviceName.value=="无功补偿装置"){
					this.CompensationDeviceFormStyle_add.display="none"
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_CompensationDevice_add.value   			//变压器所属侧
					json.courtsId = this.$refs.courtsId.value;//台区Id
					json.cuttingState = this.$refs.cuttingState_add.value
					this.CompensationDeviceFormStyle_add.display="none"
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_CompensationDevice_add.value   			//变压器所属侧
					json.cuttingState = this.$refs.cuttingState_add.value
					json.courtsId = this.$refs.courtsId.value;//台区Id
					//发送请求添加设备
					uni.request({
					 	url: config_url.baseurl + 'addDevice', //仅为示例，并非真实接口地址。
					 	data: {//参数
					 		deviceJson:JSON.stringify(json),
					 		deviceName:"CompensationDevice"
					 	},
					 	dataType:'json',
					 	method:'POST',//请求方式  或GET，必须为大写
					 	header: {
					 		'Access-Control-Allow-Credentials':true,
					 		'Access-Control-Allow-Origin':'http://localhost:8080/#/',
					 		'Content-type':'application/x-www-form-urlencoded'
					 	},
					 	success(res) {
					 		if(res.data.addMsg=="1"){
					 			that.CompensationDevice.push(res.data.CompensationDevice)
					 			uni.showModal({
					 				title:"提示",content:"添加成功"
					 			})
					 		}
					 	},
					 	fail(res) {
					 		uni.showModal({
					 			title:"提示",content:"添加成功"
					 		})
					 	}
					 }) 
					
					
				}else if(this.$refs.deviceName.value=="电缆感知设备"){
					this.CableSensingDeviceFormStyle_add.display="none"
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_CableSensingDevice_add.value   			//变压器所属侧
					json.courtsId = this.$refs.courtsId.value;//台区Id
					//发送请求添加设备
					uni.request({
					 	url: config_url.baseurl + 'addDevice', //仅为示例，并非真实接口地址。
					 	data: {//参数
					 		deviceJson:JSON.stringify(json),
					 		deviceName:"CableSensingDevice"
					 	},
					 	dataType:'json',
					 	method:'POST',//请求方式  或GET，必须为大写
					 	header: {
					 		'Access-Control-Allow-Credentials':true,
					 		'Access-Control-Allow-Origin':'http://localhost:8080/#/',
					 		'Content-type':'application/x-www-form-urlencoded'
					 	},
					 	success(res) {
					 		if(res.data.addMsg=="1"){
					 			that.CableSensingDevice.push(res.data.CableSensingDevice)
					 			uni.showModal({
					 				title:"提示",content:"添加成功"
					 			})
					 		}
					 	},
					 	fail(res) {
					 		uni.showModal({
					 			title:"提示",content:"添加成功"
					 		})
					 	}
					 }) 
					
					
				}else if(this.$refs.deviceName.value=="三相表"){
					this.ThreePhaseMeterFormStyle_add.display="none"
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_ThreePhaseMeter_add.value   			//变压器所属侧
					json.courtsId = this.$refs.courtsId.value;//台区Id
					//发送请求添加设备
					uni.request({
					 	url: config_url.baseurl + 'addDevice', //仅为示例，并非真实接口地址。
					 	data: {//参数
					 		deviceJson:JSON.stringify(json),
					 		deviceName:"ThreePhaseMeter"
					 	},
					 	dataType:'json',
					 	method:'POST',//请求方式  或GET，必须为大写
					 	header: {
					 		'Access-Control-Allow-Credentials':true,
					 		'Access-Control-Allow-Origin':'http://localhost:8080/#/',
					 		'Content-type':'application/x-www-form-urlencoded'
					 	},
					 	success(res) {
					 		if(res.data.addMsg=="1"){
					 			that.ThreePhaseMeter.push(res.data.ThreePhaseMeter)
					 			uni.showModal({
					 				title:"提示",content:"添加成功"
					 			})
					 		}
					 	},
					 	fail(res) {
					 		uni.showModal({
					 			title:"提示",content:"添加成功"
					 		})
					 	}
					 }) 
					
					
				}else if(this.$refs.deviceName.value=="智能终端"){
					this.TerminalFormStyle_add.display="none"
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_Terminal_add.value   			//变压器所属侧
					json.courtsId = this.$refs.courtsId.value;//台区Id
					//发送请求添加设备
					uni.request({
					 	url: config_url.baseurl + 'addDevice', //仅为示例，并非真实接口地址。
					 	data: {//参数
					 		deviceJson:JSON.stringify(json),
					 		deviceName:"Terminal"
					 	},
					 	dataType:'json',
					 	method:'POST',//请求方式  或GET，必须为大写
					 	header: {
					 		'Access-Control-Allow-Credentials':true,
					 		'Access-Control-Allow-Origin':'http://localhost:8080/#/',
					 		'Content-type':'application/x-www-form-urlencoded'
					 	},
					 	success(res) {
					 		if(res.data.addMsg=="1"){
					 			that.Terminal.push(res.data.Terminal)
					 			uni.showModal({
					 				title:"提示",content:"添加成功"
					 			})
					 		}
					 	},
					 	fail(res) {
					 		uni.showModal({
					 			title:"提示",content:"添加成功"
					 		})
					 	}
					 }) 
					
					
				}
					
					
				}else{
					uni.showModal({
						title:"提示",content:"未选择台区"
					})
				}
				
				
				
				
				
			},
			
			
			//删除设备
			delDevice(e){
				let that = this;
				uni.showModal({
					title:"提示",
					content:"确定删除此设备?",
					success(res) {
						if(res.confirm){
							uni.request({
								url: config_url.baseurl + 'delDevice', //仅为示例，并非真实接口地址。
								data: {//参数
									deviceId: that.deviceId,
									deviceName: that.deviceName
								},
								dataType:'json',
								method:'POST',//请求方式  或GET，必须为大写
								header: {
									'Access-Control-Allow-Credentials':true,
									'Access-Control-Allow-Origin':'http://localhost:8080/#/',
									'Content-type':'application/x-www-form-urlencoded'
								},
								success(res){//成功则更新本地数据
									if(res.data.delMsg=="1"){
								
										that.TransformerFormStyle.display="none";
										that.EvSensorFormStyle.display="none"
										that.AreaMeterFormStyle.display="none"
										that.FuseFormStyle.display="none"
										that.IntelligentSwitchFormStyle.display="none"
										that.UniphaseMeterFormStyle.display="none"
										that.LTUSwitchFormStyle.display="none"
										that.ChangePhaseSwitchFormStyle.display="none"
										that.ChargingFacilityFormStyle.display="none"
										that.PvUserFormStyle.display="none"
										that.CompensationDeviceFormStyle.display="none"
										that.CableSensingDeviceFormStyle.display="none"
										that.ThreePhaseMeterFormStyle.display="none"
										that.TerminalFormStyle.display="none"
										if(that.deviceName=="Transformer"){
											that.Transformer.splice(that.deviceIndex,1)
										}else if(that.deviceName=="EvSensor"){
											that.EvSensor.splice(that.deviceIndex,1)
										}else if(that.deviceName=="AreaMeter"){
											that.AreaMeter.splice(that.deviceIndex,1)
										}else if(that.deviceName=="Fuse"){
											that.Fuse.splice(that.deviceIndex,1)
										}else if(that.deviceName=="IntelligentSwitch"){
											that.IntelligentSwitch.splice(that.deviceIndex,1)
										}else if(that.deviceName=="UniphaseMeter"){
											that.UniphaseMeter.splice(that.deviceIndex,1)
										}else if(that.deviceName=="LTUSwitch"){
											that.LTUSwitch.splice(that.deviceIndex,1)
										}else if(that.deviceName=="ChangePhaseSwitch"){
											that.ChangePhaseSwitch.splice(that.deviceIndex,1)
										}else if(that.deviceName=="ChargingFacility"){
											that.ChargingFacility.splice(that.deviceIndex,1)
										}else if(that.deviceName=="PvUser"){
											that.PvUser.splice(that.deviceIndex,1)
										}else if(that.deviceName=="CompensationDevice"){
											that.CompensationDevice.splice(that.deviceIndex,1)
										}else if(that.deviceName=="CableSensingDevice"){
											that.CableSensingDevice.splice(that.deviceIndex,1)
										}else if(that.deviceName=="ThreePhaseMeter"){
											that.ThreePhaseMeter.splice(that.deviceIndex,1)
										}else if(that.deviceName=="Terminal"){
											that.Terminal.splice(that.deviceIndex,1)
										}
										uni.showModal({
											title:"提示",
											content:"删除成功"
										})
									}else{
									}
									
								}
							
							})
						}else{
						}
					}
				})
			},
			
			//关闭表单（隐藏所有表单）（通用）
			formCancel(e){
				this.TransformerFormStyle.display="none";
				this.EvSensorFormStyle.display="none"
				this.AreaMeterFormStyle.display="none"
				this.FuseFormStyle.display="none"
				this.IntelligentSwitchFormStyle.display="none"
				this.UniphaseMeterFormStyle.display="none"
				this.LTUSwitchFormStyle.display="none"
				this.ChangePhaseSwitchFormStyle.display="none"
				this.ChargingFacilityFormStyle.display="none"
				this.PvUserFormStyle.display="none"
				this.CompensationDeviceFormStyle.display="none"
				this.CableSensingDeviceFormStyle.display="none"
				this.ThreePhaseMeterFormStyle.display="none"
				this.TerminalFormStyle.display="none"
				this.TransformerFormStyle_add.display="none";
				this.EvSensorFormStyle_add.display="none"
				this.AreaMeterFormStyle_add.display="none"
				this.FuseFormStyle_add.display="none"
				this.IntelligentSwitchFormStyle_add.display="none"
				this.UniphaseMeterFormStyle_add.display="none"
				this.LTUSwitchFormStyle_add.display="none"
				this.ChangePhaseSwitchFormStyle_add.display="none"
				this.ChargingFacilityFormStyle_add.display="none"
				this.PvUserFormStyle_add.display="none"
				this.CompensationDeviceFormStyle_add.display="none"
				this.CableSensingDeviceFormStyle_add.display="none"
				this.ThreePhaseMeterFormStyle_add.display="none"
				this.TerminalFormStyle_add.display="none"
			},
			
			
			chooseImage:function(){
				let that = this;
				uni.chooseImage({
					count: 1,
					sizeType: ['original', 'compressed'],
					sourceType: ['album', 'camera'],
					success (res) {
						that.srcUrl = res.tempFilePaths[0],
						uni.getImageInfo({
							src:res.tempFilePaths[0],
							success(res) {
								that.imgStyle={"width": res.width*2+"rpx","height": res.height*2+"rpx"}
							}
						})
					}
				})
			},
		
		
		
		
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
			})
		},
	}
</script>

<style>
/* image{
	background-color: #007AFF;
} */
.box_1{
	width: 100%;height: 60rpx;line-height: 60rpx;
	background-color: #C0C0C0;
	border-radius: 10rpx;
	padding-left: 15rpx;
	padding-right: 10rpx;
	box-sizing: border-box;
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
.nameInput{
	/* background-color: #4CD964; */
	width: 95%;height: 45rpx;
	text-align: center;
	margin-left: 5rpx;
	font-size: small;box-sizing: border-box;
}
.chooseBtn{
	width:38%;
	height: 50rpx;
	line-height: 50rpx;
	float: right;
	margin-top: 6rpx;
	font-size: small;
	display: block;
	float: right;
	margin-left: 20rpx;box-sizing: border-box;border: 1rpx solid #8F8F94;
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
.deviceSelect{
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
	display: block;
	height: 50rpx;
	line-height: 50rpx;
	width: 100%;
	border-bottom:  1rpx solid #333333; 
	display: flex;justify-content: space-between;flex-wrap: wrap;
}
.item>view{
	
}
.itemClass_1{
	background-color: #F1F1F1;
}
.itemClass_2{
	background-color: #F8F8F8;
}
uni-list{
	list-style: none;
	display: block;
	width: 100%;
	height: 50rpx;
	line-height: 50rpx;
	margin-top: 10rpx;
	border-bottom:  1rpx solid #333333; 
	/* display: flex;justify-content: space-between;flex-wrap: wrap; */
}
/* uni-list-item{
	font-size: medium;
	display: inline-block;
	margin-right: 10rpx;
}
 */

form{
	border-radius: 20rpx;
	width: 95%;
	margin: 20rpx auto;
	position: absolute;
	top: 600rpx;
	background-color: #DBDBDB;display: block;
	padding: 15rpx 10rpx;
	box-sizing: border-box;
	display: flex;
	justify-content: space-between;flex-wrap: wrap;
}
.formItem{
	width: 50%;
	height: 60rpx;
	line-height: 60rpx;
	background-color: #C0C0C0;
	display: inline-block;
	border-radius: 15rpx;
}
.formItem_1{
	width: 51%;
	float: left;
	font-size: xx-small;margin-left: 10rpx;
}
.formItem_2{
	width: 26%;
	height: 50rpx;
	float: left;
	margin: 5rpx;
	background-color: white;
	border-radius: 10rpx;
}
.formItem_2>input{
	width: 95%;
	height: 50rpx;
	margin: 0 auto;
	font-size: small;
}
.formItem_3{
	width: 10%;float: right;
	font-size: small;margin-right: 10rpx;margin-left: 10rpx;
}

.formBtn{
	margin-top: 10rpx;
	display: block;
	width: 33.3%;
	height: 55rpx;
	background-color: #C0C0C0;
	line-height: 55rpx;
	float: right;
	border-radius: 15rpx;
	box-sizing: border-box;/* border:  1rpx solid #333333; */
}
.icon_delete{
	width: 36rpx;height: 36rpx;margin: 5rpx;margin-left: 18rpx;float: left;
}
.icon{
	width: 45rpx;height: 45rpx;margin-right: 5rpx;float: right;
}
.icon_add,.icon_del{
	width: 42rpx;height: 42rpx;margin-right: 40rpx;float: right;
}
</style>
