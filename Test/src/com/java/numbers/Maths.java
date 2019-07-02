/**
 * 
 */
package com.java.numbers;

/**
 * @author PE
 * @date 2019年6月24日 下午1:10:49
 * @explain
 */
public class Maths {
	public static void main(String[] args) {

		float f1 = 5.4f;
		float f2 = 5.5f;
		// 5.4四舍五入即5
		System.out.println(Math.round(f1));
		// 5.5四舍五入即6
		System.out.println(Math.round(f2));

		// 得到一个0-1之间的随机浮点数（取不到1）
		System.out.println(Math.random());

		// 得到一个0-10之间的随机整数 （取不到10）
		System.out.println((int) (Math.random() * 10));
		// 开方
		System.out.println(Math.sqrt(9));
		// 次方（2的4次方）
		System.out.println(Math.pow(2, 4));

		// π
		System.out.println(Math.PI);

		// 自然常数
		System.out.println(Math.E);

		double n = Integer.MAX_VALUE;

		// 方法里面输出的数相对小些
		System.out.println("自算的对数为:" + Math.pow((1 + 1 / n), n));

		System.out.println("Math方法自然对数为:" + Math.E);
		Maths.zhishu(1000000);
	}

	// 统计找出一千万以内，一共有多少质数
	// 质数概念: 只能被1和自己整除的数
	public static void zhishu(int goal) {
		int count = 0;
		int amount = 0;
		for (int i = 2; i <= goal; i++) {
			for (int j = 1; j <= i / 2; j++) {
				if (i % j == 0) {
					count++;
				}
				if (count >= 2) {
					amount++;
					count = 0;
					break;
				}
			}
		}
		System.out.println(2);
		System.out.println(goal + "以内的质数共有" + (goal - amount) + "个。");
	}
}
