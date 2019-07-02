/**
 * 
 */
package com.java.exception;

import java.util.Scanner;

/**
 * @author PE
 * @date 2019年6月25日 下午3:23:17
 * @explain
 */
public class Test {
	public static void main(String[] args) throws OverdraftException {
		try {
			float money = 50000;
			Account myaccount = new Account(money);
			myaccount.deposit(70000);
			myaccount.withdraw(43000);
			myaccount.withdraw(97000);
			myaccount.deposit(55000);
		} catch (OverdraftException e) {
			System.out.println("账户里没这么多钱可取,透支了" + e.defecit + "元");
			e.printStackTrace();
		}

		CheckingAccount a1 = new CheckingAccount(3000, 2000);
		try {
			System.out.println("预计打算取出");
			Scanner sc = new Scanner(System.in);
			float mon = sc.nextFloat();
			a1.withdraw(mon);
		} catch (OverdraftException e) {
			e.printStackTrace();
		}
	}
}
