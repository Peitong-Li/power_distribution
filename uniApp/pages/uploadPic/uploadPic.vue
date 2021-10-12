<template>
	<view style="width: 95%;margin: 0 auto;">
		
		<scroll-view scroll-x="true" style="height: 410rpx;margin-bottom: 40rpx;border: 1rpx dotted #333333;">
			<image :src="srcUrl" :style="imgStyle" mode=""></image>
		</scroll-view>
		
		<view class="box_1">
			<text class="text">台区名称：</text>
			<view >
				<input class="nameInput"  type="text" value="" placeholder="请输入台区名称" v-model="courtsName"/>
			</view>
			<button class="chooseBtn" @click="chooseImage">选择线路图</button>
		</view>
		
		<progress :percent="percent" stroke-width="10"></progress>
		
		<!-- 设备选择 -->
		<view class="box_2">
			<text class="text">添加设备</text>
			<select class="deviceSelect" @change="deviceSelect" @click="deviceSelect" ref="deviceName" id="deviceName">
				<option  value="">---------</option>
				<option  value="智能变压器">智能变压器</option>
				<option  value="智能环境传感器">智能环境传感器</option>
				<option  value="台区总表">台区总表</option>
				<option  value="熔断器">熔断器</option>
				<option  value="智能开关">智能开关</option>
				<option  value="单相表">单相表</option>
				<option  value="LTU开关">LTU开关</option>
				<option  value="换相开关">换相开关</option>
				<option  value="电动汽车充电设施">电动汽车充电设施</option>
				<option  value="光伏用户">光伏用户</option>
				<option  value="无功补偿装置">无功补偿装置</option>
				<option  value="电缆感知设备">电缆感知设备</option>
				<option  value="三相表">三相表</option>
				<option  value="智能终端">智能终端</option>
			</select>
		</view>
		
		<!-- 设备列表 -->
		<view style="padding: 15rpx;padding-top: 0rpx;background-color: #DBDBDB;border-radius: 10rpx;margin-top: 20rpx;">
			<!-- 标题 -->
			<view class="item" style="border-bottom: 1px solid #333333;">
				<view title="" note="" style="width: 14%;font-weight: bold;">标号</view>
				<view title="" note="" style="width: 45%;font-weight: bold;">设备名称</view>
				<view title="" note="" style="width: 20%;font-weight: bold;">所属侧</view>
				<view title="" note="" style="width: 12%;font-weight: bold;float: right;margin-right: 0rpx;">删除</view>
			</view>
			
			<!-- 智能变压器 -->
			<view v-for="(item, index) in Transformer" class="item">
				<view  style="width: 14%;">{{item.sign}}</view>
				<view  style="width: 45%;">智能变压器</view>
				<view  style="width: 20%;">{{item.areaName}}</view>
				<view  style="width: 10%;float: right;margin-right: 0rpx;">
					<image :data-index="index" data-name="Transformer" @click="delDevice" src="../../static/del.png" style="width: 40rpx;height: 40rpx;margin: 5rpx;"></image>
				</view> 
			</view>
			<!-- 智能环境传感器-->
			<view v-for="(item, index) in EvSensor" class="item" >
				<view  style="width: 14%;">{{item.sign}}</view>
				<view  style="width: 45%;">智能环境传感器</view>
				<view  style="width: 20%;">{{item.areaName}}</view>
				<view  style="width: 10%;float: right;margin-right: 0rpx;">
					<image :data-index="index" data-name="EvSensor" @click="delDevice" src="../../static/del.png" style="width: 40rpx;height: 40rpx;margin: 5rpx;"></image>
				</view>
			</view>
			<!-- 台区总表 -->
			<view v-for="(item, index) in AreaMeter" class="item">
				<view  style="width: 14%;">{{item.sign}}</view>
				<view  style="width: 45%;">台区总表</view>
				<view  style="width: 20%;">{{item.areaName}}</view>
				<view  style="width: 10%;float: right;margin-right: 0rpx;">
					<image :data-index="index" data-name="AreaMeter" @click="delDevice" src="../../static/del.png" style="width: 40rpx;height: 40rpx;margin: 5rpx;"></image>
				</view> 
			</view>
			<!-- 熔断器 -->
			<view v-for="(item, index) in Fuse" class="item">
				<view  style="width: 14%;">{{item.sign}}</view>
				<view  style="width: 45%;">熔断器</view>
				<view  style="width: 20%;">{{item.areaName}}</view>
				<view  style="width: 10%;float: right;margin-right: 0rpx;">
					<image :data-index="index" data-name="Fuse" @click="delDevice" src="../../static/del.png" style="width: 40rpx;height: 40rpx;margin: 5rpx;"></image>
				</view> 
			</view>
			<!-- 智能开关 -->
			<view v-for="(item, index) in IntelligentSwitch" class="item">
				<view  style="width: 14%;">{{item.sign}}</view>
				<view  style="width: 45%;">智能开关</view>
				<view  style="width: 20%;">{{item.areaName}}</view>
				<view  style="width: 10%;float: right;margin-right: 0rpx;">
					<image :data-index="index" data-name="IntelligentSwitch" @click="delDevice" src="../../static/del.png" style="width: 40rpx;height: 40rpx;margin: 5rpx;"></image>
				</view> 
			</view>
			<!-- 单相表 -->
			<view v-for="(item, index) in UniphaseMeter" class="item">
				<view  style="width: 14%;">{{item.sign}}</view>
				<view  style="width: 45%;">单相表</view>
				<view  style="width: 20%;">{{item.areaName}}</view>
				<view  style="width: 10%;float: right;margin-right: 0rpx;">
					<image :data-index="index" data-name="UniphaseMeter" @click="delDevice" src="../../static/del.png" style="width: 40rpx;height: 40rpx;margin: 5rpx;"></image>
				</view> 
			</view>
			<!-- LTU开关 -->
			<view v-for="(item, index) in LTUSwitch" class="item">
				<view  style="width: 14%;">{{item.sign}}</view>
				<view  style="width: 45%;">LTU开关</view>
				<view  style="width: 20%;">{{item.areaName}}</view>
				<view  style="width: 10%;float: right;margin-right: 0rpx;">
					<image :data-index="index" data-name="LTUSwitch" @click="delDevice" src="../../static/del.png" style="width: 40rpx;height: 40rpx;margin: 5rpx;"></image>
				</view> 
			</view>
			<!-- 换相开关 -->
			<view v-for="(item, index) in ChangePhaseSwitch" class="item">
				<view  style="width: 14%;">{{item.sign}}</view>
				<view  style="width: 45%;">换相开关</view>
				<view  style="width: 20%;">{{item.areaName}}</view>
				<view  style="width: 10%;float: right;margin-right: 0rpx;">
					<image :data-index="index" data-name="ChangePhaseSwitch" @click="delDevice" src="../../static/del.png" style="width: 40rpx;height: 40rpx;margin: 5rpx;"></image>
				</view> 
			</view>
			<!-- 电动汽车充电设施 -->
			<view v-for="(item, index) in ChargingFacility" class="item">
				<view  style="width: 14%;">{{item.sign}}</view>
				<view  style="width: 45%;">电动汽车充电设施</view>
				<view  style="width: 20%;">{{item.areaName}}</view>
				<view  style="width: 10%;float: right;margin-right: 0rpx;">
					<image :data-index="index" data-name="ChargingFacility" @click="delDevice" src="../../static/del.png" style="width: 40rpx;height: 40rpx;margin: 5rpx;"></image>
				</view> 
			</view>
			<!-- 光伏用户 -->
			<view v-for="(item, index) in PvUser" class="item">
				<view  style="width: 14%;">{{item.sign}}</view>
				<view  style="width: 45%;">光伏用户</view>
				<view  style="width: 20%;">{{item.areaName}}</view>
				<view  style="width: 10%;float: right;margin-right: 0rpx;">
					<image :data-index="index" data-name="PvUser" @click="delDevice" src="../../static/del.png" style="width: 40rpx;height: 40rpx;margin: 5rpx;"></image>
				</view> 
			</view>
			<!-- 无功补偿装置 -->
			<view v-for="(item, index) in CompensationDevice" class="item">
				<view  style="width: 14%;">{{item.sign}}</view>
				<view  style="width: 45%;">无功补偿装置</view>
				<view  style="width: 20%;">{{item.areaName}}</view>
				<view  style="width: 10%;float: right;margin-right: 0rpx;">
					<image :data-index="index" data-name="CompensationDevice" @click="delDevice" src="../../static/del.png" style="width: 40rpx;height: 40rpx;margin: 5rpx;"></image>
				</view> 
			</view>
			<!-- 电缆感知设备 -->
			<view v-for="(item, index) in CableSensingDevice" class="item">
				<view  style="width: 14%;">{{item.sign}}</view>
				<view  style="width: 45%;">电缆感知设备</view>
				<view  style="width: 20%;">{{item.areaName}}</view>
				<view  style="width: 10%;float: right;margin-right: 0rpx;">
					<image :data-index="index" data-name="CableSensingDevice" @click="delDevice" src="../../static/del.png" style="width: 40rpx;height: 40rpx;margin: 5rpx;"></image>
				</view> 
			</view>
			<!-- 三相表 -->
			<view v-for="(item, index) in ThreePhaseMeter" class="item">
				<view  style="width: 14%;">{{item.sign}}</view>
				<view  style="width: 45%;">三相表</view>
				<view  style="width: 20%;">{{item.areaName}}</view>
				<view  style="width: 10%;float: right;margin-right: 0rpx;">
					<image :data-index="index" data-name="ThreePhaseMeter" @click="delDevice" src="../../static/del.png" style="width: 40rpx;height: 40rpx;margin: 5rpx;"></image>
				</view> 
			</view>
			<!-- 智能终端 -->
			<view v-for="(item, index) in Terminal" class="item">
				<view  style="width: 14%;">{{item.sign}}</view>
				<view  style="width: 45%;">智能终端</view>
				<view  style="width: 20%;">{{item.areaName}}</view>
				<view  style="width: 10%;float: right;margin-right: 0rpx;">
					<image :data-index="index" data-name="Terminal" @click="delDevice" src="../../static/del.png" style="width: 40rpx;height: 40rpx;margin: 5rpx;"></image>
				</view> 
			</view>
		</view>

		<!-- 表单-- -->
		<!-- 表单--1智能变压器 -->
		<form @submit="formSubmit" @reset="formReset" id="Form_Transformer" :style="TransformerFormStyle">
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
					 @click="ceSelect" ref="areaName_Transformer" >
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
					 @click="ceSelect" ref="switchState_Transformer">
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
			<button form-type="submit" class="formBtn">添加</button>
			<button form-type="reset" class="formBtn">重置</button>
			<button type="default" class="formBtn" @click="formCancel">取消</button>
		</form>
		<!-- 表单--2智能环境传感器 -->
		<form @submit="formSubmit" @reset="formReset" id="Form_EvSensor" :style="EvSensorFormStyle">
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
					 @click="ceSelect" ref="areaName_EvSensor" >
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
			<button type="default" class="formBtn" @click="formCancel">取消</button>
		</form>
		<!-- 表单--3台区总表 -->
		<form @submit="formSubmit" @reset="formReset" id="Form_AreaMeter" :style="AreaMeterFormStyle">
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
					 @click="ceSelect" ref="areaName_AreaMeter" >
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
		<!-- 表单--14智能终端 -->
		<form @submit="formSubmit" @reset="formReset" id="Form_Terminal" :style="TerminalFormStyle">
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
					 @click="ceSelect" ref="areaName_Terminal" >
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
		<form @submit="formSubmit" @reset="formReset" id="Form_Fuse" :style="FuseFormStyle">
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
					 @click="ceSelect" ref="areaName_Fuse" >
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
					 @click="ceSelect" ref="switchState_Fuse" id="switchState_Fuse">
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
		<!-- 表单--5智能智能开关 -->
		<form @submit="formSubmit" @reset="formReset" id="Form_IntelligentSwitch" :style="IntelligentSwitchFormStyle">
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
					 @click="ceSelect" ref="areaName_IntelligentSwitch" >
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
					 @click="ceSelect" ref="switchState_IntelligentSwitch" >
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
		<form @submit="formSubmit" @reset="formReset" id="Form_LTUSwitch" :style="LTUSwitchFormStyle">
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
					 @click="ceSelect" ref="areaName_LTUSwitch" >
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
					 ref="switchState_LTUSwitch" >
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
		<!-- 表单--6单相表 -->
		<form @submit="formSubmit" @reset="formReset" id="Form_UniphaseMeter" :style="UniphaseMeterFormStyle">
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
					 @click="ceSelect" ref="areaName_UniphaseMeter" >
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
				<button type="default" class="formBtn" @click="formCancel">取消</button>
			</view>
			
		</form>
		<!-- 表单--8换相开关 -->
		<form @submit="formSubmit" @reset="formReset" id="Form_ChangePhaseSwitch" :style="ChangePhaseSwitchFormStyle">
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
					 @click="ceSelect" ref="areaName_ChangePhaseSwitch" >
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
					 @click="ceSelect" ref="switchState_ChangePhaseSwitch" >
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
		<form @submit="formSubmit" @reset="formReset" id="Form_ChargingFacility" :style="ChargingFacilityFormStyle">
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
					 @click="ceSelect" ref="areaName_ChargingFacility" >
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
				<button type="default" class="formBtn" @click="formCancel">取消</button>
			</view>
		</form>
		<!-- 表单--10光伏用户 -->
		<form @submit="formSubmit" @reset="formReset" id="Form_PvUser" :style="PvUserFormStyle">
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
					 @click="ceSelect" ref="areaName_PvUser" >
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
				<button type="default" class="formBtn" @click="formCancel">取消</button>
			</view>
		</form>
		<!-- 表单--11无功补偿装置 -->
		<form @submit="formSubmit" @reset="formReset" id="Form_CompensationDevice" :style="CompensationDeviceFormStyle">
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
					 @click="ceSelect" ref="areaName_CompensationDevice" >
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
					 @click="ceSelect" ref="cuttingState" id="cuttingState">
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
		<form @submit="formSubmit" @reset="formReset" id="Form_ThreePhaseMeter" :style="ThreePhaseMeterFormStyle">
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
					 @click="ceSelect" ref="areaName_ThreePhaseMeter" >
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
			<button type="default" class="formBtn" @click="formCancel">取消</button>
		</form>
		<!-- 表单--12电缆感知设备 -->
		<form @submit="formSubmit" @reset="formReset" id="Form_CableSensingDevice" :style="CableSensingDeviceFormStyle">
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
					 @click="ceSelect" ref="areaName_CableSensingDevice" >
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
			<button type="default" class="formBtn" @click="formCancel">取消</button>
		</form>
	</view>
