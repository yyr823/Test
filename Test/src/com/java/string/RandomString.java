/**
 * 
 */
package com.java.string;

/**
 * @author PE
 * @date 2019年6月24日 下午4:47:02
 * @explain 1.创建一个长度是5的随机字符串，随机字符有可能是数字，大写字母或者小写字母
 */
public class RandomString {
	// ASCII码表0-9对应48-57
	// A-Z对应65-90
	// a-z对应97-122
	private static String randomchar(int length) {
		// 定义一个静态的方法，将方法与main()分离，减少耦合，方便修改
		char ch[] = new char[length];
		int i = 0;
		while (i < length) {
			char c = (char) (Math.random() * 123);// char c = (char)(48+Math.random()*75);
			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
				ch[i] = c;
				i++;// 这个很重要，条件成立才++
			}
		}
		String str = new String(ch);
		return str;
	}

	public static void main(String[] args) {
		String str = randomchar(5);
		System.out.println(str);
	}
}
