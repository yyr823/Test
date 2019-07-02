/**
 * 
 */
package com.swing.test7;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author PE
 * @date 2019年7月1日 下午1:21:48
 * @explain 为空或数字判断校验
 */
public class Test1 {
	public static void main(String[] args) {
		JFrame f = new JFrame("练习1");
		f.setBounds(200, 300, 500, 500);
		JPanel jPanel = new JPanel();
		JTextField field = new JTextField();
		field.setPreferredSize(new Dimension(180, 25));
		JButton jButton = new JButton("检测");
		jPanel.add(field);
		jPanel.add(jButton);
		jButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String txt = field.getText();
				if (0 == txt.length()) {
					JOptionPane.showMessageDialog(f, "输入为空，请确认");
					return;
				}
				char[] c = txt.toCharArray();
				for (char each : c) {
					if (Character.isDigit(each))
						continue;
					JOptionPane.showMessageDialog(f, "输入数据不是数字");
					return;
				}
				JOptionPane.showMessageDialog(f, "输入数据是数字");
			}
		});
		f.add(jPanel);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}
}
