package src.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.DefaultComboBoxModel;


public class RentManage {

	public JFrame frmThu;
	private JTextField nameTxt;
	private JTable table;
	private JButton rentBtn, exitBtn;

	
	
	
	private DefaultTableModel tableModel = new DefaultTableModel() {
		@Override
	    public boolean isCellEditable(int row, int column) {
	       //all cells false
	       return false;
	    }
	};
	private JTextField cccdTxt;
	private JTextField textField;
	
	
	

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
	public RentManage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {
		frmThu = new JFrame();
		frmThu.setTitle("THUÊ");
		frmThu.setBounds(100, 100, 929, 516);
		frmThu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmThu.getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Quản Lý Thuê Xê");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 895, 46);
		frmThu.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CCCD/CMND");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 139, 108, 28);
		frmThu.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Trạng Thái");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 366, 108, 28);
		frmThu.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Mã Cửa Hàng");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(10, 194, 108, 28);
		frmThu.getContentPane().add(lblNewLabel_1_2_1);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(128, 139, 150, 28);
		frmThu.getContentPane().add(nameTxt);
		nameTxt.setColumns(10);
		
		String listCuaHang[] = {"cua hang 1", "cua hang 2", "cua hang 3"};
		
		
		table = new JTable();
		table.setRowHeight(30);
		frmThu.getContentPane().add(table);
		table.setModel(tableModel);
		tableModel.addColumn("STT");
		tableModel.addColumn("Mã Hóa Đơn");
		tableModel.addColumn("CCCD");
		tableModel.addColumn("Danh Sách Xe");
		tableModel.addColumn("Giá Thành");
		tableModel.addColumn("Tình Trạng");
		
		
		
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		JScrollPane sp1 = new JScrollPane(table);
		sp1.setBounds(299, 81, 606, 327);
	    frmThu.getContentPane().add(sp1);

	    tableModel.addRow(new Object[] {
	    		"1", "FE8FH", "081", "Danh Sách Xe" , "500.19", "Chưa thuê"
	    });
		
		exitBtn = new JButton("Thoát");
		exitBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		exitBtn.setBounds(826, 431, 79, 35);
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
		rentBtn.setBounds(681, 431, 135, 35);
		frmThu.getContentPane().add(rentBtn);
		
		JLabel lblNewLabel_2 = new JLabel("Danh sách thuê");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(299, 57, 108, 17);
		frmThu.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mã Hóa Đơn");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 79, 108, 28);
		frmThu.getContentPane().add(lblNewLabel_1_2);
		
		cccdTxt = new JTextField();
		cccdTxt.setBounds(128, 81, 150, 28);
		frmThu.getContentPane().add(cccdTxt);
		cccdTxt.setColumns(10);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Ngày thuê");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1.setBounds(10, 249, 108, 28);
		frmThu.getContentPane().add(lblNewLabel_1_2_1_1);
		
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Ngày trả");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1_1.setBounds(10, 306, 108, 28);
		frmThu.getContentPane().add(lblNewLabel_1_2_1_1_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(128, 249, 150, 28);
		frmThu.getContentPane().add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(128, 306, 150, 28);
		frmThu.getContentPane().add(dateChooser_1);
		
		JComboBox statusCb = new JComboBox(new Object[]{});
		statusCb.setModel(new DefaultComboBoxModel(new String[] {"Đang Thuê", "Chưa Thuê", "Đặt Trước"}));
		statusCb.setBounds(128, 368, 150, 28);
		frmThu.getContentPane().add(statusCb);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(128, 196, 150, 28);
		frmThu.getContentPane().add(textField);
		
	}
	

};


