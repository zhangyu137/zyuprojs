package com.lanqiao.team9.dietsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanqiao.team9.dietsystem.entity.Collect;
import com.lanqiao.team9.dietsystem.service.CollectService;

@Controller
@RequestMapping("CollectController")
public class CollectController {

	@Autowired
	private  CollectService collectService;
	
	
	/**显示点赞数*/
	@RequestMapping("collect.do")
	@ResponseBody
	public int collect(String dtno) {
		return collectService.collect(dtno);
	}
	@RequestMapping("ifcollect.do")
	@ResponseBody
	public boolean ifcollect(String dtno,String uno) {
		return collectService.ifcollect(dtno,uno);
	}
	
	/**添加点赞*/
	@RequestMapping("add.do")
	@ResponseBody
	public boolean add(Collect collect) {
		return collectService.add(collect);
	}
	
	/**删除点赞*/
	@RequestMapping("delete.do")
	@ResponseBody
	public boolean delete(Collect collect) {
		return collectService.delete(collect);
	}
	/**删除点赞*/
	@RequestMapping("deleteAndDt.do")
	@ResponseBody
	public boolean deleteAndDt(String dtno) {
		return collectService.deleteAndDt(dtno);
	}

}
