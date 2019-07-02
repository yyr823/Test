/**
 * 
 */
package com.reflection.test2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.reflection.Hero;

/**
 * @author PE
 * @date 2019年7月2日 下午1:31:19
 * @explain 读取hero.config的数据，取出其中的类名，根据类名实例化出对象，然后返回对象
 */
public class ReadConfig {
	public static void main(String[] args) {

		File file = new File("D:/Download/Test/src/com/reflection/hero.config");
		String className = ReadConfig.getClassName(file);
		try {
			Hero hero = (Hero) Class.forName(className).newInstance();
			hero.name = "rg";
			System.out.println(hero);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String getClassName(File file) {
		String className = null;
		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
			className = br.readLine();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return className;

	}
}
