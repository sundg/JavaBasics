package sun_web;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckedCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		BufferedImage image=new BufferedImage(100, 70, BufferedImage.TYPE_INT_RGB);
		
	}
	public String getCheckedCode(int length){
		String checkedText="ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
		StringBuffer checkedCode=new StringBuffer();
		Random rd=new Random();
		for(int i=0;i<length;i++){
			char c=checkedText.charAt(rd.nextInt(checkedText.length()));
			checkedCode.append(c);
		}
		return checkedCode.toString();
		
	}
}
