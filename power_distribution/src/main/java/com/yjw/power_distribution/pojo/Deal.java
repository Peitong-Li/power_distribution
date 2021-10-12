package com.yjw.power_distribution.pojo;

/*
* 交易管理
* */
public class Deal {
    private Integer id;

    private Integer userId;

    private Integer courtId;

    private float trading_power;

    private float price;

    private String deal_time;

    private String response_start_time;

    private String response_end_time;

    @Override
    public String toString() {
        return "Deal{" +
                "id=" + id +
                ", userId=" + userId +
                ", courtId=" + courtId +
                ", trading_power=" + trading_power +
                ", price=" + price +
                ", deal_time='" + deal_time + '\'' +
                ", response_start_time='" + response_start_time + '\'' +
                ", response_end_time='" + response_end_time + '\'' +
                '}';
    }

    public Deal() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCourtId() {
        return courtId;
    }

    public void setCourtId(Integer courtId) {
        this.courtId = courtId;
    }

    public float getTrading_power() {
        return trading_power;
    }

    public void setTrading_power(float trading_power) {
        this.trading_power = trading_power;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDeal_time() {
        return deal_time;
    }

    public void setDeal_time(String deal_time) {
        this.deal_time = deal_time;
    }

    public String getResponse_start_time() {
        return response_start_time;
    }

    public void setResponse_start_time(String response_start_time) {
        this.response_start_time = response_start_time;
    }

    public String getResponse_end_time() {
        return response_end_time;
    }

    public void setResponse_end_time(String response_end_time) {
        this.response_end_time = response_end_time;
    }
}
