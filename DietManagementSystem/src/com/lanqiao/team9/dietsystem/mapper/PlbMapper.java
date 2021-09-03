package com.lanqiao.team9.dietsystem.mapper;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.lanqiao.team9.dietsystem.entity.Plb;

@CacheNamespace
public interface PlbMapper {
	/**添加评论*/
	@Insert("insert into plb(plno,uname,dtno,contain,pdate) values(#{plno,jdbcType=VARCHAR},"
			+ "#{uname,jdbcType=VARCHAR},#{dtno,jdbcType=VARCHAR},#{contain,jdbcType=VARCHAR},#{pdate,jdbcType=VARCHAR})")
	boolean add(Plb plb);
	
	/**评论条数*/
	@Select("select plno from plb where dtno = #{dtno}")
	List<String> comments(String dtno);
	
	/**删除评论*/
	@Delete("delete from plb where plno = #{plno}")
	boolean delete(String plno);
	@Delete("delete from plb where dtno = #{dtno}")
	boolean deleteAndDt(String dtno);
	
	/**通过动态编号查询评论*/
	@Select("select plno,yh.uname,photo,contain,pdate from yh,plb where yh.uname=plb.uname and dtno = #{dtno} order by pdate desc")
	List<Plb> select(String dtno);
	
	@SelectProvider(type=PlbProvider.class,method="getListSql")
	List<Plb> selectForYh(Plb plb);
	
	
}
