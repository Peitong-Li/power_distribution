package com.yjw.power_distribution.service;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.yjw.power_distribution.mapper.BaseInfoMapper;
import com.yjw.power_distribution.pojo.BaseInfo;
import com.yjw.power_distribution.pojo.Courts;
import com.yjw.power_distribution.pojo.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class BaseInfoServiceImpl implements BaseInfoService {


    @Autowired
    DeviceService deviceService;

    @Resource
    BaseInfoMapper baseInfoMapper;

    // 根据CourtId查找所有时间的基本信息
    @Override
    public ResponseObj getBaseInfoByCourtId(Integer courtId) {
        ResponseObj responseObj = new ResponseObj();

        if(courtId == null) {
            responseObj.setStateCode(0);
            responseObj.setInfo("Please check your network!");
            return responseObj;
        }

        List<BaseInfo> baseInfoList = baseInfoMapper.getBaseInfoByCourtId(courtId);
        if(baseInfoList == null || baseInfoList.size() == 0){
            responseObj.setStateCode(0);
            responseObj.setInfo("No Court BaseInfo in Database!");
            return responseObj;
        }
        responseObj.setStateCode(1);
        responseObj.setInfo("Find Court Base Info Successful!");
        responseObj.setData(baseInfoList);

        return responseObj;
    }


    // 获取所有基本信息
    @Override
    public ResponseObj getAllBaseInfo() {
        ResponseObj responseObj = new ResponseObj();
        List<BaseInfo> baseInfoList = baseInfoMapper.getAllBaseInfo();
        if(baseInfoList == null){
            responseObj.setStateCode(0);
            responseObj.setInfo("Database find Error!");
            return responseObj;
        }
        responseObj.setStateCode(1);
        responseObj.setInfo("Add Court Base Info Successful!");
        responseObj.setData(baseInfoList);
        return responseObj;
    }

    // 根据时间和CourtId查找一个BaseInfo
    @Override
    public ResponseObj getBaseInfoByTimeAndCourtId(String time, Integer courtId) {
        ResponseObj responseObj = new ResponseObj();

        if(time == null || courtId == null) {
            responseObj.setStateCode(0);
            responseObj.setInfo("Please check your network!");
            return responseObj;
        }

        BaseInfo baseInfo = baseInfoMapper.getBaseInfoByTimeAndCourtId(time, courtId);
        if(baseInfo == null){
            responseObj.setStateCode(0);
            responseObj.setInfo("Database find Error!");
            return responseObj;
        }
        responseObj.setStateCode(1);
        responseObj.setInfo("Find Successful!");
        responseObj.setData(baseInfo);
        return responseObj;
    }

    // 不重复获取台区名和台区ID
    @Override
    public ResponseObj getBaseInfoCourtIdAndCourName() {
        ResponseObj responseObj = new ResponseObj();

        List<BaseInfo> baseInfoList = baseInfoMapper.getBaseInfoCourtIdAndCourName();
        if(baseInfoList == null || baseInfoList.size() == 0){
            responseObj.setStateCode(0);
            responseObj.setInfo("Database No Record!");
            return responseObj;
        }
        responseObj.setStateCode(1);
        responseObj.setInfo("Find Successful!");
        responseObj.setData(baseInfoList);
        return responseObj;
    }

    // 更新
    @Override
    public ResponseObj updateBaseInfo(BaseInfo baseInfo) {
        ResponseObj responseObj = new ResponseObj();
        if(baseInfo == null){
            responseObj.setStateCode(0);
            responseObj.setInfo("Please check your network!");
            return responseObj;
        }
        System.out.println(baseInfo);
        Integer resCode = baseInfoMapper.updateBaseInfo(baseInfo);
        System.out.println("resCode:" + resCode);
        if(resCode == 0){
            responseObj.setStateCode(0);
            responseObj.setInfo("Database update Error!");
            return responseObj;
        }
        responseObj.setStateCode(1);
        responseObj.setInfo("Update BaseInfo Successful!");
        return responseObj;
    }

    // 添加基本信息
    @Override
    public ResponseObj addBaseInfo(BaseInfo baseInfo) {
        ResponseObj responseObj = new ResponseObj();

        if(baseInfo == null) {
            responseObj.setStateCode(0);
            responseObj.setInfo("Please check your network!");
            return responseObj;
        }

        BaseInfo baseInfo1 = baseInfoMapper.getBaseInfoByTimeAndCourtId(baseInfo.getTime(), baseInfo.getCourtId());
        if(baseInfo1 != null){
            responseObj.setStateCode(0);
            responseObj.setInfo("This court Information have uploaded, Please update!");
            return responseObj;
        }

        Integer res = baseInfoMapper.addBaseInfo(baseInfo);
        if(res == 0){
            responseObj.setStateCode(0);
            responseObj.setInfo("Database Save Error!");
            return responseObj;
        }

        responseObj.setStateCode(1);
        responseObj.setInfo("Add Court Base Info Successful!");
        responseObj.setData(baseInfo);
        return responseObj;
    }

}
