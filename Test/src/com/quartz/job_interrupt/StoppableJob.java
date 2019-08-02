/**
 * 
 */
package com.quartz.job_interrupt;

import org.quartz.InterruptableJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.UnableToInterruptJobException;

/**
 * @author PE
 * @date 2019年7月26日 下午3:01:08
 * @explain 
 */
public class StoppableJob implements InterruptableJob{

	   private boolean stop = false;
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {

        while(true){
 
            if(stop)
                break;
            try {
                System.out.println("每隔1秒，进行一次检测，看看是否停止");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("持续工作中。。。");
        }
	}


	@Override
	public void interrupt() throws UnableToInterruptJobException {
		 System.out.println("被调度叫停");
	        stop = true;
		
	}
	

}
