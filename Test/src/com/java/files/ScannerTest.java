/**
 * 
 */
package com.java.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author PE
 * @date 2019年6月26日 下午2:17:01
 * @explain
 */
public class ScannerTest {

	public static void main(String[] args) {
		File f = new File("D:/testpro/Test/cat/Cat.java");
		// 创建类
		// 第一种方式:
		createClass(f);
		// 第二种方式
		replaceTest();

		// 控制台输入
		/*
		 * try (InputStream is = System.in;) { while (true) { // 敲入a,然后敲回车可以看到 // 97 13
		 * 10 // 97是a的ASCII码 // 13 10分别对应回车换行 int i = is.read(); System.out.println(i);
		 * }
		 * 
		 * } catch (IOException e) { e.printStackTrace(); }
		 */
	}

	public static void createClass(File f) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("输入类名:");
		String Class = sc.next();
		System.out.println("输入属性类型:");
		String type = sc.next();
		System.out.println("输入属性名称:");
		String typeName = sc.next();
		sc.close();
		String s = typeName.substring(0, 1).toUpperCase() + typeName.substring(1);// 首字母转大写

		try {
			FileWriter fw = new FileWriter(f);
			PrintWriter pw = new PrintWriter(fw);
			pw.printf("public class %s {%n", Class);
			pw.printf("public %s %s;%n", type, typeName);
			pw.printf(" public %s() {}%n", Class);
			pw.printf("public void set%s(%s  %s){\r\n" + "        this.%s = %s;\r\n" + "    }", s, type, typeName,
					typeName, typeName);
			pw.printf("public void get%s(%s  %s){\r\n" + "        this.%s = %s;\r\n" + "    }", s, type, typeName,
					typeName, typeName);
			System.out.println("文件已保存到:" + f.getPath());
			pw.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("结束！");
	}

	public static void replaceTest() {
		Scanner s = new Scanner(System.in);
		System.out.println("请输入类名：");
		String className = s.next();
		System.out.println("请输入属性的类型：");
		String variableType = s.next();
		System.out.println("请输入属性的名称：");
		String variableName = s.next();
		File modelClass = new File("D:\\testpro\\Test\\cat\\Template.java");
		File newClass = new File("D:/testpro/Test/src/com/yyr/files/" + className + ".java");
		// getter、setter方法里的属性首字母要大写，如getName或setName
		char[] vn = variableName.toCharArray();
		vn[0] = Character.toUpperCase(vn[0]);
		String Uvn = String.valueOf(vn);
		if (!newClass.getParentFile().exists())
			newClass.getParentFile().mkdirs();
		try (FileReader fr = new FileReader(modelClass);
				BufferedReader br = new BufferedReader(fr);
				FileWriter fw = new FileWriter(newClass);
				PrintWriter pw = new PrintWriter(fw);) {
			System.out.println("替换后的内容：");
			while (true) {
				String str = br.readLine();
				if (str == null)
					break;

				str = str.replaceAll("@class@", className);
				str = str.replaceAll("@type@", variableType);
				str = str.replaceAll("@property@", variableName);
				str = str.replaceAll("@Uproperty@", Uvn);
				pw.println(str);
				System.out.println(str);
			}
			System.out.println("已自动生成java类文件，保存在：" + newClass.getAbsolutePath());
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

}
