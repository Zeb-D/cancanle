package com.dingcan.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 连接数据库类
 */
public class DBOperator {

	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;

	/**
	 * 构造方法初始化数据库连接
	 */
	public DBOperator() {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@172.21.144.13:1521:orcl";// "jdbc:oracle:thin:@localhost:1521:orcl";
			conn = DriverManager.getConnection(url, "yd", "yd");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 对数据库增，删，改操作的调用方法
	 */
	public int executeUpdate(String sql, Object[] obj) throws SQLException {
		stmt = conn.prepareStatement(sql);
		if (obj != null)
			for (int i = 0; i < obj.length; i++) {
				stmt.setObject(i + 1, obj[i]);
			}
		int ri = stmt.executeUpdate();
		return ri;
	}

	/**
	 * 对数据库查找操作的调用方法
	 */
	public ResultSet executeQuery(String sql, Object[] obj) throws SQLException {
		stmt = conn.prepareStatement(sql);
		if (obj != null)
			for (int i = 0; i < obj.length; i++) {
				stmt.setObject(i + 1, obj[i]);
			}
		rs = stmt.executeQuery();
		return rs;
	}

	/**
	 * 关闭数据库方法，释放资源
	 */
	public void close() throws SQLException {
		if (conn != null) {
			conn.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (rs != null) {
			rs.close();
		}
	}

	// 获取记录的总个数
	public int getCount(String countSql) {
		ResultSet resultSet = null;
		try {
			resultSet = executeQuery(countSql, null);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			while (resultSet.next()) {
				return resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return -1;
	}

}
