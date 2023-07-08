package com.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Connection.ConnectionUtil;
import com.Dao.Product_Dao;
import com.bean.Product_Bean;

public class Product_Impl implements Product_Dao {
	Connection con = ConnectionUtil.connection();

	@Override
	public void p_Insert(Product_Bean pb) {
		try {
			PreparedStatement insert = con
					.prepareStatement("insert into product(p_id,p_name,p_price,p_brand) values (?,?,?,?)");
			insert.setInt(1, pb.getP_id());
			insert.setString(2, pb.getP_Name());
			insert.setString(3, pb.getP_Price());
			insert.setString(4, pb.getP_Brand());
			insert.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void p_Delete(Product_Bean pb) {
		try {
			PreparedStatement delete = con.prepareStatement("delete from product where p_id=?");
			delete.setInt(1, pb.getP_id());
			delete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void p_Update(Product_Bean pb) {
		try {
			PreparedStatement update = con.prepareStatement("update product set p_price=? where p_id=?");
			update.setString(1, pb.getP_Price());
			update.setInt(2, pb.getP_id());
			update.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Product_Bean p_Show(Product_Bean pb) {
		try {
			PreparedStatement show = con.prepareStatement("select * from product where p_id=?");
			show.setInt(1, pb.getP_id());
			ResultSet query = show.executeQuery();
			if (query.next()) {
				pb.setP_id(query.getInt(1));
				pb.setP_Name(query.getString(2));
				pb.setP_Price(query.getString(3));
				pb.setP_Brand(query.getString(4));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pb;
	}

}
