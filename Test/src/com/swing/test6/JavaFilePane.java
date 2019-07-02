/**
 * 
 */
package com.swing.test6;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author PE
 * @date 2019年7月1日 下午1:09:48
 * @explain 
 */
public class JavaFilePane extends JPanel{
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
        JFrame f =new JFrame();
         
        f.setSize(400,300);
         
        f.setContentPane(new JavaFilePane(new File("D:/testcode/Mina/src/main/java/com/yyr/example/MinaServer.java")));
        f.setVisible(true);
         
    }
	
    public JavaFilePane(File file){
        this.setLayout(new BorderLayout());
        String fileContent = getFileContent(file);
        JTextArea ta = new JTextArea();
        ta.setText(fileContent);
        this.add(ta);
    }
     
    private String getFileContent(File f){
        String fileContent = null;
        try (FileReader fr = new FileReader(f)) {
            char[] all = new char[(int) f.length()];
            fr.read(all);
            fileContent= new String(all);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return fileContent;
    }
     
    
}
