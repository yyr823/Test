/**
 * 
 */
package com.swing.test7;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author PE
 * @date 2019年7月1日 下午2:20:18
 * @explain 复利计算器
 */
public class Test4 {
	public static void main(String[] args) {
		JFrame f = new JFrame("复利计算器");
		f.setSize(600, 440);
		f.setLocation(300, 400);
		f.setLayout(null);

		JPanel p1 = new JPanel();
		p1.setBounds(10, 10, 560, 160);
		p1.setLayout(new GridLayout(4, 3, 10, 10));

		JLabel originalMoney = new JLabel("初始资金");
		JTextField tfOriginalMoney = new JTextField();
		JLabel originalMoneySign = new JLabel("￥");

		JLabel profitRate = new JLabel("年利率");
		JTextField tfProfitRate = new JTextField();
		JLabel profitRateSign = new JLabel("%");

		JLabel years = new JLabel("复利年数");
		JTextField tfYears = new JTextField();
		JLabel yearsSign = new JLabel("年");

		JLabel appendMoney = new JLabel("每年追加资金");
		JTextField tfAppendMoney = new JTextField();
		JLabel appendMoneySign = new JLabel("￥");

		p1.add(originalMoney);
		p1.add(tfOriginalMoney);
		p1.add(originalMoneySign);
		p1.add(profitRate);
		p1.add(tfProfitRate);
		p1.add(profitRateSign);
		p1.add(years);
		p1.add(tfYears);
		p1.add(yearsSign);
		p1.add(appendMoney);
		p1.add(tfAppendMoney);
		p1.add(appendMoneySign);

		JButton b = new JButton("计算");
		b.setBounds(250, 190, 80, 50);

		JPanel p2 = new JPanel();
		p2.setBounds(10, 260, 560, 120);
		p2.setLayout(new GridLayout(3, 3, 10, 10));

		JLabel capitalSum = new JLabel("本金和");
		JTextField tfCapitalSum = new JTextField();
		JLabel capitalSumSign = new JLabel("￥");

		JLabel intrestSum = new JLabel("利息和");
		JTextField tfIntrestSum = new JTextField();
		JLabel intrestSumSign = new JLabel("￥");

		JLabel all = new JLabel("本息和");
		JTextField tfAll = new JTextField();
		JLabel allSign = new JLabel("年");

		p2.add(capitalSum);
		p2.add(tfCapitalSum);
		p2.add(capitalSumSign);
		p2.add(intrestSum);
		p2.add(tfIntrestSum);
		p2.add(intrestSumSign);
		p2.add(all);
		p2.add(tfAll);
		p2.add(allSign);

		f.add(p1);
		f.add(b);
		f.add(p2);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		/**
		 * 复利公式： F = p* ( (1+r)^n ); F 最终收入 p 本金 r 年利率 n 存了多少年
		 * 
		 * 
		 * 假设情景一： p = 10000 r = 0.05 n = 1 解读： 本金是10000 年利率是5% 存了一年 1次 复利收入 10000*(
		 * (1+0.05)^1 ) = 10500 假设情景二： p = 10000 r = 0.05 n = 2 解读： 本金是10000 年利率是5% 存了两年
		 * 复利收入 10000*( (1+0.05)^2 ) = 11025
		 */
		b.addActionListener(new ActionListener() {
			public boolean ok = true;

			public void actionPerformed(ActionEvent e) {
				ifEmpty(tfOriginalMoney, "初始资金");
				ifNumber(tfOriginalMoney, "初始资金");
				ifEmpty(tfProfitRate, "年利率");
				ifNumber(tfProfitRate, "年利率");
				ifEmpty(tfYears, "复利年数");
				ifInt(tfYears, "复利年数");
				ifEmpty(tfAppendMoney, "每年追加资金");
				ifNumber(tfAppendMoney, "每年追加资金");

				if (ok) {
					double a = Double.parseDouble(tfOriginalMoney.getText());
					double b = Double.parseDouble(tfProfitRate.getText());
					int c = Integer.parseInt(tfYears.getText());
					double d = Double.parseDouble(tfAppendMoney.getText());

					double cs = a + d * (c - 1);

					double sum;
					if (c == 0) {
						cs = a;
						sum = cs;
					} else if (c == 1)
						sum = a * (1 + b / 100);
					else {
						sum = a * (1 + b / 100);
						for (int i = 2; i <= c; i++) {
							sum = (sum + d) * (1 + b / 100);
						}
					}

					double is = sum - cs;
					tfCapitalSum.setText(String.format("%,.2f", cs));// 本金和
					tfIntrestSum.setText(String.format("%,.2f", is));// 利息和
					tfAll.setText(String.format("%,.2f", sum));// 本息和
				}
				ok = true;
			}

			public void ifEmpty(JTextField tf, String str) {
				if (!ok)
					return;
				if (0 == tf.getText().length()) {
					String result = String.format("%s为空，请重新输入", str);
					JOptionPane.showMessageDialog(f, result);
					ok = false;
				}
			}

			public void ifNumber(JTextField tf, String str) {
				if (!ok)
					return;
				try {
					Double.parseDouble(tf.getText());
				} catch (NumberFormatException e) {
					String result = String.format("输入的%s必须为数字，请重试", str);
					JOptionPane.showMessageDialog(f, result);
					ok = false;
				}
			}

			public void ifInt(JTextField tf, String str) {
				if (!ok)
					return;
				try {
					Integer.parseInt(tf.getText());
				} catch (NumberFormatException e) {
					String result = String.format("输入的%s必须为整数，请重试", str);
					JOptionPane.showMessageDialog(f, result);
					ok = false;
				}
			}

		});

	}
}
