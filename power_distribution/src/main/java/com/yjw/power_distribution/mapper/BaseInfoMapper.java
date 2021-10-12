package com.yjw.power_distribution.mapper;

import com.yjw.power_distribution.pojo.BaseInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BaseInfoMapper {

    @Update("Update BaseInfo set capacity=#{capacity}, radius=#{radius}, load_rate=#{load_rate}, " +
            "power_sale=#{power_sale}, power_apply=#{power_apply}, pre_line_loss=#{pre_line_loss}, real_line_loss=#{real_line_loss}," +
            "error_line_loss=#{error_line_loss}, load_unbalance_rate=#{load_unbalance_rate}, power_reliability=#{power_reliability}, " +
            "voltage_pass_percent=#{voltage_pass_percent}, state_res=#{state_res} " +
            "where courtId=#{courtId} and time=#{time}" )
    Integer updateBaseInfo(BaseInfo baseInfo);

    @Select("Select * from BaseInfo where courtId = #{courtId}")
    List<BaseInfo> getBaseInfoByCourtId(Integer courtId);

    @Insert("INSERT INTO BaseInfo (courtId, courtName, capacity, radius, load_rate, power_sale, power_apply, " +
            "pre_line_loss, real_line_loss, error_line_loss, load_unbalance_rate, power_reliability, " +
            "voltage_pass_percent, state_res, time) VALUES (#{courtId}, #{courtName}, #{capacity}, #{radius}, #{load_rate}, #{power_sale}, " +
            "#{power_apply}, #{pre_line_loss}, #{real_line_loss}, #{error_line_loss}, #{load_unbalance_rate}, #{power_reliability}, " +
            "#{voltage_pass_percent}, #{state_res}, #{time})")
    Integer addBaseInfo(BaseInfo baseInfo);

    @Select("Select * from BaseInfo")
    List<BaseInfo> getAllBaseInfo();


    @Select("Select * from BaseInfo where time = #{time} and courtId=#{courtId}")
    BaseInfo getBaseInfoByTimeAndCourtId(String time, Integer courtId);

    @Select("Select distinct courtId, courtName from BaseInfo")
    List<BaseInfo> getBaseInfoCourtIdAndCourName();

}
