package com.java.arrays;

import java.util.Arrays;

/**
 * 
 */

/**
 * @author PE
 * @date 2019年6月23日 下午3:07:50
 * @explain
 */
public class CopyArray {
	public static void main(String[] args) {
		int a[] = new int[] { 18, 62, 68, 82, 65, 9 };

		int b[] = new int[3];// 分配了长度是3的空间，但是没有赋值

		// 通过数组赋值把，a数组的前3位赋值到b数组

		// 方法一： for循环
		printArray(a, b);

		// 方法二: System.arraycopy(src, srcPos, dest, destPos, length)

		printArray2(a, b);
		// 方法三:copyOfRange(int[] original, int from, int to)
		printArray3(a);
		// sort排序
		printArraySort();

		// 二维数组排序
		printErWeiArraySort();
	}

	public static void printArray(int a[], int b[]) {

		for (int i = 0; i < b.length; i++) {
			b[i] = a[i];

		}
		// 把一个数组，转换为字符串
		String content = Arrays.toString(b);
		System.out.println(content);
	}

	public static void printArray2(int a[], int b[]) {
		System.arraycopy(a, 0, b, 0, 3);
		// src: 源数组
		// srcPos: 从源数组复制数据的起始位置
		// dest: 目标数组
		// destPos: 复制到目标数组的启始位置
		// length: 复制的长度
		// 把内容打印出来
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}

	}

	public static void printArray3(int a[]) {
		// 第一个参数表示源数组
		// 第二个参数表示开始位置(取得到)
		// 第三个参数表示结束位置(取不到)
		int[] b = Arrays.copyOfRange(a, 0, 3);
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}

	}

	public static void printArraySort() {
		int a[] = new int[] { 18, 62, 68, 82, 65, 9 };
		System.out.println("排序之前 :");
		System.out.println(Arrays.toString(a));
		Arrays.sort(a);
		System.out.println("排序之后:");
		System.out.println(Arrays.toString(a));
		// 使用binarySearch之前，必须先使用sort进行排序
		System.out.println("数字 62出现的位置:" + Arrays.binarySearch(a, 62));
	}

	public static void printErWeiArraySort() {
		int array[][] = new int[5][8];
		int temp[] = new int[40];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = (int) (Math.random() * 100);
				temp[i * array[i].length + j] = array[i][j];
			}
		}
		System.out.println(Arrays.toString(temp));
		Arrays.sort(temp);
		System.out.println(Arrays.toString(temp));
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = temp[i * array[i].length + j];
			}
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}

	}

}
