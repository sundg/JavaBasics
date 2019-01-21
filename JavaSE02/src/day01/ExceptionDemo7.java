package day01;
/*
 * finally关键字
 * 	finally语句块：
 * 		该语句块出现在try或者最后一个catch语句块之后
 * 		原则：finally语句块无论程序是否出错都必然执行其内部代码，
 * 			  通常我们会使用finally语句块作为程序的收尾工作
 */
public class ExceptionDemo7 {
	public static void main(String[] args) {
		System.out.println(test(""));
	}
	
	public static int test(String str){
		try {
			if(str.length()>0){
				return str.length();
			}else{
				throw new RuntimeException();
			}
		} catch (Exception e) {
		}finally{
			System.out.println("程序结束了");
		}
		return -1;
	}
}
