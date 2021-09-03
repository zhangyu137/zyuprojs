package com.lanqiao.team9.dietsystem.entity;

import java.io.Serializable;

/**日志食物表*/
public class Dairy implements Serializable{
	/**日志编号（32位）*/
	private String dno;
	
	/**用户编号（32位）*/
	private String uno;
	
	/**早摄取热量（10位）*/
	private String zaorl;
	
	/**中摄取热量（10位）*/
	private String zhongrl;
	
	/**晚摄取热量（10位）*/
	private String wanrl;
	
	/**总摄取热量（10位）*/
	private String zongrl;
	
	/**运动总消耗量（10位）*/
	private String xhl;
	
	/**日期（20位）*/
	private String ddate;

	public Dairy() {}
	public Dairy(String dno, String uno, String zaorl, String zhongrl, String wanrl, String zongrl, String xhl,
			String ddate) {
		super();
		this.dno = dno;
		this.uno = uno;
		this.zaorl = zaorl;
		this.zhongrl = zhongrl;
		this.wanrl = wanrl;
		this.zongrl = zongrl;
		this.xhl = xhl;
		this.ddate = ddate;
	}
	
	public String getDno() {
		return dno;
	}
	public void setDno(String dno) {
		this.dno = dno;
	}
	public String getUno() {
		return uno;
	}
	public void setUno(String uno) {
		this.uno = uno;
	}
	public String getZaorl() {
		return zaorl;
	}
	public void setZaorl(String zaorl) {
		this.zaorl = zaorl;
	}
	public String getZhongrl() {
		return zhongrl;
	}
	public void setZhongrl(String zhongrl) {
		this.zhongrl = zhongrl;
	}
	public String getWanrl() {
		return wanrl;
	}
	public void setWanrl(String wanrl) {
		this.wanrl = wanrl;
	}
	public String getZongrl() {
		return zongrl;
	}
	public void setZongrl(String zongrl) {
		this.zongrl = zongrl;
	}
	public String getXhl() {
		return xhl;
	}
	public void setXhl(String xhl) {
		this.xhl = xhl;
	}
	public String getDdate() {
		return ddate;
	}
	public void setDdate(String ddate) {
		this.ddate = ddate;
	}
	
	@Override
	public String toString() {
		return "Dairy [dno=" + dno + ", uno=" + uno + ", zaorl=" + zaorl + ", zhongrl=" + zhongrl + ", wanrl=" + wanrl
				+ ", zongrl=" + zongrl + ", xhl=" + xhl + ", ddate=" + ddate + "]";
	}
}
