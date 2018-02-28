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
    <script type="text/javascript" src="<%=basePath %>js/uploadPreview.js"></script>
    
    <script type="text/javascript" src="<%=basePath %>js/libs/modernizr.min.js"></script>
    <script>
       window.onload = function () { 
            new uploadPreview({ UpBtn: "up_img", DivShow: "imgdiv", ImgShow: "imgShow" });
       }
    </script>
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
   			<h2>增加菜品</h2>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" action="<%=basePath %>Food/UploadFood.do" enctype="multipart/form-data"  method="post">
                <div class="result-title">
                
                <div class="result-content" >
                 <div class="imageload">   
                 
                    <div id="imgdiv"><img id="imgShow" width="100" height="100" /></div>
						<input type="file" id="up_img" name="filename"  />
						<!-- <input type="submit" value="上传" id="uploadFile" /> -->
						
                        
                    </div>
                <table class="addmenu-tab" >
                <tr><td>
                	 菜品名称：<input class="common-text" name="na" type="text" placeholder="名称">  
            	</td></tr>
            	<tr><td>
            	 	菜品价格：<input class="common-text" name="pr" type="text" placeholder="价格">
            	</td></tr>
            	<tr><td>
            		菜品描述：<input class="common-text" name="des" type="text" placeholder="描述">
            	</td></tr>
            	<tr><td>
            		所属商家：<select id="seller" >
            		<c:forEach items="${list}" var="emp">
            		<option value="${emp}" >${emp}</option> 
            		</c:forEach>
            		</select>
            	</td></tr>
            	</table>
            	</div>
            	</div>
            		<div style="margin-left:100px;">
            		<input type="submit" value="确认增加">
					
					</div>
					</form>
    </div>
    </div>
    <!--/main-->
</div>
</body>
</html>