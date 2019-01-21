<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color:cyan">员工表</h1>
	<table width="60%" border="1" align="center" cellpadding="2" cellspacing="2">
		<tr>
			<th>员工号</th>			
			<th>姓名</th>			
			<th>薪水</th>			
			<th>奖金</th>			
			<th>入职日期</th>			
			<th>部门号</th>
			<th>操作</th>						
		</tr>
		<!-- 数据区域 -->
		<c:forEach items="${emps}" var="emp">
			<tr>
				<td>${emp.empno }</td>
				<td>${emp.ename }</td>
				<td>${emp.salary }</td>
				<td>${emp.bonus }</td>
				<td>${emp.hiredate }</td>
				<td>${emp.deptno }</td>
				<td align="center">
					<a href="javascript:;">修改</a>
					<a href="javascript:;">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>