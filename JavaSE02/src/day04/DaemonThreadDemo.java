package day04;

/*
 * 后台线程
 */
public class DaemonThreadDemo {
	public static void main(String[] args) {
		/*
		 * 波多老师：前台线程
		 */
		String str=new String();
		Thread boDuo = new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("boDuo:let me jump!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("boDuo:啊啊啊啊啊啊啊");
				System.out.println("噗通");
			}
		};
		/*
		 * 周老师：后台线程
		 */
		Thread zhou = new Thread() {
			public void run() {
				while (true) {
					System.out.println("zhou:you jump!i jump!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		//设置后台线程:方法要在该线程被调用start()之前调用
		zhou.setDaemon(true);
		boDuo.start();
		zhou.start();
	}
}
