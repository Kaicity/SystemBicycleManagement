package src.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;

public class Login {

	JFrame frmLogin;
	private JTextField tfUserLogin;
	private JPasswordField tfPass;
	private ButtonGroup rdMenuLogin;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Login window = new Login();
//					window.frmLogin.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 520, 264);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		frmLogin.setLocationRelativeTo(frmLogin);
		
		JLabel lblNewLabel = new JLabel("Tên đăng nhập");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(71, 80, 126, 26);
		frmLogin.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mật khẩu");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(71, 133, 80, 14);
		frmLogin.getContentPane().add(lblNewLabel_1);
		
		tfUserLogin = new JTextField();
		tfUserLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfUserLogin.setBounds(180, 79, 227, 29);
		frmLogin.getContentPane().add(tfUserLogin);
		tfUserLogin.setColumns(10);
		
		tfPass = new JPasswordField();
		tfPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfPass.setBounds(180, 128, 227, 29);
		frmLogin.getContentPane().add(tfPass);
		
		JButton btnLogin = new JButton("Đăng nhập");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * String user = tfUserLogin.getText(); String pass =
				 * String.valueOf(tfPass.getPassword()); if(user.trim().equals("") ||
				 * pass.trim().equals("")){ JOptionPane.showMessageDialog(frmLogin,
				 * "Chưa nhập đầy đủ thông tin", "Thông báo", JOptionPane.ERROR_MESSAGE); }
				 * 
				 * 
				 * else if( "admin".equals(user) && "123".equals(pass)) { HomePage home = new
				 * HomePage(); home.frame.setVisible(true); home.textAdmin.setText(user);
				 * frmLogin.setVisible(false);
				 * 
				 * } else { //custom title, warning icon JOptionPane.showMessageDialog(frmLogin,
				 * "Tên đăng nhập mật khẩu sai", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				 * 
				 * }
				 */
				
				HomePage home = new HomePage();
				home.frame.setVisible(true);
				home.textAdmin.setText("user");
				frmLogin.setVisible(false);
			}
		});
		btnLogin.setBounds(180, 168, 106, 29);
		frmLogin.getContentPane().add(btnLogin);
		
		JLabel lblNewLabel_2 = new JLabel("Hệ thống thuê xe đạp ");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2.setBounds(146, 11, 248, 37);
		frmLogin.getContentPane().add(lblNewLabel_2);
		
		JButton btnExitLogin = new JButton("Thoát");
		btnExitLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 frmLogin.setVisible(false);
			 
			 UserHomePage back = new UserHomePage();
			 back.frame.setVisible(true);
			 
			}
		});
		btnExitLogin.setBounds(318, 168, 89, 29);
		frmLogin.getContentPane().add(btnExitLogin);
		
		rdMenuLogin = new ButtonGroup();
		
		
		//Event Form Login
		eventLogin();
	}
	
	private void eventLogin() {
	}
}
