package com.Dao;

import com.bean.Customer_Bean;

public interface Customer_Dao {
	public void insert(Customer_Bean cb);

	public void update(Customer_Bean cb);

	public void delete(Customer_Bean cb);

	public void show(Customer_Bean cb);
}
