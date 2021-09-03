package com.lanqiao.team9.dietsystem.entity;

import java.io.Serializable;

public class Foodkind implements Serializable{
	/**随机主键（32位）*/
	private String no;
	
	/**谷薯类（64位）*/
	private String gsl;
	
	/**肉类（64位）*/
	private String rl;
	
	/**奶类及制品（64位）*/
	private String nl;
	
	/**豆类及制品（64位）*/
	private String dl;
	
	/**水果蔬菜类（64位）*/
	private String sgscl;
	
	/**能量类（64位）*/
	private String energy;
	
	public Foodkind(){}

	public Foodkind(String no, String gsl, String rl, String nl, String dl, String sgscl, String energy) {
		super();
		this.no = no;
		this.gsl = gsl;
		this.rl = rl;
		this.nl = nl;
		this.dl = dl;
		this.sgscl = sgscl;
		this.energy = energy;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getGsl() {
		return gsl;
	}

	public void setGsl(String gsl) {
		this.gsl = gsl;
	}

	public String getRl() {
		return rl;
	}

	public void setRl(String rl) {
		this.rl = rl;
	}

	public String getNl() {
		return nl;
	}

	public void setNl(String nl) {
		this.nl = nl;
	}

	public String getDl() {
		return dl;
	}

	public void setDl(String dl) {
		this.dl = dl;
	}

	public String getSgscl() {
		return sgscl;
	}

	public void setSgscl(String sgscl) {
		this.sgscl = sgscl;
	}

	public String getEnergy() {
		return energy;
	}

	public void setEnergy(String energy) {
		this.energy = energy;
	}

	@Override
	public String toString() {
		return "Foodkind [no=" + no + ", gsl=" + gsl + ", rl=" + rl + ", nl=" + nl + ", dl=" + dl + ", sgscl=" + sgscl
				+ ", energy=" + energy + ", getNo()=" + getNo() + ", getGsl()=" + getGsl() + ", getRl()=" + getRl()
				+ ", getNl()=" + getNl() + ", getDl()=" + getDl() + ", getSgscl()=" + getSgscl() + ", getEnergy()="
				+ getEnergy() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	};
	
	
}
