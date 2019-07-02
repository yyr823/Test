/**
 * 
 */
package com.java.thread.waitandnotify;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @author PE
 * @date 2019年6月28日 上午10:21:05
 * @explain lock
 */
public class MyStack2 implements Stack{

	Lock lock=new ReentrantLock();
	Condition condition=lock.newCondition();
	LinkedList<Character> ms;
	 
    public MyStack2() {
        ms = new LinkedList<>();
    }
 
    public  void push(char c) {
    	lock.lock();
        while (ms.size() >= 200) {
            try {
                //this.wait();
                condition.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally {
				lock.unlock();
			}
        }
        ms.addFirst(c);
        condition.signalAll();
        //this.notifyAll();
    }
 
    public  char pull() {
    	lock.lock();
        while (ms.isEmpty()) {
            try {
              condition.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally {
				lock.unlock();
			}
        }
       condition.signalAll();
        return ms.removeFirst();
    }
 
    public synchronized char peek() {
    	  try {
              lock.lock();
              return ms.getLast();
          } finally {
              lock.unlock();
          }
    }
 
    public  String toString() {
        LinkedList<Character> ms2 = new LinkedList<>();
    	 try {
             lock.lock();
        ms2.addAll(ms);
        for (int i = 0; i < ms2.size() / 2; i++) {
            char temp = ms2.get(i);
            ms2.set(i, ms2.get(ms2.size() - i - 1));
            ms2.set(ms2.size() - i - 1, temp);
        }   } finally {
            lock.unlock();
        }
        return ms2.toString();
        
    }

}