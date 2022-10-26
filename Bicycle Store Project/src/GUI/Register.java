package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnRegister;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Register window = new Register();
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
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 313, 393);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(frame);
		
		JLabel lblNewLabel = new JLabel("Tên đăng nhập");
		lblNewLabel.setBounds(53, 58, 96, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mật khẩu");
		lblNewLabel_1.setBounds(53, 124, 96, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nhập lại mật khẩu");
		lblNewLabel_2.setBounds(53, 192, 108, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(53, 149, 191, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(53, 83, 191, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(53, 217, 191, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		btnRegister = new JButton("Đăng ký");
		btnRegister.setBounds(53, 276, 89, 23);
		frame.getContentPane().add(btnRegister);
		
		btnBack = new JButton("Trở lại");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login back = new Login();
				back.frmLogin.setVisible(true);
				
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(155, 276, 89, 23);
		frame.getContentPane().add(btnBack);
	}

}
