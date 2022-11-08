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
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Invoice {

	public JFrame frmHoadon;
	private JTable table;
	
	private DefaultTableModel dTable = new DefaultTableModel();
	private JTextField txtFuwefwg;

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
	public Invoice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHoadon = new JFrame();
		frmHoadon.setTitle("HoaDon");
		frmHoadon.setBounds(100, 100, 453, 551);
		frmHoadon.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmHoadon.getContentPane().setLayout(null);
		frmHoadon.setLocationRelativeTo(frmHoadon);
		
		JLabel lblNewLabel = new JLabel("Phiếu thuê xe");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(73, 0, 299, 39);
		frmHoadon.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 101, 103, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Địa Chỉ :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 185, 103, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Số Điện Thoại :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(10, 143, 103, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Cửa Hàng :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(10, 227, 103, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_3);
		
		table = new JTable();
		table.setModel(dTable);
		dTable.addColumn("Mã Xe");
		dTable.addColumn("Tên Xe");
		dTable.addColumn("Giá thuê");
		dTable.addColumn("Tiền cọc");
		dTable.addColumn("Ngày thuê");
		dTable.addColumn("Ngày trả");
		table.setBounds(10, 229, 299, 129);
		frmHoadon.getContentPane().add(table);
		
		
		
		dTable.insertRow(0, new Object[] {"PKL001","PKL","100.000","200.000"});
		
		JScrollPane sp1 = new JScrollPane(table);
		sp1.setBounds(10, 282, 419, 129);
	    frmHoadon.getContentPane().add(sp1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Thành Tiền");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3_1.setBounds(165, 422, 91, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_3_1);
	
		
		JButton btnNewButton = new JButton("Đặt");
		btnNewButton.setBounds(165, 464, 132, 39);
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
		btnHy.setBounds(307, 464, 122, 39);
		frmHoadon.getContentPane().add(btnHy);
		
		JLabel lblNewLabel_2 = new JLabel("100.000.000 VND");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(289, 422, 140, 31);
		frmHoadon.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_4 = new JLabel("Thông Nguyễn");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(123, 101, 174, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("08752226351");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4_1.setBounds(123, 143, 174, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("Cửa hàng xe đạp 1");
		lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4_2.setBounds(123, 227, 177, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_4_2);
		
		JLabel lblNewLabel_1_4_3 = new JLabel("213 Nguyễn Đình Chiểu");
		lblNewLabel_1_4_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4_3.setBounds(123, 185, 177, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_4_3);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Mã phiếu thuê");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_2.setBounds(10, 61, 103, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_3_2);
		
		txtFuwefwg = new JTextField();
		txtFuwefwg.setText("FUWEFWG8");
		txtFuwefwg.setEditable(false);
		txtFuwefwg.setBounds(123, 68, 132, 20);
		frmHoadon.getContentPane().add(txtFuwefwg);
		txtFuwefwg.setColumns(10);
	}
}
