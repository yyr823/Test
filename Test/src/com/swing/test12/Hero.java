/**
 * 
 */
package com.swing.test12;

/**
 * @author PE
 * @date 2019年6月26日 下午3:58:32
 * @explain 
 */
public class Hero {
	public int id;
	public String name;
    public float hp;
  
    public int damage;
  
    public Hero() {
  
    }
  
    // 增加一个初始化name的构造方法
    public Hero(String name) {
  
        this.name = name;
    }
  
    // 重写toString方法
    public String toString() {
        return name;
    }
    
/*    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Hero)) {
            return false;
        }
 
        Hero hero = (Hero) obj;
 
        return name.equals(hero.name);
    }*/
}
