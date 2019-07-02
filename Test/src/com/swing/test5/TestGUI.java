/**
 * 
 */
package com.swing.test5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

/**
 * @author PE
 * @date 2019年7月1日 上午9:44:35
 * @explain 组件
 */
public class TestGUI {
	public static void main(String[] args) {
		/**
		 * 设置位置和大小
		 * 方法一：setBounds(int x , int y ,int width, int heigth )
           方法二：setLocation(int x , int y );
                   setSize(int width ,int heigth);
         */
		/**
		 * Label用于显示文字
		 */
		testLable();
		/**
		 * 使用JLabel显示图片(java GUI 显示图片是通过在label上设置图标实现的) 注：
		 * 这里的图片路径是e:/project/j2se/shana.png，所以要确保这里有图片，不然不会显示 注：
		 * 图片的后缀名和真实格式，必须保持一致，否则很有可能无法正常显示。
		 * 什么意思呢？就是文件本来是jpg的，但是仅仅是把后缀名修改成了png,那么会导致显示失败。
		 */
		// testLableImage();

		/**
		 * JButton 普通按钮
		 */
		// testButton();
		/**
		 * 复选框
		 */
		// testCheckbox();
		/**
		 * 单选按钮
		 */
		// testRadio();
		/**
		 * ButtonGroup 对按钮进行分组，把不同的按钮， 放在同一个分组里 ，同一时间，只有一个 按钮 会被选中
		 */
		// testRadioGroups();
		/**
		 * 测试下拉框 JComboBox 下拉框 使用getSelectedItem来获取被选中项 使用setSelectedItem() 来指定要选中项
		 */
		// testSelect();
		/**
		 * 对话框
		 */
		// testDialog();
		/**
		 * 文本框
		 */
		 testText();
		/**
		 * JPasswordField 密码框 与文本框不同，获取密码框里的内容，推荐使用getPassword， 该方法会返回一个字符数组，而非字符串
		 */
		// testPassword();
		/**
		 * JTextArea：文本域。
		 */
		// testTextarea();
		/**
		 * 进度条(有进度的进度条)
		 */
		testProgress();
		/**
		 * 文件选择器
		 */
		// testFileSelect();
	}

	public static void testLable() {
		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.setLayout(null);
		JLabel l = new JLabel("LOL文字");
		// 文字颜色
		l.setForeground(Color.red);
		l.setBounds(50, 50, 280, 30);

		f.add(l);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setVisible(true);
	}

	public static void testLableImage() {
		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(580, 200);
		f.setLayout(null);

		JLabel l = new JLabel();

		// 根据图片创建ImageIcon对象
		ImageIcon i = new ImageIcon("D:/testpro/Test/src/com/swing/1.jpg");
		// 设置ImageIcon
		l.setIcon(i);
		// label的大小设置为ImageIcon,否则显示不完整
		l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());
		f.add(l);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	public static void testButton() {

		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.setLayout(null);
		JButton b = new JButton("一键秒对方基地挂");
		b.setBounds(50, 50, 280, 30);

		f.add(b);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setVisible(true);
	}

	public static void testCheckbox() {
		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(580, 200);
		f.setLayout(null);
		JCheckBox bCheckBox = new JCheckBox("物理英雄");
		// 设置 为 默认被选中
		bCheckBox.setSelected(true);
		bCheckBox.setBounds(50, 50, 130, 30);
		JCheckBox bCheckBox2 = new JCheckBox("魔法 英雄");
		bCheckBox2.setBounds(50, 100, 130, 30);
		// 判断 是否 被 选中
		System.out.println(bCheckBox2.isSelected());

		f.add(bCheckBox);
		f.add(bCheckBox2);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setVisible(true);
	}

	public static void testRadio() {
		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(580, 200);
		f.setLayout(null);
		JRadioButton b1 = new JRadioButton("物理英雄");
		// 设置 为 默认被选中
		b1.setSelected(true);
		b1.setBounds(50, 50, 130, 30);
		JRadioButton b2 = new JRadioButton("魔法 英雄");
		b2.setBounds(50, 100, 130, 30);

		System.out.println(b2.isSelected());

		f.add(b1);
		f.add(b2);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setVisible(true);
	}

	public static void testRadioGroups() {
		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(580, 240);
		f.setLayout(null);
		JRadioButton b1 = new JRadioButton("物理英雄");
		b1.setSelected(true);
		b1.setBounds(50, 50, 130, 30);
		JRadioButton b2 = new JRadioButton("魔法 英雄");
		b2.setBounds(50, 100, 130, 30);

		// 按钮分组
		ButtonGroup bg = new ButtonGroup();
		// 把b1，b2放在 同一个 按钮分组对象里 ，这样同一时间，只有一个 按钮 会被选中
		bg.add(b1);
		bg.add(b2);

		f.add(b1);
		f.add(b2);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setVisible(true);
	}

	public static void testSelect() {
		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(580, 240);
		f.setLayout(null);

		// 下拉框出现的条目
		String[] heros = new String[] { "卡特琳娜", "库奇" };
		JComboBox cb = new JComboBox(heros);
		cb.setSelectedIndex(1);
		cb.setBounds(50, 50, 80, 30);

		f.add(cb);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setVisible(true);
	}

