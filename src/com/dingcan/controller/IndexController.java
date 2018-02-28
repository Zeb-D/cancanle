package com.dingcan.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dingcan.daoimp.FoodDaoimp;
import com.dingcan.domain.Food;
import com.dingcan.utils.PageBean;

public class IndexController {
	static int total=0;
	static double totalprice=0;
	public void index(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		PageBean<Food> page;
		String sql="Select * from T_FOOD";
		page=returnFood(request,sql);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	public PageBean<Food> returnFood(HttpServletRequest request,String sql)
	{
		PageBean<Food> page;
		int currentPage = 1;
		if (request.getParameter("page") != null) {
			
			currentPage = Integer.valueOf(request.getParameter("page"));
			System.out.println(currentPage);
		}
		page = new FoodDaoimp().getPagedata(currentPage,sql);
		return page;
	}
	public void queryList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sql = "select * from T_FOOD";
		request.setAttribute("page", returnFood(request,sql));
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	public void addFood(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		total++;
		Double price = Double.valueOf(request.getParameter("price"));
	    totalprice+=price;
		request.setAttribute("totalprice",totalprice);
		request.setAttribute("total",total);
		
		
		
		this.queryList(request, response);
		}
}
