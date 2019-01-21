package com.xms.netctoss.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageUtil {
	
	private static final String [] CHARS = 
		{"1","2","3","4","5","6","7","8","9"};
	
	private static final Integer SIZE = 4;
	private static final Integer WIDTH = 75;
	private static final Integer HEIGHT = 30;
	private static final Integer FONT_SIZE = 30;
	private static final Integer LINES = 20;
	
	//������֤��ͼƬ��Map�е�Key����֤��ͼƬ�ϵ����֣�
	//Value�ǰ�����֤�����ֵ�ͼƬ
	public static Map<String,BufferedImage> createImage(){
		StringBuffer sb = new StringBuffer();
		BufferedImage image = new BufferedImage(
				WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		
		//��ȡ���ʶ���
		Graphics phs = image.getGraphics();
		//���û�����ɫ
		phs.setColor(Color.WHITE);
		//������
		phs.fillRect(0,0,WIDTH,HEIGHT);
		
		Random random = new Random();
		
		//������ַ�
		for(int i=0;i<SIZE;i++){
			int x = random.nextInt(CHARS.length);
			phs.setColor(new Color(random.nextInt(256),
					random.nextInt(256),random.nextInt(256)));
			phs.setFont(new Font("����",Font.BOLD,FONT_SIZE));
			
			//���ַ�
			phs.drawString(CHARS[x],(i*WIDTH)/SIZE,WIDTH/3);
			sb.append(CHARS[x]);
		}
		
		//��������
		for(int i=0;i<LINES;i++){
			phs.setColor(new Color(random.nextInt(256),
					random.nextInt(256),random.nextInt(256)));
			phs.drawLine(
				random.nextInt(WIDTH),
				random.nextInt(HEIGHT),
				random.nextInt(WIDTH),
				random.nextInt(HEIGHT));
		}
		
		Map<String,BufferedImage> map =
			new HashMap<String, BufferedImage>();
		map.put(sb.toString(),image);
		
		return map;
	}
	
	//��ͼƬת�����ֽ�����
	public static byte [] changeImage(BufferedImage image){
		ByteArrayOutputStream baos = null;
		try{
			baos = new ByteArrayOutputStream();
			//ʹ��JPEGImageEncoder��ͼƬѹ������
			JPEGImageEncoder encoder =
				JPEGCodec.createJPEGEncoder(baos);
			encoder.encode(image);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return baos.toByteArray();
	}
}
