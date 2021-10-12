package com.yjw.power_distribution.service;

import com.yjw.power_distribution.pojo.*;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DeviceService {

    //上传台区
    int uploadCourts(Courts courts);
    //根据名字查询台区
    int searchCountOfCourtsByName(String name);
    //根据台区名查询台区Id
    int findCourtsIdByName(String courtsName);
    //添加设备/更新设备
    int addTransformer(Transformer transformer);
    int updateTransformer(Transformer transformer);
    int delTransformer(int deviceId);

    int addEvSensor(EvSensor evSensor);
    int updateEvSensor(EvSensor evSensor);
    int delEvSensor(int deviceId);

    int addAreaMeter(AreaMeter areaMeter);
    int updateAreaMeter(AreaMeter areaMeter);
    int delAreaMeter(int deviceId);

    int addFuse(Fuse fuse);
    int updateFuse(Fuse fuse);
    int delFuse(int deviceId);

    int addIntelligentSwitch(IntelligentSwitch intelligentSwitch);
    int updateIntelligentSwitch(IntelligentSwitch intelligentSwitch);
    int delIntelligentSwitch(int deviceId);

    int addUniphaseMeter(UniphaseMeter uniphaseMeter);
    int updateUniphaseMeter(UniphaseMeter uniphaseMeter);
    int delUniphaseMeter(int deviceId);

    int addLTUSwitch(LTUSwitch ltuSwitch);
    int updateLTUSwitch(LTUSwitch ltuSwitch);
    int delLTUSwitch(int deviceId);

    int addChangePhaseSwitch(ChangePhaseSwitch changePhaseSwitch);
    int updateChangePhaseSwitch(ChangePhaseSwitch changePhaseSwitch);
    int delChangePhaseSwitch(int deviceId);

    int addChargingFacility(ChargingFacility chargingFacility);
    int updateChargingFacility(ChargingFacility chargingFacility);
    int delChargingFacility(int deviceId);

    int addPvUser(PvUser pvUser);
    int updatePvUser(PvUser pvUser);
    int delPvUser(int deviceId);

    int addCompensationDevice(CompensationDevice compensationDevice);
    int updateCompensationDevice(CompensationDevice compensationDevice);
    int delCompensationDevice(int deviceId);

    int addCableSensingDevice(CableSensingDevice cableSensingDevice);
    int updateCableSensingDevice(CableSensingDevice cableSensingDevice);
    int delCableSensingDevice(int deviceId);

    int addThreePhaseMeter(ThreePhaseMeter threePhaseMeter);
    int updateThreePhaseMeter(ThreePhaseMeter threePhaseMeter);
    int delThreePhaseMeter(int deviceId);

    int addTerminal(Terminal terminal);
    int updateTerminal(Terminal terminal);
    int delTerminal(int deviceId);

    //查询所有台区
    List<Courts> findAllCourts();
    //根据台区Id查询台区
    Courts findCourtsByCourtsId(int courtsId);
    //根据台区名查询设备
    List<Transformer> findTransformer(int courtsId);
    List<EvSensor> findEvSensor(int courtsId);
    List<AreaMeter> findAreaMeter(int courtsId);
    List<Fuse> findFuse(int courtsId);
    List<IntelligentSwitch> findIntelligentSwitch(int courtsId);
    List<UniphaseMeter> findUniphaseMeter(int courtsId);
    List<LTUSwitch> findLTUSwitch(int courtsId);
    List<ChangePhaseSwitch> findChangePhaseSwitch(int courtsId);
    List<ChargingFacility> findChargingFacility(int courtsId);
    List<PvUser> findPvUser(int courtsId);
    List<CompensationDevice> findCompensationDevice(int courtsId);
    List<CableSensingDevice> findCableSensingDevice(int courtsId);
    List<ThreePhaseMeter> findThreePhaseMeter(int courtsId);
    List<Terminal> findTerminal(int courtsId);



    int countTransformer();//查询该设备总数
    int countTransformerByCourtsId(int courtsId);//根据id查询设备数量

    int countAreaMeter();//查询该设备总数
    int countAreaMeterByCourtsId(int courtsId);//根据id查询设备数量

    int countCableSensingDevice();//查询该设备总数
    int countCableSensingDeviceByCourtsId(int courtsId);//根据id查询设备数量
    //4
    int countChangePhaseSwitch();//查询该设备总数
    int countChangePhaseSwitchByCourtsId(int courtsId);//根据id查询设备数量
    //5
    int countChargingFacility();//查询该设备总数
    int countChargingFacilityByCourtsId(int courtsId);//根据id查询设备数量
    //6
    int countCompensationDevice();//查询该设备总数
    int countCompensationDeviceByCourtsId(int courtsId);//根据id查询设备数量

    //7
    int countEvSensor();//查询该设备总数
    int countEvSensorByCourtsId(int courtsId);//根据id查询设备数量
//8
    int countFuse();//查询该设备总数
    int countFuseByCourtsId(int courtsId);//根据id查询设备数量
//9
    int countIntelligentSwitch();//查询该设备总数
    int countIntelligentSwitchByCourtsId(int courtsId);//根据id查询设备数量
    //10
    int countLTUSwitch();//查询该设备总数
    int countLTUSwitchByCourtsId(int courtsId);//根据id查询设备数量
    //11
    int countPvUser();//查询该设备总数
    int countPvUserByCourtsId(int courtsId);//根据id查询设备数量
    //12
    int countTerminal();//查询该设备总数
    int countTerminalByCourtsId(int courtsId);//根据id查询设备数量
    //13
    int countThreePhaseMeter();//查询该设备总数
    int countThreePhaseMeterByCourtsId(int courtsId);//根据id查询设备数量
//14
    int countUniphaseMeter();//查询该设备总数
    int countUniphaseMeterByCourtsId(int courtsId);//根据id查询设备数量


    int addCheck(CheckData checkData);
    List<CheckData> findAllCheck();
    ResponseObj findCheckById(Integer checkId);



}
