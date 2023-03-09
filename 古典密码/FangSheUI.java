package 古典密码;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class FangSheUI extends JFrame{
	private JTextArea ta1= new JTextArea(14,1);//明文区
	private JTextArea ta2= new JTextArea(14,1);//密文区
	private JTextArea ta3 = new JTextArea(2,15);//k0
	private JTextArea ta4 = new JTextArea(2,15);//k1
	private JButton bt1 = new JButton(" 加密 ");
	private JButton bt2 = new JButton(" 解密 ");
	private JButton bt3 = new JButton("换位↑↓");
	private JPanel jp = new JPanel();
	private JLabel lb1 = new JLabel("k0");
	private JLabel lb2 = new JLabel("k1");
	
	public FangSheUI(String title){
		super(title);
	}
	
	public void init() {
		Container c = getContentPane();
		ta1.setLineWrap(true);
		ta2.setLineWrap(true);
		ta3.setLineWrap(true);
		ta4.setLineWrap(true);
		JScrollPane sc1 = new JScrollPane(ta1); 
		JScrollPane sc2 = new JScrollPane(ta2); 
		JScrollPane sc3 = new JScrollPane(ta3); 
		JScrollPane sc4 = new JScrollPane(ta4); 
		jp.add(lb1);
		jp.add(sc3);
		jp.add(lb2);
		jp.add(sc4);
		jp.add(bt1);
		jp.add(bt2);
		jp.add(bt3);
		this.setSize(700, 425);
		this.add(sc1,new BorderLayout().NORTH);
		this.add(jp,new BorderLayout().CENTER);
		this.add(sc2,new BorderLayout().SOUTH);
		
		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				String str1 = ta3.getText().trim();
				FangShe.k1 = Integer.parseInt(str1);
				if(!FangShe.gcd(FangShe.k1)) {
					System.out.println("illegal!");
					System.exit(0);
				}
				String str2 = ta4.getText().trim();
				FangShe.k0 = Integer.parseInt(str2);
				FangShe.niyuan(26,FangShe.k1);
								
				String str = ta1.getText();
				
				FangShe.enstr = FangShe.encode(str);
				
				ta2.setText(new String(FangShe.enstr));
				
			}
		});
		
		bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String str = ta1.getText();
				FangShe.destr = new StringBuffer(str);
				String s = FangShe.decode(FangShe.destr.toString()).toString();
				ta2.setText(s);			
			}
			
		});
		
		bt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String str = ta2.getText().trim();
				if(!str.equals("")) {
					ta1.setText(str);
					ta2.setText("");
				}
			}
			
		});
				
		this.setSize(new Dimension(800,600));
		int windowWidth = this.getWidth(); //获得窗口宽
	    int windowHeight = this.getHeight();//获得窗口高
	    Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
	    Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
	    int screenWidth = screenSize.width; //获取屏幕的宽
	    int screenHeight = screenSize.height; //获取屏幕的高
	    //设置窗口居中
	    this.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//设置窗口居中显示
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //设置窗口大小不可变
	    this.setResizable(false);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}