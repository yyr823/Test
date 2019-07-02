/**
 * 
 */
package com.swing.test2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author PE
 * @date 2019年6月28日 下午2:23:36
 * @explain 按钮监听事件
 * 键盘监听器： KeyListener
keyPressed 代表 键被按下
keyReleased 代表 键被弹起
keyTyped 代表 一个按下弹起的组合动作
KeyEvent.getKeyCode() 可以获取当前点下了哪个键
 */
public class TestKeyListener {
	public static void main(String[] args) {
	 JFrame f=new JFrame("笨小孩");
     f.setSize(500,500);
     f.setLocation(200, 200);
     f.setLayout(null);
      
     JLabel l=new JLabel();
      
     ImageIcon i = new ImageIcon("D:/testpro/Test/src/com/swing/1.jpg");
     l.setIcon(i);
     l.setBounds(200, 200, i.getIconWidth(), i.getIconHeight());
          
     f.addKeyListener(new KeyAdapter()  {
         @Override
         public void keyTyped(KeyEvent e) {
        	 System.out.println("一个按下弹起的组合动作");
         }
         @Override
         public void keyReleased(KeyEvent e) {
        	 System.out.println("键被弹起");
         }
         @Override
         public void keyPressed(KeyEvent e) {

        	  System.out.println(e.getKeyCode());
              if(e.getKeyCode()==37) {//左
                  l.setLocation(l.getX()-10, l.getY());
              }else if(e.getKeyCode()==38){//上
                  l.setLocation(l.getX(), l.getY()-10);
              }else if (e.getKeyCode()==39) {//右
                  l.setLocation(l.getX() + 10, l.getY());
              }else if(e.getKeyCode()==40) {//下
                  l.setLocation(l.getX(), l.getY()+10);
              }
         }
     });
      
     f.add(l);
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     f.setVisible(true);
}
}
