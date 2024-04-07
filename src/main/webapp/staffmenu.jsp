<%@page import="food_app_new.dto.Menu"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>staffMenu</title>
</head>
<body>
	<%
        HttpSession httpSession=request.getSession();   
        List<Menu>menus=(List)httpSession.getAttribute("staff");
    %>
	<table border="2px solid black">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Type</th>
			<th>OrderNow</th>
		</tr>
		<%
    for(Menu menu:menus){
  %>
		<tr>
			<td><%=menu.getId() %></td>
			<td><%=menu.getName() %></td>
			<td><%=menu.getPrice() %></td>
			<td><%=menu.getType() %></td>
			<td><a href="additem?id=<%=menu.getId()%>"><button>Add</button></a></td>
		</tr>
		<%} %>
	</table>
</body>
</html>