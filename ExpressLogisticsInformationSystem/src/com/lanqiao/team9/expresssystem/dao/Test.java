package com.lanqiao.team9.expresssystem.dao;

import com.lanqiao.team9.expresssystem.entity.Goods;
import com.lanqiao.team9.expresssystem.service.CompanyService;
import com.lanqiao.team9.expresssystem.service.GoodService;

public class Test {

	public static void main(String[] args) {
		/*
		 * GoodsDao和service下单测试
		 */
		GoodsDao goodsdao=new GoodsDao();
		GoodService goodservice=new GoodService();
		//Goods goods=new Goods("116b3e20024a4dc58ef9018df192e075",null,"食品",null,null,"李无","12345698799","123654789123658974","上沙","0","23","0",null);
		System.out.println(goodsdao.GlistReceiveFinishForUser("11222666666").size());
		System.out.println(goodservice.GlistReceiveFinishForUser("11222666666").size());
		
//		Goods goods=new Goods(null,"陆达快递","日用品","02","西安泌阳县","ui五","232323","253641","南宁西乡塘","0","36","0",null);
//		goodservice.add(goods);
		
		/*
		 * Goods更改状态
		 */
//		System.out.println(goodservice.GupdateForTransport("1","2"));
		
		/*
		 * 快递公司查询的订单
		 */
		//System.out.println(goodservice.GlistForCompanyS0("陆达快递").size());
		
		/*
		 * 顾客查询的订单
		 */
//		System.out.println(goodservice.GlistFinishForAdmin().size());
		CompanyService cs=new CompanyService();
		cs.delete("发");
	}

}
