var val = sessionStorage.getItem("yh");
var yh = JSON.parse(val);
var $w = window.parent;
var fy=0;	//分页用，页面加载就是0；
var once=15;	//一次加载动态的数量
var llist;
var pages;
var i=0;
$(function(){
	$("#sc").parent().css("background-color","red");
	console.log(yh);
	checkyh();
	if (null != yh && "" != yh) {
		showDt(yh.uno);
	}
	$(parent.window).scroll(function() {
		$('#profile_details').css({
			top : $(parent.window).scrollTop() + 79.992
		});
	});
	
})
//判断动态图片是否有图，有则给空间显示，无则none
function ys(dtpicture) {
	if (dtpicture == null) {
		return "none";
	} else {
		return "inline-block";
	}
}
//删帖按钮（帖子删除连带其下的点赞和评论信息一块删除）
function dele(obj) {
	var zhe = obj;
	var dtbh = $(obj).parent().attr("id");

	$.post("/DietManagementSystem/DtController/deleteByDtno.do", {
		dtno : dtbh
	}, function(dtlist) {
		$(obj).parent().remove();
	})
	$.post("/DietManagementSystem/PlbController/deleteAndDt.do", {
		dtno : dtbh
	}, function(dtlist) {
	})
	$.post("/DietManagementSystem/LikesController/deleteAndDt.do", {
		dtno : dtbh
	}, function(dtlist) {
	})
	
}
//数据库查询我的动态item（只查询不处理）
function showDt(uno) {
	$.post("/DietManagementSystem/DtController/mySc.do",{uno:uno},function(dtlist) {
		console.log("动态列表",dtlist);
		llist=dtlist;
		fy=0;
		i=0;
		$("#item").empty();
		pages=Math.ceil(llist.length/once);		//总共的页数
		pjdtome();
		
		dzsj(); //点赞按钮添加事件
		plsj(); //评论按钮添加事件
		scsj();
		
		$w.reinitIframe();
	});
}
//给点赞按钮添加点击事件
function dzsj(){
	$(document).on("click", ".fax", function() {
		console.log("dainzang");
		var $zhe = $(this);
		if ($zhe.attr("value") == "false") {
			if (null == yh) {
				alert("请登录");
			} else {
				$.post("/DietManagementSystem/LikesController/add.do", {
					uno : yh.uno,
					dtno : $zhe.parent().parent().attr("id")
				}, function(dtlist) {
					$zhe.attr("src","img/world/Fax2.svg").attr("value","true").next().html(parseInt($zhe.next().html()) + 1);
				})
			}
		} else {
			$.post("/DietManagementSystem/LikesController/delete.do", {
				uno : yh.uno,
				dtno : $zhe.parent().parent().attr("id")
			}, function(dtlist) {
				$zhe.attr("src","img/world/Fax.svg").attr("value","false").next().html(parseInt($zhe.next().html()) - 1);
			})
	
		}
	});
}
//收藏按钮
function scsj(){
	$(document).on("click", ".collect", function() {
		var $zhe = $(this);
		if ($zhe.attr("value") == "false") {
			if (null == yh) {
				alert("请登录");
			} else {
				$.post("/DietManagementSystem/CollectController/add.do", {
					uno : yh.uno,
					dtno : $zhe.parent().parent().attr("id")
				}, function(dtlist) {
					$zhe.attr("src","img/world/Collect2.svg").attr("value","true").next().html(parseInt($zhe.next().html()) + 1);
				})
			}
		} else {
			$.post("/DietManagementSystem/CollectController/delete.do", {
				uno : yh.uno,
				dtno : $zhe.parent().parent().attr("id")
			}, function(dtlist) {
				$zhe.attr("src","img/world/Collect.svg").attr("value","false").next().html(parseInt($zhe.next().html()) - 1);
			})
	
		}
	});
}
//给评论按钮添加点击事件，并查询评论列表拼接
function plsj(){
	$(document).on("click",".message",function() {
		var $zhe = $(this);
		if ($zhe.attr("value") == "false") {
			if (null == yh) {
				alert("请登录");
			} else {
				$.post("/DietManagementSystem/PlbController/select.do", {
					dtno : $zhe.parent().parent().attr("id")
				}, function(pllist) {
					var $plitem = $zhe.parent().next().find(".pl");
					if (pllist.length > 0) {
						var llist;
						$plitem.empty();
						for (var i = 0; i < pllist.length; i++) {
							llist = pllist[i];
							$plitem.append($("<div>").addClass("pl_item").append(
									$("<span>").append($("<a>").attr("href", "#").append($("<img>").addClass("tx3").attr("src", "/DietManagementSystem/file/" + llist.photo)))).append(
									$("<span>").addClass("name_pl").append($("<div>").addClass("pl_name").html(llist.uname)).append($("<div>").addClass("pl_nr").html(llist.contain))
											.append($("<div>").addClass("pl_date").html(llist.pdate))));
						}
	
					}
					$zhe.attr("value", "true");
					$zhe.parent().next(".pl_out").fadeIn("normal");
					$w.reinitIframe();
				})
			}
		} else {
			$zhe.attr("value", "false");
			$zhe.parent().next(".pl_out").fadeOut("normal");
			$w.reinitIframe();
		}
	});
}

