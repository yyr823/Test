/**
 * 
 */
package com.java.neibulei;

/**
 * @author PE
 * @date 2019年6月24日 上午11:26:37
 * @explain 静态内部类
 */
// 因为没有一个外部类的实例，所以在静态内部类里面不可以访问外部类的实例属性和方法
public class Hero2 {
	// private String name1;
	public static String name;
	protected float hp;

	private static void battleWin() {
		System.out.println("battle win");
	}

	// 敌方的水晶
	static class EnemyCrystal {
		int hp = 5000;

		// 如果水晶的血量为0，则宣布胜利
		public void checkIfVictory() {
			if (hp == 0) {
				Hero2.battleWin();

				// 静态内部类不能直接访问外部类的对象属性,可以访问外部类的私有静态成员外，
				// System.out.println(name1 + " win this game");
				System.out.println(name + " win this game");
			}
		}
	}

	public static void main(String[] args) {
		// 实例化静态内部类
		EnemyCrystal crystal = new Hero2.EnemyCrystal();
		crystal.checkIfVictory();
	}

}
