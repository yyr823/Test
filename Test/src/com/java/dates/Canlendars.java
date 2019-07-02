/**
 * 
 */
package com.java.dates;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author PE
 * @date 2019年6月25日 下午2:38:00
 * @explain
 */
public class Canlendars {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		Date now = c.getTime();
		// 当前日期
		System.out.println("当前日期：\t" + format(c.getTime()));

		// 下个月的今天
		c.setTime(now);
		c.add(Calendar.MONTH, 1);
		System.out.println("下个月的今天:\t" + format(c.getTime()));
		// 去年的今天
		c.setTime(now);
		c.add(Calendar.YEAR, -1);
		System.out.println("去年的今天:\t" + format(c.getTime()));

		// 上个月的第三天
		c.setTime(now);
		c.add(Calendar.MONTH, -1);
		c.set(Calendar.DATE, 3);
		System.out.println("上个月的第三天:\t" + format(c.getTime()));
		// 下个月的倒数第三天
		c.setTime(now);
		c.add(Calendar.MONTH, 2);
		c.set(Calendar.DATE, 1);
		c.add(Calendar.DATE, -3);
		System.out.println("下个月的倒数第三天:\t" + format(c.getTime()));
	}

	private static String format(Date time) {
		return sdf.format(time);
	}
}
