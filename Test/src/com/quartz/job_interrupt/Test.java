/**
 * 
 */
package com.quartz.job_interrupt;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author PE
 * @date 2019年7月26日 下午3:02:23
 * @explain 
 */
public class Test {
	public static void main(String[] args) throws Exception {
		stop();
	}
	 private static void stop() throws Exception {
	        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
	          
	        Trigger trigger = newTrigger().withIdentity("trigger1", "group1")
	            .startNow()
	            .build();
	  
	        //定义一个JobDetail
	        JobDetail job = newJob(StoppableJob.class)
	            .withIdentity("exceptionJob1", "someJobGroup")
	            .build();
	          
	        //调度加入这个job
	        scheduler.scheduleJob(job, trigger);
	  
	        //启动
	        scheduler.start();
	     
	        Thread.sleep(5000);
	        System.out.println("过5秒，调度停止 job");
	         
	        //key 就相当于这个Job的主键
	        scheduler.interrupt(job.getKey());
	         
	        //等待20秒，让前面的任务都执行完了之后，再关闭调度器
	        /*Thread.sleep(20000);*/
	        scheduler.shutdown(true);  
	    }
}
