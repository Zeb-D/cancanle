package com.dingcan.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dingcan.daoimp.Liuyanimpl;
import com.dingcan.domain.lookliuyan;
import com.dingcan.utils.PageBean;

public class LiuyanController extends HttpServlet {

	// 返回 lookliuyan PageBean
	public void lookliuyan(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String sql = "select * from lookliuyan_view";
		PageBean<lookliuyan> page;
		int currentPage = 1;
		if (request.getParameter("page") != null) {

			currentPage = Integer.valueOf(request.getParameter("page"));

		}
		page = new Liuyanimpl().getPage(currentPage, sql);

		request.setAttribute("page", page);
		request.getRequestDispatcher("/admin_liuyan.jsp").forward(request,
				response);
	}

	public void dliuyan(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sql = "select * from lookliuyan_view";
		PageBean<lookliuyan> page;
		int currentPage = 1;
		if (request.getParameter("page") != null) {

			currentPage = Integer.valueOf(request.getParameter("page"));

		}
		page = new Liuyanimpl().getPage(currentPage, sql);

		request.setAttribute("page", page);
		// System.out.println(page);
		request.getRequestDispatcher("/admin_liuyanshanchu.jsp").forward(
				request, response);
	}

	public void replyliuyan(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		lookliuyan liuyan = new Liuyanimpl().queryByid(id);
		request.setAttribute("liuyan", liuyan);
		request.getRequestDispatcher("/admin_liuyanhuifu.jsp").forward(request,
				response);

	}

	public void updateliuyan(HttpServletRequest request,
			HttpServletResponse response, String range, int id)
			throws ServletException, IOException {

		String sql = "update T_LIUYAN set T_REPLY= '" + range
				+ "' where T_ID=?";
		int is = new Liuyanimpl().replyLiuyan(sql, id);
		if (is > 0)
			System.out.println("回复成功！");

		response.sendRedirect(request.getContextPath()
				+ "/Liuyan/lookliuyan.do");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int id = Integer.valueOf(req.getParameter("id"));
		String str = req.getParameter("comment");
		System.out.println(id + "  " + str);
		this.updateliuyan(req, resp, str, id);

	}

	public void deleteByNo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		// System.out.println(id);
		if (id != null && id.length() > 0) {
			boolean is = new Liuyanimpl().DeleteByNo(id);
			if (is)
				System.out.println("Liuyan 删除成功");
			this.dliuyan(request, response);
		}
	}
}
