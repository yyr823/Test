/**
 * 
 */
package com.java.thread;

/**
 * @author PE
 * @date 2019年6月27日 下午3:24:35
 * @explain 
 */
public class KillThread extends Thread{
	 private Hero h1;
	    private Hero h2;
	 
	    public KillThread(Hero h1, Hero h2){
	        this.h1 = h1;
	        this.h2 = h2;
	    }
	 
	    public void run(){
	        while(!h2.isDead()){
	            h1.attackHero(h2);
	        }
	    }
}
