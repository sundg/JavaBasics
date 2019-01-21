package day03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
 * BOS��BIS
 * �������Ĺ��ܣ�
 * 		�ڲ�ά��һ�������������ڼ��ٶ�д��������߶�дЧ��
 */
public class BufferInputStreamDemo {
	public static void main(String[] args) throws Exception{
		FileInputStream fis=new FileInputStream("tomcat-6.0.35.rar");
		FileOutputStream fos=new FileOutputStream("tomcatCopy.rar");
		BufferedInputStream bis=new BufferedInputStream(fis);
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		int d=-1;
		long start=System.currentTimeMillis();
		while((d=bis.read())!=-1){
			bos.write(d);
		}
		long end=System.currentTimeMillis();
		System.out.println(end-start);
		fis.close();
		fos.close();
		bis.close();
		bos.close();
	}
}