//加载我的动态item
function pjdtome(){
	fy++;
	console.log("fy",fy);
	console.log("pages",pages);
	var list;
	for(i;i<(once*fy+1);i++){
		if(i==llist.length){break;}
		list=llist[i];
		var dzl;
		if (list.like == true) {
			dzl = "img/world/Fax2.svg";
		} else {
			dzl = "img/world/Fax.svg";
		}
		var dzp;
		if (list.collect == true) {
			dzp = "img/world/Collect2.svg";
		} else {
			dzp = "img/world/Collect.svg";
		}
		$("#item").append(
				$("<div>").addClass("item").attr("id", list.dtno).append(
						$("<div>").addClass("head").append(
								$("<span>").append($("<a>").attr("href", "#").append($("<img>").attr("src", "/DietManagementSystem/file/" + list.photo).attr("title",list.dtno).addClass("tx2")))).append(
								$("<span>").addClass("head_name").html(list.uname)).append($("<span>").addClass("item_date").html(list.dtdate))).append(
						$("<div>").addClass("item_content").html(list.content)).append(
						$("<div>").addClass("photo").append($("<img>").addClass("pho").attr("src", "/DietManagementSystem/file/" + list.dtpictureo).css({
							display : ys(list.dtpictureo)
						})).append($("<img>").addClass("pho").attr("src", "/DietManagementSystem/file/" + list.dtpicturet).css({
							display : ys(list.dtpicturet)
						})).append($("<img>").addClass("pho").attr("src", "/DietManagementSystem/file/" + list.dtpictures).css({
							display : ys(list.dtpictures)
						})).append($("<img>").addClass("pho").attr("src", "/DietManagementSystem/file/" + list.dtpicturef).css({
							display : ys(list.dtpicturef)
						})).append($("<img>").addClass("pho").attr("src", "/DietManagementSystem/file/" + list.dtpictureff).css({
							display : ys(list.dtpictureff)
						})).append($("<img>").addClass("pho").attr("src", "/DietManagementSystem/file/" + list.dtpicturess).css({
							display : ys(list.dtpicturess)
						}))).append(
						$("<div>").addClass("item_fax")
							.append($("<img>").addClass("fax").attr("src", dzl).attr("value", list.like)).append($("<span>").addClass("sl").html(list.likes))
							.append($("<img>").addClass("message").attr("src", "img/world/Message.svg").attr("value", "false")).append($("<span>").addClass("sl").html(list.comments))
							.append($("<img>").addClass("collect").attr("src", dzp).attr("value", list.collect)).append($("<span>").addClass("sl").html(list.collects)))
						.append(
								$("<div>").addClass("pl_out").append($("<div>").addClass("tssj")).append($("<hr>")).append($("<div>").addClass("pl")).append(
										$("<form>").addClass("form1").append($("<input>").addClass("tjpl").attr("type", "text")).append(
												$("<input>").attr("type", "button").attr("value", "评论").attr("onclick", "tjpll(this,\"" + list.dtno + "\")"))))
							);
		$w.reinitIframe();
	}
}
function checkyh() {
	if (null != yh && "" != yh) {
		$("#name").html(yh.uname);
		$("#tx1").attr("src", "/DietManagementSystem/file/" + yh.photo);
	} else {

	}
};