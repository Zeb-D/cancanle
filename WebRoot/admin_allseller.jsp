<%@page import="javax.swing.text.Document"%>
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
    <script type="text/javascript" src="js/libs/modernizr.min.js"></script>
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
            <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">所有商家</span></div>
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
                            <th width="70">商家名称:</th>
                            <script>
                            	function search(){
                            		
                            		var ran = document.getElementById("ran").value;
                            		window.location.href = "<%=path%>/Seller/queryList.do?range="+ran;
                            		
                            	}
                            </script>
                            <td><input id="ran" class="common-text" placeholder="关键字" name="keywords" value="${range }" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="button" onclick="search()"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="#"><i class="icon-font"></i>新增商家</a>
                        <a id="batchDel" href="javascript:void(0)"><i class="icon-font"></i>批量删除</a>
                        <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" type="checkbox"></th>
                          	
                          	<th>图片</th>
                            <th>ID</th>
                            <th>商家名称</th>
                            <th>起送价</th>
                            <th>配送价</th>
                            <th>电话</th>
                            <th>总销售</th>
                           
                        </tr>
                        <c:forEach items="${page.list}" var="emp">
                        <tr>
                            <td class="tc"><input name="id[]" value="59" type="checkbox"></td>
                            <td><img  alt="" src="${emp.pictureaddr}"></td>
                            <td>${emp.sellerid}</td>
                            <td>${emp.sellername}</td>
                            <td>${emp.priceqisong}</td>
                            <td>${emp.pricepeisong}</td>
                            <td>${emp.telephone}</td>
                            <td>${emp.totalsell}</td>
                            <td>
                                <a class="link-update" href="#">确认</a>
                                <a class="link-del" href="#">取消</a>
                            </td>
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
						var ran = document.getElementById("ran").value;
						window.location.href = "<%=path%>/Seller/queryList.do?page="+page+"&range="+ran;
                    }
                    function go(num){
                    	if(num>${page.totalPage})
                    		num=${page.totalPage};
                    	if(num<1)
                    		num=1;
                    	var ran = document.getElementById("ran").value;
						window.location.href = "<%=path%>/Seller/queryList.do?page="+num+"&range="+ran;
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
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>