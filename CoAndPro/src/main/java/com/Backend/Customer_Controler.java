package com.Backend;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.Customer_Dao;
import com.Impl.Customer_Impl;
import com.bean.Customer_Bean;

public class Customer_Controler extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Customer_Bean customer_Bean = new Customer_Bean();
		Customer_Dao customer_dao = new Customer_Impl();
		customer_Bean.setName(request.getParameter("name"));
		customer_Bean.setPassword(request.getParameter("password"));
		customer_Bean.setGender(request.getParameter("gender"));
		customer_Bean.setEmail_id(request.getParameter("email"));
		customer_Bean.setNumber(request.getParameter("phone"));
		customer_Bean.setLocation(request.getParameter("location"));

		customer_dao.insert(customer_Bean);
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);

	}

}
