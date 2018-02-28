package com.dingcan.service;

import java.util.List;

import com.dingcan.domain.Liuyan;

public interface LiuyanService {

	List<Liuyan> queryList();   //查看所有留言
	
	boolean replyLiuyan(int userid);         //回复该id未回复留言
	
	boolean deleteLiuyan(int userid);     //根据ID删除留言
}
