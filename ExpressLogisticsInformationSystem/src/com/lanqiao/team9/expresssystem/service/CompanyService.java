package com.lanqiao.team9.expresssystem.service;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lanqiao.team9.expresssystem.dao.CompanyDao;
import com.lanqiao.team9.expresssystem.entity.Company;
import com.lanqiao.team9.expresssystem.util.DateUtil;

public class CompanyService extends BaseServiceAdapter<Company> implements IBaseService<Company> {

	CompanyDao companydao=new CompanyDao();
	@Override
	public boolean add(Company company) {	//注册添加一个快递公司
		company.setRegtime(DateUtil.getNow(DateUtil.DATE_YMDHMS2));
		if(companydao.Cadd(company)) {
			return true;
		}
		return false;
	}

	
	public boolean delete(String companyname) {	//删除一个快递公司信息
		if(companydao.Cdelete(companyname)) {
			return true;
		}
		return false;
		
	}
	
	
	public boolean update(Company company) {	//修改一个快递公司信息
		if(companydao.Cupdate(company)) {
			return true;
		}
		return false;
	}
	
	/**能否登录*/
	public Company isCompany(String phone,String pwd) {
		Company company = companydao.isCompany(phone, pwd);
		return company;
	}

	public Company ClistMyself(String companyName) {/** 查看自己公司的信息，通过公司名*/
		return companydao.ClistMyself(companyName);
	}
	
	public ArrayList<Company> ClistAll() {/** 查询所有快递公司,供管理员查看*/
		return companydao.ClistAll();
	}
	public ArrayList<Company> ClistForAdmin(String companyName,String phone,String corporation) {/** 模糊查询快递公司,供管理员查看*/
		return companydao.ClistForAdmin(companyName, phone, corporation);
	}
}
