package com.lanqiao.team9.dietsystem.mapper;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import com.lanqiao.team9.dietsystem.entity.Yh;

@CacheNamespace
public interface YhMapper {
	/**添加用户*/
	@Insert("insert into yh(uno,uname,photo,phone,pwd,weight,height,sex,birth,plan,jfnum,jfday,udate) "
			+ "values(#{uno,jdbcType=VARCHAR},#{uname,jdbcType=VARCHAR},#{photo,jdbcType=VARCHAR},#{phone,jdbcType=VARCHAR},"
			+ "#{pwd,jdbcType=VARCHAR},#{weight,jdbcType=VARCHAR},#{height,jdbcType=VARCHAR},#{sex,jdbcType=VARCHAR},#{birth,jdbcType=VARCHAR},"
			+ "#{plan,jdbcType=VARCHAR},#{jfnum,jdbcType=VARCHAR},#{jfday,jdbcType=VARCHAR},#{udate,jdbcType=VARCHAR})")
	boolean add(Yh yh);
	
	/**删除用户*/
	@Delete("delete from yh where uno = #{uno}")
	boolean delete(Serializable uno);
	
	/**修改用户信息*/
	@UpdateProvider(type = YhProvider.class,method = "getUpdateSql")
	boolean update(Yh yh);
	
	/**修改用户头像*/
	@Update("update yh set photo = #{photo} where uno = #{uno}")
	boolean updatePhoto(Yh yh);
	
	/**查询一个用户信息（用于登录）*/
	@Select("select uno,uname,photo,phone,pwd,weight,height,sex,birth,plan,jfnum,jfday,udate from yh where phone = #{phone} and pwd = #{pwd}")
	Yh selectToLogin(Yh yh);
	
	/**通过编号查询用户信息*/
	@Select("select uno,uname,photo,phone,pwd,weight,height,sex,birth,plan,jfnum,jfday,udate from yh where uno = #{uno}")
	Yh selectByUno(Serializable uno);

	/**查询所有用户信息*/
	@SelectProvider(type = YhProvider.class,method = "getListSql")
	List<Yh> list(Yh yh);
	
	/**判断待注册或新增的用户名是否存在*/
	@Select("select uno,uname,photo,phone,pwd,weight,height,sex,birth,plan,jfnum,jfday,udate from yh where uname = #{uname}")
	Yh isExists(String uname);
}
