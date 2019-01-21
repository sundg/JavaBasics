<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test2页面</h1>
	<h3>相对路径演示</h3>
	<a href="jsp1/test1.jsp">跳转到test1页面</a>
	
	<h3>绝对路径演示</h3>
	<a href="/servlet05/jsp1/test1.jsp">跳转到test1页面</a><br/>
	<!-- 动态的获取应用名 -->
	<a href="<%=request.getContextPath() %>/jsp1/test1.jsp">跳转到test1页面</a>
</body>
</html>