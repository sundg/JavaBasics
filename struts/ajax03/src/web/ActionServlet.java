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
		//服务器返回的数据类型如果是xml，需要设置contentType
		//response.setContentType("text/xml;charset=utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uri=request.getRequestURI();
		String action=uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		if("/movie".equals(action)){
			String value=request.getParameter("value");
			Movie movie=null;
			if("0".equals(value)){
				movie=new Movie("--请选择--","");
			}else if("zl".equals(value)){
				movie=new Movie("追龙","还不错");
			}else if("ktl".equals(value)){
				movie=new Movie("空天猎","很咋咧");
			}else if("yldj".equals(value)){
				movie=new Movie("英伦对决","一般");
			}
			String data=JSONObject.fromObject(movie).toString();
			out.print(data);
		}else if("/movie2".equals(action)){
			String value=request.getParameter("value");
			Movie movie=null;
			StringBuffer sf=new StringBuffer();
			sf.append("<msg>");
			if("0".equals(value)){
				sf.append("<name>--请选择--</name>");
				sf.append("<desc></desc>");
			}else if("zl".equals(value)){
				sf.append("<name>追龙</name>");
				sf.append("<desc>还不错</desc>");
			}else if("ktl".equals(value)){
				sf.append("<name>空天猎</name>");
				sf.append("<desc>很咋咧</desc>");
			}else if("yldj".equals(value)){
				sf.append("<name>英伦对决</name>");
				sf.append("<desc>一般</desc>");
			}
			sf.append("</msg>");
			out.print(sf.toString());
		}else if("/airline".equals(action)){
			String airline=request.getParameter("airline");
			if("CA1005".equals(airline)){
				out.print("价格：500元");
			}else if("CA1008".endsWith(airline)){
				out.print("价格：800元");
			}
		}
		out.close();
	}
}
