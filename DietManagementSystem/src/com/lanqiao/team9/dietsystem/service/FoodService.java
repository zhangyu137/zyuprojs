package com.lanqiao.team9.dietsystem.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.team9.dietsystem.entity.Food;
import com.lanqiao.team9.dietsystem.mapper.FoodMapper;
import com.lanqiao.team9.dietsystem.util.UUIDUtil;

@Service
public class FoodService {
	
	@Autowired
	private FoodMapper foodMapper;
	
	/**添加食物*/
	public boolean add(Food food) {
		food.setFno(UUIDUtil.getUUID());
		return foodMapper.add(food);
	}
	
	/**删除食物*/
	public boolean deleteByFno(Serializable fno) {
		return foodMapper.deleteByFno(fno);
	}
	
	/**更新食物*/
	public 	boolean update(Food food) {
		return foodMapper.update(food);
	}
	
	/**查询所有食物*/
	public List<Food> list(Food food){
		return foodMapper.list(food);
	}
	
	/**通过编号查询食物*/
	public Food selectByFno(Serializable fno) {
		return foodMapper.selectByFno(fno);
	}
	
	/**通过食物名查询食物热量*/
	public Food selectRlByFname(String fname) {
		return foodMapper.selectRlByFname(fname);
	}
	
	/**更新食物图像*/
	public boolean updateFpicture(Food food) {
		return foodMapper.updateFpicture(food);
	}
}
