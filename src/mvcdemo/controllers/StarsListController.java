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
import mvcdemo.model.Star;

/**
 * Servlet implementation class SingleMoviePageController
 */
public class StarsListController extends HttpServlet {
       
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

	     String starId = "";
	      // Do an exact match
	  
	      
	      // Not pulling in the correct Movie ID which is why its value is NULL
	      // Check the URL in movieList.jsp
		starId = request.getParameter("starid");
		
		System.out.println("StarId: "  + starId);
		
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
	    	  
	    	  Star star = Search.searchStar(starId, connection);
	    	  

	    	  System.out.println("Star: " + star);
	    	  
	    	  // set the attributes for the star
	    	  request.setAttribute("star", star);
	    	  request.setAttribute("movies", star.getMovies());

	    	  System.out.println("Will now forward to the stars page");
	    	  request.getRequestDispatcher("./singleStar.jsp").forward(request,  response);
	    	  
	    	

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
