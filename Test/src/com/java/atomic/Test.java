/**
 * 
 */
package com.java.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author PE
 * @date 2019年6月28日 下午12:00:04
 * @explain 
 * AtomicInteger提供了各种自增，自减等方法，这些方法都是原子性的。
 *  换句话说，自增方法 incrementAndGet 是线程安全的，
 * 同一个时间，只有一个线程可以调用这个方法。
 */
public class Test {
	 public static void main(String[] args) throws InterruptedException {
	        AtomicInteger atomicI =new AtomicInteger();
	        int i = atomicI.decrementAndGet();
	        int j = atomicI.incrementAndGet();
	        int k = atomicI.addAndGet(3);
	         System.out.println(i+":"+j+":"+k);
	    }
	   
}
