package com.dingcan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dingcan.daoimp.UserInfoimpl;
import com.dingcan.domain.UserInfo;

public class RegisterController extends HttpServlet {

	// 注册
	/**
	 * Constructor of the object.
	 */
	public RegisterController() {
		super();
	}

	public void UserRigister(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserInfo user;
		String username = request.getParameter("user");
		String password = request.getParameter("password");
		String repass = request.getParameter("repass");
		String address = request.getParameter("address");
		String e_address = request.getParameter("e_address");
		if(username!=null)
		user = new UserInfoimpl().getByUsername(username);
		else user=null;
		if (user != null) {
			System.out.println("不允许注册");
			request.getRequestDispatcher("/reg.jsp").forward(request, response);
		} else {
			System.out.println("进入用户注册");
			user = new UserInfo(0, username, password, address, e_address, 0);
			new UserInfoimpl().Rigister(user);
			request.getServletContext().setAttribute("username", username);
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
		}

	}

}
