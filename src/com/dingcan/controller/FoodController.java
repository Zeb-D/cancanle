package com.dingcan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.dingcan.daoimp.FoodDaoimp;
import com.dingcan.daoimp.SellerImpl;
import com.dingcan.domain.Food;
import com.dingcan.domain.Seller;
import com.dingcan.utils.PageBean;

public class FoodController {
	//Food/queryList.do
	public void queryList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sql = "Select * from T_FOOD";
		request.setAttribute("page", this.returnPage(request, sql));
		request.getRequestDispatcher("/admin_allmenu.jsp").forward(request, response);
	}
	//Food/updateFood.do
	public void updateFood(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String foodid = request.getParameter("foodid");
		request.setAttribute("foodid", foodid);
		//跳转到菜谱修改页面
		request.getRequestDispatcher("#").forward(request, response);
		
	}
	//Food/deleteFood.do
	public void deleteFood(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String foodid = request.getParameter("foodid");
		if(foodid!=null){
			//this.executeSql(sql);
			new FoodDaoimp().DeleteByNo(Integer.valueOf(foodid));
			this.queryList(request, response);
		}
		
	}
	//Food/getFood
	public void getFood(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String foodid = request.getParameter("foodid");
		request.setAttribute("foodid", foodid);
		//跳转到菜谱详情页面
		request.getRequestDispatcher("#").forward(request, response);
		
	}
	
	public void addFood(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<String> list = new SellerImpl().queryAllName();
		request.setAttribute("list", list);
		
		//跳转到增加菜谱页面
		request.getRequestDispatcher("/admin_addmenu.jsp").forward(request, response);
		
	}
	
	private String getFilename(Part part){
		
		String contentDispositionHeader = part.getHeader("content-disposition");
		String[] elements = contentDispositionHeader.split(";");
		for(String element:elements){
			if(element.trim().startsWith("filename"))
				return element.substring(element.indexOf('=')+1).trim().replace("\"", "");
		}
		return null;
	}
	//Food/addFood
	public void UploadFood(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("na");
		int price = Integer.valueOf(request.getParameter("pr"));
		String descript = request.getParameter("des");
		String sellername = request.getParameter("sel");
		System.out.println(sellername);
		
		Seller temp = new SellerImpl().getByName(sellername);
		int SellerID=temp.sellerid;
		
		Part part= request.getPart("filename");
		String fileName= getFilename(part);
		System.out.println(SellerID);
		
		if(fileName!=null && !fileName.isEmpty()){
			String path=request.getServletContext().getRealPath("/images")+"/"+fileName;
			part.write(path);
			System.out.println(path);
		}
		String p="/images/"+fileName;
		Food food =new Food(0, name, SellerID , price, p, 1, 1, 1);
		new FoodDaoimp().AddFood(food);
		
		
		response.setContentType("text/html");
		response.getWriter().println("<br/>Uploaded file name:"+fileName);
		response.getWriter().println("<br/>Size:"+part.getSize());
		response.getWriter().println("上传成功");
		
		//跳转到增加菜谱页面
		//request.getRequestDispatcher("#").forward(request, response);
		
	}
	public PageBean<Food> returnPage(HttpServletRequest request,String sql){
		PageBean<Food> page;
		int currentPage = 1;
		if (request.getParameter("page") != null) {
			
			currentPage = Integer.valueOf(request.getParameter("page"));
		
		}
		page = new FoodDaoimp().getPagedata(currentPage,sql);
		return page;
	}
}
