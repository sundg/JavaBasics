<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<%@page import="bean.CartItem"%>
<%@page import="bean.Cart"%>
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
		<table cellSpacing="6" cellPadding="2" width="100%" border="0">
			<tbody>
				<tr>
					<td>
						<table class="guide" cellSpacing="0" cellPadding="0" width="100%"
							border="0">
							<tbody>
								<tr>
									<td>
										<a href='#'>主页</a>&nbsp;/&nbsp;
										<a href='computer_list.html'>笔记本订购(WEB007)</a>&nbsp;/&nbsp;购物车信息
									</td>
								</tr>
							</tbody>
						</table>
						<br />



						<table class="tableborder" cellSpacing="0" cellPadding="0"
							width="100%" border="0">
							<tbody>
								<tr class="header">
									<td class="altbg2" colspan="6">
										购物车信息
									</td>
								</tr>
							<tbody>
								<tr>
									<td class="altbg1" width="20%">
										<b>型号</b>
									</td>
									<td class="altbg1" width="20%">
										<b>价格</b>
									</td>
									<td class="altbg1" width="10%">
										<b>数量</b>
									</td>
									<td class="altbg1" width="30">
										&nbsp;
									</td>
									<td class="altbg1" width="10%">
										&nbsp;
									</td>
									<td class="altbg1">
										&nbsp;
									</td>
								</tr>
							</tbody>
							<tbody>
							<%
								Cart cart=(Cart)session.getAttribute("cart");
								if(cart==null){
									//恢复数据
									cart=new Cart();
									cart.load(CookieUtil.findCookie(request,"cart"));
									session.setAttribute("cart",cart);
								}
								if(cart!=null && cart.getItem().size()>0){
									List<CartItem> list=cart.getItem();
									for(int i=0;i<list.size();i++){
										CartItem item=list.get(i);
										%>
										<tr>
											<td class="altbg2">
												<%=item.getC().getModel() %>
											</td>
											<td class="altbg2">
												<%=item.getC().getPrice() %>
											</td>
											<td class="altbg2">
												<%=item.getQty() %>
											</td>
											<td class="altbg2">
												<input type="text" size="3" value=""
													id="num<%=item.getC().getId() %>" />
											</td>
											<td class="altbg2">
												<a href="javascript:;" 
												onclick="this.href='modify.dp?id=<%=item.getC().getId() 
												%>&qty='+document.getElementById('num<%=item.getC().getId() %>').value">更改数量</a>
											</td>
											<td class="altbg2">
												<a href="del.dp?id=<%=item.getC().getId() %>">删除</a>
											</td>
										</tr>
										
											<%
											
									}
									%>
									<tr>
											<td class="altbg1" colspan="6">
												<b>总价格：￥<%=cart.total() %></b>
											</td>
										</tr>
									
									<%
									
								}else{
								%>
									<tr>
									<td class="altbg2" colspan="6">
										<b>还没有选购商品</b>
									</td>
									</tr>
								<% 
								}
							%>
							</tbody>
							
						
							
						
						</table>

						<br />
						<center>
							<input class="button" type="button" value="返回商品列表"
								name="settingsubmit" onclick="location = 'list.dp';">
							<input class="button" type="button" value="清空购物车"
								name="settingsubmit"
								onclick="location = 'clear.dp';">
						</center>
					</td>
				</tr>
			</tbody>
		</table>

	</body>
</html>



