<%@page import="java.text.SimpleDateFormat"%>
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
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/common_h.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/main.css" />
<script type="text/javascript" src="<%=basePath %>js/libs/modernizr.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/admin_liuyanjiemian.css">
	
	<script src="<%=basePath %>js/jquery.js"></script>
	<script type="text/javascript">
		$(function(){
        $("#reply").click(function(){
          var nickname=${liuyan.username};
          var id=${liuyan.id};
          var content=$("#comment").val();
          alert(${liuyan.username}+content+${liuyan.id});
          //window.location.href="<%=basePath%>Liuyan/updateliuyan.do?id='"+id+"' &comment='"+comment+"'";
        });
        
      });
		
	</script>
	
</head>
<body>
	<%@ include file="admin_top.jspf" %>
	<div class="container clearfix">
		<%--include admin_left --%>
		<%@ include file="admin_left.jspf"%>
		<%--/include admin_left --%>

		<div class="main-wrap">

			<div class="crumb-wrap">
				<div class="crumb-list">
					<i class="icon-font"></i><a href="admin_index.jsp">首页</a><span
						class="crumb-step">&gt;</span><span class="crumb-name">留言管理</span>
				</div>
			</div>


			<form action="<%=basePath%>/Liuyan/updateliuyan" method="post">
				<div class="search-wrap">
					<div class="search-content"
						style="margin-left:20px; font-size:20px;">
						<h1>回复留言</h1>
					</div>
				</div>

				<div style="margin-left:15px;" class="keleyitable">

					<!-- 留言开始 -->
					<div class="tj">
						<table>
							<tr>
							<input type="hidden"  name="id" value="${liuyan.id}"/>
								<td>用户：${liuyan.username}</td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<td>当前时间：<%
									java.util.Date now = new java.util.Date();
									String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
											.format(now);
									out.println(time);
								%></td>
							</tr>
						</table>顾客评论 ：<br>
						<textarea rows="10" cols="100" disabled="true" value="a">${liuyan.comment}</textarea>
						<br>商家回复 ：<br>
						<textarea rows="5" cols="100" name="comment">${liuyan.reply}</textarea>
						<input type="submit" value="回复"/>
					</div>
			</form>
			<!-- 留言结束 -->


		</div>
		<!--/main-->
	</div>
</body>
</html>