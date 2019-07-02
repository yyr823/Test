/**
 * 
 */
package com.annotation.test2;

/**
 * @author PE
 * @date 2019年7月2日 下午2:35:06
 * @explain
 */
public class Test2 {
	String name;

	@SafeVarargs
	public static <T> T getFirstOne(T... elements) {
		return elements.length > 0 ? elements[0] : null;
	}
}
