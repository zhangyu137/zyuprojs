package com.lanqiao.team9.dietsystem.mapper;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.lanqiao.team9.dietsystem.entity.Dt;
import com.lanqiao.team9.dietsystem.entity.Likes;

@CacheNamespace
public interface LikesMapper {
	
	/**显示点赞次数*/
	@Select("select dzno from likes where dtno=#{dtno}")
	List<String> likes(String dtno);
	/**查看是非点赞*/
	@Select("select dzno from likes where dtno=#{dtno} and uno=#{uno}")
	List<String> iflike(@Param("dtno")String dtno,@Param("uno")String uno);

	/**添加点赞*/
	@Insert("insert into likes(dzno,uno,dtno) values(#{dzno},#{uno},#{dtno})")
	boolean add(Likes likes);
	
	/**删除点赞*/
	@Delete("delete from likes where uno = #{uno} and dtno=#{dtno}")
	boolean delete(Likes likes);
	/**删除点赞*/
	@Delete("delete from likes where dtno = #{dtno}")
	boolean deleteAndDt(String dtno);
}
