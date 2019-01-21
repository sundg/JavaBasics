package web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//创建工厂，为解析器提供一些缺省的配置
		FileItemFactory factory=new DiskFileItemFactory();
		
		//获取解析器
		ServletFileUpload sfu=new ServletFileUpload(factory);
		//设置解码格式，避免中文文件乱码
//		sfu.setHeaderEncoding("utf-8");
		try {
			//解析器会通过request.getInputStream()获取参数流，
			//并分析该流，将其对应的数据封装成集合，集合中存放的是一个
			//FileItem对象，一个FileItem对应着文本域
			List<FileItem> list=sfu.parseRequest(request);
			for(int i=0;i<list.size();i++){
				FileItem item=list.get(i);
				//普通表单域
				if(item.isFormField()){
					//获取文本域中name的属性
					String name=item.getFieldName();
					//获取文本输入框中的数据
					String value=item.getString("utf-8");
					System.out.println(name+"="+value);
				}else{
					try {
						//时间戳
						//先截取后缀
						//new Date().getTime()+"."+后缀
						String fileName= item.getName();
						String path="upload/"+fileName;
						//根据逻辑路径得到物理路径
						ServletContext sc=getServletContext();
						path=sc.getRealPath(path);
						sc.setAttribute("path", path);
						System.out.println("path="+path);
						item.write(new File(path));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		out.close();
	}

}
