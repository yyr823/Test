package com.java.arrays;
/**
 * 
 */

/**
 * 定义一个5X5的二维数组。 然后使用随机数填充该二维数组。 找出这个二维数组里，最大的那个值，并打印出其二维坐标
 * 
 * @author PE
 * @date 2019年6月23日 下午3:11:43
 * @explain
 */
public class ErWeiArray {
	public static void main(String[] args) {
		int[][] arr = new int[5][5];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = (int) (Math.random() * 100);
			}

		}
		int temp = arr[0][0];
		int start = 0;
		int end = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + "\t");
				if (arr[i][j] >= temp) {

					temp = arr[i][j];
					start = i;
					end = j;
				}
			}
			System.out.println();

		}
		System.out.println("最大值是:" + temp);
		System.out.println("坐标为:[" + (start + 1) + "][" + (end + 1) + "]");
	}
}
