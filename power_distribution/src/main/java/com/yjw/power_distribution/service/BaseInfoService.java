package com.yjw.power_distribution.service;

import com.yjw.power_distribution.pojo.BaseInfo;
import com.yjw.power_distribution.pojo.ResponseObj;

import java.util.List;

public interface BaseInfoService {
    ResponseObj getBaseInfoByCourtId(Integer courtId);

    ResponseObj addBaseInfo(BaseInfo baseInfo);

    ResponseObj getAllBaseInfo();

    ResponseObj getBaseInfoByTimeAndCourtId(String time, Integer courtId);

    ResponseObj getBaseInfoCourtIdAndCourName();

    ResponseObj updateBaseInfo(BaseInfo baseInfo);
}
