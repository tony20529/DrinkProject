package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import service.impl.MemberServiceImpl;
import util.MemberTool;
import util.Tool;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

public class AddMemberUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JPasswordField password;
	private JTextField age;
	private JTextField mobile;
	public static int id=0;
	MemberServiceImpl memberserviceimpl=new MemberServiceImpl();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMemberUI frame = new AddMemberUI();
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
	public AddMemberUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panel.setBounds(0, 0, 434, 105);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("會員註冊");
		lblNewLabel.setFont(new Font("標楷體", Font.BOLD, 40));
		lblNewLabel.setBounds(129, 10, 183, 85);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("姓名:");
		lblNewLabel_1.setFont(new Font("標楷體", Font.BOLD, 18));
		lblNewLabel_1.setBounds(63, 161, 80, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("帳號:");
		lblNewLabel_1_1.setFont(new Font("標楷體", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(63, 228, 80, 34);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("密碼:");
		lblNewLabel_1_2.setFont(new Font("標楷體", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(63, 295, 80, 34);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("性別:");
		lblNewLabel_1_3.setFont(new Font("標楷體", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(63, 362, 80, 34);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("年齡:");
		lblNewLabel_1_4.setFont(new Font("標楷體", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(63, 429, 80, 34);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("電話:");
		lblNewLabel_1_5.setFont(new Font("標楷體", Font.BOLD, 18));
		lblNewLabel_1_5.setBounds(63, 496, 80, 34);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("地址:");
		lblNewLabel_1_6.setFont(new Font("標楷體", Font.BOLD, 18));
		lblNewLabel_1_6.setBounds(63, 563, 80, 34);
		contentPane.add(lblNewLabel_1_6);
		
		name = new JTextField();
		name.setBounds(138, 169, 96, 21);
		contentPane.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(138, 236, 96, 21);
		contentPane.add(username);
		
		password = new JPasswordField();
		password.setColumns(10);
		password.setBounds(138, 303, 96, 21);
		contentPane.add(password);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(138, 437, 96, 21);
		contentPane.add(age);
		
		mobile = new JTextField();
		mobile.setColumns(10);
		mobile.setBounds(138, 504, 178, 21);
		contentPane.add(mobile);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(138, 568, 286, 52);
		contentPane.add(scrollPane);
		
		JTextArea address = new JTextArea();
		scrollPane.setViewportView(address);
		
		JComboBox gender = new JComboBox();
		gender.setBackground(new Color(255, 255, 255));
		gender.addItem("男");
		gender.addItem("女");
		gender.setBounds(138, 369, 96, 23);
		contentPane.add(gender);
		
		JButton btnNewButton = new JButton("確認");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id=memberserviceimpl.findLatestId()+1;
				String Username=username.getText();
				if(new MemberServiceImpl().isUsernameBeenUse(Username)) {
					String Name=name.getText();
					String Password=password.getText();
					String Gender=gender.getSelectedItem().toString();
					String Address=address.getText();
					String Age=age.getText();
					String Mobile=mobile.getText();
					if(MemberTool.AddName(Name)) {JOptionPane.showMessageDialog(null,"名字請輸入2-6個中文字或1-10個英文字母","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
					else if(MemberTool.AddUsername(Username)) {JOptionPane.showMessageDialog(null,"帳號請輸入6-10個英文或數字","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
					else if(MemberTool.AddPassword(Password)){JOptionPane.showMessageDialog(null,"密碼請輸入6-12個英文或數字,而且密碼中要包含大寫英文與小寫英文還有數字","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
					else if(MemberTool.AddAge(Age)){JOptionPane.showMessageDialog(null,"請輸入真實年齡，未滿7歲的兒童依法需家長代為購買，故不能申辦帳號","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
					else if(MemberTool.AddMobile(Mobile)) {JOptionPane.showMessageDialog(null,"請輸入真實手機號碼","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
					else if(MemberTool.AddAddress(Address)){JOptionPane.showMessageDialog(null,"請輸入完整聯絡地址","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
					else{
							Member member=new Member(id,Name,Username,Password,Gender,Age,Address,Mobile);
							Tool.save(member, "member.txt");
							new MemberServiceImpl().addMember(member);
							Tool.AddMemberSuccess();
							dispose();
						}
					
				}
				else {
					Tool.AddMemberError();
					dispose();
				}
			}
		});
		btnNewButton.setBounds(138, 628, 87, 23);
		contentPane.add(btnNewButton);
	}
}
