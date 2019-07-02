/**
 * 
 */
package com.java.thread.password;

import java.util.List;

/**
 * @author PE
 * @date 2019年6月27日 下午4:40:08
 * @explain
 * 
 * 			生成一个长度是3的随机字符串，把这个字符串当作 密码 2. 创建一个破解线程，使用穷举法，匹配这个密码 3.
 *          创建一个日志线程，打印都用过哪些字符串去匹配，这个日志线程设计为守护线程 提示：
 *          破解线程把穷举法生成的可能密码放在一个容器中，日志线程不断的从这个容器中拿出可能密码，并打印出来。 如果发现容器是空的，
 *          就休息1秒，如果发现不是空的，就不停的取出，并打印。
 */
public class PasswordThread extends Thread {

	private boolean found = false;

	private String password;

	private List<String> passwords;

	public PasswordThread(String password, List<String> passwords) {
		this.password = password;
		this.passwords = passwords;
	}

	public void run() {
		char[] guessPassword = new char[password.length()];
		generatePassword(guessPassword, password);
	}

	public void generatePassword(char[] guessPassword, String password) {
		generatePassword(guessPassword, 0, password);
	}

	/**
	 * 参考package com.java.thread.password.breakpassworktool.TestPassword.java;
	 * 
	 * @param guessPassword
	 *            猜测的密码
	 * @param index
	 *            从0开始的下标
	 * @param password
	 *            初始密码(原始密码)
	 */
	public void generatePassword(char[] guessPassword, int index, String password) {
		if (found)
			return;
		for (short i = '0'; i <= 'z'; i++) {
			char c = (char) i;
			if (!Character.isLetterOrDigit(c))
				continue;
			guessPassword[index] = c;
			if (index != guessPassword.length - 1) {
				generatePassword(guessPassword, index + 1, password);
			} else {
				String guess = new String(guessPassword);
				// 穷举每次生成的密码，都放进集合中
				passwords.add(guess);
				if (guess.equals(password)) {
					System.out.println("找到了，密码是" + guess);
					found = true;
					return;
				}

			}
		}

	}
}
