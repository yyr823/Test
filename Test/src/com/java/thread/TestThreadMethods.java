/**
 * 
 */
package com.java.thread;

/**
 * @author PE
 * @date 2019年6月27日 下午3:45:35
 * @explain 
 */
public class TestThreadMethods {
public static void main(String[] args) {
	 Thread t1= new Thread(){
         public void run(){
             int seconds =0;
             while(seconds<10){
                 try {
                	 /**
Thread.sleep(1000); 表示当前线程暂停1000毫秒 ，其他线程不受影响 
Thread.sleep(1000); 会抛出InterruptedException 中断异常，因为当前线程sleep的时候，有可能被停止，
这时就会抛出 InterruptedException
                	  */
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
                 }
                 System.out.printf("已经玩了LOL %d 秒%n", seconds++);
             }              
         }
     };
     /**
守护线程的概念是:当一个进程里，所有的线程都是守护线程的时候，结束当前进程。
就好像一个公司有销售部，生产部这些和业务挂钩的部门。
除此之外，还有后勤，行政等这些支持部门。
如果一家公司销售部，生产部都解散了，那么只剩下后勤和行政，那么这家公司也可以解散了。
守护线程就相当于那些支持部门，如果一个进程只剩下守护线程，那么进程就会自动结束。
守护线程通常会被用来做日志，性能统计等工作。
      */
     t1.setDaemon(true);
     t1.start();
     /**
      * 主线程的概念
所有进程，至少会有一个线程即主线程，即main方法开始执行，就会有一个看不见的主线程存在。
      */
     //代码执行到这里，一直是main线程在运行
     try {
   //t1线程加入到main线程中来，只有t1线程运行结束，才会继续往下走
         t1.join();
     } catch (InterruptedException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
     }

     Thread t2= new Thread(){
         public void run(){
          System.out.println("开始啦!");             
         }
     };
     //会观察到盖伦把提莫杀掉后，才运行t2线程
     t2.start();
      
}


}
