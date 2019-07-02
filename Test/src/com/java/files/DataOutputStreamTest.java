package com.java.files;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author PE
 * @date 2019年6月26日 下午1:51:57
 * @explain 要用DataInputStream 读取一个文件，这个文件必须是由DataOutputStream
 *          写出的，否则会出现EOFException，因为DataOutputStream
 *          在写出的时候会做一些特殊标记，只有DataInputStream 才能成功的读取
 */
public class DataOutputStreamTest {
	public static void main(String[] args) {
		File f = new File("d:/out.txt");
		// 写入数据
		write(f);
		// 读取数据
		read(f);
		// 两种方式写入数据并进行读取
		writeAndRead(f);
	}

	private static void read(File f) {

		try (FileInputStream fis = new FileInputStream(f); DataInputStream dis = new DataInputStream(fis);) {
			boolean b = dis.readBoolean();
			int i = dis.readInt();
			double d = dis.readDouble();
			int k = dis.readInt();
			String str = dis.readUTF();
			System.out.println("读取到布尔值:" + b);
			System.out.println("读取到整数:" + i);
			System.out.println("读取到浮点数:" + d);
			System.out.println("读取到整数1:" + k);
			System.out.println("读取到字符串:" + str);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void write(File f) {
		try (FileOutputStream fos = new FileOutputStream(f); DataOutputStream dos = new DataOutputStream(fos);) {
			dos.writeBoolean(true);
			dos.writeInt(300);
			dos.writeDouble(300);
			dos.writeInt(400);
			dos.writeUTF("123 this is gareen");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void writeAndRead(File f) {
		// 使用缓存流把两个数字以字符串的形式写到文件里，再用缓存流以字符串的形式读取出来
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(f);
			PrintWriter pw = new PrintWriter(fw);
			pw.write("666@777");// 写入文件
			pw.close();
			String line = br.readLine();// 获取一行字符串
			br.close();
			String[] s = line.split("@");// 字符串以'@'分割成字符串数组
			System.out.println("第一位数：" + s[0] + "\n第二位数:" + s[1]);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("写入读出结束!");
		// 第二种方式： 使用数据流DataOutputStream向文件连续写入两个数字，然后用DataInpuStream连续读取两个数字
		try {
			FileOutputStream fo = new FileOutputStream(f);
			FileInputStream fi = new FileInputStream(f);
			DataOutputStream ds = new DataOutputStream(fo);
			ds.writeUTF("55@123");
			ds.close();
			DataInputStream di = new DataInputStream(fi);
			String line = di.readUTF();
			di.close();
			String[] s = line.split("@");
			System.out.println("第一个数:" + s[0] + "\n第二个数:" + s[1]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("写入读出结束!");
	}

}
