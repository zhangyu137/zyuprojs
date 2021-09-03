package com.lanqiao.team9.dietsystem.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanqiao.team9.dietsystem.entity.Plb;
import com.lanqiao.team9.dietsystem.service.PlbService;

@Controller
@RequestMapping("PlbController")
public class PlbController {
	@Autowired
	private PlbService plbService;
	
	/**添加评论*/
	@RequestMapping("add.do")
	@ResponseBody
	public boolean add(Plb plb){
		return plbService.add(plb);
	}
	
	/**删除评论(管理员用)*/
	@RequestMapping("delete.do")
	@ResponseBody
	public boolean delete(String plno){
		return plbService.delete(plno);
	}
	@RequestMapping("comments.do")
	@ResponseBody
	public int comments(String dtno){
		return plbService.comments(dtno);
	}
	/**删除评论(删除动态时一起删除)*/
	@RequestMapping("deleteAndDt.do")
	@ResponseBody
	public boolean deleteAndDt(String dtno){
		return plbService.deleteAndDt(dtno);
	}
	
	/**通过动态编号查询评论*/
	@RequestMapping("select.do")
	@ResponseBody
	public List<Plb> select(String dtno){
		return plbService.select(dtno);
	}
	/**通过用户名,动态编号,评论内容查询评论*/
	@RequestMapping("selectForYh.do")
	@ResponseBody
	public List<Plb> selectForYh(Plb plb){
		return plbService.selectForYh(plb);
	}
	
}
