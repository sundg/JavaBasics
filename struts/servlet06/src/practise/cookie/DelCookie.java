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
 * 需求：删除cookie
 * 1、创建一个同名的cookie覆盖要删除的cookie
 * 2、执行删除操作
 * @author Administrator
 *
 */
public class DelCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Cookie cookie=new Cookie(URLEncoder.encode("用户名", "utf-8"),"");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		out.close();
	}

}
