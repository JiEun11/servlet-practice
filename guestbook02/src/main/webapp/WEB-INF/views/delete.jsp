<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.poscoict.guestbook.dao.*, com.poscoict.guestbook.vo.*,
			java.util.List" %>
<%
	request.setCharacterEncoding("utf-8");

	String no = request.getParameter("no");
	String password = request.getParameter("password");
	
	GuestbookVo gbvo = new GuestbookVo();
	gbvo.setNo(Integer.parseInt(no));
	gbvo.setPassword(password);
	
	new GuestbookDao().delete(gbvo.getNo(), gbvo.getPassword());
	
	response.sendRedirect("/guestbook01");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete.jsp</title>
</head>
<body>
	<h1>삭제에 성공하였습니다.</h1>
</body>
</html>