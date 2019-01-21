var sun_course={};
$(function(){
	sun_course.loadCourse();
});

sun_course.loadCourse=function(){
	$.ajax({
		"url":"sun_course.do",
		"type":"post",
		"dataType":"json",
		"success":function(data){
			$.each(data,function(index,obj){
				var $sel=$("<option></option>");
				$sel.attr("value",obj.id);
				$sel.text(obj.name);
				$("#course").append($sel);
				$sel.change(sun_course.loadLore);
			});
		},
		"error":function(){alert("系统繁忙")}
		
	});
}

sun_course.loadLore=function(){
	$.ajax({
		"url":"sun_lore.do",
		"type":"post",
		"data":"id="+$(this).attr("id"),
		"dataType":"json",
		"success":function(data){
			$.each(data,function(index,obj){
				var $opt=$("<option></option>");
				$opt.attr("value",obj.id);
				$opt.text(obj.name);
				$("#lore").append($opt);
			});
		},
		"error":function(){alert("系统繁忙");}
		
	});
}











