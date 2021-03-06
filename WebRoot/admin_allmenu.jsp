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
    <link rel="stylesheet" type="text/css" href="<%=basePath %>css/common_h.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath %>css/main.css"/>
    <script type="text/javascript" src="<%=basePath %>js/libs/modernizr.min.js"></script>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.html" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="admin_index.jsp">首页</a></li>
                <li><a href="http://www.mycodes.net/" target="_blank">网站首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="#">管理员</a></li>
                <li><a href="#">修改密码</a></li>
                <li><a href="#">退出</a></li>
            </ul>
        </div>
    </div>
</div>
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
   			<h2>所有菜品</h2>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                    <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>显示所有菜品</a>
                        <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" type="checkbox"></th>
                          
                            <th>ID</th>
                            <th>菜名</th>
                            <th>价格</th>
                            <th>卖家id</th>
                            <th>图片</th>
                            <th>剩余量</th>
                            <th>总销量</th>
                            <th>stars</th>
                            <th></th>
                        </tr>
                        <c:forEach items="${page.list}" var="all">
                        	<tr>
                            <td class="tc"><input name="id[]" value="59" type="checkbox"></td>
                            <td>
                                <input name="ids[]" value="59" type="hidden">
                                <%--<input class="common-input sort-input" name="ord[]" value="0" type="text"> --%>
                          		${all.foodid }
                            </td>
                            <td>sssss</td>
							<td>${all.foodname}</td>
							<td>${all.price}</td>
							<td>${all.sellerid}</td>
							<td>${all.picture}</td>
							<td>${all.rest}</td>
							<td>${all.totalsell}</td>
							<td>${all.stars}</td>
							<td>
							<a class="link-update" href="<%=basePath %>Food/updateFood.do?foodid=${all.foodid }">修改</a>
							<a class="link-update" href="<%=basePath %>Food/deleteFood.do?foodid=${all.foodid }">删除</a>
							<a class="link-update" href="<%=basePath %>Food/getFood.do?foodid=${all.foodid }">查看</a>
							</td>
                            </tr>
                     </c:forEach>
                        
                    </table>
                    <div class="list-page">  ${page.currentPage}/${page.totalPage}页 共${page.total}行
                   
                    <a id="shang" href="queryList.do?page=${page.currentPage-1}">上一页</a>
                    <a id="xia" href="queryList.do?page=${page.currentPage+1}">下一页</a>
                    </div> 
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>