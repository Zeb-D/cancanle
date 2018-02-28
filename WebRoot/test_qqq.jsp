<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
<table>``
		<c:forEach items="${list}" var="emp">
			<tr>
				<td>${emp.rest}</td>
				<td>sssssssss</td>
				
				<a href="DeleteServlet?aid=${emp.foodid}"}">删除</a>
			</tr>

		</c:forEach>
	</table>
</body>
</html>