package com.lanqiao.team9.dietsystem.entity;

import java.io.Serializable;

public class Collect implements Serializable{
	private String scno;
	private String uno;
	private String dtno;
	
	public Collect() {
		super();
	}

	public Collect(String scno, String uno, String dtno) {
		super();
		this.scno = scno;
		this.uno = uno;
		this.dtno = dtno;
	}

	public String getScno() {
		return scno;
	}

	public void setScno(String scno) {
		this.scno = scno;
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
		return "Collect [scno=" + scno + ", uno=" + uno + ", dtno=" + dtno + "]";
	}
	
	
}
