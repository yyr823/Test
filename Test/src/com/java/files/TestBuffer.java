/**
 * 
 */
package com.java.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author PE
 * @date 2019年6月26日 下午1:28:57
 * @explain
 */
public class TestBuffer {

	public static void main(String[] args) {
		File f = new File("d:/encodingFile.txt");
		// 使用缓存流读取数据
		testBufferedReader(f);
		// 使用缓存流写出数据
	     testBufferedWriter(f);
		// 移除注释//
		removeComments(f);

	}

	public static void testBufferedReader(File f) {
		// 准备文件lol.txt其中的内容是
		// garen kill teemo
		// teemo revive after 1 minutes
		// teemo try to garen, but killed again

		// 创建文件字符流
		// 缓存流必须建立在一个存在的流的基础上
		try (FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr);) {
			while (true) {
				// 一次读一行
				String line = br.readLine();
				if (null == line)
					break;
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void testBufferedWriter(File f) {

		try (
				// 创建文件字符流
				FileWriter fw = new FileWriter(f);
				// 缓存流必须建立在一个存在的流的基础上
				PrintWriter pw = new PrintWriter(fw);) {
			pw.println("garen kill teemo");
			// 有的时候，需要立即把数据写入到硬盘，而不是等缓存满了才写出去。 这时候就需要用到flush
			// 强制把缓存中的数据写入硬盘，无论缓存是否已满
			pw.flush();
			pw.println("teemo revive after 1 minutes");
			pw.println("teemo try to garen, but killed again");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void removeComments(File file_in) {
		File file_out = new File("D:/out.txt");
		try (FileReader fr = new FileReader(file_in);
				BufferedReader br = new BufferedReader(fr);
				FileWriter fw = new FileWriter(file_out);
				PrintWriter pw = new PrintWriter(fw);) {
			while (true) {
				// 读取一行
				String line = br.readLine();
				if (line == null)
					break;
				/*
				 * if(!line.trim().startsWith("//")) pw.println(line);
				 */

				// 检测是否有"//"
				String buff = null;
				int index = line.indexOf("//");
				if (index == -1)
					buff = line;
				else
					buff = line.substring(0, index);
				// 打印并写入
				System.out.println(buff);
				pw.println(buff);
				pw.flush();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
