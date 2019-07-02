/**
 * 
 */
package com.java.exception;

/**
 * @author PE
 * @date 2019年6月25日 下午3:18:01
 * @explain 银行卡取钱存钱
 */
public class Account {
	float balance;// 余额

	public Account() {
	}
	// 获取余额

	public float getBalance() {
		return balance;
	}

	public Account(float money) {
		balance = money;
		System.out.println("当前账户余额：" + balance + "元");
	}

	// 存钱
	public void deposit(float money) {
		balance += money;
		System.out.println("存完钱后，账户里有" + balance + "元");

	}

	// 取钱
	public void withdraw(float money) throws OverdraftException {
		if (money > balance) {
			OverdraftException ode = new OverdraftException("透支异常");
			ode.defecit = money - balance;
			throw ode;
		}
		balance -= money;
		System.out.println("取完钱后，账户里还有" + balance + "元");
	}

}
