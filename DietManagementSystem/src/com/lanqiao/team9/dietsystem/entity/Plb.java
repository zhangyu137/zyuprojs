package com.lanqiao.team9.dietsystem.entity;

import java.io.Serializable;

/**评论表*/
public class Plb implements Serializable{
	/**评论编号（32）*/
	private String plno;
	
	/**用户昵称（32）*/
	private String uname;
	/**用户昵称（32）*/
	private String photo;
	
	/**动态编号（32）*/
	private String dtno;
	
	/**评论内容（255）*/
	private String contain;
	
	/**评论时间（32）*/
	private String pdate;

	public Plb(){}
	
	
	
	public Plb(String plno, String uname, String photo, String dtno, String contain, String pdate) {
		super();
		this.plno = plno;
		this.uname = uname;
		this.photo = photo;
		this.dtno = dtno;
		this.contain = contain;
		this.pdate = pdate;
	}


	
	public String getPhoto() {
		return photo;
	}



	public void setPhoto(String photo) {
		this.photo = photo;
	}



	public String getPlno() {
		return plno;
	}
	public void setPlno(String plno) {
		this.plno = plno;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getDtno() {
		return dtno;
	}
	public void setDtno(String dtno) {
		this.dtno = dtno;
	}
	public String getContain() {
		return contain;
	}
	public void setContain(String contain) {
		this.contain = contain;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}



	@Override
	public String toString() {
		return "Plb [plno=" + plno + ", uname=" + uname + ", photo=" + photo + ", dtno=" + dtno + ", contain=" + contain
				+ ", pdate=" + pdate + "]";
	}
	
	
}
