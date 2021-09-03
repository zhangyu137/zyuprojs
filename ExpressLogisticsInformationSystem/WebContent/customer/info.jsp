<%@page import="com.lanqiao.team9.expresssystem.entity.Company"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lanqiao.team9.expresssystem.service.CompanyService"%>
<%@page import="com.lanqiao.team9.expresssystem.entity.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    Customer customer = (Customer)session.getAttribute("customer");
    String path =  request.getContextPath();
    %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <link rel="icon" href="../images/maomi.png" type="image/x-icon">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>填写下单信息</title>  
    <link rel="stylesheet" href="<%=path %>/css/pintuer.css">
    <link rel="stylesheet" href="<%=path %>/css/admin.css">
    
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span>填写下单信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=path %>/GoodsServlet?m=add&customerid=<%=customer.getCustomerid() %>&status=0" >
      
      <div class="form-group">
        <div class="label">
          <label>委托快递公司：</label>
        </div>
        <div class="field">
           <select name="companyname">
           <%	
           CompanyService companyservice = new CompanyService();
           ArrayList<Company> companys = companyservice.ClistAll();
           for(int i =0;i<companys.size();i++){
          %> 
				<option value="<%=companys.get(i).getCompanyname() %>"><%=companys.get(i).getCompanyname() %></option>
          <% }%>
				<option value="其他">其他</option>
		  </select>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>货品类型：</label>
        </div>
        <div class="field">
          <select name="cargo">
				<option value="数码产品">数码产品</option>
				<option value="食品">食品</option>
				<option value="生活用品">生活用品</option>
				<option value="生鲜">生鲜</option>
				<option value="其他">其他</option>
		  </select>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>寄件人信息：</label>
        </div>
        <div class="field">
          <div><input type="text" class="input" name="name" id="name" placeholder="姓名" value="<%=customer.getName() %>" /></div>
          <div><input type="text" class="input" name="phone" id="phone" placeholder="手机号" value="<%=customer.getPhone() %>" /></div>
          <div><input type="text" class="input" name="idcard" id="idcard" placeholder="身份证号" value="<%=customer.getIdcard() %>" /></div>
          <div><input type="text" class="input" name="senderadd" id="senderadd"  placeholder="寄件人地址" value="" /></div>
      	 </div>
        </div>
        
      <div class="form-group">
        <div class="label">
          <label>收件人信息：</label>
        </div>
        <div class="field">
          <div><input type="text" class="input" name="receivename" id="receivename" placeholder="姓名" value="" /></div>
          <div><input type="text" class="input" name="receivephone" id="receivephone"  placeholder="手机号" value="" /></div>
          <div><input type="text" class="input" name="receiveidcard" id="receiveidcard"  placeholder="身份证号" value="" /></div>
          <div><input type="text" class="input" name="receiveadd" id="receiveadd" placeholder="收件人地址" value="" /></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>付款方式：</label>
        </div>
        <div class="field">
           <select name="pay">
				<option value="0">到付</option>
				<option value="1">现付</option>
		  </select>
        </div>
      </div>
      
      <div class="form-group">
      	<div class="label">
          <label>金额</label>
        </div>
        <div class="field">
        	<div><input type="text" readonly="readonly" class="input" name=money id="money" value="10" /></div>
        </div>
      </div>
      
      <div class="form-group">
      	<div class="label">
          <label></label>
        </div>
        <div class="field">
         	<div id="info">&nbsp;</div>
        </div>
      </div>
       
      <div class="form-group">
      	<div class="label">
          <label></label>
        </div>
        <div class="field">
         <input class="button bg-main icon-check-square-o" type="submit" id="submit"value="提交"/>
        </div>
      </div>
    </form>
  </div>
</div>
</body>
<script src="<%=path %>/js/jquery.js"></script>
<script src="<%=path %>/js/pintuer.js"></script>  
<script src="<%=path %>/js/check_info.js" type="text/javascript" charset="utf-8"></script> 

</html>