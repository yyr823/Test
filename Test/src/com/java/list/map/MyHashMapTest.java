package com.java.list.map;

import java.util.ArrayList;
import java.util.LinkedList;

import com.java.list.arraylist.Hero;

/**
 * @author PE
 * @date 2019年6月27日 上午11:05:27
 * @explain
 */
public class MyHashMapTest extends MyHashMapImpl {
	public static void main(String[] args) {
		ArrayList<Hero> arrylist = new ArrayList<>();
		// 初始化
		for (int i = 0; i < 100000; i++) {
			int num = (int) (Math.random() * 8999 + 1000);
			arrylist.add(new Hero("hero-" + num));
		}
		/**
		 * 进行性能比较: 1. arrylist直接使用for循环找出来，并统计花费的时间 2. 借助MyHashMap，找出结果，并统计花费的时间
		 */
		int j = 0;// 记录hero-5555的个数德 变量
		long start = System.currentTimeMillis();
		// 开始查询
		for (int i = 0; i < arrylist.size(); i++) {
			if (arrylist.get(i).name.equals("hero-5555")) {
				// System.out.print(arrylist.get(i).toString());
				j++;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("Arrylist所花费的时间是:" + (end - start) + "长度:" + j);
		MyHashMapTest hashmap = new MyHashMapTest();
		// myhashmap的初始化
		for (Hero h : arrylist) {
			@SuppressWarnings("unchecked")
			ArrayList<Hero> list = (ArrayList<Hero>) hashmap.get(h.name);
			// 先查询是否有h.name对应的ArrayList<Hero>为null的时候回添加[]就不在是null了
			if (list == null) {
				// 就是添加[]的
				list = new ArrayList<>();
				hashmap.put(h.name, list);
			} // 不为空的时候就将h添加进h.name对应的ArrayList<Hero>中
			list.add(h);
		}
		start = System.currentTimeMillis();
		// 查找hero-5555
		ArrayList<Hero> list = (ArrayList<Hero>) hashmap.get("hero-5555");
		end = System.currentTimeMillis();
		System.out.print("MyHashMap所花费的时间是:" + (end - start) + "长度:" + list.size());
	}

}
