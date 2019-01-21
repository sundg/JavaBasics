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
//			throw new RuntimeException("没有豆子了");
//		}
	public int getBeans(){
		synchronized(new Object()){
			if(beans==0){
				throw new RuntimeException("没有豆子了");
			}
		}
		/*
		 * 让出CPU，当线程让出CPU(处理器)，离开Running状态，
		 * 使它进入Runnable等待状态
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
			 * 获取线程在纳入线程调度后被分配的名字
			 */
			System.out.println(getName()+","+bean);
			Thread.yield();
		}
	}
}
