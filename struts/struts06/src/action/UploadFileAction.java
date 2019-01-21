package action;

import java.io.File;

import util.CopyFile;
/**
 * 
 * UploadFile拦截器会调用commons-io的相关方法，
 * 将用户上传的文件保存到临时目录下，并注入给Action，
 * 在action的execute方法执行完毕，拦截器又将临时
 * 文件移除了
 *
 */
public class UploadFileAction extends BaseAction {
	private File some;
	//变量名格式     some+FileName
	private String someFileName;//源文件名称
	private String someContentType;//源文件类型
	private String path;
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSomeFileName() {
		return someFileName;
	}

	public void setSomeFileName(String someFileName) {
		this.someFileName = someFileName;
	}

	public String getSomeContentType() {
		return someContentType;
	}

	public void setSomeContentType(String someContentType) {
		this.someContentType = someContentType;
	}

	public File getSome() {
		return some;
	}

	public void setSome(File some) {
		this.some = some;
	}
	public String execute(){
		//图片的相对路径
		path="upload\\"+someFileName;
		String realPath=sc.getRealPath("upload");
		File dest=new File(realPath+"\\"+someFileName);
		CopyFile.copy(some, dest);
		return "success";
	}
}
