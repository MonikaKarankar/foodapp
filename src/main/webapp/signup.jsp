<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SIGNUP</title>
<style type="text/css">
.signup{
margin-left: 70px;
}
</style>
</head>
<body>
<div class="signup">
<form action="signup" method="post"><br><br>
  Name:<input type="text" name="name"><br><br>
  Phone:<input type="tel" name="phone" ><br><br>
  Address:<input type="text" name="address"><br><br>
  Email:<input type="text" name="email"><br><br>
  Password:<input type="text" name="password"><br><br>
   Role:<input type="radio" name="role" value="MANAGER">MANAGER
  <input type="radio" name="role" value="STAFF">STAFF
  <input type="radio" name="role" value="CUSTOMER">CUSTOMER<br><br>
  <!-- Role:<input type="checkbox" name="manager">MANAGER
  <input type="checkbox" name="staff">STAFF
  <input type="checkbox" name="customer">CUSTOMER -->
 <a href="login.jsp"><button>SIGNUP</button></a>
</form>
</div>
</body>
</html>