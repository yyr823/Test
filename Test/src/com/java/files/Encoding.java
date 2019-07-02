/**
 * 
 */
package com.java.files;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author PE
 * @date 2019年6月25日 下午5:16:23
 * @explain
 */
public class Encoding {

	public static void main(String[] args) {
		File encodingFile = new File("D:/encodingFile.txt");
		File encodedFile = new File("D:/encodedFile.txt");
		File decodedFile = new File("D:/decodedFile.txt");
		encodeFile(encodingFile, encodedFile);
		decodeFile(encodedFile, decodedFile);
	}

	/**
	 * 加密算法： 数字： 如果不是9的数字，在原来的基础上加1，比如5变成6, 3变成4 如果是9的数字，变成0 字母字符：
	 * 如果是非z字符，向右移动一个，比如d变成e, G变成H 如果是z，z->a, Z-A。 字符需要保留大小写 非字母字符 比如',&^
	 * 保留不变，中文也保留不变
	 * 
	 * @param encodingFile
	 *            需要加密的文件
	 * @param encodedFile
	 *            加密后的文件
	 */
	public static void encodeFile(File encodingFile, File encodedFile) {
		char[] encodingData = new char[(int) encodingFile.length()];
		char[] encodedData = new char[(int) encodingFile.length()];
		encodedFile.getParentFile().mkdirs();
		try (FileReader fr = new FileReader(encodingFile)) {
			fr.read(encodingData);
		} catch (IOException i) {
			i.printStackTrace();
		}
		System.out.println("加密前的内容：");
		for (int i = 0; i < encodingData.length; i++) {
			System.out.print(encodingData[i]);
			if (encodingData[i] >= '0' && encodingData[i] < '9')
				encodingData[i] = (char) (encodingData[i] + 1);
			else if (encodingData[i] == '9')
				encodingData[i] = (char) 48;
			else if (Character.toUpperCase(encodingData[i]) >= 'A' && Character.toUpperCase(encodingData[i]) < 'Z')
				encodingData[i] = (char) (encodingData[i] + 1);
			else if (Character.toUpperCase(encodingData[i]) == 'Z')
				encodingData[i] = (char) (encodingData[i] - 25);
			else
				continue;
		}
		System.out.printf("%n");
		try (FileWriter fw = new FileWriter(encodedFile)) {
			fw.write(encodingData);
		} catch (IOException i) {
			i.printStackTrace();
		}
		System.out.println("加密后的内容：");
		try (FileReader fr = new FileReader(encodedFile)) {
			fr.read(encodedData);
			for (char c : encodedData)
				System.out.print(c);
		} catch (IOException i) {
			i.printStackTrace();
		}
		System.out.printf("%n");
	}

	/**
	 * 解密算法： 数字： 如果不是0的数字，在原来的基础上减1，比如6变成5, 4变成3 如果是0的数字，变成9 字母字符：
	 * 如果是非a字符，向左移动一个，比如e变成d, H变成G 如果是a，a->z, A-Z。 字符需要保留大小写 非字母字符： 比如',&^
	 * 保留不变，中文也保留不变
	 * 
	 * @param decodingFile
	 *            加密后的文件
	 * @param decodedFile
	 *            解密后的文件
	 */
	public static void decodeFile(File decodingFile, File decodedFile) {
		char[] decodedData = new char[(int) decodingFile.length()];
		decodedFile.getParentFile().mkdirs();// 如果没有就进行创建
		try (FileReader fr = new FileReader(decodingFile)) {
			fr.read(decodedData);
		} catch (IOException i) {
			i.printStackTrace();
		}
		System.out.println("解密后的内容：");
		for (int i = 0; i < decodedData.length; i++) {
			if (decodedData[i] > '0' && decodedData[i] <= '9')
				decodedData[i] = (char) (decodedData[i] - 1);
			else if (decodedData[i] == '0')
				decodedData[i] = (char) 57;
			else if (Character.toUpperCase(decodedData[i]) > 'A' && Character.toUpperCase(decodedData[i]) <= 'Z')
				decodedData[i] = (char) (decodedData[i] - 1);
			else if (Character.toUpperCase(decodedData[i]) == 'A')
				decodedData[i] = (char) (decodedData[i] + 25);
			else {
				System.out.print(decodedData[i]);
				continue;
			}
			System.out.print(decodedData[i]);
		}
		System.out.printf("%n");
		try (FileWriter fw = new FileWriter(decodedFile)) {
			fw.write(decodedData);
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

}
