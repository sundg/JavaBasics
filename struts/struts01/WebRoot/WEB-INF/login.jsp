<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login.action" method="post">
		用户名：<input name="user.username"/><br/>
		密码：<input type="password" name="user.pwd"/><br/>
		<input type="submit" value="登录" />
		<span style="color:red">
			${msg }
		</span>
	</form>
</body>
</html>