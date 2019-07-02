/**
 * 
 */
package com.java.dates;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author PE
 * @date 2019年6月25日 下午1:51:14
 * @explain
 */
public class Test {
	public static void main(String[] args) {
		// 注意：是java.util.Date;
		// 而非 java.sql.Date，此类是给数据库访问的时候使用的
		Date now = new Date();
		// 打印当前时间
		System.out.println("当前时间:" + now.toString());
		// 从1970年1月1日 早上8点0分0秒 开始经历的毫秒数
		Date d2 = new Date(5000);
		System.out.println("从1970年1月1日 早上8点0分0秒 开始经历了5秒的时间");
		System.out.println(d2);
		// getTime() 得到一个long型的整数
		// 这个整数代表 1970.1.1 08:00:00:000，每经历一毫秒，增加1
		System.out.println("当前时间getTime()返回的值是：" + now.getTime());

		Date zero = new Date(0);// 时间原点
		System.out.println("用0作为构造方法，得到的日期是:" + zero);
		// 由于机器性能的原因，可能会相差几十毫秒，毕竟每执行一行代码，都是需要时间的
		// 当前日期的毫秒数
		System.out.println("Date.getTime() \t\t\t返回值: " + now.getTime());
		// 通过System.currentTimeMillis()获取当前日期的毫秒数
		System.out.println("System.currentTimeMillis() \t返回值: " + System.currentTimeMillis());

		// 借助随机数，创建一个从1995.1.1 00:00:00 到 1995.12.31 23:59:59 之间的随机日期
		Calendar startTime = Calendar.getInstance();
		startTime.set(1995, 0, 1, 00, 00, 00);
		Calendar endTime = Calendar.getInstance();
		endTime.set(1995, 11, 31, 23, 59, 59);
		// 得到两个日期的毫秒差之间的随机数
		double randomDate = Math.abs(Math.random() * (startTime.getTimeInMillis() - endTime.getTimeInMillis()));
		// 将得到的毫秒随机数加上1995年的开始毫秒数 保证得到的毫秒数在1995年中
		long time = (long) (randomDate + startTime.getTimeInMillis());
		System.out.println("1995的随机日期：" + new Date(time));
		// 调用simpleDateFormat类 定义自己的日期输出格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh时MM分ss秒");
		// 对日期按照定义格式输出
		System.out.println(sdf.format(time));
		ranDate();
	}

	public static void ranDate() {
		long countdays = 0;
		Date d1;
		Date d2;
		for (int i = 1970; i < 1995; i++) {
			if (isLeapyear(i))
				countdays += 366;
			else
				countdays += 365;
		}
		// -8时区问题 1时(h)=3600000毫秒(ms) 一小时=60分钟 一分钟=60秒 一秒=1000毫秒 ===>60*60*1000
		long add1 = 3600 * 1000 * (24 * countdays - 8);
		long add2 = 3600 * 1000 * (24 * (countdays + (isLeapyear(1995) ? 366 : 365)) - 8) - 1;
		d1 = new Date(add1);
		d2 = new Date(add2);
		System.out.println("1995年到来的瞬间：" + d1);
		System.out.println("1995年结束的刹那：" + d2);
		System.out.println("1995年的某一刻：" + new Date((long) (Math.random() * (add2 - add1 + 1) + add1)));
	}

	// 闰年判断
	public static boolean isLeapyear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
			return true;
		else
			return false;
	}

}
