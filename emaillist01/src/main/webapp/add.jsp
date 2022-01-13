<%@page import="com.poscoict.emaillist.dao.EmaillistDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.poscoict.emaillist.vo.EmaillistVo" %>
<% 
	request.setCharacterEncoding("utf-8");
	
	String firstName = request.getParameter("fn");   // 무조건 String으로 나옴
	String lastName = request.getParameter("ln");
	String email = request.getParameter("email");
	
	EmaillistVo vo = new EmaillistVo();
	vo.setFirstName(firstName);
	vo.setLastName(lastName);
	vo.setEmail(email);
	
	new EmaillistDao().insert(vo);
	
	response.sendRedirect("/emaillist01");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add.jsp</title>
</head>
<body>
	<h1>잘 들어갔습니다.</h1>
</body>
</html>