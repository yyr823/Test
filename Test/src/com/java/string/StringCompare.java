/**
 * 
 */
package com.java.string;

/**
 * @author PE
 * @date 2019年6月24日 下午5:27:42
 * @explain 创建一个长度是100的字符串数组 使用长度是2的随机字符填充该字符串数组 统计这个字符串数组里重复的字符串有多少种
 */
public class StringCompare {
	public static void main(String[] args) {
		String[] str = new String[100];
		fill(str);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 20; j++) {
				System.out.printf("%s ", str[20 * i + j]);
			}
			System.out.println("");
		}
		int cnt = 0;
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < str.length; i++) {
			for (int j = i + 1; j < str.length; j++) {
				if (str[i].equals(str[j])) {
					cnt++;
					sb = sb.append(str[i]);
					break;
				}
			}
		}
		System.out.printf("总共有%d种重复的字符串%n", cnt);
		System.out.println("分别是：");

		for (int i = 0; i < cnt; i++) {
			System.out.printf("%c%c ", sb.charAt(i), sb.charAt(i + 1));
		}

	}

	// 填充String[]
	public static void fill(String[] s) {
		for (int i = 0; i < s.length; i++) {
			s[i] = rand();
		}
	}

	// 生成长度2的随机字符串
	public static String rand() {
		char[] rs = new char[2];
		for (int i = 0; i < 2; i++) {
			int index = (int) (Math.random() * (10 + 26 + 26)); // 0-61
			if (index <= 9)
				rs[i] = (char) ((int) '0' + index);
			else if (index <= 9 + 26)
				rs[i] = (char) ((int) 'A' + index - 10);
			else
				rs[i] = (char) ((int) 'a' + index - 36);
		}
		String ss = String.valueOf(rs);

		return ss;
	}

}
