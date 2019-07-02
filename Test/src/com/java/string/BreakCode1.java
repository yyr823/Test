/**
 * 
 */
package com.java.string;

import java.util.Random;

/**
 * @author PE
 * @date 2019年6月24日 下午4:50:10
 * @explain
 */
public class BreakCode1 {
	public static void main(String[] args) {
		// 获得一个长度为3的随机字符串：
		char[] a = new char[3];
		Random r = new Random();
		for (int i = 0; i < a.length;) {
			int m = r.nextInt(3) + 1; // 两种情况，1、大写字母，2、小写字母
			if (m == 2) { // 第i位为大写字母
				int n = r.nextInt(26) + 65;// 随机获得一个大写字母的ASCII码
				char c = (char) n;
				a[i] = c;
				i++;
			} else { // 第i位为小写字母
				int n = r.nextInt(26) + 97;// 随机获得一个小写字母的ASCII码
				char c = (char) n;
				a[i] = c;
				i++;
			}
		}
		String str = new String(a);
		System.out.println(str);
		// 穷举法破解密码：
		char[] b = str.toCharArray();
		String str_1 = new String();
		for (int i = 0; i < str.length();) {
			for (int j = 65; j <= 90; j++) { // 用小写字母比对
				if ((char) j == b[i]) {
					str_1 = str_1 + (char) j;
					i++;
					break;
				}
			}
			for (int j = 97; j <= 122; j++) { // 用大写字母比对
				if ((char) j == b[i]) {
					str_1 = str_1 + (char) j;
					i++;
					break;
				}
			}
		}
		System.out.printf("密码是：%s", str_1);
	}
}
