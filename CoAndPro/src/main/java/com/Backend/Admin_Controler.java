package com.Backend;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Admin_Controler
 */
@WebServlet("/Admin_Controler")
public class Admin_Controler extends HttpServlet {
	RequestDispatcher rdAdmin;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String admin = request.getParameter("admin");
		if (admin.equals("prod")) {
			rdAdmin = request.getRequestDispatcher("Product.jsp");
			rdAdmin.forward(request, response);
		} else if (admin.equals("coup")) {
			rdAdmin = request.getRequestDispatcher("Coupon.jsp");
			rdAdmin.forward(request, response);
		}

	}

}
