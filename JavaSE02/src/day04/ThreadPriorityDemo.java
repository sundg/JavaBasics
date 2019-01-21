package day04;
/*
 * 线程的优先级
 */
public class ThreadPriorityDemo {
	public static void main(String[] args) {
		//最高优先级的线程
		Thread max=new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("max");
				}
			}
		};
		//最低优先级的线程
		Thread min=new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("min");
				}
			}
		};
		//默认优先级的线程
		Thread norm=new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("normal");
				}
			}
		};
		/*
		 * void setPriortity(int p)
		 * 设置当前线程的优先级
		 * 最高、最低、默认都有常量对应
		 */
		max.setPriority(Thread.MAX_PRIORITY);
		min.setPriority(Thread.MIN_PRIORITY);
		//这项设置可以省略，默认情况下就是这个值
		norm.setPriority(Thread.NORM_PRIORITY);
		/*
		 * 设置了优先级也不能100%控制线程调度，只是最大程度的告诉线程调
		 * 度以更多的几率分配时间片段给线程优先级高的线程
		 */
		min.start();
		norm.start();
		max.start();
	}
}
