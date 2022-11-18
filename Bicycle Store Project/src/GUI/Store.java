package src.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import src.BLL.StoreBLL;

import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Store {

	public JFrame frame;
	private JTextField tfStoreID;
	private JTextField tfStoreName;
	private JTextField tfStorePhone;
	JTextArea tfStoreAddress;
	private JTable table;
	private DefaultTableModel modelStore = new DefaultTableModel() {
		@Override
	    public boolean isCellEditable(int row, int column) {
	       //all cells false
	       return false;
	    }
	};
	
	public int count = 1;
	
	final String[] typeBicycle = {"Xe phổ thông", "Xe đạp tình yêu", "Xe đạp leo núi",
			"Xe đạp địa hình dốc", "Xe đạp điện", "Xe đạp Single"
	};
	
	final String[] status = {"Chưa thuê", "Đã thuê"};
	private JTextField tfStorefax;
	
	StoreBLL stoBLL = new StoreBLL();

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
		
		//event
		eventStore();
		loadDataStore();
	}
	
	public void loadDataStore() {
		Vector<src.DTO.Store> arr = stoBLL.getStoreList();
		for(int i = 0;i < arr.size(); i++) {
			src.DTO.Store sto = arr.get(i);
			String id = sto.getId();
			String name = sto.getName();
			String address = sto.getAddress();
			String fax = sto.getFax();
			String phone = sto.getPhone();
			
			modelStore.addRow(new Object[] {
					count++, id, name, address, fax, phone
			});
		}
		
	}
	
	private void eventStore() {
		
		//THEM MOI CUA HANG XE DAP 
		
		JButton btnAddStore = new JButton("Thêm");
		btnAddStore.setBounds(82, 368, 89, 33);
		frame.getContentPane().add(btnAddStore);
		btnAddStore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(tfStoreID.getText().trim().equals("")||tfStoreName.getText().trim().equals("")||
						tfStoreAddress.getText().trim().equals("") || tfStorefax.getText().trim().equals("") || 
						tfStorePhone.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(frame, "Vui lòng nhập đầy đủ thông tin");
				}
				else if(tfStoreID.getText().length() > 20) {
					JOptionPane.showMessageDialog(frame, "Mã chỉ chứa đa 20 kí tự");
				}
				else {
					src.DTO.Store sto = new src.DTO.Store();
					
					sto.setId(tfStoreID.getText());
					sto.setName(tfStoreName.getText());
					sto.setAddress(tfStoreAddress.getText());
					sto.setFax(tfStorefax.getText());
					sto.setPhone(tfStorePhone.getText());
					
					
					String result = stoBLL.addstore(sto);
					JOptionPane.showMessageDialog(frame, result);
					
					System.out.println(result);
					
					if(result.equals("success")) {
						modelStore.addRow(new Object[] {
								
								count++ + "*" ,sto.getId(), sto.getName(), sto.getAddress(), 
								sto.getFax(), sto.getPhone()
						});
					}
				}
			}
				
		});
		//-------------------------------------CAP NHAT SUA THONG TIN CUA HANG
		
		JButton btnEditStore = new JButton("Sửa ");
		btnEditStore.setBounds(199, 368, 89, 33);
		frame.getContentPane().add(btnEditStore);
		btnEditStore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int i = table.getSelectedRow();
				if(i >= 0) {
					src.DTO.Store sto = new src.DTO.Store();
					sto.setId(tfStoreID.getText());
					sto.setName(tfStoreName.getText());
					sto.setAddress(tfStoreAddress.getText());
					sto.setFax(tfStorefax.getText());
					sto.setPhone(tfStorePhone.getText());
					
					int ques = JOptionPane.showConfirmDialog(frame, "Xác nhận sửa thông tin cửa hàng");
					if(ques == JOptionPane.YES_OPTION) {
						String result = stoBLL.editStore(sto);
						
						JOptionPane.showMessageDialog(frame, result);
						if(result.equals("success")) {
							modelStore.setValueAt(sto.getId(), i, 1);
							modelStore.setValueAt(sto.getName(), i, 2);
							modelStore.setValueAt(sto.getAddress(), i, 3);
							modelStore.setValueAt(sto.getFax(), i, 4);
							modelStore.setValueAt(sto.getPhone(), i, 5);
							
							
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(frame, "Vui lòng chọn dòng dữ liệu để cập nhật không thì khỏi làm");
					
				}
				
			}
		});
		//-------------------------------------XOA CUA HANG XE DAP 
		
		JButton btnRemoveStore = new JButton("Xóa");
		btnRemoveStore.setBounds(326, 368, 89, 33);
		frame.getContentPane().add(btnRemoveStore);
		btnRemoveStore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int i = table.getSelectedRow();
				if(i >= 0) {
					int ques = JOptionPane.showConfirmDialog(frame, "Xác nhận xóa thông tin cửa hàng");
					if(ques == JOptionPane.YES_OPTION) {
						String result = stoBLL.delstore(modelStore.getValueAt(i, 1).toString());
						System.out.println(modelStore.getValueAt(i, 1).toString());
						JOptionPane.showMessageDialog(frame, result);
						if(result.equals("success")) {
							modelStore.removeRow(i);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(frame, "Vui lòng chọn dòng dữ liệu để xóa không thì khỏi xóa");
				}
			}
				
		});
		//-------------------------------------MOUSE CLICK TABLE
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				if(i >= 0) {
					tfStoreID.setEditable(false);
					
					tfStoreID.setText(modelStore.getValueAt(i, 1).toString());
					tfStoreName.setText(modelStore.getValueAt(i, 2).toString());
					tfStoreAddress.setText(modelStore.getValueAt(i, 3).toString());
					tfStorefax.setText(modelStore.getValueAt(i, 4).toString());
					tfStorePhone.setText(modelStore.getValueAt(i, 5).toString());
				}
			}
		});
		
		
		JButton btnResetStore = new JButton("Reset");
		btnResetStore.setBounds(453, 368, 89, 33);
		frame.getContentPane().add(btnResetStore);
		btnResetStore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tfStoreID.setEditable(true);
				tfStoreID.setText("");
				tfStoreName.setText("");
				tfStoreAddress.setText("");
				tfStorefax.setText("");
				tfStorePhone.setText("");
				
			}
		});
		
		//---------------------------------------
		
//		table.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				int i = table5.getSelectedRow();
//				if(i >= 0) {
//					tfHotelCode.setEditable(false);
//					tfHotelCode.setText(model5.getValueAt(i, 1).toString());
//					tfHotelName.setText(model5.getValueAt(i, 2).toString());
//					tfAddress.setText(model5.getValueAt(i, 3).toString());
//				}
//				else {
//					JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn dòng dữ liệu để xóa");
//				}
//			}
//		});
		
		
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 980, 490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(frame);
		
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
		
		tfStoreID = new JTextField();
		tfStoreID.setBounds(163, 104, 202, 20);
		frame.getContentPane().add(tfStoreID);
		tfStoreID.setColumns(10);
		
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
		
//		modelStore.addRow(new Object[] {
//				"###", "DUGD7ff", "Xe Vinfast điện", "Địa hình", "Còn trống", 200.89
//		});
		
		
		JButton btnExitStore = new JButton("Thoát");
		btnExitStore.setBounds(867, 368, 89, 33);
		frame.getContentPane().add(btnExitStore);
		
		tfStoreAddress = new JTextArea();
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
