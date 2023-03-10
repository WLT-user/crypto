package 古典密码;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VigenereUI extends JFrame{
	private JTextArea ta1= new JTextArea(14,34);
	private JTextArea ta2= new JTextArea(13,1);
	private JTextArea ta3 = new JTextArea(14,34);
	private JButton bt1 = new JButton(" 加密 ");
	private JButton bt2 = new JButton(" 解密 ");
	private JButton bt3 = new JButton("换位↑↓");
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();
	private JLabel lb1 = new JLabel("密钥区");
	private JLabel lb2 = new JLabel("明文区");
	
	public VigenereUI(String title){
		super(title);
	}
	
	public void init() {
		Container c = getContentPane();
		ta1.setLineWrap(true);
		ta2.setLineWrap(true);
		ta3.setLineWrap(true);
		JScrollPane sc1 = new JScrollPane(ta1); 
		JScrollPane sc2 = new JScrollPane(ta2); 
		JScrollPane sc3 = new JScrollPane(ta3); 
		jp2.add(sc3);
		jp2.add(sc1);
		jp1.add(lb1);
		jp1.add(bt1);
		jp1.add(bt2);
		jp1.add(bt3);
		jp1.add(lb2);
		this.setSize(700, 425);
		this.add(jp2,new BorderLayout().NORTH);
		this.add(jp1,new BorderLayout().CENTER);
		this.add(sc2,new BorderLayout().SOUTH);
		
		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				Vigenere.key = ta3.getText().trim();
				Vigenere.Key2Vec();
				String str = ta1.getText().trim();
				Vigenere.enstr = Vigenere.encode(str);
				ta2.setText(Vigenere.enstr.toString());
			}
			
		});
		
		bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String str = ta1.getText().trim();
				Vigenere.enstr = new StringBuffer(str);
				Vigenere.destr = Vigenere.decode(str);
				ta2.setText(Vigenere.destr.toString());
				
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
	    //this.setResizable(false);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
