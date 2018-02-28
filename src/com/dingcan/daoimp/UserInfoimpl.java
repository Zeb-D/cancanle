package com.dingcan.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dingcan.dao.UserInfoDAO;
import com.dingcan.domain.UserInfo;
import com.dingcan.utils.DBOperator;
import com.dingcan.utils.PageBean;

public class UserInfoimpl implements UserInfoDAO {

	public List<UserInfo> queryList() {
		DBOperator db = new DBOperator();
		String sql = "select * from T_UserInfo";
		try {
			ResultSet rs = db.executeQuery(sql, null);
			List<UserInfo> list = returnList(rs);

			db.close();
			rs.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public UserInfo getByNo(String userid) {
		String sql = "select * from T_UserInfo where T_USERID=?";
		DBOperator db = new DBOperator();
		Object[] ob = { userid };
		UserInfo user;

		try {
			ResultSet rs = db.executeQuery(sql, ob);
			UserInfo userinfo = returnUserinfo(rs);
			db.close();
			rs.close();
			return userinfo;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 通过用户名查询用户信息
	public UserInfo getByUsername(String username) {
		// TODO Auto-generated method stub
		String sql = "select * from T_USERINFO where T_USERNAME=?";
		DBOperator db = new DBOperator();
		Object[] ob = { username };

		try {
			ResultSet rs = db.executeQuery(sql, ob);
			UserInfo userinfo = returnUserinfo(rs);
			db.close();
			rs.close();
			return userinfo;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 注册
	public boolean Rigister(UserInfo user) {
		DBOperator db = new DBOperator();
		String sql = "insert into T_USERINFO(T_USERNAME ,T_USERPASS ,T_ADDRESS ,T_EXTRA_ADDRESS ,T_MONEY ) values(?,?,?,?,?)";
		int rs = 0;
		try {
			Object[] ob = { user.getUsername(), user.getUserpass(),
					user.getAddress(), user.getAddress2(), user.getMoney() };

			rs = db.executeUpdate(sql, ob);
			db.close();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean UpdateByNo(String value, String userid) {
		String sql = "update t_userinfo " + value + " where t_userid=?";
		System.out.println(sql);
		DBOperator db = new DBOperator();
		Object[] ob = { userid };
		try {
			ResultSet rs = db.executeQuery(sql, ob);
			db.close();
			rs.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean DeleteByNo(String userid) {
		String sql = "delete T_UserInfo where T_userid=?";
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

	// 通用返回单个用户信息
	public UserInfo returnUserinfo(ResultSet resultSet) {
		try {
			while (resultSet.next()) {
				int userid = resultSet.getInt("T_USERID");
				String username = resultSet.getString("T_USERNAME");
				String userpass = resultSet.getString("T_USERPASS");
				String address = resultSet.getString("T_ADDRESS");
				String address2 = resultSet.getString("T_EXTRA_ADDRESS");
				double money = resultSet.getDouble("T_MONEY");
				UserInfo UserInfo = new UserInfo(userid, username, userpass,
						address, address2, money);
				return UserInfo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 返回所有用户信息
	public List<UserInfo> returnList(ResultSet rs) {
		List<UserInfo> list = new ArrayList<UserInfo>();
		try {
			while (rs.next()) {
				int userid = rs.getInt("T_USERID");
				String username = rs.getString("T_USERNAME");
				String userpass = rs.getString("T_USERPASS");
				String address = rs.getString("T_ADDRESS");
				String address2 = rs.getString("T_EXTRA_ADDRESS");
				int money = rs.getInt("T_MONEY");
				UserInfo UserInfo = new UserInfo(userid, username, userpass,
						address, address2, money);
				// System.out.println(userid+ username+ userpass+ address+
				// address2+ money);
				list.add(UserInfo);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 分页
	@Override
	public PageBean<UserInfo> getPagedata(int pageNum) {
		// TODO Auto-generated method stub
		PageBean<UserInfo> pagebean = new PageBean<UserInfo>();
		DBOperator db = new DBOperator();
		String countSql = "select count(T_userid) from T_USERINFO";

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
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		DBOperator dbo = new DBOperator();
		String strSql = "select * from  (select a.* ,rownum rn from  (select * from t_USERINFO) a where rownum <= "
				+ pageNum
				* pagebean.getPagesize()
				+ " ) where rn>"
				+ (pageNum - 1) * pagebean.getPagesize();
		System.out.println(strSql);
		ResultSet rset;
		try {
			rset = dbo.executeQuery(strSql, null);
			UserInfo UserInfo;
			while (rset.next()) {

				int userid = rset.getInt("T_USERID");
				String username = rset.getString("T_USERNAME");
				String userpass = rset.getString("T_USERPASS");
				String address = rset.getString("T_ADDRESS");
				String address2 = rset.getString("T_EXTRA_ADDRESS");
				double money = rset.getDouble("T_MONEY");
				UserInfo = new UserInfo(userid, username, userpass, address,
						address2, money);

				pagebean.getList().add(UserInfo);

			}
			rset.close();
			pagebean.setCurrentPage(pageNum);
			// pagebean.setList(null);
			return pagebean;

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
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
		UserInfo user = new UserInfoimpl().getByNo("11");
		System.out.println(user);
	}
}
