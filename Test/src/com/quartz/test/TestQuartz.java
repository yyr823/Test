/**
 * 
 */
package com.quartz.test;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
//import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobBuilder;

/**
 * @author PE
 * @date 2019年7月5日 下午5:16:48
 * @explain 触发器 Trigger： 什么时候工作 任务 Job: 做什么工作 调度器 Scheduler: 搭配 Trigger和Job
 */
public class TestQuartz {
	public static void main(String[] args) throws Exception {
		// 创建调度器
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		/**
		 * import static 这种写法叫做静态导入，指的是导入某个类的静态方法, 这样就可以直接使用了，而不是必须写成：
		 * JobBuilder.newJob()--->newJob
		 */
		// 定义一个触发器 定义名称和所属的租
		Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startNow()
				.withSchedule(simpleSchedule().withIntervalInSeconds(2) // 每隔2秒执行一次
						.withRepeatCount(10)) // 总共执行11次(第一次执行不基数)
				.build();

		// 定义一个JobDetail
		JobDetail job = JobBuilder.newJob(MailJob.class) // 指定干活的类MailJob
				/**
				 * 比如一个系统有3个job 是备份数据库的，有4个job 是发邮件的， 那么对他们进行分组，可以方便管理， 类似于一次性停止所有发邮件的这样的操作.
				 */
				.withIdentity("mailjob1", "mailgroup") // 定义任务名称和分组
				.usingJobData("email", "13623760439@163.com") // 定义属性
				.build();
	       //用JobDataMap 修改email
        job.getJobDataMap().put("email", "admin@taobao.com");
		// 调度加入这个job
		scheduler.scheduleJob(job, trigger);

		// 启动
		scheduler.start();

		// 等待20秒，让前面的任务都执行完了之后，再关闭调度器
		Thread.sleep(20000);
		scheduler.shutdown(true);
	}
}
