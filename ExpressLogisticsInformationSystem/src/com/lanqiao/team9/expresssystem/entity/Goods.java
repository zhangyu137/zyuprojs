package com.lanqiao.team9.expresssystem.entity;

import java.io.Serializable;

public class Goods implements Serializable {

	/**订单编号(唯一)*/
	private String  goodsid;
	/**委托的快递公司*/
	private String  companyname;
	/**货物信息下拉菜单*/
	private String  cargo;
	/**用户编号*/
	private String  customerid;
	/**寄件人姓名*/
	private String  sendername;
	/**寄件人手机号*/
	private String  senderphone;
	/**寄件人身份证号*/
	private String  senderidcard;
	/**寄件人地址*/
	private String  senderadd;
	/**收件人姓名*/
	private String  receivename;
	/**手机号*/
	private String  receivephone;
	/**身份证号*/
	private String  receiveidcard;
	/**收件人地址*/
	private String  receiveadd;
	/**付款方式:到付（0）现付（1）*/
	private String  pay;
	/**订单金额*/
	private String  money;
	/**运输状态:待接收订单（0），待发货（1），运途中（2），待收货（3），收货成功完成订单（4），撤销截胡（5）*/
	private String  status;
	/**创建时间*/
	private String  creationtime;
	
	public Goods() {}
	
	
	
	public Goods(String goodsid, String companyname, String cargo, String customerid, String sendername,
			String senderphone, String senderidcard, String senderadd, String receivename, String receivephone,
			String receiveidcard, String receiveadd, String pay, String money, String status, String creationtime) {
		super();
		this.goodsid = goodsid;
		this.companyname = companyname;
		this.cargo = cargo;
		this.customerid = customerid;
		this.sendername = sendername;
		this.senderphone = senderphone;
		this.senderidcard = senderidcard;
		this.senderadd = senderadd;
		this.receivename = receivename;
		this.receivephone = receivephone;
		this.receiveidcard = receiveidcard;
		this.receiveadd = receiveadd;
		this.pay = pay;
		this.money = money;
		this.status = status;
		this.creationtime = creationtime;
	}

	

	public Goods(String goodsid, String companyname, String cargo, String customerid, String senderadd,
			String receivename, String receivephone, String receiveidcard, String receiveadd, String pay, String money,
			String status, String creationtime) {
		super();
		this.goodsid = goodsid;
		this.companyname = companyname;
		this.cargo = cargo;
		this.customerid = customerid;
		this.senderadd = senderadd;
		this.receivename = receivename;
		this.receivephone = receivephone;
		this.receiveidcard = receiveidcard;
		this.receiveadd = receiveadd;
		this.pay = pay;
		this.money = money;
		this.status = status;
		this.creationtime = creationtime;
	}



	/**
	 * @return the goodsid
	 */
	public String getGoodsid() {
		return goodsid;
	}

	/**
	 * @param goodsid the goodsid to set
	 */
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
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
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	/**
	 * @return the senderadd
	 */
	public String getSenderadd() {
		return senderadd;
	}

	/**
	 * @param senderadd the senderadd to set
	 */
	public void setSenderadd(String senderadd) {
		this.senderadd = senderadd;
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
	 * @return the receivename
	 */
	public String getReceivename() {
		return receivename;
	}

	/**
	 * @param receivename the receivename to set
	 */
	public void setReceivename(String receivename) {
		this.receivename = receivename;
	}

	/**
	 * @return the receivephone
	 */
	public String getReceivephone() {
		return receivephone;
	}

	/**
	 * @param receivephone the receivephone to set
	 */
	public void setReceivephone(String receivephone) {
		this.receivephone = receivephone;
	}

	/**
	 * @return the receiveidcard
	 */
	public String getReceiveidcard() {
		return receiveidcard;
	}

	/**
	 * @param receiveidcard the receiveidcard to set
	 */
	public void setReceiveidcard(String receiveidcard) {
		this.receiveidcard = receiveidcard;
	}

	/**
	 * @return the receiveadd
	 */
	public String getReceiveadd() {
		return receiveadd;
	}

	/**
	 * @param receiveadd the receiveadd to set
	 */
	public void setReceiveadd(String receiveadd) {
		this.receiveadd = receiveadd;
	}

	/**
	 * @return the pay
	 */
	public String getPay() {
		return pay;
	}

	/**
	 * @param pay the pay to set
	 */
	public void setPay(String pay) {
		this.pay = pay;
	}

	/**
	 * @return the money
	 */
	public String getMoney() {
		return money;
	}

	/**
	 * @param money the money to set
	 */
	public void setMoney(String money) {
		this.money = money;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the creationtime
	 */
	public String getCreationtime() {
		return creationtime;
	}

	/**
	 * @param creationtime the creationtime to set
	 */
	public void setCreationtime(String creationtime) {
		this.creationtime = creationtime;
	}

	@Override
	public String toString() {
		return "Goods [goodsid=" + goodsid + ", companyname=" + companyname + ", cargo=" + cargo + ", senderadd="
				+ senderadd + ", customerid=" + customerid + ", receivename=" + receivename + ", receivephone="
				+ receivephone + ", receiveidcard=" + receiveidcard + ", receiveadd=" + receiveadd + ", pay=" + pay
				+ ", money=" + money + ", status=" + status + ", creationtime=" + creationtime + "]";
	}

	public String getSendername() {
		return sendername;
	}

	public void setSendername(String sendername) {
		this.sendername = sendername;
	}

	public String getSenderphone() {
		return senderphone;
	}

	public void setSenderphone(String senderphone) {
		this.senderphone = senderphone;
	}

	public String getSenderidcard() {
		return senderidcard;
	}

	public void setSenderidcard(String senderidcard) {
		this.senderidcard = senderidcard;
	}
	
}
