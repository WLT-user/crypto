package Playfir;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

public class PLUI extends JFrame{
	private JTextArea ta1= new JTextArea(14,1);
	private JTextArea ta2= new JTextArea(14,1);
	private JTextArea ta3 = new JTextArea(2,46);
	private JButton bt1 = new JButton(" ���� ");
	private JButton bt2 = new JButton(" ���� ");
	private JButton bt3 = new JButton("��λ����");
	private JPanel jp = new JPanel();
	
	public PLUI(String title){
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
		jp.add(sc3);
		jp.add(bt1);
		jp.add(bt2);
		jp.add(bt3);
		this.setSize(700, 425);
		this.add(sc1,new BorderLayout().NORTH);
		this.add(jp,new BorderLayout().CENTER);
		this.add(sc2,new BorderLayout().SOUTH);
		
		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				String str1 = ta1.getText().trim();
				String str3 = ta3.getText().trim();
				if(!str1.equals("")&&!str3.equals("")) {
					Playfir.build(str3);
					Vector ch_mw=new Vector();
					for(int i=0;i<str1.length();i++) {
						ch_mw.add(str1.charAt(i));
					}
					String str2 =Playfir.encrypt(ch_mw);
					ta2.setText(str2);
				}
			}
			
		});
		
		bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String str1 = ta1.getText().trim();
				String str3 = ta3.getText().trim();
				Vector ch_mw=new Vector();
				for(int i=0;i<str1.length();i++) {
					ch_mw.add(str1.charAt(i));
				}
				if(!str1.equals("")&&!str3.equals("")) {
					String str2 = Playfir.decrypt(ch_mw);
					ta2.setText(str2);
				}
			}
			
		});
		
		bt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String str = ta2.getText().trim();
				if(!str.equals("")) {
					ta1.setText(str);
					ta2.setText("");
				}
			}
			
		});
		
		this.setSize(new Dimension(800,600));
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
	    this.setResizable(false);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
