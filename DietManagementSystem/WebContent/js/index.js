window.onresize = function() {
	reinitIframe();
}
function reinitIframe() {
	// 1.获取iframe
	var iframe = document.getElementById('menuFrame');
	// 2.获取iframe的body标签
	var body = iframe.contentWindow.document.body;
	// 3.获取iframe中body标签下的某个div的高度

	var ght = $(body).find("#container").height();
	if (ght < 623) {
		ght = 623;
	}
	// 4.改变iframe高度
	$("#menuFrame").attr("height", ght + 100);
}
function checkyh() {
	var val = sessionStorage.getItem("yh");
	var yh = JSON.parse(val);
	if (null != yh && "" != yh) {
		$("#login").css("display", "none");
		$("#user").css("display", "block");
		$("#yhm").text(yh.uname);
		$("#tx").attr("src", "/DietManagementSystem/file/" + yh.photo);
	} else {
		$("#login").css("display", "block");
		$("#user").css("display", "none");
	}
}
$(function() {
	checkyh();
	$("#user").mouseenter(function() {
		$("#user_menu").css("display","block");
	});
	$("#user_menu").mouseleave(function() {
		$("#user_menu").css("display","none");
	});

});
function exit() {
	$("#user_menu").css("display", "none");
	$('#menuFrame').attr('src', $('#menuFrame').attr('src'));
	sessionStorage.clear();
	checkyh();
}