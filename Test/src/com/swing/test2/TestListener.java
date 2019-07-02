/**
 * 
 */
package com.swing.test2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author PE
 * @date 2019年6月28日 下午1:46:04
 * @explain 监听
 *
 */
public class TestListener {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(600, 600);
		f.setLocation(580, 500);
		f.setLayout(null);
		final JLabel l = new JLabel();
		ImageIcon i = new ImageIcon("D:/testpro/Test/src/com/swing/1.jpg");
		l.setIcon(i);
		l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());
		JButton b = new JButton("隐藏图片");
		b.setBounds(150, i.getIconHeight() + 100, 100, 30);
		f.add(l);
		f.add(b);
		/**
		 * 按钮监听
		 */
		b.addActionListener(new ActionListener() {
			boolean falg = true;

			// 当按钮被点击时，就会触发 ActionEvent事件
			// actionPerformed 方法就会被执行
			public void actionPerformed(ActionEvent e) {
				falg = !falg;
				l.setVisible(falg);
				System.out.println(falg);
				if (!falg) {
					b.setText("显示图片");
				} else {
					b.setText("隐藏图片");
				}
			}
		});

	
		/**
		 * MouseListener 鼠标监听器 mouseReleased 鼠标释放 mousePressed 鼠标按下 mouseExited 鼠标退出
		 * mouseEntered 鼠标进入 mouseClicked 鼠标点击
		 */
		// MouseAdapter 适配器，只需要重写用到的方法，没有用到的就不用写了
		l.addMouseListener(new MouseAdapter() {

			// 释放鼠标
		/*	public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}
*/
			// 按下鼠标
		/*	public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}*/

			// 鼠标退出
		/*	public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}*/

			// 鼠标进入
			public void mouseEntered(MouseEvent e) {

				Random r = new Random();

				int x = r.nextInt(f.getWidth() - l.getWidth());
				int y = r.nextInt(f.getHeight() - l.getHeight());

				l.setLocation(x, y);

			}

			// 按下释放组合动作为点击鼠标
			/*public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}*/
		});

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setVisible(true);
	}
}
