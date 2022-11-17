package src.GUI;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import src.DTO.Bicycle;
import src.DTO.Customer;
import src.DTO.Rent;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

import src.BLL.RentBLL;
import src.BLL.BicycleBLL;
import src.BLL.CustomerBLL;

public class DetailRentBike {

	public JFrame frmHoadon;
	private JButton btnOrderBike;
	
	JTextField tfhoadonid , tfDeposit, bikeId;
	JLabel tfCustomerName, tfStoreId, bikeName, bikePriceh, rentDay, tfCccd , returnDay, tfPhoneCus, howDays;
	private JTextField totalpayment;
	
	
	RentBLL rentBll = new RentBLL();
	CustomerBLL cusBll = new CustomerBLL();
	BicycleBLL bikeBLL = new BicycleBLL();

	public DetailRentBike() {
		initialize();
		
	}
	
	//RANDOM CHUOI HOA DON TU DONG CHO KHACH HANG THUE XE 
	private String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHoadon = new JFrame();
		frmHoadon.setResizable(false);
		frmHoadon.setVisible(false);
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
		lblNewLabel_1_2.setBounds(10, 185, 103, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Cửa Hàng :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(10, 222, 103, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_3);
		
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Thành Tiền");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3_1.setBounds(206, 298, 91, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_3_1);
	
		
	    btnOrderBike = new JButton("Đặt xe");
		btnOrderBike.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String tempDate1 = rentDay.getText();
				String tempDate2 = returnDay.getText();
				
				System.out.println(tempDate1);
				
				 // Định dạng thời gian
		        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		        Calendar c1 = Calendar.getInstance();
		        Calendar c2 = Calendar.getInstance();

		        // Định nghĩa 2 mốc thời gian ban đầu
		        Date date1 = Date.valueOf(tempDate1);
		        Date date2 = Date.valueOf(tempDate2);

		        c1.setTime(date1);
		        c2.setTime(date2);

		        // Công thức tính số ngày giữa 2 mốc thời gian:
		        long noDay = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);

		        System.out.print("Số ngày giữa " + dateFormat.format(c1.getTime())
		                + " và " + dateFormat.format(c2.getTime()) + ": ");

		        System.out.println(noDay);
		        
		        howDays.setText(String.valueOf(noDay));
		        
		        
		        //---------------Tinh gia tien thue xe --------------------------------
				Rent rentPay = new Rent();
				rentPay.setId(tfhoadonid.getText());
				rentPay.setDeposit(Integer.parseInt(tfDeposit.getText()));
				rentPay.setRentDate(tempDate1);
				rentPay.setReturnDate(tempDate2);
				rentPay.setStore(tfStoreId.getText());
				rentPay.setBicycle(bikeId.getText());
				rentPay.setCustomer(tfCccd.getText());
				
				
				String result = "";
				
				totalpayment.setText(String.valueOf(rentPay.rentPayment(Integer.parseInt(bikePriceh.getText())
				, Integer.parseInt(howDays.getText()))));
				
