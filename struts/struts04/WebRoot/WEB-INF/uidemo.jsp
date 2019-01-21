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
	<form theme="simple">
		username:<input name="username" value="${emp.username }"/><br/>
		pwd:<input name="pwd" value="${emp.pwd }"/><br/>
		sex:
		<s:if test='emp.sex=="m"'>
			<input type="radio" name="sex" value="m" checked="checked"/>man
			<input type="radio" name="sex" value="f"/>female
		</s:if>
		<s:else>
			<input type="radio" name="sex" value="m" />man
			<input type="radio" name="sex" value="f" checked="checked"/>female
		</s:else>
		<hr/>
		<s:form>
			<s:textfield name="emp.username" label="用户名"></s:textfield>
			<s:password name="emp.pwd" label="密码" showPassword="true"></s:password>
			<%-- #{'m':"男",'f':"女"} --%>
			<s:radio list="map" name="emp.sex"></s:radio>
			<s:select list="#{'bj':'北京','nj':'南京','tj':'天津'}" name="emp.city" label="城市"></s:select>
			<s:checkboxlist list="#{'sleeping':'睡觉','cooking':'做饭','dancing':'跳舞'}" name="emp.ins" label="兴趣"></s:checkboxlist>
			<s:textarea name="emp.username" label="自我介绍" cols="50" rows="20"></s:textarea>
		</s:form>
	</form>
</body>
</html>