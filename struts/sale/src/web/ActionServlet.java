package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import dao.CourseDAO;
import dao.LoreDAO;
import dao.SaleDAO;
import entity.Course;
import entity.Lore;
import entity.Sale;

import util.DAOFactory;

public class ActionServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uri=request.getRequestURI();
		String action=uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		SaleDAO dao=(SaleDAO) DAOFactory.getInstance("SaleDAO");
		CourseDAO cDao=(CourseDAO) DAOFactory.getInstance("CourseDAO");
		LoreDAO lDao=(LoreDAO) DAOFactory.getInstance("LoreDAO");
		if("/top".equals(action)){
			try {
				List<Sale> list=dao.findTop();
				String data=JSONArray.fromObject(list).toString();
				out.print(data);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("/course".equals(action)){
			try {
				List<Course> list=cDao.findAll();
				String data=JSONArray.fromObject(list).toString();
				out.print(data);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("/lore".equals(action)){
			int id=Integer.parseInt(request.getParameter("id"));
			try {
				List<Lore> list=lDao.findByCourseId(id);
				String data=JSONArray.fromObject(list).toString();
				out.print(data);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("/upload".equals(action)){
			
		}else if("/sun_course".equals(action)){
			try {
				List<Course> list;
				list = cDao.findAll();
				String data=JSONArray.fromObject(list).toString();
				out.print(data);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("/sun_lore".equals(action)){
			int id=Integer.parseInt(request.getParameter("id"));
			try {
				List<Lore> list=lDao.findByCourseId(id);
				String data=JSONArray.fromObject(list).toString();
				out.print(data);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		out.close();
	}

}
