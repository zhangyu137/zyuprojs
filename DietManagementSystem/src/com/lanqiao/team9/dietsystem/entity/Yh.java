package com.lanqiao.team9.dietsystem.entity;

import java.io.Serializable;

/**用户表*/
public class Yh implements Serializable{
	/**用户编号（32位）*/
	private String uno;

	/**用户昵称（64位）*/
	private String uname;
	
	/**用户头像（255位）*/
	private String photo;
	
	/**手机号（11位）*/
	private String phone;
	
	/**密码（10位）*/
	private String pwd;
	
	/**体重（10位）*/
	private String weight;
	
	/**身高（10位）*/
	private String height;
	
	/**性别（5位）*/
	private String sex;
	
	/**生日（32位）*/
	private String birth;
	
	/**计划（255位）*/
	private String plan;
	
	/**减肥斤数（10位）*/
	private String jfnum;
	
	/**减肥天数(10位)*/
	private String jfday;
	
	/**注册时间（20位）*/
	private String udate;
	
	public Yh() {}
	
	public Yh(String uno, String uname, String photo, String phone, String pwd, String weight, String height,
			String sex, String birth, String plan, String jfnum, String jfday, String udate) {
		super();
		this.uno = uno;
		this.uname = uname;
		this.photo = photo;
		this.phone = phone;
		this.pwd = pwd;
		this.weight = weight;
		this.height = height;
		this.sex = sex;
		this.birth = birth;
		this.plan = plan;
		this.jfnum = jfnum;
		this.jfday = jfday;
		this.udate = udate;
	}

	public String getUno() {
		return uno;
	}

	public void setUno(String uno) {
		this.uno = uno;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getJfnum() {
		return jfnum;
	}

	public void setJfnum(String jfnum) {
		this.jfnum = jfnum;
	}

	public String getJfday() {
		return jfday;
	}

	public void setJfday(String jfday) {
		this.jfday = jfday;
	}

	public String getUdate() {
		return udate;
	}

	public void setUdate(String udate) {
		this.udate = udate;
	}
	
	@Override
	public String toString() {
		return "User [uno=" + uno + ", uname=" + uname + ", photo=" + photo + ", phone=" + phone + ", pwd=" + pwd
				+ ", weight=" + weight + ", height=" + height + ", sex=" + sex + ", birth=" + birth + ", plan=" + plan
				+ ", jfnum=" + jfnum + ", jfday=" + jfday + ", udate=" + udate + "]";
	}
}
