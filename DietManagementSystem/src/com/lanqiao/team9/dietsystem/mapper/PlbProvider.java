package com.lanqiao.team9.dietsystem.mapper;

import com.lanqiao.team9.dietsystem.entity.Plb;
import com.lanqiao.team9.dietsystem.util.StrUtil;

public class PlbProvider {
	public String getListSql(Plb plb) {
		StringBuffer sql = new StringBuffer("select plno,yh.uname,photo,dtno,contain,pdate from yh,plb where yh.uname=plb.uname and yh.uname = #{uname}");
	
		if(null != plb) {
			if(StrUtil.isNotEmpty(plb.getDtno())) {
				sql.append(" and dtno like concat(concat('%',#{dtno}),'%') ");
			}
			if(plb.getContain() != null) {
				sql.append(" and contain like concat(concat('%',#{contain}),'%') ");
			}
		}
		sql.append(" order by pdate desc");
		return sql.toString();
	}
}
