package day04;
/*
 * 第二种创建线程的方式：实现Runnable接口
 * 	将任务与线程解耦(任务与线程分离)
 */
public class ThreadDemo2 {
	public static void main(String[] args) {
		//创建任务
		Runnable r1=new Runnable1();
		Runnable r2=new Runnable2();
		/*
		 * 创建线程时再将任务指派
		 */
		Thread t1=new Thread(r1);
		Thread t2=new Thread(r2);
		t1.start();
		t2.start();
	}
}

class Runnable1 implements Runnable{


	public void run() {
		for(int i=0;i<1000;i++){
			System.out.println("你是谁？");
		}
		
	}
	
}

class Runnable2 implements Runnable{


	public void run() {
		for(int i=0;i<1000;i++){
			System.out.println("我是收电费的");
		}
		
	}
	
}