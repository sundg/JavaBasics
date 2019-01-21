<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@page import="util.DAOFactory"%>
<%@page import="dao.EmpDAO"%>
<%@page import="java.util.List"%>
<%@page import="entity.Emp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//WDOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<%@include file="header.jsp" %>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Welcome!
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								Name
							</td>
							<td>
								Salary
							</td>
							<td>
								Age
							</td>
							<td>
								Operation
							</td>
						</tr>
						<%--
							List<Emp> list=(List<Emp>)request.getAttribute("list");
							
						--%>
						<c:forEach items="${list}" var="emp" varStatus="i">
							<tr class="row${i.count%2+1}">
							<td>
								${emp.id}
							</td>
							<td>
								${emp.name}
							</td>
							<td>
								${emp.salary}
							</td>
							<td>
								${emp.age}
							</td>
							<td>
								<a href="del.do?id=${emp.id}">delete emp</a>&nbsp;
								<a href="load.do?id=${emp.id}">update emp</a>
							</td>
						</tr>
						</c:forEach>
						
						
					</table>
					<p>
						<input type="button" class="button" value="addEmp" onclick="location='addEmp.jsp'"/>
						<a href="logout.do">退出exit</a>
					</p>
				</div>
			</div>
			<%@include file="footer.jsp" %>
		</div>
	</body>
</html>
