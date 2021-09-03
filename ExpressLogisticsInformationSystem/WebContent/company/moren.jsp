<%@page import="com.lanqiao.team9.expresssystem.servlet.GoodsServlet" %>
<%@page import="com.lanqiao.team9.expresssystem.entity.Company" %>
<%@page import="com.lanqiao.team9.expresssystem.dao.CompanyDao" %>
<%@page import="com.lanqiao.team9.expresssystem.dao.GoodsDao" %>
<%@page import="com.lanqiao.team9.expresssystem.entity.Goods" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%
    String path = request.getContextPath();
    Company company = (Company) session.getAttribute("company");
    GoodsServlet goodsServlet = new GoodsServlet();
    ArrayList<Company> cms = null;//需要加方法
%>

<!DOCTYPE html>
<html>
<head>
    <link rel="icon" href="../images/maomi.png" type="image/x-icon">
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="<%=path %>/css/pintuer.css">
    <link rel="stylesheet" href="<%=path %>/css/admin.css">
</head>
<body>
<form method="post" action="">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder">我的订单</strong></div>
        <div class="padding border-bottom">
        </div>
        <table class="table table-hover text-center">
            <tr>
                <th>订单编号</th>
                <th>货物信息</th>
                <th>寄件人</th>
                <th>收件人</th>
                <th>付款方式</th>
                <th>订单金额</th>
                <th>运输状态</th>
                <th>创建时间</th>
            </tr>
            <%
            %>
            <tr>
                <td colspan="8">
                    <div class="pagelist"><a href="">上一页</a> <span class="current">1</span><a href="">2</a><a
                            href="">3</a><a href="">下一页</a><a href="">尾页</a></div>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>