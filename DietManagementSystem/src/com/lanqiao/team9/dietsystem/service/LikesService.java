package com.lanqiao.team9.dietsystem.service;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.team9.dietsystem.entity.Dt;
import com.lanqiao.team9.dietsystem.entity.Likes;
import com.lanqiao.team9.dietsystem.mapper.LikesMapper;
import com.lanqiao.team9.dietsystem.util.UUIDUtil;

import oracle.net.aso.p;

@Service
public class LikesService {

	@Autowired
	private LikesMapper likesMapper;
	
	/**显示点赞次数*/
	public int likes(String dtno) {
		List<String> list=likesMapper.likes(dtno);
		if (list!=null&&!list.isEmpty()) {
			return list.size();
		}else {
			return 0;
		}
		
	};
	
	public boolean iflike(String dtno,String uno) {
		List<String> like2=likesMapper.iflike(dtno,uno);
		if (like2.size()==0) {
			return false;
		}else {
			return true;
		}
	}
	/**添加点赞*/
	public boolean add(Likes likes) {
		likes.setDzno(UUIDUtil.getUUID());
		return likesMapper.add(likes);
	}
	
	/**删除点赞*/
	public boolean delete(Likes likes) {
		return likesMapper.delete(likes);
	}
	/**删除点赞*/
	public boolean deleteAndDt(String dtno) {
		return likesMapper.deleteAndDt(dtno);
	}
	
}
