<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String col = request.getParameter("c");
	String row = request.getParameter("r");
	
	int nCol = Integer.parseInt(col);
	int nRow = Integer.parseInt(row);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>table.jsp</title>
</head>
<body>
	<table border='1px' cellspacing='0' cellpadding='10'>
		<%
			for(int i = 0; i < nRow; i++){
		%>
		<tr>
			<td>cell(0,0)</td>
			<td>cell(0,1)</td>
		</tr>
		<%
			}
		%>
		<tr>
			<td>cell(1,0)</td>
			<td>cell(1,1)</td>
		</tr>

		<tr>
			<td>cell(2,0)</td>
			<td>cell(2,1)</td>
		</tr>
	
	</table>
</body>
</html>