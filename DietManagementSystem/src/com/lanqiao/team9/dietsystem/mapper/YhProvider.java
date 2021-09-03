package com.lanqiao.team9.dietsystem.mapper;

import com.lanqiao.team9.dietsystem.entity.Yh;
import com.lanqiao.team9.dietsystem.util.StrUtil;

public class YhProvider {
	/**动态更新SQL*/
	public String getUpdateSql(Yh yh) {
		StringBuffer sql = new StringBuffer("update yh set uno = #{uno}");
	
		if(null != yh) {
			if(StrUtil.isNotEmpty(yh.getUname())) {
				sql.append(" ,uname = #{uname} ");
			}
			if(StrUtil.isNotEmpty(yh.getPhone())) {
				sql.append(" ,phone = #{phone} ");
			}
			if(StrUtil.isNotEmpty(yh.getPwd())) {
				sql.append(" ,pwd = #{pwd} ");
			}
			if(StrUtil.isNotEmpty(yh.getWeight())) {
				sql.append(" ,weight = #{weight} ");
			}
			if(StrUtil.isNotEmpty(yh.getHeight())) {
				sql.append(" ,height = #{height} ");
			}
			if(StrUtil.isNotEmpty(yh.getSex())) {
				sql.append(" ,sex = #{sex}");
			}
			if(StrUtil.isNotEmpty(yh.getBirth())) {
				sql.append(" ,birth = #{birth} ");
			}
			if(StrUtil.isNotEmpty(yh.getPlan())) {
				sql.append(" ,plan = #{plan}");
			}
			if(StrUtil.isNotEmpty(yh.getJfnum())) {
				sql.append(" ,jfnum = #{jfnum} ");
			}
			if(StrUtil.isNotEmpty(yh.getJfday())) {
				sql.append(" ,jfday = #{jfday} ");
			}
			
			sql.append("where uno = #{uno} ");
		}
		
		return sql.toString();
	}
	
	/**动态查询SQL*/
	public String getListSql(Yh yh) {
		StringBuffer sql = new StringBuffer("select uno,uname,photo,phone,pwd,weight,height,sex,birth,plan,jfnum,jfday,udate from yh where 1=1");
		
		if(null != yh) {
			if(StrUtil.isNotEmpty(yh.getUname())) {
				sql.append(" and uname like concat(concat('%',#{uname}),'%') ");
			}
			if(StrUtil.isNotEmpty(yh.getPhone())) {
				sql.append(" and phone like concat(concat('%',#{phone}),'%') ");
			}
			if(StrUtil.isNotEmpty(yh.getPwd())) {
				sql.append(" and pwd = #{pwd} ");
			}
			if(StrUtil.isNotEmpty(yh.getWeight())) {
				sql.append(" and weight = #{weight} ");
			}
			if(StrUtil.isNotEmpty(yh.getHeight())) {
				sql.append(" and height = #{height} ");
			}
			if(StrUtil.isNotEmpty(yh.getSex())) {
				sql.append(" and sex = #{sex} ");
			}
			if(StrUtil.isNotEmpty(yh.getBirth())) {
				sql.append(" and birth = #{birth} ");
			}
			if(StrUtil.isNotEmpty(yh.getPlan())) {
				sql.append(" and plan = #{plan} ");
			}
			if(StrUtil.isNotEmpty(yh.getJfnum())) {
				sql.append(" and jfnum = #{jfnum} ");
			}
			if(StrUtil.isNotEmpty(yh.getJfday())) {
				sql.append(" and jfday = #{jfday} ");
			}
			if(StrUtil.isNotEmpty(yh.getUdate())) {
				sql.append(" and udate like concat(concat('%',#{udate}),'%') ");
			}
		}
		
		return sql.toString();
	}
}
