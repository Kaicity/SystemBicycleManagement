package src.GUI;

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

public class Bicycle {

	public JFrame frame;
	private JTextField tfBicycleID;
	private JTextField tfBicycleName;
	private JTextField tfBicyclePrice;
	private JTable table;
	private DefaultTableModel modelBicycle = new DefaultTableModel();
	private JTextField seachBicycle;
	
	final String[] typeBicycle = {"Xe phổ thông", "Xe đạp tình yêu", "Xe đạp leo núi",
			"Xe đạp địa hình dốc", "Xe đạp điện", "Xe đạp Single"
	};
	
	final String[] status = {"Chưa thuê", "Đã thuê"};

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
	public Bicycle() {
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
		
		JLabel lblNewLabel = new JLabel("Xe Đạp ID");
		lblNewLabel.setBounds(82, 107, 80, 17);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên xe đạp");
		lblNewLabel_1.setBounds(82, 151, 80, 17);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Loại xe");
		lblNewLabel_2.setBounds(82, 200, 80, 18);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Trạng thái");
		lblNewLabel_3.setBounds(82, 252, 80, 18);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Giá thuê / giờ");
		lblNewLabel_4.setBounds(82, 304, 80, 17);
		frame.getContentPane().add(lblNewLabel_4);
		
		tfBicycleID = new JTextField();
		tfBicycleID.setEditable(false);
		tfBicycleID.setBounds(163, 104, 202, 20);
		frame.getContentPane().add(tfBicycleID);
		tfBicycleID.setColumns(10);
		
		tfBicycleName = new JTextField();
		tfBicycleName.setBounds(163, 148, 202, 20);
		frame.getContentPane().add(tfBicycleName);
		tfBicycleName.setColumns(10);
		
		tfBicyclePrice = new JTextField();
		tfBicyclePrice.setBounds(163, 301, 202, 20);
		frame.getContentPane().add(tfBicyclePrice);
		tfBicyclePrice.setColumns(10);
		
		JComboBox typeBicycleBox = new JComboBox(typeBicycle);
		typeBicycleBox.setBounds(163, 196, 202, 22);
		frame.getContentPane().add(typeBicycleBox);
		
		JComboBox statusBox = new JComboBox(status);
		statusBox.setBounds(163, 248, 202, 22);
		frame.getContentPane().add(statusBox);
		
		JLabel lblNewLabel_5 = new JLabel("Quản lý xe đạp cho thuê");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(82, 0, 283, 41);
		frame.getContentPane().add(lblNewLabel_5);
		
		table = new JTable();
		table.setLayout(null);
		frame.getContentPane().add(table);
		
		table.setModel(modelBicycle);
		
		modelBicycle.addColumn("STT");
		modelBicycle.addColumn("Mã xe");
		modelBicycle.addColumn("Tên xe");
		modelBicycle.addColumn("Loại xe");
		modelBicycle.addColumn("Trạng thái");
		modelBicycle.addColumn("Giá thuê");
		
		JScrollPane sc = new JScrollPane(table);
		sc.setBounds(385, 87, 571, 234);
		frame.getContentPane().add(sc);
		
		modelBicycle.addRow(new Object[] {
				"###", "DUGD7ff", "Xe Vinfast điện", "Địa hình", "Còn trống", 200.89
		});
		
		seachBicycle = new JTextField();
		seachBicycle.setBounds(385, 60, 171, 20);
		frame.getContentPane().add(seachBicycle);
		seachBicycle.setColumns(10);
		
		JButton btnSeachBicycle = new JButton("Tìm kiếm ");
		btnSeachBicycle.setBounds(566, 59, 97, 23);
		frame.getContentPane().add(btnSeachBicycle);
		
		JButton btnAddBicycle = new JButton("Thêm");
		btnAddBicycle.setBounds(82, 368, 89, 33);
		frame.getContentPane().add(btnAddBicycle);
		
		JButton btnEditBicycle = new JButton("Sửa ");
		btnEditBicycle.setBounds(199, 368, 89, 33);
		frame.getContentPane().add(btnEditBicycle);
		
		JButton btnRemoveBicycle = new JButton("Xóa");
		btnRemoveBicycle.setBounds(326, 368, 89, 33);
		frame.getContentPane().add(btnRemoveBicycle);
		
		JButton btnResetBicycle = new JButton("Reset");
		btnResetBicycle.setBounds(453, 368, 89, 33);
		frame.getContentPane().add(btnResetBicycle);
		
		JButton btnExitBicycle = new JButton("Thoát");
		btnExitBicycle.setBounds(867, 368, 89, 33);
		frame.getContentPane().add(btnExitBicycle);
		
		JLabel lblCaHng = new JLabel("Cửa hàng");
		lblCaHng.setBounds(82, 62, 80, 17);
		frame.getContentPane().add(lblCaHng);
		
		JComboBox cbStorebike = new JComboBox();
		cbStorebike.setBounds(163, 59, 202, 22);
		frame.getContentPane().add(cbStorebike);
		btnExitBicycle.addActionListener(new ActionListener() {
			
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
