<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/menu.jsp" %>
<h1>상품 목록</h1>
<c:if test="${requestScope.errorMessage }">
	<span style="color:red">${requestScope.errorMessage }</span>
</c:if>
<form action="/sessionWeb/cart/addCart" method="post">
    <label><input type="checkbox" name="items" value="TV"> TV</label><br>
    <label><input Type="checkbox" name="items" value="DVD"> DVD</label><br>
    <label><input type="checkbox" name="items" value="모니터"> 모니터</label><br>
    <label><input type="checkbox" name="items" value="노트북"> 노트북</label><br>
    <label><input type="checkbox" name="items" value="마우스"> 마우스</label><br>
    <label><input type="checkbox" name="items" value="RAM"> RAM</label><br>
    <label><input type="checkbox" name="items" value="외장메모리"> 외장메모리</label><br>
    <button type="submit">장바구니담기</button>
</form>
</body>
</html>