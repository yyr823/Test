/**
 * 
 */
package com.java.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * out和in是相对程序的，程序写文件就是out，程序读文件就是in
 * 
 * @author PE
 * @date 2019年6月26日 下午2:06:13
 * @explain 把一个对象序列化有一个前提是：这个对象的类，必须实现了Serializable接口
 */
public class SerializableTest {
	public static void main(String[] args) {

		// 准备一个文件用于保存该对象
		File f = new File("d:/garen.txt");
		// 序列化对象
		heroSerializable(f);
		// 序列化数组
		arraySerializable(f);

	}

	public static void heroSerializable(File f) {
		// 要把Hero对象直接保存在文件上，务必让Hero类实现Serializable接口
		Hero h = new Hero();
		h.name = "garen";
		h.hp = 616;

		try (
				// 创建 【对象输出流】
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				// 创建 【对象输入流】
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			oos.writeObject(h);
			Hero h2 = (Hero) ois.readObject();
			System.out.println(h2.name);
			System.out.println(h2.hp);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 序列化数组
	public static void arraySerializable(File f) {
		// 创建10个英雄
		Hero[] heros = new Hero[10];
		for (int i = 0; i < heros.length; i++) {
			heros[i] = new Hero();
			heros[i].name = "garlon" + i;
			heros[i].hp = ((int) (Math.random() * 10));
			System.out.println(heros[i].name + " " + heros[i].hp);
		}
		// 写入10个英雄
		try (FileOutputStream fos = new FileOutputStream(f); ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			for (int i = 0; i < heros.length; i++) {
				oos.writeObject(heros[i]);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 读取10个英雄
		try (FileInputStream fis = new FileInputStream(f); ObjectInputStream ois = new ObjectInputStream(fis);) {

			for (int i = 0; i < heros.length; i++) {
				heros[i] = (Hero) ois.readObject();
				System.out.println(heros[i].name);
				System.out.println(heros[i].hp);
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	}
}
