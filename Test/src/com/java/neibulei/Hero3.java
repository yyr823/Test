/**
 * 
 */
package com.java.neibulei;

/**
 * @author PE
 * @date 2019年6月24日 上午11:31:06
 * @explain 匿名类
 */
// 匿名类指的是在声明一个类的同时实例化它
// 在匿名类中使用外部的局部变量，外部的局部变量必须修饰为final，在jdk8中，已经不需要强制修饰成final了，如果没有写final，不会报错，因为编译器偷偷的帮你加上了看不见的final
public abstract class Hero3 {
	String name; // 姓名

	float hp; // 血量

	float armor; // 护甲

	int moveSpeed; // 移动速度

	public abstract void attack();

	public static void main(String[] args) {

		ADHero adh = new ADHero();
		// 通过打印adh，可以看到adh这个对象属于ADHero类
		adh.attack();
		System.out.println(adh);

		Hero3 h = new Hero3() {
			// 当场实现attack方法
			public void attack() {
				System.out.println("新的进攻手段");
			}
		};
		h.attack();
		// 通过打印h，可以看到h这个对象属于Hero$1这么一个系统自动分配的类名

		System.out.println(h);
	}

}
