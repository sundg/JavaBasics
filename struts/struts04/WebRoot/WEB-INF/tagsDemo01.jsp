<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	${name }
	<!-- 显示标签 -->
	<s:property value="name"/>
	<!-- 循环 -->
	<s:iterator value="list">
		<s:property value="username"/>
	</s:iterator>
	
	<s:iterator value="strList">
		<!-- 获取栈顶的数据 等同于value="top"的写法 -->
		<s:property/>
	</s:iterator>
	
	<s:iterator begin="1" end="5" var="p">
		<s:debug></s:debug>
		<s:property value="#p"/>
		${p }
	</s:iterator>
	<br/>
	<s:if test="age>18">成年人</s:if>
	<s:else>未成年</s:else>
</body>
</html>