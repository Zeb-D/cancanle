package com.dingcan.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dingcan.daoimp.FoodOrderInfoimpl;
import com.dingcan.domain.FoodOrderInfo;
import com.dingcan.utils.DBOperator;
import com.dingcan.utils.PageBean;

public class FoodOrderController {
	DBOperator db;

	public FoodOrderController() {
		// TODO Auto-generated constructor stub
		db = new DBOperator();
	}

	// FoodOrder/comfirm.do
	public void comfirm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sql = "select * from T_FOODORDERINFO where T_STATE = '请求订单'";
		request.setAttribute("page", returnPage(request, sql));
		request.getRequestDispatcher("admin_queren.jsp").forward(request,
				response);
	}

	// FoodOrder/queryList.do
	public void queryList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String sql = "select * from T_FOODORDERINFO";
		request.setAttribute("page", returnPage(request, sql));
		request.getRequestDispatcher("/admin_allorders.jsp").forward(request,
				response);
	}

	public void queryList1(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("username") != null) {
			String sql = "select * from T_FOODORDERINFO where T_USERID  ="
					+ request.getSession().getAttribute("userid");
			request.setAttribute("page", returnPage(request, sql));
			request.getRequestDispatcher("/order.jsp").forward(request,
					response);
		} else
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
	}

	// FoodOrder/uncomfirm.do
	public void uncomfirm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String sql = "select * from T_FOODORDERINFO where T_STATE != '完成订单'";
		request.setAttribute("page", returnPage(request, sql));
		request.getRequestDispatcher("/admin_backorders.jsp").forward(request,
				response);
	}

	// 点击确认订单后调用的方法
	public void comfirmOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String sql = "UPDATE T_FOODORDERINFO SET T_STATE  = '确认订单' WHERE T_ID = "
				+ id;
		if (id != null) {
			this.executeSql(sql);
			this.comfirm(request, response);
		}
	}

	// 点击取消订单后调用的方法
	public void quxiaoOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String sql = "UPDATE T_FOODORDERINFO SET T_STATE  = '取消订单' WHERE T_ID = "
				+ id;
		if (id != null) {
			this.executeSql(sql);
			this.comfirm(request, response);
		}
	}

	// 执行sql语句所用的函数
	public void executeSql(String sql) {
		try {
			db = new DBOperator();
			db.executeUpdate(sql, null);
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 返回pageBean
	public PageBean<FoodOrderInfo> returnPage(HttpServletRequest request,
			String sql) {
		PageBean<FoodOrderInfo> page;
		int currentPage = 1;
		if (request.getParameter("page") != null) {

			currentPage = Integer.valueOf(request.getParameter("page"));

		}
		page = new FoodOrderInfoimpl().getPagedata(currentPage, sql);
		return page;
	}
}
