package com.lanqiao.team9.dietsystem.Thread;

import com.lanqiao.team9.dietsystem.service.LikesService;

public class LikesThread extends Thread{

	int likes;
	String dtno;
	static LikesService lService=new LikesService();
	public LikesThread(String dtno) {
		this.dtno = dtno;
	}

	@Override
	public void run() {
		System.out.println("查询点赞多线程启动！"+dtno);
		likes = lService.likes(dtno);
		System.out.println("查询点赞多线结构！"+likes);
		
	}
	
	public int getLikes() {
		return likes;
	}
//	public static void main(String args[]) {
//		LikesThread likesThread=new LikesThread("243e961c80124c7e8cc231ad3dcd72bd");
//		likesThread.start();
//		System.out.println("likesThread----------"+likesThread.getLikes());
//	}
}
