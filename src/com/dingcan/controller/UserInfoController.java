package com.dingcan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dingcan.daoimp.UserInfoimpl;
import com.dingcan.domain.UserInfo;
import com.dingcan.utils.PageBean;

public class UserInfoController {

	public void queryList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PageBean<UserInfo> page;
		int currentPage = 1;
		if (request.getParameter("page") != null) {

			currentPage = Integer.valueOf(request.getParameter("page"));

		}
		page = new UserInfoimpl().getPagedata(currentPage);

		request.setAttribute("page", page);
		request.getRequestDispatcher("/admin_allmembers.jsp").forward(request,
				response);
	}

	public void queryList2(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PageBean<UserInfo> page;
		int currentPage = 1;
		if (request.getParameter("page") != null) {

			currentPage = Integer.valueOf(request.getParameter("page"));

		}
		page = new UserInfoimpl().getPagedata(currentPage);

		request.setAttribute("page", page);
		request.getRequestDispatcher("/admin_allmembers2.jsp").forward(request,
				response);
	}

	public void DeleteByNo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();// 获得输出流
		if (id != null && id.length() > 0) {
			boolean is = new UserInfoimpl().DeleteByNo(id);
			if (is)
				System.out.println("UserInfo 删除成功");
			// request.getRequestDispatcher("/admin_allmembers.jsp").forward(request,
			// response);
			this.queryList(request, response);
			out.print("<script>" + "alert('成功了');" + "" + "</script>");
		}
	}

	public void UpdateByNo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String str = new String(request.getParameter("sql").getBytes(
				"ISO-8859-1"), "utf-8");
		System.out.println(str);
		if (id != null && id.length() > 0) {
			boolean is = new UserInfoimpl().UpdateByNo(str, id);
			if (is)
				System.out.println("UserInfo 更新成功");
			else
				System.out.println("UserInfo 更新失败");
			// request.getRequestDispatcher("/admin_allmembers.jsp").forward(request,
			// response);
			this.queryList(request, response);
		}
	}

	public void getByNo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();// 获得输出流
		if (id != null && id.length() > 0) {
			Object is = new UserInfoimpl().getByNo(id);
			if ((Boolean) is)
				System.out.println("UserInfo 删除成功");
			// request.getRequestDispatcher("/admin_allmembers.jsp").forward(request,
			// response);
			this.queryList(request, response);
			out.print("<script>" + "alert('成功了');" + "" + "</script>");
		}
	}

}
