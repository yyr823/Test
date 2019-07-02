/**
 * 
 */
package com.annotation.test4;

/**
 * @author PE
 * @date 2019年7月2日 下午3:35:31
 * @explain
 */
public class NoBug {
	@Jiecha
	public void suanShu() {
		System.out.println("1234567890");
	}

	@Jiecha
	public void jiafa() {
		System.out.println("1+1=" + 1 + 1);
	}

	@Jiecha
	public void jiefa() {
		System.out.println("1-1=" + (1 - 1));
	}

	@Jiecha
	public void chengfa() {
		System.out.println("3 x 5=" + 3 * 5);
	}

	@Jiecha
	public void chufa() {
		System.out.println("6 / 0=" + 6 / 0);
	}

	public void ziwojieshao() {
		System.out.println("我写的程序没有 bug!");
	}
}
