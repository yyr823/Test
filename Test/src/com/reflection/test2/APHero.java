/**
 * 
 */
package com.reflection.test2;

import com.reflection.test3.Hero;

/**
 * @author PE
 * @date 2019年7月2日 下午1:28:51
 * @explain
 */
public class APHero extends Hero {

	public void magicAttack() {
		System.out.println("进行魔法攻击");
	}

	public void attackHero(Hero h2) {
		System.out.println(this.name + " 正在攻击 " + h2.getName());
	}

}
