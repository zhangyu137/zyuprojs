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
        <form method="post" class="form-x" action="/ExpressLogisticsInformationSystem/CompanyServlet?m=updateforadmin">
            <div class="form-group">
                <div class="label">
                    <label>公司名：</label>
                </div>
                <div class="field">
                    <input type="text" readonly="readonly" class="input w50" name="companyName"
                           value="<%=request.getParameter("companyname")  %>"/>
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
                    <label>法人：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="corporation" value="<%=request.getParameter("corporation") %>"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>密码：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="pwd" value="<%=request.getParameter("pwd") %>"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>注册时间：</label>
                </div>
                <div class="field">
                    <input type="text" readonly="readonly" class="input" name="regtime"
                           value="<%=request.getParameter("regtime") %>"/>
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
                    <input class="button bg-main icon-check-square-o" type="button" value="提交"/>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
<script src="<%=path %>/js/jquery.js"></script>
<script src="<%=path %>/js/pintuer.js"></script>
<script type="text/javascript">

    //手机号校验
    function checkReceivephone() {
        var info = "";
        if (/^1\d{10}$/.test($("[name='phone']").val())) {
            return info;
        } else if ($("[name='phone']").val() === "") {
            info = "手机号不能为空";
            return info;
        } else {
            info = "手机号格式不对";
            return info;
        }
    }

    //密码校验
    function checkPwd() {
        var info = "";
        if (/^.{1,10}$/.test($("[name='pwd']").val())) {
            return info;
        } else if ($("[name='pwd']").val() === "") {
            info = "密码不能为空";
            return info;
        } else {
            info = "密码格式不对";
            return info;
        }
    }

    //法人校验
    function checkCorporation() {
        var info = "";
        if (/^[一-龥A-Za-z0-9]{2,20}$/.test($("[name='corporation']").val())) {
            return info;
        } else if ($("[name='corporation']").val() === "") {
            info = "法人不能为空";
            return info;
        } else {
            info = "法人格式不对";
            return info;
        }
    }

    //提交前校验
    function sure_confirm() {
        return event.returnValue = confirm("确定提交吗？");
    }

    function doSubmit() {
        if (checkReceivephone() != "") {
            $("#info").css("color", "red").html(checkReceivephone());
        } else if (checkCorporation() != "") {
            $("#info").css("color", "red").html(checkCorporation());
        } else if (checkPwd() != "") {
            $("#info").css("color", "red").html(checkPwd());
        } else {
            $("#info").css("color", "red").html("");
            if (sure_confirm()) {
                $("form").submit();
            } else {
                return false;
            }
        }
    }

    $("input[type='button']").click(function () {
        doSubmit();
    });
</script>
</html>