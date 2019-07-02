/**
 * 
 */
package com.java.stringbuffer;

/**
 * @author PE
 * @date 2019年6月25日 上午11:38:42
 * @explain
 */
public class MyStringBufferTest {
	public static void main(String[] args) throws Exception {
		MyStringBuffer sb = new MyStringBuffer("there light dfgdg  sgdg sfsg");
		System.out.println("容量:" + sb.capacity);
		System.out.println("长度:" + sb.length);
		sb.insert(-1, "God Say:");
		/*
		 * sb.reverse(); sb.insert(10, "be "); sb.delete(0,4); sb.delete(4);
		 * sb.append("!"); System.out.println(sb); sb.insert(0, "God Say:");
		 */
		System.out.println(sb);
		// 测试性能1000000 自建类效率高 其他效率有待考证
		// testKuai();

	}

	public static void testKuai() throws Exception {
		/*
		 * char[] c=new char[10]; for(int i=0;i<c.length;i++){ int
		 * num=(int)(48+Math.random()*(123-48));
		 * if((num>=48&&num<=57)||(num>=65&&num<=90)||(num>=97&&num<=122)){
		 * c[i]=(char)num; } }
		 */
		String s = "sgserge";
		StringBuffer sb = new StringBuffer(s);
		long l1 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			sb.append(s);
		}
		long l2 = System.currentTimeMillis();
		long l = l2 - l1;
		System.out.println("StringBuffer:" + l);// 使用系统自带的所运行的时间

		MyStringBuffer m1 = new MyStringBuffer(s);
		long l3 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			m1.append(s);
		}
		long l4 = System.currentTimeMillis();
		long my = l4 - l3;
		System.out.println("自己創建：" + my);// 使用系统自带的所运行的时间

	}

}
