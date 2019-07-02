/**
 * 
 */
package com.java.encoding;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author PE
 * @date 2019年6月26日 下午1:03:18
 * @explain 移除BOM
 */
public class BomTest {
	public static void main(String[] args) throws UnsupportedEncodingException {
		byte[] b = new byte[3];
		b[0] = (byte) 0xE8;
		b[1] = (byte) 0xB1;
		b[2] = (byte) 0x8C;
		byte[] date = { (byte) 0xE5, (byte) 0xB1, (byte) 0X8C };
		System.out.println(new String(b, "UTF-8"));
		System.out.println(new String(date, "UTF-8"));
		String a = "E5B18C";
		System.out.println(convertUTF8ToString(a));
		File UTF8 = new File("d:/encodingFile.txt");
		// 寻找BOM
		findBOM(UTF8);
		// 移除BOM 其实就相当于copy一份 使其文件编码为UTF-8
		removeBOM(UTF8);

	}

	public static String convertUTF8ToString(String s) {
		if (s == null || s.equals("")) {
			return null;
		}

		try {
			s = s.toUpperCase();

			int total = s.length() / 2;
			int pos = 0;

			byte[] buffer = new byte[total];
			for (int i = 0; i < total; i++) {

				int start = i * 2;

				buffer[i] = (byte) Integer.parseInt(s.substring(start, start + 2), 16);
				pos++;
			}
			return new String(buffer, 0, pos, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return s;
	}

	public static void findBOM(File UTF8) {
		// 读取一个空的UTF-8编码文件数据，可以得到BOM的内
		byte[] BOMData = new byte[(int) UTF8.length()];
		try (FileInputStream fis = new FileInputStream(UTF8)) {
			fis.read(BOMData);
		} catch (IOException i) {
			i.printStackTrace();
		}
		System.out.println("BOM对应的十六进制是：");
		for (byte b : BOMData) {
			// byte转int需要&0xff，因为byte是1个字节8位，int是4个字节32位，java会默认补码把前24位补成1，导致数据出错
			int a = b & 0xff;
			System.out.print(Integer.toHexString(a) + " ");
		}
		System.out.printf("%n");
	}

	public static void removeBOM(File f) {
		System.out.printf("选中的文件为：%s%n", f.getAbsolutePath());
		byte[] data = new byte[(int) f.length()];
		try (FileInputStream fis = new FileInputStream(f)) {
			fis.read(data);
		} catch (IOException i) {
			i.printStackTrace();
		}
		if (f.length() < 3 || data[0] != -17 || data[1] != -69 || data[2] != -65) {
			System.out.println("该文件不是UTF-8编码格式");
			return;
		} else {
			byte[] newData = new byte[(int) (data.length - 3)];
			for (int i = 0; i < newData.length; i++)
				newData[i] = data[i + 3];
			File newF = new File(f.getParent() + "/new-" + f.getName());
			newF.getParentFile().mkdirs();
			try (FileOutputStream fos = new FileOutputStream(newF)) {
				fos.write(newData);
			} catch (IOException i) {
				i.printStackTrace();
			}
			System.out.printf("该文件是UTF-8编码格式，已去除BOM并输出新文件：%s%n", newF.getAbsolutePath());

		}
	}

}
