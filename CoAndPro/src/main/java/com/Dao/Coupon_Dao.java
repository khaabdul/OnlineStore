package com.Dao;

import com.bean.Coupon_Bean;

public interface Coupon_Dao {
	public void c_Insert(Coupon_Bean cb);

	public void c_Delete(Coupon_Bean cb);

	public void c_Update(Coupon_Bean cb);

	public Coupon_Bean c_Show(Coupon_Bean cb);
}
