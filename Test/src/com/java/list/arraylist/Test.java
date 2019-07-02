/**
 * 
 */
package com.java.list.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author PE
 * @date 2019年6月26日 下午3:59:16
 * @explain
 */
public class Test {
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		// 创建一个 List集合
		ArrayList<Integer> list = new ArrayList<Integer>();
		// 为集合添加对象
		list.add(new Integer(11));

		System.out.println(list.size());
		// 添加对象
		list.add(new Integer(12));

		list.add(null);

		// 可得出容量增加
		System.out.println(list.size());
		// 判断是否存在
		System.out.println(list.contains(11));
		// 遍历输出
		System.out.println(list.toString());
		list.add(0, 15);
		// 遍历 判断是否插入
		System.out.println(list.toString());
		// 得到下标的元素 越界报错
		System.out.println(list.get(2));
		// 删除某个元素 越界报错
		list.remove(0);
		System.out.println(list.toString());
		// 替换
		list.set(0, 18);
		System.out.println(list.toString());
		// 清空
		list.clear();
		System.out.println(list.toString());
		List<Hero> heros = new ArrayList<>();
		// 初始化5个对象
		for (int i = 0; i < 5; i++) {
			heros.add(new Hero("hero " + i));
		}
		Hero specialHero = new Hero("special hero");
		heros.add(specialHero);
		// 判断一个对象是否在容器中
		// 判断标准： 是否是同一个对象，而不是name是否相同
		System.out.print("虽然一个新的对象名字也叫 hero 1，但是contains的返回是:");
		System.out.println(heros.contains(new Hero("hero 1")));
		System.out.print("而对specialHero的判断，contains的返回是:");
		System.out.println(heros.contains(specialHero));
		System.out.println("specialHero所处的位置:" + heros.indexOf(specialHero));
		System.out.println("新的英雄，但是名字是\"hero 1\"所处的位置:" + heros.indexOf(new Hero("hero 1")));

		// 遍历list集合
		// 方式一:
		for (int i = 0; i < heros.size(); i++) {
			System.out.println(heros.get(i).name);
		}
		// 方式二:
		for (Hero hero : heros) {
			System.out.println(hero.name);
		}
		// 方式三:
		Iterator<Hero> its = heros.iterator();
		while (its.hasNext()) {
			System.out.println(its.next().name);
		}
		// 方式四:
		for (Iterator<Hero> a = heros.iterator(); a.hasNext();) {
			Hero hero = (Hero) a.next();
			System.out.println(hero);
		}
		// 按一定要求删除集合数据
		delete();

	}

	/**
	 * 首先初始化一个Hero集合，里面放100个Hero对象，名称分别是从 hero 0 hero 1 hero 2 ... hero 99.
	 * 
	 * 通过遍历的手段，删除掉名字编号是8的倍数的对象
	 */

	public static void delete() {
		ArrayList<Hero> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			Hero hero = new Hero("hero" + i);
			list.add(hero);
		}
		System.out.println("初始化长度:" + list.size());
		int count = 0;
		for (Hero hero : list) {
			int num = Integer.parseInt(hero.name.substring(4, hero.name.length()));
			if (num % 8 == 0 && num != 0) {
				count++;
				System.out.print(num + "\t");
			}
		}
		System.out.println("8的倍数对象数量为:" + count);
		/*
		 * 方式一:倒着删 for (int i = list.size()-1; i >=0; i--) { String
		 * name=list.get(i).name; int
		 * num=Integer.parseInt(name.substring(4,name.length())); if(num%8==0&&num!=0) {
		 * list.remove(i); } }
		 */

		/*
		 * 方式二:正着删 但是list的长度要注意 int length=list.size(); for (int i = 0; i <length; i++)
		 * { String name=list.get(i).name; int
		 * num=Integer.parseInt(name.substring(4,name.length())); if(num%8==0&&num!=0) {
		 * list.remove(i); length=length-1; } }
		 */
		//
		/*
		 * 类似方法二 for (int i = 8; i < list.size(); i = i + 8) { list.remove(i); i--; }
		 */

		System.out.println("删除后的数量:" + list.size());
	}
}