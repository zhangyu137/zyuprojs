package com.lanqiao.team9.dietsystem.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lanqiao.team9.dietsystem.entity.Dt;
import com.lanqiao.team9.dietsystem.entity.Food;
import com.lanqiao.team9.dietsystem.entity.Yh;
import com.lanqiao.team9.dietsystem.service.DtService;

public interface DtMapper {

	/**添加动态*/
	@Insert("insert into dtb(dtno,uname,content,dtpictureo,dtpicturet,dtpictures,dtpicturef,dtpictureff,dtpicturess,dtdate) "
			+ "values(#{dtno},"
			+ "#{uname},"
			+ "#{content,jdbcType=VARCHAR},"
			+ "#{dtpictureo,jdbcType=VARCHAR},"
			+ "#{dtpicturet,jdbcType=VARCHAR},"
			+ "#{dtpictures,jdbcType=VARCHAR},"
			+ "#{dtpicturef,jdbcType=VARCHAR},"
			+ "#{dtpictureff,jdbcType=VARCHAR},"
			+ "#{dtpicturess,jdbcType=VARCHAR},"
			+ "#{dtdate})")
	boolean add(Dt dt);
	
	/**删除动态*/
	@Delete("delete from dtb where dtno = #{dtno}")
	boolean deleteByDtno(String dtno);
	
	/**动态查询用户动态信息*/
	@SelectProvider(type=DtProvider.class,method="getListSql")
	List<Dt> list(Dt dt);
	
//	/**查询所有动态*/
	@SelectProvider(type=DtProvider.class,method="getListSql2")
	List<Dt> dtList(String uname);
	/**查询所有动态*/
	@Select("select dtno,dtb.uname,photo,content,dtdate,dtpictureo,dtpicturet,dtpictures,dtpicturef,dtpictureff,dtpicturess from yh join dtb on yh.uname=#{uname} and dtb.uname=#{uname} order by dtdate desc")
	List<Dt> myTie(String uname);
	
	/**分页查询所有动态*/
//	@Select("select dtno,dtb.uname,photo,content,dtdate,dtpictureo,dtpicturet,dtpictures,dtpicturef,dtpictureff,dtpicturess from yh join dtb on yh.uname=dtb.uname order by dtdate desc limit ${param3},${param4}")
	@SelectProvider(type=DtProvider.class,method="getListSql4")
	List<Dt> FyList(Map<String, Object> para);
	
	/**查询SC所有动态*/
	@Select("select dtb.dtno,dtb.uname,photo,content,dtdate,dtpictureo,dtpicturet,dtpictures,dtpicturef,dtpictureff,dtpicturess from (scb join dtb on scb.dtno=dtb.dtno and scb.uno=#{uno}) join yh on yh.uname=dtb.uname order by dtdate desc")
	List<Dt> mySc(String uno);
	
	/**更新动态*/
	@Update("update dtb set content = #{content} where dtno = #{dtno}")
	boolean update(Dt dt);
	
	/**更新动态图像*/
	@Update("update dtb set dtpictureo = #{dtpictureo,jdbcType=VARCHAR},"
			+ "dtpicturet = #{dtpicturet,jdbcType=VARCHAR},"
			+ "dtpictures = #{dtpictures,jdbcType=VARCHAR},"
			+ "dtpicturef = #{dtpicturef,jdbcType=VARCHAR},"
			+ "dtpictureff = #{dtpictureff,jdbcType=VARCHAR},"
			+ "dtpicturess = #{dtpicturess,jdbcType=VARCHAR}"
			+ " where dtno = #{dtno}")
	boolean updateDtpicture(Dt dt);
	
	
}
