package com.lanqiao.team9.dietsystem.service;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.team9.dietsystem.entity.Yh;
import com.lanqiao.team9.dietsystem.mapper.YhMapper;
import com.lanqiao.team9.dietsystem.util.UUIDUtil;
import com.lanqiao.team9.dietsystem.util.DateUtil;

@Service
public class YhService {
	@Autowired
	private YhMapper yhmapper;

	/**添加用户*/
	public boolean add(Yh yh) {
		yh.setUno(UUIDUtil.getUUID());
		yh.setUdate(DateUtil.getNow(DateUtil.DATE_YMDHMS2));
		return yhmapper.add(yh);
	}
	
	/**删除用户*/
	public boolean delete(Serializable uno) {
		return yhmapper.delete(uno);
	}
	
	/**修改用户信息*/
	public boolean update(Yh yh) {
		return yhmapper.update(yh);
	}
	
	/**修改用户头像*/
	public boolean updatePhoto(Yh yh) {
		return yhmapper.updatePhoto(yh);
	}
	
	/**查询一个用户信息（用于登录）*/
	public Yh selectToLogin(Yh yh) {
		yh = yhmapper.selectToLogin(yh);
		if(null != yh) {
			String udate = yh.getUdate();
			udate = DateUtil.dateFmt(udate,DateUtil.DATE_YMDHMS2,DateUtil.DATE_YMD2);
			yh.setUdate(udate);
		}
		return yh;
	}
	
	/**通过编号查询用户信息*/
	public Yh selectByUno(Serializable uno) {
		return yhmapper.selectByUno(uno);
	}
	
	/**查询所有用户信息*/
	public List<Yh> list(Yh yh){
		List<Yh> list = yhmapper.list(yh);
		
		for (Yh yh2 : list) {
			String udate = yh2.getUdate();
			udate = DateUtil.dateFmt(udate,DateUtil.DATE_YMDHMS2,DateUtil.DATE_YMD2);
			yh2.setUdate(udate);
		}
		return list;
	}
	
	/**判断待注册或新增的用户名是否存在*/
	public boolean isExists(String uname) {
		return yhmapper.isExists(uname) != null;
	}
}
