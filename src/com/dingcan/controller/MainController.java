package com.dingcan.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController {

	public void index(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.getWriter().println("main");
	}
	
	public void my(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.getWriter().println("my");
	}
}
