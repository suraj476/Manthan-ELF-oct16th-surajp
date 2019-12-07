<%@page import="com.manthan.flipkart.bean.Userinfobeans"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%Userinfobeans userInfoBeans=(Userinfobeans)session.getAttribute("userInfoBeans"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3 style="color:navy;">Hello <%=userInfoBeans.getusername() %>! </h3>
	<a href="./searchproductForm">Search Employee</a><br>
	<a href="./adduserForm">Add Employee</a><br>
	
	
	<a href="./Logout">Logout</a><br>
</body>
</html>