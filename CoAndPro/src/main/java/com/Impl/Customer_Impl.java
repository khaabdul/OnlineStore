package com.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Connection.ConnectionUtil;
import com.Dao.Customer_Dao;
import com.bean.Customer_Bean;

public class Customer_Impl implements Customer_Dao {
	Connection con = ConnectionUtil.connection();

	public void insert(Customer_Bean cb) {
		try {
			PreparedStatement insert = con.prepareStatement(
					"insert into customer(name,password,gender,email,phone,location)values(?,?,?,?,?,?)");
			insert.setString(1, cb.getName());
			insert.setString(2, cb.getPassword());
			insert.setString(3, cb.getGender());
			insert.setString(4, cb.getEmail_id());
			insert.setString(5, cb.getNumber());
			insert.setString(6, cb.getLocation());
			insert.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Customer_Bean cb) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Customer_Bean cb) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show(Customer_Bean cb) {
		// TODO Auto-generated method stub

	}

}
