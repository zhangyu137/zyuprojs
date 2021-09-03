package com.lanqiao.team9.dietsystem.mapper;

import com.lanqiao.team9.dietsystem.entity.Food;
import com.lanqiao.team9.dietsystem.util.StrUtil;

public class FoodProvider {
	public String getListSql(Food food) {
		StringBuffer sql = new StringBuffer("select fno,fname,foodrl,fpicture from food where 1=1");
	
		if(null != food) {
			if(StrUtil.isNotEmpty(food.getFname())) {
				sql.append(" and fname like concat(concat('%',#{fname}),'%') ");
			}
			if(food.getFoodrl() != null) {
				sql.append(" and foodrl = #{foodrl} ");
			}
			if(StrUtil.isNotEmpty(food.getFpicture())) {
				sql.append(" and fpicture like concat(concat('%',#{fpicture}),'%') ");
			}
		}
		
		return sql.toString();
	}
}
