package com.yjw.power_distribution.service;
import com.yjw.power_distribution.mapper.UserMapper;
import com.yjw.power_distribution.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserServiceImpl implements UserService{
    @Resource
    UserMapper userMapper;

    @Override
    public List<User> findAllUsers() {
        List<User> userList = userMapper.findAllUsers();
        return userList;
    }


    @Override
    public String checkLogin(User user) {
        User getUser = userMapper.findUserByName(user.getUserName());
        if(null!=getUser){
            if(getUser.getUserPwd().equals(user.getUserPwd()) && getUser.getState() == 1 ){
                return "loginSuc";
            }else if(getUser.getUserPwd().equals(user.getUserPwd()) && getUser.getState() == 0){
                return "zhErr";
            }else {
                return "pwdErr";
            }
        }else{
            return "nameErr";
        }
    }

    @Override
    public User findUserByName(String name) {
        return userMapper.findUserByName(name);
    }

    @Override
    public int findUserRole(String name) {
        return userMapper.findUserRole(name);
    }

    @Override
    public boolean checkName(String userName) {
        User user = userMapper.findUserByName(userName);
        if(user==null){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkPhone(String phone) {
        User user = userMapper.findUserByPhone(phone);
        if(user==null){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUserPwd(String newPwd, String userName) {
        int result = userMapper.updateUserPwd(newPwd,userName);
        if(result > 0){
            return true;
        }
        return false;
    }

    @Override
    public String checkRegist(User user) {
        boolean nameFlag = checkName(user.getUserName());
        boolean phoneFlag = checkPhone(user.getPhone());
        if(!nameFlag && !phoneFlag){
            return "name&phoneErr";//用户名、手机号重复
        }
        if(!nameFlag){
            return "nameErr";//用户名重复
        }
        if(!phoneFlag){
            return "phoneErr";//手机号重复
        }
        int i = userMapper.addUser(user);
        if(i>0){
            return "registSuc";//注册成功
        }else{
            return "registErr";//注册失败
        }
    }

    @Override
    public int updateUserState(int userId, int state) {
        int i = userMapper.updateUserState(userId,state);
        return i;
    }

    @Override
    public int updateUserRole(int userId, int role) {
        int i = userMapper.updateUserRole(userId,role);
        return i;
    }
}