</template>

<script>
	import {config_url} from '../../default/get_url.js'
	var _self;
	export default {
		data() {
			return {
				percent: 0,
				data_file_name: "请上传数据文件",
				srcUrl:"",
				imgStyle:{},
				courtsName:"",
				role:"",
				// deviceName:"",
				// areaName:"",
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
				
			}
		},
		methods: {
			onUpload() {
				this.$refs.lFile.upload({
					// #ifdef APP-PLUS
					currentWebview: this.$mp.page.$getAppWebview(),
					// #endif
					//默认file,上传文件的key
					name: 'uploadFile',
					// header: {'Content-Type':'类型','Authorization':'token'},
					//...其他参数
				});
			},
			onSuccess(res) {
				console.log('上传成功回调=====33====', JSON.stringify(res));
				uni.showToast({
					title: JSON.stringify(res),
					icon: 'none'
				})
			},
			test(){
				let that = this
				uni.request({
					url: config_url.baseurl + 'test',
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
						console.log(res);
					},
					fail(res) {
						console.log(res);
						
					}
				})
			},
			//判断选择的是那哪个设备，并给出相应的表单
			deviceSelect(e){
				console.log(this.$refs.deviceName.value)
				if(this.$refs.deviceName.value==""){
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
				}else if(this.$refs.deviceName.value=="智能变压器"){// document.getElementById("deviceName").value)
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
				}else if(this.$refs.deviceName.value=="智能环境传感器"){
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
				}else if(this.$refs.deviceName.value=="台区总表"){
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
				}else if(this.$refs.deviceName.value=="熔断器"){
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
				}else if(this.$refs.deviceName.value=="智能开关"){
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
				}else if(this.$refs.deviceName.value=="单相表"){
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
				}else if(this.$refs.deviceName.value=="LTU开关"){
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
				}else if(this.$refs.deviceName.value=="换相开关"){
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
				}else if(this.$refs.deviceName.value=="电动汽车充电设施"){
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
				}else if(this.$refs.deviceName.value=="光伏用户"){
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
				}else if(this.$refs.deviceName.value=="无功补偿装置"){
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
				}else if(this.$refs.deviceName.value=="电缆感知设备"){
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
				}else if(this.$refs.deviceName.value=="三相表"){
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
				}else if(this.$refs.deviceName.value=="智能终端"){
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
				}
			},
			//添加设备到本地
			formSubmit(e){
				// console.log(this.$refs.deviceName.value)
				if(this.$refs.deviceName.value=="智能变压器"){
					console.log("智能变压器表单数据：",e.detail.value  )
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_Transformer.value   			//变压器所属侧
					json.switchState = this.$refs.switchState_Transformer.value			//分接头挡位
					console.log(json)
					this.Transformer.push(json)
					this.TransformerFormStyle.display="none"
				}else if(this.$refs.deviceName.value=="智能环境传感器"){
					console.log("智能环境传感器表单数据：",e.detail.value)
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_EvSensor.value   			//变压器所属侧
					console.log(json)
					this.EvSensor.push(json)
					this.EvSensorFormStyle.display="none"
				}else if(this.$refs.deviceName.value=="台区总表"){
					console.log("台区总表表单数据：",e.detail.value)
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_AreaMeter.value   			//变压器所属侧
					console.log(json)
					this.AreaMeter.push(json)
					this.AreaMeterFormStyle.display="none"
				}else if(this.$refs.deviceName.value=="熔断器"){
					console.log("熔断器表单数据：",e.detail.value)
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_Fuse.value   			//变压器所属侧
					json.switchState = this.$refs.switchState_Fuse.value			//开关状态
					console.log(json)
					this.Fuse.push(json)
					this.FuseFormStyle.display="none"
				}else if(this.$refs.deviceName.value=="智能开关"){
					console.log("智能开关表单数据：",e.detail.value)
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_IntelligentSwitch.value   			//变压器所属侧
					json.switchState = this.$refs.switchState_IntelligentSwitch.value			//开关状态
					console.log(json)
					this.IntelligentSwitch.push(json)
					this.IntelligentSwitchFormStyle.display="none"
				}else if(this.$refs.deviceName.value=="单相表"){
					console.log("智能开关表单数据：",e.detail.value)
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_UniphaseMeter.value   			//变压器所属侧
					console.log(json)
					console.log(json)
					this.UniphaseMeter.push(json)
					this.UniphaseMeterFormStyle.display="none"
				}else if(this.$refs.deviceName.value=="LTU开关"){
					console.log("LTU开关表单数据：",e.detail.value)
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_LTUSwitch.value   			//变压器所属侧
					json.switchState = this.$refs.switchState_LTUSwitch.value
					console.log(json)
					this.LTUSwitch.push(json)
					this.LTUSwitchFormStyle.display="none"
				}else if(this.$refs.deviceName.value=="换相开关"){
					console.log("换相开关表单数据：",e.detail.value)
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_ChangePhaseSwitch.value   			//变压器所属侧
					json.switchState = this.$refs.switchState_ChangePhaseSwitch.value
					console.log(json)
					this.ChangePhaseSwitch.push(json)
					this.ChangePhaseSwitchFormStyle.display="none"
				}else if(this.$refs.deviceName.value=="电动汽车充电设施"){
					console.log("电动汽车充电设施：",e.detail.value)
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_ChargingFacility.value   			//变压器所属侧
					console.log(json)
					this.ChargingFacility.push(json)
					this.ChargingFacilityFormStyle.display="none"
				}else if(this.$refs.deviceName.value=="光伏用户"){
					console.log("光伏用户表单数据：",e.detail.value)
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_PvUser.value   			//变压器所属侧
					console.log(json)
					this.PvUser.push(json)
					this.PvUserFormStyle.display="none"
				}else if(this.$refs.deviceName.value=="无功补偿装置"){
					console.log("无功补偿装置表单数据：",e.detail.value)
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_CompensationDevice.value   			//变压器所属侧
					json.cuttingState = this.$refs.cuttingState.value
					console.log(json)
					this.CompensationDevice.push(json)
					this.CompensationDeviceFormStyle.display="none"
				}else if(this.$refs.deviceName.value=="电缆感知设备"){
					console.log("电缆感知设备表单数据：",e.detail.value)
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_CableSensingDevice.value   			//变压器所属侧
					console.log(json)
					this.CableSensingDevice.push(json)
					this.CableSensingDeviceFormStyle.display="none"
				}else if(this.$refs.deviceName.value=="三相表"){
					console.log("三相表表单数据：",e.detail.value)
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_ThreePhaseMeter.value   			//变压器所属侧
					console.log(json)
					this.ThreePhaseMeter.push(json)
					this.ThreePhaseMeterFormStyle.display="none"
				}else if(this.$refs.deviceName.value=="智能终端"){
					console.log("智能终端表单数据：",e.detail.value)
					var json = {}
					json = e.detail.value  
					json.areaName = this.$refs.areaName_Terminal.value   			//变压器所属侧
					console.log(json)
					this.Terminal.push(json)
					this.TerminalFormStyle.display="none"
				}
				

			},
			//隐藏所有表单
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
			},
			// 删除EvSensor设备
			delDevice(e){
				let that =this;
				console.log(e.currentTarget.dataset)
				var deviceName = e.currentTarget.dataset.name
				var index = e.currentTarget.dataset.index
				//1.判断需要删除哪个设备
				if(deviceName=="Transformer"){
					uni.showModal({
						title: '提示',
						content:"确定删除此条数据？",
						success(e) {
							if(e.confirm){
								that.Transformer.splice(index,1)
							}
						}
					})
				}else if(deviceName=="EvSensor"){
					uni.showModal({
						title: '提示',
						content:"确定删除此条数据？",
						success(e) {
							if(e.confirm){
								that.EvSensor.splice(index,1)
							}
						}
					})
				}else if(deviceName=="AreaMeter"){
					uni.showModal({
						title: '提示',
						content:"确定删除此条数据？",
						success(e) {
							if(e.confirm){
								that.AreaMeter.splice(index,1)
							}
						}
					})
				}else if(deviceName=="Fuse"){
					uni.showModal({
						title: '提示',
						content:"确定删除此条数据？",
						success(e) {
							if(e.confirm){
								that.Fuse.splice(index,1)
							}
						}
					})
				}else if(deviceName=="IntelligentSwitch"){
					uni.showModal({
						title: '提示',
						content:"确定删除此条数据？",
						success(e) {
							if(e.confirm){
								that.IntelligentSwitch.splice(index,1)
							}
						}
					})
				}else if(deviceName=="UniphaseMeter"){
					uni.showModal({
						title: '提示',
						content:"确定删除此条数据？",
						success(e) {
							if(e.confirm){
								that.UniphaseMeter.splice(index,1)
							}
						}
					})
				}else if(deviceName=="LTUSwitch"){
					uni.showModal({
						title: '提示',
						content:"确定删除此条数据？",
						success(e) {
							if(e.confirm){
								that.LTUSwitch.splice(index,1)
							}
						}
					})
				}else if(deviceName=="ChangePhaseSwitch"){
					uni.showModal({
						title: '提示',
						content:"确定删除此条数据？",
						success(e) {
							if(e.confirm){
								that.ChangePhaseSwitch.splice(index,1)
							}
						}
					})
				}else if(deviceName=="ChargingFacility"){
					uni.showModal({
						title: '提示',
						content:"确定删除此条数据？",
						success(e) {
							if(e.confirm){
								that.ChargingFacility.splice(index,1)
							}
						}
					})
				}else if(deviceName=="PvUser"){
					uni.showModal({
						title: '提示',
						content:"确定删除此条数据？",
						success(e) {
							if(e.confirm){
								that.PvUser.splice(index,1)
							}
						}
					})
				}else if(deviceName=="CompensationDevice"){
					uni.showModal({
						title: '提示',
						content:"确定删除此条数据？",
						success(e) {
							if(e.confirm){
								that.CompensationDevice.splice(index,1)
							}
						}
					})
				}else if(deviceName=="CableSensingDevice"){
					uni.showModal({
						title: '提示',
						content:"确定删除此条数据？",
						success(e) {
							if(e.confirm){
								that.CableSensingDevice.splice(index,1)
							}
						}
					})
				}else if(deviceName=="ThreePhaseMeter"){
					uni.showModal({
						title: '提示',
						content:"确定删除此条数据？",
						success(e) {
							if(e.confirm){
								that.ThreePhaseMeter.splice(index,1)
							}
						}
					})
				}else if(deviceName=="Terminal"){
					uni.showModal({
						title: '提示',
						content:"确定删除此条数据？",
						success(e) {
							if(e.confirm){
								that.Terminal.splice(index,1)
							}
						}
					})
				}
				
				
			},

			chooseImage:function(){
				let that = this;
				uni.chooseImage({
					count: 1,
					sizeType: ['original', 'compressed'],
					sourceType: ['album', 'camera'],
					success (res) {
						that.srcUrl = res.tempFilePaths[0],
						console.log("选择图片成功：",res)
						uni.getImageInfo({
							src:res.tempFilePaths[0],
							success(res) {
								that.imgStyle={"width": res.width*2+"rpx","height": res.height*2+"rpx"}
							}
						})
					}
				})
			},
		
			chooseDataFile:function(){
				_self = this;
				uni.chooseFile({
					count: 1, //默认1
					extension:['.xlsx','.xlsm', 'xls', 'csv'],  //传表格类型文件
					success: function (res) {  //选择文件成功后的回调，会将文件数据放置在res中
						console.log("文件选择成功:",res)
						var files = res.tempFiles[0];
						var filesPaths = res.tempFilePaths[0];
						var uper = uni.uploadFile({
							url: config_url.baseurl + "/test/fileload",
							filePath: filesPaths,
							name: 'datafile',
							formData:{
								"username": "LPT"
							},
							success(response) {
								console.log("回调：", response);
								if(response.statusCode == 200){
									uni.showToast({
										title:response.data,
										duration: 2000
									})
								}
								else{
									uni.showToast({
										title: response.statusCode + ' × Failed!',
										icon: 'none'
									})
								}
							}
						});
						uper.onProgressUpdate(function(e){
							_self.percent = res.progress;
						})
					}
				})
			}
		
		
		},
		
		onNavigationBarButtonTap(e){
			let that = this;
			if(e.text=="上传"){
				if(that.courtsName==""){
					uni.showModal({
						title:"提示",
						content:"台区名称未填"
					})
					return 0;
				}
				if(that.srcUrl==""){
					uni.showModal({
						title:"提示",
						content:"未选择图片"
					})
					return 0;
				}
				
				uni.uploadFile({
					url: config_url.baseurl + 'uploadInfoByhand',
				    filePath: that.srcUrl,
				    name: 'imageFile',
					formData:{ 
						infoType:1,
						courtsName:that.courtsName,
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
				    success (res){
				        console.log(JSON.parse(res.data))
						var res_data = JSON.parse(res.data)
						if(res_data.stateCode==1){
							var icon = "success"
							setInterval(function(){
								uni.navigateBack({
									
								})
							}, 2000)
							
						}else{
							var icon = "error"
						}
						uni.showToast({
							title: res_data.info,
							icon: icon,
							duration: 3000
						})
					}
				})
			}
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
.box_file{
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

.filename_view{
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


.chooseFileBtn{
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
	display: flex;
	justify-content: space-between;
	flex-wrap: wrap;
}

.deviceSelect{
	width: 38%;
	height: 50rpx;
	margin-top: 6rpx;
	border-radius: 10rpx;
	font-size: small;
	margin-left: 20rpx;box-sizing: border-box; 
}
.itemClass_1{
	background-color: #F1F1F1;
}
.itemClass_2{
	background-color: #F8F8F8;
}
.item{
	list-style: none;
	display: block;
	width: 100%;
	height: 50rpx;
	line-height: 50rpx;
	margin-top: 10rpx;
	border-bottom:  1rpx solid #333333; 
	display: flex;justify-content: space-between;flex-wrap: wrap;
}



form{
	border-radius: 20rpx;
	width: 95%;
	margin-top: 20rpx;
	margin: 20rpx auto;
	position: absolute;
	top: 590rpx;
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
.icon{
	width: 40rpx;height: 40rpx;margin: 5rpx;float: right;
}
</style>
