var course={};//���������ռ䣬������js�ļ���������ͻ
//var course=course||{};
$(function(){
	//���ؿγ̷������������
	course.loadCourse();
});


course.loadCourse=function(){
	$.ajax({
		"url":"course.do",
		"type":"post",
		"dataType":"json",
		"success":function(data){
			//���ݷ��������ص���������<a>,����ӵ���һ��div��
			$.each(data,function(index,obj){
				//index:�±�     obj:��ǰ�����Ķ���
				//console.log(obj);
				var $a=$("<a >"+obj.name+"</a>");
				//������a�󶨵���¼�
				$a.attr("id",obj.id);
				//���÷���
				
				$a.click(course.loadLore);
				$("#course").append($a);
				$("#course").append("&nbsp;");
			});
			//ģ�ⴥ���γ̷������ӵĵ���¼�
			$("#course").children("a").first().trigger("click");
		},
		"error":function(){alert("ϵͳ��æ");}
	});
}

//���ݿγ̷�����ؿγ�����
course.loadLore=function(){
	//������������Ӽӱ�����ɫ
	$(this).addClass("current").siblings("a").removeClass("current");
	$.ajax({
		"url":"lore.do",
		"type":"post",
		"data":"id="+($(this).attr("id")),
		"dataType":"json",
		"success":function(data){
		//ɾ����һ�δ�����a������ո�
		$("#lore .aLore").empty();
			$.each(data,function(index,obj){
				$a=$("<a href='javascript:;'>"+obj.name+"</a>");
				$("#lore .aLore").append($a);
				$("#lore .aLore").append("&nbsp;");
			});
		},
		"error":function(){alert("ϵͳ��æ");}
	});
}