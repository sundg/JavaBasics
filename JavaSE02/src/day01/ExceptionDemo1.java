package day01;
//java异常捕获机制：程序中只能解决Exception，不能解决Error
public class ExceptionDemo1 {
	public static void main(String[] args)  throws Exception{
		System.out.println("程序开始");
		try{
			String str=null;
			/*
			 * JVM发现我们调用了一个null的方法，
			 * JVM会创建一个空指针异常的实例，用来描述这里发生的异常，
			 * 当前行抛出异常，抛出后JVM会检查我们的代码片段，查看是否有异常捕获机制
			 * 当发现当前代码行没有异常捕获机制，则将该异常实例抛出到当前代码所在的方法之外
			 * 当异常逐级抛出到main方法之外，那么JVM会杀掉当前程序
			 */
		String str1="a";
//		System.out.println(str.length());
		System.out.println(str1.length());
		System.out.println(str1.charAt(1));
		int i=Integer.parseInt(str1);
		/*
		 * 当上面的代码片段出现了异常，会跳出try语句块，
		 * 那么在try语句块中剩余的代码片段不能被执行
		 */
		System.out.println("内容为执行");
		}catch(NullPointerException e){
			e.printStackTrace();
			System.out.println("空指针异常");
		}catch(StringIndexOutOfBoundsException e){
			e.printStackTrace();
			System.out.println("字符串下标越界异常");
		}catch(Exception e){
			/*
			 * 异常捕获机制的良好习惯：在最后一个捕获Exception，以保证
			 * 可以捕获程序中出现的异常，使得程序不会出现闪退
			 */
			System.out.println("反正除了错");
		}
		System.out.println("程序结束");
	}
}
