package com.yjw.power_distribution.pojo;

//10、光伏用户
public class PvUser {
   private int id;             //变压器id
   private float sign;           //变压器标号
   private String areaName;    //所属区域侧（中压侧/配变侧/低压侧...）
   private int courtsId;  //台区名称

   private Float current;  //光伏板组串直流侧电流
   private Float voltage;  //光伏板组串直流侧电压
   private Float power;    //光伏板组串直流侧功率

   public PvUser() {
   }

   public PvUser(int id, float sign, String areaName, int courtsId, Float current, Float voltage, Float power) {
      this.id = id;
      this.sign = sign;
      this.areaName = areaName;
      this.courtsId = courtsId;
      this.current = current;
      this.voltage = voltage;
      this.power = power;
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

   public Float getCurrent() {
      return current;
   }

   public void setCurrent(Float current) {
      this.current = current;
   }

   public Float getVoltage() {
      return voltage;
   }

   public void setVoltage(Float voltage) {
      this.voltage = voltage;
   }

   public Float getPower() {
      return power;
   }

   public void setPower(Float power) {
      this.power = power;
   }

   @Override
   public String toString() {
      return "PvUser{" +
              "id=" + id +
              ", sign=" + sign +
              ", areaName='" + areaName + '\'' +
              ", courtsId=" + courtsId +
              ", current=" + current +
              ", voltage=" + voltage +
              ", power=" + power +
              '}';
   }
}
