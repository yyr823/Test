/**
 * 
 */
package com.java.exception;

/**
 * @author PE
 * @date 2019年6月25日 下午3:21:21
 * @explain 自定义异常
 */
public class OverdraftException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	float defecit; // 透支额

	public float getDeficit() {
		return defecit;
	}

	public OverdraftException() {
	}

	public OverdraftException(String msg) {
		super(msg);
	}

}
