package dayo5;
//使用wait()和notify()方法完成协同工作
public class WaitAndNotifyDemo {
		//表示图片是否下载完毕
		public static boolean isFinish=false;
		
		public static Object object=new Object();
		public static void main(String[] args) {
			//下载图片线程
			final Thread download=new Thread(){
				public void run(){
					System.out.println("download:开始下载图片");
					for(int i=0;i<=100;i++){
						System.out.println("download:已完成"+i+"%");
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("图片下载完毕");
					isFinish=true;//表示图片下载完毕
					synchronized(object){
						//通知object身上的等待的线程解除阻塞
						object.notify();
					}
					System.out.println("download:开始下载附件");
					for(int i=0;i<=100;i++){
						System.out.println("download:已完成"+i+"%");
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("附件下载完毕");
				}
			};
			//显示图片的线程
			Thread showImage=new Thread(){
				public void run(){
					System.out.println("show:准备显示图片");
					//等待下载线程工作结束后，再执行下面的代码
					try {
						/*
						 * wait()阻塞会在以下两种情况下被解除
						 * 1、当download线程结束
						 * 2、当调用了download的notify()
						 */
						synchronized(object){
							object.wait();
						}
						download.join();//先执行download
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(!isFinish){
						throw new RuntimeException("download:图片未下载完毕");
					}
					System.out.println("show:图片已经显示了");
				}
			};
			download.start();
			showImage.start();
	}
}
