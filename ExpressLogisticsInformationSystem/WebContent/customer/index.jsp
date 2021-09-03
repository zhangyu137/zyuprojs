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
    <title>个人管理中心</title>  
    <link rel="stylesheet" href="<%=path %>/css/pintuer.css">
    <link rel="stylesheet" href="<%=path %>/css/admin.css">
    <script src="<%=path %>/js/jquery.js"></script>   
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="<%=path %>/images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" /><%=customer.getName() %>个人管理中心</h1>
  </div>
  <div class="head-l"><a class="button button-little bg-green" href="" target="_blank"><span class="icon-home"></span> 前台首页</a> &nbsp;&nbsp;<a href="##" class="button button-little bg-blue"><span class="icon-wrench"></span> 清除缓存</a> &nbsp;&nbsp;<a class="button button-little bg-red" href="<%=path %>/login.html"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-user"></span>基本功能</h2>
  <ul style="display:block">
    <li><a href="info.jsp" target="right"><span class="icon-caret-right"></span>下单</a></li>  
    <li><a href="<%=path%>/GoodsServlet?m=GlistNotAtivityForUser&customerid=<%=customer.getCustomerid() %>" target="right"><span class="icon-caret-right"></span>我的寄件-待接收订单</a></li>     
    <li><a href="<%=path%>/GoodsServlet?m=GlistNotFinshForUserFor1&customerid=<%=customer.getCustomerid() %>" target="right"><span class="icon-caret-right"></span>我的寄件-待发货订单</a></li>     
    <li><a href="<%=path%>/GoodsServlet?m=GlistNotFinshForUserFor2&customerid=<%=customer.getCustomerid() %>" target="right"><span class="icon-caret-right"></span>我的寄件-运途中订单</a></li>     
    <li><a href="<%=path%>/GoodsServlet?m=GlistNotFinshForUserFor3&customerid=<%=customer.getCustomerid() %>" target="right"><span class="icon-caret-right"></span>我的寄件-待收货订单</a></li>     
    <li><a href="<%=path%>/GoodsServlet?m=GlistNotFinshForUserForReceive&phone=<%=customer.getPhone() %>" target="right"><span class="icon-caret-right"></span>我的收件</a></li>
  </ul>   
  <h2><span class="icon-user"></span>历史订单</h2>
  <ul style="display:block">
    <li><a href="<%=path%>/GoodsServlet?m=GlistFinishForUser&customerid=<%=customer.getCustomerid() %>&status=5" target="right"><span class="icon-caret-right"></span>寄件</a></li>
    <li><a href="<%=path%>/GoodsServlet?m=GlistReceiveFinishForUser&phone=<%=customer.getPhone() %>&status=5" target="right"><span class="icon-caret-right"></span>收件</a></li>
  </ul>   
  <h2><span class="icon-pencil-square-o"></span>用户信息管理</h2>
  <ul>
    <li><a href="cateedit.jsp" target="right"><span class="icon-caret-right"></span>修改个人信息</a></li>        
  </ul>  
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
<ul class="bread">
  <li><a href="firstpage.html" target="right" class="icon-home"> 首页</a></li>
  <li><a href="##" id="a_leader_txt">填写下单信息</a></li>
  <li><b>当前语言：</b><span style="color:red;">中文</php></span>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="info.jsp" name="right" width="100%" height="100%"></iframe>
</div>
</body>
</html>