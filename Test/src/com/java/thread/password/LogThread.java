/**
 * 
 */
package com.java.thread.password;

import java.util.List;

/**
 * @author PE
 * @date 2019年6月27日 下午4:40:48
 * @explain
 */
public class LogThread extends Thread {
	private boolean found = false;

	private List<String> passwords;

	public LogThread(List<String> passwords) {
		this.passwords = passwords;
		this.setDaemon(true);// 把记日志的这个线程，设置为守护线程
	}

	public void run() {
		while (true) {
			while (passwords.isEmpty()) {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			String password = passwords.remove(0);

			System.out.println("穷举法本次生成的密码是：" + password);
		}
	}
}