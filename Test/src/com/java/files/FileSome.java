/**
 * 
 */
package com.java.files;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author PE
 * @date 2019年6月25日 下午3:52:24
 * @explain
 */
public class FileSome {
	public static void main(String[] args) throws IOException {

		File f = new File("D:/testcode/tt1.txt");
		System.out.println("当前文件是：" + f);
		// 文件是否存在
		System.out.println("判断是否存在：" + f.exists());

		// 是否是文件夹
		System.out.println("判断是否是文件夹：" + f.isDirectory());

		// 是否是文件（非文件夹）
		System.out.println("判断是否是文件：" + f.isFile());

		// 文件长度
		System.out.println("获取文件的长度：" + f.length());

		// 文件最后修改时间
		long time = f.lastModified();
		Date d = new Date(time);
		System.out.println("获取文件的最后修改时间：" + d);
		// 设置文件修改时间为1970.1.1 08:00:00
		f.setLastModified(0);

		// 文件重命名
		File f2 = new File("D:/testcode/tt1.txt");
		f.renameTo(f2);
		System.out.println("重命名为tt1.txt");
		// 以字符串数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
		f.list();

		// 以文件数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
		/*
		 * File[] fs= f.listFiles(); for (File file : fs) {
		 * System.out.print(file.getName()+"\t"); }
		 */
		// 以字符串形式返回获取所在文件夹
		String a = f.getParent();
		System.out.println("以字符串形式返回获取所在文件夹" + a);
		// 以文件形式返回获取所在文件夹
		File b = f.getParentFile();
		System.out.println("以字符串形式返回获取所在文件夹" + b);
		// 创建文件夹，如果父文件夹skin不存在，创建就无效
		f.mkdir();

		// 创建文件夹，如果父文件夹skin不存在，就会创建父文件夹
		f.mkdirs();

		// 创建一个空文件,如果父文件夹skin不存在，就会抛出异常
		f.createNewFile();
		// 所以创建一个空文件之前，通常都会创建父目录
		f.getParentFile().mkdirs();

		// 列出所有的盘符c: d: e: 等等
		File[] v = f.listRoots();
		for (File file : v) {
			System.out.println(file);
		}
		// 刪除文件
		f.delete();
		// JVM结束的时候，刪除文件，常用于临时文件的删除
		f.deleteOnExit();
		// 遍历C盘下windows下的文件夹,找出这些文件里，最大的和最小(非0)的那个文件，打印出他们的文件名
		String url = "C:\\WINDOWS";
		getFiles(url);
	}

	public static void getFiles(String url) {
		File f = new File(url);
		File[] fs = f.listFiles();
		long max = 0;
		long min = Long.MAX_VALUE;
		String name_max = null;
		String name_min = null;
		for (File f1 : fs) {
			if (f1.isFile()) {
				if (max < f1.length()) {
					max = f1.length();
					name_max = f1.getName();
				}

				if (f1.length() != 0 && min > f1.length()) {
					min = f1.length();
					name_min = f1.getName();
				}
			}
		}
		System.out.println("最大文件是：" + name_max + "，长度：" + max);
		System.out.println("最小文件是：" + name_min + "，长度：" + min);

	}
}
