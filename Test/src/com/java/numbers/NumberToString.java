/**
 * 
 */
package com.java.numbers;

/**
 * @author PE
 * @date 2019年6月24日 下午1:05:40
 * @explain
 */
public class NumberToString {
	public static void main(String[] args) {
		int i = 5;
		// 数字转字符串
		// 方法1
		String str = String.valueOf(i);

		// 方法2
		Integer it = i;
		String str2 = it.toString();
		// 方法3
		String str3 = i + "";
		System.out.println(str + ":" + str2 + ":" + str3);
		// 字符串转数字
		String k = "999";

		int k2 = Integer.parseInt(k);

		System.out.println(k2);

		String f = "3.1a4";

		float f2 = Float.parseFloat(f);

		System.out.println(f2);// NumberFormatException异常

	}
}