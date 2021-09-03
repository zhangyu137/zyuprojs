package com.lanqiao.team9.dietsystem.mapper;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.lanqiao.team9.dietsystem.entity.Food;

@CacheNamespace
public interface FoodMapper {
	
	/**添加食物*/
	@Insert("insert into food(fno,fname,foodrl,fpicture) values(#{fno,jdbcType=VARCHAR},#{fname,jdbcType=VARCHAR},#{foodrl,jdbcType=VARCHAR},#{fpicture,jdbcType=VARCHAR})")
	boolean add(Food food);
	
	/**删除食物*/
	@Delete("delete from food where fno = #{fno}")
	boolean deleteByFno(Serializable fno);
	
	/**更新食物*/
	@Update("update food set fname = #{fname},foodrl = #{foodrl} where fno = #{fno}")
	boolean update(Food food);
	
	/**动态查询查询食物*/
	@SelectProvider(type=FoodProvider.class,method="getListSql")
	List<Food> list(Food food);
	
	/**通过编号查询食物*/
	@Select("select fno,fname,foodrl,fpicture from food where fno = #{fno}")
	Food selectByFno(Serializable fno);
	
	/**通过食物名查询食物热量*/
	@Select("select fno,fname,foodrl,fpicture from food where fname = #{fname}")
	Food selectRlByFname(String fname);
	
	/**更新食物图像*/
	@Update("update food set fpicture = #{fpicture} where fno = #{fno}")
	boolean updateFpicture(Food food);
}
