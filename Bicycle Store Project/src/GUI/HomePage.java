package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.font.OpenType;
import java.awt.event.ActionEvent;

public class HomePage {

	public JFrame frame;
	JButton btnMenuRent, btnMenuReturn, btnMenuCus, btnMenuBicycle, btnMenuStore, btnMenuLogout;
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
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 840, 453);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(10, 10, 290, 406);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hệ Thống Cửa Hàng");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel.setBounds(44, 156, 211, 42);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cho Thuê Xe Đạp");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_1.setBounds(54, 196, 195, 42);
		panel.add(lblNewLabel_1);
		
		btnMenuRent = new JButton("Thuê xe");
		btnMenuRent.setBackground(Color.WHITE);
		btnMenuRent.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMenuRent.setBounds(306, 11, 252, 125);
		frame.getContentPane().add(btnMenuRent);
		btnMenuRent.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Rent openRent = new Rent();
				openRent.frmThu.setVisible(true);
				
				frame.setVisible(false);
				
				
			}
		});
		
		btnMenuReturn = new JButton("Trả xe");
		btnMenuReturn.setBackground(Color.WHITE);
		btnMenuReturn.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMenuReturn.setBounds(564, 11, 252, 125);
		frame.getContentPane().add(btnMenuReturn);
		btnMenuReturn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnMenuBicycle = new JButton("Quản lý xe đạp ");
		btnMenuBicycle.setBackground(Color.WHITE);
		btnMenuBicycle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMenuBicycle.setBounds(306, 147, 252, 125);
		frame.getContentPane().add(btnMenuBicycle);
		btnMenuBicycle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnMenuStore = new JButton("Thông tin cửa hàng");
		btnMenuStore.setBackground(Color.WHITE);
		btnMenuStore.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMenuStore.setBounds(564, 147, 252, 125);
		frame.getContentPane().add(btnMenuStore);
		btnMenuStore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnMenuCus = new JButton("Quản lý khách hàng");
		btnMenuCus.setBackground(Color.WHITE);
		btnMenuCus.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMenuCus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer openCus = new Customer();
				openCus.frame.setVisible(true);
				
				frame.setVisible(false);
			}
		});
		
		btnMenuCus.setBounds(306, 283, 252, 125);
		frame.getContentPane().add(btnMenuCus);
		
		btnMenuLogout = new JButton("Đăng xuất");
		btnMenuLogout.setBackground(Color.WHITE);
		btnMenuLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login log = new Login();
				log.frmLogin.setVisible(true);
				
				frame.setVisible(false);
			}
		});
		btnMenuLogout.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMenuLogout.setBounds(564, 283, 252, 125);
		frame.getContentPane().add(btnMenuLogout);
	}
}
