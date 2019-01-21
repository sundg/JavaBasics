<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Insert title here</title>
	</head>
	<body>
		${1+3 }
		<br />
		${1+"3" }
		<br />
		<%--${1+"a" } --%>
		<%
			request.setAttribute("str", "ab");
		%>
		${"ab"==str }
		<%
			request.setAttribute("obj1","");
			request.setAttribute("obj2",null);
			List list=new ArrayList();
			request.setAttribute("obj3",list);
		%>
		${empty obj }<br/>
		${empty obj1 }<br/>
		${empty obj2 }<br/>
		${empty obj3 }<br/>


	</body>
</html>