package controller.member;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.impl.MemberServiceImpl;
import util.MemberTool;
import util.Tool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class GuestManagementUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;
	private JPasswordField password;
	private static MemberServiceImpl memberserviceimpl=new MemberServiceImpl();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuestManagementUI frame = new GuestManagementUI();
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
	public GuestManagementUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("客戶管理系統");
		lblNewLabel.setFont(new Font("標楷體", Font.BOLD, 24));
		lblNewLabel.setBounds(154, 10, 258, 58);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("客戶更改密碼：");
		lblNewLabel_1.setFont(new Font("新宋体", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 58, 134, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID:");
		lblNewLabel_2.setFont(new Font("新宋体", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 81, 46, 15);
		contentPane.add(lblNewLabel_2);
		
		id = new JTextField();
		id.setBounds(36, 81, 96, 21);
		contentPane.add(id);
		id.setColumns(10);
		id.setText("0");
		
		JLabel lblNewLabel_3 = new JLabel("密碼:");
		lblNewLabel_3.setFont(new Font("新宋体", Font.BOLD, 14));
		lblNewLabel_3.setBounds(142, 81, 46, 15);
		contentPane.add(lblNewLabel_3);
		
		password = new JPasswordField();
		password.setBounds(182, 81, 96, 21);
		contentPane.add(password);
		
		JButton btnNewButton = new JButton("確認");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(MemberTool.Id(id.getText())){JOptionPane.showMessageDialog(null,"ID請輸入數字","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
				int Id=Integer.parseInt(id.getText());
				String Password=password.getText();
				
				if(memberserviceimpl.findByAllMemberId(Id)!=null) {
					if(MemberTool.AddPassword(Password)){JOptionPane.showMessageDialog(null,"密碼請輸入6-12個英文或數字,而且密碼中要包含大寫英文與小寫英文還有數字","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
					else {memberserviceimpl.updateMemberPassword(Id,Password);}
				}
				else {JOptionPane.showMessageDialog(null,"沒有編號為"+Id+"的會員","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
			}
		});
		btnNewButton.setBounds(300, 81, 96, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("查詢客戶資料：");
		lblNewLabel_1_1.setFont(new Font("新宋体", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 106, 134, 26);
		contentPane.add(lblNewLabel_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 136, 464, 115);
		contentPane.add(scrollPane);
		
		JTextArea output = new JTextArea();
		scrollPane.setViewportView(output);
		
		
		JButton btnNewButton_1 = new JButton("查詢");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				output.setText(memberserviceimpl.AllGuest());
			}
		});
		btnNewButton_1.setBounds(113, 109, 87, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("登出");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.Login();
				dispose();
			}
		});
		btnNewButton_2.setBounds(387, 10, 87, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("返回");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.LoginSeccess();
				dispose();
			}
		});
		btnNewButton_3.setBounds(10, 10, 87, 23);
		contentPane.add(btnNewButton_3);
	}

}
