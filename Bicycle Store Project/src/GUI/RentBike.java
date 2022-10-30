package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class RentBike {

	public JFrame frmThu;
	private JTextField nameTxt;
	private JTable table;
	private JTextField phoneTxt;
	private JButton rentBtn, exitBtn;
	private DefaultTableModel tableModel = new DefaultTableModel();
	private JTextField cccdTxt;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Rent window = new Rent();
//					window.frmThu.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//					
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public RentBike() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmThu = new JFrame();
		frmThu.setTitle("THUÊ");
		frmThu.setBounds(100, 100, 929, 496);
		frmThu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmThu.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thuê Xe");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(43, 0, 686, 46);
		frmThu.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Họ tên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 139, 108, 28);
		frmThu.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 202, 108, 28);
		frmThu.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Cửa hàng");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(10, 265, 108, 28);
		frmThu.getContentPane().add(lblNewLabel_1_2_1);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(128, 139, 150, 28);
		frmThu.getContentPane().add(nameTxt);
		nameTxt.setColumns(10);
		
		JComboBox storeCb = new JComboBox();
		storeCb.setBounds(128, 267, 150, 28);
		frmThu.getContentPane().add(storeCb);
		
		
		table = new JTable();
		table.setRowHeight(30);
		frmThu.getContentPane().add(table);
		table.setModel(tableModel);
		tableModel.addColumn("STT");
		tableModel.addColumn("Mã Xe");
		tableModel.addColumn("Tên Xe");
		tableModel.addColumn("Loại Xe");
		tableModel.addColumn("Giá thuê");
		tableModel.addColumn("Tình Trạng");
	
		
		JScrollPane sp1 = new JScrollPane(table);
		sp1.setBounds(299, 81, 606, 328);
	    frmThu.getContentPane().add(sp1);
	    
	    tableModel.addRow(new Object[] {
	    		"###", "FE8FH", "Xe Đạp 1 bánh", "Racingboy", "500.19", "Chưa thuê"
	    });
	    
	    tableModel.addRow(new Object[] {
	    		"###", "FE8FH", "Xe Đạp ghế tình yêu", "Nhún cực mạnh", "999.99", "Đã thuê"
	    });
	    
		
		exitBtn = new JButton("Thoát");
		exitBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		exitBtn.setBounds(826, 413, 79, 35);
		frmThu.getContentPane().add(exitBtn);
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UserHomePage home = new UserHomePage();
				home.frame.setVisible(true);
				
				frmThu.setVisible(false);
				
			}
		});
		
		rentBtn = new JButton("Thuê");
		rentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rentBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		rentBtn.setBounds(681, 413, 135, 35);
		frmThu.getContentPane().add(rentBtn);
		
		phoneTxt = new JTextField();
		phoneTxt.setColumns(10);
		phoneTxt.setBounds(128, 204, 150, 28);
		frmThu.getContentPane().add(phoneTxt);
		
		JLabel lblNewLabel_2 = new JLabel("Các loại xe");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(299, 57, 108, 17);
		frmThu.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("CCCD/CMND");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 79, 108, 28);
		frmThu.getContentPane().add(lblNewLabel_1_2);
		
		cccdTxt = new JTextField();
		cccdTxt.setBounds(128, 81, 150, 28);
		frmThu.getContentPane().add(cccdTxt);
		cccdTxt.setColumns(10);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Ngày thuê");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1.setBounds(10, 324, 108, 28);
		frmThu.getContentPane().add(lblNewLabel_1_2_1_1);
		
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Ngày trả");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1_1.setBounds(10, 381, 108, 28);
		frmThu.getContentPane().add(lblNewLabel_1_2_1_1_1);
		
		
		
		eventRent();
	}

	private void eventRent() {
		rentBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Invoice inv = new Invoice();
				inv.frmHoadon.setVisible(true);
				
			}
		});
		
	}
}
