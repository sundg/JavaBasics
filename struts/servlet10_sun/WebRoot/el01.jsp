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
		user.setAge(21);
		user.setUsername("zhangsan");
		Emp emp=new Emp();
		emp.setId(1);
		emp.setName("zhangsan_01");
		user.setEmp(emp);
		user.setArrs(new String[]{"uzi","小虎"});
		pageContext.setAttribute("user_i",user);
	%>
<!-- 访问bean的属性 -->
	<!-- 根据绑定名获取对应的数据(Object对象) -->
	<h1>${user_i.emp.id }</h1>
	<h1>${user_i["emp"] }</h1>
	<h1>${user_i[emp] }</h1>
	<h1>${user_i["emp"].id }</h1>
	<h2>${user_i.arrs}</h2>
	<h2>${user_i.arrs[0]}</h2>
	<!-- 根据绑定名查找指定隐含对象的数据 -->
	<h1>${pageScope.user_i.emp.name }</h1>
	
<!-- 获取url路径参数 -->
	<span>
		${param.name }<br/>
		${paramValues.hobby[1] }
	</span>
	<hr/>
<!--判断el表达是的值是否为空  -->
	<h2>${1+3 }</h2>
	<h2>${empty ""}</h2>
	<h2>${empty null}</h2>
	<h2>${empty user_i["emp"]}</h2>
	
</body>
</html>