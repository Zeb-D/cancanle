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
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/liuyanguanli.css">

</head>
<body>

	<%@ include file="admin_top.jspf" %>
	<div class="container clearfix">
		<%@ include file="admin_left.jspf"%>

		<div class="main-wrap">

			<div class="crumb-wrap">
				<div class="crumb-list">
					<i class="icon-font"></i><a href="admin_index.jsp">首页</a><span
						class="crumb-step">&gt;</span><span class="crumb-name">留言管理</span>
				</div>
			</div>


			<form action="<%=path%>/#" method="post">
				<div class="search-wrap">
					<div class="search-content"
						style="margin-left:20px; font-size:20px;">
						<h1>查看留言</h1>
					</div>
				</div>

				<div style="margin-left:15px;" class="keleyitable">
					<h2>留言列表</h2>


					<!-- 留言开始 -->
					<table>
						
						<tr style="text-align:center">
							<td class="td_id">ID</td>
							<td class="td_name">留言者</td>
							<td class="food_name">食谱</td>
							<td class="td_stars">星评</td>
							<td class="td_comment">顾客留言</td>
							<td class="td_comment">商家回复</td>
							<td class="td_time">时间</td>
							<td class="td">操作</td>
						</tr>
						<c:forEach items="${page.list}" var="all">
						<tr style="text-align:center">
							<!-- td_conunt -->
							<td class="td_id">${all.id}</td>
							<td class="td_name">${all.username}</td>
							<td class="food_name">${all.foodname }</td>
							<td class="td_stars">${all.stars}</td>
							<td class="td_comment">${all.comment}</td>
							<td class="td_comment">${all.reply}</td>
							<td class="td_time">${all.date}</td>
							
							<td class="td"><input type="button" id="replay" value="回复" 
								 onClick="window.location.href='../Liuyan/replyliuyan.do?id=${all.id}'" />
								 | <input type="button" value="删除"
								onClick="window.location.href='../Liuyan/dliuyan.do'" /></td>
						</tr>
						</c:forEach>
					</table>
					<div class="list-page">  ${page.currentPage}/${page.totalPage}页 共${page.total}行
                   
                   <script type="text/javascript">
                    function goPage(){
                    	
						var page = document.getElementById("Pagenum").value;
						if(page>${page.totalPage})
							page=${page.totalPage};
                    	if(page<1)
                    		page=1;
						window.location.href = "<%=path%>/Liuyan/lookliuyan.do?page="+page;
                    }
                    function go(num){
                    	if(num>${page.totalPage})
                    		num=${page.totalPage};
                    	if(num<1)
                    		num=1;
						window.location.href = "<%=path%>/Liuyan/lookliuyan.do?page="+num;
                    }
					</script>
                    <a id="fir" onclick="go(1)" >首页</a>
                    <a id="sha" onclick="go(${page.currentPage-1})">上一页</a>
                    <a id="xia" onclick="go(${page.currentPage+1})">下一页</a>
                    <a id="las" onclick="go(${page.totalPage})">尾页</a>
                    <input id="Pagenum" size="1" name="gotoPage" value="${page.currentPage }"/>
                    <input type="button" value="跳转" onclick="goPage()" />
              
                </div>

				</div>

			</form>
			<!-- 留言结束 -->


		</div>
		<!--/main-->
	</div>
</body>
</html>