package bean;

import java.util.ArrayList;
import java.util.List;

import util.DAOFactory;

import dao.ComputerDAO;
import entity.Computer;

/**
 * Ϊ�˷���������ﳵ�е���Ʒ����װ��һ����
 * �鿴���ﳵ��ɾ������ӣ��޸��������Ƽۣ����
 * @author Administrator
 *
 */
public class Cart {
	private List<CartItem> list=new ArrayList<CartItem>();
	public boolean add(CartItem item){
		//�ж�list�������Ƿ����item
		//����У�����false�����ʧ��
		//���û�У���item��ӵ�list�У�����true
		for(int i=0;i<list.size();i++){
			CartItem it=list.get(i);
			if(it.getC().getId()==item.getC().getId()){
				//��ӹ�
				return false;
			}
		}
		list.add(item);
		return true;
	}
	//�鿴���ﳵ
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
	//�޸�����
	public void modify(int id,int qty){
		for(int i=0;i<list.size();i++){
			CartItem item =list.get(i);
			if(item.getC().getId()==id){
				item.setQty(qty);
				return;
			}
		}
	}
	//�Ƽ�
	public double total(){
		double total=0;
		for(int i=0;i<list.size();i++){
			CartItem item=list.get(i);
			total+=item.getC().getPrice()*item.getQty();
		}
		return total;
	}
	
	//���
	public void clear(){
		list.clear();
	}
	
	
	//��list�е�����ת�ɡ�1:2,2:3���ַ���
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
	
	
	//����1:2,2:3���ַ����ָ���CartItem������ӵ�������
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
