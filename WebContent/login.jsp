<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<% // @ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>FabFlix - Login</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="css/loginStylesheet.css">
<script src="js/script.js"></script>
</head>
<body>

<%
	if (request.getSession(false) != null && request.getSession().getAttribute("loggedInCustomer") != null)
	{
		response.sendRedirect("success.jsp");
	}
%>

	<h1 class = "text-center">Fabflix</h1>

	<div class="login-page">
  	<div class="form">

    <form action="LoginController" method="post" class="login-form">
      <input type="text" placeholder="username" name = "username"/>
      <input type="password" placeholder="password" name = "password"/>
      <button>login</button>
			<p class="wrongLogin">${requestScope['failure']}</p>
    </form>
  </div>
</div>
<%--
	<form action="LoginController" method="post">
		Enter username : <input type="text" name="username"> <BR>
		Enter password : <input type="password" name="password"> <BR>
		<input type="submit" />
	</form> --%>

</body>
</html>
