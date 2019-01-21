package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport {
	//定义与标签属性名相同的成员变量，并提供get/set方法
	private String msg;
	private int qty;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		System.out.println("msg="+msg);
		this.msg = msg;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		System.out.println("qty="+qty);
		this.qty = qty;
	}




	public void doTag() throws JspException, IOException {
		//父类SimpleTagSupport
		//通过pageContext可以获取其他8个隐含对象
		PageContext pc=(PageContext) getJspContext();
		JspWriter out=pc.getOut();
		for(int i=0;i<qty;i++){
			out.print(msg+"<br/>");
		}
	}

}
