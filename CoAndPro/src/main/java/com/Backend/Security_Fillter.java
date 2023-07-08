package com.Backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

import com.Connection.ConnectionUtil;

public class Security_Fillter extends HttpFilter implements Filter {
	Connection con;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			PreparedStatement check = con.prepareStatement("select * from admin where name=? and password=?");
			check.setString(1, name);
			check.setString(2, password);
			ResultSet exe = check.executeQuery();

			PreparedStatement cust_Check = con.prepareStatement("select * from customer where email=? and password=?");
			cust_Check.setString(1, name);
			cust_Check.setString(2, password);
			ResultSet cust_exe = cust_Check.executeQuery();
			if (exe.next()) {
				RequestDispatcher adminHome = request.getRequestDispatcher("Admin.jsp");
				adminHome.forward(request, response);
			} else if (cust_exe.next()) {
				request.setAttribute("name", cust_exe.getString(1));
				chain.doFilter(request, response);
			} else {
				RequestDispatcher adminHome = request.getRequestDispatcher("Register.jsp");
				adminHome.forward(request, response);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
		con = ConnectionUtil.connection();
	}

}
