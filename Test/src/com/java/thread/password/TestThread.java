/**
 * 
 */
package com.java.thread.password;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PE
 * @date 2019年6月27日 下午4:41:07
 * @explain 破解密码
 */
public class TestThread {
	public static boolean found = false;

	public static void main(String[] args) {
		String password = randomString(3);
		System.out.println("密码是:" + password);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> passwords = new ArrayList<>();
		new PasswordThread(password, passwords).start();
		/**
		 * 启动日志(由于日志线程是主线程也是守护线程,当PasswordThread执行完毕后,
		 * 守护线性也将结束),因此守护线程还未来的及将查找到的可能密码打印出来, 就停止运行了 ,这也是为什么控制台上没有打印出现的原始密码的原因
		 */

		new LogThread(passwords).start();

	}

	private static String randomString(int length) {
		String pool = "";
		for (short i = '0'; i <= '9'; i++) {
			pool += (char) i;
		}
		for (short i = 'a'; i <= 'z'; i++) {
			pool += (char) i;
		}
		for (short i = 'A'; i <= 'Z'; i++) {
			pool += (char) i;
		}
		char cs[] = new char[length];
		for (int i = 0; i < cs.length; i++) {
			int index = (int) (Math.random() * pool.length());
			cs[i] = pool.charAt(index);
		}
		String result = new String(cs);
		return result;
	}
}
