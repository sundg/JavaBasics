package day04;
/*
 * 第一种创建线程的方式：继承Thread类
 */
public class ThreadDemo1  {
	public static void main(String[] args) {
		Thread t1=new Person1();
		Thread t2=new Person3();
		//启动线程要调用start()方法，而不是run()方法
		t1.start();
		t2.start();
		/*
		 * 使用多线程不应该再考虑执行的先后顺序
		 * 
		 * 执行有先后顺序的是同步运行
		 * 执行没有先后顺序的是异步运行(并发运行)
		 */
	}
}
//第一种创建线程的方式存在一个弊端：
//线程与线程之间要干的事情耦合在一起
class Person1 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("你是谁？");
		}
	}
}
class Person3 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("我是收电费的");
		}
	}
}
