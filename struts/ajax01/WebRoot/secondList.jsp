<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="/ajax01/js/my.js"></script>
<script type="text/javascript">
	function f1(value){
		var xhr=getXhr();
		xhr.open("post","secondList.do",true);
		xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
		var sel=document.getElementById("sec");
		sel.innerHTML="";
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4){
				var data=xhr.responseText;
				var arr=data.split(",");
				for(var i=0;i<arr.length;i++){
					var val=arr[i].split(":")[0];
					var text=arr[i].split(":")[1];
					//alert(val+"   "+text);
					var opt=document.createElement("option");
					opt.value=val;
					opt.innerText=text;
					sel.appendChild(opt);
				}
			}
		}
		xhr.send("value="+value);
	}
</script>
</head>
<body>
	<select onchange="f1(this.value);">
		<option value="s0">--请选择--</option>
		<option value="s1">第一阶段</option>
		<option value="s2">第二阶段</option>
		<option value="s3">第三阶段</option>
		<option value="s4">第四阶段</option>
	</select>
	<select id="sec">
		<option value="">--请选择--</option>
	</select>
</body>
</html>