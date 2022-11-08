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


public class ReturnBike {

	public JFrame frmThu;
	private JTable table;
	private JTextField tfStoreID;
	private JButton returnBike, exitBtn;
	private DefaultTableModel tableModel = new DefaultTableModel();
	private JTextField tfRentID;
	private JTextField tfDateRent;
	private JTextField tfDateReturn;

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
	public ReturnBike() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmThu = new JFrame();
		frmThu.setTitle("THUÊ");
		frmThu.setBounds(100, 100, 929, 458);
		frmThu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmThu.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Trả xe");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 895, 35);
		frmThu.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã cửa hàng");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 138, 108, 28);
		frmThu.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Trả Cửa hàng");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(10, 199, 108, 28);
		frmThu.getContentPane().add(lblNewLabel_1_2_1);
		
		JComboBox tfNameStore = new JComboBox();
		tfNameStore.setBounds(128, 201, 150, 28);
		frmThu.getContentPane().add(tfNameStore);
		
		
		table = new JTable();
		table.setRowHeight(30);
		frmThu.getContentPane().add(table);
		table.setModel(tableModel);
		tableModel.addColumn("Mã phiếu thuê");
		tableModel.addColumn("Tên cửa hàng");
		tableModel.addColumn("Ngày thuê");
		tableModel.addColumn("Ngày trả");
	
		
		JScrollPane sp1 = new JScrollPane(table);
		sp1.setBounds(299, 81, 606, 284);
	    frmThu.getContentPane().add(sp1);
	    
	    tableModel.addRow(new Object[] {
	    		"FE8FH", "Cửa hàng 1", "", ""
	    });
	    
	    
		
		exitBtn = new JButton("Thoát");
		exitBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		exitBtn.setBounds(826, 376, 79, 35);
		frmThu.getContentPane().add(exitBtn);
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				HomePage home = new HomePage();
				home.frame.setVisible(true);
				
				frmThu.setVisible(false);
				
			}
		});
		
		returnBike = new JButton("Trả xe");
		returnBike.setFont(new Font("Tahoma", Font.BOLD, 14));
		returnBike.setBounds(685, 376, 135, 35);
		frmThu.getContentPane().add(returnBike);
		
		tfStoreID = new JTextField();
		tfStoreID.setEditable(false);
		tfStoreID.setColumns(10);
		tfStoreID.setBounds(128, 140, 150, 28);
		frmThu.getContentPane().add(tfStoreID);
		
		JLabel lblNewLabel_2 = new JLabel("Danh sách phiếu thuê");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(299, 57, 168, 17);
		frmThu.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mã phiếu thuê");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 79, 108, 28);
		frmThu.getContentPane().add(lblNewLabel_1_2);
		
		tfRentID = new JTextField();
		tfRentID.setBounds(128, 81, 150, 28);
		frmThu.getContentPane().add(tfRentID);
		tfRentID.setColumns(10);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Ngày thuê");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1.setBounds(10, 260, 108, 28);
		frmThu.getContentPane().add(lblNewLabel_1_2_1_1);
		
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Ngày trả");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1_1.setBounds(10, 326, 108, 28);
		frmThu.getContentPane().add(lblNewLabel_1_2_1_1_1);
		
		tfDateRent = new JTextField();
		tfDateRent.setEditable(false);
		tfDateRent.setBounds(128, 263, 150, 26);
		frmThu.getContentPane().add(tfDateRent);
		tfDateRent.setColumns(10);
		
		tfDateReturn = new JTextField();
		tfDateReturn.setEditable(false);
		tfDateReturn.setColumns(10);
		tfDateReturn.setBounds(128, 329, 150, 26);
		frmThu.getContentPane().add(tfDateReturn);
		
		
		
		eventRent();
	}

	private void eventRent() {
		returnBike.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FinishedReturn finish = new FinishedReturn();
				finish.frmHoadon.setVisible(true);
				
				
			}
		});
		
	}
}
