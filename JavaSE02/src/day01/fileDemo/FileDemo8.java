package day01.fileDemo;

import java.io.File;
import java.io.IOException;

//递归删除
public class FileDemo8 {
	public static void main(String[] args) {
		// 删除根目录下的g目录
		delete(new File("g"));
	}

	// 将给定的file对象所表示的文件或者文件删除
	/*
	 * delete 分析：删除文件夹或者文件功能 1、检查是否是文件 a、若果是文件，直接删除 b、如果是文件夹，找出所有内容(包含文件、文件夹)
	 * c、删除每个子文件、文件夹：递归操作 d、删除当前文件夹
	 */
	public static void delete(File file) {
		if (file == null || !file.exists()) {
			throw new RuntimeException("不存在");
		}
		try {
			if (file.isFile()) {
				file.delete();
				System.out.println("删除：" + file.getCanonicalPath());
				return;
			}
			File[] file1 = file.listFiles();
			for (File dir : file1) {
				delete(dir);// 递归调用，删除子文件、文件夹
				boolean success = file.delete();// 删除当前目录
				System.out.println(success ? "删除完毕" : "删除失败");
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("删除失败", e);
		}

	}
}
