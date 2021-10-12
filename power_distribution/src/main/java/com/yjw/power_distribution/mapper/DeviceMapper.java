package com.yjw.power_distribution.mapper;

import com.yjw.power_distribution.pojo.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeviceMapper {

    //上传台区图片
    @Insert("INSERT INTO courts (courtsId,courtsName,courtsImageUrl)" +
            "VALUES (#{courtsId},#{courtsName},#{courtsImageUrl})")
    int uploadCourts(Courts courts);

    //根据名字查询台区数量
    @Select("select count(*) from courts where courtsName = #{name}")
    int searchCountOfCourtsByName(String name);

    //根据名字查询该台区Id
    @Select("select courtsId from courts where courtsName = #{name}")
    int findCourtsIdByName(String name);

    //添加设备方法  使用注解方法实现mybatis操作
    //1、添加变压器
    @Insert("INSERT INTO transformer (sign,areaName,courtsId,voltage_A,voltage_B,voltage_C,voltage_AB,voltage_BC,voltage_CA," +
            "current_A,current_B,current_C,switchState,oilTemperature,poleTemperature,oilPosition,insidePressure)" +
            "VALUES (#{sign},#{areaName},#{courtsId},#{voltage_A},#{voltage_B},#{voltage_C}," +
            "#{voltage_AB},#{voltage_BC},#{voltage_CA},#{current_A},#{current_B},#{current_C}," +
            "#{switchState},#{poleTemperature},#{oilTemperature},#{oilPosition},#{insidePressure})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int addTransformer(Transformer transformer);
    //1、更新变压器
    @Update("update transformer  set  " +
            " sign=#{sign},areaName=#{areaName},voltage_A=#{voltage_A},voltage_B=#{voltage_B},voltage_C=#{voltage_C},voltage_AB=#{voltage_AB},voltage_BC=#{voltage_BC}," +
            "voltage_CA=#{voltage_CA},current_A=#{current_A},current_B=#{current_B},current_C=#{current_C},switchState=#{switchState}," +
            "oilTemperature=#{oilTemperature},poleTemperature=#{poleTemperature},oilPosition=#{oilPosition},insidePressure=#{insidePressure} " +
            "where id=#{id}")
    int updateTransformer(Transformer transformer);
    //1、根据deviceId删除该设备
    @Delete("delete from transformer where id = #{deviceId}")
    int delTransformer(int deviceId);



    //2、添加智能环境传感器
    @Insert("INSERT INTO ev_sensor (sign,areaName,courtsId,temperature,humidity)"+
            "VALUES (#{sign},#{areaName},#{courtsId},#{temperature},#{humidity})" )
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int addEvSensor(EvSensor evSensor);
    //2、更新
    @Update("update ev_sensor set " +
            "sign=#{sign},areaName=#{areaName},temperature=#{temperature},humidity=#{humidity} " +
            "where id=#{id}" )
    int updateEvSensor(EvSensor evSensor);
    //删除
    @Delete("delete from ev_sensor where id = #{deviceId}")
    int delEvSensor(int deviceId);


    //3、添加台区总表
    @Insert("INSERT INTO area_meter (sign,areaName,courtsId," +
            "voltage_A,voltage_B,voltage_C,current_A,current_B,current_C," +
            "activePower_A,activePower_B,activePower_C,activePower_Total," +
            "reactivePower_A,reactivePower_B,reactivePower_C,reactivePower_Total," +
            "apparentPower_A,apparentPower_B,apparentPower_C,apparentPower_Total," +
            "distributionLoadRate,voltagePassRate,humiture,gasConcentration)" +
            "VALUES (#{sign},#{areaName},#{courtsId}," +
            "#{voltage_A},#{voltage_B},#{voltage_C},#{current_A},#{current_B},#{current_C}," +
            "#{activePower_A},#{activePower_B},#{activePower_C},#{activePower_Total}," +
            "#{reactivePower_A},#{reactivePower_B},#{reactivePower_C},#{reactivePower_Total}," +
            "#{apparentPower_A},#{apparentPower_B},#{apparentPower_C},#{apparentPower_Total}," +
            "#{distributionLoadRate},#{voltagePassRate},#{humiture},#{gasConcentration})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int addAreaMeter(AreaMeter areaMeter);
    //3、更新AreaMeter
    @Update("update area_meter set " +
            "sign=#{sign},areaName=#{areaName}," +
            "voltage_A=#{voltage_A},voltage_B=#{voltage_B},voltage_C=#{voltage_C},current_A=#{current_A},current_B=#{current_B},current_C=#{current_C}," +
            "activePower_A=#{activePower_A},activePower_B=#{activePower_B},activePower_C=#{activePower_C},activePower_Total=#{activePower_Total}," +
            "reactivePower_A=#{reactivePower_A},reactivePower_B=#{reactivePower_B},reactivePower_C=#{reactivePower_C},reactivePower_Total=#{reactivePower_Total}," +
            "apparentPower_A=#{apparentPower_A},apparentPower_B=#{apparentPower_B},apparentPower_C=#{apparentPower_C},apparentPower_Total=#{apparentPower_Total}," +
            "distributionLoadRate=#{distributionLoadRate},voltagePassRate=#{voltagePassRate},humiture=#{humiture},gasConcentration=#{gasConcentration} " +
            "where id = #{id}")
    int updateAreaMeter(AreaMeter areaMeter);
    //删除
    @Delete("delete from area_meter where id = #{deviceId}")
    int delAreaMeter(int deviceId);


    //4、添加熔断器
    @Insert("INSERT INTO fuse (sign,areaName,courtsId,voltage,current,switchState)" +
            "VALUES (#{sign},#{areaName},#{courtsId},#{voltage},#{current},#{switchState})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int addFuse(Fuse fuse);
    //4、更新
    @Update("update  fuse set " +
            "sign=#{sign},areaName=#{areaName},voltage=#{voltage},current=#{current},switchState=#{switchState}" +
            "where Id=#{id}")
    int updateFuse(Fuse fuse);
    //删除
    @Delete("delete from fuse where id = #{deviceId}")
    int delFuse(int deviceId);



    //5、添加智能开关
    @Insert("INSERT INTO intelligent_switch " +
            "(sign,areaName,courtsId,voltage_A,voltage_B,voltage_C,current_A,current_B,current_C,contactTemperature,switchState) " +
            "VALUES (#{sign},#{areaName},#{courtsId},#{voltage_A},#{voltage_B},#{voltage_C},#{current_A},#{current_B},#{current_C},#{contactTemperature},#{switchState})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int addIntelligentSwitch(IntelligentSwitch intelligentSwitch);
    //5、
    @Update("update  intelligent_switch set " +
            " sign=#{sign},areaName=#{areaName},voltage_A=#{voltage_A},voltage_B=#{voltage_B},voltage_C=#{voltage_C}," +
            "current_A=#{current_A},current_B=#{current_B},current_C=#{current_C},contactTemperature=#{contactTemperature},switchState=#{switchState}" +
            " where id=#{id}")
    int updateIntelligentSwitch(IntelligentSwitch intelligentSwitch);
    //删除
    @Delete("delete from intelligent_switch where id = #{deviceId}")
    int delIntelligentSwitch(int deviceId);


    //6、添加单相表
    @Insert("INSERT INTO uniphase_meter (sign,areaName,courtsId,voltage,current,power)" +
            "VALUES (#{sign},#{areaName},#{courtsId},#{voltage},#{current},#{power})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int addUniphaseMeter(UniphaseMeter uniphaseMeter);
    @Update("update  uniphase_meter set " +
            "sign=#{sign},areaName=#{areaName},voltage=#{voltage},current=#{current},power=#{power}" +
            " where id=#{id}")
    int updateUniphaseMeter(UniphaseMeter uniphaseMeter);
    @Delete("delete from uniphase_meter where id = #{deviceId}")
    int delUniphaseMeter(int deviceId);



    //7、添加LTU开关
    @Insert("INSERT INTO ltu_switch (sign,areaName,courtsId," +
            "voltage_A,voltage_B,voltage_C,current_A,current_B,current_C,contactTemperature,switchState)" +
            "VALUES (#{sign},#{areaName},#{courtsId}," +
            "#{voltage_A},#{voltage_B},#{voltage_C},#{current_A},#{current_B},#{current_C},#{contactTemperature},#{switchState})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int addLTUSwitch(LTUSwitch ltuSwitch);
    @Update("update  ltu_switch set " +
            "sign=#{sign},areaName=#{areaName},voltage_A=#{voltage_A},voltage_B=#{voltage_B},voltage_C=#{voltage_C}," +
            "current_A=#{current_A},current_B=#{current_B},current_C=#{current_C},contactTemperature=#{contactTemperature},switchState=#{switchState} " +
            "where id = #{id}")
    int updateLTUSwitch(LTUSwitch ltuSwitch);
    @Delete("delete from ltu_switch where id = #{deviceId}")
    int delLTUSwitch(int deviceId);


    //8、添加换相开关
    @Insert("INSERT INTO change_phase_switch (sign,areaName,courtsId," +
            "voltage_A,voltage_B,voltage_C,current_A,current_B,current_C,switchState)" +
            "VALUES (#{sign},#{areaName},#{courtsId}," +
            "#{voltage_A},#{voltage_B},#{voltage_C},#{current_A},#{current_B},#{current_C},#{switchState})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int addChangePhaseSwitch(ChangePhaseSwitch changePhaseSwitch);
    @Update("update  change_phase_switch set " +
            "sign=#{sign},areaName=#{areaName}," +
            "voltage_A=#{voltage_A},voltage_B=#{voltage_B},voltage_C=#{voltage_C},current_A=#{current_A},current_B=#{current_B},current_C=#{current_C},switchState=#{switchState}" +
            " where id=#{id}")
    int updateChangePhaseSwitch(ChangePhaseSwitch changePhaseSwitch);
    @Delete("delete from change_phase_switch where id = #{deviceId}")
    int delChangePhaseSwitch(int deviceId);


    //14、添加Terminal
    @Insert("INSERT INTO terminal (sign,areaName,courtsId," +
            "voltage_A,voltage_B,voltage_C,current_A,current_B,current_C," +
            "activePower_A,activePower_B,activePower_C,activePower_Total," +
            "reactivePower_A,reactivePower_B,reactivePower_C,reactivePower_Total," +
            "apparentPower_A,apparentPower_B,apparentPower_C,apparentPower_Total," +
            "distributionLoadRate,voltagePassRate,humiture,gasConcentration)" +
            "VALUES (#{sign},#{areaName},#{courtsId}," +
            "#{voltage_A},#{voltage_B},#{voltage_C},#{current_A},#{current_B},#{current_C}," +
            "#{activePower_A},#{activePower_B},#{activePower_C},#{activePower_Total}," +
            "#{reactivePower_A},#{reactivePower_B},#{reactivePower_C},#{reactivePower_Total}," +
            "#{apparentPower_A},#{apparentPower_B},#{apparentPower_C},#{apparentPower_Total}," +
            "#{distributionLoadRate},#{voltagePassRate},#{humiture},#{gasConcentration})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int addTerminal(Terminal terminal);
    @Update("update terminal set " +
            "sign=#{sign},areaName=#{areaName}," +
            "voltage_A=#{voltage_A},voltage_B=#{voltage_B},voltage_C=#{voltage_C},current_A=#{current_A},current_B=#{current_B},current_C=#{current_C}," +
            "activePower_A=#{activePower_A},activePower_B=#{activePower_B},activePower_C=#{activePower_C},activePower_Total=#{activePower_Total}," +
            "reactivePower_A=#{reactivePower_A},reactivePower_B=#{reactivePower_B},reactivePower_C=#{reactivePower_C},reactivePower_Total=#{reactivePower_Total}," +
            "apparentPower_A=#{apparentPower_A},apparentPower_B=#{apparentPower_B},apparentPower_C=#{apparentPower_C},apparentPower_Total=#{apparentPower_Total}," +
            "distributionLoadRate=#{distributionLoadRate},voltagePassRate=#{voltagePassRate},humiture=#{humiture},gasConcentration=#{gasConcentration} " +
            "where id = #{id}")
    int updateTerminal(Terminal terminal);
    @Delete("delete from terminal where id = #{deviceId}")
    int delTerminal(int deviceId);



    //10、添加光伏用户
    @Insert("INSERT INTO pv_user (sign,areaName,courtsId,voltage,current,power)" +
            "VALUES (#{sign},#{areaName},#{courtsId},#{voltage},#{current},#{power})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int addPvUser(PvUser pvUser);
    @Update("update  pv_user  set " +
            "sign=#{sign},areaName=#{areaName},voltage=#{voltage},current=#{current},power=#{power}" +
            " where id=#{id}")
    int updatePvUser(PvUser pvUser);
    @Delete("delete from pv_user where id = #{deviceId}")
    int delPvUser(int deviceId);

    //11、添加无功补偿装置
    @Insert("INSERT INTO compensation_Device (sign,areaName,courtsId," +
            "voltage_A,voltage_B,voltage_C,voltage_AB,voltage_BC,voltage_CA," +
            "current_A,current_B,current_C," +
            "activePower_A,activePower_B,activePower_C,activePower_Total," +
            "reactivePower_A,reactivePower_B,reactivePower_C,reactivePower_Total," +
            "powerFactor_A,powerFactor_B,powerFactor_C,powerFactor_Total," +
            "ratedCapacity,cuttingState)" +
            "VALUES (#{sign},#{areaName},#{courtsId}," +
            "#{voltage_A},#{voltage_B},#{voltage_C},#{voltage_AB},#{voltage_BC},#{voltage_CA}," +
            "#{current_A},#{current_B},#{current_C}," +
            "#{activePower_A},#{activePower_B},#{activePower_C},#{activePower_Total}," +
            "#{reactivePower_A},#{reactivePower_B},#{reactivePower_C},#{reactivePower_Total}," +
            "#{powerFactor_A},#{powerFactor_B},#{powerFactor_C},#{powerFactor_Total}," +
            "#{ratedCapacity},#{cuttingState})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int addCompensationDevice(CompensationDevice compensationDevice);

    @Update("update  compensation_Device set " +
            "sign=#{sign},areaName=#{areaName}," +
            "voltage_A=#{voltage_A},voltage_B=#{voltage_B},voltage_C=#{voltage_C},voltage_AB=#{voltage_AB},voltage_BC=#{voltage_BC},voltage_CA=#{voltage_CA}," +
            "current_A=#{current_A},current_B=#{current_B},current_C=#{current_C}," +
            "activePower_A=#{activePower_A},activePower_B=#{activePower_B},activePower_C=#{activePower_C},activePower_Total=#{activePower_Total}," +
            "reactivePower_A=#{reactivePower_A},reactivePower_B=#{reactivePower_B},reactivePower_C=#{reactivePower_C},reactivePower_Total=#{reactivePower_Total}," +
            "powerFactor_A=#{powerFactor_A},powerFactor_B=#{powerFactor_B},powerFactor_C=#{powerFactor_C},powerFactor_Total=#{powerFactor_Total}," +
            "ratedCapacity=#{ratedCapacity},cuttingState=#{cuttingState}" +
            " where id = #{id}")
    int updateCompensationDevice(CompensationDevice compensationDevice);
    @Delete("delete from compensation_Device where id = #{deviceId}")
    int delCompensationDevice(int deviceId);



    //12、电缆感知设备
    @Insert("INSERT INTO cable_Sensing_Device (sign,areaName,courtsId,temperature,harmfulGas,combustibleGas,displacement)" +
            "VALUES (#{sign},#{areaName},#{courtsId},#{temperature},#{harmfulGas},#{combustibleGas},#{displacement})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int addCableSensingDevice(CableSensingDevice cableSensingDevice);
    @Update("update  cable_Sensing_Device set " +
            "sign=#{sign},areaName=#{areaName},temperature=#{temperature},harmfulGas=#{harmfulGas},combustibleGas=#{combustibleGas},displacement=#{displacement}" +
            " where id=#{id}")
    int updateCableSensingDevice(CableSensingDevice cableSensingDevice);
    @Delete("delete from cable_Sensing_Device where id = #{deviceId}")
    int delCableSensingDevice(int deviceId);

    //13、添加三相表
    @Insert("INSERT INTO three_Phase_Meter (sign,areaName,courtsId," +
            "voltage_A,voltage_B,voltage_C,current_A,current_B,current_C," +
            "activePower_A,activePower_B,activePower_C,activePower_Total)" +
            "VALUES (#{sign},#{areaName},#{courtsId}," +
            "#{voltage_A},#{voltage_B},#{voltage_C},#{current_A},#{current_B},#{current_C}," +
            "#{activePower_A},#{activePower_B},#{activePower_C},#{activePower_Total})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int addThreePhaseMeter(ThreePhaseMeter threePhaseMeter);
    @Update("update  three_Phase_Meter set " +
            "sign=#{sign},areaName=#{areaName}," +
            "voltage_A=#{voltage_A},voltage_B=#{voltage_B},voltage_C=#{voltage_C},current_A=#{current_A},current_B=#{current_B},current_C=#{current_C}," +
            "activePower_A=#{activePower_A},activePower_B=#{activePower_B},activePower_C=#{activePower_C},activePower_Total=#{activePower_Total} " +
            "where id=#{id}")
    int updateThreePhaseMeter(ThreePhaseMeter threePhaseMeter);
    @Delete("delete from three_Phase_Meter where id = #{deviceId}")
    int delThreePhaseMeter(int deviceId);

    //14、添加Terminal
    @Insert("INSERT INTO charging_facility (sign,areaName,courtsId," +
            "voltage_A,voltage_B,voltage_C,current_A,current_B,current_C," +
            "activePower_A,activePower_B,activePower_C,activePower_Total," +
            "reactivePower_A,reactivePower_B,reactivePower_C,reactivePower_Total," +
            "totalEnergyValue_PositiveActive,totalEnergyValue_PositiveReactive,totalEnergyValue_NegativeActive,totalEnergyValue_NegativeReactive," +
            "powerFactor)" +
            "VALUES (#{sign},#{areaName},#{courtsId}," +
            "#{voltage_A},#{voltage_B},#{voltage_C},#{current_A},#{current_B},#{current_C}," +
            "#{activePower_A},#{activePower_B},#{activePower_C},#{activePower_Total}," +
            "#{reactivePower_A},#{reactivePower_B},#{reactivePower_C},#{reactivePower_Total}," +
            "#{totalEnergyValue_PositiveActive},#{totalEnergyValue_PositiveReactive},#{totalEnergyValue_NegativeActive},#{totalEnergyValue_NegativeReactive}," +
            "#{powerFactor})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int addChargingFacility(ChargingFacility chargingFacility);
    @Update("update  charging_facility set " +
            "sign=#{sign},areaName=#{areaName}," +
            "voltage_A=#{voltage_A},voltage_B=#{voltage_B},voltage_C=#{voltage_C},current_A=#{current_A},current_B=#{current_B},current_C=#{current_C}," +
            "activePower_A=#{activePower_A},activePower_B=#{activePower_B},activePower_C=#{activePower_C},activePower_Total=#{activePower_Total}," +
            "reactivePower_A=#{reactivePower_A},reactivePower_B=#{reactivePower_B},reactivePower_C=#{reactivePower_C},reactivePower_Total=#{reactivePower_Total}," +
            "totalEnergyValue_PositiveActive=#{totalEnergyValue_PositiveActive},totalEnergyValue_PositiveReactive=#{totalEnergyValue_PositiveReactive}," +
            "totalEnergyValue_NegativeActive=#{totalEnergyValue_NegativeActive},totalEnergyValue_NegativeReactive=#{totalEnergyValue_NegativeReactive}," +
            "powerFactor=#{powerFactor} " +
            "where id=#{id}")
    int updateChargingFacility(ChargingFacility chargingFacility);
    @Delete("delete from Charging_Facility where id = #{deviceId}")
    int delChargingFacility(int deviceId);


    //查询所有台区
    @Select("select * from courts")
    List<Courts> findAllCourts();
    //根据台区Id查询台区
    @Select("select * from courts where courtsId = #{courtsId}")
    Courts findCourtsByCourtsId(int courtsId);
    //搜索设备
    //1
    @Select("select * from transformer where courtsId = #{courtsId}")
    List<Transformer> findTransformer(int courtsId);
    //2
    @Select("select * from ev_sensor where courtsId = #{courtsId}")
    List<EvSensor> findEvSensor(int courtsId);
    //3
    @Select("select * from area_meter where courtsId = #{courtsId}")
    List<AreaMeter> findAreaMeter(int courtsId);
    //4
    @Select("select * from fuse where courtsId = #{courtsId}")
    List<Fuse> findFuse(int courtsId);
    //5
    @Select("select * from intelligent_switch where courtsId = #{courtsId}")
    List<IntelligentSwitch> findIntelligentSwitch(int courtsId);
    //6
    @Select("select * from uniphase_meter where courtsId = #{courtsId}")
    List<UniphaseMeter> findUniphaseMeter(int courtsId);
    //7
    @Select("select * from ltu_switch where courtsId = #{courtsId}")
    List<LTUSwitch> findLTUSwitch(int courtsId);
    //8
    @Select("select * from change_phase_switch where courtsId = #{courtsId}")
    List<ChangePhaseSwitch> findChangePhaseSwitch(int courtsId);
    //9
    @Select("select * from charging_facility where courtsId = #{courtsId}")
    List<ChargingFacility> findChargingFacility(int courtsId);
    //10
    @Select("select * from pv_user where courtsId = #{courtsId}")
    List<PvUser> findPvUser(int courtsId);
    //11
    @Select("select * from compensation_device where courtsId = #{courtsId}")
    List<CompensationDevice> findCompensationDevice(int courtsId);
    //12
    @Select("select * from cable_sensing_device where courtsId = #{courtsId}")
    List<CableSensingDevice> findCableSensingDevice(int courtsId);
    //13
    @Select("select * from three_phase_meter where courtsId = #{courtsId}")
    List<ThreePhaseMeter> findThreePhaseMeter(int courtsId);
    //14
    @Select("select * from terminal where courtsId = #{courtsId}")
    List<Terminal> findTerminal(int courtsId);

//1
    @Select("select COUNT(*) from transformer")
    int countTransformer();//查询该设备总数
    @Select("select COUNT(*) from transformer where courtsId = #{courtsId}")
    int countTransformerByCourtsId(int courtsId);//根据id查询设备数量
//2
    @Select("select COUNT(*) from area_meter")
    int countAreaMeter();//查询该设备总数
    @Select("select COUNT(*) from area_meter where courtsId = #{courtsId}")
    int countAreaMeterByCourtsId(int courtsId);//根据id查询设备数量
//3
    @Select("select COUNT(*) from cable_sensing_device")
    int countCableSensingDevice();//查询该设备总数
    @Select("select COUNT(*) from cable_sensing_device where courtsId = #{courtsId}")
    int countCableSensingDeviceByCourtsId(int courtsId);//根据id查询设备数量
//4
    @Select("select COUNT(*) from change_phase_switch")
    int countChangePhaseSwitch();//查询该设备总数
    @Select("select COUNT(*) from change_phase_switch where courtsId = #{courtsId}")
    int countChangePhaseSwitchByCourtsId(int courtsId);//根据id查询设备数量
//5
    @Select("select COUNT(*) from charging_facility")
    int countChargingFacility();//查询该设备总数
    @Select("select COUNT(*) from charging_facility where courtsId = #{courtsId}")
    int countChargingFacilityByCourtsId(int courtsId);//根据id查询设备数量
//6
    @Select("select COUNT(*) from compensation_device")
    int countCompensationDevice();//查询该设备总数
    @Select("select COUNT(*) from compensation_device where courtsId = #{courtsId}")
    int countCompensationDeviceByCourtsId(int courtsId);//根据id查询设备数量

//7
    @Select("select COUNT(*) from ev_sensor")
    int countEvSensor();//查询该设备总数
    @Select("select COUNT(*) from ev_sensor where courtsId = #{courtsId}")
    int countEvSensorByCourtsId(int courtsId);//根据id查询设备数量
//8

    @Select("select COUNT(*) from fuse")
    int countFuse();//查询该设备总数
    @Select("select COUNT(*) from fuse where courtsId = #{courtsId}")
    int countFuseByCourtsId(int courtsId);//根据id查询设备数量
//9

    @Select("select COUNT(*) from intelligent_switch")
    int countIntelligentSwitch();//查询该设备总数
    @Select("select COUNT(*) from intelligent_switch where courtsId = #{courtsId}")
    int countIntelligentSwitchByCourtsId(int courtsId);//根据id查询设备数量

    //10
    @Select("select COUNT(*) from ltu_switch")
    int countLTUSwitch();//查询该设备总数
    @Select("select COUNT(*) from ltu_switch where courtsId = #{courtsId}")
    int countLTUSwitchByCourtsId(int courtsId);//根据id查询设备数量

//11
    @Select("select COUNT(*) from pv_user")
    int countPvUser();//查询该设备总数
    @Select("select COUNT(*) from pv_user where courtsId = #{courtsId}")
    int countPvUserByCourtsId(int courtsId);//根据id查询设备数量

//12
    @Select("select COUNT(*) from terminal")
    int countTerminal();//查询该设备总数
    @Select("select COUNT(*) from terminal where courtsId = #{courtsId}")
    int countTerminalByCourtsId(int courtsId);//根据id查询设备数量
//13
    @Select("select COUNT(*) from three_phase_meter")
    int countThreePhaseMeter();//查询该设备总数
    @Select("select COUNT(*) from three_phase_meter where courtsId = #{courtsId}")
    int countThreePhaseMeterByCourtsId(int courtsId);//根据id查询设备数量
//14

    @Select("select COUNT(*) from uniphase_meter")
    int countUniphaseMeter();//查询该设备总数
    @Select("select COUNT(*) from uniphase_meter where courtsId = #{courtsId}")
    int countUniphaseMeterByCourtsId(int courtsId);//根据id查询设备数量




    //上传巡检
    @Insert("INSERT INTO checkdata (checkName,checkContent,checkResult,checkPeo,checkTime,courtsId)" +
            " VALUES(#{checkName},#{checkContent},#{checkResult},#{checkPeo},#{checkTime},#{courtsId})")
    int addCheck(CheckData checkData);

    @Select("SELECT checkId,checkName,checkContent,checkResult,checkTime,checkPeo,checkdata.courtsId,courtsName FROM checkdata,courts\n" +
            "WHERE checkdata.courtsId = courts.courtsId ORDER BY checkTime desc")
    List<CheckData> findAllCheck();

    @Select("SELECT checkId,checkName,checkContent,checkResult,checkTime,checkPeo,checkdata.courtsId,courtsName FROM checkdata,courts\n" +
            "WHERE checkdata.courtsId = courts.courtsId and checkdata.checkId=#{checkId}")
    CheckData findCheckById(int checkId);






}
