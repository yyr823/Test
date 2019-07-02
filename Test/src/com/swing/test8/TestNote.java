/**
 * 
 */
package com.swing.test8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * @author PE
 * @date 2019年7月1日 下午2:51:29
 * @explain 完成一个完整的记事本界面
 */
public class TestNote {
	public static void main(String[] args) {
		JFrame j = new JFrame("无标题-记事本");
		j.setBounds(200, 200, 400, 300);
		/*
		 * j.setSize(400, 300); j.setLocation(200, 200);
		 */
		JMenuBar menu = new JMenuBar();
		JMenu m1 = new JMenu("文件(F)");
		JMenu m2 = new JMenu("编辑(E)");
		JMenu m3 = new JMenu("格式(O)");
		JMenu m4 = new JMenu("查看(V)");
		JMenu m5 = new JMenu("帮助(H)");
		m1.setMnemonic('F');
		m2.setMnemonic('E');
		m3.setMnemonic('O');
		m4.setMnemonic('V');
		m5.setMnemonic('H');
		menu.add(m1);
		menu.add(m2);
		menu.add(m3);
		menu.add(m4);
		menu.add(m5);
		JMenuItem jm1 = new JMenuItem("新建(N)      Ctrl+N");
		jm1.setMnemonic('N');
		m1.add(jm1);
		JMenuItem jm2 = new JMenuItem("打开(O)...      Ctrl+O");
		jm2.setMnemonic('O');
		m1.add(jm2);
		JMenuItem jm3 = new JMenuItem("保存(S)      Ctrl+S");
		jm3.setMnemonic('S');
		m1.add(jm3);
		JMenuItem jm4 = new JMenuItem("另存为(A)...");
		jm4.setMnemonic('A');
		m1.add(jm4);
		m1.addSeparator();
		JMenuItem jm5 = new JMenuItem("页面设置(U)...");
		jm5.setMnemonic('U');
		m1.add(jm5);
		JMenuItem jm6 = new JMenuItem("打印(P)...      Ctrl+P");
		jm6.setMnemonic('P');
		m1.add(jm6);
		m1.addSeparator();
		JMenuItem jm7 = new JMenuItem("退出(X)");
		jm7.setMnemonic('X');
		m1.add(jm7);
		m1.getItem(0).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(j, m1.getItem(0).getText());
			}
		});
		//注意是set不是add
		j.setJMenuBar(menu);
		j.setVisible(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
