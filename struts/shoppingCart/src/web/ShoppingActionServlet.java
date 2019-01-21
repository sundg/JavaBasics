package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Cart;
import bean.CartItem;

import util.CookieUtil;
import util.DAOFactory;

import dao.ComputerDAO;
import entity.Computer;

public class ShoppingActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		ComputerDAO dao=(ComputerDAO)DAOFactory.getInstance("ComputerDAO");
		String uri=request.getRequestURI();
		String action=uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		if("/list".equals(action)){
			try {
				List<Computer> list=dao.findAll();
				request.setAttribute("list", list);
				request.getRequestDispatcher("computerList.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("/buy".equals(action)){
			int id=Integer.parseInt(request.getParameter("id"));
			try {
				//根据id查询computer表
				Computer comp=dao.findById(id);
				//构造CartItem
				CartItem item=new CartItem();
				item.setC(comp);
				item.setQty(1);
				//获得session
				HttpSession session=request.getSession();
				//从session中获取cart对象
				Cart cart=(Cart)session.getAttribute("cart");
				if(cart==null){
					//第一次购买，创建空的购物车
					cart=new Cart();
					//将cookie中的数据恢复到集合中
					cart.load(
							CookieUtil.findCookie(request, "cart")
					);
					session.setAttribute("cart", cart);
				}
				//cart.add(CartItem item)
				boolean flag=cart.add(item);
				if(flag){
					//购买成功
					//将数据备份到cookie中
					CookieUtil.addCookie("cart", cart.store(), 24*60*60, response);
					response.sendRedirect("list.dp");
				}else{
					request.setAttribute("buy_msg"+id, "已经购买过");
					request.getRequestDispatcher("list.dp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if("/modify".equals(action)){
			int id=Integer.parseInt(request.getParameter("id"));
			int qty=Integer.parseInt(request.getParameter("qty"));
			HttpSession session=request.getSession();
			Cart cart=(Cart)session.getAttribute("cart");
			cart.modify(id, qty);
			try {
				CookieUtil.addCookie("cart", cart.store(), 24*60*60, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("cartList.jsp");
		}else if("/del".equals(action)){
			int id=Integer.parseInt(request.getParameter("id"));
			HttpSession session=request.getSession();
			Cart cart=(Cart)session.getAttribute("cart");
			cart.del(id);
			try {
				CookieUtil.addCookie("cart", cart.store(), 24*60*60, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("cartList.jsp");
		}else if("/clear".equals(action)){
			HttpSession session=request.getSession();
			Cart cart=(Cart)session.getAttribute("cart");
			cart.clear();
			CookieUtil.delCookie("cart", response);
			response.sendRedirect("cartList.jsp");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
