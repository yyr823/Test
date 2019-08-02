/**
 * 
 */
package com.quartz.job_concurrence;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author PE
 * @date 2019年7月26日 下午2:44:14
 * @explain 
 */
public class Test {
	   public static void main(String[] args) throws Exception{
//         jobDataMap();
         databaseCurrentJob();

 }
	   private static void databaseCurrentJob() throws Exception {
	        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
	          
	        Trigger trigger = newTrigger().withIdentity("trigger1", "group1")
	            .startNow()
	            .withSchedule(simpleSchedule()
	                .withIntervalInSeconds(2)
	                .withRepeatCount(10))
	            .build();
	  
	        //定义一个JobDetail
	        JobDetail job = JobBuilder.newJob(DatabaseBackupJob.class)
	            .withIdentity("backupjob", "databasegroup")
	            .usingJobData("database", "how2java")
	            .build();
	         
	        //调度加入这个job
	        scheduler.scheduleJob(job, trigger);
	  
	        //启动
	        scheduler.start();
	          
	        //等待200秒，让前面的任务都执行完了之后，再关闭调度器
	       Thread.sleep(200000);
	        scheduler.shutdown(true);      
	    }
	 
}
