package day01;
/*
 * throws关键字：
 * 	该关键字用于在声明方法时连同声明该方法可能抛出的异常种类，
 * 	以通知使用者在调用该方法时应当捕获这些异常
 * 
 * 俗话：丑话说在前面
 * 
 * 什么时候该抛出异常，什么时候捕获异常
 * 总结：分清责任关系
 */
public class ExceptionDemo5 {
	public static void main(String[] args) {
		try {
			test(1,0,2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * 先使用a/b，之后再将商加上c返回
	 */
	public static int test(int a,int b,int c) throws Exception{
		/*
		 * 当我们调用的方法会平抛出异常，而我们的方法不关心
		 * 这个异常时，我们可以采取在当前方法上声明throws，
		 * 将该方法的异常抛给调用者
		 */
		return divide(a,b)+c;
	}
	
	
	
	//除法操作
	/*
	 * 当方法中抛出一个异常时，该方法的声明就应该书写throws来声明该异常的抛出
	 */
	public static int divide(int a,int b) throws Exception{
		if(b==0){
			throw new Exception("除数不能为0");
		}
		return a/b;
	}
}
