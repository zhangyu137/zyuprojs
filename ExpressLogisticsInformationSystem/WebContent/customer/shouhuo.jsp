<%@page import="com.lanqiao.team9.expresssystem.entity.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.lanqiao.team9.expresssystem.dao.GoodsDao" %>
<%@ page import="com.lanqiao.team9.expresssystem.entity.Goods" %>
<%@ page import="java.util.List" %>
<%@page import="java.util.ArrayList"%>
 <%
    String path =  request.getContextPath();
    Customer customer = (Customer)session.getAttribute("customer");
   	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="icon" href="../images/maomi.png" type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=path %>/css/pintuer.css">
<link rel="stylesheet" href="<%=path %>/css/admin.css">
</head>
<body>
<form method="post" action="">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder">历史寄件</strong></div>
    <div class="padding border-bottom">
    </div>
    <table class="table table-hover text-center">
      <tr>
       				     <th>序号</th>       
       				     <th>订单编号</th>       
       				     <th>快递公司</th>       
        				 <th>货物信息</th>
       					 <th>寄件人</th>
      				     <th>收件人</th>
        				 <th>付款方式</th>
        				 <th>订单金额</th>
       					 <th>创建时间</th>
       					 <th>操作</th>
      </tr>
    	<%		ArrayList<Goods> jijian = (ArrayList<Goods>)request.getAttribute("jijian");
					if(null!=jijian ){
						for(int i=0;i<jijian.size();i++){
							Goods good=jijian.get(i);
				%>
				<tr>
					<td><%=i+1%></td>
					<td><%=good.getGoodsid()%></td>
					<td><%=good.getCompanyname()%></td>
					<td><%=good.getCargo()%></td>
					<td><%=good.getSendername() %></td>
					<td><%=good.getReceivename() %></td>
					<td><%=good.getPay() %></td>
					<td><%=good.getMoney() %></td>
					<td><%=good.getCreationtime() %></td>
					<td><input type="button" onclick="javascrtpt:window.location.href='/ExpressLogisticsInformationSystem/GoodsServlet?m=GupdateForTransportForCustomer&goodsId=<%=good.getGoodsid() %>&status=4&s=<%=good.getStatus() %>'" value="确认收货"/>
					    <input type="button" onclick="javascrtpt:window.location.href='/ExpressLogisticsInformationSystem/GoodsServlet?m=GupdateForTransportForCustomer&goodsId=<%=good.getGoodsid() %>&status=5&s=<%=good.getStatus() %>'" value="截胡"/></td>
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