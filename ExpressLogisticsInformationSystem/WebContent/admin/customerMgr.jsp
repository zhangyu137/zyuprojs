<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="com.lanqiao.team9.expresssystem.dao.CustomerDao" %>
<%@ page import="com.lanqiao.team9.expresssystem.entity.Customer" %>
<%@ page import="java.util.ArrayList" %>
<%
    request.setCharacterEncoding("UTF-8");
    // 获取项目根路径
    String root = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<link rel="icon" href="../images/maomi.png" type="image/x-icon">
<link rel="stylesheet" href="<%=root %>/css/pintuer.css">
<link rel="stylesheet" href="<%=root %>/css/admin.css">
<head>
    <meta charset="UTF-8">
    <title>货品表管理</title>
</head>
<body>
<!--contentPanel内容面板：1.search  2.space  3.content -->
<div id="contentPanel">
    <!--
        描述：条件查询
    -->
    <!-- 1.search -->
    <div style=" margin-top: 15px; margin-left: 15px;">
        <!-- 1.1. head -->
        <div class="head">
            <span><img src="<%=root %>/images/search.ico"/> 查询条件</span>
        </div>
        <!-- 1.2. body -->
        <div class="body">
            <form action="<%=root %>/CustomerServlet?m=ListForAdmin" method="post">
                <table width="100%" cellspacing="0">
                    <tr style="display: block; margin: 7px 0;">
                        <td>用户编号</td>
                        <td><input name="customerid" placeholder="支持模糊查询"/></td>
                        <td>姓名</td>
                        <td><input name="name" placeholder="支持模糊查询"/></td>
                        <td>手机号</td>
                        <td><input name="phone" placeholder="支持模糊查询"/></td>
                    </tr>

                    <tr>
                        <td colspan="3" id="btnPanel">
                            <input type="submit" value="查询"/>
                            <input type="reset"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>

    <!-- 2.space -->
    <div class="space"></div>

    <!--
        描述：查询结果
    -->
    <!-- 3.content -->
    <div class="content">
        <!-- 3.1. head -->
        <div class="panel-head">
            <span><img src="<%=root %>/images/table.ico"/> 查询结果</span>
            <span onclick="location.reload()" style="float: right;"><img src="<%=root %>/images/refresh.ico"/></span>
        </div>
        <!-- 3.2. body -->
        <div class="body">
            <table width="100%" cellspacing="0" class="table table-hover text-center">
                <tr>
                    <th width="5%">用户编号</th>
                    <th width="5%">姓名</th>
                    <th width="5%">手机号</th>
                    <td width="5%">身份证号</td>
                    <th width="5%">密码</th>
                    <th width="5%">注册时间</th>
                    <th width="5%">操作</th>
                </tr>
                <%
                    ArrayList<Customer> list = (ArrayList<Customer>) request.getAttribute("search");
                    for (int i = 0; i < list.size(); i++) {
                        Customer customers = list.get(i);
                %>
                <tr>
                    <td><%=customers.getCustomerid() %>
                    </td>
                    <td><%=customers.getName() %>
                    </td>
                    <td><%=customers.getPhone() %>
                    </td>
                    <td><%=customers.getIdcard() %>
                    </td>
                    <td><%=customers.getPwd() %>
                    </td>
                    <td><%=customers.getRegtime() %>
                    </td>
                    <td>
                        <a href="<%=root %>/CustomerServlet?m=delete&customerid=<%=customers.getCustomerid() %>">删除</a>
                        <a href="admin/upCustomer.jsp?customerid=<%=customers.getCustomerid() %>&name=<%=customers.getName() %>&phone=<%=customers.getPhone() %>&idcard=<%=customers.getIdcard() %>&pwd=<%=customers.getPwd() %>&regtime=<%=customers.getRegtime() %>">修改</a>
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
