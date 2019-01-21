
<%@page pageEncoding="utf-8" import="java.util.Date"%>
<html>
	<head>
	</head>
	<body>
		<h1>Hello JSP</h1>
		
		<%
			for(int i=0;i<10;i++){
				out.print("你好 jsp<br/>");
			}
		%>
		<br/>
		<%
			Date date=new Date();
			out.print(date);
		%>
		<br/>
		<!-- 
			相当于out.print(new Date());
		 -->
		<%=new Date() %>
	</body>
</html>