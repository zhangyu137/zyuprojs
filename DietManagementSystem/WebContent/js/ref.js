var $w = window.parent;
function ss(){
	$("#span1").html("查询结果");
	$("#table1").css("display","none");
	
	$("#table2").empty().append($("<tr>")
						.append($("<th>").css("color","black").html("食物图片"))
						.append($("<th>").css("color","black").html("食物名"))
						.append($("<th>").css("color","black").html("热量"))
					)
	$.post("/DietManagementSystem/FoodController/list.do",{fname:form1.text_input.value},function(llist){
		var list;
		for(var i=0;i<llist.length;i++){
			list=llist[i];
			$("#table2").append($("<tr>")
								.append($("<th>")
									.append($("<img>").attr("src","/DietManagementSystem/file/"+list.fpicture).addClass("sstp").attr("title",list.fno)))
								.append($("<th>").html(list.fname))
								.append($("<th>").html(list.foodrl))
							)
			$w.reinitIframe();
		}
		
					
	})
}