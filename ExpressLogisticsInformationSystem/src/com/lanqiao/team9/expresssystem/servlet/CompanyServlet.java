package com.lanqiao.team9.expresssystem.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lanqiao.team9.expresssystem.entity.Company;
import com.lanqiao.team9.expresssystem.entity.Customer;
import com.lanqiao.team9.expresssystem.service.CompanyService;

/**
 * Servlet implementation class CompanyServlet
 */
@WebServlet("/CompanyServlet")
public class CompanyServlet extends HttpServlet {
	
	CompanyService companyService = new CompanyService();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String m = request.getParameter("m");
		switch (m) {
		case "add":									//添加注册一个快递公司
			add(request,response);
			break;
		case "delete":								//删除一个快递公司
			delete(request,response);
			break;
		case "update":								//修改更新快递公司（手机号，密码，法人），公司和管理员权限一致
			update(request,response);	
			break;
		case "updateforadmin":								//修改更新快递公司（手机号，密码，法人），公司和管理员权限一致
			updateForAdmin(request,response);	
			break;
		case "ClistMyself":							//查看快递公司的信息
			ClistMyself(request,response);	
			break;	
		case "ClistAll":							//所有快递公司信息
			ClistAll(request,response);	
			break;
		case "ClistForAdmin":							//模糊快递公司信息
			ClistForAdmin(request,response);	
			break;
		}
	}

	public void updateForAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String companyName = request.getParameter("companyName");
		String phone = request.getParameter("phone");
		String corporation = request.getParameter("corporation");
		String pwd = request.getParameter("pwd");
		String time = request.getParameter("time");
		Company company = new Company(companyName, phone, corporation, pwd, time);
		companyService.update(company);
		ArrayList<Company> search=companyService.ClistAll();
		request.setAttribute("search", search);
		request.getRequestDispatcher("/admin/companyMgr.jsp").forward(request, response);
		
	}

	public void ClistForAdmin(HttpServletRequest request, HttpServletResponse response) {
		String companyname = request.getParameter("companyname");
		String phone = request.getParameter("phone");
		String corporation = request.getParameter("corporation");
		ArrayList<Company> search=companyService.ClistForAdmin(companyname, phone, corporation);
		request.setAttribute("search", search);
		try {
			request.getRequestDispatcher("/admin/companyMgr.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String companyname = request.getParameter("name");
		String phone = request.getParameter("phone");
		String corporation = request.getParameter("corporation");
		String pwd = request.getParameter("pwd");
		Company company = new Company(companyname, phone, corporation, pwd, null);
		boolean i = companyService.add(company);
		response.sendRedirect("/ExpressLogisticsInformationSystem/login.html");
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String companyname = request.getParameter("companyname");
		companyService.delete(companyname);
		ArrayList<Company> search=companyService.ClistAll();
		request.setAttribute("search", search);
		request.getRequestDispatcher("/admin/companyMgr.jsp").forward(request, response);
		
	}

	public void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String companyName = request.getParameter("companyName");
		String phone = request.getParameter("phone");
		String corporation = request.getParameter("corporation");
		String pwd = request.getParameter("pwd");
		String time = request.getParameter("time");
		Company company = new Company(companyName, phone, corporation, pwd, time);
		if(companyService.update(company)) {
			HttpSession session = request.getSession();
			session.setAttribute("company", company);
			response.sendRedirect(request.getContextPath()+"/company/cateedit.jsp");
		}
	}

	public void ClistMyself(HttpServletRequest request, HttpServletResponse response) throws IOException {
	}

	public void ClistAll(HttpServletRequest request, HttpServletResponse response) {
		// TODO 自动生成的方法存根
		
	}

}
