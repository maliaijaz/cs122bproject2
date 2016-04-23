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

public class LogoutController extends HttpServlet
{
    public String getServletInfo()
    {
       return "Servlet connects to MySQL database and displays result of a SELECT";
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Session object and the state of the logged in customer
		HttpSession session = request.getSession(false);
		Customer customerLoggedIn = (Customer) session.getAttribute("customer_loggedin");
		
	    RequestDispatcher rd = null;

		String value = request.getParameter("yesOrNo");
		
		if (value == "Yes"){
			session.setAttribute("customer_loggedin", null);
			session.setAttribute("connection", null);
			session.setAttribute("session_cart", null);
			
	        rd = request.getRequestDispatcher("/login.jsp");


		}
		rd.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
