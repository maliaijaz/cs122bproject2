package mvcdemo.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvcdemo.model.Movie;
import mvcdemo.model.Search;
import mvcdemo.model.User;

import sun.text.normalizer.ICUBinary.Authenticate;

public class SearchController extends HttpServlet
{
    public String getServletInfo()
    {
       return "Servlet connects to MySQL database and displays result of a SELECT";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException
    {

      String movieId, movieTitle, movieYear, movieDirector, movieGenre, starFirstName, starLastName, order;
      movieId= movieTitle=movieYear=movieDirector=movieGenre=starFirstName=starLastName = order = "";

      // Ignore this field, check for null values/empty strings
    	// any value that's passed into searchMovies cannot be null, however,
    	// it can be an empty string.
    	
      movieId = request.getParameter("movieId"); 
      movieTitle = request.getParameter("movieTitle");
      movieYear = request.getParameter("movieYear");
      movieDirector = request.getParameter("movieDirector");
      
      // Radio checkbox / ignore for now
      // check if this should be an ArrayList
      //movieGenre = request.getParameter("movieGenre");
      
      starFirstName = request.getParameter("starFirstName");
      starLastName = request.getParameter("starLastName");
      
     
      order = request.getParameter("order");
      
      // Sub Match is TRUE if you want to do the fuzzy search
      // Sub Match is FALSE if you DON'T want to do the fuzzy search
      // Checkbox for fuzzy string; convert to a Boolean
      // radio checkbox
      boolean sub_match = Boolean.parseBoolean(request.getParameter("sub_match")); 


    	// Database login information
      String database = "root";
      String dbPassword = "poop";
      
   // Incorporate mySQL driver
      // Establish connection to JBDC instance
      try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		System.out.println("Success");
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
      // Connection to local database using JDBC 
     
      try {
    	
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedb", database, dbPassword);
		System.out.println("Connection successful!");
	    Statement select = connection.createStatement();
	    System.out.println("Select successful!");
	    
  	  System.out.println("Search executing");

	    // Now creating ArrayList to get back all the data from the search
	      Search search = new Search();
    	  System.out.println("Search is done executing");
    	  
    	  RequestDispatcher rd = null;

    	  if (movieId.equals("") && movieTitle.equals("") && movieYear.equals("") &&
    			  movieGenre.equals("") && starFirstName.equals("") && starLastName.equals("")  
    			  ) {
    		  rd = request.getRequestDispatcher("/search.jsp");
    		  String failure = "You must enter at least one value.";
              request.setAttribute("failure", failure );
    	  }
    	  else{
    		  
           // we are assuming that the fields that have no values are empty strings
    	      ArrayList<Movie> listOfMovies = search.searchMovies(movieId, movieTitle,
    	    		  movieYear, movieDirector, movieGenre, starFirstName, starLastName,
    	    		  order, sub_match, connection); 
    	      
    	      if (order.equals("titleasc")){
    	    	  
    	    	  Collections.sort(listOfMovies, new Comparator<Movie>(){

					@Override
					public int compare(Movie o1, Movie o2) {
						// TODO Auto-generated method stub
						return (o1.getTitle().compareTo(o2.getTitle()));
					}
    	    		  
    	    	  });
    	      }
    	      else if (order.equals("titledsc")){
    	    	  
    	    	  Collections.sort(listOfMovies, new Comparator<Movie>(){

					@Override
					public int compare(Movie o1, Movie o2) {
						// TODO Auto-generated method stub
						return (o1.getTitle().compareTo(o2.getTitle()));
					}
    	    		  
    	    	  });
    	    	  Collections.reverse(listOfMovies);
    	    	  
    	      }
    	      else if (order.equals("yearasc")){
    	    	  
    	    	  Collections.sort(listOfMovies, new Comparator<Movie>(){

					@Override
					public int compare(Movie o1, Movie o2) {
						// TODO Auto-generated method stub
						if (o1.getYear() == o2.getYear()){
							return (o1.getTitle().compareTo(o2.getTitle()));
						};
						return o1.getYear() - o2.getYear();
					}
    	    		  
    	    	  });
    	      }
    	      else if (order.equals("yeardsc")){
    	    	  
    	    	  Collections.sort(listOfMovies, new Comparator<Movie>(){

					@Override
					public int compare(Movie o1, Movie o2) {
						// TODO Auto-generated method stub
						if (o1.getYear() == o2.getYear()){
							return (o1.getTitle().compareTo(o2.getTitle()));
						};
						return o2.getYear() - o1.getYear();
					}
    	    		  
    	    	  });
    	      }
    	      		
        	  System.out.println("Created list of movies");
        	  
        	  for (int i =0; i<listOfMovies.size(); i++){
        		  System.out.println(listOfMovies.get(i).getTitle());
        	  }
        	  System.out.println("Size of the movies: " + listOfMovies.size());

    	      
    	      
    	      if (listOfMovies.isEmpty()){
    	    	  rd = request.getRequestDispatcher("/noMovies.jsp");
    	      }
    	      else { // all movies will be displayed on this page
    	    	  
    	    	  System.out.println("Will now forward to list of movies");
    	    	  request.setAttribute("listOfMovies", listOfMovies);
    	    	  rd = request.getRequestDispatcher("movieList.jsp");

    	    	  }
    		  
    	  }
    	  
	      
	      
	    	  // set attributes of the page dynamically 
	      rd.forward(request, response);
	      
//	    String emailLogin = "a@email.com";
//	    String passwordLogin = "a2";
//	    System.out.println("value: " + value);
//	    if (value == true){
//	    	rd = request.getRequestDispatcher("/success.jsp");
//	    	User user = new User(email, password);
//	        request.setAttribute("user", user);
//	    }
//	    else {
//          rd = request.getRequestDispatcher("/login.jsp");
//          String failure = "Failed to login. Try again!";
//          request.setAttribute("failure", failure );
//	    }
	    

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException
    {
	doGet(request, response);
    }
}

