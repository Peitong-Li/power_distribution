package com.yjw.power_distribution.pojo;

//12、电缆感知设备
public class CableSensingDevice {
    private int id;             //变压器id
    private float sign;           //变压器标号
    private String areaName;    //所属区域侧（中压侧/配变侧/低压侧...）
    private int courtsId;  //台区id

    private Float temperature;      //温度
    private String harmfulGas;       //有害气体
    private String combustibleGas;   //可燃气体
    private Float displacement;     //位移    ThreePhaseMeter

    public CableSensingDevice() {
    }

    public CableSensingDevice(int id, float sign, String areaName, int courtsId, Float temperature, String harmfulGas, String combustibleGas, Float displacement) {
        this.id = id;
        this.sign = sign;
        this.areaName = areaName;
        this.courtsId = courtsId;
        this.temperature = temperature;
        this.harmfulGas = harmfulGas;
        this.combustibleGas = combustibleGas;
        this.displacement = displacement;
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

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public String getHarmfulGas() {
        return harmfulGas;
    }

    public void setHarmfulGas(String harmfulGas) {
        this.harmfulGas = harmfulGas;
    }

    public String getCombustibleGas() {
        return combustibleGas;
    }

    public void setCombustibleGas(String combustibleGas) {
        this.combustibleGas = combustibleGas;
    }

    public Float getDisplacement() {
        return displacement;
    }

    public void setDisplacement(Float displacement) {
        this.displacement = displacement;
    }

    @Override
    public String toString() {
        return "CableSensingDevice{" +
                "id=" + id +
                ", sign=" + sign +
                ", areaName='" + areaName + '\'' +
                ", courtsId=" + courtsId +
                ", temperature=" + temperature +
                ", harmfulGas='" + harmfulGas + '\'' +
                ", combustibleGas='" + combustibleGas + '\'' +
                ", displacement=" + displacement +
                '}';
    }
}
