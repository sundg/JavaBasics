	package web;
	
	import java.io.IOException;
	import java.io.PrintWriter;
	
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	
	
	
	public class HelloServlet extends HttpServlet {
		//���л�ID
		private static final long serialVersionUID = 1L;
		/*��д����service����
		 * 
		 *HttpServletRequest:�������
		 *HttpServletResponse:��Ӧ����
		 */
		public void service(HttpServletRequest req,HttpServletResponse res)
		throws IOException,ServletException{
			//������Ĭ�ϵı����ʽ��ISO8859-1
			//֪ͨ����������������ص���������
			//֪ͨ��������utf-8�ĸ�ʽ��������(����)��֪ͨ�������utf-8�ĸ�ʽ����
			res.setContentType("text/html;charset=utf-8");

			//���÷����������ʽΪutf-8��ֻ��post��������
			req.setCharacterEncoding("utf-8");
			//���ݲ�������ȡ����ֵ
			String name=req.getParameter("name");
			int age=Integer.parseInt(req.getParameter("age"));
			String[] city=req.getParameterValues("city");
			//��ҳ�����hello world
			//��ȡ�ַ������
			PrintWriter out=res.getWriter();
			out.println("<span style='color:red'>���"+name+"</span><br/>");
			out.println("age="+age+"<br/>");
			for(String str:city){
				out.println(str+" ");
			}
			out.close();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
