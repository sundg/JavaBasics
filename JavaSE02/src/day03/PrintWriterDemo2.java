package day03;

import java.io.FileOutputStream;
import java.io.PrintWriter;

/*
 * ���Զ���ˢ�µĻ����ַ������
 */
public class PrintWriterDemo2 {
	public static void main(String[] args) throws Exception{
		FileOutputStream fos=new FileOutputStream("pw2.txt");
		/*
		 * 	PrintWriter(OutputStream out)	
		 * 	PrintWriter(OutputStream out,boolean autoFlush)
		 * ����һ�������Զ���ˢ�µĻ����ַ������
		 * ÿ������println()��ע���Ǵ��еķ���
		 * �ͻ���д����֮���Զ�����flush()		
		 */
		PrintWriter writer=new PrintWriter(fos,true);
		writer.print("�ǺǺ�");//������д���󣬻��Զ�����flush()������ˢ��
		writer.close();
	}
}
