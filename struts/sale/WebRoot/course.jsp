<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="/ajax02/js/my.js"></script>
<script type="text/javascript" src="/ajax02/js/prototype-1.6.0.3.js"></script>
<script type="text/javascript" src="/ajax02/js/jquery-1.11.1.js"></script>
<style type="text/css">
	div{
		width:300px;
		height:100px;
		background-color: cyan;
		border:1px solid red;
	}
	
	a:link,a:visited{
	
	font-weight:bold;
	font-size:14px;
	font-family:Verdana, Arial, Helvetica, sans-serif;
	color:#FFFFFF;
	background-color:#98bf21;
	width:120px;
	text-align:center;
	padding:5px;
	text-decoration:none;
	margin:3px;
	}
	a:hover{
		background-color:gray;
	}
	
</style>
<script type="text/javascript">
	function f1(){
		var xhr=getXhr();
		xhr.open("get","course.do",true);
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4){
				var json_data=xhr.responseText;
				var js_data=json_data.evalJSON();
				for(i=0;i<js_data.length;i++){
					var id=js_data[i].id;
					var name=js_data[i].name;
					var $a=$("<a href='javascript:;' onclick='f2("+id+");'>"+name+"&nbsp;</a>");
					$("#first").append($a);
				}
			}
		}
		xhr.send(null);
		f2(1);
	}
	function f2(id){
		var xhr=getXhr();
		xhr.open("get","lore.do?id="+id,true);
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4){
				$("#second").html("<span>课程内容：</span>");
				var json_data=xhr.responseText;
				var js_data=json_data.evalJSON();
				console.log(js_data);
				for(i=0;i<js_data.length;i++){
					var id=js_data[i].id;
					var name=js_data[i].name;
					var $a=$("<a href='javascript:;'>"+name+"&nbsp;</a>");
					$a.attr({"id":id,"onclick":f3(id)});
					$("#second").append($a);
				}
			}
		}
		xhr.send(null);
	}
	function f3(){
		
	}
</script>
</head>
<body onload="f1();">
	<div id="first">
		<span>课程方向：</span>
	</div>
	<div id="second">
		<span>课程内容：</span>
	</div>
	
</body>
</html>