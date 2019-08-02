/**
 * 
 */
package com.quartz.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author PE
 * @date 2019年7月5日 下午5:18:20
 * @explain 实现了 Job 接口，提供 execute，干具体的活儿
 */
public class MailJob implements Job {
	    public void execute(JobExecutionContext context) throws JobExecutionException {
	        JobDetail detail = context.getJobDetail();
	        String email = detail.getJobDataMap().getString("email");
	         
	        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	        String now = sdf.format(new  Date());
	         
	        System.out.printf("给邮件地址 %s 发出了一封定时邮件, 当前时间是: %s%n" ,email, now);
	    }
}
