/**
 * 
 */
package com.java.thread;

/**
 * @author PE
 * @date 2019年6月27日 下午3:56:47
 * @explain
英雄有可以放一个技能叫做: 波动拳-a du gen。 每隔一秒钟，
可以发一次，但是只能连续发3次。
发完3次之后，需要充能5秒钟，充满，再继续发。
 */
public class HeroTest extends Thread {
	 public static void main(String[] args) {
	        Thread t = new Thread() {
	            public void run() {
	                while (true) {
	                    for (int i = 1; i <= 3; i++) {
	                        System.out.printf("波动拳第%d发%n", i);
	                        if (i == 3)
	                            break;
	                        try {
	                            Thread.sleep(1000);
	                        } catch (InterruptedException e) {
	                            // TODO Auto-generated catch block
	                            e.printStackTrace();
	                        }
	                    }
	                    System.out.println("开始为时5秒的充能");
	                    for (int i = 5; i >= 0; i--) {
	                        if (i == 0) {
	                            System.out.println("冷却完毕");
	                            break;
	                        }
	                        System.out.printf("冷却中，还剩%d秒%n", i);
	                        try {
	                            Thread.sleep(1000);
	                        } catch (InterruptedException e) {
	                            // TODO Auto-generated catch block
	                            e.printStackTrace();
	                        }
	                    }
	                }
	            }
	        };
	        t.start();
	 }
}
