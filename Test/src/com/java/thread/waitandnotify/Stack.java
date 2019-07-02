/**
 * 
 */
package com.java.thread.waitandnotify;

/**
 * @author PE
 * @date 2019年6月28日 上午10:22:57
 * @explain 
 */
public interface Stack {
	void push(char c);
	char pull();
	char peek();
	String toString() ;
}
