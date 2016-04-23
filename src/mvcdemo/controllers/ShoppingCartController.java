//package mvcdemo.controllers;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import mvcdemo.model.Movie;
//import mvcdemo.model.Search;
//import mvcdemo.model.SessionCart;
//
///**
// * Servlet implementation class ShoppingCartController
// */
//public class ShoppingCartController extends HttpServlet {
//    
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//	public String getServletInfo()
//    {
//       return "Servlet connects to MySQL database and displays result of a SELECT";
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		// Database login information
//	      String database = "root";
//	      String dbPassword = "poop";
//	      
//	      String movieId, movieTitle, movieYear, movieDirector, movieGenre, starFirstName, starLastName, order;
//	      movieId= movieTitle=movieYear=movieDirector=movieGenre=starFirstName=starLastName = order = "";
//	      
//	      // Movie ID
//	      movieId = request.getParameter("movieid");
//	      
//	      boolean sub_match = false;
//	      
//	      // Create session object, get the attribute
//	      HttpSession session = request.getSession(false);
//	      SessionCart myCart = (SessionCart) session.getAttribute("session_cart");
//	      RequestDispatcher rd = null;
//    
//	   // Incorporate mySQL driver
//	      // Establish connection to JBDC instance
//	      try {
//			Class.forName("com.mysql.jdbc.Driver").newInstance();
//			System.out.println("Success");
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace(); 
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace(); 
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	      
//	      try {
//	    	  Connection connection = DriverManager.getConnection("jdbc:mysql:///moviedb", database, dbPassword);
//		  	  System.out.println("Connection successful!");
//		  	  Statement select = connection.createStatement();
//		  	  System.out.println("Select successful!");
//		  	  
//		  	  // Used to check which method to execute
//		  	  String actionType = request.getParameter("action");
//		  	  
//		  	  int quantityOfMovies = 1;
//		  	  
//		  	  // Check if user entered a quantity in the shopping cart jsp page
//		  	  if (request.getParameter("quantity") != null){
//		  		quantityOfMovies = Integer.parseInt(request.getParameter("quantity"));
//		  	  }
//		  	  
//		  	  System.out.println("Initial quantity of movies: " + quantityOfMovies);
//		  	// we are assuming that the fields that have no values are empty strings
//    	      ArrayList<Movie> listOfMovies = Search.searchMovies(movieId, movieTitle,
//    	    		  movieYear, movieDirector, movieGenre, starFirstName, starLastName,
//    	    		  order, sub_match, connection); 
//    	      
//    	      Movie movieToAdd = listOfMovies.get(0);
//    	      
//    	      System.out.println("Cart Items initially: " + myCart.getCartItems_Hash()); 
//    	      System.out.print("MOVIE from arraylist: " + movieToAdd);
//    	      
//    	      if  (actionType.equals("addmovie")){
//    	    	  System.out.println("Now adding: " + movieToAdd.getTitle() + "\n");
//    	    	  myCart.addMovieToCart(movieToAdd, quantityOfMovies);
//        	      System.out.println("Cart Items after adding the first: " + myCart.getCartItems_Hash()); 
//
//    	      }
//    	      // used for updating quantity of a movie
//    	      else if (actionType.equals("update")){
//    	    	  System.out.println("Update: Current quantity: " + quantityOfMovies + "\n");
//    	    	  myCart.updateQuantity(movieToAdd, quantityOfMovies);
//    	    	  request.setAttribute("quantity", quantityOfMovies);
//    	    	  System.out.println("Update: NEW quantity: " + quantityOfMovies + "\n");
//    	    	  System.out.println("Movie that is updated: " + movieToAdd.getTitle());
//
//    	      }
//    	      // used for removing a movie
//    	      else if (actionType.equals("removeOneItem")){
//    	    	  System.out.println("Removed: Old quantity: " + quantityOfMovies + "\n");
//    	    	  myCart.removeFromCart(movieToAdd);
//    	    	  System.out.println("Removed: New quantity: " + quantityOfMovies + "\n");
//
//    	    	  
//    	      }
//    	      // used for clearing the ENTIRE cart
//    	      else if (actionType.equals("removeAllItems")){
//    	    	  myCart.removeAll();
//    	    	  
//    	      }
//    	      
//    	      session.setAttribute("session_cart", myCart);
//    	      System.out.println("Will now forward to the SHOPPING CART page");
//	    	  request.getRequestDispatcher("./shoppingCart.jsp").forward(request,  response);
//		  	  
//
//	      } catch (SQLException e) {
//	  		// TODO Auto-generated catch block
//	  		e.printStackTrace();
//	  	  }
//	      
//	      
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
