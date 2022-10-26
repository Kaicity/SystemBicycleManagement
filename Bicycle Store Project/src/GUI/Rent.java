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

public class Rent {

	public JFrame frmThu;
	private JTextField nameTxt;
	private JTable table;
	private JTextField phoneTxt;
	private JTextField addressTxt;
	private JButton rentBtn, exitBtn;
	private DefaultTableModel tableModel = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rent window = new Rent();
					window.frmThu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Rent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmThu = new JFrame();
		frmThu.setTitle("THUÊ");
		frmThu.setBounds(100, 100, 815, 387);
		frmThu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmThu.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thuê Xe");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 686, 45);
		frmThu.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Họ tên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 81, 108, 28);
		frmThu.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 145, 108, 28);
		frmThu.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Địa chỉ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 211, 108, 28);
		frmThu.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Cửa hàng");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(10, 265, 108, 28);
		frmThu.getContentPane().add(lblNewLabel_1_2_1);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(128, 81, 150, 28);
		frmThu.getContentPane().add(nameTxt);
		nameTxt.setColumns(10);
		
		JComboBox storeCb = new JComboBox();
		storeCb.setBounds(128, 267, 150, 28);
		frmThu.getContentPane().add(storeCb);
		
		
		table = new JTable();
		table.setBounds(317, 102, 276, 127);
		frmThu.getContentPane().add(table);
		table.setModel(tableModel);
		tableModel.addColumn("STT");
		tableModel.addColumn("Mã Xe");
		tableModel.addColumn("Tên Xe");
		tableModel.addColumn("Loại Xe");
		tableModel.addColumn("Giá");
		tableModel.addColumn("Tình Trạng");
		
		JScrollPane sp1 = new JScrollPane(table);
		sp1.setBounds(317, 81, 474, 212);
	    frmThu.getContentPane().add(sp1);
		
		exitBtn = new JButton("Thoát");
		exitBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		exitBtn.setBounds(714, 304, 77, 35);
		frmThu.getContentPane().add(exitBtn);
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				HomePage home = new HomePage();
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
		rentBtn.setBounds(596, 304, 108, 35);
		frmThu.getContentPane().add(rentBtn);
		
		phoneTxt = new JTextField();
		phoneTxt.setColumns(10);
		phoneTxt.setBounds(128, 147, 150, 28);
		frmThu.getContentPane().add(phoneTxt);
		
		addressTxt = new JTextField();
		addressTxt.setColumns(10);
		addressTxt.setBounds(128, 213, 150, 28);
		frmThu.getContentPane().add(addressTxt);
		
		JLabel lblNewLabel_2 = new JLabel("Các loại xe");
		lblNewLabel_2.setBounds(317, 67, 108, 14);
		frmThu.getContentPane().add(lblNewLabel_2);
		
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
