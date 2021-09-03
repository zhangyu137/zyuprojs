package com.lanqiao.team9.dietsystem.entity;

public class DtFy {
	private String uname;
	private String uno;
	private int start;
	private String end;
	
	
	
	public DtFy() {
		super();
	}
	public DtFy(String uname, String uno, int start, String end) {
		super();
		this.uname = uname;
		this.uno = uno;
		this.start = start;
		this.end = end;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUno() {
		return uno;
	}
	public void setUno(String uno) {
		this.uno = uno;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	@Override
	public String toString() {
		return "DtFy [uname=" + uname + ", uno=" + uno + ", start=" + start + ", end=" + end + "]";
	}
	
	
}
