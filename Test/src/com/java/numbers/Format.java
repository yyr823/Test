/**
 * 
 */
package com.java.numbers;

import java.util.Locale;

/**
 * @author PE
 * @date 2019年6月24日 下午4:21:14
 * @explain
 */
public class Format {
	public static void main(String[] args) {

		String name = "盖伦";
		int kill = 8;
		String title = "超神";

		// 直接使用+进行字符串连接，编码感觉会比较繁琐，并且维护性差,易读性差
		String sentence = name + " 在进行了连续 " + kill + " 次击杀后，获得了 " + title + " 的称号";

		System.out.println(sentence);
		/**
		 * %s 表示字符串 %d 表示数字 %n 表示换行
		 */
		// 使用格式化输出
		// %s表示字符串，%d表示数字,%n表示换行
		String sentenceFormat = "%s 在进行了连续 %d 次击杀后，获得了 %s 的称号%n";
		System.out.printf(sentenceFormat, name, kill, title);
		System.out.printf("这是换行符%n");
		// 使用format格式化输出
		System.out.format(sentenceFormat, name, kill, title);
		int year = 2020;
		// 总长度，左对齐，补0，千位分隔符，小数点位数，本地化表达
		// 直接打印数字
		System.out.format("%d%n", year);
		// 总长度是8,默认右对齐
		System.out.format("%8d%n", year);
		// 总长度是8,左对齐
		System.out.format("%-8d%n", year);
		// 总长度是8,不够补0
		System.out.format("%08d%n", year);
		// 千位分隔符
		System.out.format("%,8d%n", year * 10000);

		// 小数点位数
		System.out.format("%.2f%n", Math.PI);

		// 不同国家的千位分隔符
		System.out.format(Locale.FRANCE, "%,.2f%n", Math.PI * 10000);
		System.out.format(Locale.US, "%,.2f%n", Math.PI * 10000);
		System.out.format(Locale.UK, "%,.2f%n", Math.PI * 10000);

		System.out.println("使用\\t制表符可以达到对齐的效果");
		System.out.println("abc\tdef");
		System.out.println("ab\tdef");
		System.out.println("a\tdef");

		System.out.println("一个\\t制表符长度是8");

		System.out.println("换行符 \\n");
		System.out.println("abc\ndef");

		System.out.println("单引号 \\'");
		System.out.println("abc\'def");
		System.out.println("双引号 \\\"");
		System.out.println("abc\"def");
		System.out.println("反斜杠本身 \\");
		System.out.println("abc\\def");

	}
}