				//--------------LAY THONG TIN KHACH HANG THUE XE TAO 1 HOA DON MOI----------------------------------
			
				
				
			
			}
		});
		btnOrderBike.setBounds(162, 358, 232, 39);
		frmHoadon.getContentPane().add(btnOrderBike);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(frmHoadon, "Xác nhận hủy giao dịch",
						"Thông báo",JOptionPane.YES_NO_OPTION ,JOptionPane.QUESTION_MESSAGE);
				if(result == JOptionPane.YES_OPTION) {
					frmHoadon.setVisible(false);
					RentBike back = new RentBike();
					back.frmThu.setVisible(true);
				}
				
			}
		});
		btnHuy.setBounds(404, 358, 168, 39);
		frmHoadon.getContentPane().add(btnHuy);
		
	    tfCustomerName = new JLabel("");
		tfCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfCustomerName.setBounds(123, 101, 174, 31);
		frmHoadon.getContentPane().add(tfCustomerName);
		
		tfStoreId = new JLabel();
		tfStoreId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfStoreId.setBounds(123, 227, 156, 31);
		
		frmHoadon.getContentPane().add(tfStoreId);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Mã phiếu thuê");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_2.setBounds(10, 61, 103, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_3_2);
		
		tfhoadonid = new JTextField();
		tfhoadonid.setFont(new Font("Tahoma", Font.PLAIN, 14));	
		tfhoadonid.setEditable(false);
		tfhoadonid.setBounds(123, 65, 133, 24);
		frmHoadon.getContentPane().add(tfhoadonid);
		tfhoadonid.setColumns(10);
		tfhoadonid.setText(getSaltString());
		
		JButton btnInPhiu = new JButton("Thanh toán");
		btnInPhiu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(rentDay.getText());
				JOptionPane.showMessageDialog(frmHoadon, "Thanh toán thành công","",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		
		
		btnInPhiu.setBounds(10, 358, 142, 39);
		frmHoadon.getContentPane().add(btnInPhiu);
		
		JLabel lblNewLabel_1_3_3 = new JLabel("Đặt cọc:");
		lblNewLabel_1_3_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_3.setBounds(206, 260, 103, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_3_3);
		
		tfDeposit = new JTextField();
		tfDeposit.setText("500000");
		tfDeposit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDeposit.setEditable(false);
		tfDeposit.setColumns(10);
		tfDeposit.setBounds(307, 264, 192, 24);
		frmHoadon.getContentPane().add(tfDeposit);
		
		JLabel lblNewLabel_1_3_3_1 = new JLabel("VND");
		lblNewLabel_1_3_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_3_1.setBounds(509, 260, 40, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_3_3_1);
		
		JLabel lblNewLabel_1_3_2_1 = new JLabel("Mã xe :");
		lblNewLabel_1_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_2_1.setBounds(326, 61, 76, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_3_2_1);
		
		bikeName = new JLabel("");
		bikeName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bikeName.setBounds(452, 101, 120, 31);
		frmHoadon.getContentPane().add(bikeName);
		
		JLabel lblNewLabel_1_3_2_3 = new JLabel("Giá thuê / H : ");
		lblNewLabel_1_3_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_2_3.setBounds(326, 143, 103, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_3_2_3);
		
		JLabel lblNewLabel_1_3_2_4 = new JLabel("Ngày thuê :");
		lblNewLabel_1_3_2_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_2_4.setBounds(326, 185, 103, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_3_2_4);
		
		bikeId = new JTextField();
		bikeId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bikeId.setEditable(false);
		bikeId.setColumns(10);
		bikeId.setBounds(452, 65, 120, 24);
		frmHoadon.getContentPane().add(bikeId);
		
		JLabel lblNewLabel_1_3_2_2_1 = new JLabel("Tên xe :");
		lblNewLabel_1_3_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_2_2_1.setBounds(326, 101, 76, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_3_2_2_1);
		
		bikePriceh = new JLabel();
		bikePriceh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bikePriceh.setBounds(450, 143, 122, 31);
		frmHoadon.getContentPane().add(bikePriceh);
		
		rentDay = new JLabel();
		rentDay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rentDay.setBounds(452, 185, 120, 31);
		frmHoadon.getContentPane().add(rentDay);
		
		totalpayment = new JTextField();
		totalpayment.setForeground(Color.RED);
		totalpayment.setFont(new Font("Tahoma", Font.BOLD, 14));
		totalpayment.setEditable(false);
		totalpayment.setColumns(10);
		totalpayment.setBounds(307, 302, 192, 24);
		frmHoadon.getContentPane().add(totalpayment);
		

		
		JLabel lblNewLabel_1_3_3_1_1 = new JLabel("VND");
		lblNewLabel_1_3_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_3_1_1.setBounds(509, 298, 59, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_3_3_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("CCCD/CMND : ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 143, 103, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_1);
		
		tfCccd = new JLabel("");
		tfCccd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfCccd.setBounds(123, 143, 174, 31);
		frmHoadon.getContentPane().add(tfCccd);
		
		JLabel lblNewLabel_1_3_2_4_1 = new JLabel("Ngày trả:");
		lblNewLabel_1_3_2_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_2_4_1.setBounds(326, 222, 103, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_3_2_4_1);
		
		returnDay = new JLabel();
		returnDay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		returnDay.setBounds(452, 218, 120, 31);
		frmHoadon.getContentPane().add(returnDay);
		
		tfPhoneCus = new JLabel("");
		tfPhoneCus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfPhoneCus.setBounds(123, 185, 103, 31);
		frmHoadon.getContentPane().add(tfPhoneCus);
		
		JLabel lblNewLabel_1_3_3_2 = new JLabel("Số ngày thuê : ");
		lblNewLabel_1_3_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_3_2.setBounds(10, 260, 103, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_3_3_2);
		
		howDays = new JLabel();
		howDays.setForeground(Color.RED);
		howDays.setFont(new Font("Tahoma", Font.BOLD, 15));
		howDays.setBounds(123, 255, 76, 31);
		frmHoadon.getContentPane().add(howDays);

	}
}
