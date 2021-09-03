package com.lanqiao.team9.dietsystem.controller;

import com.lanqiao.team9.dietsystem.entity.Dairy;
import com.lanqiao.team9.dietsystem.service.DairyFoodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("DairyController")
public class DairyController {
    @Autowired
    private DairyFoodService dairyFoodService;
    /** 添加历史日志记录*/
    @RequestMapping("add.do")
    @ResponseBody
    public boolean add(Dairy dairy){
        return dairyFoodService.add(dairy);
    }
    /** 查看任意时间的日志记录*/
    @RequestMapping("list1.do")
    @ResponseBody
    public List<Dairy> List1(Dairy dairy){
        return dairyFoodService.list1(dairy);
    }
    /** 查看早消耗记录*/
    @RequestMapping("list2.do")
    @ResponseBody
    public List<Dairy> List2(Dairy dairy){
        return dairyFoodService.list2(dairy);
    }
    /** 查看午消耗记录*/
    @RequestMapping("list3.do")
    @ResponseBody
    public List<Dairy> List3(Dairy dairy){
        return dairyFoodService.list3(dairy);
    }
    /** 查案晚消耗记录*/
    @RequestMapping("list4.do")
    @ResponseBody
    public List<Dairy> List4(Dairy dairy){
        return dairyFoodService.list4(dairy);
    }
    /** 删除全部记录*/
    @RequestMapping("delete.do")
    @ResponseBody
    public boolean delete(String dno){
        return dairyFoodService.delete(dno);
    }
    
    /**查看当天记录*/
    @RequestMapping("selectToday.do")
    @ResponseBody
    public Dairy selectToday(Dairy dairy) {
    	return dairyFoodService.selectToday(dairy);
    }
    
    /*public static void main(String[] args) {
	ApplicationContext ac = new ClassPathXmlApplicationContext("/spring-servlet.xml");
	DairyController dairyController = ac.getBean(DairyController.class);
	Dairy dairy = new Dairy();
	dairy.setUno("bb5479027cac41c798737d7281bdbd00");
	dairy.setZaorl("牛肉");
	dairy.setWanrl("苹果");
	dairyController.add(dairy);
    }*/
}
