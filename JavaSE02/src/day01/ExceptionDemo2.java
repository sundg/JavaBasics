package day01;
/**
 * finally永远会被执行
 * NullPointerException与StringIndexOutOfBoundsException都属于RuntimeException
 * 
 * catch异常有顺序：异常从小到大，否则会出现编译错误
 *
 */
public class ExceptionDemo2 {
	public static void main(String[] args) {
		System.out.println(test(null)+","+test("0")+","+test(""));
	}
	public static int test(String str) {
		try{
			return str.charAt(0)-'0';
		}catch(NullPointerException e){
			e.printStackTrace();
			return 1; 
		}catch(RuntimeException e){
			e.printStackTrace();
			return 2;
		}catch(Exception e){
			return 3;
		}
		finally{
			/*
			 * finally中不建议(不应该)书写return语句
			 */
			return 4;
		}
	}
}
