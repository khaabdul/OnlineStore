package com.Backend;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.Coupon_Dao;
import com.Impl.Coupn_Impl;
import com.bean.Coupon_Bean;

public class Coupon_Controler extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Coupon_Bean coupon_Bean = new Coupon_Bean();
		Coupon_Dao coupn_dao = new Coupn_Impl();
		String btn = request.getParameter("btn");
		coupon_Bean.setC_Id(Integer.valueOf(request.getParameter("id")));
		coupon_Bean.setC_Code(request.getParameter("code"));
		coupon_Bean.setC_Discount(request.getParameter("discount"));
		coupon_Bean.setC_Date(request.getParameter("date"));

		if (btn.equals("add")) {
			coupn_dao.c_Insert(coupon_Bean);
		} else if (btn.equals("update")) {
			coupn_dao.c_Update(coupon_Bean);
		} else if (btn.equals("delete")) {
			coupn_dao.c_Delete(coupon_Bean);
		} else if (btn.equals("show")) {
			System.out.println(coupn_dao.c_Show(coupon_Bean));
		}

		RequestDispatcher rd = request.getRequestDispatcher("Coupon.jsp");
		rd.forward(request, response);
	}

}
