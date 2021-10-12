package com.yjw.power_distribution.service;

import com.yjw.power_distribution.pojo.User;

import java.util.List;

public interface UserService {


    //查询所有用户
    List<User> findAllUsers();

    //实现注册
    String checkRegist(User user);

    //实现登录
    String checkLogin(User user);
    //根据用户名查用户
    User findUserByName(String name);
    int findUserRole(String name);
    //检查用户名是否重复
    boolean checkName(String userName);
    //检查手机号是否重复
    boolean checkPhone(String phone);

    //更新密码
    boolean updateUserPwd(String newPwd,String userName);

    int updateUserState(int userId,int state);
    int updateUserRole(int userId,int role);

}
