/**
 * 
 */
package com.java.thread.waitandnotify;

import java.util.LinkedList;
/**
 * @author PE
 * @date 2019年6月28日 上午10:21:05
 * @explain synchronized
 */
public class MyStack implements Stack{
	LinkedList<Character> ms;
	 
    public MyStack() {
        ms = new LinkedList<>();
    }
 
    public synchronized void push(char c) {
        while (ms.size() >= 200) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        ms.addFirst(c);
        this.notifyAll();
    }
 
    public synchronized char pull() {
        while (ms.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        this.notifyAll();
        return ms.removeFirst();
    }
 
    public synchronized char peek() {
        return ms.getFirst();
    }
 
    public synchronized String toString() {
        LinkedList<Character> ms2 = new LinkedList<>();
        ms2.addAll(ms);
        for (int i = 0; i < ms2.size() / 2; i++) {
            char temp = ms2.get(i);
            ms2.set(i, ms2.get(ms2.size() - i - 1));
            ms2.set(ms2.size() - i - 1, temp);
        }
        return ms2.toString();
    }

}