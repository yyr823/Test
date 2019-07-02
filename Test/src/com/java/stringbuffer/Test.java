/**
 * 
 */
package com.java.stringbuffer;

/**
 * @author PE
 * @date 2019年6月25日 上午10:59:21
 * @explain
 */
public class Test {
	public static void main(String[] args) {
		String str1 = "let there ";

		StringBuffer sb = new StringBuffer(str1); // 根据str1创建一个StringBuffer对象
		sb.append("be light"); // 在最后追加

		System.out.println(sb);

		sb.delete(4, 10);// 删除4-10之间的字符

		System.out.println(sb);

		sb.insert(4, "there ");// 在4这个位置插入 there

		System.out.println(sb);

		sb.reverse(); // 反转

		String str = "the";

		StringBuffer kk = new StringBuffer(str);

		System.out.println(kk.length()); // 内容长度

		System.out.println(kk.capacity());// 总空间

		System.out.println(kk);
		// ************************************
		String ran = Test.createRandomStr(10);
		StringBuffer sBuffer = new StringBuffer(ran);

		long t1 = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			str = str + Test.createRandomStr(10);
		}
		long t2 = System.currentTimeMillis();
		long t3 = t2 - t1;
		for (int i = 0; i < 10000; i++) {
			sBuffer.append(Test.createRandomStr(10));
		}
		long t4 = System.currentTimeMillis();
		long t5 = t4 - t2;
		System.out.printf("使用'+'连接字符串的耗时为：%s毫秒\n", t3);
		System.out.printf("使用append连接字符串的耗时为：%s毫秒", t5);

	}

	// 生成随机数组的函数
	public static String createRandomStr(int len) {

		char[] a = new char[len];
		int k;
		for (int i = 0; i < len;) {
			k = (int) (48 + Math.random() * 75);
			if (48 <= k && k <= 57 || 65 <= k && k <= 90 || 97 <= k && k <= 122) {
				a[i] = (char) k;
				i++;// 注意要把i++放到这里，否则不能有效的生成数字或者字母的字符
			}
		}
		String str = new String(a);// 把字符转化成字符串
		return str;
	}

}
