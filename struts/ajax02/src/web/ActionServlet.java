package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import entity.City;

public class ActionServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uri=request.getRequestURI();
		String action=uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		String course=null;
		if("/course".equals(action)){
			//��ȡ�γ̽׶�
			String value=request.getParameter("value");
			if("-1".equals(value)){
				out.print("-1:--��ѡ��--");
			}else if("one".equals(value)){
				course="basic:BASIC,oop:OOP";
				out.print(course);
			}else if("two".equals(value)){
				course="html:HTML,jdbc:JDBC";
				out.print(course);
			}else if("three".equals(value)){
				course="servlet:SERVLET,ajax:AJAX";
				out.print(course);
			}else if("four".equals(value)){
				course="struts:STRUTS,spring:SPRING";
				out.print(course);
			}
		}else if("/city".equals(action)){
			String value=request.getParameter("city");
			City city=null;
			String data=null;
			List<City> list=new ArrayList<City>();
			if("-1".equals(value)){
				city=new City();
				city.setName("-1");
				city.setValue("--��ѡ��--");
				list.add(city);
				data=JSONArray.fromObject(list).toString();
				out.print(data);
			}else if("s1".equals(value)){
				city=new City();
				city.setName("�Ͼ�");
				city.setValue("nj");
				list.add(city);
				city=new City();
				city.setName("����");
				city.setValue("ha");
				list.add(city);
				city=new City();
				city.setName("����");
				city.setValue("sz");
				list.add(city);
				data=JSONArray.fromObject(list).toString();
				out.print(data);
			}else if("s2".equals(value)){
				city=new City();
				city.setName("�Ϸ�");
				city.setValue("hf");
				list.add(city);
				city=new City();
				city.setName("����");
				city.setValue("mg");
				list.add(city);
				city=new City();
				city.setName("����");
				city.setValue("bb");
				list.add(city);
				data=JSONArray.fromObject(list).toString();
				out.print(data);
			}else if("s3".equals(value)){
				city=new City();
				city.setName("����");
				city.setValue("hz");
				list.add(city);
				city=new City();
				city.setName("����");
				city.setValue("jx");
				list.add(city);
				city=new City();
				city.setName("ƽ��");
				city.setValue("ph");
				list.add(city);
				data=JSONArray.fromObject(list).toString();
				out.print(data);
			}
		}
		out.close();
	}

}
