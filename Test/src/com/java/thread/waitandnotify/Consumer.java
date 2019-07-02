/**
 * 
 */
package com.java.thread.waitandnotify;

/**
 * @author PE
 * @date 2019年6月28日 上午10:24:13
 * @explain 
 */
public class Consumer extends Thread {
    private MyStack ms;
    
    private String name;

    public Consumer(MyStack ms, String name) {
        this.ms = ms;
        this.name = name;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.printf("%s 弹出：%s%n", name, ms.pull());
        }
    }
}
