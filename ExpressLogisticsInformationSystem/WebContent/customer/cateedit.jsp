<%@page import="com.lanqiao.team9.expresssystem.entity.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
     	String path =  request.getContextPath();
    	Customer customer = (Customer)session.getAttribute("customer");
    %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
  <link rel="icon" href="../images/maomi.png" type="image/x-icon">
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
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改个人信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="/ExpressLogisticsInformationSystem/CustomerServlet?m=CustUpdate">        
      <div class="form-group">
        <div class="label">
          <label>顾客id：</label>
        </div>
        <div class="field">
          <input type="text" readonly="readonly" class="input w50" name="customerid" value="<%=customer.getCustomerid() %>" />
          <div class="tips"></div>
        </div>
      </div>        
      <div class="form-group">
        <div class="label">
          <label>姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="customername" value="<%=customer.getName() %>" />
          <div class="tips"></div>
        </div>
      </div>        
      <div class="form-group">
        <div class="label">
          <label>手机号：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="customerphone" value="<%=customer.getPhone() %>"/>         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>身份证号：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="customeridcard" value="<%=customer.getIdcard() %>"/>         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input" name="customerpwd" value="<%=customer.getPwd() %>"/>        
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
          <input class="button bg-main icon-check-square-o" type="button" id="button_customer" value="提交"/>
        </div>
      </div>
    </form>
  </div>
</div>
</body><script src="<%=path %>/js/jquery.js"></script>
<script src="<%=path %>/js/pintuer.js"></script>  
<script type="text/javascript">

//手机号校验
function checkReceivephone(){
	var info = "";
	if(/^1\d{10}$/.test($("[name='customerphone']").val())){
		return info;
	}else if($("[name='customerphone']").val()===""){
		info = "手机号不能为空";
		return info;
	}
	else{
		info="手机号格式不对";
		return info;
	}
}
//身份证校验
function checkReceiveidcard(){
	var info = "";
	if(/^\d{17}(\d|x|X)$/.test($("[name='customeridcard']").val())){
		return info;
	}else if($("[name='customeridcard']").val()==""){
		info = "身份证号不能为空";
		return info;
	}
	else{
		info="身份证号格式不对";
		return info;
	}
}
//密码校验
function checkPwd(){
	var info = "";
	if(/^.{1,10}$/.test($("[name='customerpwd']").val())){
		return info;
	}else if($("[name='customerpwd']").val()===""){
		info = "密码不能为空";
		return info;
	}
	else{
		info="密码格式不对";
		return info;
	}
}
//姓名校验
function checkName(){
	var info = "";
	if(/^[一-龥A-Za-z0-9]{2,20}$/.test($("[name='customername']").val())){
		return info;
	}else if($("[name='customername']").val()===""){
		info = "姓名不能为空";
		return info;
	}
	else{
		info="姓名格式不对";
		return info;
	}
}
//提交前校验
function sure_confirm() 
{
	return event.returnValue = confirm("确定提交吗？");
}
function doSubmit(){
	if(checkName()!="" ){
		$("#info").css("color","red").html(checkName());
	}else if(checkReceivephone()!=""){
		$("#info").css("color","red").html(checkReceivephone());
	}else if(checkReceiveidcard()){
		$("#info").css("color","red").html(checkReceiveidcard());
	}else if(checkPwd()!=""){
		$("#info").css("color","red").html(checkPwd());
	}else{
		if(sure_confirm()){
		$("form").submit();
		}else{
			return false;
		}
	}
}
$("input[type='button']").click(function(){
	doSubmit();
});
</script> 
</html>