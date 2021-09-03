<%@page import="java.util.ArrayList" %>
<%@page import="com.lanqiao.team9.expresssystem.entity.Goods" %>
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
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="<%=path %>/css/pintuer.css">
    <link rel="stylesheet" href="<%=path %>/css/admin.css">
</head>
<body>
<form method="post" action="">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder">代发货订单</strong></div>
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

            <% ArrayList<Goods> dfahuo = (ArrayList<Goods>) request.getAttribute("dfahuo");
                if (null != dfahuo) {
                    for (int i = 0; i < dfahuo.size(); i++) {
                    	Goods good = dfahuo.get(i);
            %>
            <tr>
                <td><%=i + 1 %>
                </td>
                <td><%=good.getGoodsid() %>
                </td>
                <td><%=good.getCargo() %>
                </td>
                <td><%=good.getSendername() %>
                </td>
                <td><%=good.getSenderphone() %>
                </td>
                <td><%=good.getReceivename() %>
                </td>
                <td><%=good.getReceivephone() %>
                </td>
                <td><%=good.getPay() %>
                </td>
                <td><%=good.getMoney() %>
                </td>
                <td><%=good.getCreationtime() %>
                </td>
                <td>
                	<input type="button" onclick="javascrtpt:window.location.href='/ExpressLogisticsInformationSystem/GoodsServlet?m=GupdateForTransportForCompany&goodsId=<%=good.getGoodsid() %>&status=2'" value="发货"/>
                	<input type="button" onclick="javascrtpt:window.location.href='/ExpressLogisticsInformationSystem/GoodsServlet?m=GupdateForTransportForCompany&goodsId=<%=good.getGoodsid() %>&status=5&s=1'" value="截胡"/>
                	<input type="button" onclick="javascrtpt:window.location.href='ExpressLogisticsInformationSystem/company/gd.jsp?goodsId=<%=good.getGoodsid() %>
                    &cargo=<%=good.getCargo() %>&senderphone=<%=good.getSenderphone() %>&senderidcard=<%=good.getSenderidcard() %>
                    &senderadd=<%=good.getSenderadd() %>&receivename=<%=good.getReceivename() %>&receivephone=<%=good.getReceivephone() %>
                    &receiveidcard=<%=good.getReceiveidcard() %>&receiveadd=<%=good.getReceiveadd() %>&pay=<%=good.getPay() %>
                    &money=<%=good.getMoney() %>&status=<%=good.getStatus() %>&s=1'" value="修改"/>
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