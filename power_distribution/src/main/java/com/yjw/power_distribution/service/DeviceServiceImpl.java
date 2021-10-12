package com.yjw.power_distribution.service;

import com.sun.org.apache.regexp.internal.RE;
import com.yjw.power_distribution.mapper.DeviceMapper;
import com.yjw.power_distribution.pojo.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Resource
    DeviceMapper deviceMapper;

    @Override
    public int uploadCourts(Courts courts) {
        int result = deviceMapper.uploadCourts(courts);
        return result;
    }

    @Override
    public int searchCountOfCourtsByName(String name) {
        int result = deviceMapper.searchCountOfCourtsByName(name);
        return result;
    }

    @Override
    public int findCourtsIdByName(String courtsName) {
        int courtsId = deviceMapper.findCourtsIdByName(courtsName);
        return courtsId;
    }

    @Override
    public int addTransformer(Transformer transformer) {
        int result = deviceMapper.addTransformer(transformer);
        return result;
    }

    @Override
    public int updateTransformer(Transformer transformer) {
        int result = deviceMapper.updateTransformer(transformer);
        return result;
    }

    @Override
    public int delTransformer(int deviceId) {
        int result = deviceMapper.delTransformer(deviceId);
        return result;
    }

    @Override
    public int addEvSensor(EvSensor evSensor) {
        int result = deviceMapper.addEvSensor(evSensor);
        return result;
    }

    @Override
    public int updateEvSensor(EvSensor evSensor) {
        int result = deviceMapper.updateEvSensor(evSensor);
        return result;
    }

    @Override
    public int addAreaMeter(AreaMeter areaMeter) {
        int result = deviceMapper.addAreaMeter(areaMeter);
        return result;
    }

    @Override
    public int updateAreaMeter(AreaMeter areaMeter) {
        int result = deviceMapper.updateAreaMeter(areaMeter);
        return result;
    }

    @Override
    public int addFuse(Fuse fuse) {
        int result = deviceMapper.addFuse(fuse);
        return result;
    }

    @Override
    public int updateFuse(Fuse fuse) {
        int result = deviceMapper.updateFuse(fuse);
        return result;
    }

    @Override
    public int addIntelligentSwitch(IntelligentSwitch intelligentSwitch) {
        int result = deviceMapper.addIntelligentSwitch(intelligentSwitch);
        return result;
    }

    @Override
    public int updateIntelligentSwitch(IntelligentSwitch intelligentSwitch) {
        int result = deviceMapper.updateIntelligentSwitch(intelligentSwitch);
        return result;
    }

    @Override
    public int addUniphaseMeter(UniphaseMeter uniphaseMeter) {
        int result = deviceMapper.addUniphaseMeter(uniphaseMeter);
        return result;
    }

    @Override
    public int updateUniphaseMeter(UniphaseMeter uniphaseMeter) {
        int result = deviceMapper.updateUniphaseMeter(uniphaseMeter);
        return result;
    }

    @Override
    public int addLTUSwitch(LTUSwitch ltuSwitch) {
        int result = deviceMapper.addLTUSwitch(ltuSwitch);
        return result;
    }

    @Override
    public int updateLTUSwitch(LTUSwitch ltuSwitch) {
        int result = deviceMapper.updateLTUSwitch(ltuSwitch);
        return result;
    }

    @Override
    public int addChangePhaseSwitch(ChangePhaseSwitch changePhaseSwitch) {
        int result = deviceMapper.addChangePhaseSwitch(changePhaseSwitch);
        return result;
    }

    @Override
    public int updateChangePhaseSwitch(ChangePhaseSwitch changePhaseSwitch) {
        int result = deviceMapper.updateChangePhaseSwitch(changePhaseSwitch);
        return result;
    }

    @Override
    public int addChargingFacility(ChargingFacility chargingFacility) {
        int result = deviceMapper.addChargingFacility(chargingFacility);
        return result;
    }

    @Override
    public int updateChargingFacility(ChargingFacility chargingFacility) {
        int result = deviceMapper.updateChargingFacility(chargingFacility);
        return result;
    }

    @Override
    public int addPvUser(PvUser pvUser) {
        int result = deviceMapper.addPvUser(pvUser);
        return result;
    }

    @Override
    public int updatePvUser(PvUser pvUser) {
        int result = deviceMapper.updatePvUser(pvUser);
        return result;
    }

    @Override
    public int addCompensationDevice(CompensationDevice compensationDevice) {
        int result = deviceMapper.addCompensationDevice(compensationDevice );
        return result;
    }

    @Override
    public int updateCompensationDevice(CompensationDevice compensationDevice) {
        int result = deviceMapper.updateCompensationDevice(compensationDevice);
        return result;
    }

    @Override
    public int addCableSensingDevice(CableSensingDevice cableSensingDevice) {
        int result = deviceMapper.addCableSensingDevice(cableSensingDevice );
        return result;
    }

    @Override
    public int updateCableSensingDevice(CableSensingDevice cableSensingDevice) {
        int result = deviceMapper.updateCableSensingDevice(cableSensingDevice);
        return result;
    }

    @Override
    public int addThreePhaseMeter(ThreePhaseMeter threePhaseMeter) {
        int result = deviceMapper.addThreePhaseMeter(threePhaseMeter);
        return result;
    }

    @Override
    public int updateThreePhaseMeter(ThreePhaseMeter threePhaseMeter) {
        int result = deviceMapper.updateThreePhaseMeter(threePhaseMeter);
        return result;
    }

    @Override
    public int addTerminal(Terminal terminal) {
        int result = deviceMapper.addTerminal(terminal);
        return result;
    }

    @Override
    public int updateTerminal(Terminal terminal) {
        int result = deviceMapper.updateTerminal(terminal);
        return result;
    }

    @Override
    public int delEvSensor(int deviceId) {
        int result = deviceMapper.delEvSensor(deviceId);
        return result;
    }

    @Override
    public int delAreaMeter(int deviceId) {
        int result = deviceMapper.delAreaMeter(deviceId);
        return result;
    }

    @Override
    public int delFuse(int deviceId) {
        int result = deviceMapper.delFuse(deviceId);
        return result;
    }

    @Override
    public int delIntelligentSwitch(int deviceId) {
        int result = deviceMapper.delIntelligentSwitch(deviceId);
        return result;
    }

    @Override
    public int delUniphaseMeter(int deviceId) {
        int result = deviceMapper.delUniphaseMeter(deviceId);
        return result;
    }

    @Override
    public int delLTUSwitch(int deviceId) {
        int result = deviceMapper.delLTUSwitch(deviceId);
        return result;
    }

    @Override
    public int delChangePhaseSwitch(int deviceId) {
        int result = deviceMapper.delChangePhaseSwitch(deviceId);
        return result;
    }

    @Override
    public int delChargingFacility(int deviceId) {
        int result = deviceMapper.delChargingFacility(deviceId);
        return result;
    }

    @Override
    public int delPvUser(int deviceId) {
        int result = deviceMapper.delPvUser(deviceId);
        return result;
    }

    @Override
    public int delCompensationDevice(int deviceId) {
        int result = deviceMapper.delCompensationDevice(deviceId);
        return result;
    }

    @Override
    public int delCableSensingDevice(int deviceId) {
        int result = deviceMapper.delCableSensingDevice(deviceId);
        return result;
    }

    @Override
    public int delThreePhaseMeter(int deviceId) {
        int result = deviceMapper.delThreePhaseMeter(deviceId);
        return result;
    }

    @Override
    public int delTerminal(int deviceId) {
        int result = deviceMapper.delTerminal(deviceId);
        return result;
    }

    @Override
    public List<Courts> findAllCourts() {
        List<Courts> courtsList = deviceMapper.findAllCourts();
        return courtsList;
    }

    @Override
    public Courts findCourtsByCourtsId(int courtsId) {
        Courts courts = deviceMapper.findCourtsByCourtsId(courtsId);
        return courts;
    }

    @Override
    public List<Transformer> findTransformer(int courtsId) {
        List<Transformer> transformerList = deviceMapper.findTransformer(courtsId);
        return transformerList;
    }

    @Override
    public List<EvSensor> findEvSensor(int courtsId) {
        List<EvSensor> evSensorList = deviceMapper.findEvSensor(courtsId);
        return evSensorList;
    }

    @Override
    public List<AreaMeter> findAreaMeter(int courtsId) {
        List<AreaMeter> areaMeterList = deviceMapper.findAreaMeter(courtsId);
        return areaMeterList;
    }

    @Override
    public List<Fuse> findFuse(int courtsId) {
        List<Fuse> fuseList = deviceMapper.findFuse(courtsId);
        return fuseList;
    }

    @Override
    public List<IntelligentSwitch> findIntelligentSwitch(int courtsId) {
        List<IntelligentSwitch> intelligentSwitchList = deviceMapper.findIntelligentSwitch(courtsId);
        return intelligentSwitchList;
    }

    @Override
    public List<UniphaseMeter> findUniphaseMeter(int courtsId) {
        List<UniphaseMeter> uniphaseMeterList = deviceMapper.findUniphaseMeter(courtsId);
        return uniphaseMeterList;
    }

    @Override
    public List<LTUSwitch> findLTUSwitch(int courtsId) {
        List<LTUSwitch> ltuSwitchList = deviceMapper.findLTUSwitch(courtsId);
        return ltuSwitchList;
    }

    @Override
    public List<ChangePhaseSwitch> findChangePhaseSwitch(int courtsId) {
        List<ChangePhaseSwitch> changePhaseSwitchList = deviceMapper.findChangePhaseSwitch(courtsId);
        return changePhaseSwitchList;
    }

    @Override
    public List<ChargingFacility> findChargingFacility(int courtsId) {
        List<ChargingFacility> chargingFacilityList = deviceMapper.findChargingFacility(courtsId);
        return chargingFacilityList;
    }

    @Override
    public List<PvUser> findPvUser(int courtsId) {
        List<PvUser> pvUserList = deviceMapper.findPvUser(courtsId);
        return pvUserList;
    }

    @Override
    public List<CompensationDevice> findCompensationDevice(int courtsId) {
        List<CompensationDevice> compensationDeviceList = deviceMapper.findCompensationDevice(courtsId);
        return compensationDeviceList;
    }

    @Override
    public List<CableSensingDevice> findCableSensingDevice(int courtsId) {
        List<CableSensingDevice> cableSensingDeviceList = deviceMapper.findCableSensingDevice(courtsId);
        return cableSensingDeviceList;
    }

    @Override
    public List<ThreePhaseMeter> findThreePhaseMeter(int courtsId) {
        List<ThreePhaseMeter> threePhaseMeterList = deviceMapper.findThreePhaseMeter(courtsId);
        return threePhaseMeterList;
    }

    @Override
    public List<Terminal> findTerminal(int courtsId) {
        List<Terminal> terminalList = deviceMapper.findTerminal(courtsId);
        return terminalList;
    }


    @Override
    public int countTransformer() {
        return deviceMapper.countTransformer();
    }

    @Override
    public int countTransformerByCourtsId(int courtsId) {
        return deviceMapper.countTransformerByCourtsId(courtsId);
    }

    @Override
    public int countAreaMeter() {
        return deviceMapper.countAreaMeter();
    }

    @Override
    public int countAreaMeterByCourtsId(int courtsId) {
        return deviceMapper.countAreaMeterByCourtsId(courtsId);
    }

    @Override
    public int countCableSensingDevice() {
        return deviceMapper.countCableSensingDevice();
    }

    @Override
    public int countCableSensingDeviceByCourtsId(int courtsId) {
        return deviceMapper.countCableSensingDeviceByCourtsId(courtsId);
    }

    @Override
    public int countChangePhaseSwitch() {
        return deviceMapper.countChangePhaseSwitch();
    }

    @Override
    public int countChangePhaseSwitchByCourtsId(int courtsId) {
        return deviceMapper.countChangePhaseSwitchByCourtsId(courtsId);
    }

    @Override
    public int countChargingFacility() {
        return deviceMapper.countChargingFacility();
    }

    @Override
    public int countChargingFacilityByCourtsId(int courtsId) {
        return deviceMapper.countChargingFacilityByCourtsId(courtsId);
    }

    @Override
    public int countCompensationDevice() {
        return deviceMapper.countCompensationDevice();
    }

    @Override
    public int countCompensationDeviceByCourtsId(int courtsId) {
        return deviceMapper.countCompensationDeviceByCourtsId(courtsId);
    }

    @Override
    public int countEvSensor() {
        return deviceMapper.countEvSensor();
    }

    @Override
    public int countEvSensorByCourtsId(int courtsId) {
        return deviceMapper.countEvSensorByCourtsId(courtsId);
    }

    @Override
    public int countFuse() {
        return deviceMapper.countFuse();
    }

    @Override
    public int countFuseByCourtsId(int courtsId) {
        return deviceMapper.countFuseByCourtsId(courtsId);
    }

    @Override
    public int countIntelligentSwitch() {
        return deviceMapper.countIntelligentSwitch();
    }

    @Override
    public int countIntelligentSwitchByCourtsId(int courtsId) {
        return deviceMapper.countIntelligentSwitchByCourtsId(courtsId);
    }

    @Override
    public int countLTUSwitch() {
        return deviceMapper.countLTUSwitch();
    }

    @Override
    public int countLTUSwitchByCourtsId(int courtsId) {
        return deviceMapper.countLTUSwitchByCourtsId(courtsId);
    }

    @Override
    public int countPvUser() {
        return deviceMapper.countPvUser();
    }

    @Override
    public int countPvUserByCourtsId(int courtsId) {
        return deviceMapper.countPvUserByCourtsId(courtsId);
    }

    @Override
    public int countTerminal() {
        return deviceMapper.countTerminal();
    }

    @Override
    public int countTerminalByCourtsId(int courtsId) {
        return deviceMapper.countTerminalByCourtsId(courtsId);
    }

    @Override
    public int countThreePhaseMeter() {
        return deviceMapper.countThreePhaseMeter();
    }

    @Override
    public int countThreePhaseMeterByCourtsId(int courtsId) {
        return deviceMapper.countThreePhaseMeterByCourtsId(courtsId);
    }

    @Override
    public int countUniphaseMeter() {
        return deviceMapper.countUniphaseMeter();
    }

    @Override
    public int countUniphaseMeterByCourtsId(int courtsId) {
        return deviceMapper.countUniphaseMeterByCourtsId(courtsId);
    }

    @Override
    public int addCheck(CheckData checkData) {
        int result = deviceMapper.addCheck(checkData);
        return result;
    }

    @Override
    public List<CheckData> findAllCheck() {
        return deviceMapper.findAllCheck();
    }

    @Override
    public ResponseObj findCheckById(Integer checkId) {
        ResponseObj responseObj = new ResponseObj();
        if(checkId == null){
            responseObj.setStateCode(0);
            responseObj.setInfo("Network error!");
            return responseObj;
        }
        CheckData checkData = deviceMapper.findCheckById(checkId);
        if(checkData == null){
            responseObj.setStateCode(0);
            responseObj.setInfo("Database find error!");
            return responseObj;
        }
        System.out.println(checkId);
        responseObj.setStateCode(1);
        responseObj.setInfo("查找成功！");
        responseObj.setData(checkData);
        return responseObj;
    }
}
