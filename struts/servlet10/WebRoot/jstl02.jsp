<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="entity.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sun/myTag" prefix="c1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
	.row1{
		background-color: red;
	}
	.row2{
		background-color: cyan;
	}
</style>
</head>
<body>
	<%
		User user=new User();
		user.setUserName("jack");
		user.setAge(10);
		request.setAttribute("user",user);
		
		User user2=new User();
		user2.setUserName("jack");
		user2.setAge(12);
		List<User> list=new ArrayList<User>();
		list.add(user);
		list.add(user2);
		request.setAttribute("list",list);
	%>
	<c:if test="${user.age>=18}" var="f" scope="request">成年了</c:if>
	<%--<c:if test="${user.age<18}">未成年</c:if> --%>
	<c:if test="${!f}">未成年</c:if>
	
	<c:choose>
		<c:when test="${user.age>=18}">大了</c:when>
		<c:otherwise>还小</c:otherwise>
	</c:choose>
	
	<table border="1px">
		<tr>
			<td>name</td>
			<td>age</td>
			<c:forEach items="${list}" var="u" varStatus="vs">
				<tr class="row${vs.count%2+1 }">
				<td>${u.userName }</td>
				<td>${u.age }</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
	<!-- jsp标签在服务器端执行 -->
	<c1:forInfo qty="10" msg="hello"/>
	
	<c1:date pattern="yyyy/MM_dd hh:mm:ss"/>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>