/**
 * 
 */
package com.swing.test9;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

/**
 * @author PE
 * @date 2019年7月1日 下午3:18:35
 * @explain 工具栏
 */
public class TestToolBar {
public static void main(String[] args) {
	JFrame f = new JFrame("LoL");
	f.setSize(400, 300);
	f.setLocation(200, 200);
	// 菜单
	addMenu(f);

	// 工具栏
	JToolBar tb = new JToolBar();
	// 为工具栏增加按钮
	JButton b1 = new JButton(new ImageIcon("D:/testpro/Test/image/1.jpg"));
	JButton b2 = new JButton(new ImageIcon("D:/testpro/Test/image/2.jpg"));
	JButton b3 = new JButton(new ImageIcon("D:/testpro/Test/image/3.jpg"));
	JButton b4 = new JButton(new ImageIcon("D:/testpro/Test/image/4.jpg"));
	JButton b5 = new JButton(new ImageIcon("D:/testpro/Test/image/5.jpg"));
	JButton b6 = new JButton(new ImageIcon("D:/testpro/Test/image/6.jpg"));
	tb.add(b1);
	tb.add(b2);
	tb.add(b3);
	tb.add(b4);
	tb.add(b5);
	tb.add(b6);

	// 给按钮设置提示信息
	b1.setToolTipText("坑爹英雄");
	// 禁止工具栏拖动(默认可拖动)
	tb.setFloatable(false);
	// 把工具栏放在north的位置
	f.setLayout(new BorderLayout());
	f.add(tb, BorderLayout.NORTH);

	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	f.setVisible(true);
}

private static void addMenu(JFrame f) {
	JMenuBar mb = new JMenuBar();

	JMenu mHero = new JMenu("英雄");
	JMenu mItem = new JMenu("道具");
	JMenu mWord = new JMenu("符文");
	JMenu mSummon = new JMenu("召唤师");
	JMenu mTalent = new JMenu("天赋树");

	// 菜单项
	mHero.add(new JMenuItem("近战-Warriar"));
	mHero.add(new JMenuItem("远程-Range"));
	mHero.add(new JMenuItem("物理-physical"));
	mHero.add(new JMenuItem("坦克-Tank"));
	mHero.add(new JMenuItem("法系-Mage"));
	mHero.add(new JMenuItem("辅助-Support"));
	mHero.add(new JMenuItem("打野-Jungle"));
	mHero.add(new JMenuItem("突进-Charge"));
	mHero.add(new JMenuItem("男性-Boy"));
	mHero.add(new JMenuItem("女性-Girl"));

	mb.add(mHero);
	mb.add(mItem);
	mb.add(mWord);
	mb.add(mSummon);
	mb.add(mTalent);

	f.setJMenuBar(mb);
}
}
