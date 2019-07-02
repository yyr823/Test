package com.java.calc;
/**
 * 
 */

/**
 * @author PE
 * @date 2019年6月23日 下午3:02:31
 * @explain
 */
public class ShuiXianFlower {
	/**
	 * 水仙花数
	 */
	public static void narcissisticNumber() {
		StringBuilder msg = new StringBuilder();
		for (int i = 100; i <= 999; i++) {
			String number = String.valueOf(i);
			int a = Integer.parseInt(number.substring(0, 1));
			int b = Integer.parseInt(number.substring(1, 2));
			int c = Integer.parseInt(number.substring(2, 3));
			if (i != (a * a * a) + (b * b * b) + (c * c * c))
				continue;
			msg.append(i).append(",");
		}
		if (msg.length() > 0) {
			System.out.println("得到的水仙花数分别是: " + msg.substring(0, msg.length() - 1).toString());
		}
	}

	public static void shuixian() {
		for (int i = 100; i < 1000; i++) {
			int bai = i / 100;
			int shi = (i % 100) / 10;
			int ge = i % 10;
			int cube = bai * bai * bai + shi * shi * shi + ge * ge * ge;
			if (cube == i)
				System.out.println(i);
		}
	}
}
