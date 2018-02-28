<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>餐餐乐后台管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/common_h.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/libs/modernizr.min.js"></script>

<style type="text/css">
table {
	border: #999 1px solid;
	border-collapse: collapse;
}

table td {border: 1px solid #999;text-align: center;}
.one {background: #9FC;}
.two {background: #FC6;}
.xz {border: 1px solid #fff;background-color: #D1E8FF;cursor: pointer;font-family: "微软雅黑";}
.xz:hover {background-color: #91BDE9;color: red;font-family: "微软雅黑";}
</style>
<script type="text/javascript" language="javascript">
		function clickBtn(id) {
			alert("准备删除留言id为"+id);
			window.location.href = "<%=basePath%>Liuyan/deleteByNo.do?id="+id;
			alert("删除 "+id+" 成功");
		}
	function gehang() {
		//获取tr节点
		var tr = document.getElementsByTagName("tr");
		//为第一行添加背景颜色
		tr[0].style.background = "#00FF66";
		//为最后一行添加背景颜色
		tr[tr.length - 1].style.background = "#00FF66";
	}
	//创建全选反选函数
	function xuan(type) {
		//获取name值
		var qcheck = document.getElementsByName("check[]");
		//获取选的按钮
		if (type == "qx") {
			for (var i = 0; i <= qcheck.length; i++) {
				qcheck[i].checked = true;
			}
		}
		if (type == "fx") {
			for (var i = 0; i <= qcheck.length; i++) {
				qcheck[i].checked = false;
			}
		}
		if (type == "qxx") {
			for (var i = 0; i <= qcheck.length; i++) {
				if (qcheck[i].checked) {
					qcheck[i].checked = false;
				} else {
					qcheck[i].checked = true;
				}
			}
		}
	}
	function del() {
		var input = document.getElementsByName("check[]");
		for (var i = input.length - 1; i >= 0; i--) {
			if (input[i].checked == true) {
				//获取td节点
				var td = input[i].parentNode;
				//获取tr节点
				var tr = td.parentNode;
				//获取table
				var table = tr.parentNode;
				//移除子节点
				table.removeChild(tr);
			}
		}
	}
</script>


</head>

<body>

	<%@ include file="admin_top.jspf"%>
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


			<table>
				<div class="search-wrap">
					<div class="search-content"
						style="margin-left:20px; font-size:20px;">
						<h1>删除留言</h1>
					</div>
				</div>
			</table>
			<div style="margin-left:15px;" class="keleyitable">
				<h2>留言列表</h2>
			</div>

			<div class="btn_shanchu">
				<table style="width:98%;">
					<tr>
						<td ><input onclick="xuan('qx')" type="checkbox" >全选</td>
						<td style="width:150px;">姓名</td>
						<td >时间</td>
						<td >留言内容</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${page.list}" var="all">
					<tr class="one">
						<td><input type="checkbox" name="check[]"></td>
						<td style="width:150px;">${all.username}</td>
						<td>${all.date }</td>
						<td>${all.comment}</td>
						<td class="td">
							<a  href="Liuyan/deleteByNo.do?id=${all.id}" onclick="{if(confirm('确认删除?')){return true;}return false;}">删除</a>
						</td>
					</tr>
					</c:forEach>


					<tr>
						<th><input onclick="xuan('qx')" type="checkbox" class="xz">全选</th>
						<td colspan="3" align="center"><input type="button" id="qx"
							onclick="xuan('qx')" value="全选" class="xz">&nbsp;&nbsp;&nbsp; 
							<input type="button" id="qxx" onclick="xuan('qxx')" value="反选"
							class="xz"> &nbsp;&nbsp;&nbsp;
							<input type="button" id="fx" onclick="xuan('fx')" value="取消反选" class="xz">&nbsp;&nbsp;&nbsp; 
							<input type="button" id="del" onclick="del()" value="删除所选附件" class="xz"></td>
					</tr>
				</table>
				<div class="list-page">  ${page.currentPage}/${page.totalPage}页 共${page.total}行
                   
                   <script type="text/javascript">
                    function goPage(){
                    	
						var page = document.getElementById("Pagenum").value;
						if(page>${page.totalPage})
							page=${page.totalPage};
                    	if(page<1)
                    		page=1;
						window.location.href = "<%=path%>/Liuyan/dliuyan.do?page="+page;
                    }
                    function go(num){
                    	if(num>${page.totalPage})
                    		num=${page.totalPage};
                    	if(num<1)
                    		num=1;
						window.location.href = "<%=path%>/Liuyan/dliuyan.do?page="+num;
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
		</div>
</body>
</html>
