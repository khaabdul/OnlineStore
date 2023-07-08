package com.Backend;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.Product_Dao;
import com.Impl.Product_Impl;
import com.bean.Product_Bean;

public class Product_Controler extends HttpServlet {
	Product_Dao pro_dao;
	Product_Bean product_Bean;
	String btn;
	RequestDispatcher product;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		pro_dao = new Product_Impl();
		product_Bean = new Product_Bean();
		btn = request.getParameter("btn");
		product_Bean.setP_id(Integer.valueOf(request.getParameter("id")));
		product_Bean.setP_Name(request.getParameter("name"));
		product_Bean.setP_Brand(request.getParameter("brand"));
		product_Bean.setP_Price(request.getParameter("price"));

		if (btn.equals("add")) {
			pro_dao.p_Insert(product_Bean);
		} else if (btn.equals("update")) {
			pro_dao.p_Update(product_Bean);
		} else if (btn.equals("delete")) {
			pro_dao.p_Delete(product_Bean);
		} else if (btn.equals("show")) {
			System.out.println(pro_dao.p_Show(product_Bean));
		}

		RequestDispatcher rd = request.getRequestDispatcher("Product.jsp");
		rd.forward(request, response);
	}

}
