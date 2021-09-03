<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%	
   		request.setCharacterEncoding("utf-8");
    	String path = request.getContextPath();
    	String goodsid = request.getParameter("goodsId").trim();
    	String cargo = request.getParameter("cargo").trim();
    	String receivename = request.getParameter("receivename").trim();
    	String receivephone = request.getParameter("receivephone").trim();
    	String receiveidcard = request.getParameter("receiveidcard").trim();
    	String receiveadd = request.getParameter("receiveadd").trim();
    	String pay = request.getParameter("pay").trim();
    	String money = request.getParameter("money").trim();
    	String status = request.getParameter("status").trim();
    	String s = request.getParameter("s").trim();
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
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改订单信息</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="/ExpressLogisticsInformationSystem/GoodsServlet?m=GupdateGoodsInfoForCompany&s=<%=s%>">
            <div class="form-group">
                <div class="label">
                    <label>订单编号：</label>
                </div>
                <div class="field">
                    <input type="text" readonly="readonly"class="input" name="goodsid" value="<%=goodsid %>"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>货品信息：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="cargo" value="<%=cargo %>"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>收件人姓名：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="receivename" value="<%=receivename %>"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>收件人手机号：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="receivephone" value="<%=receivephone %>"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>收件人身份证：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="receiveidcard" value="<%=receiveidcard %>"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>收件人地址：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="receiveadd" value="<%=receiveadd %>"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>付款方式：</label>
                </div>
                <div class="field">
                    <select name="pay">
						<option value="现付">现付</option>
						<option value="到付">到付</option>
				 	 </select>
                </div>
            </div>
            
            <div class="form-group">
                <div class="label">
                    <label>金额：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="money" value="<%=money %>"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>状态：</label>
                </div>
                <div class="field">
                    <select name="status">
						<option value="待接收订单">待接收订单</option>
						<option value="待发货订单">待发货订单</option>
						<option value="运途中订单">运途中订单</option>
						<option value="待收货订单">待收货订单</option>
						<option value="收货成功订单">收货成功订单</option>
						<option value="撤销截胡">撤销截胡</option>
				 	 </select>
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
        if (/^1\d{10}$/.test($("[name='receivephone']").val())) {
            return info;
        } else if ($("[name='receivephone']").val() === "") {
            info = "手机号不能为空";
            return info;
        } else {
            info = "手机号格式不对";
            return info;
        }
    }

    //名字校验
    function checkReceivename() {
        var info = "";
        if (/^[一-龥A-Za-z0-9]{2,20}$/.test($("[name='receivename']").val())) {
            return info;
        } else if ($("[name='receivename']").val() === "") {
            info = "姓名不能为空";
            return info;
        } else {
            info = "姓名格式不对";
            return info;
        }
    }
  //身份证校验
    function checkReceiveidcard(){
    	var info = "";
    	if(/^\d{17}(\d|x|X)$/.test($("[name='receiveidcard']").val())){
    		return info;
    	}else if($("[name='receiveidcard']").val()==""){
    		info = "身份证号不能为空";
    		return info;
    	}
    	else{
    		info="身份证号格式不对";
    		return info;
    	}
    }
  //地址校验
    function checkReceiveadd(){
    	var info = "";
    	if(/^[一-龥A-Za-z0-9]{2,60}$/.test($("[name='receiveadd']").val())){
    		return info;
    	}else if($("[name='receiveadd']").val()==""){
    		info = "收件人地址不能为空";
    		return info;
    	}
    	else{
    		info="地址无法识别";
    		return info;
    	}
    }
  //现金校验
    function checkMoney(){
    	var info = "";
    	if(/^[1-9]\d{0,2}$/.test($("[name='money']").val())){
    		return info;
    	}else if($("[name='money']").val()==""){
    		info = "现金不能为空";
    		return info;
    	}
    	else{
    		info="金额过大";
    		return info;
    	}
    }
    //提交前校验
    function sure_confirm() {
        return event.returnValue = confirm("确定提交吗？");
    }

    function doSubmit() {
        if (checkReceivename() != "") {
            $("#info").css("color", "red").html(checkReceivename());
        } else if (checkReceivephone() != "") {
            $("#info").css("color", "red").html(checkReceivephone());
        } else if (checkReceiveidcard() != "") {
            $("#info").css("color", "red").html(checkReceiveidcard());
        } else if (checkReceiveadd() != "") {
            $("#info").css("color", "red").html(checkReceiveadd());
        } else if (checkMoney() != "") {
            $("#info").css("color", "red").html(checkMoney());
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