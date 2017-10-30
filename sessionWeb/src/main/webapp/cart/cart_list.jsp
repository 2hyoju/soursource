<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/menu.jsp"%>
<table border="1">
	<thead>
		<tr>
			<th>제품</th>
			<th>주문개수</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${sessionScope.itemList }" var="entry">
		<tr>
			<td>${entry.key }</td>
			<td style="text-align:center;">${entry.value }</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
	<a href="/sessionWeb/cart/showItems">쇼핑계속</a>
</body>
</html>