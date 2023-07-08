package com.bean;

import java.text.SimpleDateFormat;

public class Coupon_Bean {
	private int c_Id;
	private String c_Code;
	private String c_Discount;
	private String c_Date;

	public int getC_Id() {
		return c_Id;
	}

	public void setC_Id(int c_Id) {
		this.c_Id = c_Id;
	}

	public String getC_Code() {
		return c_Code;
	}

	public void setC_Code(String c_Code) {
		this.c_Code = c_Code;
	}

	public String getC_Discount() {
		return c_Discount;
	}

	public void setC_Discount(String c_Discount) {
		this.c_Discount = c_Discount;
	}

	public String getC_Date() {
		return c_Date;
	}

	public void setC_Date(String c_Date) {
		this.c_Date = c_Date;
	}

	@Override
	public String toString() {
		return "Coupon_Bean [c_Id=" + c_Id + ", c_Code=" + c_Code + ", c_Discount=" + c_Discount + ", c_Date=" + c_Date
				+ "]";
	}

}
