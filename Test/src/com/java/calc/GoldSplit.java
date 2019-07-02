package com.java.calc;
/**
 * 
 */

/**
 * @author PE
 * @date 2019年6月23日 下午3:00:42
 * @explain
 */
public class GoldSplit {
	/*
	 *              * 步骤 1 : 练习-黄金分割点    寻找某两个数相除，其结果 离黄金分割点 0.618最近   分母和分子不能同时为偶数
	 * 分母和分子 取值范围在[1-20]         
	 */
	public static void main(String[] args) {
		float a, b, m = 0.0f, n = 0.0f, min = 1.0f, value;
		for (a = 1.0f; a < 20.0; a++) {
			for (b = a + 1; b < 20.0; b++)/* 保证a和b不同 */ {
				if (a % 2 == 0 && b % 2 == 0)
					continue;
				value = (a / b > 0.618f) ? (a / b - 0.618f) : (0.618f - a / b);// 拿两个除数相除与0比较
				if (value < min) {
					min = value;
					m = a;
					n = b;
				}
			}
		}
		System.out.println("离黄金分割点（0.618）最近的两个数相除是：" + (int) m + "/" + (int) n + "=" + (m / n));
	}

	public static void glod() {
		String msg = null;
		for (double i = 1.0, section = 0.618, number = 0.0; i <= 20.0; i++) {
			for (int j = 1; j <= 20; j++) {
				if (i % 2 == 0 && j % 2 == 0)
					continue;
				double with = section - (i / j);
				if (!((number == 0 || number > with) && with >= 0))
					continue;
				number = with;
				msg = "被除数: " + i + "\n除数: " + j + "\n得到的商: " + i / j + " 最接近 0.618!";
			}
		}
		System.out.println(msg);
	}
}
