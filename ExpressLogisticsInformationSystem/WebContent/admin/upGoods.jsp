<%@page import="com.lanqiao.team9.expresssystem.entity.Goods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");	
	String path =  request.getContextPath();
    //Goods good = (Goods)request.getAttribute("good");
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head >
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="<%=path %>/css/pintuer.css">
<link rel="stylesheet" href="<%=path %>/css/admin.css">
</head>
<body>
<div class="panel admin-panel margin-top">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改订单信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=path %>/GoodsServlet?m=GupdateGoodsInfoForAdmin">    
    <div class="form-group">
        <div class="label">
          <label>订单编号：</label>
        </div>
        <div class="field">
        <input type="text" readonly="readonly" class="input" name="goodsid" value="<%=request.getParameter("goodsid")  %>"/> 
        </div>
      </div>    
      <div class="form-group">
        <div class="label">
          <label>委托的快递公司：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="companyname" value="<%=request.getParameter("companyname") %>" />
          <div class="tips"></div>
        </div>
      </div>        
      <div class="form-group">
        <div class="label">
          <label>货物类型：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="cargo" value="<%=request.getParameter("cargo") %>"/>         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>收件人姓名：</label>
        </div>
        <div class="field">
          <input type="text"  class="input" name="receivename" value="<%=request.getParameter("receivename") %>"/>         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>收件人电话号码：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="receivephone" value="<%=request.getParameter("receivephone") %>"/>         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>收件人身份证：</label>
        </div>
        <div class="field">
        <input type="text" class="input" name="receiveidcard" value="<%=request.getParameter("receiveidcard")  %>"/> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>收件人地址：</label>
        </div>
        <div class="field">
        <input type="text" class="input" name="receiveadd" value="<%=request.getParameter("receiveadd")  %>"/> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>支付方式：</label>
        </div>
        <div class="field">
        <input type="text" class="input" name="pay" value="<%=request.getParameter("pay") %>"/> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>订单金额：</label>
        </div>
        <div class="field">
        <input type="text" class="input" name="money" value="<%=request.getParameter("money")  %>"/> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>运输状态：</label>
        </div>
        <div class="field">
        <input type="text" class="input" name="status" value="<%=request.getParameter("status")  %>"/> 
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
          <input class="button bg-main icon-check-square-o" type="submit" value="提交"/>
        </div>
      </div>
    </form>
  </div>
</div>
</body>

</html>