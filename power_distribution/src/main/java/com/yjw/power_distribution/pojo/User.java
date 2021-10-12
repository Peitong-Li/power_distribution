package com.yjw.power_distribution.pojo;


/*
    根据表创建 对应的实体类
CREATE TABLE `user` (
  `userId` int(11) NOT NULL,
  `userName` char(30) DEFAULT NULL,
  `phone` char(11) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


    */
public class User {

    private int userId;
    private String userName;
    private String userPwd;
    private String phone;
    private int role;       //用户角色
    private int state;      //用户状态



    public User() {
    }

    public User(int userId, String userName, String userPwd, String phone, int role, int state) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.phone = phone;
        this.role = role;
        this.state = state;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", phone='" + phone + '\'' +
                ", role=" + role +
                ", state=" + state +
                '}';
    }
}
