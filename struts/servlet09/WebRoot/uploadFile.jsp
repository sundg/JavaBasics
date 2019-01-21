<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="uploadFile" method="post" enctype="multipart/form-data">
		username:<input name="username"/>
		pwd:<input type="password" name="pwd"/>
		phone:<input type="file" name="phone"/>
		<input type="submit" value="上传"/>
	</form>
	<a href="del">删除</a>
</body>
</html>