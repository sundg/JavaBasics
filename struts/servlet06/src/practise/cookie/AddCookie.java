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
 * �������cookie
 * 1������cookie
 * 		a��cookie��name��valueֻ�����ַ���
 * 		b�������������Ҫ����URLEncoder.encode(String str,String bm)
 * 2����cookie��ӵ�response��Ӧ����
 * @author Administrator
 *
 */
public class AddCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest req,HttpServletResponse res)
		throws ServletException,IOException{
		res.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		Cookie cookie=new Cookie("name",URLEncoder.encode("����", "utf-8"));
		//����cookie��Ĭ��·��
		cookie.setPath("/servlet06");
		//����cookie����ʱ��
		cookie.setMaxAge(60);
		res.addCookie(cookie);
		PrintWriter out=res.getWriter();
		out.print("�Ѵ�����Ϊ"+cookie.getName());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
