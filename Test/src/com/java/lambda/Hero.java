/**
 * 
 */
package com.java.lambda;

/**
 * @author PE
 * @date 2019年6月27日 下午1:57:24
 * @explain 
 */
public class Hero implements Comparable<Hero>{
	    public String name;
	    public float hp;
	        
	    public int damage;
	        
	    public Hero(){
	           
	    }
	       
	    public Hero(String name) {
	        this.name =name;
	   
	    }
	    public boolean matched(){
	    	   return this.hp>100 && this.damage<50;
	    	}
	    //初始化name,hp,damage的构造方法
	    public Hero(String name,float hp, int damage) {
	        this.name =name;
	        this.hp = hp;
	        this.damage = damage;
	    }
	   
	    @Override
	    public int compareTo(Hero anotherHero) {
	        if(damage<anotherHero.damage)
	            return 1; 
	        else
	            return -1;
	    }
	    public int compareHero(Hero h1, Hero h2) {
	        return (h1.hp >= h2.hp ? 1 : -1);
	    }
	 
	   
	    @Override
	    public String toString() {
	        return "Hero [name=" + name + ", hp=" + hp + ", damage=" + damage + "]\r\n";
	    }
	       
}
