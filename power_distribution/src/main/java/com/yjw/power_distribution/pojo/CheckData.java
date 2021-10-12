package com.yjw.power_distribution.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CheckData {
    //CREATE TABLE `check` (
    //  `checkId` int(11) NOT NULL AUTO_INCREMENT,
    //  `checkName` char(50) DEFAULT NULL,
    //  `checkContent` char(200) DEFAULT NULL,
    //  `checkResult` char(200) DEFAULT NULL,
    //  `checkCourts` int(11) DEFAULT NULL,
    //  `checkPeople` char(20) DEFAULT '',
    //  `checkTime` date DEFAULT NULL,
    //  PRIMARY KEY (`checkId`)
    //) ENGINE=MyISAM DEFAULT CHARSET=utf8;
    private int checkId;
    private String checkName;
    private String checkContent;
    private String checkResult;
    private String checkTime;
    private String checkPeo;
    private int courtsId;
    private String courtsName;

    public CheckData() {
    }

    public CheckData(int checkId, String checkName, String checkContent, String checkResult, String checkTime, String checkPeo, int courtsId, String courtsName) {
        this.checkId = checkId;
        this.checkName = checkName;
        this.checkContent = checkContent;
        this.checkResult = checkResult;
        this.checkTime = checkTime;
        this.checkPeo = checkPeo;
        this.courtsId = courtsId;
        this.courtsName = courtsName;
    }

    public int getCheckId() {
        return checkId;
    }

    public void setCheckId(int checkId) {
        this.checkId = checkId;
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    public String getCheckContent() {
        return checkContent;
    }

    public void setCheckContent(String checkContent) {
        this.checkContent = checkContent;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getCheckPeo() {
        return checkPeo;
    }

    public void setCheckPeo(String checkPeo) {
        this.checkPeo = checkPeo;
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

    @Override
    public String toString() {
        return "CheckData{" +
                "checkId=" + checkId +
                ", checkName='" + checkName + '\'' +
                ", checkContent='" + checkContent + '\'' +
                ", checkResult='" + checkResult + '\'' +
                ", checkTime=" + checkTime +
                ", checkPeo='" + checkPeo + '\'' +
                ", courtsId=" + courtsId +
                ", courtsName='" + courtsName + '\'' +
                '}';
    }
}
