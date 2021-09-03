package com.lanqiao.team9.dietsystem.mapper;

import com.lanqiao.team9.dietsystem.entity.Dairy;
import com.lanqiao.team9.dietsystem.util.StrUtil;

public class DairyFoodProvider {
    public String getListSql1(Dairy dairy) {//根据日期来查完全信息
        StringBuffer sql = new StringBuffer("select zaorl,zhongrl,wanrl,zongrl,xhl,ddate from dairy where 1=1");
        if (null != dairy) {
            if (dairy.getUno() != null) {
                sql.append("and uno=#{uno}");
            }
            if (dairy.getDdate() != null) {
                sql.append("and ddate=#{ddate}");
            }

        }
        return sql.toString();
    }

    public String getListSql2(Dairy dairy) {//只查某一天的一些早餐信息
        StringBuffer sql = new StringBuffer("select zaorl,xhl,ddate,zongrl from dairy where 1=1");
        if (null != dairy) {
            if (dairy.getUno() != null) {
                sql.append("and uno=#{uno}");
            }
        }
        if (dairy.getDdate() != null) {
            sql.append("and ddate=#{ddate}");
        }
        return sql.toString();
    }

    public String getListSql3(Dairy dairy) {//只查某一天的一些中餐信息
        StringBuffer sql = new StringBuffer("select zhongrl,xhl,ddate,zongrl from dairy where 1=1");
        if (null != dairy) {
            if (dairy.getUno() != null) {
                sql.append("and uno=#{uno}");
            }
            if (dairy.getDdate() != null) {
                sql.append("and ddate=#{ddate}");
            }
        }
        return sql.toString();
    }

    public String getListSql4(Dairy dairy) {//只查某一天的晚餐
        StringBuffer sql = new StringBuffer("select wanrl,xhl,ddate,zongrl from dairy where 1=1");
        if (null != dairy) {
            if (dairy.getUno() != null) {
                sql.append("and uno=#{uno}");
            }
            if (dairy.getDdate() != null) {
                sql.append("and ddate=#{ddate}");
            }
        }
        return sql.toString();
    }
    
    public String getUpdateSql(Dairy dairy) {
    	StringBuffer sql = new StringBuffer("update dairy set dno = #{dno,jdbcType=VARCHAR}");
        if (null != dairy) {
            if (dairy.getZaorl() != null) {
            	sql.append(", zaorl=#{zaorl,jdbcType=VARCHAR} ");
            }
            if (dairy.getZhongrl() != null) {
            	sql.append(", zhongrl=#{zhongrl,jdbcType=VARCHAR} ");
            }
            if (dairy.getWanrl() != null) {
            	sql.append(", wanrl=#{wanrl,jdbcType=VARCHAR} ");
            }
            if (dairy.getZongrl() != null) {
            	sql.append(", zongrl=#{zongrl,jdbcType=VARCHAR} ");
            }
            if (dairy.getXhl() != null) {
            	sql.append(", xhl=#{xhl,jdbcType=VARCHAR} ");
            }
            sql.append("where dno = #{dno} and uno=#{uno} and ddate=#{ddate}");
        }
        return sql.toString();
    }
}
