package com.lanqiao.team9.expresssystem.entity;

import java.io.Serializable;

public class Company implements Serializable {

	/**公司名(主键唯一)*/
	private String  companyname;
	/**手机号(唯一)*/
	private String  phone;
	/**法人（）不为空*/
	private String  corporation;
	/**密码(不为空)*/
	private String  pwd;
	/**注册时间*/
	private String  regtime;
	
	public Company() {}
	
	public Company(String companyname, String phone, String corporation, String pwd, String regtime) {
		super();
		this.companyname = companyname;
		this.phone = phone;
		this.corporation = corporation;
		this.pwd = pwd;
		this.regtime = regtime;
	}

	/**
	 * @return the companyname
	 */
	public String getCompanyname() {
		return companyname;
	}

	/**
	 * @param companyname the companyname to set
	 */
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the corporation
	 */
	public String getCorporation() {
		return corporation;
	}

	/**
	 * @param corporation the corporation to set
	 */
	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}

	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * @return the regtime
	 */
	public String getRegtime() {
		return regtime;
	}

	/**
	 * @param regtime the regtime to set
	 */
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	@Override
	public String toString() {
		return "Company [companyname=" + companyname + ", phone=" + phone + ", corporation=" + corporation + ", pwd="
				+ pwd + ", regtime=" + regtime + "]";
	}
	
}
