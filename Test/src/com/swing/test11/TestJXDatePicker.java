/**
 * 
 */
package com.swing.test11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jdesktop.swingx.JXDatePicker;

/**
 * @author PE
 * @date 2019年7月1日 下午4:11:36
 * @explain 
 */
public class TestJXDatePicker {
	 public static void main(String[] args) {
		 
	        JFrame f = new JFrame("LoL");
	        f.setSize(400, 300);
	        f.setLocation(200, 200);
	        f.setLayout(null);
	 
	        Date date = new Date();
	        final JXDatePicker datepick = new JXDatePicker();
	        // 设置 date日期
	        datepick.setDate(date);
	        datepick.setBounds(137, 83, 177, 24);
	        f.add(datepick);
	 
	        JButton b = new JButton("获取时间");
	        b.setBounds(137, 183, 100, 30);
	        f.add(b);
	 
	        b.addActionListener(new ActionListener() {
	 
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // 获取 日期
	                Date d = datepick.getDate();
	                JOptionPane.showMessageDialog(f, "获取控件中的日期 :" + d);
	 
	            }
	        });
	 
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	        f.setVisible(true);
	    }
	}