package com.dingcan.dao;

import java.util.List;

import com.dingcan.domain.lookliuyan;
import com.dingcan.utils.PageBean;

public interface LiuyanDAO {

	List<lookliuyan> queryList(); // 查看所有留言

	lookliuyan queryByid(int id);

	int replyLiuyan(String sql, int id); // 回复id未回复留言

	PageBean<lookliuyan> getPage(int pageNum, String sql);

	boolean DeleteByNo(String userid);
}
