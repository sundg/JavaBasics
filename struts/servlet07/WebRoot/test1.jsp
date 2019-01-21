<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	验证码：<img id="img1" alt="" src="checkCode" onclick="this.src='checkCode?'+new Date().getTime()">
	<a href="javascript:;" onclick="document.getElementById('img1').src='checkCode?'+new Date().getTime()">看不清换一张</a>
</body>
</html>