package controller.porder;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import service.impl.MemberServiceImpl;
import service.impl.PorderServiceImpl;
import util.MemberTool;
import util.Tool;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PorderManagementUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;
	private JTextField seller;
	private JTextField idupdate;
	private JTextField pearlmilktea;
	private JTextField duoduogreentea;
	private JTextField milkcoveredgreentea;
	private JTextField coffee;
	private JTextField pearlmilk;
	private JTextField idusername;
	private JTextField username;
	private static MemberServiceImpl memberserviceimpl=new MemberServiceImpl();
	private static PorderServiceImpl porderserviceimpl=new PorderServiceImpl();
	private JTextField deleteid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PorderManagementUI frame = new PorderManagementUI();
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
	public PorderManagementUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 370);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("訂單管理系統");
		lblNewLabel.setFont(new Font("標楷體", Font.BOLD, 24));
		lblNewLabel.setBounds(154, 10, 258, 58);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("員工上傳資料：");
		lblNewLabel_1.setFont(new Font("新宋体", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 58, 134, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID:");
		lblNewLabel_2.setFont(new Font("新宋体", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 81, 46, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("服務員:");
		lblNewLabel_3.setFont(new Font("新宋体", Font.BOLD, 14));
		lblNewLabel_3.setBounds(142, 81, 57, 18);
		contentPane.add(lblNewLabel_3);
		
		id = new JTextField();
		id.setBounds(36, 78, 96, 21);
		contentPane.add(id);
		id.setColumns(10);
		id.setText("0");
		
		seller = new JTextField();
		seller.setBounds(195, 78, 96, 21);
		contentPane.add(seller);
		seller.setColumns(10);
		seller.setText("Null");
		
		JButton btnNewButton = new JButton("確認");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(MemberTool.Id(id.getText())){JOptionPane.showMessageDialog(null,"id請輸入數字","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);return;}
				else if(porderserviceimpl.findById(Integer.parseInt(id.getText()))==null) {JOptionPane.showMessageDialog(null,"查無此訂單","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);return;}
				else if(memberserviceimpl.findByEmployeeName(seller.getText())==null){JOptionPane.showMessageDialog(null,"檢查服務員的名字是否有誤","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);return;}
				else {porderserviceimpl.updateSeller(seller.getText(),Integer.parseInt(id.getText()));JOptionPane.showMessageDialog(null,"編號:"+Integer.parseInt(id.getText())+"的訂單已成功更新","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
				
			}
		});
		btnNewButton.setBounds(307, 80, 85, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("訂單內容更改：");
		lblNewLabel_1_1.setFont(new Font("新宋体", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 116, 134, 26);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("ID:");
		lblNewLabel_2_1.setFont(new Font("新宋体", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(10, 140, 46, 15);
		contentPane.add(lblNewLabel_2_1);
		
		idupdate = new JTextField();
		idupdate.setText("0");
		idupdate.setColumns(10);
		idupdate.setBounds(36, 137, 96, 21);
		contentPane.add(idupdate);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("珍奶:");
		lblNewLabel_2_1_1.setFont(new Font("新宋体", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(142, 140, 46, 15);
		contentPane.add(lblNewLabel_2_1_1);
		
		pearlmilktea = new JTextField();
		pearlmilktea.setText("0");
		pearlmilktea.setColumns(10);
		pearlmilktea.setBounds(180, 137, 96, 21);
		contentPane.add(pearlmilktea);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("多多綠:");
		lblNewLabel_2_1_2.setFont(new Font("新宋体", Font.BOLD, 14));
		lblNewLabel_2_1_2.setBounds(10, 170, 67, 15);
		contentPane.add(lblNewLabel_2_1_2);
		
		duoduogreentea = new JTextField();
		duoduogreentea.setText("0");
		duoduogreentea.setColumns(10);
		duoduogreentea.setBounds(65, 167, 96, 21);
		contentPane.add(duoduogreentea);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("奶蓋:");
		lblNewLabel_2_1_2_1.setFont(new Font("新宋体", Font.BOLD, 14));
		lblNewLabel_2_1_2_1.setBounds(165, 170, 67, 15);
		contentPane.add(lblNewLabel_2_1_2_1);
		
		milkcoveredgreentea = new JTextField();
		milkcoveredgreentea.setText("0");
		milkcoveredgreentea.setColumns(10);
		milkcoveredgreentea.setBounds(203, 167, 96, 21);
		contentPane.add(milkcoveredgreentea);
		
		JLabel lblNewLabel_2_1_2_2 = new JLabel("咖啡:");
		lblNewLabel_2_1_2_2.setFont(new Font("新宋体", Font.BOLD, 14));
		lblNewLabel_2_1_2_2.setBounds(10, 198, 67, 15);
		contentPane.add(lblNewLabel_2_1_2_2);
		
		coffee = new JTextField();
		coffee.setText("0");
		coffee.setColumns(10);
		coffee.setBounds(48, 195, 96, 21);
		contentPane.add(coffee);
		
		JLabel lblNewLabel_2_1_2_1_1 = new JLabel("珍鮮:");
		lblNewLabel_2_1_2_1_1.setFont(new Font("新宋体", Font.BOLD, 14));
		lblNewLabel_2_1_2_1_1.setBounds(150, 198, 67, 15);
		contentPane.add(lblNewLabel_2_1_2_1_1);
		
		pearlmilk = new JTextField();
		pearlmilk.setText("0");
		pearlmilk.setColumns(10);
		pearlmilk.setBounds(188, 195, 96, 21);
		contentPane.add(pearlmilk);
		
		JButton btnNewButton_1 = new JButton("確認");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(MemberTool.Id(idupdate.getText())){JOptionPane.showMessageDialog(null,"id請輸入數字","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);return;}
				else if(MemberTool.Id(pearlmilktea.getText()) || MemberTool.Id(coffee.getText()) || MemberTool.Id(duoduogreentea.getText()) || MemberTool.Id(milkcoveredgreentea.getText()) || MemberTool.Id(pearlmilk.getText()) ){JOptionPane.showMessageDialog(null,"飲料數量請輸入數字","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);return;}
				else if(Integer.parseInt(pearlmilktea.getText())<0 || Integer.parseInt(duoduogreentea.getText())<0 || Integer.parseInt(milkcoveredgreentea.getText())<0 || Integer.parseInt(coffee.getText())<0 || Integer.parseInt(pearlmilk.getText())<0) {JOptionPane.showMessageDialog(null,"飲料數量不能為負數","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);return;}
				else if(porderserviceimpl.findById(Integer.parseInt(idupdate.getText()))==null){JOptionPane.showMessageDialog(null,"查不到這個訂單編號","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);return;}
				else {porderserviceimpl.updatePorder(Integer.parseInt(pearlmilktea.getText()),Integer.parseInt(duoduogreentea.getText()),Integer.parseInt(milkcoveredgreentea.getText()),Integer.parseInt(coffee.getText()),Integer.parseInt(pearlmilk.getText()),Integer.parseInt(idupdate.getText()));JOptionPane.showMessageDialog(null,"編號:"+Integer.parseInt(idupdate.getText())+"的訂單已成功更新","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
			}
		});
		btnNewButton_1.setBounds(307, 194, 85, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("訂單客戶名字更改：");
		lblNewLabel_1_1_1.setFont(new Font("新宋体", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(10, 223, 140, 26);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("ID:");
		lblNewLabel_2_1_3.setFont(new Font("新宋体", Font.BOLD, 14));
		lblNewLabel_2_1_3.setBounds(10, 251, 46, 15);
		contentPane.add(lblNewLabel_2_1_3);
		
		idusername = new JTextField();
		idusername.setText("0");
		idusername.setColumns(10);
		idusername.setBounds(36, 248, 96, 21);
		contentPane.add(idusername);
		
		JLabel lblNewLabel_3_1 = new JLabel("帳號:");
		lblNewLabel_3_1.setFont(new Font("新宋体", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(142, 251, 57, 18);
		contentPane.add(lblNewLabel_3_1);
		
		username = new JTextField();
		username.setText("Null");
		username.setColumns(10);
		username.setBounds(180, 248, 96, 21);
		contentPane.add(username);
		
		JButton btnNewButton_2 = new JButton("確認");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(MemberTool.Id(idusername.getText())){JOptionPane.showMessageDialog(null,"id請輸入數字","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);return;}
				else if(porderserviceimpl.findById(Integer.parseInt(idusername.getText()))==null){JOptionPane.showMessageDialog(null,"查不到這個訂單編號","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);return;}
				else if(memberserviceimpl.findByUsername(username.getText())==null){JOptionPane.showMessageDialog(null,"客戶的帳號尚未註冊過，請進行確認正確與否，或重新註冊過後再更正","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);return;}
				else {porderserviceimpl.updatePorder(username.getText(),Integer.parseInt(idusername.getText()));JOptionPane.showMessageDialog(null,"編號:"+Integer.parseInt(idusername.getText())+"的訂單已成功更新","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
			}
		});
		btnNewButton_2.setBounds(307, 247, 85, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("返回");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.LoginSeccess();
				dispose();
			}
		});
		btnNewButton_3.setBounds(10, 10, 85, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("登出");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.Login();
				dispose();
			}
		});
		btnNewButton_4.setBounds(391, 289, 85, 23);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("訂單刪除：");
		lblNewLabel_1_1_1_1.setFont(new Font("新宋体", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(10, 273, 140, 26);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_2_1_3_1 = new JLabel("ID:");
		lblNewLabel_2_1_3_1.setFont(new Font("新宋体", Font.BOLD, 14));
		lblNewLabel_2_1_3_1.setBounds(10, 301, 46, 15);
		contentPane.add(lblNewLabel_2_1_3_1);
		
		deleteid = new JTextField();
		deleteid.setText("0");
		deleteid.setColumns(10);
		deleteid.setBounds(36, 298, 96, 21);
		contentPane.add(deleteid);
		
		JButton btnNewButton_2_1 = new JButton("確認");
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(MemberTool.Id(deleteid.getText())){JOptionPane.showMessageDialog(null,"id請輸入數字","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);return;}
				else if(porderserviceimpl.findById(Integer.parseInt(deleteid.getText()))==null){JOptionPane.showMessageDialog(null,"這個訂單編號已經被刪除了","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);return;}
				else{porderserviceimpl.deletePorderById(Integer.parseInt(deleteid.getText()));JOptionPane.showMessageDialog(null,"訂單編號:"+Integer.parseInt(deleteid.getText())+"現在被刪除了","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);return;}
			}
		});
		btnNewButton_2_1.setBounds(163, 297, 85, 23);
		contentPane.add(btnNewButton_2_1);
		
		
		
	}
}
