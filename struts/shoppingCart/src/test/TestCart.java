package test;

import java.util.List;

import org.junit.Test;

import entity.Computer;

import bean.Cart;
import bean.CartItem;

public class TestCart {

	public static String test1(){
		Cart cart=new Cart();
		CartItem item=new CartItem();
		Computer com=new Computer();
		com.setId(1);
		item.setC(com);
		item.setQty(2);
		cart.add(item);
		
		
		CartItem item2=new CartItem();
		Computer com2=new Computer();
		com2.setId(2);
		item2.setC(com2);
		item2.setQty(3);
		cart.add(item2);
		
		String str=cart.store();
		System.out.println(str);
		return str;
	}
	@Test
	public void test2(){
		String str=TestCart.test1();
		Cart cart=new Cart();
		cart.load(str);
		List<CartItem> list=cart.getItem();
		System.out.println(list.size());
	}
	
	
	
	
	
	
	
	
	
}
