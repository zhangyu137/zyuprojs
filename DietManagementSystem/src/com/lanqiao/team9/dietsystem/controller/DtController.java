package com.lanqiao.team9.dietsystem.controller;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lanqiao.team9.dietsystem.entity.Dt;
import com.lanqiao.team9.dietsystem.entity.Food;
import com.lanqiao.team9.dietsystem.service.DtService;
import com.lanqiao.team9.dietsystem.util.UUIDUtil;

@Controller
@RequestMapping("DtController")
public class DtController {
	
	@Autowired
	private  DtService dtService;
	
	/**添加动态*/
	@RequestMapping("add.do")
	@ResponseBody
	public boolean add(@RequestParam(value="img",required=false)MultipartFile[] img,@RequestParam(value="uname",required=false)String uname,@RequestParam(value="content",required=false)String content) throws IOException {
		List<String> imgList = new ArrayList<String>();
		String fileName = null;
		//限制只上传图片文件	
		for (MultipartFile dtpicture : img) {
			if(!dtpicture.isEmpty() && null != ImageIO.read(dtpicture.getInputStream())){
				// 获取文件名
				fileName = dtpicture.getOriginalFilename();
				// 设置 文件新的名字
				fileName = UUIDUtil.getUUID() + fileName.substring(fileName.lastIndexOf("."));
				
				imgList.add(fileName);
				
				// 上传图片到 c:/upload
				File targetFile = new File("c:/upload", fileName);
				targetFile.createNewFile();
				dtpicture.transferTo(targetFile);
			}
		}
		// 将 图片名 保存到数据库
		if (null!=imgList) {
			Dt dt = new Dt();
			dt.setContent(content);
			dt.setUname(uname);
			switch (imgList.size()) {
				case 6:
					dt.setdtpicturess(imgList.get(5));
				case 5:
					dt.setdtpictureff(imgList.get(4));
				case 4:
					dt.setdtpicturef(imgList.get(3));
				case 3:
					dt.setdtpictures(imgList.get(2));
				case 2:
					dt.setdtpicturet(imgList.get(1));
				case 1:
					dt.setdtpictureo(imgList.get(0));
					break;
			}
			boolean ret = dtService.add(dt);
			if(ret == false) {
				return false;//更新失败，返回空信息
			}
		}
		return true;
	}
	
	/**删除动态*/
	@RequestMapping("deleteByDtno.do")
	@ResponseBody
	public boolean deleteByFno(String dtno) {
		return dtService.deleteByDtno(dtno);
	}
	
	/**查询所有动态*/
	@RequestMapping("list.do")
	@ResponseBody
	 public List<Dt> list(Dt dt){
		return dtService.list(dt);
	}
	
	@RequestMapping("dtList.do")
	@ResponseBody
	public List<Dt> dtList(String uname,String uno) {
		return dtService.dtList(uname,uno);
	}
	@RequestMapping("myTie.do")
	@ResponseBody
	public List<Dt> myTie(String uname) {
		return dtService.myTie(uname);
	}
	@RequestMapping("FyList.do")
	@ResponseBody
	public List<Dt> FyList(String uname,String uno,int page) {
		return dtService.FyList(uname,uno,page);
	}
	@RequestMapping("mySc.do")
	@ResponseBody
	public List<Dt> mySc(String uno) {
		return dtService.mySc(uno);
	}
	//测试
	@RequestMapping("test.do")
	@ResponseBody
	public void test(@RequestParam(value="img",required=false)MultipartFile[] img,@RequestParam(value="text",required=false)String text) {
		System.out.println("i am in test");
		System.out.println(text);
	}
	
	/**更新动态*/
	@RequestMapping("update.do")
	@ResponseBody
	public 	boolean update(Dt dt) {
		return dtService.update(dt);
	}
		
	/**更新动态图像*/
	@RequestMapping("updateDtpicture.do")
	@ResponseBody
	public boolean updateDtpicture(@RequestParam(value="img",required=false)MultipartFile[] img,String dtno) throws IOException {
		List<String> imgList = new ArrayList<String>();
		String fileName = null;
		//限制只上传图片文件	
		for (MultipartFile dtpicture : img) {
			if(!dtpicture.isEmpty() && null != ImageIO.read(dtpicture.getInputStream())){
				// 获取文件名
				fileName = dtpicture.getOriginalFilename();
				// 设置 文件新的名字
				fileName = UUIDUtil.getUUID() + fileName.substring(fileName.lastIndexOf("."));
				
				imgList.add(fileName);
				
				// 上传图片到 c:/upload
				File targetFile = new File("c:/upload", fileName);
				targetFile.createNewFile();
				dtpicture.transferTo(targetFile);
			}
		}
		// 将 图片名 保存到数据库
		if (null!=imgList) {
			Dt dt = new Dt();
			dt.setDtno(dtno);
			switch (imgList.size()) {
				case 6:
					dt.setdtpicturess(imgList.get(5));
				case 5:
					dt.setdtpictureff(imgList.get(4));
				case 4:
					dt.setdtpicturef(imgList.get(3));
				case 3:
					dt.setdtpictures(imgList.get(2));
				case 2:
					dt.setdtpicturet(imgList.get(1));
				case 1:
					dt.setdtpictureo(imgList.get(0));
					break;
			}
			boolean ret = dtService.updateDtpicture(dt);
			if(ret == false) {
				return false;//更新失败，返回空信息
			}
		}
		return true;
	}
		
}
