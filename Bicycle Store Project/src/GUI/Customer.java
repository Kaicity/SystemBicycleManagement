package src.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import src.BLL.CustomerBLL;
import src.DTO.Customer;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Customer {

	public JFrame frame;
	private JTextField tfCusID;
	private JTextField tfCusName;
	private JTextField tfCusPhone;
	private JTable tableCus;
	private JTextField tfCusSeach;
	private DefaultTableModel modelCus = new DefaultTableModel();
	private JButton btnCusAdd, btnCusRemove, btnCusReset, btnCusEdit;
	
	CustomerBLL cusBLL = new CustomerBLL();
	
	int count = 1;

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
		
		eventCustomer();
	}

	private void eventCustomer() {
		
		
		Vector<src.DTO.Customer> arr = cusBLL.getCustomerlist();
		for(int i = 0;i < arr.size(); i++) {
			src.DTO.Customer cus = arr.get(i);
			String cccd = cus.getCccd();
			String name = cus.getName();
			String phone = cus.getPhone();
			
			modelCus.addRow(new Object[] {
					count++, cccd, name, phone
			});
		}
		
		
		//Them khach hang moi 
		// TODO Auto-generated method stub
		btnCusAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tfCusID.getText().trim().isEmpty() || tfCusName.getText().trim().equals("") || tfCusPhone.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(frame,"Vui lòng điền đầy đủ thông tin khách hàng");
				}
				else if(tfCusID.getText().length() > 20) {
					JOptionPane.showMessageDialog(frame, "CCCD/CMND không quá 20 kí tự");
				}
				else {
				    //kiem tra va dien thong tin khach hang neu khach hang da ton tai 
					src.DTO.Customer info = new src.DTO.Customer();
					info.setCccd(tfCusID.getText());
					info.setName(tfCusName.getText());
					info.setPhone(tfCusPhone.getText());
					
					String result = cusBLL.addNewCustomer(info);
					System.out.println(result);
					
					JOptionPane.showMessageDialog(frame, result);	
					
					if(result.equals("success")) {
						modelCus.addRow(new Object[] {
								
								count++ + "*" , info.getCccd(), info.getName(), info.getPhone()
						});
					}
				}
				
			}
		});
		
		//Sua thong tin khach hang
		btnCusEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = tableCus.getSelectedRow();
				if(i >= 0) {
					src.DTO.Customer cus = new src.DTO.Customer();
					cus.setCccd(tfCusID.getText());
					cus.setName(tfCusName.getText());
					cus.setPhone(tfCusPhone.getText());
					
					
					
					int ques = JOptionPane.showConfirmDialog(frame, "Xác nhận sửa thông tin khách hàng");
					if(ques == JOptionPane.YES_OPTION) {
						String result = cusBLL.editCustomer(cus);
						
						JOptionPane.showMessageDialog(frame, result);
						if(result.equals("success")) {
							modelCus.setValueAt(cus.getCccd(), i, 1);
							modelCus.setValueAt(cus.getName(), i, 2);
							modelCus.setValueAt(cus.getPhone(), i, 3);
							
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(frame, "Vui lòng chọn dòng dữ liệu để cập nhật không thì khỏi làm");
					
				}
				
			}
		});
		//Xoa thong tin khach hang
		btnCusRemove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = tableCus.getSelectedRow();
				if(i >= 0) {
					int ques = JOptionPane.showConfirmDialog(frame, "Xác nhận xóa thông tin khách hàng");
					if(ques == JOptionPane.YES_OPTION) {
						String result = cusBLL.removeCustomer(modelCus.getValueAt(i, 1).toString());
						System.out.println(modelCus.getValueAt(i, 1).toString());
						JOptionPane.showMessageDialog(frame, result);
						if(result.equals("success")) {
							modelCus.removeRow(i);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(frame, "Vui lòng chọn dòng dữ liệu để xóa không thì khỏi xóa");
				}
				
			}
		});
		//Click table 
		tableCus.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int i = tableCus.getSelectedRow();
				if(i >= 0) {
					tfCusID.setEditable(false);
					
					tfCusID.setText(modelCus.getValueAt(i, 1).toString());
					tfCusName.setText(modelCus.getValueAt(i, 2).toString());
					tfCusPhone.setText(modelCus.getValueAt(i, 3).toString());
					
				}
			}
		});
		//Reset thong tin khach hang 
		btnCusReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		    tfCusID.setEditable(true);
		    
			tfCusID.setText("");
			tfCusName.setText("");
			tfCusPhone.setText("");
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 853, 432);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(frame);
		
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
		modelCus.addColumn("CCCD");
		modelCus.addColumn("Tên khách hàng");
		modelCus.addColumn("Số điện thoại");
		
		
		
		
		JScrollPane sc = new JScrollPane(tableCus);
		sc.setBounds(385, 74, 437, 266);
		frame.getContentPane().add(sc);
		
		modelCus.addRow(new Object[] {
				"###", "DWFEF8", "Bùi Thanh Trung", "0703338458", "317 Nguyễn Văn luông P12 Q6"
		});
		
		
		
		btnCusAdd = new JButton("Thêm");
		btnCusAdd.setBounds(70, 267, 89, 30);
		frame.getContentPane().add(btnCusAdd);
		
		btnCusEdit = new JButton("Sửa ");
		btnCusEdit.setBounds(172, 267, 89, 30);
		frame.getContentPane().add(btnCusEdit);
		
		btnCusRemove = new JButton("Xóa");
		btnCusRemove.setBounds(70, 310, 89, 30);
		frame.getContentPane().add(btnCusRemove);
		
		btnCusReset = new JButton("Reset");
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
