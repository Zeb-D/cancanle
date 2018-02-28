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
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/common_h.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/main.css"/>
    <script type="text/javascript" src="<%=basePath%>/js/libs/modernizr.min.js"></script>
</head>
<body>
<%@ include file="admin_top.jspf" %>
<div class="container clearfix">
    <%--include admin_left --%>
    <%@ include file="admin_left.jspf" %>
    <%--/include admin_left --%>
    
 
    
    
    
    
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">订单管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="#" method="post">
                    <table class="search-tab">
                        <tr>
                            <th width="120">选择分类:</th>
                            <td>
                                <select name="search-sort" id="">
                                    <option value="">全部</option>
                                    <option value="19">精品界面</option><option value="20">推荐界面</option>
                                </select>
                            </td>
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="#"><i class="icon-font"></i>新增订单</a>
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
                            <th></th>
                           
                        </tr>
                        
                        	<c:forEach items="${page.list}" var="queren">
                        	<tr>
                            <td class="tc"><input name="id[]" value="59" type="checkbox"></td>
                            <td>
                                <input name="ids[]" value="59" type="hidden">
                                <%--<input class="common-input sort-input" name="ord[]" value="0" type="text"> --%>
                            	${queren.id }
                            </td>
                            
							<td>${queren.foodid}</td>
							<td>${queren.foodid2}</td>
							<td>${queren.userid}</td>
							<td>${queren.address}</td>
							<td>${queren.telephone}</td>
							<td>${queren.state}</td>
							<td>${queren.bookdate}</td>

							<td>
                                <a class="link-update" href="<%=basePath %>FoodOrder/comfirmOrder.do?id=${queren.id }">确认订单</a>
                                <a class="link-del" href="<%=basePath %>FoodOrder/quxiaoOrder.do?id=${queren.id }">取消订单</a>
                            </td>
                            </tr>
                     </c:forEach>
                    </table>
                    <div class="list-page">  ${page.currentPage}/${page.totalPage}页 共${page.total}行
                    <script type="text/javascript">
                    	
                    		
                    </script>
                    <a id="shang" href="queryList.do?page=${page.currentPage-1}">上一页</a>
                    <a id="xia" href="queryList.do?page=${page.currentPage+1}">下一页</a>
                    </div> 
               
         
               </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>