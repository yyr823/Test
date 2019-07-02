/**
 * 
 */
package com.java.exception;

/**
 * @author PE
 * @date 2019年6月25日 下午3:35:48
 * @explain 支票透支
 */
public class CheckingAccount extends Account {
	private double overdraftProtection; // 透支额度

	public CheckingAccount() {

	}

	public CheckingAccount(float balance) {
		super(balance);
	}

	public CheckingAccount(float balance, float protect) {
		super(balance);
		this.overdraftProtection = protect;
		System.out.println("可透支额度为:" + protect);
	}

	public void withdraw(float amt) throws OverdraftException {
		float money = balance - amt;
		double money2 = overdraftProtection + balance - amt;
		double money3 = amt - balance;
		if (money2 < 0) {
			throw (new OverdraftException("不好意思:你已超出超过透支额度:" + (-money2)));
		} else if (money >= 0) {
			System.out.println("取出" + amt + "当前余额为" + money);
		} else if (money2 >= 0) {
			System.out.println("取出" + amt + "\t当前余额为0\t" + "透支额度:" + money3 + "\t\t剩余额度" + money2);
		}
	}
}
