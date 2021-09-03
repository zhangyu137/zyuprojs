var val = sessionStorage.getItem("yh");
var yh = JSON.parse(val);
var $w = window.parent;
var fy=0;	//分页用，页面加载就是0；
var once=15;	//一次加载动态的数量
var llist;
var pages;
var i=0;
$(function(){
	$("#glpl").parent().css("background-color","red");
	checkyh();
	if(yh!=null&&yh!=""){
		 lb();
	}
	$(parent.window).scroll(function() {
		$('#profile_details').css({
			top : $(parent.window).scrollTop() + 79.992
		});
	});
})
//删除评论
function plsc(obj){
	$.post("/DietManagementSystem/PlbController/delete.do", {
		plno : $(obj).parent().parent().attr("id")
	}, function(dtlist) {
		$(obj).parent().parent().remove();
	})
}
function cx(){
	if(yh!=null&&yh!=""){
		lb(cxxx.xxdtno.value,cxxx.xxdtnr.value);
	}
}
function checkyh() {
	if (null != yh && "" != yh) {
		$("#name").html(yh.uname);
		$("#tx1").attr("src", "/DietManagementSystem/file/" + yh.photo);
	} else {

	}
}
function ys(dtpicture) {
	if (dtpicture == null) {
		return "none";
	} else {
		return "inline-block";
	}
}
function lb(no,nr) {
	var para={
		dtno:no,
		contain:nr,
		uname:yh.uname
	};
	$(".pl1").empty();
	$.post("/DietManagementSystem/PlbController/selectForYh.do",para,function(dtlist) {
		console.log("信息列表",dtlist);
		llist=dtlist;
		fy=0;
		i=0;
		pages=Math.ceil(dtlist.length/once);		//总共的页数
		pjdtome();
		
		$w.reinitIframe();
	});
}

function pjdtome(){
	fy++;
	console.log("fy",fy);
	console.log("pages",pages);
	var list;
	for(i;i<(once*fy+1);i++){
		if(i==llist.length){break;}
		list=llist[i];
		$(".pl1").append($("<div>").addClass("pl_item").attr("id",list.plno).append(
				$("<span>").append($("<a>").attr("href", "#").append($("<img>").addClass("tx3").attr("src", "/DietManagementSystem/file/" + list.photo)))).append(
				$("<span>").addClass("name_pl")
						.append($("<div>").addClass("pl_dtno").html("to: "+list.dtno))
						.append($("<div>").addClass("pl_name").html(list.uname))
						.append($("<div>").addClass("pl_delete").attr("onclick","plsc(this)"))
						.append($("<div>").addClass("pl_nr").html(list.contain))
						.append($("<div>").addClass("pl_date").html(list.pdate))));
	}
	$w.reinitIframe();
}
