package RSA;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RSAUI extends JFrame{
	private JTextArea ta1= new JTextArea(14,1);
	private JTextArea ta2 = new JTextArea(14,1);
	private JButton bt1 = new JButton(" ���� ");
	private JButton bt2 = new JButton(" ���� ");
	private JButton bt3 = new JButton("��λ����");
	private JPanel jp = new JPanel();
	
	public RSAUI(String title){
		super(title);
	}
	
	public void init() {
		Container c = getContentPane();
		ta1.setLineWrap(true);
		ta2.setLineWrap(true);
		JScrollPane sc1 = new JScrollPane(ta1); 
		JScrollPane sc2 = new JScrollPane(ta2); 
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
				// TODO �Զ����ɵķ������
				String str = ta1.getText().trim();
				RSA.data = str;
				try {
					String enstr = RSA.encode();
					ta2.setText(enstr);
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
			
		});
		
		bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				String str = ta1.getText().trim();
				try {
					String destr = RSA.decode();
					ta2.setText(destr);
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				
				
			}
			
		});
		
		bt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
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

