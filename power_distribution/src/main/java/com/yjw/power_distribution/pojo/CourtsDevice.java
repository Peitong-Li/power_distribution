package com.yjw.power_distribution.pojo;

import java.util.List;

public class CourtsDevice {
    public Courts courts;
    public List<Transformer> transformerList;
    public List<EvSensor> evSensorList;
    public List<AreaMeter> areaMeterList;
    public List<Fuse> fuseList;
    public List<IntelligentSwitch> intelligentSwitchList;
    public List<UniphaseMeter> uniphaseMeterList;
    public List<LTUSwitch> ltuSwitchList;
    public List<ChangePhaseSwitch> changePhaseSwitchList;
    public List<ChargingFacility> chargingFacilityList;
    public List<PvUser> pvUserList;
    public List<CompensationDevice> compensationDeviceList;
    public List<CableSensingDevice> cableSensingDeviceList;
    public List<ThreePhaseMeter> threePhaseMeterList;
    public List<Terminal> terminalList;


    public CourtsDevice() {
    }

    public CourtsDevice(Courts courts,List<Transformer> transformerList, List<EvSensor> evSensorList, List<AreaMeter> areaMeterList, List<Fuse> fuseList, List<IntelligentSwitch> intelligentSwitchList, List<UniphaseMeter> uniphaseMeterList, List<LTUSwitch> ltuSwitchList, List<ChangePhaseSwitch> changePhaseSwitchList, List<ChargingFacility> chargingFacilityList, List<PvUser> pvUserList, List<CompensationDevice> compensationDeviceList, List<CableSensingDevice> cableSensingDeviceList, List<ThreePhaseMeter> threePhaseMeterList, List<Terminal> terminalList) {
        this.courts = courts;
        this.transformerList = transformerList;
        this.evSensorList = evSensorList;
        this.areaMeterList = areaMeterList;
        this.fuseList = fuseList;
        this.intelligentSwitchList = intelligentSwitchList;
        this.uniphaseMeterList = uniphaseMeterList;
        this.ltuSwitchList = ltuSwitchList;
        this.changePhaseSwitchList = changePhaseSwitchList;
        this.chargingFacilityList = chargingFacilityList;
        this.pvUserList = pvUserList;
        this.compensationDeviceList = compensationDeviceList;
        this.cableSensingDeviceList = cableSensingDeviceList;
        this.threePhaseMeterList = threePhaseMeterList;
        this.terminalList = terminalList;
    }

    public Courts getCourts() {
        return courts;
    }

    public void setCourts(Courts courts) {
        this.courts = courts;
    }

    public List<Transformer> getTransformerList() {
        return transformerList;
    }

    public void setTransformerList(List<Transformer> transformerList) {
        this.transformerList = transformerList;
    }

    public List<EvSensor> getEvSensorList() {
        return evSensorList;
    }

    public void setEvSensorList(List<EvSensor> evSensorList) {
        this.evSensorList = evSensorList;
    }

    public List<AreaMeter> getAreaMeterList() {
        return areaMeterList;
    }

    public void setAreaMeterList(List<AreaMeter> areaMeterList) {
        this.areaMeterList = areaMeterList;
    }

    public List<Fuse> getFuseList() {
        return fuseList;
    }

    public void setFuseList(List<Fuse> fuseList) {
        this.fuseList = fuseList;
    }

    public List<IntelligentSwitch> getIntelligentSwitchList() {
        return intelligentSwitchList;
    }

    public void setIntelligentSwitchList(List<IntelligentSwitch> intelligentSwitchList) {
        this.intelligentSwitchList = intelligentSwitchList;
    }

    public List<UniphaseMeter> getUniphaseMeterList() {
        return uniphaseMeterList;
    }

    public void setUniphaseMeterList(List<UniphaseMeter> uniphaseMeterList) {
        this.uniphaseMeterList = uniphaseMeterList;
    }

    public List<LTUSwitch> getLtuSwitchList() {
        return ltuSwitchList;
    }

    public void setLtuSwitchList(List<LTUSwitch> ltuSwitchList) {
        this.ltuSwitchList = ltuSwitchList;
    }

    public List<ChangePhaseSwitch> getChangePhaseSwitchList() {
        return changePhaseSwitchList;
    }

    public void setChangePhaseSwitchList(List<ChangePhaseSwitch> changePhaseSwitchList) {
        this.changePhaseSwitchList = changePhaseSwitchList;
    }

    public List<ChargingFacility> getChargingFacilityList() {
        return chargingFacilityList;
    }

    public void setChargingFacilityList(List<ChargingFacility> chargingFacilityList) {
        this.chargingFacilityList = chargingFacilityList;
    }

    public List<PvUser> getPvUserList() {
        return pvUserList;
    }

    public void setPvUserList(List<PvUser> pvUserList) {
        this.pvUserList = pvUserList;
    }

    public List<CompensationDevice> getCompensationDeviceList() {
        return compensationDeviceList;
    }

    public void setCompensationDeviceList(List<CompensationDevice> compensationDeviceList) {
        this.compensationDeviceList = compensationDeviceList;
    }

    public List<CableSensingDevice> getCableSensingDeviceList() {
        return cableSensingDeviceList;
    }

    public void setCableSensingDeviceList(List<CableSensingDevice> cableSensingDeviceList) {
        this.cableSensingDeviceList = cableSensingDeviceList;
    }

    public List<ThreePhaseMeter> getThreePhaseMeterList() {
        return threePhaseMeterList;
    }

    public void setThreePhaseMeterList(List<ThreePhaseMeter> threePhaseMeterList) {
        this.threePhaseMeterList = threePhaseMeterList;
    }

    public List<Terminal> getTerminalList() {
        return terminalList;
    }

    public void setTerminalList(List<Terminal> terminalList) {
        this.terminalList = terminalList;
    }

    @Override
    public String toString() {
        return "CourtsDevice{" +
                "courts='" + courts + '\'' +
                ", transformerList=" + transformerList +
                ", evSensorList=" + evSensorList +
                ", areaMeterList=" + areaMeterList +
                ", fuseList=" + fuseList +
                ", intelligentSwitchList=" + intelligentSwitchList +
                ", uniphaseMeterList=" + uniphaseMeterList +
                ", ltuSwitchList=" + ltuSwitchList +
                ", changePhaseSwitchList=" + changePhaseSwitchList +
                ", chargingFacilityList=" + chargingFacilityList +
                ", pvUserList=" + pvUserList +
                ", compensationDeviceList=" + compensationDeviceList +
                ", cableSensingDeviceList=" + cableSensingDeviceList +
                ", threePhaseMeterList=" + threePhaseMeterList +
                ", terminalList=" + terminalList +
                '}';
    }
}
