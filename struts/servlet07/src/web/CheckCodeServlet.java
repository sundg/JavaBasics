package web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckCodeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/jpeg");
//		System.out.println("checkCode service");
		//»­Í¼
		BufferedImage image=new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
		Graphics g=image.getGraphics();
		Random r=new Random();
		g.setColor(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
		g.fillRect(0, 0, 80, 30);//»­ÊµÐÄ¾ØÐÎ
		g.setFont(new Font(null, Font.ITALIC, 20));
		String num=getNum(5);
		g.setColor(Color.black);
		g.drawString(num, 5, 25);
		
		//»­Ïß
		for(int i=0;i<5;i++){
			g.setColor(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
			g.drawLine(r.nextInt(80), r.nextInt(30), r.nextInt(80), r.nextInt(30));
		}
		OutputStream os=response.getOutputStream();
		//Í¼Æ¬Ñ¹Ëõ
		ImageIO.write(image, "jpeg", os);
	
	}
	public String getNum(int length){
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
