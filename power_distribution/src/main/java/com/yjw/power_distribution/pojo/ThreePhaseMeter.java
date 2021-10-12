package com.yjw.power_distribution.pojo;

//13、三相表
public class ThreePhaseMeter {

    private int id;             //变压器id
    private float sign;           //变压器标号
    private String areaName;    //所属区域侧（中压侧/配变侧/低压侧...）
    private int courtsId;  //台区名称

    private Float voltage_A;    //A相电压
    private Float voltage_B;    //B相电压
    private Float voltage_C;    //C相电压
    private Float current_A;    //A相电流
    private Float current_B;    //B相电流
    private Float current_C;    //C相电流

    private Float activePower_A;        //A相有功功率
    private Float activePower_B;        //B相有功功率
    private Float activePower_C;        //C相有功功率
    private Float activePower_Total;    //总有功功率

    public ThreePhaseMeter() {
    }

    public ThreePhaseMeter(int id, float sign, String areaName, int courtsId, Float voltage_A, Float voltage_B, Float voltage_C, Float current_A, Float current_B, Float current_C, Float activePower_A, Float activePower_B, Float activePower_C, Float activePower_Total) {
        this.id = id;
        this.sign = sign;
        this.areaName = areaName;
        this.courtsId = courtsId;
        this.voltage_A = voltage_A;
        this.voltage_B = voltage_B;
        this.voltage_C = voltage_C;
        this.current_A = current_A;
        this.current_B = current_B;
        this.current_C = current_C;
        this.activePower_A = activePower_A;
        this.activePower_B = activePower_B;
        this.activePower_C = activePower_C;
        this.activePower_Total = activePower_Total;
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

    @Override
    public String toString() {
        return "ThreePhaseMeter{" +
                "id=" + id +
                ", sign=" + sign +
                ", areaName='" + areaName + '\'' +
                ", courtsId=" + courtsId +
                ", voltage_A=" + voltage_A +
                ", voltage_B=" + voltage_B +
                ", voltage_C=" + voltage_C +
                ", current_A=" + current_A +
                ", current_B=" + current_B +
                ", current_C=" + current_C +
                ", activePower_A=" + activePower_A +
                ", activePower_B=" + activePower_B +
                ", activePower_C=" + activePower_C +
                ", activePower_Total=" + activePower_Total +
                '}';
    }
}
