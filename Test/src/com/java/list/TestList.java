/**
 * 
 */
package com.java.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author PE
 * @date 2019年6月27日 上午10:07:19
 * @explain ArrayList和LinkedList的区别
 */
public class TestList {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		List<Integer> link = new LinkedList<>();
		// 插入数据比较 LinkedList>ArrayList
		insertFirst(ArrayList::new,"ArrayList");//lambada调用构造器
		insertFirst(ArrayList::new,"LinkedList");
		// 定位数据 ArrayList>LinkedList
		modify(list, "ArrayList");
		modify(link, "LinkedList");
		// 比较 ArrayList和LinkedList 在最后面插入100000条数据，谁快谁慢？
/**
 * 总数是10000条的时候，链表定位的总开支要比数组插入的总开支更多，所以最后整体表现，数组会更好。
 * 如果总数是1000条，结果可能就不一样了。
 */
		// 中间插入数据 ArrayList>LinkedList
		insertBetween(list, "ArrayList");
		insertBetween(link, "LinkedList");
		// 后面插入数据 LinkedList>ArrayList
		insertEnd(list, "ArrayList");
		insertEnd(link, "LinkedList");

	}

	public static void insertEnd(List<Integer> list, String type) {
		int total = 100 * 1000;
		long start = System.currentTimeMillis();
		for (int i = 0; i < total; i++)
			list.add(i);
		long end = System.currentTimeMillis();
		System.out.printf("在%s最后面插入%d条数据,总共耗时%d毫秒%n", type, total, end - start);
	}

	public static void insertBetween(List<Integer> list, String type) {
		int total = 100 * 1000;
		long start = System.currentTimeMillis();
		final int number = 5;
		for (int i = 0; i < total; i++)
			list.add(total / 2, number);
		long end = System.currentTimeMillis();
		System.out.printf("在%s中间插入%d条数据,总共耗时%d毫秒%n", type, total, end - start);
	}

	private static void modify(List<Integer> l, String type) {
		int total = 100 * 1000;
		int index = total / 2;
		final int number = 5;
		// 初始化
		for (int i = 0; i < total; i++) {
			l.add(number);
		}

		long start = System.currentTimeMillis();

		for (int i = 0; i < total; i++) {
			int n = l.get(index);
			n++;
			l.set(index, n);
		}
		long end = System.currentTimeMillis();
		System.out.printf("%s总长度是%d，定位到第%d个数据，取出来，加1，再放回去%n 重复%d遍，总共耗时 %d 毫秒 %n", type, total, index, total,
				end - start);
		System.out.println();
	}

	private static void insertFirst(Supplier<List> li, String type) {
	// 使用构造器创建一个list对象
		int total = 1000 * 100;
		final int number = 5;
		long start = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			li.get().add(0, number);
		}
		long end = System.currentTimeMillis();
		System.out.printf("在%s 最前面插入%d条数据，总共耗时 %d 毫秒 %n", type, total, end - start);
	}
}
