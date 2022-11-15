package src.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import src.DTO.Rent;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DetailRentBike {

	public JFrame frmHoadon;
	
	DefaultTableModel dTable = new DefaultTableModel();
	JTextField tfhoadonid , tfDeposit, bikeId;
	JLabel tfCustomerName, tfPhoneCus, tfStoreName, bikeName, bikePriceh, rentDate, returnDate;
	Rent rentPay = new Rent();
	private JTextField totalpayment;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Invoice window = new Invoice();
//					window.frmHoadon.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public DetailRentBike() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHoadon = new JFrame();
		frmHoadon.setTitle("HoaDon");
		frmHoadon.setBounds(100, 100, 601, 453);
		frmHoadon.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmHoadon.getContentPane().setLayout(null);
		frmHoadon.setLocationRelativeTo(frmHoadon);
		
		JLabel lblNewLabel = new JLabel("Phiếu thuê xe");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(150, 0, 299, 39);
		frmHoadon.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 101, 103, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Số Điện Thoại :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(10, 143, 103, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Cửa Hàng :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(10, 185, 103, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_3);
		dTable.addColumn("Mã Xe");
		dTable.addColumn("Tên Xe");
		dTable.addColumn("Giá thuê");
		dTable.addColumn("Ngày thuê");
		dTable.addColumn("Ngày trả");
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Thành Tiền");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3_1.setBounds(206, 298, 91, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_3_1);
	
		
		JButton btnNewButton = new JButton("Đặt xe");
		btnNewButton.setBounds(162, 358, 232, 39);
		frmHoadon.getContentPane().add(btnNewButton);
		
		JButton btnHy = new JButton("Hủy");
		btnHy.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(frmHoadon, "Xác nhận hủy giao dịch",
						"Thông báo",JOptionPane.YES_NO_OPTION ,JOptionPane.QUESTION_MESSAGE);
				if(result == JOptionPane.YES_OPTION) {
					frmHoadon.setVisible(false);
				}
				
			}
		});
		btnHy.setBounds(404, 358, 168, 39);
		frmHoadon.getContentPane().add(btnHy);
		
	    tfCustomerName = new JLabel("");
		tfCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfCustomerName.setBounds(123, 101, 174, 31);
		frmHoadon.getContentPane().add(tfCustomerName);
		
		tfPhoneCus = new JLabel();
		tfPhoneCus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfPhoneCus.setBounds(123, 143, 200, 31);
		frmHoadon.getContentPane().add(tfPhoneCus);
		
		tfStoreName = new JLabel();
		tfStoreName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfStoreName.setBounds(123, 185, 156, 31);
		
		frmHoadon.getContentPane().add(tfStoreName);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Mã phiếu thuê");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_2.setBounds(10, 61, 103, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_3_2);
		
		tfhoadonid = new JTextField();
		tfhoadonid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfhoadonid.setText("WDFEYF87Y");
		tfhoadonid.setEditable(false);
		tfhoadonid.setBounds(123, 65, 133, 24);
		frmHoadon.getContentPane().add(tfhoadonid);
		tfhoadonid.setColumns(10);
		
		JButton btnInPhiu = new JButton("In phiếu");
		btnInPhiu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frmHoadon, "Chưa kết nối máy in","",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnInPhiu.setBounds(10, 358, 142, 39);
		frmHoadon.getContentPane().add(btnInPhiu);
		
		JLabel lblNewLabel_1_3_3 = new JLabel("Đặt cọc:");
		lblNewLabel_1_3_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_3.setBounds(10, 227, 103, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_3_3);
		
		tfDeposit = new JTextField();
		tfDeposit.setText(String.valueOf(500.0));
		tfDeposit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDeposit.setEditable(false);
		tfDeposit.setColumns(10);
		tfDeposit.setBounds(123, 231, 133, 24);
		frmHoadon.getContentPane().add(tfDeposit);
		
		JLabel lblNewLabel_1_3_3_1 = new JLabel("VND");
		lblNewLabel_1_3_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_3_1.setBounds(266, 227, 59, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_3_3_1);
		
		JLabel lblNewLabel_1_3_2_1 = new JLabel("Mã xe :");
		lblNewLabel_1_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_2_1.setBounds(329, 61, 76, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_3_2_1);
		
		bikeName = new JLabel("");
		bikeName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bikeName.setBounds(452, 101, 103, 31);
		frmHoadon.getContentPane().add(bikeName);
		
		JLabel lblNewLabel_1_3_2_3 = new JLabel("Giá thuê / H : ");
		lblNewLabel_1_3_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_2_3.setBounds(329, 143, 103, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_3_2_3);
		
		JLabel lblNewLabel_1_3_2_4 = new JLabel("Ngày thuê");
		lblNewLabel_1_3_2_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_2_4.setBounds(326, 185, 103, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_3_2_4);
		
		JLabel lblNewLabel_1_3_2_5 = new JLabel("Ngày trả");
		lblNewLabel_1_3_2_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_2_5.setBounds(326, 227, 103, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_3_2_5);
		
		bikeId = new JTextField();
		bikeId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bikeId.setEditable(false);
		bikeId.setColumns(10);
		bikeId.setBounds(452, 65, 120, 24);
		frmHoadon.getContentPane().add(bikeId);
		
		JLabel lblNewLabel_1_3_2_2_1 = new JLabel("Tên xe :");
		lblNewLabel_1_3_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_2_2_1.setBounds(329, 101, 76, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_3_2_2_1);
		
		bikePriceh = new JLabel();
		bikePriceh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bikePriceh.setBounds(450, 143, 103, 31);
		frmHoadon.getContentPane().add(bikePriceh);
		
		rentDate = new JLabel();
		rentDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rentDate.setBounds(450, 185, 103, 31);
		frmHoadon.getContentPane().add(rentDate);
		
		returnDate = new JLabel();
		returnDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		returnDate.setBounds(450, 227, 103, 31);
		frmHoadon.getContentPane().add(returnDate);
		
		totalpayment = new JTextField();
		totalpayment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		totalpayment.setEditable(false);
		totalpayment.setColumns(10);
		totalpayment.setBounds(307, 302, 192, 24);
		frmHoadon.getContentPane().add(totalpayment);
		
		totalpayment.setText(String.valueOf(rentPay.rentPayment(Integer.parseInt(bikePriceh.getText()), Integer.parseInt(tfDeposit.getText())
				, Integer.parseInt(rentDate.getText()), Integer.parseInt(rentDate.getText()))));
		
		
		JLabel lblNewLabel_1_3_3_1_1 = new JLabel("VND");
		lblNewLabel_1_3_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_3_1_1.setBounds(509, 298, 59, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_3_3_1_1);

	}
}
