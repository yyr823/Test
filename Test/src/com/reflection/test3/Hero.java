/**
 * 
 */
package com.reflection.test3;

/**
 * @author PE
 * @date 2019年7月2日 下午1:41:01
 * @explain 为了访问属性，把name修改为public。 对于private修饰的成员，需要使用setAccessible(true)才能访问和修改
 */
public class Hero {
	public String name;
	public float hp;
	public int damage;
	public int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hero() {

	}

	public Hero(String string) {
		name = string;
	}

	@Override
	public String toString() {
		return "Hero [name=" + name + "]";
	}

	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}

	public void attackHero(Hero h2) {
		System.out.println(this.name + " 正在攻击 " + h2.getName());
	}

}
