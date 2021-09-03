package com.lanqiao.team9.dietsystem.entity;

import java.io.Serializable;

/**点赞表*/
public class Likes implements Serializable{

	/**点赞编号（32）*/
	private String dzno;
	
	/**用户编号（32）*/
	private String uno;
	
	/**动态编号（32）*/
	private String dtno;

	public Likes() {}
	
	public Likes(String uno, String dtno) {
		super();
		this.uno = uno;
		this.dtno = dtno;
	}

	public Likes(String dzno, String uno, String dtno) {
		super();
		this.dzno = dzno;
		this.uno = uno;
		this.dtno = dtno;
	}
	
	public String getDzno() {
		return dzno;
	}
	public void setDzno(String dzno) {
		this.dzno = dzno;
	}
	public String getUno() {
		return uno;
	}
	public void setUno(String uno) {
		this.uno = uno;
	}
	public String getDtno() {
		return dtno;
	}
	public void setDtno(String dtno) {
		this.dtno = dtno;
	}
	
	@Override
	public String toString() {
		return "Likes [dzno=" + dzno + ", uno=" + uno + ", dtno=" + dtno + "]";
	}
}
