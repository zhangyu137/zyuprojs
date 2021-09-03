package com.lanqiao.team9.dietsystem.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.team9.dietsystem.Thread.LikesThread;
import com.lanqiao.team9.dietsystem.entity.Dt;
import com.lanqiao.team9.dietsystem.entity.Food;
import com.lanqiao.team9.dietsystem.entity.Likes;
import com.lanqiao.team9.dietsystem.entity.Plb;
import com.lanqiao.team9.dietsystem.mapper.DtMapper;
import com.lanqiao.team9.dietsystem.mapper.FoodMapper;
import com.lanqiao.team9.dietsystem.util.DateUtil;
import com.lanqiao.team9.dietsystem.util.UUIDUtil;

@Service
public class DtService {
	
	@Autowired
	private DtMapper dtMapper;
	@Autowired
	private LikesService likesService;
	@Autowired
	private CollectService collectService;
	@Autowired
	private PlbService plbService;
	String date = "";
	
	/**添加动态*/
	public boolean add(Dt dt) {
		dt.setDtno(UUIDUtil.getUUID());
		dt.setDtdate(DateUtil.getNow(DateUtil.DATE_YMDHMS2));
		return dtMapper.add(dt);
	}
	
	/**删除动态*/
	public boolean deleteByDtno(String dtno) {
		return dtMapper.deleteByDtno(dtno);
	}
	
	/**查询所有食物*/
	public List<Dt> list(Dt dt){
		return dtMapper.list(dt);
	}
	
	public 	List<Dt> FyList(String uname,String uno,int page) {
		List<Dt> dtb;
		Map<String, Object> para = new HashMap<String, Object>();
		para.put("uname", uname);
		if (page==1) {
			para.put("date", null);
			para.put("start", 1);
			para.put("end", 15);
			dtb=dtMapper.FyList(para);
			date=dtb.get(0).getDtdate();
		}else {
			para.put("date", date);
			para.put("start", (15*(page-1)+1));
			para.put("end", 15*page);
			dtb=dtMapper.FyList(para);
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
		
		int min=60000; 		//分钟
		int hour=3600000;	//小时
		int day=86400000;	//天
		int day2=172800000;
		try {
			Date now=dateFormat.parse(dateFormat.format(new Date()));
			if (dtb!=null) {
				for (Dt dt : dtb) {
					dt.setLike(likesService.iflike(dt.getDtno(),uno));
					dt.setLikes(likesService.likes(dt.getDtno()));
					dt.setCollect(collectService.ifcollect(dt.getDtno(),uno));
					dt.setCollects(collectService.collect(dt.getDtno()));
					dt.setComments(plbService.comments(dt.getDtno()));
					long diff=now.getTime() - dateFormat.parse(dt.getDtdate()).getTime();
					if (diff<hour) {
						dt.setDtdate((diff/min+1)+"分钟前");
					}else if (diff<day) {
						dt.setDtdate(diff/hour+"小时前");
					}else if(diff<day2){
						dt.setDtdate("昨天");
					}else {
						dt.setDtdate(DateUtil.dateFmt(dt.getDtdate(), "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd"));
					}
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dtb;
	}
	public 	List<Dt> dtList(String uname,String uno) {
		List<Dt> dtb=dtMapper.dtList(uname);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式

		int min=60000; 		//分钟
		int hour=3600000;	//小时
		int day=86400000;	//天
		int day2=172800000;
		try {
			Date now=dateFormat.parse(dateFormat.format(new Date()));
			if (dtb!=null) {
				for (Dt dt : dtb) {
					dt.setLike(likesService.iflike(dt.getDtno(),uno));
					dt.setLikes(likesService.likes(dt.getDtno()));
					dt.setCollect(collectService.ifcollect(dt.getDtno(),uno));
					dt.setCollects(collectService.collect(dt.getDtno()));
					dt.setComments(plbService.comments(dt.getDtno()));
					long diff=now.getTime() - dateFormat.parse(dt.getDtdate()).getTime();
					if (diff<hour) {
						dt.setDtdate((diff/min+1)+"分钟前");
					}else if (diff<day) {
						dt.setDtdate(diff/hour+"小时前");
					}else if(diff<day2){
						dt.setDtdate("昨天");
					}else {
						dt.setDtdate(DateUtil.dateFmt(dt.getDtdate(), "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd"));
					}
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dtb;
	}
	public 	List<Dt> mySc(String uno) {
		List<Dt> dtb=dtMapper.mySc(uno);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
		
		int min=60000; 		//分钟
		int hour=3600000;	//小时
		int day=86400000;	//天
		int day2=172800000;
		try {
			Date now=dateFormat.parse(dateFormat.format(new Date()));
			if (dtb!=null) {
				for (Dt dt : dtb) {
					dt.setLike(likesService.iflike(dt.getDtno(),uno));
					dt.setLikes(likesService.likes(dt.getDtno()));
					dt.setCollect(collectService.ifcollect(dt.getDtno(),uno));
					dt.setCollects(collectService.collect(dt.getDtno()));
					dt.setComments(plbService.comments(dt.getDtno()));
					long diff=now.getTime() - dateFormat.parse(dt.getDtdate()).getTime();
					if (diff<hour) {
						dt.setDtdate((diff/min+1)+"分钟前");
					}else if (diff<day) {
						dt.setDtdate(diff/hour+"小时前");
					}else if(diff<day2){
						dt.setDtdate("昨天");
					}else {
						dt.setDtdate(DateUtil.dateFmt(dt.getDtdate(), "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd"));
					}
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dtb;
	}
	/**更新动态*/
	public 	boolean update(Dt dt) {
		return dtMapper.update(dt);
	}
	
	/**更新动态图像*/
	public boolean updateDtpicture(Dt dt) {
		return dtMapper.updateDtpicture(dt);
	}

	public List<Dt> myTie(String uname) {
		List<Dt> dtb=dtMapper.myTie(uname);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int min=60000; 		//分钟
		int hour=3600000;	//小时
		int day=86400000;	//天
		int day2=172800000;
		try {
			Date now=dateFormat.parse(dateFormat.format(new Date()));
			if (dtb!=null) {
				for (Dt dt : dtb) {
					
					dt.setLikes(likesService.likes(dt.getDtno()));
					dt.setComments(plbService.comments(dt.getDtno()));
					long diff=now.getTime() - dateFormat.parse(dt.getDtdate()).getTime();
					if (diff<hour) {
						dt.setDtdate((diff/min+1)+"分钟前");
					}else if (diff<day) {
						dt.setDtdate(diff/hour+"小时前");
					}else if(diff<day2){
						dt.setDtdate("昨天");
					}else {
						dt.setDtdate(DateUtil.dateFmt(dt.getDtdate(), "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd"));
					}
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dtb;
	}
	
}
