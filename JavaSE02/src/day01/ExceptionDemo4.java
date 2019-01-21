package day01;

//抛出异常的第二种情况
public class ExceptionDemo4 {
	public static void main(String[] args) {
		String data="个人信息";
		connectDB("admin", "1231", data);
		System.out.println("注册成功");
	}

	public static void connectDB(String user, String pwd, String data) {
		if ("admin".equals(user) && "123".equals(pwd)) {
			System.out.println("保存数据" + data + "成功");
		} else {
			// 模拟系统抛出一个连接数据库失败的异常
			throw new RuntimeException("数据库连接失败");
		}
	}
}
