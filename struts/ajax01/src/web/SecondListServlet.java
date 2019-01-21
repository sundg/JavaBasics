package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondListServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uri=request.getRequestURI();
		String action=uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		if("/secondList".equals(action)){
			String str;
			String val=request.getParameter("value");
			if("s0".equals(val)){
				out.print("s0:--«Î—°‘Ò--");
			}else if("s1".equals(val)){
				str="oop:oop,core:core,se:se";
				out.print(str);
			}else if("s2".equals(val)){
				str="html:html,css:css,jdbc:jdbc";
				out.print(str);
			}else if("s3".equals(val)){
				str="servlet:servlet,jsp:jsp,ajax:ajax";
				out.print(str);
			}else if("s4".equals(val)){
				str="struts:struct,spring:spring,springMVC:springMVC";
				out.print(str);
			}
		}
		out.close();
	}

}
