/**
 * 
 */
package com.hutool;

/**
 * @author PE
 * @date 2019年7月2日 下午10:05:45
 * @explain
 */
public class Hero {
	String name;
	int hp;

	public Hero() {
	}

	public Hero(String name, int hp) {
		super();
		this.name = name;
		this.hp = hp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	@Override
	public String toString() {
		return "Hero [name=" + name + ", hp=" + hp + "]";
	}

}
