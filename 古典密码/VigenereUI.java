package �ŵ�����;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VigenereUI extends JFrame{
	private JTextArea ta1= new JTextArea(14,34);
	private JTextArea ta2= new JTextArea(13,1);
	private JTextArea ta3 = new JTextArea(14,34);
	private JButton bt1 = new JButton(" ���� ");
	private JButton bt2 = new JButton(" ���� ");
	private JButton bt3 = new JButton("��λ����");
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();
	private JLabel lb1 = new JLabel("��Կ��");
	private JLabel lb2 = new JLabel("������");
	
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
				// TODO �Զ����ɵķ������
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
				// TODO �Զ����ɵķ������
				String str = ta1.getText().trim();
				Vigenere.enstr = new StringBuffer(str);
				Vigenere.destr = Vigenere.decode(str);
				ta2.setText(Vigenere.destr.toString());
				
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
	    //this.setResizable(false);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
