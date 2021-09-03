package com.lanqiao.team9.dietsystem.mapper;

import com.lanqiao.team9.dietsystem.entity.Foodkind;
import com.lanqiao.team9.dietsystem.util.StrUtil;

public class FoodkindProvider {
	public String getListSql(Foodkind foodkind) {
		StringBuffer sql = new StringBuffer("select no,gsl,energy from foodkind where 1=1");//查询对应编号谷薯类的热量
        if (null != foodkind) {
            if (foodkind.getNo() != null) {
                sql.append("and no=#{no}");
            }
            if (foodkind.getGsl() != null) {
                sql.append("and ddate=#{ddate}");
            }

        }
        return sql.toString();
    }

	}