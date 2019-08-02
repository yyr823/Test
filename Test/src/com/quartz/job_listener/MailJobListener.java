/**
 * 
 */
package com.quartz.job_listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/**
 * @author PE
 * @date 2019年7月26日 下午3:43:16
 * @explain 
 */
public class MailJobListener implements JobListener {

	@Override
	public String getName() {
	     return "listener of mail job";
	}


	@Override
	public void jobExecutionVetoed(JobExecutionContext context) {
		   System.out.println("取消执行：\t "+context.getJobDetail().getKey());
	}


	@Override
	public void jobToBeExecuted(JobExecutionContext context) {
		 System.out.println("准备执行：\t "+context.getJobDetail().getKey());
		
	}

	
	@Override
	public void jobWasExecuted(JobExecutionContext context, JobExecutionException arg1) {
	    System.out.println("执行结束：\t "+context.getJobDetail().getKey());
        System.out.println();
	}

}
