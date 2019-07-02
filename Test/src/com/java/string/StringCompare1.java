/**
 * 
 */
package com.java.string;

/**
 * @author PE
 * @date 2019年6月24日 下午5:32:01
 * @explain
 */
public class StringCompare1 {
	public static void main(String[] args) {
		String[] forCompare = new String[100];
		// 判断是否已被比较过且确认有重复，如果为true就不用拿它和其它字符串一一比较了,boolean默认值为false
		boolean[] ifRepeat = new boolean[100];
		// 有重复的字符串一一放到这个字符串数组里
		String[] repeat = new String[50];
		// 与repeat数组一一对应，表示重复次数
		int[] repeatTimes = new int[50];
		// repeatIndex[]与repeat数组一一对应，repeatIndex[][]存储重复字符串出现的位置
		int[][] repeatIndex = new int[50][50];
		// 表示有多少种重复字符串
		int repeatType = 0;
		char[] tmp = new char[2];

		// 生成字符串数组并打印
		for (int i = 0; i < forCompare.length; i++) {
			for (int j = 0; j < tmp.length; j++)
				tmp[j] = (char) ASCII();
			forCompare[i] = String.valueOf(tmp);
			// 打印字符串数组，每20组换行
			if ((i + 1) % 20 == 0) {
				System.out.println(forCompare[i]);
				continue;
			}
			System.out.print(forCompare[i] + "  ");
		}

		// 检查是否有重复字符串，并得到重复次数和出现位置
		for (int i = 0; i < forCompare.length; i++) {
			// 如果确认与之前比较过的字符串无重复，则拿它与后续字符串一一比较
			if (!ifRepeat[i]) {
				for (int j = i + 1; j < forCompare.length; j++) {
					if (forCompare[i].equals(forCompare[j])) {
						ifRepeat[i] = true;
						ifRepeat[j] = true;
						repeat[repeatType] = forCompare[i];
						repeatTimes[repeatType]++;
						repeatIndex[repeatType][0] = i;
						repeatIndex[repeatType][repeatTimes[repeatType]] = j;
					}
				}
				if (ifRepeat[i]) {
					repeatTimes[repeatType] += 1;
					repeatType++;
				}
			}
		}

		// 打印比较结果
		if (repeatType == 0)
			System.out.println("没有重复的字符串");
		else {
			System.out.println("总共有" + repeatType + "种重复的字符串，分别是：");
			String sentence = "%s  重复出现%d次，出现位置(基1)为：";
			for (int i = 0; i < repeatType; i++) {
				System.out.printf(sentence, repeat[i], repeatTimes[i]);
				for (int j = 0; j < repeatTimes[i]; j++) {
					if (j == repeatTimes[i] - 1) {
						System.out.println(repeatIndex[i][j] + 1);
						continue;
					}
					System.out.print(repeatIndex[i][j] + 1 + "、");
				}
			}
		}
	}

	// 生成随机字符用，返回一个ASCII码值，大小写字母和数字三种字符出现概率相同
	public static int ASCII() {
		int tmp = (int) (Math.random() * 30);
		if (tmp >= 0 && tmp < 10)
			return (int) (Math.random() * 10 + 48);
		else if (tmp >= 10 && tmp < 20)
			return (int) (Math.random() * 26 + 65);
		else
			return (int) (Math.random() * 26 + 97);
	}
}
