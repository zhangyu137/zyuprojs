package com.lanqiao.team9.expresssystem.service;

import java.util.ArrayList;

import com.lanqiao.team9.expresssystem.dao.CompanyDao;
import com.lanqiao.team9.expresssystem.dao.CustomerDao;
import com.lanqiao.team9.expresssystem.entity.Company;
import com.lanqiao.team9.expresssystem.entity.Customer;
import com.lanqiao.team9.expresssystem.util.DateUtil;
import com.lanqiao.team9.expresssystem.util.UUIDUtil;

public class CustomerService {

	static CustomerDao customerdao=new CustomerDao();
	
	public boolean add(Customer customer) {	//注册添加一个顾客
		customer.setCustomerid(UUIDUtil.getUUID());
		customer.setRegtime(DateUtil.getNow(DateUtil.DATE_YMDHMS2));
		if(customerdao.CustAdd(customer)) {
			return true;
		}
		return false;
	}

	
	public boolean delete(String customerid) {	//删除一个顾客
		if(customerdao.CustDelete(customerid)) {
			return true;
		}
		return false;
		
	}
	
	
	public boolean CustUpdate(Customer customer) {	//修改一个顾客信息
		if(customerdao.CustUpdate(customer)) {
			return true;
		}
		return false;
	}

	public Customer ListMyself(String customerid) {/** 查看顾客自己的信息，通过用户id名*/
		return customerdao.ListMyself(customerid);
	}
	
	public ArrayList<Customer> ListAll() {/** 查询所有顾客信息,供管理员查看*/
		return customerdao.ListAll();
	}


	public Customer isCustomer(String phone, String pwd) {
		Customer customer = customerdao.isCustomer(phone, pwd);
		return customer;
	}
	public ArrayList<Customer> ListForAdmin(String customerid,String name,String phone) {/**模糊查询用户信息，供管理员查看*/
		return customerdao.ListForAdmin(customerid, name, phone);
	}





}
