package com.lanqiao.team9.expresssystem.entity;

import java.io.Serializable;

public class Admin implements Serializable {

	/**账号*/
	private String  name;
	/**密码*/
	private String  pwd;
	
	public Admin() {}
	
	public Admin(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
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

	@Override
	public String toString() {
		return "Admin [name=" + name + ", pwd=" + pwd + ", getName()=" + getName() + ", getPwd()=" + getPwd()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
