package com.yjw.power_distribution.controller;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.bcel.internal.generic.ARETURN;
import com.yjw.power_distribution.pojo.Notice;
import com.yjw.power_distribution.pojo.ResponseObj;
import com.yjw.power_distribution.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.List;

@Controller
public class NoticeController {
    @Autowired
    NoticeService noticeService;


    //添加通知公告
    @PostMapping("/addNotice")
    @ResponseBody
    public ResponseObj addNotice(Notice notice){
        return noticeService.addNotice(notice);
    }

    //查询所有通知
    @PostMapping(value="/findAllNotice",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object findAllNotice()throws Exception{
        List<Notice> noticeList = noticeService.findAllNotice();
        return noticeList;
    }

    //根据Id查询通知
    @PostMapping(value="/findNoticeById",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object findNoticeById(int noticeId)throws Exception{
        System.out.print("获取到的Id:"+noticeId);
        Notice notice = noticeService.findNoticeById(noticeId);
        return notice;
    }

    //添加浏览次数
    @PostMapping(value="/addViewNum")
    @ResponseBody
    public String addViewNum(int noticeId)throws Exception{
        System.out.print("获取到的Id:"+noticeId);
        if(noticeService.updateViewNum(noticeId)==1){
            return "{\"addMsg\":\"1\"}";
        }else{
            return "{\"addMsg\":\"0\"}";
        }
    }

    //删除通知
    @PostMapping(value="/delNoticeById")
    @ResponseBody
    public String delNoticeById(int noticeId)throws Exception{
        System.out.print("获取到的Id:"+noticeId);
        if(noticeService.delNoticeById(noticeId)==1){
            return "{\"delMsg\":\"1\"}";
        }else{
            return "{\"delMsg\":\"0\"}";
        }
    }




}
