<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="entity.User"%>
<%@page import="entity.Emp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		User user=new User();
		user.setUserName("jack");
		user.setAge(10);
		Emp emp=new Emp();
		emp.setName("rose");
		user.setEmp(emp);
		user.setArrs(new String[]{"@","@@"});
		request.setAttribute("user1",user);
	%>
	<%
		User u=(User)request.getAttribute("user1");
		out.print(u.getUserName());
	%>
	<%
	User user2=new User();
	user2.setUserName("张上");
	user2.setAge(20);
	session.setAttribute("user1",user2);
	%>
	<h3>el表达式获取数据</h3>
	${user1.userName}<br/>
	${user1.age }<br/>
	${user1.emp.name }<br/>
	<!-- 可以指定查找的范围 -->
	${sessionScope.user1.userName }<br/>
	
	${user1["userName"] }<br/>
	
	${user1.arrs }<br/>
	
	<hr/>
	${user1.arrs[0] }
	<%
		request.setAttribute("paramAge","age");
	%>
	${user1[paramAge] }
	<hr/>
	${param.name }
	${paramValues.city[0] }
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>