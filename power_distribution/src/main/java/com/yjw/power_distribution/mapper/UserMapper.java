package com.yjw.power_distribution.mapper;

import com.yjw.power_distribution.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    //用户注册方法  使用注解方法实现mybatis操作(role:[0]管理员；[1]：普通用户    )
    @Insert("INSERT INTO user (userName,userPwd,phone,role,state)" +
            "VALUES (#{userName},#{userPwd},#{phone},1,1)")
    int addUser(User user);

    //根据用户名查询用户
    @Select("SELECT *"+
            " FROM user WHERE userName=#{name} ")
    User findUserByName(String name);
    //根据用户名查询角色
    @Select("SELECT role"+
            " FROM user WHERE userName=#{name} ")
    int findUserRole(String name);




    //根据手机号查用户
    @Select("SELECT * "+
            " FROM user WHERE phone=#{phone} ")
    User findUserByPhone(String phone);

    //根据用户名修改密码
    @Update("UPDATE user set userPwd=#{newPwd} WHERE userName=#{userName}")
    int updateUserPwd(String newPwd,String userName);


    //查询所有用户
    @Select("SELECT * "+
            " FROM user WHERE role!=2 ")
    List<User> findAllUsers();
    //更改用户状态
    @Update("UPDATE user set state=#{state} WHERE userId=#{userId}")
    int updateUserState(int userId,int state);
    //更改用户角色
    @Update("UPDATE user set role=#{role} WHERE userId=#{userId}")
    int updateUserRole(int userId,int role);

}
