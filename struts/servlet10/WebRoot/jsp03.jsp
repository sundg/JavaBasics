<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%=request.getAttribute("username") %>
	<%=pageContext.getAttribute("pwd") %>
	
	<%=config.getInitParameter("city") %>
	
	<!-- 
		<%
		Date date1=new Date();
		out.print(date1);
	%>
	 -->
	 <%--
		Date date=new Date();
		out.print(date);
	--%>
	<jsp:include page="index.jsp"></jsp:include>
</body>
</html>