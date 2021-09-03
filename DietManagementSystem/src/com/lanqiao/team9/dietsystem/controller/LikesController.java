package com.lanqiao.team9.dietsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;
import com.lanqiao.team9.dietsystem.entity.Dt;
import com.lanqiao.team9.dietsystem.entity.Likes;
import com.lanqiao.team9.dietsystem.service.LikesService;

@Controller
@RequestMapping("LikesController")
public class LikesController {

	@Autowired
	private  LikesService likesService;
	
	
	/**显示点赞数*/
	@RequestMapping("likes.do")
	@ResponseBody
	public int likes(String dtno) {
		return likesService.likes(dtno);
	}
	@RequestMapping("iflike.do")
	@ResponseBody
	public boolean iflike(String dtno,String uno) {
		return likesService.iflike(dtno,uno);
	}
	
	/**添加点赞*/
	@RequestMapping("add.do")
	@ResponseBody
	public boolean add(Likes likes) {
		return likesService.add(likes);
	}
	
	/**删除点赞*/
	@RequestMapping("delete.do")
	@ResponseBody
	public boolean delete(Likes likes) {
		return likesService.delete(likes);
	}
	/**删除点赞*/
	@RequestMapping("deleteAndDt.do")
	@ResponseBody
	public boolean deleteAndDt(String dtno) {
		return likesService.deleteAndDt(dtno);
	}

}
