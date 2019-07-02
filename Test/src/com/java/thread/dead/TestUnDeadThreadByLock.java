/**
 * 
 */
package com.java.thread.dead;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @author PE
 * @date 2019年6月28日 上午10:09:00
 * @explain 
 * 
 */
public class TestUnDeadThreadByLock {
	static Lock a = new ReentrantLock();
    static Lock b = new ReentrantLock();
    static Lock c = new ReentrantLock();
 
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            public void run() {
                boolean aLocked = false;
                boolean bLocked = false;
                try {
                    System.out.println("t1试图占有a");
                    System.out.println("t1等待中");
                    aLocked = a.tryLock(1, TimeUnit.SECONDS);
                    if (aLocked) {
                        System.out.println("t1已占有a");
                        Thread.sleep(500);
                        try {
                            System.out.println("t1试图占有b");
                            System.out.println("t1等待中");
                            bLocked = b.tryLock(1, TimeUnit.SECONDS);
                            if (bLocked)
                                System.out.println("t1已占有b");
                            else
                                System.out.println("经过1秒钟的努力，t1还没有占有b，放弃占有");
                        } finally {
                            if (bLocked) {
                                b.unlock();
                                System.out.println("t1已解除对b的占有");
                            }
                        }
 
                    } else
                        System.out.println("经过1秒钟的努力，t1还没有占有a，放弃占有");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    if (aLocked) {
                        a.unlock();
                        System.out.println("t1已解除对a的占有");
                    }
                }
            }
        };
        t1.start();
 
        Thread t2 = new Thread() {
            public void run() {
                boolean bLocked = false;
                boolean cLocked = false;
                try {
                    System.out.println("t2试图占有b");
                    System.out.println("t2等待中");
                    bLocked = b.tryLock(1, TimeUnit.SECONDS);
                    if (bLocked) {
                        System.out.println("t2已占有b");
                        Thread.sleep(500);
                        try {
                            System.out.println("t2试图占有c");
                            System.out.println("t2等待中");
                            cLocked = c.tryLock(1, TimeUnit.SECONDS);
                            if (cLocked)
                                System.out.println("t2已占有c");
                            else
                                System.out.println("经过1秒钟的努力，t2还没有占有c，放弃占有");
                        } finally {
                            if (cLocked) {
                                c.unlock();
                                System.out.println("t2已解除对c的占有");
                            }
                        }
 
                    } else
                        System.out.println("经过1秒钟的努力，t2还没有占有b，放弃占有");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    if (bLocked) {
                        b.unlock();
                        System.out.println("t2已解除对b的占有");
                    }
                }
            }
        };
        t2.start();
 
        Thread t3 = new Thread() {
            public void run() {
                boolean aLocked = false;
                boolean cLocked = false;
                try {
                    System.out.println("t3试图占有c");
                    System.out.println("t3等待中");
                    cLocked = c.tryLock(1, TimeUnit.SECONDS);
                    if (cLocked) {
                        System.out.println("t3已占有c");
                        Thread.sleep(500);
                        try {
                            System.out.println("t3试图占有a");
                            System.out.println("t3等待中");
                            aLocked = a.tryLock(1, TimeUnit.SECONDS);
                            if (aLocked)
                                System.out.println("t3已占有a");
                            else
                                System.out.println("经过1秒钟的努力，t3还没有占有a，放弃占有");
                        } finally {
                            if (aLocked) {
                                a.unlock();
                                System.out.println("t3已解除对a的占有");
                            }
                        }
 
                    } else
                        System.out.println("经过1秒钟的努力，t3还没有占有c，放弃占有");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    if (cLocked) {
                        c.unlock();
                        System.out.println("t3已解除对c的占有");
                    }
                }
            }
        };
        t3.start();
    }
        
}
