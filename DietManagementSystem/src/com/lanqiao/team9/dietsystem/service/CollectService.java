package com.lanqiao.team9.dietsystem.service;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.team9.dietsystem.entity.Collect;
import com.lanqiao.team9.dietsystem.entity.Dt;
import com.lanqiao.team9.dietsystem.entity.Likes;
import com.lanqiao.team9.dietsystem.mapper.CollectsMapper;
import com.lanqiao.team9.dietsystem.mapper.LikesMapper;
import com.lanqiao.team9.dietsystem.util.UUIDUtil;

import oracle.net.aso.p;

@Service
public class CollectService {

	@Autowired
	private CollectsMapper collectMapper;
	
	/**显示点赞次数*/
	public int collect(String dtno) {
		List<String> collect=collectMapper.collects(dtno);
		if (collect!=null&&!collect.isEmpty()) {
			return collect.size();
		}else {
			return 0;
		}
		
	};
	
	public boolean ifcollect(String dtno,String uno) {
		List<String> collect=collectMapper.ifcollect(dtno, uno);
		if (collect.size()==0) {
			return false;
		}else {
			return true;
		}
	}
	/**添加点赞*/
	public boolean add(Collect collect) {
		collect.setScno(UUIDUtil.getUUID());
		return collectMapper.add(collect);
	}
	
	/**删除点赞*/
	public boolean delete(Collect collect) {
		return collectMapper.delete(collect);
	}
	/**删除点赞*/
	public boolean deleteAndDt(String dtno) {
		return collectMapper.deleteAndDt(dtno);
	}
	
}
