/**
 * 
 */
package com.reflection.test2;

import com.reflection.test3.Hero;

/**
 * @author PE
 * @date 2019年7月2日 下午1:29:14
 * @explain
 */
public class ADHero extends Hero {

	public void physicAttack() {
		System.out.println("进行物理攻击");
	}

	public void attackHero(Hero h2) {
		System.out.println(this.name + " 正在攻击 " + h2.getName());
	}

}
