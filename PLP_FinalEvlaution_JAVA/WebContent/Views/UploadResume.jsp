<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String message=(String) request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	
<fieldset>
<legend>Upload Resume</legend>
    <form method="post" action="./Uploadresume" enctype="multipart/form-data" align="center">
    	<label>Choose any file</label>
        <input type="file" name="uploadFile" />
        <br/><br/>
       <input type="submit" value="Upload" multiple="multiple" />
   </form>    
</fieldset>
<% if(message!=null && !message.isEmpty()){%>
		<h2><%=message %></h2>
	<% } %>
</body>
</html>