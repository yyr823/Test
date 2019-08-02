package com.quartz.simple_trigger;
  
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

import java.text.DateFormat;
import java.util.Date;
 
import org.quartz.DateBuilder;
import org.quartz.DateBuilder.IntervalUnit;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;
  
public class TestQuartz {
    public static void main(String[] args) throws Exception{
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
  //下一个8秒的倍数
            Date startTime = DateBuilder.nextGivenSecondDate(null, 8);
 //10 秒后运行
            Date startTime1 = DateBuilder.futureDate(10, IntervalUnit.SECOND);
            JobDetail job = newJob(MailJob.class).withIdentity("mailJob", "mailGroup").build();
 
            SimpleTrigger trigger = (SimpleTrigger) newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startAt(startTime)
                    //累计n次，间隔n秒
                    .withSchedule(simpleSchedule()
                    		.withRepeatCount(3)
                            //.repeatForever() 无限重复
                            .withIntervalInSeconds(1))
                    .build();
 
            // schedule it to run!
            Date ft = scheduler.scheduleJob(job, trigger);
            DateFormat df=DateFormat.getDateTimeInstance();
            System.out.println("当前时间是：" + df.format(new Date()));
            System.out.printf("%s 这个任务会在 %s 准时开始运行，累计运行%d次，间隔时间是%d毫秒%n", job.getKey(),df.format(ft), trigger.getRepeatCount()+1, trigger.getRepeatInterval());
            
            scheduler.start();
              
            //等待200秒，让前面的任务都执行完了之后，再关闭调度器
            Thread.sleep(200000);
            scheduler.shutdown(true);
    }
}