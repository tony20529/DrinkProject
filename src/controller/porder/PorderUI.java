package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import model.Porder;
import service.impl.MemberServiceImpl;
import service.impl.PorderServiceImpl;
import util.MemberTool;
import util.Tool;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class PorderUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pt4;
	private JTextField dt4;
	private JTextField mt4;
	private JTextField cf4;
	private JTextField pk4;
	private JTextField pay;
	private static Member member=(Member)Tool.read("member.txt");
	private static MemberServiceImpl memberserviceimpl=new MemberServiceImpl();
	private static PorderServiceImpl porderserviceimpl=new PorderServiceImpl();
	private static int MID=member.getId();
	public int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PorderUI frame = new PorderUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PorderUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 680);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("科技幻影體驗館");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 36));
		lblNewLabel.setForeground(new Color(248, 248, 255));
		lblNewLabel.setBounds(115, 10, 346, 58);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("本店一杯一律50元");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_2.setForeground(new Color(255, 255, 0));
		lblNewLabel_2.setBounds(10, 67, 129, 30);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("甜度");
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1.setBounds(105, 97, 46, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("冰度");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(175, 97, 46, 15);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("杯數");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 0));
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(261, 97, 46, 15);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("金額");
		lblNewLabel_1_2_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(363, 97, 85, 15);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel amount = new JLabel("");
		amount.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		amount.setForeground(new Color(255, 255, 0));
		amount.setBounds(43, 391, 96, 15);
		contentPane.add(amount);
		amount.setText("0");
		
		JLabel lblNewLabel_3 = new JLabel("元");
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_3.setForeground(new Color(255, 255, 0));
		lblNewLabel_3.setBounds(80, 391, 46, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("應付");
		lblNewLabel_5.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_5.setForeground(new Color(255, 255, 0));
		lblNewLabel_5.setBounds(13, 391, 46, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel clock = new JLabel("");
		clock.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		clock.setForeground(new Color(255, 255, 0));
		clock.setBounds(308, 75, 168, 15);
		contentPane.add(clock);
		
		JLabel pt1 = new JLabel("珍珠奶茶");
		pt1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		pt1.setForeground(new Color(124, 252, 0));
		pt1.setBounds(10, 107, 85, 42);
		contentPane.add(pt1);
		
		JComboBox pt2 = new JComboBox();
		pt2.addItem("無糖");
		pt2.addItem("微甜");
		pt2.addItem("半糖");
		pt2.addItem("少糖");
		pt2.addItem("全糖");
		pt2.setBackground(new Color(124, 252, 0));
		pt2.setBounds(96, 122, 58, 23);
		contentPane.add(pt2);
		
		JComboBox pt3 = new JComboBox();
		pt3.addItem("溫");
		pt3.addItem("去冰");
		pt3.addItem("微冰");
		pt3.addItem("少冰");
		pt3.addItem("正常");
		pt3.addItem("多冰");
		pt3.setBackground(new Color(124, 252, 0));
		pt3.setBounds(164, 122, 58, 23);
		contentPane.add(pt3);
		
		pt4 = new JTextField();
		pt4.setFont(new Font("微软雅黑", Font.BOLD, 14));
		pt4.setBackground(new Color(127, 255, 0));
		pt4.setForeground(new Color(0, 0, 0));
		pt4.setBounds(232, 123, 96, 21);
		contentPane.add(pt4);
		pt4.setColumns(10);
		pt4.setText("0");
		
		JButton pt5 = new JButton("");
		pt5.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
				pt5.setText(50*Integer.parseInt(pt4.getText())+"元");
				int sum=(Integer.parseInt(pt4.getText())+Integer.parseInt(dt4.getText())+Integer.parseInt(mt4.getText())+Integer.parseInt(cf4.getText())+Integer.parseInt(pk4.getText()))*50;
				if(memberserviceimpl.findByMemberId(MID)!=null) {amount.setText(""+sum);}
				else if(memberserviceimpl.findByVipMemberId(MID)!=null){amount.setText(""+(int)(sum*0.9));}
				else {amount.setText(""+(int)(sum*0.8));}
				
			}
		});
		pt5.setBackground(new Color(127, 255, 0));
		pt5.setBounds(338, 122, 85, 23);
		contentPane.add(pt5);
		
		
		JLabel dt1 = new JLabel("多多綠茶");
		dt1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		dt1.setForeground(new Color(255, 165, 0));
		dt1.setBounds(10, 163, 85, 42);
		contentPane.add(dt1);
		
		JLabel mt1 = new JLabel("奶蓋綠茶");
		mt1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		mt1.setForeground(new Color(148, 0, 211));
		mt1.setBounds(10, 219, 85, 42);
		contentPane.add(mt1);
		
		JLabel cf1 = new JLabel("咖  啡");
		cf1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		cf1.setForeground(new Color(0, 255, 127));
		cf1.setBounds(20, 275, 85, 42);
		contentPane.add(cf1);		
		
		JComboBox dt2 = new JComboBox();
		dt2.addItem("無糖");
		dt2.addItem("微甜");
		dt2.addItem("半糖");
		dt2.addItem("少糖");
		dt2.addItem("全糖");
		dt2.setBackground(new Color(255, 165, 0));
		dt2.setBounds(96, 178, 58, 23);
		contentPane.add(dt2);
		
		JComboBox mt2 = new JComboBox();
		mt2.addItem("無糖");
		mt2.addItem("微甜");
		mt2.addItem("半糖");
		mt2.addItem("少糖");
		mt2.addItem("全糖");
		mt2.setBackground(new Color(148, 0, 211));
		mt2.setBounds(96, 234, 58, 23);
		contentPane.add(mt2);
		
		JComboBox cf2 = new JComboBox();
		cf2.addItem("無糖");
		cf2.addItem("微甜");
		cf2.addItem("半糖");
		cf2.addItem("少糖");
		cf2.addItem("全糖");
		cf2.setBackground(new Color(0, 255, 127));
		cf2.setBounds(96, 290, 58, 23);
		contentPane.add(cf2);
		
		JComboBox dt3 = new JComboBox();
		dt3.addItem("去冰");
		dt3.addItem("微冰");
		dt3.addItem("少冰");
		dt3.addItem("正常");
		dt3.addItem("多冰");
		dt3.setBackground(new Color(255, 165, 0));
		dt3.setBounds(164, 178, 58, 23);
		contentPane.add(dt3);
		
		JComboBox mt3 = new JComboBox();
		mt3.addItem("溫");
		mt3.addItem("去冰");
		mt3.addItem("微冰");
		mt3.addItem("少冰");
		mt3.addItem("正常");
		mt3.addItem("多冰");
		mt3.setBackground(new Color(148, 0, 211));
		mt3.setBounds(164, 234, 58, 23);
		contentPane.add(mt3);
		
		JComboBox cf3 = new JComboBox();
		cf3.addItem("熱");
		cf3.addItem("溫");
		cf3.addItem("去冰");
		cf3.addItem("微冰");
		cf3.addItem("少冰");
		cf3.addItem("正常");
		cf3.addItem("多冰");
		cf3.setBackground(new Color(0, 255, 127));
		cf3.setBounds(164, 290, 58, 23);
		contentPane.add(cf3);
				
		dt4 = new JTextField();
		dt4.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		dt4.setForeground(Color.BLACK);
		dt4.setColumns(10);
		dt4.setBackground(new Color(255, 165, 0));
		dt4.setBounds(232, 179, 96, 21);
		contentPane.add(dt4);
		dt4.setText("0");
		
		mt4 = new JTextField();
		mt4.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		mt4.setForeground(new Color(255, 255, 255));
		mt4.setColumns(10);
		mt4.setBackground(new Color(148, 0, 211));
		mt4.setBounds(232, 235, 96, 21);
		contentPane.add(mt4);
		mt4.setText("0");
		
		cf4 = new JTextField();
		cf4.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		cf4.setForeground(Color.BLACK);
		cf4.setColumns(10);
		cf4.setBackground(new Color(0, 255, 127));
		cf4.setBounds(232, 291, 96, 21);
		contentPane.add(cf4);
		cf4.setText("0");
				
		JButton dt5 = new JButton("");
		dt5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dt5.setText(50*Integer.parseInt(dt4.getText())+"元");
				int sum=(Integer.parseInt(pt4.getText())+Integer.parseInt(dt4.getText())+Integer.parseInt(mt4.getText())+Integer.parseInt(cf4.getText())+Integer.parseInt(pk4.getText()))*50;
				if(memberserviceimpl.findByMemberId(MID)!=null) {amount.setText(""+sum);}
				else if(memberserviceimpl.findByVipMemberId(MID)!=null){amount.setText(""+(int)(sum*0.9));}
				else {amount.setText(""+(int)(sum*0.8));}
				
				
			}
		});
		dt5.setBackground(new Color(255, 165, 0));
		dt5.setBounds(338, 178, 85, 23);
		contentPane.add(dt5);
		
		JButton mt5 = new JButton("");
		mt5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mt5.setText(50*Integer.parseInt(mt4.getText())+"元");
				int sum=(Integer.parseInt(pt4.getText())+Integer.parseInt(dt4.getText())+Integer.parseInt(mt4.getText())+Integer.parseInt(cf4.getText())+Integer.parseInt(pk4.getText()))*50;
				if(memberserviceimpl.findByMemberId(MID)!=null) {amount.setText(""+sum);}
				else if(memberserviceimpl.findByVipMemberId(MID)!=null){amount.setText(""+(int)(sum*0.9));}
				else {amount.setText(""+(int)(sum*0.8));}
			}
		});
		mt5.setForeground(Color.WHITE);
		mt5.setBackground(new Color(148, 0, 211));
		mt5.setBounds(338, 234, 85, 23);
		contentPane.add(mt5);
		
		JButton cf5 = new JButton("");
		cf5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cf5.setText(50*Integer.parseInt(cf4.getText())+"元");
				int sum=(Integer.parseInt(pt4.getText())+Integer.parseInt(dt4.getText())+Integer.parseInt(mt4.getText())+Integer.parseInt(cf4.getText())+Integer.parseInt(pk4.getText()))*50;
				if(memberserviceimpl.findByMemberId(MID)!=null) {amount.setText(""+sum);}
				else if(memberserviceimpl.findByVipMemberId(MID)!=null){amount.setText(""+(int)(sum*0.9));}
				else {amount.setText(""+(int)(sum*0.8));}
			}
		});
		cf5.setBackground(new Color(0, 255, 127));
		cf5.setBounds(338, 290, 85, 23);
		contentPane.add(cf5);
		
			JLabel pk1 = new JLabel("珍珠鮮奶");
			pk1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
			pk1.setForeground(new Color(255, 182, 193));
			pk1.setBounds(10, 331, 85, 42);
			contentPane.add(pk1);
		
			JComboBox pk2 = new JComboBox();
			pk2.addItem("無糖");
			pk2.addItem("微甜");
			pk2.addItem("半糖");
			pk2.addItem("少糖");
			pk2.addItem("全糖");
			pk2.setBackground(new Color(255, 182, 193));
			pk2.setBounds(96, 346, 58, 23);
			contentPane.add(pk2);
		
			JComboBox pk3 = new JComboBox();
			pk3.addItem("溫");
			pk3.addItem("去冰");
			pk3.addItem("微冰");
			pk3.addItem("少冰");
			pk3.addItem("正常");
			pk3.addItem("多冰");
			pk3.setBackground(new Color(255, 182, 193));
			pk3.setBounds(164, 346, 58, 23);
			contentPane.add(pk3);
		
			pk4 = new JTextField();
			pk4.setFont(new Font("微軟正黑體", Font.BOLD, 14));
			pk4.setForeground(Color.BLACK);
			pk4.setColumns(10);
			pk4.setBackground(new Color(255, 182, 193));
			pk4.setBounds(232, 347, 96, 21);
			contentPane.add(pk4);
			pk4.setText("0");
		
			JButton pk5 = new JButton("");
			pk5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					pk5.setText(50*Integer.parseInt(pk4.getText())+"元");
					int sum=(Integer.parseInt(pt4.getText())+Integer.parseInt(dt4.getText())+Integer.parseInt(mt4.getText())+Integer.parseInt(cf4.getText())+Integer.parseInt(pk4.getText()))*50;
					if(memberserviceimpl.findByMemberId(MID)!=null) {amount.setText(""+sum);}
					else if(memberserviceimpl.findByVipMemberId(MID)!=null){amount.setText(""+(int)(sum*0.9));}
					else {amount.setText(""+(int)(sum*0.8));}
					
				}
			});
			pk5.setBackground(new Color(255, 182, 193));
			pk5.setBounds(338, 346, 85, 23);
			contentPane.add(pk5);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 416, 420, 187);
		contentPane.add(scrollPane);
		
		JTextArea output = new JTextArea();
		scrollPane.setViewportView(output);
		output.setBackground(new Color(250, 250, 210));
		
		JButton btnNewButton_1 = new JButton("列印");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(output.getText().isEmpty()) {JOptionPane.showMessageDialog(null,"沒有東西可以列印!","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
				else {
					try {
						output.print();
					} catch (PrinterException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton_1.setBounds(120, 610, 85, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("返回");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.LoginSeccess();
				dispose();
			}
		});
		btnNewButton_2.setBounds(220, 610, 85, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("登出");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				member=null;
				Tool.Login();
				dispose();
			}
		});
		btnNewButton_3.setBounds(320, 610, 85, 23);
		contentPane.add(btnNewButton_3);
		
		pay = new JTextField();
		pay.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		pay.setBounds(145, 390, 73, 21);
		contentPane.add(pay);
		pay.setColumns(10);
		pay.setText("0");
		
		JLabel lblNewLabel_4 = new JLabel("元");
		lblNewLabel_4.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(230, 391, 46, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("支付:");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_4_1.setBounds(100, 388, 46, 21);
		contentPane.add(lblNewLabel_4_1);
		
		
		
		JButton btnNewButton = new JButton("確認");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(MemberTool.Id(pk4.getText())){JOptionPane.showMessageDialog(null,"杯數請輸入數字","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);return;}
				else if(MemberTool.Id(pt4.getText())){JOptionPane.showMessageDialog(null,"杯數請輸入數字","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);return;}
				else if(MemberTool.Id(dt4.getText())){JOptionPane.showMessageDialog(null,"杯數請輸入數字","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);return;}
				else if(MemberTool.Id(mt4.getText())){JOptionPane.showMessageDialog(null,"杯數請輸入數字","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);return;}
				else if(MemberTool.Id(cf4.getText())){JOptionPane.showMessageDialog(null,"杯數請輸入數字","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);return;}
				else if(MemberTool.Id(pay.getText())){JOptionPane.showMessageDialog(null,"支付金額請輸入數字","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);return;}
				else if(Integer.parseInt(amount.getText())<(Integer.parseInt(pt4.getText())+Integer.parseInt(dt4.getText())+Integer.parseInt(mt4.getText())+Integer.parseInt(cf4.getText())+Integer.parseInt(pk4.getText()))*40) {JOptionPane.showMessageDialog(null,"請記得在填完飲料選單後按下該飲料對印顏色後面的按鈕","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
				else if(Integer.parseInt(amount.getText())==0) {JOptionPane.showMessageDialog(null,"沒有點飲料無法成立訂單，請點完飲料再按確認鍵","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
				else if(Integer.parseInt(pay.getText())<Integer.parseInt(amount.getText())) {JOptionPane.showMessageDialog(null,"您所支付的錢不夠支付訂單金額","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
				else{
					int pearlmilktea=Integer.parseInt(pt4.getText());
					int duoduogreentea=Integer.parseInt(dt4.getText());
					int milkcoveredgreentea=Integer.parseInt(mt4.getText());
					int coffee=Integer.parseInt(cf4.getText());
					int pearlmilk=Integer.parseInt(pk4.getText());
						Porder p=new Porder(member.getName(),member.getUsername(),pearlmilktea,duoduogreentea,milkcoveredgreentea,coffee,pearlmilk,Tool.getTime1());
						porderserviceimpl.addPorder(p);
						String show=
								"\n客戶名:"+p.getName()+
								"\n客戶帳號:"+p.getUsername()+
								"\n珍珠奶茶:"+p.getPearlmilktea()+"杯\t甜度:"+pt2.getSelectedItem().toString()+"\t冰度:"+pt3.getSelectedItem().toString()+
								"\n多多綠茶:"+p.getDuoduogreentea()+"杯\t甜度:"+dt2.getSelectedItem().toString()+"\t冰度:"+dt3.getSelectedItem().toString()+
								"\n奶蓋綠茶:"+p.getMilkcoveredgreentea()+"杯\t甜度:"+mt2.getSelectedItem().toString()+"\t冰度:"+mt3.getSelectedItem().toString()+
								"\n咖啡:"+p.getCoffee()+"杯\t甜度:"+cf2.getSelectedItem().toString()+"\t冰度:"+cf3.getSelectedItem().toString()+
								"\n珍珠鮮奶:"+p.getPearlmilk()+"杯\t甜度:"+pk2.getSelectedItem().toString()+"\t冰度:"+pk3.getSelectedItem().toString()+
								"\n購買時間:"+p.getTime()+
								"\n------------------------------------";
						int Pay=Integer.parseInt(pay.getText());
						int Sum=Integer.parseInt(amount.getText());
						output.setText(show+"\n需要支付金額:"+(Sum+"元\n您支付的金額是"+Pay+"元\n找"+(Pay-Sum)+"元"));
						
				
				}
				
			}
		});
		btnNewButton.setBounds(20, 610, 85, 23);
		contentPane.add(btnNewButton);
		
		
		
		
		class ClockRunnable implements Runnable
		{@Override
		public void run() {
		while (true) {
			clock.setText(Tool.getTime()) ;
			try
			{Thread.sleep(1000);}
			catch(InterruptedException e)
			{e.printStackTrace ();}}}}
		
				
		addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				super.windowActivated(e);
				new Thread(new ClockRunnable()).start();
			}
		});
		
		
		
		
	}
}
