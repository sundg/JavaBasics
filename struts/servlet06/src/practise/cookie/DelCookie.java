package practise.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ����ɾ��cookie
 * 1������һ��ͬ����cookie����Ҫɾ����cookie
 * 2��ִ��ɾ������
 * @author Administrator
 *
 */
public class DelCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Cookie cookie=new Cookie(URLEncoder.encode("�û���", "utf-8"),"");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		out.close();
	}

}
