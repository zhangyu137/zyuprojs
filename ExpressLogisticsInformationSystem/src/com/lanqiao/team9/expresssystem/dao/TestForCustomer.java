package com.lanqiao.team9.expresssystem.dao;

import com.lanqiao.team9.expresssystem.entity.Customer;
import com.lanqiao.team9.expresssystem.service.CustomerService;

public class TestForCustomer {
	public static void main(String[] args) {
		CustomerService customerservice=new CustomerService();
//		Customer customer=new Customer("01",null,null,null,"123697",null);
//		System.out.println(customerservice.add(customer));
//		System.out.println(customerservice.delete("8e56c03ef97e437bb011905c91b8a7e1"));
		
		System.out.println(customerservice.ListAll().size());
	}
}
