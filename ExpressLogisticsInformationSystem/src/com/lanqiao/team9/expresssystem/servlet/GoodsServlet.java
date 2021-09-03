package com.lanqiao.team9.expresssystem.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lanqiao.team9.expresssystem.entity.Company;
import com.lanqiao.team9.expresssystem.entity.Customer;
import com.lanqiao.team9.expresssystem.entity.Goods;
import com.lanqiao.team9.expresssystem.service.CompanyService;
import com.lanqiao.team9.expresssystem.service.CustomerService;
import com.lanqiao.team9.expresssystem.service.GoodService;

@WebServlet("/GoodsServlet")
public class GoodsServlet extends HttpServlet {
	
	GoodService goodservice=new GoodService();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String m = request.getParameter("m");
		switch (m) {
		case "add":									//添加订单
			add(request,response);
			break;
		case "FuzzyQueryForAdmin":					//通过订单编号和快递公司模糊查询出订单信息
			FuzzyQueryForAdmin(request,response);
			break;
		case "GupdateForTransportForCustomer":		//顾客更改寄件货品状态
			GupdateForTransportForCustomer(request,response);	
			break;	
		case "GupdateForTransportReceiveForCustomer":		//顾客更改收件货品状态
			GupdateForTransportReceiveForCustomer(request,response);	
			break;	
		case "GupdateForTransportForCompany":		//快递公司更改货品状态
			GupdateForTransportForCompany(request,response);	
			break;	
		case "GlistForCompanyS0":					//快递公司查询待接收的订单
			GlistForCompanyS0(request,response);	
			break;
		case "GlistForCompanyS1":					//快递公司查询待发货订单
			GlistForCompanyS1(request,response);	
			break;
		case "GlistForCompanyS2":					//快递公司查询运途中的订单
			GlistForCompanyS2(request,response);
			break;
		case "GlistForCompanyS3":					//快递公司查询待收货的订单
			GlistForCompanyS3(request,response);
			break;
		case "GlistForCompanyS4":					//快递公司查询收货完成的订单
			GlistForCompanyS4(request,response);	
			break;
		case "GlistForCompanyS5":					//快递公司查询被截胡的订单
			GlistForCompanyS5(request,response);	
			break;
		case "GupdateGoodsInfoForCompany":					//快递公司修改订单（可以修改货品信息，收件人姓名手机号身份证和地址，付款方式，金额，状态）
			GupdateGoodsInfoForCompany(request,response);	
			break;
		case "GlistNotAtivityForUser":				//寄件人的快递公司待接收的订单，通过用户id查询
			GlistNotAtivityForUser(request,response);
			break;
		case "GlistNotFinshForUserFor1":				//寄件人的待发货的订单，通过用户id查询
			GlistNotFinshForUserFor1(request,response);
			break;
		case "GlistNotFinshForUserFor2":				//寄件人的运途中的订单，通过用户id查询
			GlistNotFinshForUserFor2(request,response);
			break;
		case "GlistNotFinshForUserFor3":				//寄件人的待收货的订单，通过用户id查询
			GlistNotFinshForUserFor3(request,response);
			break;
		case "GlistNotFinshForUser":				//寄件人的还在运输中的订单（包括待发货，运途中，待收货），通过用户id查询
			GlistNotFinshForUser(request,response);
			break;
		case "GlistNotFinshForUserForReceive":		//收件人的还在运输中的订单（包括待发货，运途中，待收货），通过用户手机号查询
			GlistNotFinshForUserForReceive(request,response);	
			break;
		case "GlistFinishForUser":				// 顾客完成和截胡的历史订单
			GlistFinishForUser(request,response);
			break;
		case "GlistReceiveFinishForUser":				// 顾客收件完成和截胡的历史订单(通过手机号查询)
			GlistReceiveFinishForUser(request,response);
			break;
		case "GlistFinishForAdmin":				// 管理员查询货品订单
			GlistFinishForAdmin(request,response);
			break;
		case "DelelteGoods":				// 管理员删除订单
			DelelteGoods(request,response);
			break;
		case "GupdateGoodsInfoForAdmin":					//管理员修改订单（可以修改快递公司，货品信息，收件人姓名手机号身份证和地址，付款方式，金额，状态）
			GupdateGoodsInfoForAdmin(request,response);	
			break;
		}
	}
	public void GlistNotFinshForUserFor3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer customer =(Customer)session.getAttribute("customer");
		String customerid = customer.getCustomerid();
		ArrayList<Goods> jijian = goodservice.GlistNotFinshForUserFor3(customerid);
		request.setAttribute("jijian", jijian);
		request.getRequestDispatcher("customer/shouhuo.jsp").forward(request, response);
		
	}
	public void GlistNotFinshForUserFor2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer customer =(Customer)session.getAttribute("customer");
		String customerid = customer.getCustomerid();
		ArrayList<Goods> jijian = goodservice.GlistNotFinshForUserFor2(customerid);
		request.setAttribute("jijian", jijian);
		request.getRequestDispatcher("customer/noshouhuo.jsp").forward(request, response);
		
	}
	public void GlistNotFinshForUserFor1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer customer =(Customer)session.getAttribute("customer");
		String customerid = customer.getCustomerid();
		ArrayList<Goods> jijian = goodservice.GlistNotFinshForUserFor1(customerid);
		request.setAttribute("jijian", jijian);
		request.getRequestDispatcher("customer/noshouhuo.jsp").forward(request, response);
		
	}
	public void GlistReceiveFinishForUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone = request.getParameter("phone");
		ArrayList<Goods> lishishoujian=goodservice.GlistReceiveFinishForUser(phone);
		request.setAttribute("lishishoujian", lishishoujian);
		request.getRequestDispatcher("customer/lishishoujian.jsp").forward(request, response);
		
		
	}
	public void GupdateGoodsInfoForAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		/*
		 * 封装成一个货品对象进行修改
		 */
		
		String goodsid = request.getParameter("goodsid");
		String companyname = request.getParameter("companyname");
		String cargo = request.getParameter("cargo");
		String senderphone = request.getParameter("phone");
		String senderidcard = request.getParameter("idcard");
		String senderadd = request.getParameter("senderadd");
		String receivename = request.getParameter("receivename");
		String receivephone = request.getParameter("receivephone");
		String receiveidcard = request.getParameter("receiveidcard");
		String receiveadd = request.getParameter("receiveadd");
		String pay = request.getParameter("pay");
		String money = request.getParameter("money");
		String status = request.getParameter("status");
		Goods good=new Goods(goodsid,companyname,cargo,null,senderphone,senderidcard,senderadd,null,receivename,receivephone,receiveidcard,receiveadd,pay,money,status,null);
		boolean res=goodservice.GupdateGoodsInfoForAdmin(good);
		GlistFinishForAdmin(request, response);
		
	}
	public void GupdateGoodsInfoForCompany(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 封装成一个货品对象进行修改
		 */
		
		String goodsid = request.getParameter("goodsid");
		String cargo = request.getParameter("cargo");
		String receivename = request.getParameter("receivename");
		String receivephone = request.getParameter("receivephone");
		String receiveidcard = request.getParameter("receiveidcard");
		String receiveadd = request.getParameter("receiveadd");
		String pay = request.getParameter("pay");
		String money = request.getParameter("money");
		String status = request.getParameter("status").trim();
		Goods good=new Goods(goodsid,null,cargo,null,null,null,null,null,receivename,receivephone,receiveidcard,receiveadd,pay,money,status,null);
		boolean res=goodservice.GupdateGoodsInfoForCompany(good);
		String  s = request.getParameter("s");
		CompanyService companyService = new CompanyService();
		HttpSession session = request.getSession();
		Company company =(Company)session.getAttribute("company");
		Company newcompany =companyService.ClistMyself(company.getCompanyname());
		session.setAttribute("company", newcompany);
		if("0".equals(s)) {
			request.getRequestDispatcher("/GoodsServlet?m=GlistForCompanyS0&name="+newcompany.getCompanyname()).forward(request, response);
		}else {
			request.getRequestDispatcher("/GoodsServlet?m=GlistForCompanyS1&name="+newcompany.getCompanyname()).forward(request, response);
		}
	}
	public void GlistFinishForAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Goods> search = goodservice.GlistFinishForAdmin();
		request.setAttribute("search", search);
		request.getRequestDispatcher("/admin/goodsMgr.jsp").forward(request, response);
		
	}
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String companyname = request.getParameter("companyname");
		String cargo = request.getParameter("cargo");
		String customerid = request.getParameter("customerid");
		String sendername = request.getParameter("name");
		String senderphone = request.getParameter("phone");
		String senderidcard = request.getParameter("idcard");
		String senderadd = request.getParameter("senderadd");
		String receivename = request.getParameter("receivename");
		String receivephone = request.getParameter("receivephone");
		String receiveidcard = request.getParameter("receiveidcard");
		String receiveadd = request.getParameter("receiveadd");
		String pay = request.getParameter("pay");
		String money = request.getParameter("money");
		String status = request.getParameter("status");
		Goods good=new Goods(null,companyname,cargo,customerid,sendername,senderphone,senderidcard,senderadd,receivename,receivephone,receiveidcard,receiveadd,pay,money,status,null);
		boolean res = goodservice.add(good);
		request.getRequestDispatcher("/customer/info.jsp").forward(request, response);
		/* 
		 * 添加成功跳转到。。
		 * */
	}
	private void FuzzyQueryForAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//通过订单编号和快递公司模糊查询出订单信息
		String goodsid = request.getParameter("goodsid");
		String companyName = request.getParameter("companyname");
		ArrayList<Goods> search = goodservice.FuzzyQueryForAdmin(goodsid, companyName);
		request.setAttribute("search", search);
		request.getRequestDispatcher("admin/goodsMgr.jsp").forward(request, response);
		
	}
	public void GupdateForTransportForCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		String goodsId = request.getParameter("goodsId");
		String status = request.getParameter("status");
		String s=request.getParameter("s");
		System.out.println(s);
		goodservice.GupdateForTransport(goodsId, status);
		switch(s) {
		case "待接收订单":
			GlistNotAtivityForUser(request, response);
			break;
		case "待发货订单":
			GlistNotFinshForUserFor1(request, response);
			break;
		case "运途中订单":
			GlistNotFinshForUserFor2(request, response);
			break;
		case "待收货订单":
			GlistNotFinshForUserFor3(request, response);
			break;
		}
		
	}
	public void GupdateForTransportReceiveForCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		String goodsId = request.getParameter("goodsId");
		String status = request.getParameter("status");
		goodservice.GupdateForTransport(goodsId, status);
		GlistNotFinshForUserForReceive(request, response);
		
	}
	public void GupdateForTransportForCompany(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String goodsId = request.getParameter("goodsId");
		String status = request.getParameter("status");
		goodservice.GupdateForTransport(goodsId, status);
		CompanyService companyService = new CompanyService();
		HttpSession session = request.getSession();
		Company company =(Company)session.getAttribute("company");
		Company newcompany =companyService.ClistMyself(company.getCompanyname());
		session.setAttribute("company", newcompany);
		switch(status) {
		case "1":
			request.getRequestDispatcher("/GoodsServlet?m=GlistForCompanyS0&name="+newcompany.getCompanyname()).forward(request, response);
			break;
		case "2":
			request.getRequestDispatcher("/GoodsServlet?m=GlistForCompanyS1&name="+newcompany.getCompanyname()).forward(request, response);
			break;
		case "3":
			request.getRequestDispatcher("/GoodsServlet?m=GlistForCompanyS2&name="+newcompany.getCompanyname()).forward(request, response);
			break;
		case "5":
			String s = request.getParameter("s");
			if("0".equals(s)) {
				request.getRequestDispatcher("/GoodsServlet?m=GlistForCompanyS0&name="+newcompany.getCompanyname()).forward(request, response);
			}else if("1".equals(s)) {
				request.getRequestDispatcher("/GoodsServlet?m=GlistForCompanyS1&name="+newcompany.getCompanyname()).forward(request, response);
			}else {
				request.getRequestDispatcher("/GoodsServlet?m=GlistForCompanyS2&name="+newcompany.getCompanyname()).forward(request, response);
			}
			break;
		}
		
		
	}
	public void GlistForCompanyS0(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		ArrayList<Goods> djieshou = goodservice.GlistForCompanyS0(name);
		request.setAttribute("djieshou", djieshou);
		request.getRequestDispatcher("company/djieshou.jsp").forward(request, response);
		
	}
	public void GlistForCompanyS1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		ArrayList<Goods> dfahuo = goodservice.GlistForCompanyS1(name);
		request.setAttribute("dfahuo", dfahuo);
		request.getRequestDispatcher("company/dfahuo.jsp").forward(request, response);
		
	}
	public void GlistForCompanyS2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		ArrayList<Goods> yuntu = goodservice.GlistForCompanyS2(name);
		request.setAttribute("yuntu", yuntu);
		request.getRequestDispatcher("company/yuntu.jsp").forward(request, response);
		
	}
	public void GlistForCompanyS3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		ArrayList<Goods> dshouhuo = goodservice.GlistForCompanyS3(name);
		request.setAttribute("dshouhuo", dshouhuo);
		request.getRequestDispatcher("company/dshouhuo.jsp").forward(request, response);
		
	}
	public void GlistForCompanyS4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		ArrayList<Goods> finish = goodservice.GlistForCompanyS4(name);
		request.setAttribute("finish", finish);
		request.getRequestDispatcher("company/finish.jsp").forward(request, response);
		
	}
	public void GlistForCompanyS5(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		ArrayList<Goods> jujie = goodservice.GlistForCompanyS5(name);
		request.setAttribute("jujie", jujie);
		request.getRequestDispatcher("company/jujie.jsp").forward(request, response);
		
	}
	public void GlistNotAtivityForUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		HttpSession session = request.getSession();
		Customer customer =(Customer)session.getAttribute("customer");
		String customerid = customer.getCustomerid();
		System.out.println(customerid+"fs ");
		ArrayList<Goods> jijian = goodservice.GlistNotAtivityForUser(customerid);
		request.setAttribute("jijian", jijian);
		request.getRequestDispatcher("customer/noshouhuo.jsp").forward(request, response);
	}
	public void GlistNotFinshForUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		HttpSession session = request.getSession();
		Customer customer =(Customer)session.getAttribute("customer");
		String customerid = customer.getCustomerid();
		ArrayList<Goods> jijian = goodservice.GlistNotFinshForUser(customerid);
		request.setAttribute("jijian", jijian);
		request.getRequestDispatcher("customer/noshouhuo.jsp").forward(request, response);
		
		
	}
	public void GlistNotFinshForUserForReceive(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		HttpSession session = request.getSession();
		Customer customer =(Customer)session.getAttribute("customer");
		ArrayList<Goods> shoujian = goodservice.GlistNotFinshForUserForReceive(customer.getPhone());
		request.setAttribute("shoujian", shoujian);
		request.getRequestDispatcher("customer/column.jsp").forward(request, response);
	}
	public void GlistFinishForUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		String customerid = request.getParameter("customerid");
		ArrayList<Goods> lishijijian = goodservice.GlistFinishForUser(customerid);
		request.setAttribute("lishijijian", lishijijian);
		request.getRequestDispatcher("customer/lishijijian.jsp").forward(request, response);
		
	}
	public void DelelteGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String goodsid = request.getParameter("goodsid");
		goodservice.DelelteGoods(goodsid);
		GlistFinishForAdmin(request, response);
		
	}
	
	public void returnCompoany(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Company company = (Company)session.getAttribute("company");
		session.setAttribute("company", company);
		response.sendRedirect(request.getContextPath()+"/company/index.jsp");
	}
}
