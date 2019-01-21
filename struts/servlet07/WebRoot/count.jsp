<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<%=response.encodeURL("count") %>">统计访问次数</a>
	<a href="#"><%=response.encodeURL("count") %></a>
	<a href="count">统计访问次数2(没有重写URL)</a>
</body>
</html>