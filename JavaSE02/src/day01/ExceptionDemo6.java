package day01;
/**
 * java中的异常分为检查异常和非检查异常
 * 	非检查异常：RuntimeException及其子类
 * 		RuntimeException是Exception的子类
 * 		当程序中抛出(throw)了一个RuntimeException，获取子类时，编译器
 * 		会在编译时不检查该类异常是否被处理(主动try catch或throws)
 * 	检查异常：
 * 		除了RuntimeException及其子类
 * 		这些异常若在程序中被抛出，编译时会检查该类异常是否有处理代码，没有则编译不通过
 * 
 * RuntimeException的常用子类
 * 		1、NullPointerException
 * 		2、ArrayIndexOutOfBoundsException
 * 		3、StringIndexOutOfBoundsException
 * 		4、ClassCastException
 * 		5、NumberFormatException
 * 		....
 * @author Administrator
 *
 */
public class ExceptionDemo6 {
	public static void main(String[] args) {
		try {
			Object o="123";
			Integer i=(Integer)o;
			System.out.println(i);
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
	}
	public static void test(int a){
		if(a>100){
			throw new RuntimeException("数字超过100");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
