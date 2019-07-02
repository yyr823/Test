/**
 * 
 */
package com.java.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author PE
 * @date 2019年6月25日 下午4:20:33
 * @explain
 */
public class TestStream {
	public static void main(String[] args) throws Exception {
		// 以字节流的形式读取文件内容
		inputTest();
		// 以字节流的形式向文件写入数据
		outputTest();
		// 使用字符流读取文件
		readerTest();
		// 使用字符流把字符串写入到文件
		outputReaderTest();
		// 拆分文件
		CutFile(new File("D:\\exe\\RedisClient\\openssl-1.1.1-pre6.tar.gz"), 9);
		// 拆分文件(可行)
		splitfile("D:/exe/RedisClient/openssl-1.1.1-pre6.tar.gz", 1024 * 1024);
		// 合并文件(可行)
		multifile("D:/exe/RedisClient/openssl-1.1.1-pre6.tar.gz_split");
	}

	public static void readerTest() {
		File f = new File("d:/lol.txt");
		// 创建基于文件的Reader
		try (FileReader fr = new FileReader(f)) {
			// 创建字符数组，其长度就是文件的长度
			char[] all = new char[(int) f.length()];
			// 以字符流的形式读取文件所有内容
			fr.read(all);
			for (char b : all) {
				// 打印出来是A B
				System.out.println(b);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void outputReaderTest() {
		// 准备文件lol2.txt
		File f = new File("d:/lol2.txt");
		// 创建基于文件的Writer
		try (FileWriter fr = new FileWriter(f)) {
			// 以字符流的形式把数据写入到文件中
			String data = "abcdefg1234567890";
			char[] cs = data.toCharArray();
			fr.write(cs);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void inputTest() {
		try {
			// 准备文件lol.txt其中的内容是AB，对应的ASCII分别是65 66
			File f = new File("d:/hello/lol.txt");

			// 创建基于文件的输入流
			FileInputStream fis = new FileInputStream(f);
			// 创建字节数组，其长度就是文件的长度
			byte[] all = new byte[(int) f.length()];
			// 以字节流的形式读取文件所有内容
			fis.read(all);
			for (byte b : all) {
				// 打印出来是65 66
				System.out.println(b);
			}

			// 每次使用完流，都应该进行关闭
			fis.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void outputTest() {
		try {
			// 准备文件lol2.txt其中的内容是空的
			File f = new File("d:/hello/lol2.txt");
			// 获得父目录生成文件夹
			f.getParentFile().mkdirs();
			// 准备长度是2的字节数组，用88,89初始化，其对应的字符分别是X,Y
			byte data[] = { 88, 89 };

			// 创建基于文件的输出流
			FileOutputStream fos = new FileOutputStream(f);
			// 把数据写入到输出流
			fos.write(data);
			// 关闭输出流
			fos.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 分割文件 读取一段，写入这读取的一段
	 * 
	 * @param path
	 *            传入的文件路径
	 * @throws Exception
	 */
	private static void splitfile(String path, int split_byte) {
		File file_dir = new File(path + "_split");
		if (file_dir.exists()) {
			file_dir.delete();
		}
		file_dir.mkdirs();// 创建分割文件存放的文件夹
		File file = new File(path);
		if (!file.isFile())
			return;// 当此不为文件时，不继续执行
		/* 开始分割 */
		// 读入
		// 起始下标
		int off = 0;
		// 每次读入的数量
		int len = split_byte;
		// 分为多少个文件
		int num = (int) file.length() / split_byte + 1;
		// 除了完整的100bit文件之外余下的哪一个文件有多少字节
		int remain = (int) (file.length() % split_byte);
		// 输入流
		FileInputStream fis = null;
		// 创建写入文件流
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file);
			// 读入的数组
			byte[] inBy = new byte[(int) file.length()];
			// 循环，每次循环都读入特定数量字节，然后写出到part文件
			for (int i = 0; i < num; i++) {
				// 读入的字节
				if (i == num - 1) {
					len = remain;
				}
				fis.read(inBy, off, len);
				// 创建写入文件
				File outf = new File(file_dir, file.getName() + "_" + (i + 1) + ".part");
				// 初始化写入文件流
				fos = new FileOutputStream(outf);
				// 写入
				fos.write(inBy, off, len);
				// 开始的下标向后移动100
				off += split_byte;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 在finally 里关闭流
			if (null != fis)
				try {

					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (null != fos)
				try {

					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

	/**
	 * 合并被分割的文件 遍历读取后合并再写入
	 * 
	 * @param path
	 *            被分割文件所存放的文件夹
	 */
	private static void multifile(String path) {
		File splited_file = new File(path);
		if (!splited_file.exists() || !splited_file.isDirectory())
			return;// 当不存在此文件夹或者不是一个文件夹则不继续执行
		// 获取此文件夹下的文件列表
		File[] files = splited_file.listFiles();
		// 创建一个有序的容器将单个文件的byte数组存储起来，这里选用list
		ArrayList<byte[]> bytesArray = new ArrayList<>();
		// 创建文件输入流
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			// 开始读入分文件，存放到字节数组中
			for (File file : files) {// 遍历
				// 判断是否为文件,不是则继续下一个
				if (!file.isFile())
					continue;
				// 判断文件结尾是否以part*结尾,不是则继续下一个
				if (file.getName().endsWith(".part*"))
					continue;
				// 初始化文件输入流
				fis = new FileInputStream(file);
				byte[] inByte = new byte[(int) file.length()];
				fis.read(inByte);
				// 将读入的数组加入到list
				bytesArray.add(inByte);
			}
			// 遍历list，将遍历到的byte数组合并为一个
			byte[] result = new byte[0];
			for (byte[] b : bytesArray) {
				result = concatAll(result, b);
			}
			// 创建文件输出流
			fos = new FileOutputStream(splited_file.getParentFile().getAbsolutePath() + "\\合并_"
					+ splited_file.getName().substring(0, splited_file.getName().lastIndexOf("_")));
			// 此时resul已经是所有文件的输入流字节合并
			fos.write(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 在finally 里关闭流
			if (null != fis)
				try {

					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (null != fos)
				try {

					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	/**
	 * 合并多个读入的byte数组
	 *
	 * @param first
	 *            第一个
	 * @param rest
	 *            后面可以多个
	 * @return
	 */
	private static byte[] concatAll(byte[] first, byte[]... rest) {
		int totalLength = first.length;
		for (byte[] array : rest) {
			totalLength += array.length;
		}
		byte[] result = Arrays.copyOf(first, totalLength);
		int offset = first.length;
		for (byte[] array : rest) {
			System.arraycopy(array, 0, result, offset, array.length);
			offset += array.length;
		}
		return result;
	}

	// 拆分文件
	public static void CutFile(File f, int m) {
		// 获取文件信息
		if (f.isFile()) {
			long length;
			length = f.length();
			// 文件名称
			String FileName = f.getName().substring(0, f.getName().indexOf("."));
			// 文件的后缀
			String EndName = f.getName().substring(f.getName().lastIndexOf("."), f.getName().length());
			FileInputStream in = null;
			try {
				in = new FileInputStream(f);
				for (int i = 1; i < m; i++) {
					StringBuffer sBuffer = new StringBuffer();
					sBuffer.append(f.getParent()).append("\\").append(FileName).append("_data").append(i)
							.append(EndName);
					System.out.println(sBuffer.toString());// 新的文件路径
					File file2 = new File(sBuffer.toString());
					// 创建写文件的输出流
					FileOutputStream fileOutputStream = new FileOutputStream(file2);
					int len = -1;
					byte[] bytes = new byte[1024 * 1024];
					while ((len = in.read(bytes)) != -1) {
						fileOutputStream.write(bytes, 0, len);
						if (file2.length() > length / m) {
							break;
						}
					}
					fileOutputStream.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			}
		}

	}
}
