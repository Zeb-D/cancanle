package com.dingcan.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dingcan.dao.LiuyanDAO;
import com.dingcan.domain.Liuyan;
import com.dingcan.domain.lookliuyan;
import com.dingcan.utils.DBOperator;
import com.dingcan.utils.PageBean;

public class Liuyanimpl implements LiuyanDAO {
	// 显示所有订单
	@Override
	public List<lookliuyan> queryList() {
		DBOperator db = new DBOperator();
		String sql = "select t_id,t_username,t_foodname,t_comment,t_reply,t_stars,t_comment_date from lookliuyan_view";
		try {
			ResultSet rs = db.executeQuery(sql, null);
			List<lookliuyan> list = lookList(rs);

			db.close();
			rs.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 返回未回复的留言
	@Override
	public int replyLiuyan(String sql, int id) {
		// TODO Auto-generated method stub
		DBOperator db = new DBOperator();
		Object[] ob = { id };
		int rs = 0;
		try {
			rs = db.executeUpdate(sql, ob);

			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public boolean DeleteByNo(String userid) {
		String sql = "delete T_LIUYAN where T_ID=?";
		DBOperator db = new DBOperator();
		Object[] ob = { userid };

		try {
			ResultSet rs = db.executeQuery(sql, ob);

			db.close();
			rs.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// 返回查看留言
	public List<lookliuyan> lookList(ResultSet rs) {
		List<lookliuyan> list = new ArrayList<lookliuyan>();
		try {
			while (rs.next()) {
				int id = rs.getInt(1);
				String username = rs.getString(2);
				String foodname = rs.getString(3);
				String comment = rs.getString(4);
				String reply = rs.getString(5);
				int stars = rs.getInt(6);
				Date commentdate = rs.getDate(7);

				lookliuyan liuyan = new lookliuyan(id, username, foodname,
						comment, reply, stars, commentdate);
				list.add(liuyan);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public List<Liuyan> returnList(ResultSet rs) {
		List<Liuyan> list = new ArrayList<Liuyan>();
		try {
			while (rs.next()) {
				int id = rs.getInt(1);
				int userid = rs.getInt(2);
				int foodid = rs.getInt(3);
				Date commentdate = rs.getDate(4);
				int stars = rs.getInt(5);
				String comment = rs.getString(6);
				String reply = rs.getString(7);

				Liuyan liuyan = new Liuyan(id, userid, foodid, commentdate,
						stars, comment, reply);
				list.add(liuyan);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public PageBean<lookliuyan> getPage(int pageNum, String sql) {
		PageBean<lookliuyan> pagebean = new PageBean<lookliuyan>();
		DBOperator db = new DBOperator();
		String countSql = "select count(T_ID) from lookliuyan_view";

		pagebean.setTotal(db.getCount(countSql));

		if (pageNum > pagebean.getTotalPage()) {
			pageNum = pagebean.getTotalPage();
		}
		if (pageNum <= 0) {
			pageNum = 1;
		}
		try {
			db.close();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}

		DBOperator dbo = new DBOperator();
		String strSql = "select * from (select a.* ,rownum rn from  (" + sql
				+ ") a where rownum <= " + pageNum * pagebean.getPagesize()
				+ " ) where rn>" + (pageNum - 1) * pagebean.getPagesize();
		System.out.println(strSql);
		ResultSet rs;
		try {
			rs = dbo.executeQuery(strSql, null);
			List<lookliuyan> list = lookList(rs);

			pagebean.getList().addAll(list);

			rs.close();
			pagebean.setCurrentPage(pageNum);
			return pagebean;
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				dbo.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public static void main(String[] args) {
		String sql = "update T_LIUYAN set T_REPLY= '草' where T_ID=?";
		int id = 32;
		int n = new Liuyanimpl().replyLiuyan(sql, id);
		if (n > 0)
			System.out.println("成功");
	}

	@Override
	public lookliuyan queryByid(int t_id) {
		DBOperator db = new DBOperator();
		String sql = "select t_id,t_username,t_foodname,t_comment,t_reply,t_stars,t_comment_date from lookliuyan_view where t_id=?";
		Object[] ob = { t_id };

		try {
			ResultSet rs = db.executeQuery(sql, ob);
			while (rs.next()) {
				int id = rs.getInt(1);
				String username = rs.getString(2);
				String foodname = rs.getString(3);
				String comment = rs.getString(4);
				String reply = rs.getString(5);
				int stars = rs.getInt(6);
				Date commentdate = rs.getDate(7);

				lookliuyan liuyan = new lookliuyan(id, username, foodname,
						comment, reply, stars, commentdate);
				return liuyan;
			}
			db.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
