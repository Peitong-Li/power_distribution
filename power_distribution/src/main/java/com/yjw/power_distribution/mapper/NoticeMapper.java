package com.yjw.power_distribution.mapper;

import com.yjw.power_distribution.pojo.CheckData;
import com.yjw.power_distribution.pojo.Notice;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoticeMapper {

    @Insert("insert into notice (noticeTitle,noticeContent,noticeTime,noticePeo,viewNum) " +
            "values (#{noticeTitle},#{noticeContent},#{noticeTime},#{noticePeo},#{viewNum})")
    Integer addNotice(Notice notice);

    @Select("select * from notice ORDER BY noticeTime desc")
    List<Notice> findAllNotice();

    @Select("select * from notice where noticeId=#{noticeId}")
    Notice findNoticeById(int noticeId);

    @Update("update notice set viewNum=notice.ViewNum+1 where noticeId=#{noticeId}")
    int updateViewNum(int noticeId);

    @Delete("delete from notice where noticeId=#{noticeId}")
    int delNoticeById(int noticeId);

}




