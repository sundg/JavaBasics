package action;

import java.io.File;

import util.CopyFile;
/**
 * 
 * UploadFile�����������commons-io����ط�����
 * ���û��ϴ����ļ����浽��ʱĿ¼�£���ע���Action��
 * ��action��execute����ִ����ϣ��������ֽ���ʱ
 * �ļ��Ƴ���
 *
 */
public class UploadFileAction extends BaseAction {
	private File some;
	//��������ʽ     some+FileName
	private String someFileName;//Դ�ļ�����
	private String someContentType;//Դ�ļ�����
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
		//ͼƬ�����·��
		path="upload\\"+someFileName;
		String realPath=sc.getRealPath("upload");
		File dest=new File(realPath+"\\"+someFileName);
		CopyFile.copy(some, dest);
		return "success";
	}
}
