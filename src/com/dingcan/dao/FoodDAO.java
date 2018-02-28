package com.dingcan.dao;

import java.util.List;

import com.dingcan.domain.Food;
import com.dingcan.utils.PageBean;


public interface FoodDAO {
	List<Food> queryList();  //查看所有菜

	Food getByNo(int foodid); //通过foodid 查看该菜
	
	Food getByNo(String foodname); //通过foodname 查看该菜
	
	boolean UpdateByNo(Food food, int foodid); //通过foodid修改该菜
	
	boolean DeleteByNo(int foodid); //通过userid删除该菜

	void AddFood();

	

	
	void AddFood(Food food);    //添加菜品
	
	PageBean<Food> getPagedata(int pageNum,String sql);

}
