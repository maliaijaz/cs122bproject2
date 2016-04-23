package mvcdemo.controllers;

import java.io.IOException;
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

import mvcdemo.model.User;
import mvcdemo.model.SessionCart;
import mvcdemo.model.Customer;
import mvcdemo.model.Search;

import sun.text.normalizer.ICUBinary.Authenticate;

public class LoginController extends HttpServlet
{
    public String getServletInfo()
    {
       return "Servlet connects to MySQL database and displays result of a SELECT";
    }

    
    // HELPER method
	public static boolean loginAuthenticator(Statement select, String email, String password) throws SQLException {
		
		boolean exists = true;
		
		ResultSet result;
		
		String query = "Select email, password from customers where email = '" + email + "'" + " and password = '" + password + "';" ;
		
		result = select.executeQuery(query);

		if (!result.next()) {
			  System.out.println("This email/password combination is incorrect. Please try again.");
			  exists = false;
			} else {
			  //display results
			  do {
			    String queryEmail = result.getString(1);
			    String queryPassword = result.getString(2);
			    //name.setText(data);
			    System.out.println("RESULT IS: " + queryEmail + queryPassword);
			  } while (result.next());
			}

		return exists;
	}

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException
    {

      String email = request.getParameter("username");
      String password = request.getParameter("password");
      RequestDispatcher rd = null;
     
      // Used to keep track of login info
      HttpSession session;
      
//
//      Authenticator authenticator = new Authenticator();
//      String result = authenticator.authenticate(username, password);
      
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
//	    String emailLogin = "a@email.com";
//	    String passwordLogin = "a2";
	    Customer loggedInCustomer = null; // default value
	    loggedInCustomer= Search.verifyLoginAccount(email, password, connection);
	    System.out.println("Customer: " + loggedInCustomer);
	    if (loggedInCustomer != null){
	    	
	    	session = request.getSession(true);
	    	// to keep track of a customer, we must create a Customer object
			session.setAttribute("loggedInCustomer", loggedInCustomer);
			session.setAttribute("session_cart", new SessionCart());
			request.setAttribute("failure", "");
	    	rd = request.getRequestDispatcher("/success.jsp");
	    	User user = new User(email, password);
	        request.setAttribute("user", user);
	    }
	    else {
          rd = request.getRequestDispatcher("/login.jsp");
          String failure = "Failed to login. Try again!";
          request.setAttribute("failure", failure );
	    }
	    rd.forward(request, response);
//	    connection.close(); // close or no?

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
