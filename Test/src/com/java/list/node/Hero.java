/**
 * 
 */
package com.java.list.node;

/**
 * @author PE
 * @date 2019年6月26日 下午5:34:06
 * @explain 
 */
public class Hero {
	 String name;
	    int hp;
	    public Hero(String name,int hp){
	        this.name=  name;
	        this.hp = hp;
	    }
	 
	    @Override
	    public String toString() {
	        return "name:"+name+" "+"hp:"+hp;
	    }
}
