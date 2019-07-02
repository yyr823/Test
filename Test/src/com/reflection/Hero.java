/**
 * 
 */
package com.reflection;

import java.io.Serializable;

/**
 * @author PE
 * @date 2019年6月26日 下午2:06:32
 * @explain
 */
public class Hero implements Serializable {
	// 表示这个类当前的版本，如果有了变化，比如新设计了属性，就应该修改这个版本号
	private static final long serialVersionUID = 1L;
	public String name;
	public float hp;
	static String copyright;
	/**
	 * 无论什么途径获取类对象，都会导致静态属性被初始化，而且只会执行一次。 （除了直接使用 Class c = Hero.class
	 * 这种方式，这种方式不会导致静态属性被初始化）
	 */
	static {
		System.out.println("初始化 copyright");
		copyright = "版权由Riot Games公司所有";
	}

	public static void method1() {
		// 对象方法
		synchronized (Hero.class) {
			// 对于method1而言，同步对象是Hero.class，只有占用Hero.class才可以执行到这里
			System.out.println(Thread.currentThread().getName() + " 进入了method1方法");
			try {
				System.out.println("运行5秒");
				Thread.sleep(5000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

	// 类方法
	public static synchronized void method2() {
		/**
		 * 对于mehotd2而言，必然有个同步对象，通过观察发现， 当某个线程在method1中，占用了Hero.class之后
		 * 就无法进入method2，推断出，method2的同步对象，就是Hero.class
		 */

		System.out.println(Thread.currentThread().getName() + " 进入了method2方法");
		try {
			System.out.println("运行5秒");
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	@Override
	public String toString() {
		return "Hero [name=" + name + ", hp=" + hp + "]";
	}

}
