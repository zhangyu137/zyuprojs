package com.lanqiao.team9.expresssystem.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lanqiao.team9.expresssystem.entity.Customer;
import com.lanqiao.team9.expresssystem.service.CustomerService;

/**
 * Servlet implementation class CustomerServlet
 */
@SuppressWarnings("serial")
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	
	CustomerService customerService = new CustomerService();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String m = request.getParameter("m");
		switch (m) {
		case "add":									//添加注册一个顾客
			add(request,response);
			break;
		case "delete":								//删除一个顾客
			delete(request,response);
			break;
		case "CustUpdate":								//顾客修改更新顾客
			CustUpdate(request,response);	
			break;	
		case "CustUpdateForAdmin":								//管理员修改更新顾客
			CustUpdateForAdmin(request,response);	
			break;	
		case "ListMyself":							//查看顾客的信息
			ListMyself(request,response);	
			break;	
		case "ListAll":							//所有顾客信息
			ListAll(request,response);	
			break;
		case "ListForAdmin":							//模糊查询顾客信息，供管理员使用
			ListForAdmin(request,response);	
			break;
		}
	}

	public void CustUpdateForAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Customerid = request.getParameter("customerid");
		String Name = request.getParameter("name");
		String Phone = request.getParameter("phone");
		String Idcard = request.getParameter("idcard");
		String Pwd = request.getParameter("pwd");
		String Regtime = request.getParameter("Regtime");
		Customer customer = new Customer(Customerid, Name, Phone, Idcard, Pwd, Regtime);
		if(customerService.CustUpdate(customer)) {
			ArrayList<Customer> search=customerService.ListAll();
			request.setAttribute("search", search);
			request.getRequestDispatcher("/admin/customerMgr.jsp").forward(request, response);
		}
		
	}

	public void ListForAdmin(HttpServletRequest request, HttpServletResponse response) {
		String Customerid = request.getParameter("customerid");
		String Name = request.getParameter("name");
		String Phone = request.getParameter("phone");
		ArrayList<Customer> search=customerService.ListForAdmin(Customerid, Name, Phone);
		request.setAttribute("search", search);
		try {
			request.getRequestDispatcher("/admin/customerMgr.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO 自动生成的方法存根
		String Name = request.getParameter("name");
		String Phone = request.getParameter("phone");
		String Idcard= request.getParameter("idcard");
		String Pwd = request.getParameter("pwd");
		Customer customer = new Customer(null, Name, Phone, Idcard, Pwd,null);
		if (customerService.add(customer)){
			response.sendRedirect("login.html");
		};
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		String customerid=request.getParameter("customerid");
		boolean res=customerService.delete(customerid);
		System.out.println("删除:"+res);
		ArrayList<Customer> search=customerService.ListAll();
		request.setAttribute("search", search);
		request.getRequestDispatcher("/admin/customerMgr.jsp").forward(request, response);
	}

	public void CustUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		String Customerid = request.getParameter("customerid");
		String Name = request.getParameter("customername");
		String Phone = request.getParameter("customerphone");
		String Idcard = request.getParameter("customeridcard");
		String Pwd = request.getParameter("customerpwd");
		String Regtime = request.getParameter("Regtime");
		Customer customer = new Customer(Customerid, Name, Phone, Idcard, Pwd, Regtime);
		if(customerService.CustUpdate(customer)) {
			HttpSession session = request.getSession();
			session.setAttribute("customer", customer);
			request.getRequestDispatcher("/customer/cateedit.jsp").forward(request, response);
		}
	}

	public void ListMyself(HttpServletRequest request, HttpServletResponse response) {
		// TODO 自动生成的方法存根
		String customerid=request.getParameter("customerid");
		customerService.ListMyself(customerid);

	}

	public void ListAll(HttpServletRequest request, HttpServletResponse response) {
		// TODO 自动生成的方法存根
		ArrayList<Customer> listall=customerService.ListAll();

	}

}

