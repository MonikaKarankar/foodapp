<%@page import="food_app_new.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FINAL ORDER</title>
</head>
<body>
  <%
  HttpSession httpSession=request.getSession();
   String msg=(String)httpSession.getAttribute("finalorder");
   User user=(User)httpSession.getAttribute("stafforder");
  %>
  <%=user %>
  <%=msg%>
</body>
</html>