/**
 * 
 */
package com.java.string;

/**
 * @author PE
 * @date 2019年6月24日 下午5:18:44
 * @explain
 */
public class Test {
	public static void main(String[] args) {

		String sentence = "盖伦,在进行了连续8次击杀后,获得了超神 的称号";

		System.out.println(sentence.indexOf('8')); // 字符第一次出现的位置

		System.out.println(sentence.indexOf("超神")); // 字符串第一次出现的位置

		System.out.println(sentence.lastIndexOf("了")); // 字符串最后出现的位置

		System.out.println(sentence.indexOf(',', 5)); // 从位置5开始，出现的第一次,的位置

		System.out.println(sentence.contains("击杀")); // 是否包含字符串"击杀"
		String temp = sentence.replaceAll("击杀", "反杀"); // 替换所有的
		System.out.println(temp);
		temp = sentence.replaceFirst(",", "!");// 只替换第一个
		System.out.println(temp);
		// 字母大小写穿插排列
		daxiao();
	}

	// 字母大小写穿插排列
	public static void daxiao() {
		String str = "lengendary";

		char[] ch = str.toCharArray();

		for (int i = 0; i < ch.length; i++) {

			// 判断是否为偶数
			if (i % 2 == 0) {

				ch[i] = Character.toUpperCase(ch[i]);
			}
		}
		String str1 = String.copyValueOf(ch);
		System.out.println("变换后的句子为:" + str1);
	}

}
