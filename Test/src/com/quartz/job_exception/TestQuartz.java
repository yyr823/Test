/**
 * 
 */
package com.quartz.job_exception;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author PE
 * @date 2019年7月26日 下午2:50:07
 * @explain 
 */
public class TestQuartz {
public static void main(String[] args) throws Exception {
	 //exceptionHandle1();
	 exceptionHandle2();
}
private static  void exceptionHandle2() throws Exception {
    Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
      
    Trigger trigger = newTrigger().withIdentity("trigger1", "group1")
        .startNow()
        .withSchedule(simpleSchedule()
            .withIntervalInSeconds(2)
            .withRepeatCount(10))
        .build();

    //定义一个JobDetail
    JobDetail job = newJob(ExceptionJob2.class)
        .withIdentity("exceptionJob1", "someJobGroup")
        .build();
      
    //调度加入这个job
    scheduler.scheduleJob(job, trigger);

    //启动
    scheduler.start();
      
    //等待20秒，让前面的任务都执行完了之后，再关闭调度器
    Thread.sleep(20000);
    scheduler.shutdown(true);  
}

private static  void exceptionHandle1() throws Exception {
    Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
      
    Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
        .startNow()
        .withSchedule(simpleSchedule()
            .withIntervalInSeconds(2)
            .withRepeatCount(10))
        .build();

    //定义一个JobDetail
    JobDetail job = newJob(ExceptionJob1.class)
        .withIdentity("exceptionJob1", "someJobGroup")
        .build();
      
    //调度加入这个job
    scheduler.scheduleJob(job, trigger);

    //启动
    scheduler.start();
      
    //等待20秒，让前面的任务都执行完了之后，再关闭调度器
    Thread.sleep(20000);
    scheduler.shutdown(true);  
}
}
