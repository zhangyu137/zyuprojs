package com.lanqiao.team9.dietsystem.mapper;

import org.apache.ibatis.annotations.*;
import com.lanqiao.team9.dietsystem.entity.Dairy;

import java.io.Serializable;
import java.util.List;

@CacheNamespace
public interface DairyFoodMapper {
    /** 添加历史日志记录*/
    @Insert("insert into dairy(dno,uno,zaorl,zhongrl,wanrl,zongrl,xhl,ddate) values (#{dno,jdbcType=VARCHAR},#{uno,jdbcType=VARCHAR},#{zaorl,jdbcType=VARCHAR},#{zhongrl,jdbcType=VARCHAR},#{wanrl,jdbcType=VARCHAR},#{zongrl,jdbcType=VARCHAR},#{xhl,jdbcType=VARCHAR},#{ddate,jdbcType=VARCHAR})")
     boolean add(Dairy dairy);
    /** 删除用户全部的历史记录*/
    @Delete("delete from dairy where dno=#{dno}")
    boolean delete(Serializable dno);
    /** 查询全部信息*/
    @SelectProvider(type = DairyFoodProvider.class,method = "getListSql1")
    List<Dairy> list1(Dairy dairy);
    /** 查询某一天早餐记录*/
    @SelectProvider(type = DairyFoodProvider.class,method = "getListSql2")
    List<Dairy> list2(Dairy dairy);
    /** 查询某一天中餐记录*/
    @SelectProvider(type = DairyFoodProvider.class,method = "getListSql3")
    List<Dairy> list3(Dairy dairy);
    /** 查询某一天晚餐记录*/
    @SelectProvider(type = DairyFoodProvider.class,method = "getListSql4")
    List<Dairy> list4(Dairy dairy);
    
    /**查看当天记录*/
    @Select("select dno, zaorl,zhongrl,wanrl,zongrl,xhl,ddate from dairy where uno=#{uno,jdbcType=VARCHAR} and ddate = #{ddate,jdbcType=VARCHAR}")
    Dairy selectToday(Dairy dairy);
    
    /**修改当天记录*/
    @UpdateProvider(type = DairyFoodProvider.class,method = "getUpdateSql")
    boolean update(Dairy dairy);
}
