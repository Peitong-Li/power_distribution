package com.yjw.power_distribution.service;

import com.yjw.power_distribution.pojo.Notice;
import com.yjw.power_distribution.pojo.ResponseObj;

import java.util.List;

public interface NoticeService {
    //添加
    ResponseObj addNotice(Notice notice);
    //查询所有通知
    List<Notice> findAllNotice();
    //根据Id查询通知
    Notice findNoticeById(int noticeId);
    //添加次数
    int updateViewNum(int noticeId);
    //删除
    int delNoticeById(int noticeId);

}
