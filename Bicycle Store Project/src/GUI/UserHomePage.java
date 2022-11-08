package src.GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.font.OpenType;
import java.awt.event.ActionEvent;

public class UserHomePage {

	public JFrame frame;
	JButton btnMenuRent, btnMenuLogout;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HomePage window = new HomePage();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public UserHomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Trang chính");
		frame.setBounds(100, 100, 840, 342);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(frame);

		
		Panel panel = new Panel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(10, 10, 290, 280);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hệ Thống Cửa Hàng");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel.setBounds(38, 98, 211, 42);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cho Thuê Xe Đạp");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_1.setBounds(38, 139, 195, 42);
		panel.add(lblNewLabel_1);
		
		btnMenuRent = new JButton("Thuê xe");
		btnMenuRent.setBackground(Color.WHITE);
		btnMenuRent.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMenuRent.setBounds(306, 11, 510, 163);
		frame.getContentPane().add(btnMenuRent);
		btnMenuRent.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RentBike openRent = new RentBike();
				openRent.frmThu.setVisible(true);
				
				frame.setVisible(false);
				
				
			}
		});
		
		btnMenuLogout = new JButton("Quản lý chung");
		btnMenuLogout.setBackground(Color.WHITE);
		btnMenuLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int result = JOptionPane.showConfirmDialog(frame, "Chức năng quản lý chỉ sử dụng cho nhân viên",
						"Thông báo",JOptionPane.YES_NO_OPTION ,JOptionPane.INFORMATION_MESSAGE);
				if(result == JOptionPane.YES_OPTION) {
					Login log = new Login();
					log.frmLogin.setVisible(true);
					
					frame.setVisible(false);
				}
				
				
			}
		});
		btnMenuLogout.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMenuLogout.setBounds(497, 185, 181, 105);
		frame.getContentPane().add(btnMenuLogout);
		
		JButton btnLchSThu = new JButton("Lịch sử giao dịch");
		btnLchSThu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLchSThu.setBackground(Color.WHITE);
		btnLchSThu.setBounds(306, 185, 181, 105);
		frame.getContentPane().add(btnLchSThu);
		
		JButton btnThoatUserHome = new JButton("Thoát");
		btnThoatUserHome.setBackground(Color.WHITE);
		btnThoatUserHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnThoatUserHome.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThoatUserHome.setBounds(688, 185, 128, 105);
		frame.getContentPane().add(btnThoatUserHome);
	}
}
