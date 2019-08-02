/**
 * 
 */
package com.quartz.cron_trigger;
import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

import java.text.DateFormat;
import java.util.Date;
 
import org.quartz.CronTrigger;
import org.quartz.DateBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

import com.quartz.simple_trigger.MailJob;
/**
 * @author PE
 * @date 2019年7月26日 下午3:28:57
 * @explain 在线生成cron表达式  http://cron.qqe2.com/
 */
public class TestQuartz {
	public static void main(String[] args) throws Exception{
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        JobDetail job = newJob(MailJob.class).withIdentity("mailJob", "mailGroup").build();

        CronTrigger trigger = newTrigger().withIdentity("trigger1", "group1")
        		.withSchedule(cronSchedule("0/2 * * * * ?"))
                .build();

        Date ft = scheduler.scheduleJob(job, trigger);
        DateFormat df=DateFormat.getDateTimeInstance();
        System.out.println("使用的Cron表达式是："+trigger.getCronExpression());
      System.out.printf("%s 这个任务会在 %s 准时开始运行%n", job.getKey(), df.format(ft));
         
        scheduler.start();
           
        //等待200秒，让前面的任务都执行完了之后，再关闭调度器
        Thread.sleep(200000);
        scheduler.shutdown(true);
}
}
