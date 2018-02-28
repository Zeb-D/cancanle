package com.dingcan.dao;

import java.util.List;

import com.dingcan.domain.Seller;
import com.dingcan.utils.PageBean;

public interface SellerDAO {
	
	List<Seller> queryList();  //查看所有商家
	
	List<String> queryAllName();//查看所有商家名称
	
	PageBean<Seller> getPagedata(int pageNum,String range);//

	Seller getByNo(int sellerid); //通过userid 查看该商家的信息
	
	Seller getByName(String sellername); //通过sellername 查看该商家的信息
	
	boolean InsertSeller(Seller seller);//增加商家
	
	boolean UpdateByNo(Seller seller, int sellerid); //通过userid修改该商家信息
	
	boolean DeleteByNo(int sellerid); //通过userid删除该商家
}
