<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="/ajax03/js/jquery-1.11.1.js"></script>

<script type="text/javascript" src="/ajax03/js/myjs.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	//页面加载完给链接绑定点击事件
	$(function(){
		//模拟鼠标连续点击事件
		$("table a").toggle(function(){
			//alert(1);
			//向服务器发请求，获取价格,将价格显示在div中
			$(this).next().load("airline.do",{"airline":$(this).text()});
		},function(){
			//	alert(2);
			//清空div中的价格
			$(this).next().empty();
		});
	});
</script>
</head>
<body>
	<table border="1" width="40%" cellspacing="0" cellspacing="0">
		<tr>
			<td>序号</td>
			<td>航班号</td>
		</tr>
		
		<tr>
			<td>1</td>
			<td><a href="javascript:;">CA1005</a><div></div></td>
		</tr>
		
		<tr>
			<td>2</td>
			<td><a href="javascript:;">CA1008</a><div></div></td>
		</tr>
	</table>
</body>
</html>