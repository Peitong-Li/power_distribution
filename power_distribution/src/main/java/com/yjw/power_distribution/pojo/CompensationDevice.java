package com.yjw.power_distribution.pojo;

//11、无功补偿装置
public class CompensationDevice {
    private int id;             //变压器id
    private float sign;           //变压器标号
    private String areaName;    //所属区域侧（中压侧/配变侧/低压侧...）
    private int courtsId;  //台区名称

    private Float voltage_A;    //A相电压
    private Float voltage_B;    //B相电压
    private Float voltage_C;    //C相电压
    private Float voltage_AB;   //AB线电压
    private Float voltage_BC;   //BC线电压
    private Float voltage_CA;   //CA线电压
    private Float current_A;    //A相电流
    private Float current_B;    //B相电流
    private Float current_C;    //C相电流

    private Float activePower_A;           //A相有功功率
    private Float activePower_B;           //B相有功功率
    private Float activePower_C;           //C相有功功率
    private Float activePower_Total;       //总有功功率

    private Float reactivePower_A;          //A相无功功率
    private Float reactivePower_B;          //B相无功功率
    private Float reactivePower_C;          //C相无功功率
    private Float reactivePower_Total;      //总无功功率

    private Float powerFactor_A;             //A相功率因数
    private Float powerFactor_B;             //B相功率因数
    private Float powerFactor_C;             //C相功率因数
    private Float powerFactor_Total;         //总功率因数

    private Float ratedCapacity;            //额定容量
    private String cuttingState;             //投切状态

    public CompensationDevice() {
    }

