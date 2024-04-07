<%@page import="food_app_new.dto.User"%>
<%@page import="java.util.List"%>
<%@page import="food_app_new.dto.Menu"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ORDER NOW</title>
</head>
<body>
	<%
	HttpSession httpSession = request.getSession();
	List<Menu> menus = (List) httpSession.getAttribute("items");

	User user = (User) httpSession.getAttribute("user");
	httpSession.setAttribute("stafforder", user);
	%>
	<%=user%>
	<%
	for (Menu menu : menus) {
	%>
	<form action="saveOrder" method="get">
		Id:<input type="hidden" name="id" value="<%=menu.getId()%>"><br>
		<br> Name:<input type="text" name="name" readonly
			value="<%=menu.getName()%>"><br> <br> Price:<input
			type="text" name="price" readonly value="<%=menu.getPrice()%>"><br>
		<br> Type:<input type="text" name="type" readonly
			value="<%=menu.getType()%>"><br> <br>
		<%
		}
		%>
		Quantity:<input type="text" name="qua"><br> <br> <input
			type="submit" value="Save Order">
	</form>

</body>
</html>