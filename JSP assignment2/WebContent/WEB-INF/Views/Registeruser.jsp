<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String msg=(String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(msg!=null && !msg.isEmpty()){ %>
 <h3><%=msg %></h3>
<%} %>
<form action="./adduser" method="post">
	<table>
		<tr>
			<td>user id</td>
			<td>:</td>
			<td><input type="number" name="Id" required></td>
		</tr>
		<tr>
			<td>user name</td>
			<td>:</td>
			<td><input type="text" name="name" required></td>
		</tr>
		<tr>
			<td>email</td>
			<td>:</td>
			<td><input type="text" name="email" required></td>
		</tr>
		<tr>
			<td>password</td>
			<td>:</td>
			<td><input type="text" name="password" required></td>
		</tr>
	</table>
	<input type="submit" value="add">
</form>
</body>
</html>