package com.yjw.power_distribution.pojo;
/*
* 台区基本信息
* */

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;


public class BaseInfo {
    private Integer Id;
    // 台区ID
    private Integer courtId;
    private String courtName;

    // time
    private String time;
    // 台区容量 MVA
    private float capacity;
    // 台区供电半径 km
    private float radius;
    // 变压负载率 %
    private float load_rate;
    // 售电量 kwh
    private float power_sale;
    // 供电量 kwh
    private float power_apply;
    // 预测线损率、真实线损率、误差线损
    private float pre_line_loss;
    private float real_line_loss;
    private float error_line_loss;
    //负荷不平衡度
    private float load_unbalance_rate;
    // 供电可靠率
    private float power_reliability;
    // 电压合格率
    private float voltage_pass_percent;
    // 状态评估结果
    private Integer state_res;

    @Override
    public String toString() {
        return "BaseInfo{" +
                "Id=" + Id +
                ", courtId=" + courtId +
                ", courtName='" + courtName + '\'' +
                ", time=" + time +
                ", capacity=" + capacity +
                ", radius=" + radius +
                ", load_rate=" + load_rate +
                ", power_sale=" + power_sale +
                ", power_apply=" + power_apply +
                ", pre_line_loss=" + pre_line_loss +
                ", real_line_loss=" + real_line_loss +
                ", error_line_loss=" + error_line_loss +
                ", load_unbalance_rate=" + load_unbalance_rate +
                ", power_reliability=" + power_reliability +
                ", voltage_pass_percent=" + voltage_pass_percent +
                ", state_res=" + state_res +
                '}';
    }

    public BaseInfo() {

    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getCourtId() {
        return courtId;
    }

    public void setCourtId(Integer courtId) {
        this.courtId = courtId;
    }

    public String getCourtName() {
        return courtName;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getLoad_rate() {
        return load_rate;
    }

    public void setLoad_rate(float load_rate) {
        this.load_rate = load_rate;
    }

    public float getPower_sale() {
        return power_sale;
    }

    public void setPower_sale(float power_sale) {
        this.power_sale = power_sale;
    }

    public float getPower_apply() {
        return power_apply;
    }

    public void setPower_apply(float power_apply) {
        this.power_apply = power_apply;
    }

    public float getPre_line_loss() {
        return pre_line_loss;
    }

    public void setPre_line_loss(float pre_line_loss) {
        this.pre_line_loss = pre_line_loss;
    }

    public float getReal_line_loss() {
        return real_line_loss;
    }

    public void setReal_line_loss(float real_line_loss) {
        this.real_line_loss = real_line_loss;
    }

    public float getError_line_loss() {
        return error_line_loss;
    }

    public void setError_line_loss(float error_line_loss) {
        this.error_line_loss = error_line_loss;
    }

    public float getLoad_unbalance_rate() {
        return load_unbalance_rate;
    }

    public void setLoad_unbalance_rate(float load_unbalance_rate) {
        this.load_unbalance_rate = load_unbalance_rate;
    }

    public float getPower_reliability() {
        return power_reliability;
    }

    public void setPower_reliability(float power_reliability) {
        this.power_reliability = power_reliability;
    }

    public float getVoltage_pass_percent() {
        return voltage_pass_percent;
    }

    public void setVoltage_pass_percent(float voltage_pass_percent) {
        this.voltage_pass_percent = voltage_pass_percent;
    }

    public Integer getState_res() {
        return state_res;
    }

    public void setState_res(Integer state_res) {
        this.state_res = state_res;
    }
}
