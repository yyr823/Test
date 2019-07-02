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
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author PE
 * @date 2019年7月1日 下午2:14:30
 * @explain 为空和数字判断
 */
public class Test3 {
	public static void main(String[] args) {
		JFrame f = new JFrame("黄鹤");
		f.setSize(650, 520);
		f.setLocation(300, 200);
		f.setLayout(null);

		JPanel p = new JPanel();
		p.setBounds(10, 10, 560, 160);
		p.setLayout(new GridLayout(4, 4, 10, 10));

		JLabel location = new JLabel("地名：");
		JTextField tfLocation = new JTextField();
		JLabel companyType = new JLabel("公司类型：");
		JTextField tfCompanyType = new JTextField();
		JLabel companyName = new JLabel("公司名称：");
		JTextField tfCompanyName = new JTextField();
		JLabel boss = new JLabel("老板名字：");
		JTextField tfBoss = new JTextField();
		JLabel money = new JLabel("金额：");
		JTextField tfMoney = new JTextField();
		JLabel product = new JLabel("产品：");
		JTextField tfProduct = new JTextField();
		JLabel unit = new JLabel("价格计量单位：");
		JTextField tfUnit = new JTextField();
		p.add(location);
		p.add(tfLocation);
		p.add(companyType);
		p.add(tfCompanyType);
		p.add(companyName);
		p.add(tfCompanyName);
		p.add(boss);
		p.add(tfBoss);
		p.add(money);
		p.add(tfMoney);
		p.add(product);
		p.add(tfProduct);
		p.add(unit);
		p.add(tfUnit);
		JButton b = new JButton("生成");
		b.setBounds(250, 190, 80, 50);

		JTextArea ta = new JTextArea();
		ta.setLineWrap(true);
		ta.setBounds(40, 260, 500, 200);
		f.add(p);
		f.add(b);
		f.add(ta);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

		b.addActionListener(new ActionListener() {
			public boolean ok = true;

			public void actionPerformed(ActionEvent e) {
				ifEmpty(tfLocation, "地点");
				ifEmpty(tfCompanyType, "公司类型");
				ifEmpty(tfCompanyName, "公司名称");
				ifEmpty(tfBoss, "老板名字");
				ifEmpty(tfMoney, "金额");
				ifNumber(tfMoney, "金额");
				ifEmpty(tfProduct, "产品");
				ifEmpty(tfUnit, "价格计量单位");
				if (ok) {
					String model = "%s最大%s%s倒闭了，王八蛋老板%s吃喝嫖赌，欠下了%s个亿，"
							+ "带着他的小姨子跑了！我们没有办法，拿着%s抵工资！原价都是一%s多、两%s多、三%s多的%s，"
							+ "现在全部只卖二十块，统统只要二十块！%s王八蛋，你不是人！我们辛辛苦苦给你干了大半年，" + "你不发工资，你还我血汗钱，还我血汗钱！";
					String s1 = tfLocation.getText();
					String s2 = tfCompanyType.getText();
					String s3 = tfCompanyName.getText();
					String s4 = tfBoss.getText();
					String s5 = tfMoney.getText();
					String s6 = tfProduct.getText();
					String s7 = tfUnit.getText();
					String str = String.format(model, s1, s2, s3, s4, s5, s6, s7, s7, s7, s6, s4);
					ta.setText(str);
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
					String result = String.format("输入的%s必须是数字，请重试", str);
					JOptionPane.showMessageDialog(f, result);
					ok = false;
				}
			}

		});
	}

}
