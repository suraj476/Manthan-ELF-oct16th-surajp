<%@page import="java.util.ArrayList"%>
<%@page import="com.manthan.resume.servlet.Resumebean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%
   List<Resumebean>arraybean=(ArrayList<Resumebean>)request.getAttribute("resumebean");
   %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="./searchresume" enctype="multipart/form-data" align="center">
<input type="text" name="search" required>
<input type= "submit" value="search resume">
</form>
<br>
<% if(arraybean!=null &&  !arraybean.isEmpty()){ %>
<br>
<table align="center" >
<tr>
	<td>Filename</td>
	<td>Name</td>
	<td>Download</td>
</tr>
<% for(Resumebean result: arraybean){ %>
<tr>
	<td><%=result.getfilename() %></td>
	<td><%=result.getemail() %></td>
</tr>
<%} %>
</table>
<%} %>
</body>

</html>