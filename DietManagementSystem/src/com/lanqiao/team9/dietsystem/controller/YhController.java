package com.lanqiao.team9.dietsystem.controller;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lanqiao.team9.dietsystem.entity.Yh;
import com.lanqiao.team9.dietsystem.service.YhService;
import com.lanqiao.team9.dietsystem.util.UUIDUtil;

@Controller
@RequestMapping("YhController")
public class YhController {
	@Autowired
	private YhService yhService;

	/**添加用户*/
	@RequestMapping("add.do")
	@ResponseBody
	public boolean add(Yh yh) {
		return yhService.add(yh);
	}
	
	/**删除用户*/
	@RequestMapping("delete.do")
	@ResponseBody
	public boolean delete(String uno) {
		return yhService.delete(uno);
	}
	
	/**修改用户信息*/
	@RequestMapping("update.do")
	@ResponseBody
	public boolean update(Yh yh) {
		return yhService.update(yh);
	}
	
	/**修改用户头像*/
	@RequestMapping("updatePhoto.do")
	@ResponseBody
	public String updatePhoto(MultipartFile photo,String uno) throws IOException {
		String fileName = null;
		//限制只上传图片文件			
		if(!photo.isEmpty() && null != ImageIO.read(photo.getInputStream())){
			// 获取文件名
			fileName = photo.getOriginalFilename();
			System.out.println(fileName);
			// 设置 文件新的名字
			fileName = UUIDUtil.getUUID() + fileName.substring(fileName.lastIndexOf("."));
			
			// 上传图片到 c:/upload
			File targetFile = new File("c:/upload", fileName);
			targetFile.createNewFile();
			photo.transferTo(targetFile);
			
			// 将 图片名 保存到数据库
			Yh yh = new Yh();
			yh.setUno(uno);
			yh.setPhoto(fileName);
			boolean ret = yhService.updatePhoto(yh);
			if(ret == false) {
				fileName = null;//更新失败，返回空信息
			}
		}
		return fileName;
	}
	
	/**查询一个用户信息（用于登录）*/
	@RequestMapping("selectToLogin.do")
	@ResponseBody
	Yh selectToLogin(Yh yh) {
		return yhService.selectToLogin(yh);
	}
	
	/**通过编号查询用户信息*/
	@RequestMapping("selectByUno.do")
	@ResponseBody
	public Yh selectByUno(String uno) {
		return yhService.selectByUno(uno);
	}
	
	/**查询所有用户信息*/
	@RequestMapping("list.do")
	@ResponseBody
	public List<Yh> list(Yh yh){
		return yhService.list(yh);
	}
	
	/**判断待注册或新增的用户名是否存在,存在返回TRUE*/
	@RequestMapping("isExists.do")
	@ResponseBody
	public boolean isExists(String uname) {
		return yhService.isExists(uname);
	}

}
