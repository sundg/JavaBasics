<%@page import="entity.User"%>
<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@page import="util.DAOFactory"%>

<%@page import="java.util.List"%>


<!DOCTYPE html PUBLIC "-//WDOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>userlist</title>
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
						<%
							List<User> list=(List<User>)request.getAttribute("list");
							for(int i=0;i<list.size();i++){
								User user=list.get(i);
						%>
							<tr class="row<%=i%2+1%>">
							<td>
								<%=user.getId()%>
							</td>
							<td>
								<%=user.getUsername()%>
							</td>
							<td>
								<%=user.getName() %>
							</td>
							<td>
								<%=user.getPwd() %>
							</td>
							<td>
								<%=user.getSex() %>
							</td>
							<td>
								<a href="del.do?id=<%=user.getId()%>">delete emp</a>&nbsp;
								<a href="load.do?id=<%=user.getId()%>">update emp</a>
							</td>
						</tr>
						<%
							}
						%>
						
						
					</table>
					<p>
						<input type="button" class="button" value="addUser" onclick="location='addEmp.jsp'"/>
					</p>
				</div>
			</div>
			<%@include file="footer.jsp" %>
		</div>
	</body>
</html>
