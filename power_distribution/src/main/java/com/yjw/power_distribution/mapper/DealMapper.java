package com.yjw.power_distribution.mapper;

import com.yjw.power_distribution.pojo.Deal;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DealMapper {

    @Insert("INSERT INTO Deal (userId, courtId, trading_power, price, deal_time, response_start_time, response_end_time) " +
            "Values (#{userId}, #{courtId}, #{trading_power}, #{price}, #{deal_time}, #{response_start_time}, #{response_end_time})")
    Integer addDealRecord(Deal deal);

    @Select("Select * from Deal")
    List<Deal> findAllDealRecord();
}
