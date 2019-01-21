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
		//����������Ϊ�������ṩһЩȱʡ������
		FileItemFactory factory=new DiskFileItemFactory();
		
		//��ȡ������
		ServletFileUpload sfu=new ServletFileUpload(factory);
		//���ý����ʽ�����������ļ�����
//		sfu.setHeaderEncoding("utf-8");
		try {
			//��������ͨ��request.getInputStream()��ȡ��������
			//�����������������Ӧ�����ݷ�װ�ɼ��ϣ������д�ŵ���һ��
			//FileItem����һ��FileItem��Ӧ���ı���
			List<FileItem> list=sfu.parseRequest(request);
			for(int i=0;i<list.size();i++){
				FileItem item=list.get(i);
				//��ͨ����
				if(item.isFormField()){
					//��ȡ�ı�����name������
					String name=item.getFieldName();
					//��ȡ�ı�������е�����
					String value=item.getString("utf-8");
					System.out.println(name+"="+value);
				}else{
					try {
						//ʱ���
						//�Ƚ�ȡ��׺
						//new Date().getTime()+"."+��׺
						String fileName= item.getName();
						String path="upload/"+fileName;
						//�����߼�·���õ�����·��
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
