package day04;
/*
 * 
 */
public class SyncDemo {
	public static void main(String[] args) {
		Table table=new Table();
		Thread t1=new Person4(table);
		Thread t2=new Person4(table);
		t1.start();
		t2.start();
		
	}
}

class Table{
	int beans=20;
//	public synchronized int getBeans(){
//		if(beans==0){
//			throw new RuntimeException("û�ж�����");
//		}
	public int getBeans(){
		synchronized(new Object()){
			if(beans==0){
				throw new RuntimeException("û�ж�����");
			}
		}
		/*
		 * �ó�CPU�����߳��ó�CPU(������)���뿪Running״̬��
		 * ʹ������Runnable�ȴ�״̬
		 */
		Thread.yield();
		return beans--;
	}
}
class Person4 extends Thread{
	private Table table;

	public Person4(Table table) {
		this.table = table;
	}
	public void run(){
		while(true){
			int bean=table.getBeans();
			/*
			 * String getName()
			 * ��ȡ�߳��������̵߳��Ⱥ󱻷��������
			 */
			System.out.println(getName()+","+bean);
			Thread.yield();
		}
	}
}
