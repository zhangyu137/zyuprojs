package com.lanqiao.team9.dietsystem.service;

import com.lanqiao.team9.dietsystem.entity.Dairy;
import com.lanqiao.team9.dietsystem.mapper.DairyFoodMapper;
import com.lanqiao.team9.dietsystem.mapper.FoodMapper;
import com.lanqiao.team9.dietsystem.util.DateUtil;
import com.lanqiao.team9.dietsystem.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class DairyFoodService {
    @Autowired
    private DairyFoodMapper dairyFoodMapper;
    @Autowired
    private FoodMapper foodMapper;
    
    public boolean add(Dairy dairy) {
    	Dairy dairy1= new Dairy();
    	dairy1.setDdate(DateUtil.getNow(DateUtil.DATE_YMD2));
    	dairy1.setUno(dairy.getUno());
    	Dairy dairy2= dairyFoodMapper.selectToday(dairy1);
    	if(null != dairy2) {
    		dairy.setDno(dairy2.getDno());
    		dairy.setDdate(DateUtil.getNow(DateUtil.DATE_YMD2));
	        long zao = 0;
	        long zhong = 0;
	        long wan = 0;
	        long zongrl = Long.parseLong(dairy2.getZhongrl());
	        if(null != dairy.getZaorl()) {
	           zao = Long.parseLong(foodMapper.selectRlByFname(dairy.getZaorl()).getFoodrl()) ;
	           dairy.setZaorl(zao+"");
	           zongrl = zongrl +zao;
	        }else {
	        	dairy.setZaorl(null);
	        }
	        if(null != dairy.getZhongrl()) {
	        	zhong = Long.parseLong(foodMapper.selectRlByFname(dairy.getZhongrl()).getFoodrl()) ;
	        	 dairy.setZhongrl(zhong+"");
	        	 zongrl = zongrl + zhong;
	        }else {
	        	dairy.setZhongrl(null);
	        }
	        if(null != dairy.getWanrl()) {
	        	wan = Long.parseLong(foodMapper.selectRlByFname(dairy.getWanrl()).getFoodrl()) ;
	        	  dairy.setWanrl(wan+"");
	        	  zongrl = zongrl + wan;
	        }else {
	        	dairy.setWanrl(null);
	        }
	        
	        long xhl = 0;
	        if(null!=dairy.getXhl()) {
	        	xhl = Long.parseLong(dairy.getXhl());
	        	 dairy.setXhl(xhl+"");
	        }else {
	        	 dairy.setXhl(null);
	        }
	        dairy.setZongrl(zongrl+"");
	        return dairyFoodMapper.update(dairy);
    	}else {
    		dairy.setDno(UUIDUtil.getUUID());
    		dairy.setDdate(DateUtil.getNow(DateUtil.DATE_YMD2));
            long zao = 0;
            long zhong = 0;
            long wan = 0;
            if(null != dairy.getZaorl()) {
               zao = Long.parseLong(foodMapper.selectRlByFname(dairy.getZaorl()).getFoodrl()) ;
            }
            if(null != dairy.getZhongrl()) {
            	zao = Long.parseLong(foodMapper.selectRlByFname(dairy.getZhongrl()).getFoodrl()) ;
            }
            if(null != dairy.getWanrl()) {
            	zao = Long.parseLong(foodMapper.selectRlByFname(dairy.getWanrl()).getFoodrl()) ;
            }
            
            long zongrl = zao+zhong+wan;
            long xhl = 0;
            if(null!=dairy.getXhl()) {
            	xhl = Long.parseLong(dairy.getXhl());
            }
            
            dairy.setZaorl(zao+"");
            dairy.setZhongrl(zhong+"");
            dairy.setWanrl(wan+"");
            dairy.setZongrl(zongrl+"");
            dairy.setXhl(xhl+"");
            return dairyFoodMapper.add(dairy);
    	}
    }
    public boolean delete(Serializable dno){
        return dairyFoodMapper.delete(dno);
    }
    public List<Dairy> list1(Dairy dairy){
        return dairyFoodMapper.list1(dairy);
    }
    public List<Dairy> list2(Dairy dairy){
        return dairyFoodMapper.list2(dairy);
    }
    public List<Dairy> list3(Dairy dairy){
        return dairyFoodMapper.list3(dairy);
    }
    public List<Dairy> list4(Dairy dairy){
        return dairyFoodMapper.list4(dairy);
    }
    /**查看当天记录*/
    public Dairy selectToday(Dairy dairy) {
    	dairy.setDdate(DateUtil.getNow(DateUtil.DATE_YMD2));
    	return dairyFoodMapper.selectToday(dairy);
    }
}
