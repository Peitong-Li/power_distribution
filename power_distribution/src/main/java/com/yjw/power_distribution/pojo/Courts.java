package com.yjw.power_distribution.pojo;

public class Courts {

    private int courtsId;   //台区id
    private String courtsName;  //台区名
    private String courtsImageUrl;//台区图片地址

    public Courts() {
    }

    public Courts(int courtsId, String courtsName, String courtsImageUrl) {
        this.courtsId = courtsId;
        this.courtsName = courtsName;
        this.courtsImageUrl = courtsImageUrl;
    }

    public int getCourtsId() {
        return courtsId;
    }

    public void setCourtsId(int courtsId) {
        this.courtsId = courtsId;
    }

    public String getCourtsName() {
        return courtsName;
    }

    public void setCourtsName(String courtsName) {
        this.courtsName = courtsName;
    }

    public String getCourtsImageUrl() {
        return courtsImageUrl;
    }

    public void setCourtsImageUrl(String courtsImageUrl) {
        this.courtsImageUrl = courtsImageUrl;
    }

    @Override
    public String toString() {
        return "Courts{" +
                "courtsId=" + courtsId +
                ", courtsName='" + courtsName + '\'' +
                ", courtsImageUrl='" + courtsImageUrl + '\'' +
                '}';
    }
}
