/**
 * 
 */
package com.reflection.test1;

import com.reflection.Hero;

/**
 * @author PE
 * @date 2019年7月2日 下午1:11:58
 * @explain 获取类对象 在一个JVM中，一种类，只会有一个类对象存在
 */
public class Test {
	public static void main(String[] args) {
		String className = "com.reflection.Hero";
		try {
			Class pClass1 = Class.forName(className);
			Class pClass2 = Hero.class;
			Class pClass3 = new Hero().getClass();
			System.out.println(pClass1 == pClass2);// true
			System.out.println(pClass1 == pClass3);// true
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/**
		 * 在对象方法前，加上修饰符synchronized ，同步对象是当前实例。 在类方法前，加上修饰符 synchronized，同步对象也是当前实例
		 */
		Thread t1 = new Thread() {
			public void run() {
				// 调用method1
				Hero.method1();
			}
		};
		t1.setName("第一个线程");
		t1.start();

		// 保证第一个线程先调用method1
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Thread t2 = new Thread() {
			public void run() {
				// 调用method2
				Hero.method2();
			}
		};
		t2.setName("第二个线程");
		t2.start();
	}
}
