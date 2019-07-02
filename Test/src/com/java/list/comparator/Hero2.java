/**
 * 
 */
package com.java.list.comparator;

/**
 * @author PE
 * @date 2019年6月27日 上午11:43:36
 * @explain 
 */
public class Hero2 implements Comparable<Hero2>{
	public String name;
    public float hp;
  
    public int damage;
  
    public Hero2() {
  
    }
  
    public Hero2(String name) {
 
        this.name = name;
    }
  
    public String toString() {
        return "Hero [name=" + name + ", hp=" + hp + ", damage=" + damage + "]\r\n";
    }
 
    public Hero2(String name, int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }


	@Override
	public int compareTo(Hero2 o) {
		if(damage<o.damage)
            return 1; 
        else
            return -1;
	}
}
