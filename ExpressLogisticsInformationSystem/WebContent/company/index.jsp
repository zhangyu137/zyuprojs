<%@page import="com.lanqiao.team9.expresssystem.entity.Company" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    Company company = (Company) session.getAttribute("company");
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <link rel="icon" href="../images/maomi.png" type="image/x-icon">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title>公司管理中心</title>
    <link rel="stylesheet" href="<%=path %>/css/pintuer.css">
    <link rel="stylesheet" href="<%=path %>/css/admin.css">
    <script src="<%=path %>/js/jquery.js"></script>
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
    <div class="logo margin-big-left fadein-top">
        <h1><img src="../images/y.jpg" class="radius-circle rotate-hover" height="50"
                 alt=""/><%=company.getCompanyname() %>管理中心</h1>
    </div>
    <div class="head-l"><a class="button button-little bg-green" href="" target="_blank"><span class="icon-home"></span>
        前台首页</a> &nbsp;&nbsp;<a href="##" class="button button-little bg-blue"><span class="icon-wrench"></span>
        清除缓存</a> &nbsp;&nbsp;<a class="button button-little bg-red" href="../login.html"><span
            class="icon-power-off"></span> 退出登录</a></div>
</div>
<div class="leftnav">
    <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
    <h2><span class="icon-user"></span>我的订单</h2>
    <ul style="display:block">
        <li><a href="<%=path %>/GoodsServlet?m=GlistForCompanyS0&name=<%=company.getCompanyname() %>"
               target="right"><span id="click" class="icon-caret-right"></span>待接收的订单</a></li>
        <li><a href="<%=path %>/GoodsServlet?m=GlistForCompanyS1&name=<%=company.getCompanyname() %>"
               target="right"><span class="icon-caret-right"></span>待发货的订单</a></li>
        <li><a href="<%=path %>/GoodsServlet?m=GlistForCompanyS2&name=<%=company.getCompanyname() %>"
               target="right"><span class="icon-caret-right"></span>运途中的订单</a></li>
        <li><a href="<%=path %>/GoodsServlet?m=GlistForCompanyS3&name=<%=company.getCompanyname() %>"
               target="right"><span class="icon-caret-right"></span>待收货的订单</a></li>
    </ul>
    <h2><span class="icon-user"></span>历史订单</h2>
    <ul style="display:block">
        <li><a href="<%=path %>/GoodsServlet?m=GlistForCompanyS4&name=<%=company.getCompanyname() %>"
               target="right"><span class="icon-caret-right"></span>完成的订单</a></li>
        <li><a href="<%=path %>/GoodsServlet?m=GlistForCompanyS5&name=<%=company.getCompanyname() %>"
               target="right"><span class="icon-caret-right"></span>未完成订单</a></li>
    </ul>
    <h2><span class="icon-pencil-square-o"></span>公司信息管理</h2>
    <ul>
        <li><a href="<%=path %>/company/cateedit.jsp" target="right"><span class="icon-caret-right"></span>修改公司信息</a>
        </li>
    </ul>
</div>
<script type="text/javascript">
    $(function () {
        $(".leftnav h2").click(function () {
            $(this).next().slideToggle(200);
            $(this).toggleClass("on");
        })
        $(".leftnav ul li a").click(function () {
            $("#a_leader_txt").text($(this).text());
            $(".leftnav ul li a").removeClass("on");
            $(this).addClass("on");
        })
        $("#click").click();
    });
</script>
<ul class="bread">
    <li><a href="{:U('Index/info')}" target="right" class="icon-home"> 首页</a></li>
    <li><a href="##" id="a_leader_txt">待接收的订单</a></li>
    <li><b>当前语言：</b><span style="color:red;">中文</php></span>
        <div class="admin">
            <iframe scrolling="auto" rameborder="0"
                    src="<%=path %>/GoodsServlet?m=GlistForCompanyS0&name=<%=company.getCompanyname() %>" name="right"
                    width="100%" height="100%"></iframe>
        </div>
</body>
</html>