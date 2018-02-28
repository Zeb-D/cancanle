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
<script type="text/javascript">
	function clickBtn(id) {
		alert("准备删除用户id为"+id);
		window.location.href = "<%=basePath%>UserInfo/DeleteByNo.do?id="+id;
		alert("删除 "+id+" 成功");
	}
</script>
<body>

<%@ include file="admin_top.jspf" %>
<div class="container clearfix">
    <%--include admin_left --%>
    <%@ include file="admin_left.jspf" %>
    <%--/include admin_left --%>
    
 
    
    
    
    
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">会员管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content" style="margin-left:20px; font-size:20px;">
   			<h2>所有会员</h2>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a id="updateUser" href="javascript:void(0)"><i class="icon-font"></i>显示所有会员</a>
                        <a id="updateUser" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" type="checkbox"></th>
                          
                            <th>id</th>
                            <th>手机号</th>
                            <th>密码</th>
                            <th>地址</th>
                            <th>备用地址</th>
                            <th>现金</th>
                            <th></th>    
                        </tr>
                            <c:forEach items="${page.list}" var="user">
                        	<tr>
                            <td class="tc"><input name="id[]" value="59" type="checkbox"></td>
                           
                            
							<td>${user.userid}</td>
							<td>${user.username}</td>
							<td>${user.userpass}</td>
							<td>${user.address}</td>
							<td>${user.address2}</td>
							<td>${user.money}</td>
							<td></td>
							
                            <td>
                                <a class="link-update" href="<%=mybasePath %>UserInfo/queryList2.do">修改 </a>
                                <a  href="UserInfo/DeleteByNo.do?id=${user.userid}" onclick="{if(confirm('确认删除?')){return true;}return false;}">删除</a>
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
						window.location.href = "<%=path%>/UserInfo/queryList.do?page="+page;
                    }
                    function go(num){
                    	if(num>${page.totalPage})
                    		num=${page.totalPage};
                    	if(num<1)
                    		num=1;
						window.location.href = "<%=path%>/UserInfo/queryList.do?page="+num;
                    }
					</script>
                    <a id="fir" onclick="go(1)" >首页</a>
                    <a id="sha" onclick="go(${page.currentPage-1})">上一页</a>
                    <a id="xia" onclick="go(${page.currentPage+1})">下一页</a>
                    <a id="las" onclick="go(${page.totalPage})">尾页</a>
                    <input id="Pagenum" size="1" name="gotoPage" value="${page.currentPage }"/>
                    <input type="button" value="跳转" onclick="goPage()" />
              
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>