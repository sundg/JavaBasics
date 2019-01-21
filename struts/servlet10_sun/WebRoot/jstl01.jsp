<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="entity.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!-- 引入jstl标签库 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		user.setAge(17);
		user.setUsername("lisi");
		session.setAttribute("user",user);
		
		User user2=new User();
		user2.setAge(17);
		user2.setUsername("lisi");
		List<User> list=new ArrayList<User>();
		list.add(user);
		list.add(user2);
		session.setAttribute("list",list);
	%>
	<!-- if判断
		test:返回boolean值，true执行
		var:为test的结果设置绑定名
		scope:指定var的绑定对象(pageContext,request,session,application)
	 -->
	<c:if test="${user.age>18}" var="f" scope="request">${user.age}</c:if>
	<c:if test="${!f}">${f}</c:if>
	<!-- choose选择 -->
	<c:choose>
		<c:when test="${user.username=='zhangs'}">${empty user.username}</c:when>
		<c:otherwise>${user.username}</c:otherwise>
	</c:choose>
	<!-- for循环
		items:指定需要遍历的集合
		var:指定绑定名，绑定值为遍历集合的元素
		varStatus:指定绑定名，绑定值为java对象，封装遍历的数据，如index、count 
	 -->
	<table>
		<tr>
			<td>name</td>
			<td>ags</td>
		</tr>
		<c:forEach items="${list}" var="user" varStatus="vs">
			<tr class="row${vs.index%2+1 }">
				<td>${user.age }</td>
				<td>${user.username }</td>
			</tr>
		</c:forEach>
	</table>
	<sun:userInfo qty="" msg=""/>
</body>
</html>