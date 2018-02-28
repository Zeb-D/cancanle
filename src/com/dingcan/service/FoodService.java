package com.dingcan.service;

import java.util.List;

import com.dingcan.domain.Food;

public interface FoodService {
	List<Food> queryList();  //查看所有菜

	Food getByNo(int foodid); //通过foodid 查看该菜
	
	Food getByNo(String foodname); //通过foodname 查看该菜
	
	boolean UpdateByNo(String sql, int foodid); //通过foodid修改该菜
	
	boolean DeleteByNo(int foodid); //通过userid删除该菜
}
