/**
 * 
 */
package com.java.thread.waitandnotify;

/**
 * @author PE
 * @date 2019年6月28日 上午10:24:38
 * @explain 
 */
public class Producer extends Thread {
    private MyStack ms;
    
    private String name;

    public Producer(MyStack ms, String name) {
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
            char c = (char) (Math.random() * 26 + 65);
     /*       String pool="";
            for(char i='A';i<='Z';i++) {
                pool+=i;
            }
             pool.charAt((int) (Math.random()*pool.length()));*/
            ms.push(c);
            System.out.printf("%s 压入：%s%n", name, c);
        }
    }
}
