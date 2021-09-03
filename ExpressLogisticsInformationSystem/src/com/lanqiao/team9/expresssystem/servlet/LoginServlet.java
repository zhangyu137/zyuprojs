package com.lanqiao.team9.expresssystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lanqiao.team9.expresssystem.entity.Company;
import com.lanqiao.team9.expresssystem.entity.Customer;
import com.lanqiao.team9.expresssystem.service.CompanyService;
import com.lanqiao.team9.expresssystem.service.CustomerService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String phone = request.getParameter("phone");
		String pwd = request.getParameter("pwd");
		String m = request.getParameter("shenfen");
		switch (m) {
		case "custom":
			CustomerService customerService = new CustomerService();
			Customer customer = customerService.isCustomer(phone, pwd);
			if(null!=customer) {
				// 登录成功，将公司信息存放在session中，方便其他JSP或Servlet使用
				HttpSession session = request.getSession();
				session.setAttribute("customer", customer);
				response.sendRedirect(request.getContextPath()+"/customer/index.jsp");
			}else {
				request.setAttribute("info", "用户名或密码错误");
				request.getRequestDispatcher("/login.html").forward(request, response);
			}
			break;
		case "company":
			CompanyService companyService = new CompanyService();
			Company company = companyService.isCompany(phone, pwd);
			if(null!=company) {
				// 登录成功，将公司信息存放在session中，方便其他JSP或Servlet使用
				HttpSession session = request.getSession();
				session.setAttribute("company", company);
				response.sendRedirect(request.getContextPath()+"/company/index.jsp");
			}else {
				request.setAttribute("info", "用户名或密码错误");
				request.getRequestDispatcher("/login.html").forward(request, response);
			}
			break;
		case "manager":
			if("luyi".equals(phone)&&"123".equals(pwd)) {
			response.sendRedirect(request.getContextPath()+"/admin/glyIndex.jsp");
			}else {
				request.setAttribute("info", "用户名或密码错误");
				request.getRequestDispatcher("/login.html").forward(request, response);
			}
			break;
		}
	}

}
