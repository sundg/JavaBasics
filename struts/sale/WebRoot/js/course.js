var course={};//定义命名空间，避免多个js文件函数名冲突
//var course=course||{};
$(function(){
	//加载课程方向的所有内容
	course.loadCourse();
});


course.loadCourse=function(){
	$.ajax({
		"url":"course.do",
		"type":"post",
		"dataType":"json",
		"success":function(data){
			//根据服务器返回的数据生成<a>,并添加到第一个div中
			$.each(data,function(index,obj){
				//index:下标     obj:当前遍历的对象
				//console.log(obj);
				var $a=$("<a >"+obj.name+"</a>");
				//给链接a绑定点击事件
				$a.attr("id",obj.id);
				//调用方法
				
				$a.click(course.loadLore);
				$("#course").append($a);
				$("#course").append("&nbsp;");
			});
			//模拟触发课程方向链接的点击事件
			$("#course").children("a").first().trigger("click");
		},
		"error":function(){alert("系统繁忙");}
	});
}

//根据课程方向加载课程内容
course.loadLore=function(){
	//给所点击的链接加背景颜色
	$(this).addClass("current").siblings("a").removeClass("current");
	$.ajax({
		"url":"lore.do",
		"type":"post",
		"data":"id="+($(this).attr("id")),
		"dataType":"json",
		"success":function(data){
		//删除上一次创建的a链接与空格
		$("#lore .aLore").empty();
			$.each(data,function(index,obj){
				$a=$("<a href='javascript:;'>"+obj.name+"</a>");
				$("#lore .aLore").append($a);
				$("#lore .aLore").append("&nbsp;");
			});
		},
		"error":function(){alert("系统繁忙");}
	});
}