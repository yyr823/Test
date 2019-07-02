/**
 * 
 */
package com.java.numbers;

/**
 * @author PE
 * @date 2019年6月24日 上午11:57:02
 * @explain
 */
public class Test {
	public static void main(String[] args) {
		int i = 5;
		// 基本类型转换成封装类型
		Integer it = new Integer(i);
		// 自动把基本类型 转换为类类型 就叫装箱
		Integer it2 = i;
		// 封装类型转换成基本类型
		int i2 = it.intValue();
		// 自动转换就叫拆箱
		int i3 = it;
		// 通过=就自动转换成int类型，就叫拆箱

		// int的最大值可以通过其对应的封装类Integer.MAX_VALUE获取
		// int的最大值
		System.out.println(Integer.MAX_VALUE);
		// int的最小值
		System.out.println(Integer.MIN_VALUE);
		Byte bb = 5;// 装箱失败
		int iii = bb;// 拆箱成功
		System.out.println(it2 + ":" + i2 + ":" + i3 + ":" + iii);

		System.out.println(Character.isLetter('a'));// 判断是否为字母
		System.out.println(Character.isDigit('a')); // 判断是否为数字
		System.out.println(Character.isWhitespace(' ')); // 是否是空白
		System.out.println(Character.isUpperCase('a')); // 是否是大写
		System.out.println(Character.isLowerCase('a')); // 是否是小写

		System.out.println(Character.toUpperCase('a')); // 转换为大写
		System.out.println(Character.toLowerCase('A')); // 转换为小写

		// String a = 'a'; //不能够直接把一个字符转换成字符串
		String a2 = Character.toString('a'); // 转换为字符串
		System.out.println(a2);
		String str = "abC123";
		char[] cs = str.toCharArray();
		for (char c : cs) {
			if (Character.isUpperCase(c) || Character.isDigit(c))
				System.out.print(c);
		}

	}
}
