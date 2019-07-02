/**
 * 
 */
package com.swing.test10;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author PE
 * @date 2019年7月1日 下午3:25:31
 * @explain  基础表格
 */
public class TestTable {
public static void main(String[] args) {
	JFrame f = new JFrame("LoL");
    f.setSize(400, 300);
    f.setLocation(200, 200);
    f.setLayout(new BorderLayout());

    // 表格上的title
    String[] columnNames = new String[] { "id", "name", "hp", "damage" };
    // 表格中的内容，是一个二维数组
    String[][] heros = new String[][] { { "1", "盖伦", "616", "100" },
            { "2", "提莫", "512", "102" }, { "3", "奎因", "832", "200" } };
    JTable t = new JTable(heros, columnNames);
    // f.add(t, BorderLayout.CENTER);(基础表格无title )

    // 根据t创建 JScrollPane
    JScrollPane sp = new JScrollPane(t);
    // 设置列宽度
    t.getColumnModel().getColumn(0).setPreferredWidth(10);
    f.add(sp, BorderLayout.CENTER);
    /**
     * 或则创建一个空的JScrollPane，再通过setViewportView把table放在JScrollPane中
        JScrollPane sp = new JScrollPane(t);
        sp.setViewportView(t);
     */

    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    f.setVisible(true);
}
}
