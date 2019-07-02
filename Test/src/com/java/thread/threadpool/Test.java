/**
 * 
 */
package com.java.thread.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author PE
 * @date 2019年6月28日 上午10:45:13
 * @explain 
 */
public class Test {
	public static void main(String[] args) throws InterruptedException {
        
		/**
第一个参数10 表示这个线程池初始化了10个线程在里面工作
第二个参数15 表示如果10个线程不够用了，就会自动增加到最多15个线程
第三个参数60 结合第四个参数TimeUnit.SECONDS，表示经过60秒，多出来的线程还没有接到活儿，
就会回收，最后保持池子里就10个
第四个参数TimeUnit.SECONDS 如上
第五个参数 new LinkedBlockingQueue() 用来放任务的集合
execute方法用于添加新的任务
		 */
		  ThreadPoolExecutor threadpool = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
	        for (int i = 0; i < 20; i++) {
	            threadpool.execute(new Runnable() {
	                @Override
	                public void run() {
	                 
	                    // TODO Auto-generated method stub
	                    System.out.println("任务"+Thread.currentThread().getName());
	                     
	                    try {
	                        Thread.sleep(10000);
	                    } catch (InterruptedException e) {
	                        // TODO Auto-generated catch block
	                        e.printStackTrace();
	                    }
	                }
	            });
	            System.out.println("线程池中线程数目：" + threadpool.getPoolSize() + "，队列中等待执行的任务数目：" +
	                    threadpool.getQueue().size() + "，已执行完的任务数目：" + threadpool.getCompletedTaskCount());
	        }
    }
   
}
