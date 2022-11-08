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
import javax.swing.JPanel;

public class FinishedReturn {

	public JFrame frmHoadon;
	private JTable table;
	
	private DefaultTableModel dTable = new DefaultTableModel();
	private JTextField tfBikeID;
	private JTextField txtVP;

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
	public FinishedReturn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHoadon = new JFrame();
		frmHoadon.setTitle("HoaDon");
		frmHoadon.setBounds(100, 100, 453, 549);
		frmHoadon.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmHoadon.getContentPane().setLayout(null);
		frmHoadon.setLocationRelativeTo(frmHoadon);
		
		JLabel lblNewLabel = new JLabel("Thủ tục trả xe");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(73, 11, 299, 39);
		frmHoadon.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 61, 103, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Số Điện Thoại :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(10, 103, 103, 31);
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
		dTable.addColumn("Vi phạm");
		table.setBounds(10, 229, 299, 129);
		frmHoadon.getContentPane().add(table);
		
		
		
		dTable.insertRow(0, new Object[] {"PKL001","PKL","100.000","200.000","999.000"});
		
		JScrollPane sp1 = new JScrollPane(table);
		sp1.setBounds(10, 269, 419, 140);
	    frmHoadon.getContentPane().add(sp1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Chi phí trả xe");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3_1.setBounds(165, 420, 114, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_3_1);
	
		
		JButton btnReturnLate = new JButton("Trả");
		btnReturnLate.setBounds(165, 462, 132, 39);
		frmHoadon.getContentPane().add(btnReturnLate);
		
		JButton btnCancel = new JButton("Hủy");
		btnCancel.setBounds(307, 462, 122, 39);
		frmHoadon.getContentPane().add(btnCancel);
		
		JLabel lblNewLabel_2 = new JLabel("50.000 VND");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(307, 420, 122, 31);
		frmHoadon.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_4 = new JLabel("Thông Nguyễn");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(120, 61, 177, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("08752226351");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4_1.setBounds(123, 103, 177, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("Cửa hàng xe đạp 1");
		lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4_2.setBounds(120, 227, 177, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_4_2);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Mã xe :");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_2.setBounds(10, 145, 103, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_3_2);
		
		tfBikeID = new JTextField();
		tfBikeID.setEditable(false);
		tfBikeID.setBounds(120, 145, 150, 31);
		frmHoadon.getContentPane().add(tfBikeID);
		tfBikeID.setColumns(10);
		
		JLabel lblNewLabel_1_3_2_1 = new JLabel("Vi phạm : ");
		lblNewLabel_1_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_2_1.setBounds(10, 187, 103, 31);
		frmHoadon.getContentPane().add(lblNewLabel_1_3_2_1);
		
		txtVP = new JTextField();
		txtVP.setText("0 VNĐ");
		txtVP.setEditable(false);
		txtVP.setBounds(120, 187, 150, 31);
		frmHoadon.getContentPane().add(txtVP);
		txtVP.setColumns(10);
	}
}
