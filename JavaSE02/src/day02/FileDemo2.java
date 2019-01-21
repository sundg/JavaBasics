package day02;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileDemo2 {
	public static void main(String[] args) {
		//方式一：
		File file=new File("."+File.separator+"src"+File.separator+"day01");
		List<File> list=listFile(file, ".java");
		System.out.println(list);
		//accept方法被回调执行，运行期间将比较规则最为参数传到方法中
		//方式二：
		System.out.println(listFile(new File("."+File.separator+"src"+File.separator+"day01")));
		//方式三：
		List<File> all=listFile(file,new Filter(){
			public boolean accept(File f){
				return f.isFile()&&f.getName().endsWith(".java");
			}
		});
		System.out.println(all);
		
		
		/*
		 * 列出dir的内容，将满足(accept)的文件作为返回值
		 *FileFilter的实例中封装了文件的比较方法
		 */
		//方式四：
		File dir=new File("./src/day01");
		File[] files=dir.listFiles(new FileFilter() {
			public boolean accept(File f) {
				return f.isFile()&&f.getName().endsWith(".java");
			}
		});
		System.out.println(Arrays.toString(files));
	}
	/*
	 * 列出扩展名为ext的文件，如：listFile(dir,".java")
	 * 目的：规定文件比较规则
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
	
	//比较规则接口
	interface Filter{
		//比较规则：抽象方法，是抽象的比较规则，在运行期实现
		boolean accept(File file);
	}
	
	/*
	 * 将文件的比较规则定义到Filter接口中，
	 * 要是变更文件的比较规则，只需要变更包含accept方法的参数就可以了
	 */
	public static List<File> listFile(File file,Filter filter){
		File[] files=file.listFiles();
		List<File> list =new ArrayList<File>();
		for(File sub:files){
			if(filter.accept(sub)){//将比较逻辑封装accept方法中
				list.add(sub);
			}
		}
		return list;
	}
	
	
	
	/*
	 * accept:接收
	 */
	public static boolean accept(File file){
		return file.isFile()&&file.getName().endsWith(".java");
	}
	public static List<File> listFile(File file){
		File[] files=file.listFiles();
		List<File> list =new ArrayList<File>();
		for(File sub:files){
			if(accept(sub)){//将比较逻辑封装accept方法中
				list.add(sub);
			}
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
