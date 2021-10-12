/*
Navicat MySQL Data Transfer

Source Server         : Connection
Source Server Version : 80026
Source Host           : localhost:3306
Source Database       : database_1

Target Server Type    : MYSQL
Target Server Version : 80026
File Encoding         : 65001

Date: 2021-10-12 16:06:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for area_meter
-- ----------------------------
DROP TABLE IF EXISTS `area_meter`;
CREATE TABLE `area_meter` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sign` float(10,2) DEFAULT NULL,
  `areaName` char(10) DEFAULT NULL,
  `courtsId` int DEFAULT NULL,
  `voltage_A` float(10,2) DEFAULT NULL,
  `voltage_B` float(10,2) DEFAULT NULL,
  `voltage_C` float(10,2) DEFAULT NULL,
  `current_A` float(10,2) DEFAULT NULL,
  `current_B` float(10,2) DEFAULT NULL,
  `current_C` float(10,2) DEFAULT NULL,
  `activePower_A` float(10,2) DEFAULT NULL,
  `activePower_B` float(10,2) DEFAULT NULL,
  `activePower_C` float(10,2) DEFAULT NULL,
  `activePower_Total` float(10,2) DEFAULT NULL,
  `reactivePower_A` float(10,2) DEFAULT NULL,
  `reactivePower_B` float(10,2) DEFAULT NULL,
  `reactivePower_C` float(10,2) DEFAULT NULL,
  `reactivePower_Total` float(10,2) DEFAULT NULL,
  `apparentPower_A` float(10,2) DEFAULT NULL,
  `apparentPower_B` float(10,2) DEFAULT NULL,
  `apparentPower_C` float(10,2) DEFAULT NULL,
  `apparentPower_Total` float(10,2) DEFAULT NULL,
  `distributionLoadRate` float(10,2) DEFAULT NULL,
  `voltagePassRate` float(10,2) DEFAULT NULL,
  `humiture` float(10,2) DEFAULT NULL,
  `gasConcentration` float(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of area_meter
-- ----------------------------
INSERT INTO `area_meter` VALUES ('1', '4.00', '用户侧', '2', '4.00', '4.00', '4.00', '4.00', '4.00', '4.00', '4.00', '4.00', '4.00', '4.00', '4.00', '4.00', '4.00', '4.00', '4.00', '4.00', '4.00', '4.00', '4.00', '4.00', '4.00', '4.00');
INSERT INTO `area_meter` VALUES ('2', '6.00', '中压侧', '5', '66.00', '66666.00', '66.00', '6.00', '6.00', '6.00', '6.00', '6.00', '6.00', '6.00', '6.00', '66.00', null, '66.00', '6.00', '6.00', '6.00', '6.00', '6.00', '66.00', '6.00', '6.00');

-- ----------------------------
-- Table structure for baseinfo
-- ----------------------------
DROP TABLE IF EXISTS `baseinfo`;
CREATE TABLE `baseinfo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `courtId` int DEFAULT NULL,
  `courtName` varchar(255) DEFAULT NULL,
  `capacity` float(255,0) DEFAULT NULL,
  `radius` float(255,2) DEFAULT NULL,
  `load_rate` float(255,2) DEFAULT NULL,
  `power_sale` float(255,2) DEFAULT NULL,
  `power_apply` float(255,2) DEFAULT NULL,
  `pre_line_loss` float(255,2) NOT NULL,
  `real_line_loss` float(255,2) NOT NULL,
  `error_line_loss` float(255,2) DEFAULT NULL,
  `load_unbalance_rate` float(255,2) DEFAULT NULL,
  `power_reliability` float(255,2) DEFAULT NULL,
  `voltage_pass_percent` float(255,2) DEFAULT NULL,
  `state_res` int NOT NULL,
  `time` varchar(255) NOT NULL,
  PRIMARY KEY (`id`,`time`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of baseinfo
-- ----------------------------
INSERT INTO `baseinfo` VALUES ('4', '1', '测试台区_1', '70', '20.00', '70.00', '119.00', '121.00', '2.05', '1.65', '0.40', '4.23', '99.80', '99.50', '1', '2021-10-07');
INSERT INTO `baseinfo` VALUES ('5', '1', '测试台区_1', '75', '21.00', '60.00', '120.00', '122.00', '1.65', '1.85', '0.20', '4.55', '99.50', '99.10', '2', '2021-10-06');
INSERT INTO `baseinfo` VALUES ('6', '1', '测试台区_1', '75', '26.00', '65.00', '120.00', '122.00', '1.85', '1.85', '0.00', '4.55', '99.50', '99.10', '2', '2021-10-05');
INSERT INTO `baseinfo` VALUES ('7', '2', '测试台区_2', '70', '29.00', '75.00', '119.00', '121.00', '1.95', '3.65', '1.70', '4.23', '99.80', '99.50', '2', '2021-10-07');
INSERT INTO `baseinfo` VALUES ('8', '1', '测试台区_1', '75', '30.00', '75.00', '115.00', '135.00', '2.65', '2.45', '0.20', '5.35', '94.60', '95.94', '5', '2021-10-10');
INSERT INTO `baseinfo` VALUES ('9', '1', '测试台区_1', '75', '30.00', '75.00', '115.00', '135.00', '2.65', '2.45', '0.20', '5.35', '94.60', '95.94', '5', '2021-10-01');
INSERT INTO `baseinfo` VALUES ('10', '1', '测试台区_1', '75', '30.00', '75.00', '115.00', '135.00', '2.65', '2.45', '0.20', '5.35', '94.60', '95.94', '5', '2021-10-04');
INSERT INTO `baseinfo` VALUES ('11', '1', '测试台区_1', '75', '30.00', '75.00', '115.00', '135.00', '1.65', '2.33', '0.68', '5.35', '94.60', '95.94', '4', '2021-09-01');

-- ----------------------------
-- Table structure for cable_sensing_device
-- ----------------------------
DROP TABLE IF EXISTS `cable_sensing_device`;
CREATE TABLE `cable_sensing_device` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sign` float(8,2) DEFAULT NULL,
  `areaName` char(10) DEFAULT NULL,
  `courtsId` int DEFAULT NULL,
  `temperature` float(10,2) DEFAULT NULL,
  `displacement` float(10,2) DEFAULT NULL,
  `harmfulGas` char(50) CHARACTER SET utf8 COLLATE utf8_czech_ci DEFAULT NULL,
  `combustibleGas` char(50) CHARACTER SET utf8 COLLATE utf8_czech_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of cable_sensing_device
-- ----------------------------

-- ----------------------------
-- Table structure for change_phase_switch
-- ----------------------------
DROP TABLE IF EXISTS `change_phase_switch`;
CREATE TABLE `change_phase_switch` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sign` float(10,2) DEFAULT NULL,
  `areaName` char(10) DEFAULT NULL,
  `courtsId` int DEFAULT NULL,
  `voltage_A` float(10,2) DEFAULT NULL,
  `voltage_B` float(10,2) DEFAULT NULL,
  `voltage_C` float(10,2) DEFAULT NULL,
  `current_A` float(10,2) DEFAULT NULL,
  `current_B` float(10,2) DEFAULT NULL,
  `current_C` float(10,2) DEFAULT NULL,
  `switchState` char(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of change_phase_switch
-- ----------------------------

-- ----------------------------
-- Table structure for charging_facility
-- ----------------------------
DROP TABLE IF EXISTS `charging_facility`;
CREATE TABLE `charging_facility` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sign` float(10,2) DEFAULT NULL,
  `areaName` char(10) DEFAULT NULL,
  `courtsId` int DEFAULT NULL,
  `voltage_A` float(10,2) DEFAULT NULL,
  `voltage_B` float(10,2) DEFAULT NULL,
  `voltage_C` float(10,2) DEFAULT NULL,
  `current_A` float(10,2) DEFAULT NULL,
  `current_B` float(10,2) DEFAULT NULL,
  `current_C` float(10,2) DEFAULT NULL,
  `powerFactor` float(10,2) DEFAULT NULL,
  `activePower_A` float(10,2) DEFAULT NULL,
  `activePower_B` float(10,2) DEFAULT NULL,
  `activePower_C` float(10,2) DEFAULT NULL,
  `activePower_Total` float(10,2) DEFAULT NULL,
  `reactivePower_A` float(10,2) DEFAULT NULL,
  `reactivePower_B` float(10,2) DEFAULT NULL,
  `reactivePower_C` float(10,2) DEFAULT NULL,
  `reactivePower_Total` float(10,2) DEFAULT NULL,
  `totalEnergyValue_PositiveActive` float(10,2) DEFAULT NULL,
  `totalEnergyValue_PositiveReactive` float(10,2) DEFAULT NULL,
  `totalEnergyValue_NegativeActive` float(10,2) DEFAULT NULL,
  `totalEnergyValue_NegativeReactive` float(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of charging_facility
-- ----------------------------

-- ----------------------------
-- Table structure for checkdata
-- ----------------------------
DROP TABLE IF EXISTS `checkdata`;
CREATE TABLE `checkdata` (
  `checkId` int NOT NULL AUTO_INCREMENT,
  `checkName` char(50) DEFAULT NULL,
  `checkContent` char(200) DEFAULT NULL,
  `checkResult` char(200) DEFAULT NULL,
  `checkPeo` char(20) DEFAULT '',
  `checkTime` varchar(255) DEFAULT NULL,
  `courtsId` int DEFAULT NULL,
  PRIMARY KEY (`checkId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of checkdata
-- ----------------------------
INSERT INTO `checkdata` VALUES ('1', '变压器检测', '检测变压器是否异常', '无异常', '张三', '2021-03-20', '1');
INSERT INTO `checkdata` VALUES ('2', '智能变压器主硬板更换', '沪城环路橄榄路智能变压器主板硬件更换', '更换主板成功', '张三', '2021-10-10 16:00:00.0', '1');

-- ----------------------------
-- Table structure for compensation_device
-- ----------------------------
DROP TABLE IF EXISTS `compensation_device`;
CREATE TABLE `compensation_device` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sign` float(10,2) DEFAULT NULL,
  `areaName` char(10) DEFAULT NULL,
  `courtsId` int DEFAULT NULL,
  `voltage_A` float(10,2) DEFAULT NULL,
  `voltage_B` float(10,2) DEFAULT NULL,
  `voltage_C` float(10,2) DEFAULT NULL,
  `voltage_AB` float(10,2) DEFAULT NULL,
  `voltage_BC` float(10,2) DEFAULT NULL,
  `voltage_CA` float(10,2) DEFAULT NULL,
  `current_A` float(10,2) DEFAULT NULL,
  `current_B` float(10,2) DEFAULT NULL,
  `current_C` float(10,2) DEFAULT NULL,
  `activePower_A` float(10,2) DEFAULT NULL,
  `activePower_B` float(10,2) DEFAULT NULL,
  `activePower_C` float(10,2) DEFAULT NULL,
  `activePower_Total` float(10,2) DEFAULT NULL,
  `reactivePower_A` float(10,2) DEFAULT NULL,
  `reactivePower_B` float(10,2) DEFAULT NULL,
  `reactivePower_C` float(10,2) DEFAULT NULL,
  `reactivePower_Total` float(10,2) DEFAULT NULL,
  `powerFactor_A` float(10,2) DEFAULT NULL,
  `powerFactor_B` float(10,2) DEFAULT NULL,
  `powerFactor_C` float(10,2) DEFAULT NULL,
  `powerFactor_Total` float(10,2) DEFAULT NULL,
  `ratedCapacity` float(10,2) DEFAULT NULL,
  `cuttingState` char(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of compensation_device
-- ----------------------------

-- ----------------------------
-- Table structure for courts
-- ----------------------------
DROP TABLE IF EXISTS `courts`;
CREATE TABLE `courts` (
  `courtsId` int NOT NULL AUTO_INCREMENT,
  `courtsName` char(50) DEFAULT NULL,
  `courtsImageUrl` char(50) DEFAULT NULL,
  PRIMARY KEY (`courtsId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of courts
-- ----------------------------
INSERT INTO `courts` VALUES ('1', '测试台区_1', '2668d753-3658-4dff-9db3-0600d6a73f2f.png');
INSERT INTO `courts` VALUES ('2', '测试台区_2', '8259a66a-9c50-4227-806d-1d0ea4c3c51f.png');
INSERT INTO `courts` VALUES ('3', '测试台区_3', '3b294403-6cce-4d80-96c2-3c801c944301.png');
INSERT INTO `courts` VALUES ('6', '临港台区', '7fa4797b-fa5d-4c91-9d7b-a397e7ef159f.png');
INSERT INTO `courts` VALUES ('7', '杨浦台区', 'ed4e24f5-e776-49bb-8d80-76e80f32f99b.png');
INSERT INTO `courts` VALUES ('8', '徐汇台区', 'eb21cdb7-4651-4020-a4f5-b4e72009ca47.png');
INSERT INTO `courts` VALUES ('9', '浦东新区台区', 'ee205a0d-546f-4c9e-9a01-33081f65fb78.png');
INSERT INTO `courts` VALUES ('10', '静安台区', 'f6a9d48a-446a-479a-bb38-394b420d915c.png');
INSERT INTO `courts` VALUES ('11', '陆家嘴台区', '76d810fc-76e4-4ab6-a3a9-16820aae3d84.png');

-- ----------------------------
-- Table structure for deal
-- ----------------------------
DROP TABLE IF EXISTS `deal`;
CREATE TABLE `deal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userId` int NOT NULL,
  `courtId` int NOT NULL,
  `trading_power` varchar(255) NOT NULL,
  `price` float(255,2) NOT NULL,
  `deal_time` varchar(255) NOT NULL,
  `response_start_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `response_end_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of deal
-- ----------------------------
INSERT INTO `deal` VALUES ('1', '1', '1', '20.0', '27.60', '2021-10-08 04:57:32', '2021-10-0820 :00:00', null);
INSERT INTO `deal` VALUES ('2', '1', '1', '20.0', '27.60', '2021-10-08 04:57:33', '2021-10-0819 :00:00', null);
INSERT INTO `deal` VALUES ('3', '1', '1', '20.0', '27.60', '2021-10-08 04:57:35', '2021-10-0819 :00:00', null);
INSERT INTO `deal` VALUES ('4', '1', '1', '20.0', '27.60', '2021-10-08 04:57:37', '2021-10-0816 :00:00', null);
INSERT INTO `deal` VALUES ('5', '1', '1', '20.0', '27.60', '2021-10-08 04:58:58', '2021-10-08 17:00:00', '2021-10-08 19:00:00');
INSERT INTO `deal` VALUES ('6', '1', '1', '20.0', '27.60', '2021-10-08 04:59:00', '2021-10-08 19:00:00', '2021-10-08 21:00:00');
INSERT INTO `deal` VALUES ('7', '1', '1', '20.0', '27.60', '2021-10-08 04:59:25', '2021-10-08 18:00:00', '2021-10-08 20:00:00');

-- ----------------------------
-- Table structure for ev_sensor
-- ----------------------------
DROP TABLE IF EXISTS `ev_sensor`;
CREATE TABLE `ev_sensor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sign` float(8,2) DEFAULT NULL,
  `areaName` char(10) DEFAULT NULL,
  `courtsId` int DEFAULT NULL,
  `temperature` float(10,2) DEFAULT NULL,
  `humidity` float(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of ev_sensor
-- ----------------------------
INSERT INTO `ev_sensor` VALUES ('1', '2.00', '配变侧', '1', '2.00', '2.00');
INSERT INTO `ev_sensor` VALUES ('2', '2.10', '低压侧', '1', '2.00', '2.00');
INSERT INTO `ev_sensor` VALUES ('3', '156.00', '中压侧', '9', null, null);
INSERT INTO `ev_sensor` VALUES ('4', '9612.00', '中压侧', '10', null, null);
INSERT INTO `ev_sensor` VALUES ('5', '9654.00', '中压侧', '11', null, null);

-- ----------------------------
-- Table structure for fuse
-- ----------------------------
DROP TABLE IF EXISTS `fuse`;
CREATE TABLE `fuse` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sign` float(8,2) DEFAULT NULL,
  `areaName` char(10) DEFAULT NULL,
  `courtsId` int DEFAULT NULL,
  `voltage` float(10,2) DEFAULT NULL,
  `current` float(10,2) DEFAULT NULL,
  `switchState` char(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of fuse
-- ----------------------------
INSERT INTO `fuse` VALUES ('1', '3.00', '中压侧', '1', '3.00', '3.00', '合闸');

-- ----------------------------
-- Table structure for intelligent_switch
-- ----------------------------
DROP TABLE IF EXISTS `intelligent_switch`;
CREATE TABLE `intelligent_switch` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sign` float(10,2) DEFAULT NULL,
  `areaName` char(10) DEFAULT NULL,
  `courtsId` int DEFAULT NULL,
  `voltage_A` float(10,2) DEFAULT NULL,
  `voltage_B` float(10,2) DEFAULT NULL,
  `voltage_C` float(10,2) DEFAULT NULL,
  `current_A` float(10,2) DEFAULT NULL,
  `current_B` float(10,2) DEFAULT NULL,
  `current_C` float(10,2) DEFAULT NULL,
  `contactTemperature` float(10,2) DEFAULT NULL,
  `switchState` char(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of intelligent_switch
-- ----------------------------
INSERT INTO `intelligent_switch` VALUES ('1', '3.00', '低压侧', '2', '3.00', '3.00', '3.00', '3.00', '3.00', '3.00', '3.00', '合闸');
INSERT INTO `intelligent_switch` VALUES ('2', '2.00', '线路侧', '3', '2.00', '2.00', '2.00', '2.00', '2.00', '2.00', '2.00', '合闸');
INSERT INTO `intelligent_switch` VALUES ('3', '2.00', '线路侧', '4', '2.00', '2.00', '2.00', '2.00', '2.00', '2.00', '2.00', '合闸');
INSERT INTO `intelligent_switch` VALUES ('4', '2.00', '线路侧', '5', '2.00', '2.00', '2.00', '2.00', '2.00', '2.00', '2.00', '合闸');

-- ----------------------------
-- Table structure for ltu_switch
-- ----------------------------
DROP TABLE IF EXISTS `ltu_switch`;
CREATE TABLE `ltu_switch` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sign` float(10,2) DEFAULT NULL,
  `areaName` char(10) DEFAULT NULL,
  `courtsId` int DEFAULT NULL,
  `voltage_A` float(10,2) DEFAULT NULL,
  `voltage_B` float(10,2) DEFAULT NULL,
  `voltage_C` float(10,2) DEFAULT NULL,
  `current_A` float(10,2) DEFAULT NULL,
  `current_B` float(10,2) DEFAULT NULL,
  `current_C` float(10,2) DEFAULT NULL,
  `contactTemperature` float(10,2) DEFAULT NULL,
  `switchState` char(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of ltu_switch
-- ----------------------------

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `noticeId` int NOT NULL AUTO_INCREMENT,
  `noticeTitle` char(60) DEFAULT NULL,
  `noticeContent` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `noticePeo` char(20) DEFAULT '',
  `noticeTime` varchar(255) DEFAULT NULL,
  `viewNum` int DEFAULT NULL,
  PRIMARY KEY (`noticeId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('10', '台区断网通知', '台区全体用户： \n\n由于核心设备和系统需要进行升级，将于2021年10月12日（周二）晚22点-24点进行升级，升级期间网络将中断，对此造成不便敬请谅解！ \n\n \n\n信息技术中心 \n\n2021年10月11日', '张卫国', '2021-09-11', '85');
INSERT INTO `notice` VALUES ('11', '中层干部培训通知', '各部（室）：\n　　根据工作需要，经公司研究，决定召开中层干部培训会议。现将有关事宜通知如下：\n　　一、会议时间\n　　2021年6月18日——6月25日。\n\n　　二、会议地点\n　　统战部6楼会议室。\n　　三、参会人员\n　　项目总监（负责人）、总监代表等。\n　　四、会议内容及安排\n　　1、中层干部培训会议（6月18日10：00——17：00）。\n　　2、团队建设活动（6月19日——6月20日）。\n　　五、参会要求\n　　1、请参会人员安排好项目工作，按要求准时参会，不得无故缺席。\n　　2、服从会议组委会的安排，遵守会场纪律，不得中途退场。\n　　3、要求与会人员4月18日9：30到达会场，综合办公室组织签到。\n\n　　2021年6月15日', '方治国', '2021-6-17', '30');
INSERT INTO `notice` VALUES ('12', '图文形式会议报告', '各分、子公司：\n　　经研究决定，公司于2021年8月初召开经营生产例会。为提高会议质量和效率，公司决定，此次会议各分、子公司经理结合多媒体图文形式向会议报告工作。现将会议准备工作要求如下：\n　　1、各分、子公司要提前做好资料收集与整理工作，按附件大纲的格式，使用Microsoft powerpoint软件，编制汇报文件，并于2021年7月31日18：00之前，上报公司综合部邮箱。\n\n　　2、公司综合部汇总各单位上报文件后，进行整理，及时与上报单位联系修订事务，并做好技术指导工作。\n　　3、会务联系人：张建国，联系电话：13223156835。\n　　4、会议时间、地点等事宜另行通知。\n\n　　2021年7月15日', '张建国', '2021-7-15', '28');

-- ----------------------------
-- Table structure for pv_user
-- ----------------------------
DROP TABLE IF EXISTS `pv_user`;
CREATE TABLE `pv_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sign` float(8,2) DEFAULT NULL,
  `areaName` char(10) DEFAULT NULL,
  `courtsId` int DEFAULT NULL,
  `voltage` float(10,2) DEFAULT NULL,
  `current` float(10,2) DEFAULT NULL,
  `power` float(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of pv_user
-- ----------------------------
INSERT INTO `pv_user` VALUES ('1', '4.30', '低压侧', '1', '1.00', '1.00', '1.00');

-- ----------------------------
-- Table structure for tb_test_count
-- ----------------------------
DROP TABLE IF EXISTS `tb_test_count`;
CREATE TABLE `tb_test_count` (
  `id` bigint NOT NULL,
  `mc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `xh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tb_test_count
-- ----------------------------

-- ----------------------------
-- Table structure for terminal
-- ----------------------------
DROP TABLE IF EXISTS `terminal`;
CREATE TABLE `terminal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sign` float(10,2) DEFAULT NULL,
  `areaName` char(10) DEFAULT NULL,
  `courtsId` int DEFAULT NULL,
  `voltage_A` float(10,2) DEFAULT NULL,
  `voltage_B` float(10,2) DEFAULT NULL,
  `voltage_C` float(10,2) DEFAULT NULL,
  `current_A` float(10,2) DEFAULT NULL,
  `current_B` float(10,2) DEFAULT NULL,
  `current_C` float(10,2) DEFAULT NULL,
  `activePower_A` float(10,2) DEFAULT NULL,
  `activePower_B` float(10,2) DEFAULT NULL,
  `activePower_C` float(10,2) DEFAULT NULL,
  `activePower_Total` float(10,2) DEFAULT NULL,
  `reactivePower_A` float(10,2) DEFAULT NULL,
  `reactivePower_B` float(10,2) DEFAULT NULL,
  `reactivePower_C` float(10,2) DEFAULT NULL,
  `reactivePower_Total` float(10,2) DEFAULT NULL,
  `apparentPower_A` float(10,2) DEFAULT NULL,
  `apparentPower_B` float(10,2) DEFAULT NULL,
  `apparentPower_C` float(10,2) DEFAULT NULL,
  `apparentPower_Total` float(10,2) DEFAULT NULL,
  `distributionLoadRate` float(10,2) DEFAULT NULL,
  `voltagePassRate` float(10,2) DEFAULT NULL,
  `humiture` float(10,2) DEFAULT NULL,
  `gasConcentration` float(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of terminal
-- ----------------------------

-- ----------------------------
-- Table structure for three_phase_meter
-- ----------------------------
DROP TABLE IF EXISTS `three_phase_meter`;
CREATE TABLE `three_phase_meter` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sign` float(10,2) DEFAULT NULL,
  `areaName` char(10) DEFAULT NULL,
  `courtsId` int DEFAULT NULL,
  `voltage_A` float(10,2) DEFAULT NULL,
  `voltage_B` float(10,2) DEFAULT NULL,
  `voltage_C` float(10,2) DEFAULT NULL,
  `current_A` float(10,2) DEFAULT NULL,
  `current_B` float(10,2) DEFAULT NULL,
  `current_C` float(10,2) DEFAULT NULL,
  `activePower_A` float(10,2) DEFAULT NULL,
  `activePower_B` float(10,2) DEFAULT NULL,
  `activePower_C` float(10,2) DEFAULT NULL,
  `activePower_Total` float(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of three_phase_meter
-- ----------------------------

-- ----------------------------
-- Table structure for transformer
-- ----------------------------
DROP TABLE IF EXISTS `transformer`;
CREATE TABLE `transformer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sign` float(10,2) DEFAULT NULL,
  `areaName` char(10) CHARACTER SET utf8 COLLATE utf8_czech_ci DEFAULT NULL,
  `courtsId` int DEFAULT NULL,
  `voltage_A` float(10,2) DEFAULT NULL,
  `voltage_B` float(10,2) DEFAULT NULL,
  `voltage_C` float(10,2) DEFAULT NULL,
  `voltage_AB` float(10,2) DEFAULT NULL,
  `voltage_BC` float(10,2) DEFAULT NULL,
  `voltage_CA` float(10,2) DEFAULT NULL,
  `current_A` float(10,2) DEFAULT NULL,
  `current_B` float(10,2) DEFAULT NULL,
  `current_C` float(10,2) DEFAULT NULL,
  `switchState` char(8) DEFAULT NULL,
  `poleTemperature` float(10,2) DEFAULT NULL,
  `oilTemperature` float(10,2) DEFAULT NULL,
  `oilPosition` float(10,2) DEFAULT NULL,
  `insidePressure` float(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of transformer
-- ----------------------------
INSERT INTO `transformer` VALUES ('1', '1.00', '中压侧', '1', '1.00', '1.00', '1.00', '1.00', '1.00', '1.00', '1.00', '1.00', '1.00', '分闸', '1.00', '1.00', '1.00', '1.00');
INSERT INTO `transformer` VALUES ('2', '1.00', '配变侧', '2', '1.00', '1.00', '1.00', '1.00', '1.00', '1.00', '1.00', '1.00', '1.00', '分闸', '1.00', '1.00', '1.00', '1.00');
INSERT INTO `transformer` VALUES ('3', '1.00', '中压侧', '3', '1.00', '1.00', '1.00', '1.00', '1.00', '1.00', '1.00', '1.00', '1.00', '合闸', '1.00', '1.00', '1.00', '1.00');
INSERT INTO `transformer` VALUES ('4', '1.00', '中压侧', '4', '1.00', '1.00', '1.00', '1.00', '1.00', '1.00', '1.00', '1.00', '1.00', '合闸', '1.00', '1.00', '1.00', '1.00');
INSERT INTO `transformer` VALUES ('5', '1.00', '中压侧', '5', '1.00', '1.00', '1.00', '1.00', '1.00', '1.00', '1.00', '1.00', '1.00', '合闸', '1.00', '1.00', '1.00', '1.00');
INSERT INTO `transformer` VALUES ('6', '265.00', '中压侧', '6', null, null, null, null, null, null, null, null, null, '合闸', null, null, null, null);
INSERT INTO `transformer` VALUES ('7', '126.00', '中压侧', '7', null, null, null, null, null, null, null, null, null, '合闸', null, null, null, null);
INSERT INTO `transformer` VALUES ('8', '269.00', '中压侧', '8', null, null, null, null, null, null, null, null, null, '合闸', null, null, null, null);

-- ----------------------------
-- Table structure for uniphase_meter
-- ----------------------------
DROP TABLE IF EXISTS `uniphase_meter`;
CREATE TABLE `uniphase_meter` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sign` float(10,2) DEFAULT NULL,
  `areaName` char(10) DEFAULT NULL,
  `courtsId` int DEFAULT NULL,
  `voltage` float(10,2) DEFAULT NULL,
  `current` float(10,2) DEFAULT NULL,
  `power` float(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of uniphase_meter
-- ----------------------------
INSERT INTO `uniphase_meter` VALUES ('1', '3.00', '中压侧', '3', '3.00', '3.00', '3.00');
INSERT INTO `uniphase_meter` VALUES ('3', '3.00', '中压侧', '5', '3.00', '3.00', '3.00');
INSERT INTO `uniphase_meter` VALUES ('4', '7.00', '配变侧', '5', '7.00', '77.00', '7.00');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `userName` char(30) DEFAULT NULL,
  `userPwd` char(32) DEFAULT NULL,
  `phone` char(11) DEFAULT NULL,
  `role` int DEFAULT NULL,
  `state` int DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123', '13564884723', '2', '1');
INSERT INTO `user` VALUES ('2', 'YYY', '111111', '13564884724', '1', '1');
INSERT INTO `user` VALUES ('3', 'JJJ', '111111', '13564884725', '0', '1');
INSERT INTO `user` VALUES ('4', 'WWW', '111111', '13564884726', '0', '1');
INSERT INTO `user` VALUES ('5', 'FFF', '111111', '13564884727', '0', '1');
INSERT INTO `user` VALUES ('6', 'yxl', '123456', '12345678910', '1', '0');
INSERT INTO `user` VALUES ('7', 'YJJ', '111111', '13564888888', '0', '0');
INSERT INTO `user` VALUES ('8', 'YXX', '111111', '13564887777', '1', '0');
INSERT INTO `user` VALUES ('9', 'YTT', '111111', '13564889999', '0', '0');
INSERT INTO `user` VALUES ('10', 'YUU', '111111', '13564885555', '1', '0');
INSERT INTO `user` VALUES ('11', 'YUY', '111111', '13564885551', '1', '1');
INSERT INTO `user` VALUES ('12', 'III', '111111', '13564887878', '1', '1');
INSERT INTO `user` VALUES ('13', 'zhhh', '111111', '13524511222', '1', '1');
INSERT INTO `user` VALUES ('15', 'ewq', '111111', '13564883698', '1', '1');
INSERT INTO `user` VALUES ('16', 'rew', '123123', '13564882356', '1', '1');
INSERT INTO `user` VALUES ('17', 'zxc', '111111', '13564885985', '1', '1');
INSERT INTO `user` VALUES ('21', 'lpt2', '123456', '13023156831', '1', '1');
INSERT INTO `user` VALUES ('20', 'lpt', '123456', '13023156835', '1', '1');
