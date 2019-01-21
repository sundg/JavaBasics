package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uri=request.getRequestURI();
		String action=uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		if("/checkUsername".equals(action)){
			//ģ����ʱ
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			String username=request.getParameter("username");
			if("����".equals(username)){
//				out.print("�ѱ�ռ��");
				out.print("error");
			}else{
//				out.print("����ʹ��");
				out.print("ok");
			}
			//ģ���쳣
			//throw new ServletException();
		}else if("/description".equals(action)){
			String film=request.getParameter("value");
			if("zl".equals(film)){
				out.print("��Ƭ");
			}else if("yldj".equals(film)){
				out.print("��Ƭ");
			}else if("ktl".equals(film)){
				out.print("�ڵ�");
			}
		}
		out.close();
	}

}
