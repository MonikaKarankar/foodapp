<%@page import="food_app_new.dto.User"%>
<%@page import="food_app_new.dto.Menu"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MENUPAGE</title>

</head>
<body>
<form action="addmenu" method="post">
  <%
  List<Menu>menu=(List)request.getAttribute("menuadded");
 
  %>
    <!-- IF THE ROLE IS  MANAGER  THIS TABLE FOR MANAGER TO ADD MENUS --> 
	<table border="2px solid " class="table" style="padding-bottom: 10ox" >
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Type</th>
		</tr>
		<%
		if(menu!=null){
		%>
		<%
		for (Menu val : menu) {
		%>
		<tr>
			<td><%=val.getId()%></td>
			<td><%=val.getName()%></td>
			<td><%=val.getPrice()%></td>
			<td><%=val.getType()%></td>
		</tr>
		
		<%}%>
		<%}%>
		</table>
		<%
		 /* User user=(User)request.getAttribute("user"); */  
		 HttpSession httpSession=request.getSession();
		 User user=(User)httpSession.getAttribute("user");	 
		 if((user.getRole().equalsIgnoreCase("manager"))){
		%>
		<button><a href="addmenu.jsp">ADD</a></button>
		<%}
		 
		%>
		<button><a href="login.jsp">LOGOUT</a></button>
</form>
</body>
</html>