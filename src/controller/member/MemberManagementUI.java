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

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MemberManagementUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField searchid;
	private JTextField deleteid;
	private MemberServiceImpl memberserviceimpl=new MemberServiceImpl();
	private static Member M=(Member)Tool.read("member.txt");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberManagementUI frame = new MemberManagementUI();
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
	public MemberManagementUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("會員管理系統");
		lblNewLabel.setBounds(143, 10, 222, 66);
		lblNewLabel.setFont(new Font("標楷體", Font.BOLD, 24));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("返回");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.LoginSeccess();
				dispose();
			}
		});
		btnNewButton.setBounds(10, 10, 87, 23);
		btnNewButton.setBackground(new Color(240, 255, 255));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("登出");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.Login();
				dispose();
			}
		});
		btnNewButton_1.setBounds(387, 228, 87, 23);
		btnNewButton_1.setBackground(new Color(221, 160, 221));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("會員清單");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AllMemberUI allmember=new AllMemberUI();
				allmember.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_2.setBounds(71, 73, 87, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(206, 76, 46, 15);
		contentPane.add(lblNewLabel_1);
		
		searchid = new JTextField();
		searchid.setBounds(235, 74, 96, 21);
		contentPane.add(searchid);
		searchid.setColumns(10);
		searchid.setText("0");
		
		JButton btnNewButton_3 = new JButton("查詢");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(MemberTool.Id(searchid.getText())){JOptionPane.showMessageDialog(null,"ID請輸入數字","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
				int id=Integer.parseInt(searchid.getText());
				if(memberserviceimpl.findByAllMemberId(id)!=null) {
					Member m=memberserviceimpl.findByAllMemberId(id);
					String show="客戶編號:"+m.getId()+
							"\t客戶姓名:"+m.getName()+
							"\t客戶帳號:"+m.getUsername()+
							"\t客戶密碼:"+m.getPassword()+
							"\t客戶性別:"+m.getGender()+
							"\t客戶年齡:"+m.getAge()+
							"\t客戶地址:"+m.getAddress()+
							"\t客戶電話:"+m.getMobile()+
							"\n";
					Member member=new Member(show);
					Tool.save(member, "massage.txt");
					IDSearchUI idsearch=new IDSearchUI();
					idsearch.setVisible(true);
					dispose();
				}	
				else {JOptionPane.showMessageDialog(null,"找不到編號為"+id+"的ID","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
				
			}
		});
		btnNewButton_3.setBounds(341, 73, 64, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("新增會員");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TopAddMemberUI topaddmember=new TopAddMemberUI();
				topaddmember.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setBounds(71, 125, 87, 23);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_2 = new JLabel("刪除成員:");
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(71, 158, 87, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID:");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(153, 168, 46, 15);
		contentPane.add(lblNewLabel_1_1);
		
		deleteid = new JTextField();
		deleteid.setColumns(10);
		deleteid.setBounds(181, 165, 96, 21);
		contentPane.add(deleteid);
		deleteid.setText("0");
		
		JButton btnNewButton_3_1 = new JButton("刪除");
		btnNewButton_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(MemberTool.Id(deleteid.getText())){JOptionPane.showMessageDialog(null,"ID請輸入數字","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
				else if(memberserviceimpl.findByAllMemberId(Integer.parseInt(deleteid.getText()))!=null) {
					memberserviceimpl.deleteMember(Integer.parseInt(deleteid.getText()));
					JOptionPane.showMessageDialog(null,"ID編號為"+Integer.parseInt(deleteid.getText())+"的會員已經被刪除","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);
				}
				else {JOptionPane.showMessageDialog(null,"ID編號為"+Integer.parseInt(deleteid.getText())+"的會員早就已經被刪除了","科技幻影體驗館",JOptionPane.PLAIN_MESSAGE);}
			}
		});
		btnNewButton_3_1.setBounds(287, 164, 64, 23);
		contentPane.add(btnNewButton_3_1);
		
		JButton btnNewButton_5 = new JButton("客戶管理系統");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.GuestManagement();
				dispose();
			}
		});
		btnNewButton_5.setBounds(181, 228, 125, 23);
		contentPane.add(btnNewButton_5);
	}
}
