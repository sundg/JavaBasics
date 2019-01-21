package day01.fileDemo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * java.io.File
 * File���ÿһ��ʵ������������һ���ļ���Ŀ¼����Ϣ
 */
public class FileDemo1 {
	public static void main(String[] args) throws IOException {
		//����·������ȡ�������ڳ���Ŀ�ƽ̨
		//File file=new File("D:\\Program Files\\Workspaces\\MyEclipse 8.6\\JavaSE02\\test.txt");
		
		/*
		 * ʹ�����·��
		 * "."��ʾ��ǰĿ¼������ĵ�ǰĿ¼ָ���ǵ�ǰ�������ڵ���Ŀ�ĸ�Ŀ¼
		 * 
		 * File�ĳ���separator:��ʾĿ¼�Ĳ㼶�ָ���
		 * 		��Windows����ϵͳ�£��ó�����ֵΪ�ַ���"\"
		 * 		��Linux����ϵͳ�£��ó�����ֵΪ�ַ���"/"
		 */
		File file=new File("."+File.separator+"test.txt");
		
		/*
		 * String getName()   
		 * ��ȡ�ļ���Ŀ¼������
		 */
		System.out.println(file.getName());
		
		/*
		 * long length()
		 * ��ǰ�ļ��Ĵ�С(�ֽ���)
		 */
		long length=file.length();
		System.out.println("�ļ��Ĵ�С��"+length);
		
		/*
		 * long lastModifiled()
		 * ��ȡ��ǰ�ļ�����޸ĵ�ʱ��
		 * longΪ1970��Ԫ�����޸���һ�̵ĺ���ֵ
		 */
		long lastModifiled=file.lastModified();
		System.out.println(lastModifiled);
		
		/*
		 * 2017��8��24��14��30��00
		 */
		Date date=new Date();
		System.out.println("date"+date);
		date.setTime(lastModifiled);
		SimpleDateFormat sdf=new SimpleDateFormat("y-M-d H:m:s");
		String lastDate=sdf.format(date);
		System.out.println(lastDate);
		
		/*
		 * String getPath()
		 * ��ȡ��ǰ�ļ���Ŀ¼��·��(���·��)
		 */
		System.out.println("path:"+file.getPath());
		/*
		 * String getAbsolutePath()
		 * ��ȡ����·��
		 */
		System.out.println("path:"+file.getAbsolutePath());
		
		/*
		 * String getCanonicalPath()
		 * ��ȡϵͳ��׼�ľ���·�����÷���Ҫ�󲶻��쳣
		 */
		System.out.println("canonical:"+file.getCanonicalPath());
		
		/*
		 * boolean exists()
		 * �鿴��ǰFile�����������ļ��Ƿ���ʵ����
		 */
		if(file.exists()){
			System.out.println("����");
		}else{
			System.out.println("������");
		}
		
		/*
		 * boolean isFile()
		 * �鿴��ǰfile�����������Ƿ�Ϊһ���ļ�
		 */
		if(file.isFile()){
			System.out.println("��һ���ļ�");
		}else{
			System.out.println("����һ���ļ�");
		}
		
		/*
		 * boolean isDirectory()
		 * �鿴��ǰ�����������Ƿ�Ϊһ��Ŀ¼
		 */
		if(file.isDirectory()){
			System.out.println("��һ��Ŀ¼");
		}else{
			System.out.println("����һ��Ŀ¼");
		}
		
		/*
		 * boolean canRead()
		 * �Ƿ�ɶ�
		 */
		if(file.canRead()){
			System.out.println("�ɶ�");
		}else{
			System.out.println("���ɶ�");
		}
		/*
		 * boolean canWrite()
		 * �Ƿ��д
		 */
		if(file.canWrite()){
			System.out.println("��д");
		}else{
			System.out.println("����д");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
