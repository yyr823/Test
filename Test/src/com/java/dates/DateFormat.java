/**
 * 
 */
package com.java.dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * @author PE
 * @date 2019年6月25日 下午2:09:56
 * @explain 日期转换
 */
public class DateFormat {
	// y 代表年
	// M 代表月
	// d 代表日
	// H 代表24进制的小时
	// h 代表12进制的小时
	// m 代表分钟
	// s 代表秒
	// S 代表毫秒
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		Date d = new Date();
		String str = sdf.format(d);
		System.out.println("当前时间通过 yyyy-MM-dd HH:mm:ss SSS 格式化后的输出: " + str);

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = new Date();
		String str1 = sdf1.format(d1);
		System.out.println("当前时间通过 yyyy-MM-dd 格式化后的输出: " + str1);

		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		String str2 = "2016/1/5 12:12:12";

		try {
			Date da = sdf2.parse(str2);
			System.out.printf("字符串 %s 通过格式  yyyy/MM/dd HH:mm:ss %n转换为日期对象: %s", str2, da.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sortDate();

	}

	public static void sortDate() throws ParseException {
		Calendar c1 = Calendar.getInstance();
		c1.set(1970, 01, 01, 00, 00, 00);
		Calendar c2 = Calendar.getInstance();
		c2.set(2000, 12, 31, 23, 59, 59);
		Date[] dates = new Date[9];
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		// 初始化数组
		for (int i = 0; i < dates.length; i++) {
			double rantime = Math.random() * (c2.getTimeInMillis() - c1.getTimeInMillis());
			long time = (long) (rantime) + c1.getTimeInMillis();
			dates[i] = new Date(time);
		}

		// 打印
		int k = 0;
		System.out.println("\n");
		System.out.println("排序之前：");
		for (int i = 0; i < dates.length; i++) {
			System.out.print(sdf.format(dates[i]) + "   ");
			k++;
			if (k % 3 == 0)
				System.out.println();
		}
		// 一:数组排序(升序)
		// Arrays.sort(dates);
		// 二:选择排序法

		/*
		 * for (int i = 0; i < dates.length; i++) { for (int j = i+1; j < dates.length;
		 * j++) { //小于降序 大于升序 if(dates[i].getTime()<dates[j].getTime()){ Date date =
		 * dates[j]; dates[j] = dates[i]; dates[i] = date; } } }
		 */
		// 三:冒泡排序
		for (int i = 0; i < dates.length; i++) {
			for (int j = 0; j < dates.length - i - 1; j++) {
				// 大于升序 小于降序
				if (dates[j].getTime() < dates[j + 1].getTime()) {
					Date da = dates[j];
					dates[j] = dates[j + 1];
					dates[j + 1] = da;
				}
			}
		}

		// 打印
		k = 0;
		System.out.println("排序之后：:");
		for (int i = 0; i < dates.length; i++) {
			System.out.print(sdf.format(dates[i]) + "   ");
			k++;
			if (k % 3 == 0)
				System.out.println();

		}
	}

}