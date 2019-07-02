/**
 * 
 */
package com.java.encoding;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * @author PE
 * @date 2019年6月25日 下午5:24:07
 * @explain
 */
public class Test {
	public static void main(String[] args) {
		String str = "中";
		// 中文在个编码下的显示
		showCode(str);

		// 读取中文
		test();
	}

	private static void showCode(String str) {
		String[] encodes = { "BIG5", "GBK", "GB2312", "UTF-8", "UTF-16", "UTF-32" };
		for (String encode : encodes) {
			showCode(str, encode);
		}

	}

	private static void showCode(String str, String encode) {
		try {
			System.out.printf("字符: \"%s\" 的在编码方式%s下的十六进制值是%n", str, encode);
			byte[] bs = str.getBytes(encode);

			for (byte b : bs) {
				int i = b & 0xff;
				System.out.print(Integer.toHexString(i) + "\t");
			}
			System.out.println();
			System.out.println();
		} catch (UnsupportedEncodingException e) {
			System.out.printf("UnsupportedEncodingException: %s编码方式无法解析字符%s\n", encode, str);
		}
	}

	// 读取文件
	public static void test() {
		File f = new File("d:/encodingFile.txt");
		System.out.println("默认编码方式:" + Charset.defaultCharset());
		try (FileInputStream fis = new FileInputStream(f);) {
			byte[] all = new byte[(int) f.length()];
			fis.read(all);
			System.out.printf("FileReader会使用默认的编码方式%s,识别出来的字符是：%n", Charset.defaultCharset());
			System.out.println(new String(all, "UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (InputStreamReader isr = new InputStreamReader(new FileInputStream(f), Charset.forName("UTF-8"))) {
			char[] cs = new char[(int) f.length()];
			isr.read(cs);
			System.out.printf("InputStreamReader 指定编码方式UTF-8,识别出来的字符是：%n");
			System.out.println(new String(cs));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
