/**
 * 
 */
package com.swing.test11;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.eltima.components.ui.DatePicker;

/**
 * @author PE
 * @date 2019年7月1日 下午4:14:42
 * @explain 借助时间控件，选中一个时间，然后根据这个时间， 统计某个路径下 修改时间大于这个时间的文件，一共有多少
 */
public class Test {
	private static int counter = 0;
	private static int filesum = 0;

	public static void main(String[] args) {
		String filesrc = "D:\\deyuanFile";

		JFrame f = new JFrame("LoL");
		f.setSize(405, 300);
		f.setLocation(200, 200);
		f.setLayout(null);

		DatePicker datepick = getDatePicker();

		f.add(datepick);

		JButton b = new JButton("统计在" + filesrc + " 目录下，修改时间大于控件日期的文件总数");
		b.setBounds(5, 183, 380, 30);
		f.add(b);

		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				counter = 0;
				filesum = 0;
				String filetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(datepick.getValue());
				System.out.println("控件日期为：" + filetime);
				System.out.println("要搜索的文件路径为：" + filesrc);
				search(new File(filesrc), filetime);
				JOptionPane.showMessageDialog(f, "总文件数量为：" + filesum + "\n满足条件的文件总数为：" + counter);
			}
		});

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	public static void search(File folder, String filetime) {
		File[] fs = folder.listFiles();

		for (File f : fs) {
			if (f.isDirectory()) {
				search(f, filetime);
			} else {
				try (FileReader fis = new FileReader(f); BufferedReader br = new BufferedReader(fis)) {
					String modifiedtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
							.format(new Date(f.lastModified()));
					if (modifiedtime.compareTo(filetime) < 0)
						counter++;
					filesum++;
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private static DatePicker getDatePicker() {
		final DatePicker datepick;
		// 格式
		String DefaultFormat = "yyyy-MM-dd HH:mm:ss";
		// 当前时间
		Date date = new Date();
		// 字体
		Font font = new Font("Times New Roman", Font.BOLD, 16);

		Dimension dimension = new Dimension(200, 30);

		int[] hilightDays = { 1, 3, 5, 7 };

		datepick = new DatePicker(date, DefaultFormat, font, dimension);
		// datepick.setLocation(100, 83);
		datepick.setBounds(105, 83, 177, 24);
		// 设置一个月份中需要高亮显示的日子
		datepick.setHightlightdays(hilightDays, Color.red);
		// 设置一个月份中不需要的日子，呈灰色显示
		// datepick.setDisableddays(disabledDays);
		// 设置国家
		datepick.setLocale(Locale.CHINA);
		// 设置时钟面板可见
		datepick.setTimePanleVisible(true);
		return datepick;
	}
}
