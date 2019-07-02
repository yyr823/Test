/**
 * 
 */
package com.swing.test8;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @author PE
 * @date 2019年7月1日 下午2:48:21
 * @explain 菜单/菜单栏/菜单项
 */
public class TestMenu {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(200, 200);

		// 菜单栏
		JMenuBar mb = new JMenuBar();

		// 菜单
		JMenu mHero = new JMenu("英雄");
		JMenu mItem = new JMenu("道具");
		JMenu mWord = new JMenu("符文");
		JMenu mSummon = new JMenu("召唤师");
		JMenu mTalent = new JMenu("天赋树");

		// 把菜单加入到菜单栏
		mb.add(mHero);
		mb.add(mItem);
		mb.add(mWord);
		mb.add(mSummon);
		mb.add(mTalent);

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
		// 分隔符
		mHero.addSeparator();
		mHero.add(new JMenuItem("所有-All"));

		mb.add(mHero);
		mb.add(mItem);
		mb.add(mWord);
		mb.add(mSummon);
		mb.add(mTalent);
		// 把菜单栏加入到frame，这里用的是set而非add
		f.setJMenuBar(mb);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setVisible(true);
	}
}
