package com.lanqiao.team9.dietsystem.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.lanqiao.team9.dietsystem.entity.Dt;
import com.lanqiao.team9.dietsystem.entity.DtFy;
import com.lanqiao.team9.dietsystem.entity.Food;
import com.lanqiao.team9.dietsystem.util.StrUtil;

import jdk.nashorn.internal.objects.annotations.Where;

public class DtProvider {
	public String getListSql(Dt dt) {
		StringBuffer sql = new StringBuffer("select dtno,uname,content,dtpicturet from dtb where 1=1");
	
		if(null != dt) {
			if(StrUtil.isNotEmpty(dt.getDtno())) {
				sql.append(" and dtno like concat(concat('%',#{dtno}),'%') ");
			}
			if(dt.getUname() != null) {
				sql.append(" and uname = #{uname} ");
			}
			if(StrUtil.isNotEmpty(dt.getContent())) {
				sql.append(" and content like concat(concat('%',#{content}),'%') ");
			}
			if(StrUtil.isNotEmpty(dt.getdtpictureo())) {
				sql.append(" and dtpicture like concat(concat('%',#{dtpicture}),'%') ");
			}
		}
		
		return sql.toString();
	}
	public String getListSql2(String uname) {
		StringBuffer sql = new StringBuffer("select dtno,dtb.uname,photo,content,dtdate,dtpictureo,dtpicturet,dtpictures,dtpicturef,dtpictureff,dtpicturess from yh,dtb where yh.uname=dtb.uname");
		
			if(StrUtil.isNotEmpty(uname)) {
				sql.append(" and yh.uname = #{uname}");
			}
		System.out.println(sql.toString()+" order by dtdate desc");
		return sql.toString()+" order by dtdate desc";
	}
	//mysql分页查询动态列表
	public String getListSql3(Map<String, Object> para) {
		StringBuffer sql = new StringBuffer("select dtno,dtb.uname,photo,content,dtdate,dtpictureo,dtpicturet,dtpictures,dtpicturef,dtpictureff,dtpicturess from yh join dtb on yh.uname=dtb.uname");
		
		if(StrUtil.isNotEmpty((String)para.get("date"))) {
			sql.append(" and dtdate <="+para.get("date"));
		}
		return sql.toString()+" order by dtdate desc limit "+para.get("start")+","+para.get("end");
	}
	//oracle分页查询动态列表
	public String getListSql4(Map<String, Object> para) {
		StringBuffer sql = new StringBuffer("SELECT dtno,uname,photo,content,dtdate,dtpictureo,dtpicturet,dtpictures,dtpicturef,dtpictureff,dtpicturess FROM (SELECT rownum rn,dtno,uname,photo,content,dtdate,dtpictureo,dtpicturet,dtpictures,dtpicturef,dtpictureff,dtpicturess FROM　(SELECT dtno,yh.uname,photo,content,dtdate,dtpictureo,dtpicturet,dtpictures,dtpicturef,dtpictureff,dtpicturess FROM dtb,yh WHERE dtb.uname=yh.uname");
				if(StrUtil.isNotEmpty((String)para.get("date"))) {
					sql.append(" and dtdate <='");
					sql.append(para.get("date"));
					sql.append("'");
				};
				sql.append(" ORDER BY dtdate DESC)");
				sql.append(" WHERE rownum<="); 
				sql.append(para.get("end"));
				sql.append(") WHERE rn>="); 
				sql.append(para.get("start"));
		return sql.toString();
	}
}
