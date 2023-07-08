package com.bean;

public class Product_Bean {
	private int p_id;
	private String p_Name;
	private String p_Price;
	private String p_Brand;

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getP_Name() {
		return p_Name;
	}

	public void setP_Name(String p_Name) {
		this.p_Name = p_Name;
	}




	public String getP_Price() {
		return p_Price;
	}

	public void setP_Price(String p_Price) {
		this.p_Price = p_Price;
	}

	public String getP_Brand() {
		return p_Brand;
	}

	public void setP_Brand(String p_Brand) {
		this.p_Brand = p_Brand;
	}

	@Override
	public String toString() {
		return "Product_Bean [p_id=" + p_id + ", p_Name=" + p_Name + ", p_Price=" + p_Price + ", p_Brand=" + p_Brand
				+ "]";
	}

}
