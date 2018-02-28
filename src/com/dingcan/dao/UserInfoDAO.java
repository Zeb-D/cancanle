package com.dingcan.dao;

import java.util.List;

import com.dingcan.domain.UserInfo;
import com.dingcan.utils.PageBean;

public interface UserInfoDAO {
	List<UserInfo> queryList(); // 查看所有用户

	UserInfo getByNo(String userid); // 通过userid 查看该用户的信息

	UserInfo getByUsername(String username);// 通过用户名查找用户信息

	boolean UpdateByNo(String sql, String userid); // 通过userid修改该用户信息

	boolean Rigister(UserInfo user);

	boolean DeleteByNo(String userid); // 通过userid删除该用户

	PageBean<UserInfo> getPagedata(int pageNum);// 分页
}
