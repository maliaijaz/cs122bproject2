<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="mvcdemo.model.Customer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<% // @ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Browse - Title</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
</head>
<body>
<hr/>

	<%
	if ((Customer) request.getSession().getAttribute("loggedInCustomer") == null)
	{
		response.sendRedirect("login.jsp");
	}
%>

	<h1 class="text-center">Welcome ${requestScope['user'].username}.</h1>
  <p class="text-center">This is the browse by title page.</p>
  <hr/>
  <form action="TitleController" method="post">
  	<input type="radio" name="movieLetterTitle" value="0"> 0<BR>
  	<input type="radio" name="movieLetterTitle" value="1"> 1<BR>
  	<input type="radio" name="movieLetterTitle" value="2"> 2<BR>
    <input type="radio" name="movieLetterTitle" value="3"> 3<BR>
  	<input type="radio" name="movieLetterTitle" value="4"> 4<BR>
  	<input type="radio" name="movieLetterTitle" value="5"> 5<BR>
  	<input type="radio" name="movieLetterTitle" value="6"> 6<BR>
  	<input type="radio" name="movieLetterTitle" value="7"> 7<BR>
  	<input type="radio" name="movieLetterTitle" value="8"> 8<BR>
  	<input type="radio" name="movieLetterTitle" value="9"> 9<BR>
  	<input type="radio" name="movieLetterTitle" value="A"> A<BR>
  	<input type="radio" name="movieLetterTitle" value="B"> B<BR>
  	<input type="radio" name="movieLetterTitle" value="C"> C<BR>
  	<input type="radio" name="movieLetterTitle" value="D"> D<BR>
  	<input type="radio" name="movieLetterTitle" value="E"> E<BR>
  	<input type="radio" name="movieLetterTitle" value="F"> F<BR>
  	<input type="radio" name="movieLetterTitle" value="G"> G<BR>
  	<input type="radio" name="movieLetterTitle" value="H"> H<BR>
  	<input type="radio" name="movieLetterTitle" value="I"> I<BR>
  	<input type="radio" name="movieLetterTitle" value="J"> J<BR>
  	<input type="radio" name="movieLetterTitle" value="K"> K<BR>
  	<input type="radio" name="movieLetterTitle" value="L"> L<BR>
  	<input type="radio" name="movieLetterTitle" value="M"> M<BR>
  	<input type="radio" name="movieLetterTitle" value="N"> N<BR>
  	<input type="radio" name="movieLetterTitle" value="O"> O<BR>
  	<input type="radio" name="movieLetterTitle" value="P"> P<BR>
  	<input type="radio" name="movieLetterTitle" value="Q"> Q<BR>
  	<input type="radio" name="movieLetterTitle" value="R"> R<BR>
  	<input type="radio" name="movieLetterTitle" value="S"> S<BR>
  	<input type="radio" name="movieLetterTitle" value="T"> T<BR>
  	<input type="radio" name="movieLetterTitle" value="U"> U<BR>
  	<input type="radio" name="movieLetterTitle" value="V"> V<BR>
  	<input type="radio" name="movieLetterTitle" value="W"> W<BR>
  	<input type="radio" name="movieLetterTitle" value="X"> X<BR>
  	<input type="radio" name="movieLetterTitle" value="Y"> Y<BR>
  	<input type="radio" name="movieLetterTitle" value="Z"> Z<BR>

    <p>Select a order</p>
    <input type="radio" name="order" value="titleasc" checked> Title Ascending<BR>
    <input type="radio" name="order" value="titledsc"> Title Descending<BR>
    <input type="radio" name="order" value="yearasc"> Year Ascending<BR>
    <input type="radio" name="order" value="yeardsc"> Year Descending<BR>

  <input type="submit" />
  </form>

  <a href="browse.jsp">Return to browse search</a>
  <a href="##" onClick="history.go(-1); return false;">Go back</a>



  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

  <!-- Latest compiled and minified JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

</body>
</html>
