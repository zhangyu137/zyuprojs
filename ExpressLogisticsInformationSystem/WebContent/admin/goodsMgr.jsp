<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="com.lanqiao.team9.expresssystem.dao.GoodsDao" %>
<%@ page import="com.lanqiao.team9.expresssystem.entity.Goods" %>
<%@ page import="com.lanqiao.team9.expresssystem.entity.Company" %>
<%@ page import="com.lanqiao.team9.expresssystem.service.CompanyService" %>
<%@ page import="com.lanqiao.team9.expresssystem.util.ConnectUtil" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%
	request.setCharacterEncoding("UTF-8");
	// 获取项目根路径
	String root = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>货品表管理</title>
</head>
<link rel="stylesheet" href="<%=root %>/css/pintuer.css">
<link rel="stylesheet" href="<%=root %>/css/admin.css">
<body>
<!--contentPanel内容面板：1.search  2.space  3.content -->
<div id="contentPanel">
	<!--
    	描述：条件查询
    -->
	<!-- 1.search -->
	<div class="search" style=" margin-top: 15px; margin-left: 15px;">
		<!-- 1.1. head -->
		<div class="head">
			<span><img src="<%=root %>/images/search.ico"/> 查询条件</span> 
		</div>
		<!-- 1.2. body -->
		<div class="body">
			<form action="<%=root %>/GoodsServlet?m=FuzzyQueryForAdmin"  method="post">
				<table width="100%" cellspacing="0">
					<tr style="display: block; margin: 7px 0;">
						<td>订单编号:</td>
						<td> <input name="goodsid" placeholder="支持模糊查询"/></td>
						<td>委托的快递公司:</td>
						<td><select name="companyname">
								<option selected="selected" value="">请选择公司</option>
								<%
								ArrayList<Company> clist = new ArrayList<Company>();
								Connection connection = ConnectUtil.getConnection();
								String sql = "select companyname from company";
								PreparedStatement stmt = connection.prepareStatement(sql);
								ResultSet rs = stmt.executeQuery();
								while(rs.next()){
									out.print("<option value=" + rs.getString("companyname") + ">" + rs.getString("companyname") +  "</option>");
									//out.print("<option value=" + request.getParameter("companyname") + "></option>");
								}
								%>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="2" >
							<input type="submit" value="查询" />
							<input type="reset"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	
	<!-- 2.space -->
	<!--
    	描述：查询结果
    -->
	<!-- 3.content -->
	<div class="">
		<!-- 3.1. head -->
		<div class="panel-head">
			<span><img src="<%=root %>/images/table.ico"/> 查询结果</span>
			<span onclick="location.reload()" style="float: right;"><img src="<%=root %>/images/refresh.ico"/></span>
		</div>
		<!-- 3.2. body -->
		<div class="" >
			<table width="100%" cellspacing="0" class="table table-hover text-center">
				<tr>
					<th width="5%">订单编号</th>
					<th width="5%">委托的快递公司</th>
					<th width="5%">货物信息</th>
					<td width="5%">寄件人地址</td>
					<th width="5%">用户编号</th>
					<th width="5%">收件人姓名</th>
					<th width="5%">收件人手机号</th>
					<th width="5%">收件人身份证号</th>
					<th width="5%">收件人地址</th>
					<th width="5%">付款方式</th>
					<th width="5%">订单金额</th>
					<th width="5%">运输状态</th>
					<th width="5%">创建时间</th>
					<th width="5%">寄件人姓名</th>
					<th width="5%">寄件人手机号</th>
					<th width="5%">寄件人身份证号</th>
					<th width="5%">操作</th>
				</tr>
				<%
					ArrayList<Goods> list=(ArrayList<Goods>)request.getAttribute("search");
					for(int i=0;i<list.size();i++){
					Goods goods = list.get(i);
				%>
				<tr>
					<td><%=goods.getGoodsid() %></td>
					<td><%=goods.getCompanyname() %></td>
					<td><%=goods.getCargo() %></td>
					<td><%=goods.getSenderadd() %></td>
					<td><%=goods.getCustomerid() %></td>
					<td><%=goods.getReceivename() %></td>
					<td><%=goods.getReceivephone() %></td>
					<td><%=goods.getReceiveidcard() %></td>
					<td><%=goods.getReceiveadd() %></td>
					<td><%=goods.getPay() %></td>
					<td><%=goods.getMoney() %></td>
					<td><%=goods.getStatus() %></td>
					<td><%=goods.getCreationtime() %></td>
					<td><%=goods.getSendername() %></td>
					<td><%=goods.getSenderphone() %></td>
					<td><%=goods.getSenderidcard() %></td>
					<td>
						<a href="<%=root %>/GoodsServlet?m=DelelteGoods&goodsid=<%=goods.getGoodsid() %>">删除</a>
						<a href="<%=root %>/admin/upGoods.jsp?goodsid=<%=goods.getGoodsid() %>&companyname=<%=goods.getCompanyname()%>&cargo=<%=goods.getCargo()%>
								&receivename=<%=goods.getReceivename() %>&receivephone=<%=goods.getReceivephone()%>&receiveidcard=<%=goods.getReceiveidcard()%>
								&receiveadd=<%=goods.getReceiveadd() %>&pay=<%=goods.getPay()%>&money=<%=goods.getMoney()%>
								&status=<%=goods.getStatus()%>">修改</a>
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
