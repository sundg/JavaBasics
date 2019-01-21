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
		width:500px;
		height:200px;
		background-color: cyan;
		border:1px solid red;
		margin-left:350px;
		margin-top:50px;
	}
</style>
<script type="text/javascript">
	function loadTop(){
		var xhr=getXhr();
		xhr.open("get","top.do",true);
		xhr.onreadystatechange=function(){
			$("#show").html("");
			//var $tr0=$("<tr></tr>");
			//var $td01=$("<td>商品名称</td>");
			//var $td02=$("<td>销售数量</td>");
			//$tr0.append($td01);
			//$tr0.append($td02);
			//$("#show").append($tr0);
			var saleInfo="当前销售最好的三件商品：<br/>";
			if(xhr.readyState==4){
				var json_data=xhr.responseText;
				var js_data=json_data.evalJSON();
				for(i=0;i<js_data.length;i++){
					var saleName=js_data[i].name;
					var saleQty=js_data[i].qty;
					
					saleInfo+="商品名称:"+saleName+"  销售数量:"+saleQty+"<br/>";
					$("#show").html(saleInfo);
					//var $tr=$("<tr></tr>");
					//var $td1=$("<td>"+saleName+"</td>");
					//var $td2=$("<td>"+saleQty+"</td>");
					//$tr.append($td1);
					//$tr.append($td2);
					//$("#show").append($tr);
				}
			}
		}
		xhr.send(null);
		console.log(Math.random());
	}
	function f1(){
		loadTop();
		window.setInterval(loadTop,3000);
	}
</script>
</head>
<body onload="f1();">
	<h3>当前销售最好的三件商品：</h3>
	<table >
		
	</table>
	<div id="show">
	
	</div>
</body>
</html>