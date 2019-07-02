/**
 * 
 */
package com.java.list.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import com.java.list.arraylist.Hero;

/**
 * @author PE
 * @date 2019年6月27日 上午9:21:42
 * @explain 1. 不使用HashMap(键不可重复)，直接使用for循环找出来，并统计花费的时间 2.
 *          借助HashMap，找出结果，并统计花费的时间 结论:for循环较HashMap查找更快
 */
public class TestHashMap {
	Random r = new Random();

	static ArrayList<Hero> al = new ArrayList<>();

	public static void main(String[] args) {
		TestHashMap tm = new TestHashMap();
		// for循环查找
		tm.forTest();
		// hashMap查找
		tm.hashTest();
	}

	public void forTest() {
		for (int i = 0; i < 3000000; i++) {// 赋随机值
			al.add(new Hero("hero-" + (r.nextInt(9000) + 1000)));
		}

		long betTime = System.currentTimeMillis();
		int count = 0;
		for (int i = 0; i < al.size(); i++) {
			if ((al.get(i).name).equals("hero-5555")) {// 获取集合数组hero对象的值做比较
				// System.out.println(al.get(i).toString()+"\t"+al.get(i).name);
				count++;
			}
		}
		System.out.println("用for循环找到hero-5555的数量为：" + count);
		long endTime = System.currentTimeMillis();
		System.out.println("for循环花的时间：" + (int) (endTime - betTime));
	}

	public void hashTest() {
		HashMap<Hero, String> hm = new HashMap<Hero, String>();

		for (int i = 0; i < al.size(); i++) {// 给hashMap赋值
			hm.put(al.get(i), al.get(i).name);
		}

		Set<Hero> s = hm.keySet();
		int num1 = 0;
		long betTime = System.currentTimeMillis();
		for (Hero h : s) {// 找出key建对象对应的值
			if (h.name.equals("hero-5555")) {
				// System.out.println(h.toString()+"\t"+h.name);
				num1++;
			}
		}
		System.out.println("使用HashMap找到hero-5555的数量为" + num1);
		long endTime = System.currentTimeMillis();
		System.out.println("hashMap所花时间:" + (int) (endTime - betTime));
	}
}
