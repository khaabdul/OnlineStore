package com.Customer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Connection.ConnectionUtil;
import com.bean.Coupon_Bean;
import com.bean.Customer_Bean;
import com.bean.Product_Bean;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class AddToCart extends HttpServlet {
	Coupon_Bean cb;
	Customer_Bean cub;
	Connection con;
	Random co;
	int random;
	double final_price, Discount;

	@Override
	public void init(ServletConfig config) throws ServletException {
		con = ConnectionUtil.connection();
		cub = new Customer_Bean();
		cb = new Coupon_Bean();
		co = new Random();
		random = co.nextInt(5);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession bill = request.getSession();
			Product_Bean data = (Product_Bean) bill.getAttribute("Bill");
			data.getP_id();
			data.getP_Name();
			data.getP_Brand();
			data.getP_Price();
			System.out.println(random);
			PreparedStatement showcoupon = con.prepareStatement("select * from coupon where c_id=?");
			showcoupon.setInt(1, random);
			ResultSet rs = showcoupon.executeQuery();
			while (rs.next()) {
				cb.setC_Id(rs.getInt(1));
				cb.setC_Code(rs.getString(2));
				cb.setC_Discount(rs.getString(3));
				cb.setC_Date(rs.getString(4));
			}

			PreparedStatement customer = con.prepareStatement("select * from customer where email=?");
			customer.setString(1, (String) bill.getAttribute("email"));
			ResultSet custdetails = customer.executeQuery();
			while (custdetails.next()) {
				cub.setName(custdetails.getString(1));
				cub.setGender(custdetails.getString(3));
				cub.setEmail_id(custdetails.getString(4));
				cub.setNumber(custdetails.getString(5));
				cub.setLocation(custdetails.getString(6));
			}
			Discount = Double.valueOf(data.getP_Price()) * Double.valueOf(cb.getC_Discount()) / 100;
			final_price = Double.valueOf(data.getP_Price()) - Discount;
			String file_Name = "E:\\PdfOfMarkssheet\\" + cub.getName() + ".pdf";
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(file_Name));
			document.open();
			Paragraph par = new Paragraph("Customer Details \n Name :-" + cub.getName() + "\n Number :-"
					+ cub.getNumber() + "\n Email :-" + cub.getEmail_id() + "\n Location :-" + cub.getLocation()
					+ "\n\n Product Details  \n Product Name :-" + data.getP_Name() + "\n Product Price :-"
					+ data.getP_Price() + "\n\n Coupon Code :-" + cb.getC_Code() + "\n Coupon Discount :-"
					+ cb.getC_Discount() + "% \n Dicount Amount :-" + Discount + "\n Total Price :-" + final_price);
			document.add(par);
			document.close();
			request.getRequestDispatcher("Product_Home.jsp").forward(request, response);
		} catch (SQLException | DocumentException e) {
			e.printStackTrace();
		}
	}
}
