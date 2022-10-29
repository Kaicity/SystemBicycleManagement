package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Store {

	public JFrame frame;
	private JTextField tfSroreID;
	private JTextField tfStoreName;
	private JTextField tfStorePhone;
	private JTable table;
	private DefaultTableModel modelStore = new DefaultTableModel();
	private JTextField seachStore;
	
	final String[] typeBicycle = {"Xe phổ thông", "Xe đạp tình yêu", "Xe đạp leo núi",
			"Xe đạp địa hình dốc", "Xe đạp điện", "Xe đạp Single"
	};
	
	final String[] status = {"Chưa thuê", "Đã thuê"};
	private JTextField tfStorefax;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Bicycle window = new Bicycle();
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
	public Store() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 980, 490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cửa hàng ID");
		lblNewLabel.setBounds(82, 107, 80, 17);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên của hàng");
		lblNewLabel_1.setBounds(82, 151, 80, 17);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Địa chỉ");
		lblNewLabel_2.setBounds(82, 200, 80, 18);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Số fax");
		lblNewLabel_3.setBounds(82, 263, 80, 18);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("SĐT");
		lblNewLabel_4.setBounds(82, 304, 80, 17);
		frame.getContentPane().add(lblNewLabel_4);
		
		tfSroreID = new JTextField();
		tfSroreID.setEditable(false);
		tfSroreID.setBounds(163, 104, 202, 20);
		frame.getContentPane().add(tfSroreID);
		tfSroreID.setColumns(10);
		
		tfStoreName = new JTextField();
		tfStoreName.setBounds(163, 148, 202, 20);
		frame.getContentPane().add(tfStoreName);
		tfStoreName.setColumns(10);
		
		tfStorePhone = new JTextField();
		tfStorePhone.setBounds(163, 301, 202, 20);
		frame.getContentPane().add(tfStorePhone);
		tfStorePhone.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Quản lý của hàng ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(82, 34, 283, 41);
		frame.getContentPane().add(lblNewLabel_5);
		
		table = new JTable();
		table.setLayout(null);
		frame.getContentPane().add(table);
		
		table.setModel(modelStore);
		
		modelStore.addColumn("STT");
		modelStore.addColumn("Mã của hàng");
		modelStore.addColumn("Tên của hàng");
		modelStore.addColumn("Địa chỉ");
		modelStore.addColumn("Số fax");
		modelStore.addColumn("Số Điện Thoại");
		
		JScrollPane sc = new JScrollPane(table);
		sc.setBounds(385, 107, 571, 211);
		frame.getContentPane().add(sc);//non
		
		modelStore.addRow(new Object[] {
				"###", "DUGD7ff", "Xe Vinfast điện", "Địa hình", "Còn trống", 200.89
		});
		
		seachStore = new JTextField();
		seachStore.setBounds(385, 76, 171, 20);
		frame.getContentPane().add(seachStore);
		seachStore.setColumns(10);
		
		JButton btnSeachStore = new JButton("Tìm kiếm ");
		btnSeachStore.setBounds(566, 73, 97, 23);
		frame.getContentPane().add(btnSeachStore);
		
		JButton btnAddStore = new JButton("Thêm");
		btnAddStore.setBounds(82, 368, 89, 33);
		frame.getContentPane().add(btnAddStore);
		
		JButton btnEditStore = new JButton("Sửa ");
		btnEditStore.setBounds(199, 368, 89, 33);
		frame.getContentPane().add(btnEditStore);
		
		JButton btnRemoveStore = new JButton("Xóa");
		btnRemoveStore.setBounds(326, 368, 89, 33);
		frame.getContentPane().add(btnRemoveStore);
		
		JButton btnResetStore = new JButton("Reset");
		btnResetStore.setBounds(453, 368, 89, 33);
		frame.getContentPane().add(btnResetStore);
		
		JButton btnExitStore = new JButton("Thoát");
		btnExitStore.setBounds(867, 368, 89, 33);
		frame.getContentPane().add(btnExitStore);
		
		JTextArea tfStoreAddress = new JTextArea();
		tfStoreAddress.setBounds(163, 197, 202, 50);
		frame.getContentPane().add(tfStoreAddress);
		
		tfStorefax = new JTextField();
		tfStorefax.setBounds(163, 262, 202, 20);
		frame.getContentPane().add(tfStorefax);
		tfStorefax.setColumns(10);
		btnExitStore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HomePage home = new HomePage();
				home.frame.setVisible(true);
				
				frame.setVisible(false);
			}
		});
		
	}
}
