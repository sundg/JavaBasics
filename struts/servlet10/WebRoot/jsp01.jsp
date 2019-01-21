<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		int num=10;
		int add(int a,int b){
			return a+b;
		}
	%>
	
	<%=num %><br/>
	<%=add(4,5) %>
	<%
		session.setAttribute("pwd","1243");
	%>
</body>
</html>