/**
 * 
 */
package com.socket.ip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author PE
 * @date 2019年6月28日 下午2:43:20
 * @explain   判断本网段有多少可用的ip地址?
 首先获取 获取本机IP地址，比如说是192.168.2.100。
 那么本网段的ip地址就是从 192.168.2.1 到 192.168.2.255
再通过使用java 执行ping命令 判断这些ip地址能否使用，把能够使用的ip打印出来
 */
public class TestPing {
	 private static List<String> availableIps = Collections.synchronizedList
			 (new ArrayList<String>());
     /**
Java通过Executors提供四种线程池，分别为：
newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
      */
	    private static ExecutorService threadPool = Executors.newFixedThreadPool(50);
/*	 线程池   ThreadPoolExecutor threadPool1 = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());*/
	    public static void main(String[] args) throws InterruptedException {
	        // TODO Auto-generated method stub
	        String ip = null;
	        try {
	            InetAddress host = InetAddress.getLocalHost();
	            ip = host.getHostAddress();
	        } catch (UnknownHostException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        }
	        System.out.println("本机的内网IP: " + ip);
	        String myIp = ip.substring(0, ip.lastIndexOf(".") + 1);
	        for (int i = 1; i <=255; i++) {
	            String pingIp = new StringBuilder(myIp).append(i).toString();
	            threadPool.submit(new Runnable() {
	                @Override
	                public void run() {
	                    try {
	                        System.out.println("尝试连接： " + pingIp);
	                        Process process = Runtime.getRuntime().exec("ping " + pingIp);
	                        try (BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(),"UTF-8"))) {
	                            String line = null;
	                            StringBuilder builder = new StringBuilder();
	                            while (null != (line = br.readLine())) {
	                                builder.append(line + "\r\n");
	                            }
	                            if (builder.toString().contains("TTL=64")) {
	                                availableIps.add(pingIp);
	                            }
	                        }
	                    } catch (IOException e) {
	                        // TODO Auto-generated catch block
	                        e.printStackTrace();
	                    }
	                }
	            });
	             
	        }
	        // 不再提交任何任务
	        threadPool.shutdown();
	        if (threadPool.awaitTermination(2, TimeUnit.MINUTES)) {
	            System.out.println("可以连接的IP有:");
	            for (String aIp : availableIps) {
	                System.out.println(aIp);
	            }
	            System.out.println("总共有：" + availableIps.size());
	        }
	         
	    }
}
