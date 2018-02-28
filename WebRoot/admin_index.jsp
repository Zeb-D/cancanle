<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <h1 class="topbar-logo none"><a href="<%=path %>admin_index.jsp" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="<%=path %>/admin_index.jsp">首页</a></li>
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
            <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span>欢迎使用 餐餐乐后台管理系统</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>快捷操作</h1>
            </div>
            <div class="result-content">
                <div class="short-wrap">
                    <a href="#"><i class="icon-font">&#xe001;</i>新增菜品</a>
                    <a href="#"><i class="icon-font">&#xe005;</i>删除菜品</a>
                    <a href="#"><i class="icon-font">&#xe048;</i>确认订单</a>
                    <a href="#"><i class="icon-font">&#xe041;</i>查阅所有订单</a>
                    <a href="#"><i class="icon-font">&#xe01e;</i>回复留言</a>
                </div>
            </div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>系统基本信息</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                    <li>
                        <label class="res-lab">服务器当前时间</label><span class="res-info">xxx</span>
                    </li>
                    <li>
                        <label class="res-lab">今日订单数</label><span class="res-info">xxx.0</span>
                    </li>
                    <li>
                        <label class="res-lab">今日营业额</label><span class="res-info">xxx</span>
                    </li>
                    <li>
                        <label class="res-lab">新增菜品数量</label><span class="res-info">xxx</span>
                    </li>
                    <li>
                        <label class="res-lab">新增留言</label><span class="res-info">xxx</span>
                    </li>
                    
                </ul>
            </div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>使用帮助</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                    <li>
                        <label class="res-lab">官方交流网站：</label><span class="res-info"><a href="http://www.baidu.com" target="_blank">餐餐乐</a></span>
                    </li>
                    <li>
                        <label class="res-lab">开发人员：</label><span class="res-info">邓,邹,李，段，王，田</span>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <!--/main-->
</div>

</body>
</html>