package src.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Customer {

	public JFrame frame;
	private JTextField tfCusID;
	private JTextField tfCusName;
	private JTextField tfCusPhone;
	private JTable tableCus;
	private JTextField tfCusSeach;
	private DefaultTableModel modelCus = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Customer window = new Customer();
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
	public Customer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 853, 432);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CCCD/CMND");
		lblNewLabel.setBounds(67, 75, 92, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên khách hàng");
		lblNewLabel_1.setBounds(67, 136, 92, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("SDT");
		lblNewLabel_2.setBounds(67, 203, 49, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		tfCusID = new JTextField();
		tfCusID.setBounds(172, 72, 191, 20);
		frame.getContentPane().add(tfCusID);
		tfCusID.setColumns(10);
		
		tfCusName = new JTextField();
		tfCusName.setBounds(172, 133, 191, 20);
		frame.getContentPane().add(tfCusName);
		tfCusName.setColumns(10);
		
		tfCusPhone = new JTextField();
		tfCusPhone.setBounds(172, 200, 191, 20);
		frame.getContentPane().add(tfCusPhone);
		tfCusPhone.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Quản lý thông tin khách hàng");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(67, 11, 344, 50);
		frame.getContentPane().add(lblNewLabel_4);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(197, 275, -30, 22);
		frame.getContentPane().add(textArea);
		
		tableCus = new JTable();
		tableCus.setLayout(null);
		frame.getContentPane().add(tableCus);
		
		tableCus.setModel(modelCus);
		
		modelCus.addColumn("STT");
		modelCus.addColumn("Mã khách hàng");
		modelCus.addColumn("Tên khách hàng");
		modelCus.addColumn("Số điện thoại");
		modelCus.addColumn("Địa chỉ");
		
		
		
		
		JScrollPane sc = new JScrollPane(tableCus);
		sc.setBounds(385, 74, 437, 266);
		frame.getContentPane().add(sc);
		
		modelCus.addRow(new Object[] {
				"###", "DWFEF8", "Bùi Thanh Trung", "0703338458", "317 Nguyễn Văn luông P12 Q6"
		});
		
		
		
		JButton btnCusAdd = new JButton("Thêm");
		btnCusAdd.setBounds(70, 267, 89, 30);
		frame.getContentPane().add(btnCusAdd);
		
		JButton btnCusEdit = new JButton("Sửa ");
		btnCusEdit.setBounds(172, 267, 89, 30);
		frame.getContentPane().add(btnCusEdit);
		
		JButton btnCusRemove = new JButton("Xóa");
		btnCusRemove.setBounds(70, 310, 89, 30);
		frame.getContentPane().add(btnCusRemove);
		
		JButton btnCusReset = new JButton("Reset");
		btnCusReset.setBounds(172, 310, 89, 30);
		frame.getContentPane().add(btnCusReset);
		
		tfCusSeach = new JTextField();
		tfCusSeach.setBackground(Color.WHITE);
		tfCusSeach.setBounds(385, 39, 133, 20);
		frame.getContentPane().add(tfCusSeach);
		tfCusSeach.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Tìm kiếm");
		btnNewButton_4.setBounds(528, 39, 89, 22);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton = new JButton("Thoát");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage home = new HomePage();
				home.frame.setVisible(true);
				
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(733, 351, 89, 30);
		frame.getContentPane().add(btnNewButton);
	}
}
