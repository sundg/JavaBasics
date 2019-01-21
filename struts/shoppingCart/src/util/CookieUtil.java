package util;



import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CookieUtil {
	private static final long serialVersionUID = 1L;
	
	public static final String path="/shoppingCart";
	//Ìí¼Ócookie
	public static void addCookie(String name,String value,int age,HttpServletResponse res) throws Exception{
		Cookie cookie=new Cookie(name, URLEncoder.encode(value,"utf-8"));
		cookie.setMaxAge(age);
		cookie.setPath(path);
		res.addCookie(cookie);
	}
	//²éÕÒcookie
	public static String findCookie(HttpServletRequest request,String name) throws Exception{
		String cookieValue=null;
		Cookie[] cs=request.getCookies();
		if(cs==null){
			return null;
		}
		for(Cookie cookie:cs){
			if(name.equals(cookie.getName())){
				cookieValue=URLDecoder.decode(cookie.getValue(), "utf-8");
				break;
			}
		}
		return cookieValue;
	}
	//É¾³ýcookie
	public static void delCookie(String name,HttpServletResponse response){
		Cookie c=new Cookie(name,"");
		c.setPath(path);
		//Á¢¼´É¾³ý
		c.setMaxAge(0);
		response.addCookie(c);
	}
}
