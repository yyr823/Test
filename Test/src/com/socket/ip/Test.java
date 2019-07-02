/**
 * 
 */
package com.socket.ip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;

/**
 * @author PE
 * @date 2019年6月28日 下午2:37:06
 * @explain 
 */
public class Test {
	  public static void main(String[] args) throws IOException {
	        InetAddress host = InetAddress.getLocalHost();
	        String ip =host.getHostAddress();
	        System.out.println("本机ip地址：" + ip);
	        Process p = Runtime.getRuntime().exec("ping " + ip);
	        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(),"GBK"));
	        String line = null;
	        StringBuilder sb = new StringBuilder();
	        while ((line = br.readLine()) != null) {
	            if (line.length() != 0)
	            	/**
	            	 * 苹果系统Mac       \r 
	            	 * Unix、Linux系统   \n 
	            	 * Windows系统       \r\n
	            	 */
	                sb.append(line + "\r\n");
	        }
	        System.out.println("本次指令返回的消息是：");
	        System.out.println(sb.toString());
	        
	        
	    }
}
