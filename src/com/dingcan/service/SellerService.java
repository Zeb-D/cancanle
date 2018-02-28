package com.dingcan.service;

import java.util.List;

import com.dingcan.domain.Seller;

public interface SellerService {
	List<Seller> queryList();  //查看所有商家

	Seller getByNo(int sellerid); //通过userid 查看该商家的信息
	
	Seller getByName(String sellername); //通过sellername 查看该商家的信息
	
	boolean UpdateByNo(String sql, int sellerid); //通过userid修改该商家信息
	
	boolean DeleteByNo(int sellerid); //通过userid删除该商家
}
