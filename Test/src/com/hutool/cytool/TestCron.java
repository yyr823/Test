/**
 * 
 */
package com.hutool.cytool;

import cn.hutool.core.date.DateUtil;
import cn.hutool.cron.CronUtil;

/**
 * @author PE
 * @date 2019年7月2日 下午10:11:07
 * @explain 定时器
 */
public class TestCron {
	public static void main(String[] args) {
		CronUtil.setMatchSecond(true);
		CronUtil.start();

		CronUtil.schedule("*/2 * * * * ?", new Runnable() {

			@Override
			public void run() {
				System.out.println(DateUtil.now() + " 执行新任务");

			}
		});
	}
}
