package day03;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
/*
 * ʹ��FileWriterд�ı��ļ�
 */
public class FileWriterDemo {
	public static void main(String[] args) throws Exception {
//		FileWriter writer=new FileWriter(new File("fw.txt"));
		/*
		 * ����ֱ�Ӷ��ļ�д�ַ�
		 * ʹ��FileWriter����FileReader
		 * ��Ĭ�������ʹ�õ�ǰϵͳĬ�ϵ��ַ������ж�д
		 */
		FileWriter writer=new FileWriter("fw.txt");
		BufferedWriter bw=new BufferedWriter(writer);
		bw.write("�ǺǺ�");
		bw.close();
	}
}
