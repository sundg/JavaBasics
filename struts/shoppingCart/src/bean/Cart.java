package bean;

import java.util.ArrayList;
import java.util.List;

import util.DAOFactory;

import dao.ComputerDAO;
import entity.Computer;

/**
 * 为了方便操作购物车中的商品而封装的一个类
 * 查看购物车，删除，添加，修改数量，计价，清空
 * @author Administrator
 *
 */
public class Cart {
	private List<CartItem> list=new ArrayList<CartItem>();
	public boolean add(CartItem item){
		//判断list集合中是否包含item
		//如果有，返回false，添加失败
		//如果没有，将item添加到list中，返回true
		for(int i=0;i<list.size();i++){
			CartItem it=list.get(i);
			if(it.getC().getId()==item.getC().getId()){
				//添加过
				return false;
			}
		}
		list.add(item);
		return true;
	}
	//查看购物车
	public List<CartItem> getItem(){
		return list;
	}
	public void del(int id){
		for(int i=0;i<list.size();i++){
			CartItem item= list.get(i);
			if(item.getC().getId()==id){
				list.remove(item);
			}
		}
	}
	//修改数量
	public void modify(int id,int qty){
		for(int i=0;i<list.size();i++){
			CartItem item =list.get(i);
			if(item.getC().getId()==id){
				item.setQty(qty);
				return;
			}
		}
	}
	//计价
	public double total(){
		double total=0;
		for(int i=0;i<list.size();i++){
			CartItem item=list.get(i);
			total+=item.getC().getPrice()*item.getQty();
		}
		return total;
	}
	
	//清空
	public void clear(){
		list.clear();
	}
	
	
	//将list中的数据转成“1:2,2:3”字符串
	public String store(){
		StringBuffer sf=new StringBuffer();
		if(list.size()==0){
			return "0";
		}
		for(int i=0;i<list.size();i++){
			CartItem item=list.get(i);
			int id=item.getC().getId();
			int qty=item.getQty();
			sf.append(id+":"+qty+",");
		}
		sf.deleteCharAt(sf.length()-1);
		return sf.toString();
	}
	
	
	//将“1:2,2:3”字符串恢复成CartItem，并添加到集合中
	public void load(String content){
		if(content==null||"0".equals(content)){
			return;
		}
		String[] arrs=content.split(",");
		ComputerDAO dao=(ComputerDAO)DAOFactory.getInstance("ComputerDAO");
		for(String arr:arrs){
			int id=Integer.parseInt(arr.split(":")[0]);
			int qty=Integer.parseInt(arr.split(":")[1]);
			try {
				Computer c=dao.findById(id);
				CartItem item=new CartItem();
				item.setC(c);
				item.setQty(qty);
				list.add(item);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
}
