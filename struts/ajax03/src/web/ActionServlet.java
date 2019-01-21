package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import entity.Movie;

public class ActionServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//���������ص��������������xml����Ҫ����contentType
		//response.setContentType("text/xml;charset=utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uri=request.getRequestURI();
		String action=uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		if("/movie".equals(action)){
			String value=request.getParameter("value");
			Movie movie=null;
			if("0".equals(value)){
				movie=new Movie("--��ѡ��--","");
			}else if("zl".equals(value)){
				movie=new Movie("׷��","������");
			}else if("ktl".equals(value)){
				movie=new Movie("������","��զ��");
			}else if("yldj".equals(value)){
				movie=new Movie("Ӣ�׶Ծ�","һ��");
			}
			String data=JSONObject.fromObject(movie).toString();
			out.print(data);
		}else if("/movie2".equals(action)){
			String value=request.getParameter("value");
			Movie movie=null;
			StringBuffer sf=new StringBuffer();
			sf.append("<msg>");
			if("0".equals(value)){
				sf.append("<name>--��ѡ��--</name>");
				sf.append("<desc></desc>");
			}else if("zl".equals(value)){
				sf.append("<name>׷��</name>");
				sf.append("<desc>������</desc>");
			}else if("ktl".equals(value)){
				sf.append("<name>������</name>");
				sf.append("<desc>��զ��</desc>");
			}else if("yldj".equals(value)){
				sf.append("<name>Ӣ�׶Ծ�</name>");
				sf.append("<desc>һ��</desc>");
			}
			sf.append("</msg>");
			out.print(sf.toString());
		}else if("/airline".equals(action)){
			String airline=request.getParameter("airline");
			if("CA1005".equals(airline)){
				out.print("�۸�500Ԫ");
			}else if("CA1008".endsWith(airline)){
				out.print("�۸�800Ԫ");
			}
		}
		out.close();
	}
}