	/**
	 * JOptionPane 用于弹出对话框 JOptionPane.showConfirmDialog(f, "是否 使用外挂 ？");
	 * 表示询问，第一个参数是该对话框以哪个组件对齐 JOptionPane.showInputDialog(f, "请输入yes，表明使用外挂后果自负");
	 * 接受用户的输入 JOptionPane.showMessageDialog(f, "你使用外挂被抓住！ 罚拣肥皂3次！"); 显示消息
	 */
	public static void testDialog() {
		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(580, 240);
		f.setLayout(null);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setVisible(true);

		int option = JOptionPane.showConfirmDialog(f, "是否 使用外挂 ？");
		if (JOptionPane.OK_OPTION == option) {
			String answer = JOptionPane.showInputDialog(f, "请输入yes，表明使用外挂后果自负");
			if ("yes".equals(answer))
				JOptionPane.showMessageDialog(f, "你使用外挂被抓住！ 罚拣肥皂3次！");
		}

	}

	/**
	 * JTextField 输入框 setText 设置文本 getText 获取文本 JTextField
	 * 是单行文本框，如果要输入多行数据，请使用JTextArea tfPassword.grabFocus(); 表示让密码输入框获取焦点
	 */

	public static void testText() {
		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(200, 200);

		f.setLayout(new FlowLayout());

		JLabel lName = new JLabel("账号：");
		// 输入框
		JTextField tfName = new JTextField("");
		tfName.setText("请输入账号");
		tfName.setPreferredSize(new Dimension(80, 30));

		JLabel lPassword = new JLabel("密码：");
		// 输入框
		JTextField tfPassword = new JTextField("");
		tfPassword.setText("请输入密码");
		tfPassword.setPreferredSize(new Dimension(80, 30));

		f.add(lName);
		f.add(tfName);
		f.add(lPassword);
		f.add(tfPassword);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setVisible(true);
		tfPassword.grabFocus();
	}

	public static void testPassword() {

		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(200, 200);

		f.setLayout(new FlowLayout());

		JLabel l = new JLabel("密码：");
		// 密码框
		JPasswordField pf = new JPasswordField("");
		pf.setText("&48kdh4@#");
		pf.setPreferredSize(new Dimension(80, 30));

		// 与文本框不同，获取密码框里的内容，推荐使用getPassword，该方法会返回一个字符数组，而非字符串
		char[] password = pf.getPassword();
		String p = String.valueOf(password);
		System.out.println(p);

		f.add(l);
		f.add(pf);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setVisible(true);
	}

	/**
	 * 和文本框JTextField不同的是，文本域可以输入多行数据 如果要给文本域初始文本，通过\n来实现换行效果
	 * JTextArea通常会用到append来进行数据追加 如果文本太长，会跑出去，可以通过setLineWrap(true) 来做到自动换行
	 */
	public static void testTextarea() {
		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(200, 200);

		f.setLayout(new FlowLayout());

		JLabel l = new JLabel("文本域：");

		JTextArea ta = new JTextArea();
		ta.setPreferredSize(new Dimension(200, 150));
		// \n换行符
		ta.setText("抢人头！\n抢你妹啊抢！\n");
		// 追加数据
		ta.append("我去送了了了了了了了了了了了了了了了了了了了了了了了了");
		// 设置自动换行
		ta.setLineWrap(true);
		f.add(l);
		f.add(ta);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setVisible(true);
	}

	public static void testProgress() {
		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(200, 200);

		f.setLayout(new FlowLayout());

		JProgressBar pb = new JProgressBar();
		// 进度条最大100
		pb.setMaximum(100);
		// 当前进度是50
		// pb.setValue(50);
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i <= 100; i++) {
					try {
						Thread.sleep(100);
						pb.setValue(i);
					} catch (InterruptedException ie) {
					}
				}
			}
		}).start();

		// 显示当前进度
		pb.setStringPainted(true);
		f.add(pb);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setVisible(true);

	}

	public static void testFileSelect() {

		JFrame f = new JFrame("LOL");
		f.setLayout(new FlowLayout());
		JFileChooser fc = new JFileChooser();

		fc.setFileFilter(new FileFilter() {
			// 使用FileFilter用于仅选择.txt文件
			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return ".txt";
			}

			@Override
			public boolean accept(File f) {
				return f.getName().toLowerCase().endsWith(".txt");
			}
		});

		JButton bOpen = new JButton("打开文件");

		JButton bSave = new JButton("保存文件");

		f.add(bOpen);
		f.add(bSave);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400, 300);
		f.setLocationRelativeTo(null);

		f.setVisible(true);

		bOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int returnVal = fc.showOpenDialog(f);// 用于打开文件
				File file = fc.getSelectedFile();
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(f, "计划打开文件:" + file.getAbsolutePath());
				}

			}
		});
		bSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int returnVal = fc.showSaveDialog(f);// 用于保存文件
				File file = fc.getSelectedFile();
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(f, "计划保存到文件:" + file.getAbsolutePath());
				}
			}
		});

	}

}
