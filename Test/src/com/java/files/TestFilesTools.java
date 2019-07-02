/**
 * 
 */
package com.java.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author PE
 * @date 2019年6月26日 下午2:43:35
 * @explain
 */
public class TestFilesTools {
	public static void main(String[] args) {
		String srcFile = "d:/lol2.txt";
		String destFile = "D:/temp/lol2.txt";
		// 复制文件是常见的IO操作,实现复制源文件srcFile到目标文件destFile
		copyFile(srcFile, destFile);

		// 复制文件夹,把源文件夹下所有的文件 复制到目标文件夹下(包括子文件夹)
		String srcFolder = "D:/farbox";
		String destFolder = "D:/farbox/farbox-副本";
		System.out.println("要进行复制的文件夹为：" + srcFolder);
		copyFolder(srcFolder, destFolder);
		// 假设你的项目目录是 D:\testpro\Test，遍历这个目录下所有的java文件
		// （包括子文件夹），找出文件内容包括 Magic的那些文件，并打印出来
		File file = new File("D:\\testpro\\Test");
		search(file, "DataOutputStreamTest");
	}

	// 复制文件是常见的IO操作,实现复制源文件srcFile到目标文件destFile
	public static void copyFile(String srcFile, String destFile) {
		File file = new File(srcFile);
		File newfile = new File(destFile);
		try (FileInputStream fReader = new FileInputStream(file);
				FileOutputStream fileWriter = new FileOutputStream(newfile);) {
			byte[] cs = new byte[(int) file.length()];
			fReader.read(cs);
			fileWriter.write(cs);
			System.out.println("复制的文件保存在：" + newfile.getAbsolutePath());
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	// 复制文件夹,把源文件夹下所有的文件 复制到目标文件夹下(包括子文件夹)
	public static void copyFolder(String srcFolder, String destFolder) {
		File srcF = new File(srcFolder);
		File destF = new File(destFolder);
		if (!srcF.exists()) {
			System.out.println("源文件夹不存在！");
			return;
		}
		if (srcFolder.equals(destFolder)) {
			System.out.println("目标文件夹与源文件夹名称一致且在同一目录，复制无效");
			return;
		}
		// 得先读取文件列表再创建目标文件夹，否则如果目标文件夹是源文件夹的子目录，那么
		// 目标文件夹会包含在待复制的文件列表里，造成死循环无限递归
		File[] allFiles = srcF.listFiles();
		if (!destF.exists())
			destF.mkdirs();
		if (null == allFiles)
			return;
		for (File eachFile : allFiles) {
			if (eachFile.isDirectory()) {
				// 若文件列表里有子文件夹，递归对其进行相同的复制操作
				String subSrcFolder = new String(eachFile.getAbsolutePath());
				String subDestFolder = new String(destFolder + "/" + eachFile.getName());
				copyFolder(subSrcFolder, subDestFolder);
			} else if (eachFile.isFile()) {
				try (FileInputStream fis = new FileInputStream(eachFile);
						FileOutputStream fos = new FileOutputStream(destFolder + "/" + eachFile.getName());) {
					byte[] data = new byte[(int) eachFile.length()];
					fis.read(data);
					fos.write(data);
				} catch (IOException i) {
					i.printStackTrace();
				}
			}
		}
		System.out.println("已将源文件夹中所有文件复制至目标文件夹：" + destFolder);
	}

	// 假设你的项目目录是 D:\testpro\Test，遍历这个目录下所有的java文件
	// （包括子文件夹），找出文件内容包括 Magic的那些文件，并打印出来
	public static void search(File folder, String search) {
		File[] allFiles = folder.listFiles();
		for (File eachFile : allFiles) {
			if (eachFile.isFile()) {
				// 判断是否为java文件
				String name = eachFile.getName();
				// 如果是java文件，判断文件中是否含有要查找的内容
				if (name.substring(name.lastIndexOf("."), name.length()).equals(".java")) {
					try ( BufferedReader br = new BufferedReader(new FileReader(eachFile));) {
						char[] data = new char[(int) eachFile.length()];
						br.read(data);
						String str = String.valueOf(data);
						if (str.contains(search))
							System.out.printf("找到子目标字符串%s，在文件：%s%n", search, eachFile.getAbsoluteFile());
					} catch (IOException i) {
						i.printStackTrace();
					}
				}
			} else if (eachFile.isDirectory()) {
				if (null != eachFile.listFiles()) {
					search(eachFile, search);
				}
			}
		}
	}

}
