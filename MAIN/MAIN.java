package MAIN;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

import DES.*;
import RSA.*;
import keeloq.*;
import Playfir.*;
import 古典密码.*;

class jframe extends JFrame{
	private JLabel lb = new JLabel("选择工作模式",SwingConstants.CENTER);
	private JButton bt1 = new JButton("DES");
	private JButton bt2 = new JButton("仿射");
	private JButton bt3 = new JButton("维吉尼亚");
	private JButton bt4 = new JButton("RSA");
	private JButton bt5 = new JButton("keeloq");
	private JButton bt6 = new JButton("Playfir");
	
	jframe(String title){
		super(title);
	}
	
	public void init() {
		this.setLayout(new GridLayout(7,1));
		Dimension preferredSize = new Dimension(2,2);//设置尺寸
		bt1.setPreferredSize(new Dimension(2,2));
		this.add(lb);
		this.add(bt1);
		this.add(bt2);
		this.add(bt3);
		this.add(bt4);
		this.add(bt5);
		this.add(bt6);
		
		
		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				DESUI j = new DESUI("DES");	
				j.init();
				j.setVisible(true);
			}
			
		});
		
		bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FangSheUI j = new FangSheUI("仿射");	
				j.init();
				j.setVisible(true);
			}
		});
		
		bt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				VigenereUI j = new VigenereUI("Vigenere");	
				j.init();
				j.setVisible(true);
			}
			
		});
		
		bt4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				RSAUI j = new RSAUI("RSA");	
				j.init();
				j.setVisible(true);
			}
			
		});
		
		bt5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				keeloqUI j = new keeloqUI("keeloq");	
				j.init();
				j.setVisible(true);
			}
			
		});
		
		bt6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				PLUI j = new PLUI("Playfir");	
				j.init();
				j.setVisible(true);
			}
			
		});
		
		
		
		this.setSize(new Dimension(380,430));
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


public class MAIN {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		jframe j = new jframe("加解密");	
		j.init();
		j.setVisible(true);
	}

}
