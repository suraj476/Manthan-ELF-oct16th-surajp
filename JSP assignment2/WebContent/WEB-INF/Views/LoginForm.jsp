<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%
	String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		if (msg != null) {
	%>
	<%=msg%>
	<%
		}
	%>
	<form action="./login" method="post">
		Emial Id:<input type="text" name="emial"><br> Password:<input
			type="password" name="password"><br> <input
			type="submit" value="login">
	</form>
</body>
</html>