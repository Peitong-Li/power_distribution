package com.yjw.power_distribution.service;

import com.yjw.power_distribution.pojo.Deal;
import com.yjw.power_distribution.pojo.ResponseObj;
import org.springframework.stereotype.Service;

@Service
public interface DealService {

    ResponseObj addDealRecord(Deal deal);

    ResponseObj findAllDealRecord();

}
