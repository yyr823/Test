/**
 * 
 */
package com.java.string;

/**
 * @author PE
 * @date 2019年6月24日 下午4:48:38
 * @explain 3. 生成一个长度是3的随机字符串，把这个字符串作为当做密码
 * 
 *          使用穷举法生成长度是3个字符串，匹配上述生成的密码
 * 
 *          要求： 分别使用多层for循环 和 递归解决上述问题
 */
public class BreakCode {
	public static void main(String[] args) {
		// 在for循环中采用StringBuilder比用String的“ += ”高效
		StringBuilder codePool_tmp = new StringBuilder();
		StringBuilder randomPassword_tmp = new StringBuilder();
		StringBuilder hackedPassword_tmp = new StringBuilder();

		// 获取密码池中的字符串
		for (short i = '0'; i <= 'z'; i++) {
			if (Character.isLetter((char) i) || Character.isDigit((char) i))
				codePool_tmp.append((char) i);
		}
		String codePool = codePool_tmp.toString();
		System.out.println("密码池中的随机密码是：" + codePool);

		// 获取随机的三位数密码
		for (int i = 0; i < 3; i++) {
			int randomCode = (int) Math.floor(Math.random() * codePool.length());
			randomPassword_tmp.append(codePool.charAt(randomCode));
		}
		String randomPassword = randomPassword_tmp.toString();
		System.out.println("初始随机密码是：" + randomPassword);

		// 递归破解初始化随机密码
		for (int i = 0; i < 3; i++) {
			// 遍历字符串
			for (int j = 0; j < codePool.length(); j++) {
				if (codePool.charAt(j) == randomPassword.charAt(i)) {
					hackedPassword_tmp.append(codePool.charAt(j));
					break;
				}
			}
		}
		String hackedPassword = hackedPassword_tmp.toString();
		System.out.println("通过递归得到的破解密码是：" + hackedPassword);
	}
}
