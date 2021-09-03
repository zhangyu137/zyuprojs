package com.lanqiao.team9.dietsystem.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lanqiao.team9.dietsystem.entity.Dairy;
import com.lanqiao.team9.dietsystem.entity.Food;
import com.lanqiao.team9.dietsystem.service.FoodService;
import com.lanqiao.team9.dietsystem.util.UUIDUtil;

@Controller
@RequestMapping("FoodController")
public class FoodController {
	
	@Autowired
	private  FoodService foodService;
	
	/**添加食物*/
	@RequestMapping("add.do")
	@ResponseBody
	public boolean add(Food food) {
		return foodService.add(food);
	}
	
	/**删除食物*/
	@RequestMapping("deleteByFno.do")
	@ResponseBody
	public boolean deleteByFno(String fno) {
		return foodService.deleteByFno(fno);
	}
	
	/**更新食物*/
	@RequestMapping("update.do")
	@ResponseBody
	public 	boolean update(Food food) {
		return foodService.update(food);
	}
	
	/**查询所有食物*/
	@RequestMapping("list.do")
	@ResponseBody
	 public List<Food> list(Food food){
		return foodService.list(food);
	}
	
	/**通过编号查询食物*/
	@RequestMapping("selectByFno.do")
	@ResponseBody
	public Food selectByFno(String fno) {
		return foodService.selectByFno(fno);
	}
	
	/**通过食物名查询食物热量*/
	public Food selectRlByFname(String fname) {
		return foodService.selectRlByFname(fname);
	}
	
	/**更新食物图像*/
	@RequestMapping("updateFpicture.do")
	@ResponseBody
	public String updateFpicture(MultipartFile fpicture,String fno) throws IOException {
		String fileName = null;
		//限制只上传图片文件			
		if(!fpicture.isEmpty() && null != ImageIO.read(fpicture.getInputStream())){
			// 获取文件名
			fileName = fpicture.getOriginalFilename();
			System.out.println(fileName);
			// 设置 文件新的名字
			fileName = UUIDUtil.getUUID() + fileName.substring(fileName.lastIndexOf("."));
			
			// 上传图片到 c:/upload
			File targetFile = new File("c:/upload", fileName);
			targetFile.createNewFile();
			fpicture.transferTo(targetFile);
			
			// 将 图片名 保存到数据库
			Food food = new Food();
			food.setFno(fno);
			food.setFpicture(fileName);
			boolean ret = foodService.updateFpicture(food);
			if(ret == false) {
				fileName = null;//更新失败，返回空信息
			}
		}
		return fileName;
	}
	
	/* public static void main(String[] args) {
			ApplicationContext ac = new ClassPathXmlApplicationContext("/spring-servlet.xml");
			FoodController foodController = ac.getBean(FoodController.class);
			Food food = new Food();
			food.setFname("苹果");
			System.out.println(foodController.selectRlByFname("苹果"));
		    }*/
}
