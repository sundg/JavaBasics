package bean;

import entity.Computer;

/**
 * 商品条目类
 * @author Administrator
 *
 */
public class CartItem {
	private Computer c;
	private int qty;
	
	public CartItem() {
	}
	public Computer getC() {
		return c;
	}
	public void setC(Computer c) {
		this.c = c;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
}
