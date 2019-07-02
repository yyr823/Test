/**
 * 
 */
package com.socket.morechat;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author PE
 * @date 2019年6月28日 下午3:55:10
 * @explain 
 */
public class RecieveThread extends Thread {
 
    private Socket s;
 
    public RecieveThread(Socket s) {
        this.s = s;
    }
 
    public void run() {
        try {
            InputStream is = s.getInputStream();
 
            DataInputStream dis = new DataInputStream(is);
            while (true) {
                String msg = dis.readUTF();
                System.out.println(msg);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
    }
}
