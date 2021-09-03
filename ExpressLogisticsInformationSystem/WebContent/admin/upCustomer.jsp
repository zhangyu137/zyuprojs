<%@page import="com.lanqiao.team9.expresssystem.entity.Company" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
	request.setCharacterEncoding("utf-8");
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
    <title></title>
    <link rel="stylesheet" href="<%=path %>/css/pintuer.css">
    <link rel="stylesheet" href="<%=path %>/css/admin.css">
</head>
<body>
<div class="panel admin-panel margin-top">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改公司信息</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="<%=path %>/CustomerServlet?m=CustUpdateForAdmin">
        <div class="form-group">
            <div class="label">
          <label>顾客id：</label>
        </div>
        <div class="field">
          <input type="text" readonly="readonly" class="input w50" name="customerid" value="<%=request.getParameter("customerid") %>" />
          <div class="tips"></div>
        </div>
      </div>        
      <div class="form-group">
        <div class="label">
          <label>姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="name" value="<%=request.getParameter("name") %>" />
          <div class="tips"></div>
        </div>
      </div>        
      <div class="form-group">
        <div class="label">
          <label>手机号：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="phone" value="<%=request.getParameter("phone") %>"/>         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>身份证号：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="idcard" value="<%=request.getParameter("idcard") %>"/>         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input" name="pwd" value="<%=request.getParameter("pwd") %>"/>        
        </div>
        <div class="label">
          <label>注册时间：</label>
        </div>
        <div class="field">
          <input type="text" readonly="readonly" class="input w50" name="regtime" value="<%=request.getParameter("regtime") %>" />
          <div class="tips"></div>
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