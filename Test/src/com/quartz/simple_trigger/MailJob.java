package com.quartz.simple_trigger;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


public class MailJob implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {

        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String now = sdf.format(new  Date());
        
        
        
        System.out.printf("发出了一封邮件, 当前时间是: %s%n" , now);
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}