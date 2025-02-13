package controller.member;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import service.impl.MemberServiceImpl;
import util.MemberTool;
import util.Tool;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TopAddMemberUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JPasswordField password;
	private JTextField age;
	private JTextField mobile;
	MemberServiceImpl memberserviceimpl=new MemberServiceImpl();
	private JTextField searchid;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TopAddMemberUI frame = new TopAddMemberUI();
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
	public TopAddMemberUI() {
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
		
		JLabel lblNewLabel = new JLabel("會員新增更改系統");
		lblNewLabel.setFont(new Font("標楷體", Font.BOLD, 40));
		lblNewLabel.setBounds(58, 10, 352, 85);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("姓名:");
		lblNewLabel_1.setFont(new Font("標楷體", Font.BOLD, 18));
		lblNewLabel_1.setBounds(63, 161, 80, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("帳號:");
		lblNewLabel_2.setFont(new Font("標楷體", Font.BOLD, 18));
		lblNewLabel_2.setBounds(63, 228, 80, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("密碼:");
		lblNewLabel_3.setFont(new Font("標楷體", Font.BOLD, 18));
		lblNewLabel_3.setBounds(63, 295, 80, 34);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("性別:");
		lblNewLabel_4.setFont(new Font("標楷體", Font.BOLD, 18));
		lblNewLabel_4.setBounds(63, 362, 80, 34);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("年齡:");
		lblNewLabel_5.setFont(new Font("標楷體", Font.BOLD, 18));
		lblNewLabel_5.setBounds(63, 429, 80, 34);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("電話:");
		lblNewLabel_6.setFont(new Font("標楷體", Font.BOLD, 18));
		lblNewLabel_6.setBounds(63, 496, 80, 34);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("地址:");
		lblNewLabel_7.setFont(new Font("標楷體", Font.BOLD, 18));
		lblNewLabel_7.setBounds(63, 563, 80, 34);
		contentPane.add(lblNewLabel_7);
		
		name = new JTextField();
		name.setBounds(138, 169, 96, 21);
		contentPane.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setBounds(138, 236, 96, 21);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(138, 303, 96, 21);
		contentPane.add(password);
		
		JComboBox gender = new JComboBox();
		gender.setBackground(new Color(255, 255, 255));
		gender.addItem("男");
		gender.addItem("女");
		gender.setBounds(138, 369, 96, 23);
		contentPane.add(gender);
		
		age = new JTextField();
		age.setBounds(138, 437, 96, 21);
		contentPane.add(age);
		age.setColumns(10);
		
		mobile = new JTextField();
		mobile.setBounds(138, 504, 178, 21);
		contentPane.add(mobile);
		mobile.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(138, 568, 286, 52);
		contentPane.add(scrollPane);
		
		JTextArea address = new JTextArea();
		scrollPane.setViewportView(address);
		
		JComboBox grade = new JComboBox();
		grade.setBackground(new Color(255, 255, 255));
		grade.addItem("Member");
		grade.addItem("VIPMember");
		grade.addItem("Employee");
		grade.addItem("Superuser");
		grade.setBounds(138, 115, 96, 23);
		contentPane.add(grade);
		
		JLabel lblNewLabel_1_1 = new JLabel("會員等級:");
		lblNewLabel_1_1.setFont(new Font("標楷體", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(24, 108, 105, 34);
		contentPane.add(lblNewLabel_1_1);
		
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
							if(grade.getSelectedItem().toString().equals("Member")) {new MemberServiceImpl().addMember(member);JOptionPane.showMessageDialog(null,"新增會員成功","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
							else if(grade.getSelectedItem().toString().equals("VIPMember")){new MemberServiceImpl().addVipMember(member);JOptionPane.showMessageDialog(null,"新增VIP會員成功","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
							else if(grade.getSelectedItem().toString().equals("Employee")){new MemberServiceImpl().addEmployeeMember(member);JOptionPane.showMessageDialog(null,"新增員工成功","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
							else if(grade.getSelectedItem().toString().equals("Superuser")){new MemberServiceImpl().addSuperuserMember(member);JOptionPane.showMessageDialog(null,"新增管理員成功","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
							
						}
					
				}
				else {
					JOptionPane.showMessageDialog(null,"帳號已被使用過，請重新新增一次","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(138, 628, 87, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.MemberManagement();
				dispose();
			}
		});
		btnNewButton_1.setBounds(10, 628, 87, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_8 = new JLabel("ID:");
		lblNewLabel_8.setFont(new Font("標楷體", Font.BOLD, 18));
		lblNewLabel_8.setBounds(256, 114, 46, 23);
		contentPane.add(lblNewLabel_8);
		
		searchid = new JTextField();
		searchid.setColumns(10);
		searchid.setBounds(291, 115, 96, 21);
		contentPane.add(searchid);
		searchid.setText("0");
		
		JButton btnNewButton_2 = new JButton("ID確認");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(MemberTool.Id(searchid.getText())){JOptionPane.showMessageDialog(null,"ID請輸入數字","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
				int id=Integer.parseInt(searchid.getText());
				if(memberserviceimpl.findByAllMemberId(id)!=null)
				{
					Member m=memberserviceimpl.findByAllMemberId(id);
					name.setText(m.getName());
					username.setText(m.getUsername());
					password.setText(m.getPassword());
					gender.setSelectedItem(m.getGender());
					age.setText(m.getAge());
					mobile.setText(m.getMobile());
					address.setText(m.getAddress());
					if(memberserviceimpl.findByMemberId(id)!=null) {grade.setSelectedItem("Member");}
					else if(memberserviceimpl.findByVipMemberId(id)!=null) {grade.setSelectedItem("VIPMember");}
					else if(memberserviceimpl.findByEmployeeMemberId(id)!=null){grade.setSelectedItem("Employee");}
					else if(memberserviceimpl.findBySuperuserMemberId(id)!=null){grade.setSelectedItem("Superuser");}
	
				}
				else {JOptionPane.showMessageDialog(null,"ID編號為"+id+"的會員不存在","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
			}
		});
		btnNewButton_2.setBounds(301, 147, 87, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("更新資料");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(MemberTool.Id(searchid.getText())){JOptionPane.showMessageDialog(null,"ID請輸入數字","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
				int id=Integer.parseInt(searchid.getText());
				if(memberserviceimpl.findByAllMemberId(id)!=null) {
					memberserviceimpl.deleteMember(id);
					String Name=name.getText();
					String Username=username.getText();
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
							if(grade.getSelectedItem().toString().equals("Member")) {new MemberServiceImpl().addMember(member);JOptionPane.showMessageDialog(null,"更新會員資料成功","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
							else if(grade.getSelectedItem().toString().equals("VIPMember")){new MemberServiceImpl().addVipMember(member);JOptionPane.showMessageDialog(null,"更新VIP會員資料成功","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
							else if(grade.getSelectedItem().toString().equals("Employee")){new MemberServiceImpl().addEmployeeMember(member);JOptionPane.showMessageDialog(null,"更新員工資料成功","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
							else if(grade.getSelectedItem().toString().equals("Superuser")){new MemberServiceImpl().addSuperuserMember(member);JOptionPane.showMessageDialog(null,"更新管理員資料成功","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
							
						}
				}
				else {JOptionPane.showMessageDialog(null,"ID編號為"+id+"的會員不存在","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
			}
		});
		btnNewButton_3.setBounds(301, 191, 87, 23);
		contentPane.add(btnNewButton_3);
		
		
	}
}
