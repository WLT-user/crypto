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
import �ŵ�����.*;

class jframe extends JFrame{
	private JLabel lb = new JLabel("ѡ����ģʽ",SwingConstants.CENTER);
	private JButton bt1 = new JButton("DES");
	private JButton bt2 = new JButton("����");
	private JButton bt3 = new JButton("ά������");
	private JButton bt4 = new JButton("RSA");
	private JButton bt5 = new JButton("keeloq");
	private JButton bt6 = new JButton("Playfir");
	
	jframe(String title){
		super(title);
	}
	
	public void init() {
		this.setLayout(new GridLayout(7,1));
		Dimension preferredSize = new Dimension(2,2);//���óߴ�
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
				// TODO �Զ����ɵķ������
				DESUI j = new DESUI("DES");	
				j.init();
				j.setVisible(true);
			}
			
		});
		
		bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				FangSheUI j = new FangSheUI("����");	
				j.init();
				j.setVisible(true);
			}
		});
		
		bt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				VigenereUI j = new VigenereUI("Vigenere");	
				j.init();
				j.setVisible(true);
			}
			
		});
		
		bt4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				RSAUI j = new RSAUI("RSA");	
				j.init();
				j.setVisible(true);
			}
			
		});
		
		bt5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				keeloqUI j = new keeloqUI("keeloq");	
				j.init();
				j.setVisible(true);
			}
			
		});
		
		bt6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				PLUI j = new PLUI("Playfir");	
				j.init();
				j.setVisible(true);
			}
			
		});
		
		
		
		this.setSize(new Dimension(380,430));
		int windowWidth = this.getWidth(); //��ô��ڿ�
	    int windowHeight = this.getHeight();//��ô��ڸ�
	    Toolkit kit = Toolkit.getDefaultToolkit(); //���幤�߰�
	    Dimension screenSize = kit.getScreenSize(); //��ȡ��Ļ�ĳߴ�
	    int screenWidth = screenSize.width; //��ȡ��Ļ�Ŀ�
	    int screenHeight = screenSize.height; //��ȡ��Ļ�ĸ�
	    //���ô��ھ���
	    this.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//���ô��ھ�����ʾ
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //���ô��ڴ�С���ɱ�
	    //this.setResizable(false);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}


public class MAIN {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		jframe j = new jframe("�ӽ���");	
		j.init();
		j.setVisible(true);
	}

}