    public CompensationDevice(int id, float sign, String areaName, int courtsId, Float voltage_A, Float voltage_B, Float voltage_C, Float voltage_AB, Float voltage_BC, Float voltage_CA, Float current_A, Float current_B, Float current_C, Float activePower_A, Float activePower_B, Float activePower_C, Float activePower_Total, Float reactivePower_A, Float reactivePower_B, Float reactivePower_C, Float reactivePower_Total, Float powerFactor_A, Float powerFactor_B, Float powerFactor_C, Float powerFactor_Total, Float ratedCapacity, String cuttingState) {
        this.id = id;
        this.sign = sign;
        this.areaName = areaName;
        this.courtsId = courtsId;
        this.voltage_A = voltage_A;
        this.voltage_B = voltage_B;
        this.voltage_C = voltage_C;
        this.voltage_AB = voltage_AB;
        this.voltage_BC = voltage_BC;
        this.voltage_CA = voltage_CA;
        this.current_A = current_A;
        this.current_B = current_B;
        this.current_C = current_C;
        this.activePower_A = activePower_A;
        this.activePower_B = activePower_B;
        this.activePower_C = activePower_C;
        this.activePower_Total = activePower_Total;
        this.reactivePower_A = reactivePower_A;
        this.reactivePower_B = reactivePower_B;
        this.reactivePower_C = reactivePower_C;
        this.reactivePower_Total = reactivePower_Total;
        this.powerFactor_A = powerFactor_A;
        this.powerFactor_B = powerFactor_B;
        this.powerFactor_C = powerFactor_C;
        this.powerFactor_Total = powerFactor_Total;
        this.ratedCapacity = ratedCapacity;
        this.cuttingState = cuttingState;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSign() {
        return sign;
    }

    public void setSign(float sign) {
        this.sign = sign;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public int getCourtsId() {
        return courtsId;
    }

    public void setCourtsId(int courtsId) {
        this.courtsId = courtsId;
    }

    public Float getVoltage_A() {
        return voltage_A;
    }

    public void setVoltage_A(Float voltage_A) {
        this.voltage_A = voltage_A;
    }

    public Float getVoltage_B() {
        return voltage_B;
    }

    public void setVoltage_B(Float voltage_B) {
        this.voltage_B = voltage_B;
    }

    public Float getVoltage_C() {
        return voltage_C;
    }

    public void setVoltage_C(Float voltage_C) {
        this.voltage_C = voltage_C;
    }

    public Float getVoltage_AB() {
        return voltage_AB;
    }

    public void setVoltage_AB(Float voltage_AB) {
        this.voltage_AB = voltage_AB;
    }

    public Float getVoltage_BC() {
        return voltage_BC;
    }

    public void setVoltage_BC(Float voltage_BC) {
        this.voltage_BC = voltage_BC;
    }

    public Float getVoltage_CA() {
        return voltage_CA;
    }

    public void setVoltage_CA(Float voltage_CA) {
        this.voltage_CA = voltage_CA;
    }

    public Float getCurrent_A() {
        return current_A;
    }

    public void setCurrent_A(Float current_A) {
        this.current_A = current_A;
    }

    public Float getCurrent_B() {
        return current_B;
    }

    public void setCurrent_B(Float current_B) {
        this.current_B = current_B;
    }

    public Float getCurrent_C() {
        return current_C;
    }

    public void setCurrent_C(Float current_C) {
        this.current_C = current_C;
    }

    public Float getActivePower_A() {
        return activePower_A;
    }

    public void setActivePower_A(Float activePower_A) {
        this.activePower_A = activePower_A;
    }

    public Float getActivePower_B() {
        return activePower_B;
    }

    public void setActivePower_B(Float activePower_B) {
        this.activePower_B = activePower_B;
    }

    public Float getActivePower_C() {
        return activePower_C;
    }

    public void setActivePower_C(Float activePower_C) {
        this.activePower_C = activePower_C;
    }

    public Float getActivePower_Total() {
        return activePower_Total;
    }

    public void setActivePower_Total(Float activePower_Total) {
        this.activePower_Total = activePower_Total;
    }

    public Float getReactivePower_A() {
        return reactivePower_A;
    }

    public void setReactivePower_A(Float reactivePower_A) {
        this.reactivePower_A = reactivePower_A;
    }

    public Float getReactivePower_B() {
        return reactivePower_B;
    }

    public void setReactivePower_B(Float reactivePower_B) {
        this.reactivePower_B = reactivePower_B;
    }

    public Float getReactivePower_C() {
        return reactivePower_C;
    }

    public void setReactivePower_C(Float reactivePower_C) {
        this.reactivePower_C = reactivePower_C;
    }

    public Float getReactivePower_Total() {
        return reactivePower_Total;
    }

    public void setReactivePower_Total(Float reactivePower_Total) {
        this.reactivePower_Total = reactivePower_Total;
    }

    public Float getPowerFactor_A() {
        return powerFactor_A;
    }

    public void setPowerFactor_A(Float powerFactor_A) {
        this.powerFactor_A = powerFactor_A;
    }

    public Float getPowerFactor_B() {
        return powerFactor_B;
    }

    public void setPowerFactor_B(Float powerFactor_B) {
        this.powerFactor_B = powerFactor_B;
    }

    public Float getPowerFactor_C() {
        return powerFactor_C;
    }

    public void setPowerFactor_C(Float powerFactor_C) {
        this.powerFactor_C = powerFactor_C;
    }

    public Float getPowerFactor_Total() {
        return powerFactor_Total;
    }

    public void setPowerFactor_Total(Float powerFactor_Total) {
        this.powerFactor_Total = powerFactor_Total;
    }

    public Float getRatedCapacity() {
        return ratedCapacity;
    }

    public void setRatedCapacity(Float ratedCapacity) {
        this.ratedCapacity = ratedCapacity;
    }

    public String getCuttingState() {
        return cuttingState;
    }

    public void setCuttingState(String cuttingState) {
        this.cuttingState = cuttingState;
    }

    @Override
    public String toString() {
        return "CompensationDevice{" +
                "id=" + id +
                ", sign=" + sign +
                ", areaName='" + areaName + '\'' +
                ", courtsId=" + courtsId +
                ", voltage_A=" + voltage_A +
                ", voltage_B=" + voltage_B +
                ", voltage_C=" + voltage_C +
                ", voltage_AB=" + voltage_AB +
                ", voltage_BC=" + voltage_BC +
                ", voltage_CA=" + voltage_CA +
                ", current_A=" + current_A +
                ", current_B=" + current_B +
                ", current_C=" + current_C +
                ", activePower_A=" + activePower_A +
                ", activePower_B=" + activePower_B +
                ", activePower_C=" + activePower_C +
                ", activePower_Total=" + activePower_Total +
                ", reactivePower_A=" + reactivePower_A +
                ", reactivePower_B=" + reactivePower_B +
                ", reactivePower_C=" + reactivePower_C +
                ", reactivePower_Total=" + reactivePower_Total +
                ", powerFactor_A=" + powerFactor_A +
                ", powerFactor_B=" + powerFactor_B +
                ", powerFactor_C=" + powerFactor_C +
                ", powerFactor_Total=" + powerFactor_Total +
                ", ratedCapacity=" + ratedCapacity +
                ", cuttingState='" + cuttingState + '\'' +
                '}';
    }
}
