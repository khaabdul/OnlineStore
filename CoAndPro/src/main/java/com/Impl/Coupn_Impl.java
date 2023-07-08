package com.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.Connection.ConnectionUtil;
import com.Dao.Coupon_Dao;
import com.bean.Coupon_Bean;

public class Coupn_Impl implements Coupon_Dao {
	Connection con = ConnectionUtil.connection();

	public void c_Insert(Coupon_Bean cb) {
		try {
			PreparedStatement insert = con
					.prepareStatement("insert into coupon(c_id,c_code,c_descount,c_date) values(?,?,?,?)");
			insert.setInt(1, cb.getC_Id());
			insert.setString(2, cb.getC_Code());
			insert.setString(3, cb.getC_Discount());
			insert.setString(4, cb.getC_Date());
			insert.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void c_Delete(Coupon_Bean cb) {
		try {
			PreparedStatement delete = con.prepareStatement("delete from coupon where c_id=?");
			delete.setInt(1, cb.getC_Id());
			delete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void c_Update(Coupon_Bean cb) {
		try {
			PreparedStatement update = con.prepareStatement("update coupon set c_descount=? where c_id=?");
			update.setString(1, cb.getC_Discount());
			update.setInt(2, cb.getC_Id());
			update.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Coupon_Bean c_Show(Coupon_Bean cb) {
		try {
			PreparedStatement show = con.prepareStatement("select * from coupon where c_id=?");
			show.setInt(1, cb.getC_Id());
			ResultSet query = show.executeQuery();
			if (query.next()) {
				cb.setC_Id(query.getInt(1));
				cb.setC_Code(query.getString(2));
				cb.setC_Discount(query.getString(3));
				cb.setC_Date(query.getString(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cb;
	}
}
