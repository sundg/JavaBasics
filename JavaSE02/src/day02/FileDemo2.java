package day02;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileDemo2 {
	public static void main(String[] args) {
		//��ʽһ��
		File file=new File("."+File.separator+"src"+File.separator+"day01");
		List<File> list=listFile(file, ".java");
		System.out.println(list);
		//accept�������ص�ִ�У������ڼ佫�ȽϹ�����Ϊ��������������
		//��ʽ����
		System.out.println(listFile(new File("."+File.separator+"src"+File.separator+"day01")));
		//��ʽ����
		List<File> all=listFile(file,new Filter(){
			public boolean accept(File f){
				return f.isFile()&&f.getName().endsWith(".java");
			}
		});
		System.out.println(all);
		
		
		/*
		 * �г�dir�����ݣ�������(accept)���ļ���Ϊ����ֵ
		 *FileFilter��ʵ���з�װ���ļ��ıȽϷ���
		 */
		//��ʽ�ģ�
		File dir=new File("./src/day01");
		File[] files=dir.listFiles(new FileFilter() {
			public boolean accept(File f) {
				return f.isFile()&&f.getName().endsWith(".java");
			}
		});
		System.out.println(Arrays.toString(files));
	}
	/*
	 * �г���չ��Ϊext���ļ����磺listFile(dir,".java")
	 * Ŀ�ģ��涨�ļ��ȽϹ���
	 */
	public static List<File> listFile(File file,String ext){
		List<File> list=new ArrayList<File>();
		File[] files=file.listFiles();
		for(File sub:files){
			if(sub.isFile()&&sub.getName().endsWith(".java"))
				list.add(sub);
		}
		return list;
	}
	
	//�ȽϹ���ӿ�
	interface Filter{
		//�ȽϹ��򣺳��󷽷����ǳ���ıȽϹ�����������ʵ��
		boolean accept(File file);
	}
	
	/*
	 * ���ļ��ıȽϹ����嵽Filter�ӿ��У�
	 * Ҫ�Ǳ���ļ��ıȽϹ���ֻ��Ҫ�������accept�����Ĳ����Ϳ�����
	 */
	public static List<File> listFile(File file,Filter filter){
		File[] files=file.listFiles();
		List<File> list =new ArrayList<File>();
		for(File sub:files){
			if(filter.accept(sub)){//���Ƚ��߼���װaccept������
				list.add(sub);
			}
		}
		return list;
	}
	
	
	
	/*
	 * accept:����
	 */
	public static boolean accept(File file){
		return file.isFile()&&file.getName().endsWith(".java");
	}
	public static List<File> listFile(File file){
		File[] files=file.listFiles();
		List<File> list =new ArrayList<File>();
		for(File sub:files){
			if(accept(sub)){//���Ƚ��߼���װaccept������
				list.add(sub);
			}
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
