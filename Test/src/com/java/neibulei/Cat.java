/**
 * 
 */
package com.java.neibulei;

/**
 * @author PE
 * @date 2019年6月24日 上午11:44:22
 * @explain
 */
public interface Cat {
	default void revive() {
		System.out.println("本英雄复活了");
	}
}
