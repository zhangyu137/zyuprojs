$(function(){
	$(parent.window).scroll(function(){
			$('#meun').css({
				top : $(parent.window).scrollTop()+49.99
			});
		});
});
window.onresize = function () {
	reinitIframe1();
}
function reinitIframe1(){
	//1.获取iframe
	var iframe = document.getElementById('contFrame');
	//2.获取iframe的body标签
	var body = iframe.contentWindow.document.body;
	//3.获取iframe中body标签下的某个div的高度
	
	var ght = $(body).find("#container").height();
	console.log("子iframe高度："+ght)
	//4.改变iframe高度
	$("#contFrame").attr("height",ght+30);
}