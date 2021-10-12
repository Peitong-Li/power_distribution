package com.yjw.power_distribution.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Notice {

    private int noticeId;
    private String noticeTitle; //通知标题
    private String noticeContent;//通知内容
//    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private String noticeTime;//发布时间
    private String noticePeo;//责任编辑
    private int viewNum;//浏览次数

    public Notice() {
    }

    public Notice(int noticeId, String noticeTitle, String noticeContent, String noticeTime, String noticePeo, int viewNum) {
        this.noticeId = noticeId;
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeTime = noticeTime;
        this.noticePeo = noticePeo;
        this.viewNum = viewNum;
    }

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(String noticeTime) {
        this.noticeTime = noticeTime;
    }

    public String getNoticePeo() {
        return noticePeo;
    }

    public void setNoticePeo(String noticePeo) {
        this.noticePeo = noticePeo;
    }

    public int getViewNum() {
        return viewNum;
    }

    public void setViewNum(int viewNum) {
        this.viewNum = viewNum;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "noticeId=" + noticeId +
                ", noticeTitle='" + noticeTitle + '\'' +
                ", noticeContent='" + noticeContent + '\'' +
                ", noticeTime=" + noticeTime +
                ", noticePeo='" + noticePeo + '\'' +
                ", viewNum=" + viewNum +
                '}';
    }
}
