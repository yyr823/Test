/**
 * 
 */
package com.swing.test7;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

/**
 * @author PE
 * @date 2019年7月1日 下午2:33:33
 * @explain 显示文件夹复制进度条
 */
public class Test5 {

	public static JProgressBar pb = new JProgressBar();
	public static JFrame jf = new JFrame("带进度条的文件夹复制");
	public static JTextField srcTf = new JTextField("");
	public static JTextField destTf = new JTextField("");
	public static double totalLength = 0;
	public static double currentLength = 0;

	public static void main(String[] args) {

		jf.setSize(450, 140);
		jf.setLocation(200, 200);
		jf.setLayout(new FlowLayout());

		// 文件地址
		JLabel lStr = new JLabel("源文件地址：");
		srcTf.setText("D:\\testpro\\Attend");
		srcTf.setPreferredSize(new Dimension(100, 30));
		JLabel lDest = new JLabel("复制到：");
		destTf.setText("D:\\temp");
		destTf.setPreferredSize(new Dimension(100, 30));

		jf.add(lStr);
		jf.add(srcTf);
		jf.add(lDest);
		jf.add(destTf);

		JButton bStartCopy = new JButton("开始复制");
		bStartCopy.setPreferredSize(new Dimension(100, 30));
		JLabel l = new JLabel("复制进度：");
		pb.setMaximum(100);
		pb.setStringPainted(true);
		jf.add(bStartCopy);
		jf.add(l);
		jf.add(pb);
		// 计算文件(夹)大小
		calAllFile(new File(srcTf.getText()));
		bStartCopy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				new Thread() {
					@Override
					public void run() {
						copyFolder(srcTf.getText(), destTf.getText());
						bStartCopy.setEnabled(false);
						if (pb.getValue() == 100) {
							JOptionPane.showMessageDialog(jf, "复制完成");
						}
					}
				}.start();
			}
		});

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}

	/**
	 * 进度条控制 
	 * @param srcFolder  源文件夹
	 * @param destFolder 目标文件夹
	 */
	public static void copyFolder(String srcFolder, String destFolder) {
		File folder = new File(srcFolder);
		File file2 = new File(destFolder);
		File[] files = folder.listFiles();

		if (!folder.isDirectory())
			return;
		if (file2.isFile())
			return;
		if (!folder.exists())
			return;
		if (!file2.exists())
			file2.mkdirs();
		for (File f : files)
			if (f.isFile()) {
				File destFile = new File(file2, f.getName());
				copyFile(f.getAbsolutePath(), destFile.getAbsolutePath());
				currentLength = currentLength + (int) f.length();
				System.out.println("已复制文件大小： " + currentLength);
				System.out.println("文件总大小:     " + totalLength);
				double progress = currentLength / totalLength;
				int pro = (int) (progress * 100);
				System.out.println("进度：  " + pro);
				pb.setValue(pro);
			} else if (f.isDirectory()) {
				File destFoldernew = new File(file2, f.getName());
				copyFolder(f.getAbsolutePath(), destFoldernew.getAbsolutePath());
			}
	}

	/**
	 * 开始copy文件
	 * @param srcFilePath 源文件路径
	 * @param destFilePath 文件存放的目标路径
	 */
	public static void copyFile(String srcFilePath, String destFilePath) {
		File file = new File(srcFilePath);
		File file3 = new File(destFilePath);
		System.out.println("copy file: " + file.getName());
		byte[] bytes = new byte[(int) file.length()];
		try (FileInputStream fi = new FileInputStream(file);) {
			fi.read(bytes);

		} catch (IOException e) {

			e.printStackTrace();
		}
		try (FileOutputStream fo = new FileOutputStream(file3);

		) {
			fo.write(bytes);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 计算原文件大小
	 * @param file
	 */
	public static void calAllFile(File file) {
		if (file.isFile())
			totalLength = totalLength + file.length();
		else if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				calAllFile(f);
			}
		}
	}
}
