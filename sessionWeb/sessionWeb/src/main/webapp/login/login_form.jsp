<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<% 
		String errorMessage = (String)request.getAttribute("errorMessage");
		if(errorMessage != null){
	%>
		<span style="color : red"><%= errorMessage %></span>
	<%	} %>
	<form action="/sessionWeb/login" method="post">
		ID : <input type="text" name="id"><br>
		Password : <input type="password" name="password"><br>
		<button type="submit">로그인</button>
	</form>
</body>
</html>