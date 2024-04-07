<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN</title>
</head>
<body>

  <%
	String message = (String) request.getAttribute("signup");	
	      if(message!=null){
  %>
	<h1><%=message%></h1>
	<%} %>
	<%
	String email = (String) request.getAttribute("email");	
	      if(email!=null){
  %>
	<h1><%=email%></h1>
	<%} %>
	<%
	String notfound = (String) request.getAttribute("notfound");	
	      if(notfound!=null){
  %>
	<h1><%=notfound%></h1>
	<%} %>
	
	<%
	String pass = (String) request.getAttribute("pass");	
	      if(pass!=null){
  %>
	<h1><%=pass%></h1>
	<%} %>
	
	
<form action="login" method="post">
<!-- Id:<input type="text" name="id"> -->
Email:<input type="text" name="email"><br><br>
Password:<input type="text" name="password">
<a href="menu.jsp"><button>LOGIN</button></a>
</form>


</body>
</html>