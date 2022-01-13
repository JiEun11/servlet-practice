<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.poscoict.guestbook.dao.*, com.poscoict.guestbook.vo.*, 
			java.util.List" %>
<%
	GuestbookDao gdao = new GuestbookDao();
	List<GuestbookVo> list = gdao.findAll();

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/add.jsp" method="post">
	<table border=1 width=500>
		<tr>
			<td>이름</td><td><input type="text" name="name"></td>
			<td>비밀번호</td><td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td colspan=4><textarea name="message" cols=60 rows=5></textarea></td>
		</tr>
		<tr>
			<td colspan=4 align=right><input type="submit" value=" 확인 "></td>
		</tr>
	</table>
	</form>
	<br>
	
	<%
		//int count = list.size();
		//int index = 0;
		//GuestbookVo gbvo = new GuestbookVo();
		// 아래에서 gbvo.getName()으로 쓸 수 있다.
		for(int i=0; i<list.size();i++){
		
	%>
	<table width=510 border=1>
		<tr>
			<td>[<%=i %>]</td>
			<td><%=list.get(i).getName() %></td>
			<td><%=list.get(i).getRegDate() %></td>
			<td><a href="/guestbook01/deleteform.jsp?no=<%=list.get(i) %>">삭제</a></td>
		</tr>
		<tr>
			<td colspan=4><%=list.get(i).getMessage().replace("\n", "<br>") %></td>
		</tr>
	</table>
<%
		}
%>	

</body>
</html>