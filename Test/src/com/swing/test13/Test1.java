/**
 * 
 */
package com.swing.test13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * @author PE
 * @date 2019年7月1日 下午5:10:23
 * @explain
 */
public class Test1 {
	public static void main(String[] args) {

		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(580, 200);
		f.setLayout(null);
		JButton b = new JButton("隐藏图片");
		b.setBounds(150, 200, 100, 30);
		b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("当前使用的是事件调度线程：" + SwingUtilities.isEventDispatchThread());
			}
		});
		f.add(b);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setVisible(true);
	}
}
