package com.lanqiao.team9.dietsystem.service;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.team9.dietsystem.entity.Dt;
import com.lanqiao.team9.dietsystem.entity.Plb;
import com.lanqiao.team9.dietsystem.mapper.PlbMapper;
import com.lanqiao.team9.dietsystem.util.DateUtil;
import com.lanqiao.team9.dietsystem.util.UUIDUtil;

@Service
public class PlbService {
	@Autowired
	private PlbMapper plbMapper;
	
	/**添加评论*/
	public boolean add(Plb plb) {
		plb.setPlno(UUIDUtil.getUUID());
		plb.setPdate(DateUtil.getNow(DateUtil.DATE_YMDHMS2));
		return plbMapper.add(plb);
	}
	
	/**评论数*/

	public int comments(String dtno) {
		List<String> list=plbMapper.comments(dtno);
		if (list!=null&&!list.isEmpty()) {
			return list.size();
		}else {
			return 0;
		}
		
	};
	/**删除评论*/
	public boolean delete(String plno) {
		return plbMapper.delete(plno);
	}
	/**删除评论*/
	public boolean deleteAndDt(String dtno) {
		return plbMapper.deleteAndDt(dtno);
	}
	
	/**通过动态编号查询评论*/
	public List<Plb> select(String dtno){
		List<Plb> list = plbMapper.select(dtno);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int min=60000; 		//分钟
		int hour=3600000;	//小时
		int day=86400000;	//天
		int day2=172800000;
		try {
			Date now=dateFormat.parse(dateFormat.format(new Date()));
			if (list!=null) {
				for (Plb dt : list) {
					
					long diff=now.getTime() - dateFormat.parse(dt.getPdate()).getTime();
					if (diff<hour) {
						dt.setPdate((diff/min+1)+"分钟前");
					}else if (diff<day) {
						dt.setPdate(diff/hour+"小时前");
					}else if(diff<day2){
						dt.setPdate("昨天");
					}else {
						dt.setPdate(DateUtil.dateFmt(dt.getPdate(), "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd"));
					}
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Plb> selectForYh(Plb plb){
		List<Plb> list = plbMapper.selectForYh(plb);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int min=60000; 		//分钟
		int hour=3600000;	//小时
		int day=86400000;	//天
		int day2=172800000;
		try {
			Date now=dateFormat.parse(dateFormat.format(new Date()));
			if (list!=null) {
				for (Plb dt : list) {
					
					long diff=now.getTime() - dateFormat.parse(dt.getPdate()).getTime();
					if (diff<hour) {
						dt.setPdate((diff/min+1)+"分钟前");
					}else if (diff<day) {
						dt.setPdate(diff/hour+"小时前");
					}else if(diff<day2){
						dt.setPdate("昨天");
					}else {
						dt.setPdate(DateUtil.dateFmt(dt.getPdate(), "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd"));
					}
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return list;
	}

}
