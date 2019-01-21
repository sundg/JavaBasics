<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		Integer.parseInt("abc");
	--%>
	<%
		request.setAttribute("username","jack");
		pageContext.setAttribute("pwd","1234");
		
	%>
	<%=request.getAttribute("username") %>
	<%=pageContext.getAttribute("pwd") %>
	<a href="jsp03.jsp">点击跳转到jsp03页面</a>
</body>
</html>