/**
 * 
 */
package com.swing.test10;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import cn.hutool.core.util.ArrayUtil;

/**
 * @author PE
 * @date 2019年7月1日 下午3:31:08
 * @explain 
 */
public class TestHeroTableModel {
	public static void main(String[] args) {
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());
        // 增加 一个 panel用于放置名称，血量输入框和增加 按钮
        JPanel p = new JPanel();
 
        final JLabel lName = new JLabel("名称");
        final JTextField tfName = new JTextField("");
        final JLabel lHp = new JLabel("血量");
        final JTextField tfHp = new JTextField("");
        JButton bAdd = new JButton("增加");
        tfName.setPreferredSize(new Dimension(80, 30));
        tfHp.setPreferredSize(new Dimension(80, 30));
        p.add(lName);
        p.add(tfName);
        p.add(lHp);
        p.add(tfHp);
        p.add(bAdd);
        //创建一个TableModel
        HeroTableModel htm= new HeroTableModel();
        // 准备一个Panel上面放一个Label用于显示哪条被选中了
        JPanel p2 = new JPanel();
        final JLabel l = new JLabel("暂时未选中条目");
        p2.add(l);
  
        //根据 TableModel来创建 Table(注意不可漏掉)
        JTable t = new JTable(htm);
        
        JScrollPane sp = new JScrollPane(t);
        // 使用selection监听器来监听table的哪个条目被选中
        t.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
                    // 当选择了某一行的时候触发该事件
                    public void valueChanged(ListSelectionEvent e) {
                        // 获取哪一行被选中了
                        int row = t.getSelectedRow();
                        // 根据选中的行，到HeroTableModel中获取对应的对象
                       String h = htm.heros[row][1];
                        // 更新标签内容
                        l.setText("当前选中的是： " + h);
  
                    }
                });
     // 为增加按钮添加监听
        bAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String name = tfName.getText();
           String hp = tfHp.getText().trim();
           
        // 通过name长度判断 名称是否为空
           if (name.length() == 0) {
               // 弹出对话框提示用户
               JOptionPane.showMessageDialog(f, "名称不能为空");

               // 名称输入框获取焦点
               tfName.grabFocus();
               return;
           }
           try {
               // 把hp转换为浮点型，如果出现异常NumberFormatException表示不是浮点型格式
               Float.parseFloat(hp);
           } catch (NumberFormatException e1) {
               JOptionPane.showMessageDialog(f, "血量只能是小数 ");
               tfHp.grabFocus();
               return;
           }
           //已解决二维数组扩容(HuTool):
           String[][] heros=htm.heros;
          String[][] heross = ArrayUtil.resize(heros, heros.length+1);
          String[] hero= { heross.length+"", name, hp, "100" };
           heross[heross.length-1]=hero;
           htm.heros=heross;
            t.updateUI();//更新
            }
        });
        f.add(p, BorderLayout.NORTH);
        f.add(sp, BorderLayout.CENTER);
        f.add(p2, BorderLayout.SOUTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        f.setVisible(true);
    }
	

}
