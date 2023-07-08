package com.Customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Product_Details extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession user = request.getSession();
		user.setAttribute("email", request.getParameter("username"));
		user.setAttribute("name", request.getAttribute("name"));
		RequestDispatcher rd = request.getRequestDispatcher("Product_Home.jsp");
		rd.forward(request, response);
	}

}
