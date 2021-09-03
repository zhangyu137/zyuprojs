package com.lanqiao.team9.dietsystem.entity;

import java.io.Serializable;

/**食物对应热量表*/
public class Food implements Serializable{
	/**食物编号（32位）*/
	private String fno;
	
	/**食物名（20位）*/
	private String fname;
	
	/**对应热量（10位）*/
	private String foodrl;
	
	/**食物图片（255位）*/
	private String fpicture;
	
	public Food() {};
	public Food(String fno, String fname, String foodrl, String fpicture) {
		super();
		this.fno = fno;
		this.fname = fname;
		this.foodrl = foodrl;
		this.fpicture = fpicture;
	}

	public String getFno() {
		return fno;
	}

	public void setFno(String fno) {
		this.fno = fno;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFoodrl() {
		return foodrl;
	}

	public void setFoodrl(String foodrl) {
		this.foodrl = foodrl;
	}

	public String getFpicture() {
		return fpicture;
	}

	public void setFpicture(String fpicture) {
		this.fpicture = fpicture;
	}

	@Override
	public String toString() {
		return "Food [食物编号=" + fno + ", 食物名=" + fname + ", 对应热量=" + foodrl + ", 食物图片=" + fpicture + "]";
	}
	
	

}
