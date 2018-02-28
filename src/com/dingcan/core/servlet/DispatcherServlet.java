package com.dingcan.core.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8"); 
		// /className/method.do
		String uri = request.getRequestURI().substring(
				request.getContextPath().length());
		if (uri.length() > 0) {
			uri = uri.substring(1);
		}
		String className = null;
		String methodName = null;
		try {
			// 获得http请求的方法名
			methodName = uri.substring(uri.lastIndexOf('/') + 1,
					uri.lastIndexOf(".do"));
			// 获得http请求的类名
			className = uri.substring(0, uri.indexOf('/'));
		} catch (IndexOutOfBoundsException e) {
			System.out.println("路径有误" + uri);
		}
		// 如果请求的方法null，则默认调用Action对象中的index方法
		if (className == null || className.isEmpty()) {
			className = "Index";
		}
		if (methodName == null || methodName.isEmpty()) {
			methodName = "index";
		}
		Method method = null;
		Object obj = null;
		try {
			// 通过反射获得要执行的方法对象
			Class cClass = Class.forName("com.dingcan.controller." + className
					+ "Controller");
			obj = cClass.newInstance();
			System.out.println(obj.toString());
			method = obj.getClass().getMethod(methodName,
					HttpServletRequest.class, HttpServletResponse.class);
		} catch (Exception e) {
			throw new RuntimeException("在" + className + "上找不到与" + methodName
					+ "相对应的方法！！！");
		}
		try {
			// 执行Controller对象中的方法
			method.invoke(obj, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}