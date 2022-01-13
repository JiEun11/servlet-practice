<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.poscoict.guestbook.dao.*, com.poscoict.guestbook.vo.*,
			java.util.List" %>
<%
	request.setCharacterEncoding("utf-8");
	
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String message = request.getParameter("message");
	
	GuestbookVo gbvo = new GuestbookVo();
	gbvo.setName(name);
	gbvo.setPassword(password);
	gbvo.setMessage(message);
	
	new GuestbookDao().insert(gbvo);
	
	response.sendRedirect("/guestbook01");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add.jsp</title>
</head>
<body>
	<h1>입력에 성공하였습니다.</h1>
</body>
</html>