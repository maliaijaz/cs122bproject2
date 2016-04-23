<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<%@ page import="mvcdemo.model.*"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>

      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="description" content="">
      <meta name="author" content="">

      <title>Fabflix</title>

      <!-- Bootstrap Core CSS - Uses Bootswatch Flatly Theme: http://bootswatch.com/flatly/ -->
      <link href="css/bootstrap.min.css" rel="stylesheet">

      <!-- Custom CSS -->
      <link href="css/freelancer.css" rel="stylesheet">

      <!-- Custom Fonts -->
      <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
      <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
      <link href="http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

      <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
      <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
      <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
      <![endif]-->

  </head>
<body>

  <%
  if ((Customer) request.getSession().getAttribute("loggedInCustomer") == null)
  {
    response.sendRedirect("login.jsp");
  }
%>

  <!-- Navigation -->
  <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
          <!-- Brand and toggle get grouped for better mobile display -->
          <div class="navbar-header page-scroll">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#page-top">Fabflix</a>
          </div>

          <!-- Collect the nav links, forms, and other content for toggling -->
          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
              <ul class="nav navbar-nav navbar-right">

                  <li class="search.jsp">
                      <a href="search.jsp">Search</a>
                  </li>
                  <li class="browse.jsp">
                      <a href="browse.jsp">Browse</a>
                  </li>
                  <li>
                    <a href="##" onClick="history.go(-1); return false;">Previous</a>
                  </li>
              </ul>
          </div>
          <!-- /.navbar-collapse -->
      </div>
      <!-- /.container-fluid -->
  </nav>

  <!-- Header -->
  <header>
      <div class="container">
          <div class="row">
              <div class="col-lg-12">
                  <div class="intro-text">
                      <span class="name">Stars</span>
                      <hr class="star-light">
                      <span class="skills">Here's information about your favorite star.</span>
                  </div>
              </div>
          </div>
      </div>
  </header>

<table border=1>
		<tr>
			<td>
				<img src="${star.photo}" width="150" height="200" alt="No Star Image"/>
			</td>
			<td>
				<h3>Star Name: ${star.first_name} ${star.last_name}</h3>
				<p>Date of Birth: ${star.star_dob}</p>
				<p>Star id: ${star.id}</p>
        <p>Movies:
					<c:forEach items="${star.movies}" var="movie">
						<a href="<%=request.getContextPath()%>/SingleMoviePageController?movieid=${movie.id}">${movie.title},</a>
					</c:forEach>
				</p>
        <p>Add to cart</p>
			</td>
		</tr>
	</table>

</body>
</html>
