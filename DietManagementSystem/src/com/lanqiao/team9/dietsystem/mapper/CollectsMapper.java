package com.lanqiao.team9.dietsystem.mapper;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.lanqiao.team9.dietsystem.entity.Collect;
import com.lanqiao.team9.dietsystem.entity.Dt;
import com.lanqiao.team9.dietsystem.entity.Likes;

@CacheNamespace
public interface CollectsMapper {
	
	/**显示点赞次数*/
	@Select("select scno from SCB where dtno=#{dtno}")
	List<String> collects(String dtno);
	/**查看是非点赞*/
	@Select("select scno from SCB where dtno=#{dtno} and uno=#{uno}")
	List<String> ifcollect(@Param("dtno")String dtno,@Param("uno")String uno);

	/**添加点赞*/
	@Insert("insert into SCB(scno,uno,dtno) values(#{scno},#{uno},#{dtno})")
	boolean add(Collect collect);
	
	/**删除点赞*/
	@Delete("delete from SCB where uno = #{uno} and dtno=#{dtno}")
	boolean delete(Collect collect);
	/**删除点赞*/
	@Delete("delete from SCB where dtno = #{dtno}")
	boolean deleteAndDt(String dtno);
}
