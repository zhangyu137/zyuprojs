<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.lanqiao.team9.expresssystem.dao.AdminDao" %>
<%@ page import="com.lanqiao.team9.expresssystem.entity.Company" %>
<%@ page import="java.util.ArrayList" %>
<%
	request.setCharacterEncoding("UTF-8");
	// 获取项目根路径
	String root = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<link rel="icon" href="<%=root %>/images/maomi.png" type="image/x-icon">
<link rel="stylesheet" href="<%=root %>/css/pintuer.css">
<link rel="stylesheet" href="<%=root %>/css/admin.css">
<head>
	<meta charset="UTF-8">
	<title>公司表管理</title>
</head>
<body>
<!--contentPanel内容面板：1.search  2.space  3.content -->
<div id="contentPanel">
	<!--
    	描述：条件查询
    -->
	<!-- 1.search -->
	<div class="search">
		<!-- 1.1. head -->
		<div class="head">
			<span><img src="<%=root %>/images/search.ico"/> 查询条件</span>
		</div>
		<!-- 1.2. body -->
		<div class="body">
			<form name="form1" action="<%=root %>/CompanyServlet?m=ClistForAdmin"  method="post">
				<table width="100%" cellspacing="0">
					<tr>
						<td>公司名</td>
						<td><input name="companyname" placeholder="支持模糊查询"/></td>
						<td>手机号</td>
						<td><input name="phone" placeholder="支持模糊查询"/></td>
						<td>法人</td>
						<td><input name="corporation" placeholder="支持模糊查询"/></td>
					</tr>

					<tr>
						<td colspan="3" id="btnPanel">
							<input type="submit" value="查询" />
							<input type="reset"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<!-- 2.space -->
	<div class="space"></div>

	<!--
    	描述：查询结果
    -->
	<!-- 3.content -->
	<div class="content">
		<!-- 3.1. head -->
		<div class="panel-head">
			<span><img src="<%=root %>/images/table.ico"/> 查询结果</span>
			<span onclick="location.reload()" style="float: right;"><img src="<%=root %>/images/refresh.ico"/></span>
		</div>
		<!-- 3.2. body -->
		<div class="body" >
			<table width="100%" cellspacing="0" class="table table-hover text-center">
				<tr>
					<th width="5%">公司名</th>
					<th width="5%">手机号</th>
					<th width="5%">法人</th>
					<td width="5%">密码</td>
					<th width="5%">注册时间</th>
					<th width="5%">操作</th>
				</tr>
				<%
					ArrayList<Company> list=(ArrayList<Company>)request.getAttribute("search");

					for(int i=0;i<list.size();i++){
					Company coms = list.get(i);
				%>
				<tr>
					<td><%=coms.getCompanyname() %></td>
					<td><%=coms.getPhone() %></td>
					<td><%=coms.getCorporation() %></td>
					<td><%=coms.getPwd() %></td>
					<td><%=coms.getRegtime() %></td>
					<td>
						<a href="<%=root%>/CompanyServlet?m=delete&companyname=<%=coms.getCompanyname()%>">删除</a>
						<a href="<%=root%>/admin/upCompany.jsp?companyname=<%=coms.getCompanyname()%>&phone=<%=coms.getPhone()%>&corporation=<%=coms.getCorporation()%>&pwd=<%=coms.getPwd() %>&regtime=<%=coms.getRegtime()%>">修改</a>
					</td>
				</tr>
				<%
					}
				%>
				<tr>
        			<td colspan="8">
        				<div class="pagelist"> 
        				<a href="">上一页</a> <span class="current">1</span><a href="">2</a>
        				<a href="">3</a><a href="">下一页</a>
        				<a href="">尾页</a> 
        				</div>
        			</td>
      			</tr>
			</table>
		</div>
	</div>
</div>
</body>
</html>
