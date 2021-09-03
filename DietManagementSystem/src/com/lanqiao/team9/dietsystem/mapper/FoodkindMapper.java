package com.lanqiao.team9.dietsystem.mapper;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.lanqiao.team9.dietsystem.entity.Dairy;
import com.lanqiao.team9.dietsystem.entity.Foodkind;

@CacheNamespace
public interface FoodkindMapper {
	
	/**添加食物品种*/
	@Insert("insert into foodkind(no,gsl,rl,nl,dl,sgscl,energy) values("
			+ "#{no,jdbcType=VARCHAR},"
			+ "#{gsl,jdbcType=VARCHAR},"
			+ "#{rl,jdbcType=VARCHAR},"
			+ "#{nl,jdbcType=VARCHAR},"
			+ "#{dl,jdbcType=VARCHAR},"
			+ "#{sgscl,jdbcType=VARCHAR},"
			+ "#{energy,jdbcType=VARCHAR})")
	boolean add(Foodkind foodkind);
	
	/**删除食物品种*/
	@Delete("delete from foodkind where no = #{no}")
	boolean deleteByFno(Serializable no);
	
	/**更新食物*/
	@Update("update foodkind set "
			+ "gsl = #{gsl},"
			+ "rl = #{rl},"
			+ "nl = #{nl},"
			+ "dl = #{dl},"
			+ "sgscl = #{sgscl},"
			+ "energy = #{energy} where fno = #{fno}")
	boolean update(Foodkind foodkind);

    /** 查询谷薯类记录*/
    @SelectProvider(type = FoodkindProvider.class,method = "getListSql1")
    List<Foodkind> list1(Foodkind foodkind);
    
    /** 查询肉类记录*/
    @SelectProvider(type = FoodkindProvider.class,method = "getListSql2")
    List<Foodkind> list2(Foodkind foodkind);
    
    /** 查询奶类记录*/
    @SelectProvider(type = FoodkindProvider.class,method = "getListSql3")
    List<Foodkind> list3(Foodkind foodkind);
    
    /** 查询豆类记录*/
    @SelectProvider(type = FoodkindProvider.class,method = "getListSql4")
    List<Foodkind> list4(Foodkind foodkind);
    
    /** 查询水果蔬菜类记录*/
    @SelectProvider(type = FoodkindProvider.class,method = "getListSql5")
    List<Foodkind> list5(Foodkind foodkind);
    
    /** 查询能量类记录*/
    @SelectProvider(type = FoodkindProvider.class,method = "getListSql6")
    List<Foodkind> list6(Foodkind foodkind);
    
      
    
}
