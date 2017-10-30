<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		HashMap<String, Integer> list = (HashMap<String, Integer>) session.getAttribute("itemList");
	%>
	<table border="1">
		<thead>
			<tr>
				<th>제품</th>
				<th>주문개수</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (String item : list.keySet()) {
			%>
			<tr>
				<td><%=item%></td>
				<td style="text-align:center;"><%=list.get(item)%></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<a href="/sessionWeb/cart/showItems">쇼핑계속</a>
</body>
</html>