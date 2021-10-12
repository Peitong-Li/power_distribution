package com.yjw.power_distribution.controller;

import com.yjw.power_distribution.pojo.User;
import com.yjw.power_distribution.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.yjw.power_distribution.mapper.UserMapper;

import javax.servlet.http.HttpSession;
import java.util.List;


/*
* 声名当前类是一个Controller
*/
//@RestController
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/toIndex")
    public String toIndex()throws Exception{
        System.out.print("访问了动态页面");
        return "index";  //返回的页面名
    }

    @PostMapping("/login")
    public ModelAndView login(ModelAndView mav, User user, HttpSession session)throws Exception{
        String result = userService.checkLogin(user);
        //查询用户功能   考虑数据持久化  登陆后 用户状态需要持久化保存
        if("loginSuc".equals(result)){
            User getUser = userService.findUserByName(user.getUserName());
            session.setAttribute("user",getUser);
            mav.setViewName("loginSuc");
        }else if ("nameErr".equals(result)){
            mav.setViewName("index");
            mav.addObject("errMsg","用户名错误！");
        }else if ("pwdErr".equals(result)){
            mav.setViewName("index");
            mav.addObject("errMsg","密码错误！");
        }
        return mav ;
    }



    @PostMapping("/login_2")
    @ResponseBody
    public String checkLogin(User user) throws Exception{
        System.out.println(user);
        //调用业务逻辑层 单个判断用户名是否存在
        String result = userService.checkLogin(user);
        if("loginSuc".equals(result)){
            System.out.println("登录成功!");
            int role = userService.findUserRole(user.getUserName());
            System.out.println("返回的role:"+role);
            return "{\"msg\":\"1\"," +
                    "\"role\":"+ role + "}";
        }else if("zhErr".equals(result)){
            return "{\"msg\":\"2\"}";
        }else{
            System.out.println(user.toString());
            System.out.println("用户名或密码错误!");
            return "{\"msg\":\"0\"}";
        }
    }


    @PostMapping("/checkName")
    @ResponseBody
    public String checkName(String userName) throws Exception{
        //调用业务逻辑层 单个判断用户名是否存在
        System.out.print(userName);
        boolean result = userService.checkName(userName);
        if(result){
            return "{\"msg\":\"0\"}";
        }
        return "{\"msg\":\"1\"}";
    }

    @PostMapping("/checkPhone")
    @ResponseBody
    public String checkPhone(String phone) throws Exception{
        //调用业务逻辑层 单个判断用户名是否存在
        boolean result = userService.checkPhone(phone);
        if(result){
            return "{\"msg\":\"noRepet\"}";  //手机号没重复
        }
        return "{\"msg\":\"Repet\"}";  //手机号重复
    }

    @PostMapping("/regist")
    @ResponseBody
    public String checkRegist(User user)throws Exception{
        System.out.println("获取注册的信息为："+user);
        String result = userService.checkRegist(user);
        if(result=="registSuc"){
            return "{\"registMsg\":\"1\"}";  //注册成功
        }else if(result=="registErr"){
            return "{\"registMsg\":\"0\"}";  //注册失败
        }else if(result=="nameErr"){
            return "{\"registMsg\":\"2\"}";  //用户名重复
        }else if(result=="phoneErr"){
            return "{\"registMsg\":\"3\"}";  //电话重复
        }else{
            return "{\"registMsg\":\"4\"}"; //用户名和电话重复
        }
    }

    @PostMapping("/updateUserPwd")
    @ResponseBody
    public String updateUserPwd(String newPwd,String userName)throws Exception{
        System.out.println("用户名："+userName+";新密码："+newPwd);
        boolean result = userService.updateUserPwd(newPwd,userName);
        if(result){
            return "{\"updateMsg\":\"1\"}";
        }else{
            return "{\"updateMsg\":\"0\"}";
        }

    }

    @PostMapping("/findAllUsers")
    @ResponseBody
    public Object findAllUsers()throws Exception{
        List<User> userList = userService.findAllUsers();
        return userList;
    }

    @PostMapping("/updateUserState")
    @ResponseBody
    public Object updateUserState(int userId,int state)throws Exception{
       int i = userService.updateUserState(userId,state);
       if(i==1){
           System.out.println("修改成功");
           return "{\"updateMsg\":\"1\"}";
       }else{
           System.out.println("修改失败");
           return "{\"updateMsg\":\"0\"}";
       }
    }
    @PostMapping("/updateUserRole")
    @ResponseBody
    public Object updateUserRole(int userId,int role)throws Exception{
        int i = userService.updateUserRole(userId,role);
        if(i==1){
            System.out.println("修改成功");
            return "{\"updateMsg\":\"1\"}";
        }else{
            System.out.println("修改失败");
            return "{\"updateMsg\":\"0\"}";
        }
    }


}
