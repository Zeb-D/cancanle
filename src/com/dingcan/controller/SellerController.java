package com.dingcan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dingcan.daoimp.SellerImpl;
import com.dingcan.domain.Seller;
import com.dingcan.utils.PageBean;

public class SellerController {

	public void queryList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PageBean<Seller> page;
		int currentPage = 1;
		String range ="";
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		if (request.getParameter("page") != null) {
			
			currentPage = Integer.valueOf(request.getParameter("page"));
		
		}
		if(request.getParameter("range") != null && !"".equals(request.getParameter("range"))){
			 String str = new String(request.getParameter("range").getBytes("ISO-8859-1"),"utf-8");
			range+=" where T_SELLER_NAME like '%"+str+"%'";
			request.setAttribute("range", str);
			System.out.println(range);
		}
		page = new SellerImpl().getPagedata(currentPage,range);
		
		request.setAttribute("page", page);
		request.getRequestDispatcher("/admin_allseller.jsp").forward(request, response);
	}
	
	public void queryByRange(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PageBean<Seller> page;
		int currentPage = 1;
		if (request.getParameter("page") != null) {
			
			currentPage = Integer.valueOf(request.getParameter("page"));
		
		}
		page = new SellerImpl().getPagedata(currentPage,"");
		
		request.setAttribute("page", page);
		request.getRequestDispatcher("/admin_allseller.jsp").forward(request, response);
	}
}
