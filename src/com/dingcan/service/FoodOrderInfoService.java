package com.dingcan.service;

import java.util.List;

import com.dingcan.domain.FoodOrderInfo;

public interface FoodOrderInfoService {
	
	boolean confirmOrder();    //确认所有未完成订单
	
	List<FoodOrderInfo> queryList(); //查询所有订单
	
	List<FoodOrderInfo> queryUnOrder();//查询所有未完成订单
}
