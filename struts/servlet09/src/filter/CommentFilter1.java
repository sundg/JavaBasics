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
	 * 容器在删除filter之前会调用销毁的方法
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 容器调用完init方法之后，会执行该方法
	 * FilterChain：过滤链
	 * 只有当调用了chain.doFilter(req,res)方法，容器才会调用或许的过滤器，
	 * 如果没有过滤器，则调用后续的web组件
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("filter1   doFilter.....");
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		//设置解码格式
		req.setCharacterEncoding("utf-8");
		//设置编码格式
		res.setContentType("text/html;charset=utf-8");
		//获取初始化参数值
		String value=config.getInitParameter("illegal");
		PrintWriter out=res.getWriter();
		//获取评论内容
		String comment=req.getParameter("comment");
		//判断内容中是否存在dog
		if(comment.indexOf(value)>=0){
			//评论内容不合法
			out.print("评论内容不合法");
		}else{
//			out.print(comment);
			chain.doFilter(req, res);
		}

		
	}
	/**
	 * 容器在实例化完Filter之后紧接着会调用init()方法
	 * 容器在调用init()方法之前，会先创建FilterConfig对象
	 * 通过config.getInitParameter("参数名")获取到初始化参数值
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter1  init..........");
		this.config=filterConfig;
	}

}
