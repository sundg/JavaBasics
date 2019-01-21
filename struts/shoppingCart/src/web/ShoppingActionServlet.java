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
				//����id��ѯcomputer��
				Computer comp=dao.findById(id);
				//����CartItem
				CartItem item=new CartItem();
				item.setC(comp);
				item.setQty(1);
				//���session
				HttpSession session=request.getSession();
				//��session�л�ȡcart����
				Cart cart=(Cart)session.getAttribute("cart");
				if(cart==null){
					//��һ�ι��򣬴����յĹ��ﳵ
					cart=new Cart();
					//��cookie�е����ݻָ���������
					cart.load(
							CookieUtil.findCookie(request, "cart")
					);
					session.setAttribute("cart", cart);
				}
				//cart.add(CartItem item)
				boolean flag=cart.add(item);
				if(flag){
					//����ɹ�
					//�����ݱ��ݵ�cookie��
					CookieUtil.addCookie("cart", cart.store(), 24*60*60, response);
					response.sendRedirect("list.dp");
				}else{
					request.setAttribute("buy_msg"+id, "�Ѿ������");
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
