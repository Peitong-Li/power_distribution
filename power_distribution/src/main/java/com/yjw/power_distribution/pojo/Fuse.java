package com.yjw.power_distribution.pojo;

//4、熔断器
public class Fuse {

    private int id;             //变压器id
    private float sign;           //变压器标号
    private String areaName;    //所属区域侧（中压侧/配变侧/低压侧...）
    private int courtsId;  //台区名称

    private Float voltage;        //电压
    private Float current;        //电流
    private String switchState;    //开关状态(分闸/合闸)

    public Fuse() {
    }

    public Fuse(int id, float sign, String areaName, int courtsId, Float voltage, Float current, String switchState) {
        this.id = id;
        this.sign = sign;
        this.areaName = areaName;
        this.courtsId = courtsId;
        this.voltage = voltage;
        this.current = current;
        this.switchState = switchState;
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

    public Float getVoltage() {
        return voltage;
    }

    public void setVoltage(Float voltage) {
        this.voltage = voltage;
    }

    public Float getCurrent() {
        return current;
    }

    public void setCurrent(Float current) {
        this.current = current;
    }

    public String getSwitchState() {
        return switchState;
    }

    public void setSwitchState(String switchState) {
        this.switchState = switchState;
    }

    @Override
    public String toString() {
        return "Fuse{" +
                "id=" + id +
                ", sign=" + sign +
                ", areaName='" + areaName + '\'' +
                ", courtsId=" + courtsId +
                ", voltage=" + voltage +
                ", current=" + current +
                ", switchState='" + switchState + '\'' +
                '}';
    }
}
