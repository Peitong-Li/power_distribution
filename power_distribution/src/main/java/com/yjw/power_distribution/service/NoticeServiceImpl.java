package com.yjw.power_distribution.service;

import com.yjw.power_distribution.mapper.NoticeMapper;
import com.yjw.power_distribution.pojo.Notice;
import com.yjw.power_distribution.pojo.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class NoticeServiceImpl implements NoticeService{

    @Resource
    NoticeMapper noticeMapper;

    @Override
    public List<Notice> findAllNotice() {
        return noticeMapper.findAllNotice();
    }

    @Override
    public Notice findNoticeById(int noticeId) {
        return noticeMapper.findNoticeById(noticeId);
    }

    @Override
    public int updateViewNum(int noticeId) {
        return noticeMapper.updateViewNum(noticeId);
    }

    @Override
    public int delNoticeById(int noticeId) {
        return noticeMapper.delNoticeById(noticeId);
    }

    @Override
    public ResponseObj addNotice(Notice notice) {
        ResponseObj responseObj = new ResponseObj();
        if(notice == null){
            responseObj.setStateCode(0);
            responseObj.setInfo("Please check your network!");
            return responseObj;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(new Date());
        notice.setNoticeTime(time);
        notice.setViewNum(0);
        Integer resCode = noticeMapper.addNotice(notice);
        if(resCode == 0){
            responseObj.setStateCode(0);
            responseObj.setInfo("Database update Error!");
            return responseObj;
        }
        responseObj.setStateCode(1);
        responseObj.setInfo("Add Notice Successful!");
        return responseObj;
    }
}
