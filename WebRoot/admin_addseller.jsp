<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/common_h.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <script type="text/javascript" src="js/libs/modernizr.min.js"></script>
</head>
<body>

<%@ include file="admin_top.jspf" %>
<div class="container clearfix">
    <%--include admin_left --%>
    <%@ include file="admin_left.jspf" %>
    <%--/include admin_left --%>
    
 
    
    
    
    
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">菜品管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content" style="margin-left:20px; font-size:20px;">
   			<h2>增加商家</h2>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        
                        
                    </div>
                </div>
                <div class="search-tab" ">
                	 商家名称：<input class="common-text" type="text" placeholder="商家名称"/></br>  
            	 	起送价：<input class="common-text" type="text" placeholder="起送价"/></br>
            		配送费：<input class="common-text" type="text" placeholder="配送费"/></br>
            		电话：<input class="common-text" type="text" placeholder="电话"/></br>
            	<div style="margin-left:100px;">
            	<input type="submit" value="增加">
            	<input type="submit" value="取消">
				</div>
					</div>
    </div>
    <!--/main-->
</div>
</body>
</html>