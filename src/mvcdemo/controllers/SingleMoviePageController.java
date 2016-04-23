package mvcdemo.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcdemo.model.Movie;
import mvcdemo.model.Search;

/**
 * Servlet implementation class SingleMoviePageController
 */
public class SingleMoviePageController extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public String getServletInfo()
    {
       return "Servlet connects to MySQL database and displays result of a SELECT";
    }

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String movieId, movieTitle, movieYear, movieDirector, movieGenre, starFirstName, starLastName, order;
	      movieId= movieTitle=movieYear=movieDirector=movieGenre=starFirstName=starLastName = order = "";
	      
	      // Do an exact match
	      boolean sub_match = false;
	      
	      // Not pulling in the correct Movie ID which is why its value is NULL
	      // Check the URL in movieList.jsp
		movieId = request.getParameter("movieid");
		
		System.out.println("MovieID: "  + movieId);
		
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
	      
	      try {
	    	  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedb", database, dbPassword);
	  		System.out.println("Connection successful!");
	  	    Statement select = connection.createStatement();
	  	    System.out.println("Select successful!");
	  	    
	  	// Now creating ArrayList to get back all the data from the search
		      Search search = new Search();
	    	  System.out.println("Search is done executing");
	    	  
	    	  RequestDispatcher rd = null;
	    	  
	    	  ArrayList<Movie> listOfMovies = search.searchMovies(movieId, movieTitle,
    	    		  movieYear, movieDirector, movieGenre, starFirstName, starLastName,
    	    		  order, sub_match, connection);
	    	  
	    	  System.out.println("Size of movies is..." + listOfMovies.size());
	    	  
	    	  if (listOfMovies.size() == 1){
	    		  System.out.println("Executing forwarding");
	    		  Movie movie = listOfMovies.get(0); // get the Movie ID
	    		  
	    		  request.setAttribute("movie", movie);
	    		  request.setAttribute("stars", movie.getStars());
	    		  request.setAttribute("genres", movie.getGenres());
	    		  System.out.println("Will now forward to list of movies");
	    		  request.getRequestDispatcher("./singleMovie.jsp").forward(request,  response);
	    	  }
	    	  else{
	    		  System.out.println("Movie NOT found!");
	    	  }

	      } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	      }
	      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
