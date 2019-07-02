/**
 * 
 */
package com.java.list.map;

/**
 * @author PE
 * @date 2019年6月27日 上午11:16:01
 * @explain
 */
public class Entry {
	public Entry(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}

	public Object key;
	public Object value;

	public String toString() {
		return "[ket=" + key + ",value=" + value + "]";
	}
}
