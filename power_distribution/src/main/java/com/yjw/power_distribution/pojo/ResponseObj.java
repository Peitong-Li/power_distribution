package com.yjw.power_distribution.pojo;

public class ResponseObj {

    private Integer stateCode;

    private String info;

    private Object data;

    @Override
    public String toString() {
        return "ResponseObj{" +
                "stateCode=" + stateCode +
                ", info='" + info + '\'' +
                ", data=" + data +
                '}';
    }

    public ResponseObj() {

    }

    public Integer getStateCode() {
        return stateCode;
    }

    public void setStateCode(Integer stateCode) {
        this.stateCode = stateCode;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}



