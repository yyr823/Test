/**
 * 
 */
package com.java.list.comparator;

/**
 * @author PE
 * @date 2019年6月27日 上午11:43:36
 * @explain 
 */
public class Hero {
	public String name;
    public float hp;
  
    public int damage;
  
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getHp() {
		return hp;
	}

	public void setHp(float hp) {
		this.hp = hp;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public Hero() {
  
    }
  
    public Hero(String name) {
 
        this.name = name;
    }
  
    public String toString() {
        return "Hero [name=" + name + ", hp=" + hp + ", damage=" + damage + "]\r\n";
    }
 
    public Hero(String name, int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }
}
