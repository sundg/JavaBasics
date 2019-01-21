<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<%@page import="entity.Computer"%>
<%@page import="util.DBUtil"%>
<%@page import="util.CookieUtil"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv=Content-Type content="text/html; charset=utf-8" />
		<link href="css/main/style.css"
			type="text/css" rel="stylesheet" />
	</head>
	<body topMargin="10">
		<div id="append_parent"></div>
		<table cellSpacing=6 cellPadding=2 width="100%" border="0">
			<tbody>
				<tr>
					<td>
						<table class="guide" cellSpacing="0" cellPadding="0" width="100%"
							border="0">
							<tbody>
								<tr>
									<td>
										<a href='#'>主页</a>&nbsp;/&nbsp;
										<a href='#'>笔记本订购(WEB007)</a>&nbsp;/&nbsp;商品列表
									</td>
								</tr>
							</tbody>
						</table>
						<br />

						<table class="tableborder" cellSpacing="0" cellPadding="0"
							width="100%" border="0">
							<tbody>
								<tr class="header">
									<td class="altbg1" width="15%">
										<b>型号</B>
									</td>
									<td class="altbg1" width="20%">
										<b>产品图片</b>
									</td>
									<td class="altbg1" width="30%">
										<b>产品说明</b>
									</td>

									<td class="altbg1" width="10%">
										<b>产品报价</b>
									</td>
									<td class="altbg1">
									</td>
								</tr>
							</tbody>
							
							<%
								List<Computer> list=(List<Computer>)request.getAttribute("list");
								for(int i=0;i<list.size();i++){
									Computer computer=list.get(i);
							%>
							<tbody>
							<tr>
									<td class="altbg2">
										&nbsp;&nbsp;<%=computer.getModel()%>>
									</td>
									<td class="altbg2">
										<img src="img/d007/<%=computer.getPic()%>" width="150"
											height="90" />
									</td>
									<td class="altbg2">
										<%=computer.getProDesc()%>
									</td>


									<td class="altbg2">
										￥<%=computer.getPrice()%>
									</td>
									<td class="altbg2">
											<a href="buy.dp?id=<%=computer.getId()%>">购买</a>
											<%
												String buy_msg=(String)request.getAttribute("buy_msg"+computer.getId());
											%>
											
											<span style="color: red">
												<%=buy_msg==null?"":buy_msg %>
											</span>
										</td>
								</tr>
								</tbody>
							<% }%>
								
							
						</table>
						<br />
						<center>
							<input class="button" type="button" value="查看购物车"
								name="settingsubmit" onclick="location = 'cartList.jsp';">
						</center>
					</td>
				</tr>
			</tbody>
		</table>

	</body>
</html>