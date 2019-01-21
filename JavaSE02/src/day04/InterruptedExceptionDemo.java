package day04;

//中断异常
public class InterruptedExceptionDemo {
	public static void main(String[] args) {
		/*
		 * 小泽老师 表演者：处于睡眠阻塞的线程
		 * 
		 * 当一个方法中的局部内部类中需要引用该方法的其他局部变量，那么这个变量必须是final修饰的
		 */
		final Thread xiaoZe = new Thread() {
			public void run() {
				System.out.println("小泽：刚做完美容睡觉吧");
				try {
					/*
					 * 当一个线程处于睡眠阻塞时，若被其他线程调用interrupt()方法中断，
					 * 则sleep()方法会抛出InterruptedException异常
					 */
					Thread.sleep(1000000);
				} catch (InterruptedException e) {
					System.out.println("小泽：干嘛呢，干嘛呢，嘛呢");
				}
			}
		};
		/*
		 * 周老师 表演者：中断睡眠阻塞的线程
		 */
		Thread zhou = new Thread() {
			public void run() {
				System.out.println("周：开始砸墙~~~");
				for (int i = 0; i < 5; i++) {
					System.out.println("周：啪！");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("啪啪啪");
				System.out.println("周：搞定");
				xiaoZe.interrupt();//中断小泽的睡眠阻塞
			}
		};
		xiaoZe.start();
		zhou.start();
	}
}
