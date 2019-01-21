package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

public class ImageUtil {
	/*
	 * ��ȡͼƬ
	 * key:��ȷ����֤��
	 * value:ͼƬ
	 */
	public static Map<String,BufferedImage> getImage(){
		//��ͼ
		BufferedImage image=new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
		//��û���
		Graphics g=image.getGraphics();
		Random r=new Random();
		g.setColor(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
		g.fillRect(0, 0, 80, 30);//��ʵ�ľ���
		g.setFont(new Font(null, Font.ITALIC, 20));
		String num=getNum(5);
		g.setColor(Color.black);
		g.drawString(num, 5, 25);
		//����
		for(int i=0;i<5;i++){
			g.setColor(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
			g.drawLine(r.nextInt(80), r.nextInt(30), r.nextInt(80), r.nextInt(30));
		}
		
		Map<String,BufferedImage> map=new HashMap<String, BufferedImage>();
		map.put(num, image);
		return map;
		
	}
	//��ͼƬת��������
	public static InputStream changeImage(BufferedImage image){
		//�����==��������
		//�ֽ����������
		ByteArrayOutputStream os=new ByteArrayOutputStream();
		InputStream in=null;
		//ѹ��ͼƬ
		try {
			ImageIO.write(image, "jpeg", os);
			byte[] bs=os.toByteArray();
			in=new ByteArrayInputStream(bs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return in;
	}
	
	
	
	
	
	
	public static String getNum(int length){
		String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
		Random rd=new Random();
		StringBuffer sf=new StringBuffer();
		for(int i=0;i<length;i++){
			int index=rd.nextInt(str.length());
			char c=str.charAt(index);
			sf.append(c);
		}
		return sf.toString();
	}

}
