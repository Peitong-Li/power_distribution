package com.yjw.power_distribution.pojo;

//9、智能汽车充电设施
public class ChargingFacility {
    private int id;             //变压器id
    private float sign;           //变压器标号
    private String areaName;    //所属区域侧（中压侧/配变侧/低压侧...）
    private int courtsId;  //台区名称

    private Float activePower_A;       //A相有功功率
    private Float activePower_B;       //B相有功功率
    private Float activePower_C;       //C相有功功率
    private Float activePower_Total;   //总有功功率

    private Float reactivePower_A;     //A相无功功率
    private Float reactivePower_B;     //B相无功功率
    private Float reactivePower_C;     //C相无功功率
    private Float reactivePower_Total; //总无功功率

    private Float powerFactor;  //功率因数

    private Float voltage_A;    //A相电压
    private Float voltage_B;    //B相电压
    private Float voltage_C;    //C相电压
    private Float current_A;    //A相电流
    private Float current_B;    //B相电流
    private Float current_C;    //C相电流

    private Float totalEnergyValue_PositiveActive;        //正向有功总电能示值
    private Float totalEnergyValue_PositiveReactive;      //正向无功总电能示值
    private Float totalEnergyValue_NegativeActive;        //反向有功总电能示值
    private Float totalEnergyValue_NegativeReactive;      //反向无功总电能示值


    public ChargingFacility() {
    }

    public ChargingFacility(int id, float sign, String areaName, int courtsId, Float activePower_A, Float activePower_B, Float activePower_C, Float activePower_Total, Float reactivePower_A, Float reactivePower_B, Float reactivePower_C, Float reactivePower_Total, Float powerFactor, Float voltage_A, Float voltage_B, Float voltage_C, Float current_A, Float current_B, Float current_C, Float totalEnergyValue_PositiveActive, Float totalEnergyValue_PositiveReactive, Float totalEnergyValue_NegativeActive, Float totalEnergyValue_NegativeReactive) {
        this.id = id;
        this.sign = sign;
        this.areaName = areaName;
        this.courtsId = courtsId;
        this.activePower_A = activePower_A;
        this.activePower_B = activePower_B;
        this.activePower_C = activePower_C;
        this.activePower_Total = activePower_Total;
        this.reactivePower_A = reactivePower_A;
        this.reactivePower_B = reactivePower_B;
        this.reactivePower_C = reactivePower_C;
        this.reactivePower_Total = reactivePower_Total;
        this.powerFactor = powerFactor;
        this.voltage_A = voltage_A;
        this.voltage_B = voltage_B;
        this.voltage_C = voltage_C;
        this.current_A = current_A;
        this.current_B = current_B;
        this.current_C = current_C;
        this.totalEnergyValue_PositiveActive = totalEnergyValue_PositiveActive;
        this.totalEnergyValue_PositiveReactive = totalEnergyValue_PositiveReactive;
        this.totalEnergyValue_NegativeActive = totalEnergyValue_NegativeActive;
        this.totalEnergyValue_NegativeReactive = totalEnergyValue_NegativeReactive;
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

    public Float getPowerFactor() {
        return powerFactor;
    }

    public void setPowerFactor(Float powerFactor) {
        this.powerFactor = powerFactor;
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

    public Float getTotalEnergyValue_PositiveActive() {
        return totalEnergyValue_PositiveActive;
    }

    public void setTotalEnergyValue_PositiveActive(Float totalEnergyValue_PositiveActive) {
        this.totalEnergyValue_PositiveActive = totalEnergyValue_PositiveActive;
    }

    public Float getTotalEnergyValue_PositiveReactive() {
        return totalEnergyValue_PositiveReactive;
    }

    public void setTotalEnergyValue_PositiveReactive(Float totalEnergyValue_PositiveReactive) {
        this.totalEnergyValue_PositiveReactive = totalEnergyValue_PositiveReactive;
    }

    public Float getTotalEnergyValue_NegativeActive() {
        return totalEnergyValue_NegativeActive;
    }

    public void setTotalEnergyValue_NegativeActive(Float totalEnergyValue_NegativeActive) {
        this.totalEnergyValue_NegativeActive = totalEnergyValue_NegativeActive;
    }

    public Float getTotalEnergyValue_NegativeReactive() {
        return totalEnergyValue_NegativeReactive;
    }

    public void setTotalEnergyValue_NegativeReactive(Float totalEnergyValue_NegativeReactive) {
        this.totalEnergyValue_NegativeReactive = totalEnergyValue_NegativeReactive;
    }

    @Override
    public String toString() {
        return "ChargingFacility{" +
                "id=" + id +
                ", sign=" + sign +
                ", areaName='" + areaName + '\'' +
                ", courtsId=" + courtsId +
                ", activePower_A=" + activePower_A +
                ", activePower_B=" + activePower_B +
                ", activePower_C=" + activePower_C +
                ", activePower_Total=" + activePower_Total +
                ", reactivePower_A=" + reactivePower_A +
                ", reactivePower_B=" + reactivePower_B +
                ", reactivePower_C=" + reactivePower_C +
                ", reactivePower_Total=" + reactivePower_Total +
                ", powerFactor=" + powerFactor +
                ", voltage_A=" + voltage_A +
                ", voltage_B=" + voltage_B +
                ", voltage_C=" + voltage_C +
                ", current_A=" + current_A +
                ", current_B=" + current_B +
                ", current_C=" + current_C +
                ", totalEnergyValue_PositiveActive=" + totalEnergyValue_PositiveActive +
                ", totalEnergyValue_PositiveReactive=" + totalEnergyValue_PositiveReactive +
                ", totalEnergyValue_NegativeActive=" + totalEnergyValue_NegativeActive +
                ", totalEnergyValue_NegativeReactive=" + totalEnergyValue_NegativeReactive +
                '}';
    }
}
