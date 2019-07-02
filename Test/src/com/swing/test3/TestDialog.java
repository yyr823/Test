/**
 * 
 */
package com.swing.test3;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * @author PE
 * @date 2019年6月28日 下午4:52:15
 * @explain 模态框
 */
public class TestDialog {
	public static void main(String[] args) {
		/**
		 * 当一个对话框被设置为模态的时候，其背后的父窗体，
		 * 是不能被激活的(不可操作)，除非该对话框被关闭
		 */
        JFrame f = new JFrame("外部窗体");
        f.setSize(800, 600);
        f.setLocation(100, 100);
        // 窗体大小不可变化
        f.setResizable(false);
        // 根据外部窗体实例化JDialog
        JDialog d = new JDialog(f);
        // 设置为模态
        d.setModal(true);
 
        d.setTitle("模态的对话框");
        d.setSize(400, 300);
        d.setLocation(200, 200);
        d.setLayout(null);
        JButton b = new JButton("一键秒对方基地挂");
        b.setBounds(50, 50, 280, 30);
        d.add(b);
 
        f.setVisible(true);
        d.setVisible(true);
 
    }
}
