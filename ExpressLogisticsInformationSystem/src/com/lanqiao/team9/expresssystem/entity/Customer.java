package com.lanqiao.team9.expresssystem.entity;

import java.io.Serializable;

public class Customer implements Serializable {

	/**用户编号(唯一，主键)*/
	private String  customerid;
	/**姓名(不为空)*/
	private String  name;
	/**手机号*/
	private String  phone;
	/**身份证号*/
	private String  idcard;
	/**密码(不为空)*/
	private String  pwd;
	/**注册时间*/
	private String  regtime;
	
	public Customer() {}
	
	public Customer(String customerid, String name, String phone, String idcard, String pwd, String regtime) {
		super();
		this.customerid = customerid;
		this.name = name;
		this.phone = phone;
		this.idcard = idcard;
		this.pwd = pwd;
		this.regtime = regtime;
	}

	/**
	 * @return the customerid
	 */
	public String getCustomerid() {
		return customerid;
	}

	/**
	 * @param customerid the customerid to set
	 */
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the idcard
	 */
	public String getIdcard() {
		return idcard;
	}

	/**
	 * @param idcard the idcard to set
	 */
	public void setIdcard(String idcard) {
		this.idcard = idcard;
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
	
}
