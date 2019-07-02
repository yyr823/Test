/**
 * 
 */
package com.swing.test4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author PE
 * @date 2019年7月1日 上午9:06:03
 * @explain  布局容器
 */
public class TestGUI {
public static void main(String[] args) {
	/**
	 * 绝对定位
	 * 就是指不使用布局器，组件的位置和大小需要单独指定
	 */
	//test1();
	/**
	 * 设置布局器为FlowLayout,顺序布局器
     * 容器上的组件水平摆放,加入到容器即可，无需单独指定大小和位置
	 */
	//test2();
	/**
	 * 设置布局器为BorderLayout
       容器上的组件按照上北 下南 左西 右东 中的顺序摆放
	 */
	//test3();
	/**
	 * GridLayout，即网格布局器
	 */
	//test4();
	/**
	 * 即便使用布局器 ，也可以 通过setPreferredSize，
	 * 向布局器建议该组件显示的大小.
      注 只对部分布局器起作用，比如FlowLayout可以起作用。
      比如GridLayout就不起作用，因为网格布局器必须对齐
	 */
	//test5();
	/**
	 * 计算器
	 */
	calc();
	
   }

public static void calc() {
	  JFrame f = new JFrame("计算器");
    f.setSize(600, 600);
    f.setLocation(200, 200);
    f.setLayout(new GridLayout(4, 5, 10, 10));
    String[][] a = {{"7","8","9","/","sq"},{"4","5","6","*","%"},
    		{"1","2","3","-","1/x"},{"0","+/-",".","+","="}};
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 5; j++) { 
            JButton button = new JButton(a[i][j]);
           //layOut为new FlowLayout()  ---> 设置按钮大小 button.setPreferredSize(new Dimension(60,40));
            button.setBackground(Color.ORANGE);
            f.add(button);
        }
    }

    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
}
public static void test1() {
	
	JFrame j=new JFrame("LOL");
	j.setSize(400, 300);
    j.setLocation(200, 200);
    //设置布容器为NULL,即进行绝对定位,
    // 容器上的组件都需要指定位置和大小
    j.setLayout(null);
    JButton b1=new JButton("英雄1");
    b1.setBounds(50, 50, 80, 30);
   JButton b2=new JButton("英雄2");
   b2.setBounds(150, 50, 80, 30);
   JButton b3=new JButton("英雄3");
   b3.setBounds(250, 50, 80, 30);
   JButton b4=new JButton("英雄4");
   j.add(b1);
   j.add(b2);
   j.add(b3);
   //b4没有指定位置和大小 不会出现在容器上
   j.add(b4);
   j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   j.setVisible(true);
}

public static void test2() {
	  JFrame f = new JFrame("LoL");
      f.setSize(400, 300);
      f.setLocation(200, 200);
      // 设置布局器为FlowLayerout
      // 容器上的组件水平摆放
      f.setLayout(new FlowLayout());

      JButton b1 = new JButton("英雄1");
      JButton b2 = new JButton("英雄2");
      JButton b3 = new JButton("英雄3");

      // 加入到容器即可，无需单独指定大小和位置
      f.add(b1);
      f.add(b2);
      f.add(b3);

      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      f.setVisible(true);
}

public static void test3() {
	 JFrame f = new JFrame("LoL");
     f.setSize(400, 300);
     f.setLocation(200, 200);
     // 设置布局器为BorderLayerout
     // 容器上的组件按照上北下南左西右东中的顺序摆放
     f.setLayout(new BorderLayout());

     JButton b1 = new JButton("洪七");
     JButton b2 = new JButton("段智兴");
     JButton b3 = new JButton("欧阳锋");
     JButton b4 = new JButton("黄药师");
     JButton b5 = new JButton("周伯通");

     // 加入到容器的时候，需要指定位置
     f.add(b1, BorderLayout.NORTH);
     f.add(b2, BorderLayout.SOUTH);
     f.add(b3, BorderLayout.WEST);
     f.add(b4, BorderLayout.EAST);
     f.add(b5, BorderLayout.CENTER);

     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     f.setVisible(true);
}

public static void test4() {
	  JFrame f = new JFrame("LoL");
      f.setSize(400, 300);
      f.setLocation(200, 200);
      // 设置布局器为GridLayerout，即网格布局器
      // 该GridLayerout的构造方法表示该网格是2行3列
      f.setLayout(new GridLayout(2, 3));

      JButton b1 = new JButton("洪七");
      JButton b2 = new JButton("段智兴");
      JButton b3 = new JButton("欧阳锋");
      JButton b4 = new JButton("黄药师");
      JButton b5 = new JButton("周伯通");

      f.add(b1);
      f.add(b2);
      f.add(b3);
      f.add(b4);
      f.add(b5);

      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      f.setVisible(true);
  }
public static void test5() {
	 JFrame f = new JFrame("LoL");
     f.setSize(400, 300);
     f.setLocation(200, 200);
     f.setLayout(new FlowLayout());

     JButton b1 = new JButton("英雄1");
     JButton b2 = new JButton("英雄2");
     JButton b3 = new JButton("英雄3");

     // 即便 使用 布局器 ，也可以 通过setPreferredSize，向布局器建议该组件显示的大小
     b3.setPreferredSize(new Dimension(180, 40));
     f.add(b1);
     f.add(b2);
     f.add(b3);

     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     f.setVisible(true);
}
}



