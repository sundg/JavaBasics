package bean;

import entity.Computer;

/**
 * ��Ʒ��Ŀ��
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
