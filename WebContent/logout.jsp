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


    <h1>Signing out?</h1>
    <form action="LogoutController" method="post">
      <<input type="radio" name="yesOrNo" value="Yes" checked> Yes<BR>
  		<input type="radio" name="yesOrNo" value="No"> No<BR>

      <button>Logout</button>
    </form>

    <a href="##" onClick="history.go(-1); return false;">Go back</a>

</body>
</html>
