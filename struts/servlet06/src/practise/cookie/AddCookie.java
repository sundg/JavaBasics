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
 * 需求：添加cookie
 * 1、创建cookie
 * 		a、cookie的name与value只能是字符串
 * 		b、如果是中文需要编码URLEncoder.encode(String str,String bm)
 * 2、将cookie添加到response响应对象
 * @author Administrator
 *
 */
public class AddCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest req,HttpServletResponse res)
		throws ServletException,IOException{
		res.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		Cookie cookie=new Cookie("name",URLEncoder.encode("哈哈", "utf-8"));
		//设置cookie的默认路径
		cookie.setPath("/servlet06");
		//设置cookie存在时长
		cookie.setMaxAge(60);
		res.addCookie(cookie);
		PrintWriter out=res.getWriter();
		out.print("已创建名为"+cookie.getName());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
