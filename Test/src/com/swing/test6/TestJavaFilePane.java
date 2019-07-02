/**
 * 
 */
package com.swing.test6;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 * @author PE
 * @date 2019年7月1日 下午1:10:49
 * @explain 
 */
public class TestJavaFilePane {
	public static void main(String[] args) {
        JFrame f = new JFrame("LoL");
        f.setSize(800, 600);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
         
        File folder = new File("D:/testcode/Mina");
        File[] fs=folder.listFiles();
        JTabbedPane tp = new JTabbedPane();
        ImageIcon icon = new ImageIcon("D:/testpro/Test/j.png");
        for (int i = 0; i < fs.length; i++) {
            JavaFilePane jfp =new JavaFilePane(fs[i]);
            tp.add(jfp);
            tp.setIconAt(i,icon );
            tp.setTitleAt(i, shortName(fs[i].getName()));
        }
 
        f.setContentPane(tp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
 
    private static String shortName(String name) {
        int length = 6;
        if(name.length()>length){
            return name.substring(0,length) + "...";
        }
        return name;
         
    }
}
