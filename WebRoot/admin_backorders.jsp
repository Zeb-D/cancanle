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
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/css/common_h.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/css/main.css"/>
    <script type="text/javascript" src="<%=basePath %>/js/libs/modernizr.min.js"></script>
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
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">订单管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content" style="margin-left:20px; font-size:20px;">
   			<h2>未完成订单</h2>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                    <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>显示所有未完成订单</a>
                        <a id="batchDel" href="javascript:void(0)"><i class="icon-font"></i>批量删除</a>
                        <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" type="checkbox"></th>
                          
                            <th>ID</th>
                            <th>菜ID</th>
                            <th>菜e_id</th>
                            <th>用户id</th>
                            <th>送餐地址</th>
                            <th>电话</th>
                            <th>注意事项</th>
                            <th>订餐时间</th>
                            <th>操作</th>
                            
                           
                        </tr>
                        <c:forEach items="${page.list}" var="un">
                        	<tr>
                            <td class="tc"><input name="id[]" value="59" type="checkbox"></td>
                            <td>
                                <input name="ids[]" value="59" type="hidden">
                                <%--<input class="common-input sort-input" name="ord[]" value="0" type="text"> --%>
                          		${un.id }
                            </td>
                            
							<td>${un.foodid}</td>
							<td>${un.foodid2}</td>
							<td>${un.userid}</td>
							<td>${un.address}</td>
							<td>${un.telephone}</td>
							<td>${un.state}</td>
							<td>${un.bookdate}</td>
							
							<c:choose>
								<c:when test="${un.state=='请求订单'}">
									<td>
									 <a class="link-update" href="<%=basePath %>FoodOrder/comfirmOrder.do?id=${queren.id }">确认订单</a>
									 <a class="link-update" href="<%=basePath %>FoodOrder/quxiaoOrder.do?id=${queren.id }">取消订单</a>
									</td>
								</c:when>
								<c:when test="${un.state=='确认订单'}">
									<td>
									 <a>正在派送</a>
									</td>
								</c:when>
								<c:when test="${un.state=='完成订单'}">
									<td>
									 <a>订单完成</a>
									</td>
								</c:when>
								<c:when test="${un.state=='取消订单'}">
									<td>
									 <a>订单取消</a>
									</td>
								</c:when>
							</c:choose>
                            </tr>
                     </c:forEach>
                        
                    </table>
                    <div class="list-page">  ${page.currentPage}/${page.totalPage}页 共${page.total}行
                   
                    <a id="shang" href="uncomfirm.do?page=${page.currentPage-1}">上一页</a>
                    <a id="xia" href="uncomfirm.do?page=${page.currentPage+1}">下一页</a>
                    </div> 
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>