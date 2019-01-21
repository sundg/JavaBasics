	package web;
	
	import java.io.IOException;
	import java.io.PrintWriter;
	
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	
	
	
	public class HelloServlet extends HttpServlet {
		//序列化ID
		private static final long serialVersionUID = 1L;
		/*重写父类service方法
		 * 
		 *HttpServletRequest:请求对象
		 *HttpServletResponse:响应对象
		 */
		public void service(HttpServletRequest req,HttpServletResponse res)
		throws IOException,ServletException{
			//服务器默认的编码格式是ISO8859-1
			//通知浏览器，服务器返回的数据类型
			//通知服务器以utf-8的格式处理数据(编码)，通知浏览器以utf-8的格式解码
			res.setContentType("text/html;charset=utf-8");

			//设置服务器解码格式为utf-8，只对post请求有用
			req.setCharacterEncoding("utf-8");
			//根据参数名获取参数值
			String name=req.getParameter("name");
			int age=Integer.parseInt(req.getParameter("age"));
			String[] city=req.getParameterValues("city");
			//向页面输出hello world
			//获取字符输出流
			PrintWriter out=res.getWriter();
			out.println("<span style='color:red'>你好"+name+"</span><br/>");
			out.println("age="+age+"<br/>");
			for(String str:city){
				out.println(str+" ");
			}
			out.close();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
