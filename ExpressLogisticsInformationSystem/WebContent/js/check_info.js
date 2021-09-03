/**
 * info中表单校验
 */

//姓名判空
function checkReceivename(){
	var info = "";
	if(/^[一-龥A-Za-z0-9]{2,20}$/.test($("[name='receivename']").val())){
		return info;
	}else if($("[name='receivename']").val()==""){
		info = "姓名不能为空";
		return info;
	}
	else{
		info="名字不对";
		return info;
	}
}
//手机号校验
function checkReceivephone(){
	var info = "";
	if(/^1\d{10}$/.test($("[name='receivephone']").val())){
		return info;
	}else if($("[name='receivephone']").val()==""){
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

function sure_confirm() 
{
	return event.returnValue = confirm("确定提交吗？");
}
//提交前校验
function doSubmit(){
	if(checkReceivename()!="" ){
		$("#info").css("color","red").html(checkReceivename());
	}else if(checkReceivephone()!=""){
		$("#info").css("color","red").html(checkReceivephone());
	}else if(checkReceiveidcard()!=""){
		$("#info").css("color","red").html(checkReceiveidcard());
	}else if(checkReceiveadd()!=""){
		$("#info").css("color","red").html(checkReceiveadd());
	}else{
		if(sure_confirm()){
		$("form").submit();
		}else{
			return false;
		}
	}
}
$("#submit").click(function(){
	doSubmit();
});