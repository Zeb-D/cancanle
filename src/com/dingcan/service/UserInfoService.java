package com.dingcan.service;

import java.util.List;

import com.dingcan.domain.UserInfo;

public interface UserInfoService {
	List<UserInfo> queryList();  //查看所有用户

	UserInfo getByNo(int userid); //通过userid 查看该用户的信息
	
	boolean UpdateByNo(String sql, int userid); //通过userid修改该ID信息
	
	boolean DeleteByNo(int userid); //通过userid删除该用户
}
