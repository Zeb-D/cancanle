package com.dingcan.dao;

import java.util.List;

import com.dingcan.domain.FoodOrderInfo;
import com.dingcan.domain.Seller;
import com.dingcan.utils.PageBean;

public interface FoodOrderInfoDAO {
	
	List<FoodOrderInfo> confirmOrder();    //确认所有未完成订单
	
	List<FoodOrderInfo> queryList(); //查询所有订单
	
	
	
	List<FoodOrderInfo> queryUnOrder();//查询所有未完成订单
	
	PageBean<FoodOrderInfo> getPagedata(int pageNum,String sql);//使用分页查询
}
