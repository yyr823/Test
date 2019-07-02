/**
 * 
 */
package com.swing.test7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author PE
 * @date 2019年7月1日 下午1:35:56
 * @explain 登录界面
 */
public class Test2 {
	public static void main(String[] args) {
		JFrame f = new JFrame("登录界面");
		f.setSize(400, 300);
		f.setLocation(300, 300);
		f.setLayout(null);
		JLabel l1 = new JLabel("请输入账号:");
		l1.setBounds(40, 40, 80, 30);
		JLabel l2 = new JLabel("请输入密码:");
		l2.setBounds(200, 40, 80, 30);
		final JTextField zhanghao = new JTextField();
		final JPasswordField mima = new JPasswordField();
		zhanghao.setBounds(110, 45, 80, 20);
		mima.setBounds(280, 45, 80, 20);
		JButton b = new JButton("登录");
		b.setBounds(160, 100, 60, 30);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name1 = zhanghao.getText();
				String pass = String.valueOf(mima.getPassword());
				if (name1.equals("yyr") && pass.equals("123456")) {
					JOptionPane.showMessageDialog(f, "登录成功");
				} else {
					JOptionPane.showMessageDialog(f, "登录失败");

				}
			}
		});
		f.add(b);
		f.add(zhanghao);
		f.add(mima);
		f.add(l1);
		f.add(l2);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
