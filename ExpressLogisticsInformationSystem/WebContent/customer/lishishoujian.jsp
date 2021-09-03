<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.lanqiao.team9.expresssystem.entity.Goods"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lanqiao.team9.expresssystem.entity.Customer"%>
     <%
    	 	String path =  request.getContextPath();
     	 	Customer customer = (Customer)session.getAttribute("customer");
   	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title></title>
    <link rel="icon" href="../images/maomi.png" type="image/x-icon">
<link rel="stylesheet" href="<%=path %>/css/pintuer.css">
    <link rel="stylesheet" href="<%=path%>/css/admin.css">
</head>
<body>
<form method="post" action="">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder">历史寄件订单</strong></div>
    <div class="padding border-bottom">
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th>订单编号</th>       
        <th>货物信息</th>
        <th>寄件人</th>
        <th>收件人</th>
        <th>状态</th>
        <th>付款方式</th>
        <th>订单金额</th>
        <th>创建时间</th>
      </tr>
      <%  ArrayList<Goods> lishishoujian = (ArrayList<Goods>)request.getAttribute("lishishoujian");
			if(null!=lishishoujian){
			for(int i=0;i<lishishoujian.size();i++){
			      %>
			      <tr>
			      	<td><%=lishishoujian.get(i).getGoodsid() %></td>
			      	<td><%=lishishoujian.get(i).getCargo() %></td>
			      	<td><%=lishishoujian.get(i).getSendername() %></td>
			      	<td><%=lishishoujian.get(i).getReceivename() %></td>
			      	<td><%=lishishoujian.get(i).getStatus() %></td>
			      	<td><%=lishishoujian.get(i).getPay() %></td>
			      	<td><%=lishishoujian.get(i).getMoney() %></td>
			      	<td><%=lishishoujian.get(i).getCreationtime() %></td>
			      </tr>
						
			      <%}
			} %>    
      <tr>
        <td colspan="8"><div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div></td>
      </tr>
    </table>
  </div>
</form>
</body>
</html>