package com.Dao;

import com.bean.Product_Bean;

public interface Product_Dao {
	public void p_Insert(Product_Bean pb);

	public void p_Delete(Product_Bean pb);

	public void p_Update(Product_Bean pb);

	public Product_Bean p_Show(Product_Bean pb);
}
