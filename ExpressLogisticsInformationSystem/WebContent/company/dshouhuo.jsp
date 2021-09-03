<%@page import="com.lanqiao.team9.expresssystem.entity.Goods" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.lanqiao.team9.expresssystem.entity.Company" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <link rel="icon" href="../images/maomi.png" type="image/x-icon">
    <base target="_parent"/>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="<%=path %>/css/pintuer.css">
    <link rel="stylesheet" href="<%=path %>/css/admin.css">
</head>
<body>
<form method="post" action="">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder">待收货订单</strong></div>
        <div class="padding border-bottom">
        </div>
        <table class="table table-hover text-center">
            <tr>
                <th>序号</th>
                <th>订单编号</th>
                <th>货物信息</th>
                <th>寄件人</th>
                <th>寄件人手机号</th>
                <th>收件人</th>
                <th>收件人手机号</th>
                <th>付款方式</th>
                <th>订单金额</th>
                <th>创建时间</th>
                <th>操作</th>
            </tr>
            <% ArrayList<Goods> dshouhuo = (ArrayList<Goods>) request.getAttribute("dshouhuo");
                if (null != dshouhuo) {
                    for (int i = 0; i < dshouhuo.size(); i++) {
            %>
            <tr>
                <td><%=i + 1 %>
                </td>
                <td><%=dshouhuo.get(i).getGoodsid() %>
                </td>
                <td><%=dshouhuo.get(i).getCargo() %>
                </td>
                <td><%=dshouhuo.get(i).getSendername() %>
                </td>
                <td><%=dshouhuo.get(i).getSenderphone() %>
                </td>
                <td><%=dshouhuo.get(i).getReceivename() %>
                </td>
                <td><%=dshouhuo.get(i).getReceivephone() %>
                </td>
                <td><%=dshouhuo.get(i).getPay() %>
                </td>
                <td><%=dshouhuo.get(i).getMoney() %>
                </td>
                <td><%=dshouhuo.get(i).getCreationtime() %>
                </td>
                <td>
					<input type="button"  value="催收"/>
                </td>
            </tr>

            <%
                    }
                }
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