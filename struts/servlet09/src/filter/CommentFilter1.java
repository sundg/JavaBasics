package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentFilter1 implements Filter {
	private FilterConfig config;
	/**
	 * ������ɾ��filter֮ǰ��������ٵķ���
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * ����������init����֮�󣬻�ִ�и÷���
	 * FilterChain��������
	 * ֻ�е�������chain.doFilter(req,res)�����������Ż���û���Ĺ�������
	 * ���û�й�����������ú�����web���
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("filter1   doFilter.....");
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		//���ý����ʽ
		req.setCharacterEncoding("utf-8");
		//���ñ����ʽ
		res.setContentType("text/html;charset=utf-8");
		//��ȡ��ʼ������ֵ
		String value=config.getInitParameter("illegal");
		PrintWriter out=res.getWriter();
		//��ȡ��������
		String comment=req.getParameter("comment");
		//�ж��������Ƿ����dog
		if(comment.indexOf(value)>=0){
			//�������ݲ��Ϸ�
			out.print("�������ݲ��Ϸ�");
		}else{
//			out.print(comment);
			chain.doFilter(req, res);
		}

		
	}
	/**
	 * ������ʵ������Filter֮������Ż����init()����
	 * �����ڵ���init()����֮ǰ�����ȴ���FilterConfig����
	 * ͨ��config.getInitParameter("������")��ȡ����ʼ������ֵ
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter1  init..........");
		this.config=filterConfig;
	}

}
