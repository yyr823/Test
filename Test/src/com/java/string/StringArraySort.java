/**
 * 
 */
package com.java.string;

import java.util.Arrays;

/**
 * @author PE
 * @date 2019年6月24日 下午4:43:57
 * @explain 2. 创建一个长度是8的字符串数组 使用8个长度是5的随机字符串初始化这个数组
 *          对这个数组进行排序，按照每个字符串的首字母排序(无视大小写)
 */
public class StringArraySort {
	public static void main(String[] args) {
		String str[] = new String[8];
		for (int i = 0; i < str.length; i++) {
			str[i] = randomchar(5);
		}
		System.out.println(Arrays.toString(str));
		stringArraySort(str);
	}

	private static String randomchar(int length) {
		char ch[] = new char[length];
		int i = 0;
		while (i < length) {
			char c = (char) (48 + Math.random() * 75);
			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
				ch[i] = c;
				i++;
			}
		}
		String str = new String(ch);
		return str;
	}

	private static void stringArraySort(String str[]) {
		// 两两比较大的往后移，第一次循环，最大的在后面了
		// 第二次最大的在倒数第二个个位置
		// 最后，第一个和第二个交换
		for (int i = 0; i < str.length; i++) {
			// 这是冒泡循环，第一个循环决定比较哪里停止
			for (int j = 0; j < str.length - i - 1; j++) {
				// 1.第一步，取首字母，转小写
				// 2.第二步：比较首字母，按照首字母，小值在前，大值移到最后
				char firstChar1 = Character.toLowerCase(getLetter(str[j]));
				char firstChar2 = Character.toLowerCase(getLetter(str[j + 1]));
				System.out.print(firstChar1 + "\t");
				System.out.print(firstChar2 + "\t");
				if (firstChar1 > firstChar2) {
					String temp = str[j];
					str[j] = str[j + 1];
					str[j + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(str));
	}

	public static char getLetter(String str) {
		char[] st = str.toCharArray();
		for (int i = 0; i < st.length; i++) {
			if (Character.isLetter(st[i])) {
				return st[i];
			}
		}
		return 'z';
	}

}
