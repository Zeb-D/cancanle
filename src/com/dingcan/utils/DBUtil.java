package com.dingcan.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	// 驱动类
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	// 数据库链接字符串
	public static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	// 用户名
	public static final String NAME = "scott";
	// 密码
	public static final String PWD = "tiger";

	// 数据库链接对象
	Connection con = null;
	// 预编译语句对象
	PreparedStatement ps = null;
	// 结果集对象
	ResultSet rs = null;

	/**
	 * 返回数据库链接对象
	 * 
	 * @return
	 */
	public Connection getCon() {
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, NAME, PWD);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	/**
	 * 关闭关闭
	 */
	public void closeAll() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 增删改通用方法
	 * 
	 * @param sql
	 * @param obj
	 * @return
	 */
	public int update(String sql, Object... obj) {
		int result = 0;
		con = getCon();
		try {
			ps = con.prepareStatement(sql);

			if (obj != null) {
				// 不等于空证明有传质
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i + 1, obj[i]);
				}
			}

			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}

		return result;
	}

	/**
	 * 查询
	 * 
	 * @param sql
	 * @param obj
	 * @return
	 */
	public ResultSet query(String sql, Object... obj) {
		try {
			con = getCon();
			ps = con.prepareStatement(sql);
			if (obj != null) {
				// 不等于空证明有传质
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i + 1, obj[i]);
				}
			}
			rs = ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rs;
	}

	public int getCount(String countSql) {
		ResultSet resultSet = query(countSql);
		try {
			while (resultSet.next()) {
				return resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return -1;
	}

}
