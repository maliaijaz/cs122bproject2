<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="mvcdemo.model.Customer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<% // @ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Browse - Genre</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
</head>
<body>

	<%
	if ((Customer) request.getSession().getAttribute("loggedInCustomer") == null)
	{
		response.sendRedirect("login.jsp");
	}
%>
<hr/>

	<h1 class="text-center">Welcome ${requestScope['user'].username}.</h1>
  <p class="text-center">This is the browse by genre page.</p>
  <hr/>

  <form action="GenreController" method="post">
    <input type="radio" name="movieGenre" value="classic" checked> classic<BR>
    <input type="radio" name="movieGenre" value="Horror"> Horror<BR>
    <input type="radio" name="movieGenre" value="Fantasy" checked> Fantasy<BR>
    <input type="radio" name="movieGenre" value="Romance"> Romance<BR>
    <input type="radio" name="movieGenre" value="Sci-Fi" checked> Sci-Fi<BR>
    <input type="radio" name="movieGenre" value="Foreign"> Foreign<BR>
    <input type="radio" name="movieGenre" value="Thriller"> Thriller<BR>
    <input type="radio" name="movieGenre" value="Comedy"> Comedy<BR>
    <input type="radio" name="movieGenre" value="Drama"> Drama<BR>
    <input type="radio" name="movieGenre" value="Adventure"> Adventure<BR>
    <input type="radio" name="movieGenre" value="Action"> Action<BR>
    <input type="radio" name="movieGenre" value="Family"> Family<BR>
    <input type="radio" name="movieGenre" value="Westerns"> Westerns<BR>
    <input type="radio" name="movieGenre" value="War"> War<BR>
    <input type="radio" name="movieGenre" value="Science Fiction"> Science Fiction<BR>
    <input type="radio" name="movieGenre" value="Musicals"> Musicals<BR>
    <input type="radio" name="movieGenre" value="Epics/Historical"> Epics/Historical<BR>
    <input type="radio" name="movieGenre" value="Crime/Gangster"> Crime<BR>
    <input type="radio" name="movieGenre" value="Music"> Music<BR>
    <input type="radio" name="movieGenre" value="Crime"> Crime<BR>
    <input type="radio" name="movieGenre" value="Musical/Performing Arts"> Musical/Performing Arts<BR>
    <input type="radio" name="movieGenre" value="Documentary"> Documentary<BR>
    <input type="radio" name="movieGenre" value="Science Fiction/Fantasy"> Science Fiction/Fantasy<BR>
    <input type="radio" name="movieGenre" value="Western"> Western<BR>
    <input type="radio" name="movieGenre" value="Short"> Short<BR>
    <input type="radio" name="movieGenre" value="Mystery"> Mystery<BR>
    <input type="radio" name="movieGenre" value="Musical"> Musical<BR>
    <input type="radio" name="movieGenre" value="Film-Noir"> Film-Noir<BR>
    <input type="radio" name="movieGenre" value="Animation"> Animation<BR>
    <input type="radio" name="movieGenre" value="SciFi"> SciFi<BR>
        <input type="radio" name="movieGenre" value="Tragedy"> Tragedy<BR>
        <input type="radio" name="movieGenre" value="Epics/Historial"> Epics/Historial<BR>
        <input type="radio" name="movieGenre" value="Roman"> Roman<BR>
        <input type="radio" name="movieGenre" value="James Bond"> James Bond<BR>
        <input type="radio" name="movieGenre" value="spy"> spy<BR>
        <input type="radio" name="movieGenre" value="epics"> epics<BR>
        <input type="radio" name="movieGenre" value="Indie"> Indie<BR>
        <input type="radio" name="movieGenre" value="Suspense"> Suspense<BR>
        <input type="radio" name="movieGenre" value="Love"> Love<BR>
        <input type="radio" name="movieGenre" value="Gangster"> Gangster<BR>
        <input type="radio" name="movieGenre" value="Detective"> Detective<BR>
                <input type="radio" name="movieGenre" value="Coming-of-Age-Drama"> Coming-of-Age-Drama<BR>

                <input type="radio" name="movieGenre" value="Commedy"> Commedy<BR>

                <input type="radio" name="movieGenre" value="SCI/FI"> SCI/FI<BR>

                <input type="radio" name="movieGenre" value="arts"> arts<BR>
                <input type="radio" name="movieGenre" value="arts"> musial<BR>

                <input type="radio" name="movieGenre" value="arts"> kid<BR>

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
