/**
 * 
 */
package com.socket.rootchat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author PE
 * @date 2019年6月28日 下午3:42:30
 * @explain 
 开发一个程序，当从scanner读取到消息，发给Server服务端，
 服务端用这个消息到表dictionary中找到对应的相应，返回出去。
  看上去就像在自动回应一样。
如果一个recieve有多条response，则随机返回一条

 */
public class Client {
	public static void main(String[] args) {
		  
        try {
            Socket s = new Socket("127.0.0.1", 8888);
  
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
              
            while(true){
                Scanner sc = new Scanner(System.in);
                String str = sc.nextLine();
                dos.writeUTF(str);
                String msg = dis.readUTF();
                System.out.println(msg);
 
            }
              
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
