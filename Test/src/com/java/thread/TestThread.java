/**
 * 
 */
package com.java.thread;

/**
 * @author PE
 * @date 2019年6月27日 下午3:23:24
 * @explain 
 */
public class TestThread {
	public static void main(String[] args) {
        
        Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;
 
        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;
         
        Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;
         
        Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;
        /**
         * 按顺序进行攻击
         */
         //盖伦攻击提莫
        while(!teemo.isDead()){
            gareen.attackHero(teemo);
        }
 
        //赏金猎人攻击盲僧
        while(!leesin.isDead()){
            bh.attackHero(leesin);
        }
        /**
         * 创建多线程的三种方式
         */
        /**
         * 1.Thread
         */
        KillThread killThread1 = new KillThread(gareen,teemo);
        killThread1.start();
        KillThread killThread2 = new KillThread(bh,leesin);
        killThread2.start();
        /**
         * 2.Runable
         */
        Battle battle1 = new Battle(gareen,teemo);
        
        new Thread(battle1).start();
 
        Battle battle2 = new Battle(bh,leesin);
        new Thread(battle2).start();
        /**
         * 3.匿名类
         */
        Thread t1= new Thread(){
            public void run(){
                //匿名类中用到外部的局部变量teemo，必须把teemo声明为final
                //但是在JDK7以后，就不是必须加final的了
                while(!teemo.isDead()){
                    gareen.attackHero(teemo);
                }              
            }
        };
         
 
          
        Thread t2= new Thread(){
            public void run(){
                while(!leesin.isDead()){
                    bh.attackHero(leesin);
                }              
            }
        };
        /**
         * 当线程处于竞争关系的时候，优先级高的线程会有更大的几率获得CPU资源 
         */
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
     
    }
     
}
