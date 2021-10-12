package com.yjw.power_distribution.controller;

import com.yjw.power_distribution.pojo.Deal;
import com.yjw.power_distribution.pojo.ResponseObj;
import com.yjw.power_distribution.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/deal")
public class DealController {
    @Autowired
    DealService dealService;

    @PostMapping("/addDealRecord")
    @ResponseBody
    public ResponseObj addDealRecord(Deal deal){
        return dealService.addDealRecord(deal);
    }

    @GetMapping("/findAllDealRecord")
    @ResponseBody
    public ResponseObj findAllDealRecord(){
        return dealService.findAllDealRecord();
    }
}
