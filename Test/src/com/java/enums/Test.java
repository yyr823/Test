/**
 * 
 */
package com.java.enums;

/**
 * @author PE
 * @date 2019年6月24日 上午10:06:39
 * @explain 枚举类型的使用
 */
public class Test {
	public static void main(String[] args) {
		for (Enum ht : Enum.values()) {
			switch (ht) {
			case TANK:
				System.out.println("坦克");
				break;
			case WIZARD:
				System.out.println("法师");
				break;
			case ASSASSIN:
				System.out.println("辅助");
				break;
			case WARRIOR:
				System.out.println("近战");
				break;
			case RANGED:
				System.out.println("射程");
				break;
			case PUSH:
				System.out.println("推进");
				break;
			case FARMING:
				System.out.println("打野");
				break;
			default:
				break;
			}
		}
	}
}
