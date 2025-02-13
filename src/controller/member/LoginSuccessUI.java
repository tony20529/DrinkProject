package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.porder.PorderManagementUI;
import controller.porder.PorderOrderPrint;
import model.Member;
import service.impl.MemberServiceImpl;
import util.Tool;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginSuccessUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Member member=(Member)Tool.read("member.txt");
	private static MemberServiceImpl memberserviceimpl=new MemberServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSuccessUI frame = new LoginSuccessUI();
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
	public LoginSuccessUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel message = new JLabel("New label");
		message.setFont(new Font("新細明體", Font.BOLD, 16));
		message.setBounds(10, 0, 464, 56);
		contentPane.add(message);
		message.setText("歡迎"+member.getName()+"您的登入時間是"+Tool.getTime()) ;
		
		JLabel lblNewLabel = new JLabel("請選擇您下一步的操作：");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 54, 371, 49);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("體驗選單");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.Porder();
				dispose();
			}
		});
		btnNewButton.setBounds(62, 100, 87, 17);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("個資更改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tool.UpdateMember();
				dispose();
			}
		});
		btnNewButton_1.setBounds(188, 100, 87, 17);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_5 = new JButton("登出");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.Login();
				dispose();
			}
		});
		btnNewButton_5.setBounds(387, 228, 87, 23);
		contentPane.add(btnNewButton_5);
		
		
		
		if(memberserviceimpl.findByEmployeeMemberId(member.getId())!=null ||memberserviceimpl.findBySuperuserMemberId(member.getId())!=null) 
		{
			JButton btnNewButton_2 = new JButton("客戶管理");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Tool.GuestManagement();
					dispose();
				}
			});
			btnNewButton_2.setBounds(62, 131, 87, 17);
			contentPane.add(btnNewButton_2);
			
			
			JButton btnNewButton_2_1 = new JButton("訂單管理");
			btnNewButton_2_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					PorderManagementUI pordermanagement=new PorderManagementUI();
					pordermanagement.setVisible(true);
					dispose();
				}
			});
			btnNewButton_2_1.setBounds(188, 131, 87, 17);
			contentPane.add(btnNewButton_2_1);
		}
			if(memberserviceimpl.findBySuperuserMemberId(member.getId())!=null) {
				JButton btnNewButton_3 = new JButton("人員管理");
				btnNewButton_3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Tool.MemberManagement();
						dispose();
					}
				});
				btnNewButton_3.setBounds(62, 174, 87, 17);
				contentPane.add(btnNewButton_3);
		
				JButton btnNewButton_4 = new JButton("報表管理");
				btnNewButton_4.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						PorderOrderPrint porderorderprint=new PorderOrderPrint();
						porderorderprint.setVisible(true);
						dispose();
					}
				});
				btnNewButton_4.setBounds(188, 174, 87, 17);
				contentPane.add(btnNewButton_4);
			}
			
			
	}
	
	

}
