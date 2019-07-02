package com.java.arrays;

import java.util.Arrays;

/**
 * @author PE
 * @date 2019年6月22日 下午5:06:30
 * @explain 排序数组
 */
public class Test {

	public static void main(String[] args) {
		int[] a = new int[5];
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (100 * Math.random());
		}
		System.out.println(Arrays.toString(a));
		// 选择法排正序
		for (int j = 0; j < a.length - 1; j++) {
			for (int i = j + 1; i < a.length; i++) {
				if (a[j] > a[i]) {
					int temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
			}
		}
		System.out.print("选择法排序：");
		System.out.println(Arrays.toString(a));

		// 冒泡排序
		for (int j = 0; j < a.length; j++) {
			for (int i = 0; i < a.length - 1 - j; i++) {
				if (a[i] < a[i + 1]) {
					int temp = a[i + 1];
					a[i + 1] = a[i];
					a[i] = temp;
				}
			}
		}
		System.out.print("冒泡法排序：");
		System.out.print(Arrays.toString(a));

	}

}
