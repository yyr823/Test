package com.swing.test1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author PE
 * @date 2019年6月28日 下午1:15:23
 * @explain 
 启动一个线程，每个100毫秒读取当前的位置信息，保存在文件中，比如location.txt文件。 
启动的时候，从这个文件中读取位置信息，如果是空的，就使用默认位置，如果不是空的，就把位置信息设置在窗口上。
读取位置信息的办法： f.getX() 读取横坐标信息，f.getY()读取纵坐标信息。
 */
public class TestGUI {
	   //创建一个Window对象作为属性 -- 主窗体
    private static JFrame j=new JFrame("HelloWorld");
public static void main(String[] args) {
	 //读取文件上一次位置
    Integer x=null,y=null,w=null,h=null;
    try (FileReader fr=new FileReader("D:/testpro/Test/src/com/swing/location.txt");
            BufferedReader br=new BufferedReader(fr);){
    	String xy=br.readLine();
    	br.close();
    	if(xy!=null) {
    		String[] t = xy.split(",");
    		x = Integer.valueOf(t[0]);//字符串转整形x坐标
            y = Integer.valueOf(t[1]);//字符串转整形y坐标
            w = Integer.valueOf(t[2]);
            h = Integer.valueOf(t[3]);
    	}
  
    } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }
     
    //调用创建带按钮的窗体
    if(null==x&&null==y) {
    creatWindowWithSbButton(300,300,400,600);
    }else {
        creatWindowWithSbButton(x,y,w,h);
    }
     
    
    
    Thread t=new Thread() {
        public void run() {
            while(true) {
            try(FileWriter fw=new FileWriter("D:/testpro/Test/src/com/swing/location.txt")) {
            	//读取位置信息的办法： f.getX() 读取横坐标信息，f.getY()读取纵坐标信息。
                String xy = String.valueOf(j.getX()+","+j.getY()+","+j.getWidth()+","+j.getHeight());
                fw.write(xy);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //每隔100毫秒读取位置
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        }
    };
    t.start();
}

public static void  creatWindowWithSbButton(int x,int y,int w,int h) {
    //设置窗体的位置和大小
    j.setBounds(x,y,w,h);
    //创建一个按钮
    JButton b=new JButton("一键秒对方基地挂");
    //为最后的插件绝对大小生效
    j.setLayout(null);
    //设置按钮的位置和大小
    b.setBounds(50, 50, 280, 30);
   //将按钮加入到窗体中
    j.add(b);
    //设置通过叉掉窗口来终止程序
    j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  //最后的渲染，f.setVisible(true)会对所有的组件进行渲染，所以一定要放在最后面
    j.setVisible(true);
}
}
