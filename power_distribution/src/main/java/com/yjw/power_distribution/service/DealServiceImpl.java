package com.yjw.power_distribution.service;

import com.yjw.power_distribution.mapper.DealMapper;
import com.yjw.power_distribution.pojo.Deal;
import com.yjw.power_distribution.pojo.ResponseObj;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class DealServiceImpl implements DealService{

    @Resource
    DealMapper dealMapper;

    @Override
    public ResponseObj addDealRecord(Deal deal) {
        ResponseObj responseObj = new ResponseObj();

        if(deal == null) {
            responseObj.setStateCode(0);
            responseObj.setInfo("Please check your network!");
            return responseObj;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Random random = new Random();
        int hour = random.nextInt(22-new Date().getHours()) + new Date().getHours();
        int hour_down = hour + 2;
        String start_time = sdf2.format(new Date()) + " " + hour + ":00:00";
        String end_time = sdf2.format(new Date()) + " " + hour_down + ":00:00";
        deal.setDeal_time(sdf.format(new Date()));
        deal.setResponse_start_time(start_time);
        deal.setResponse_end_time(end_time);
        System.out.println("deal:" + deal);
        Integer i = dealMapper.addDealRecord(deal);
        if(i == 0){
            responseObj.setStateCode(0);
            responseObj.setInfo("Database Save Error!");
            return responseObj;
        }
        responseObj.setStateCode(1);
        responseObj.setInfo("Add Deal Info Successful!");
        responseObj.setData(deal);
        return responseObj;
    }

    @Override
    public ResponseObj findAllDealRecord() {
        ResponseObj responseObj = new ResponseObj();
        List<Deal> dealList = dealMapper.findAllDealRecord();
        if(dealList.size() == 0){
            responseObj.setStateCode(0);
            responseObj.setInfo("No Deal!");
            return responseObj;
        }
        responseObj.setData(dealList);
        responseObj.setInfo("Find Deal Record Successful!");
        responseObj.setStateCode(1);
        return responseObj;
    }

}
