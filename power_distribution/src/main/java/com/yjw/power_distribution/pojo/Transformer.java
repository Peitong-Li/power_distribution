package com.yjw.power_distribution.pojo;



//1、智能变压器
public class Transformer {

    private int id;             //变压器id
    private float sign;           //变压器标号
    private String areaName;    //所属区域侧（中压侧/配变侧/低压侧...）
    private int courtsId;  //台区名称

    private Float voltage_A;          //A相电压
    private Float voltage_B;          //B相电压
    private Float voltage_C;          //C相电压
    private Float voltage_AB;         //AB线电压
    private Float voltage_BC;         //BC线电压
    private Float voltage_CA;         //CA线电压
    private Float current_A;          //A相电流
    private Float current_B;          //B相电流
    private Float current_C;          //C相电流

    private String switchState;     //分接头档位（分闸/合闸）
    private Float poleTemperature;  //桩头温度
    private Float oilTemperature;   //油温
    private Float oilPosition;      //油位
    private Float insidePressure;   //内部压力


    public Transformer() {
    }

    public Transformer(int id, float sign, String areaName, int courtsId, Float voltage_A, Float voltage_B, Float voltage_C, Float voltage_AB, Float voltage_BC, Float voltage_CA, Float current_A, Float current_B, Float current_C, String switchState, Float poleTemperature, Float oilTemperature, Float oilPosition, Float insidePressure) {
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
        this.switchState = switchState;
        this.poleTemperature = poleTemperature;
        this.oilTemperature = oilTemperature;
        this.oilPosition = oilPosition;
        this.insidePressure = insidePressure;
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

    public String getSwitchState() {
        return switchState;
    }

    public void setSwitchState(String switchState) {
        this.switchState = switchState;
    }

    public Float getPoleTemperature() {
        return poleTemperature;
    }

    public void setPoleTemperature(Float poleTemperature) {
        this.poleTemperature = poleTemperature;
    }

    public Float getOilTemperature() {
        return oilTemperature;
    }

    public void setOilTemperature(Float oilTemperature) {
        this.oilTemperature = oilTemperature;
    }

    public Float getOilPosition() {
        return oilPosition;
    }

    public void setOilPosition(Float oilPosition) {
        this.oilPosition = oilPosition;
    }

    public Float getInsidePressure() {
        return insidePressure;
    }

    public void setInsidePressure(Float insidePressure) {
        this.insidePressure = insidePressure;
    }

    @Override
    public String toString() {
        return "Transformer{" +
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
                ", switchState='" + switchState + '\'' +
                ", poleTemperature=" + poleTemperature +
                ", oilTemperature=" + oilTemperature +
                ", oilPosition=" + oilPosition +
                ", insidePressure=" + insidePressure +
                '}';
    }
}
