package practise.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 需求：查找cookie
 * 1、调用request.getCookies()获取cookie对象数组
 * 2、遍历数组查找指定cookie对象
 * 3、返回cookie对象值
 * @author Administrator
 *
 */
public class FindCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Cookie[] cookies=request.getCookies();
		boolean flag=false; 
		if(cookies!=null){
			
		for(Cookie cs:cookies){
			if("name".equals(cs.getName())){
				flag=true;
				out.print("cookie的值为："+cs.getValue());
			}
		}
		}
		if(!flag){
			Cookie cookie=new Cookie(URLEncoder.encode("用户名","utf-8"),"username");
			response.addCookie(cookie);
			out.print("已创建"+URLDecoder.decode(cookie.getName(), "utf-8"));
		}
		out.close();
	}

}
