package src.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import src.BLL.BicycleBLL;
import src.DTO.Store;

import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.SwingConstants;

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
	
	BicycleBLL bikeBLL = new BicycleBLL();

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
		
		//eventBike
		eventBicycle();
		loadLBicycleList();
	}


	private void loadLBicycleList() {
		
		
	}

	private void eventBicycle() {
		
		JComboBox typeBicycleBox = new JComboBox(typeBicycle);
		typeBicycleBox.setBounds(163, 196, 202, 22);
		frame.getContentPane().add(typeBicycleBox);
		
		JComboBox statusBox = new JComboBox(status);
		statusBox.setBounds(163, 248, 202, 22);
		frame.getContentPane().add(statusBox);
		
		
		Vector<String> arrSTO = new Vector<String>();
		
		Vector<Store> listSTO = bikeBLL.getStoreList();
		for(int i = 0; i < listSTO.size(); i++) {
			Store st = listSTO.get(i);
			String id = st.getId();
			String name = st.getName();
			
			arrSTO.add(id);
		}
		
		JComboBox cbStorebike = new JComboBox(arrSTO);
		cbStorebike.setBounds(163, 59, 202, 22);
		frame.getContentPane().add(cbStorebike);
		
		//----------------------------------SHOW LIST XE DAP 
		
		cbStorebike.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		
				String cbSelect = cbStorebike.getSelectedItem().toString();
				System.out.println(cbSelect);
				
				Vector<src.DTO.Bicycle> arr = bikeBLL.getBicyclesList(cbSelect);
				
				modelBicycle.getDataVector().removeAllElements();
						
				int count = 1;
				for(int i = 0;i < arr.size(); i++) {
					
					src.DTO.Bicycle bike = arr.get(i);
					String id = bike.getId();
					String name = bike.getName();
					String type = bike.getType();
					String store = bike.getStoreId();
					String price = String.valueOf(bike.getPricePerH());
					String status = bike.getStatus();
					
					modelBicycle.addRow(new Object[] {
							count++, id, name, type, store, price, status
					});
				}
			}
		});
		
		//SEACH XE DAP THEO MA 
		JButton btnSeachBicycle = new JButton("Tìm kiếm ");
		btnSeachBicycle.setBounds(566, 59, 97, 23);
		frame.getContentPane().add(btnSeachBicycle);
		
		//------------------------------------THEM XE DAP 
		
		JButton btnAddBicycle = new JButton("Thêm");
		btnAddBicycle.setBounds(82, 368, 89, 33);
		frame.getContentPane().add(btnAddBicycle);
		btnAddBicycle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tfBicycleID.getText().trim().equals("")||tfBicycleName.getText().trim().equals("")||
						tfBicyclePrice.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(frame, "Vui lòng nhập đầy đủ thông tin");
				}
				else if(tfBicycleID.getText().length() > 20) {
					JOptionPane.showMessageDialog(frame, "Mã chỉ chứa đa 20 kí tự");
				}
				else {
					src.DTO.Bicycle bike = new src.DTO.Bicycle();
					
					bike.setId(tfBicycleID.getText());
					bike.setName(tfBicycleName.getText());
					bike.setType(typeBicycleBox.getSelectedItem().toString());
					bike.setStoreId(cbStorebike.getSelectedItem().toString());
					bike.setPricePerH(Integer.parseInt(tfBicyclePrice.getText()));
					bike.setStatus(statusBox.getSelectedItem().toString());
					
					
					String result = bikeBLL.addbikeBLL(bike);
					JOptionPane.showMessageDialog(frame, result);
					
					System.out.println(result);
					
					if(result.equals("success")) {
						modelBicycle.addRow(new Object[] {
								"*" ,bike.getId(), bike.getName(), bike.getType(), 
								bike.getStoreId(), bike.getPricePerH(), bike.getStatus()
						});
					}
				}
				
			}
		});
		
		//------------------------------------SUA XE DAP
		
		JButton btnEditBicycle = new JButton("Sửa ");
		btnEditBicycle.setBounds(199, 368, 89, 33);
		frame.getContentPane().add(btnEditBicycle);
		btnEditBicycle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i >= 0) {
					src.DTO.Bicycle bike = new src.DTO.Bicycle();
					bike.setId(tfBicycleID.getText());
					bike.setName(tfBicycleName.getText());
					bike.setType(typeBicycleBox.getSelectedItem().toString());
					bike.setStoreId(cbStorebike.getSelectedItem().toString());
					bike.setPricePerH(Integer.parseInt(tfBicyclePrice.getText()));
					bike.setStatus(statusBox.getSelectedItem().toString());
					
					
					int ques = JOptionPane.showConfirmDialog(frame, "Xác nhận sửa thông tin xe đạp");
					if(ques == JOptionPane.YES_OPTION) {
						String result = bikeBLL.editbikeBLL(bike);
						
						JOptionPane.showMessageDialog(frame, result);
						if(result.equals("success")) {
							modelBicycle.setValueAt(bike.getId(), i, 1);
							modelBicycle.setValueAt(bike.getName(), i, 2);
							modelBicycle.setValueAt(bike.getType(), i, 3);
							modelBicycle.setValueAt(bike.getStoreId(), i, 4);
							modelBicycle.setValueAt(bike.getPricePerH(), i, 5);
							modelBicycle.setValueAt(bike.getStatus(), i, 6);
							
							
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(frame, "Vui lòng chọn dòng dữ liệu để cập nhật không thì khỏi làm");
					
				}
				
			}
		});
		
		//--------------------------------------XOA XE DAP
		
		JButton btnRemoveBicycle = new JButton("Xóa");
		btnRemoveBicycle.setBounds(326, 368, 89, 33);
		frame.getContentPane().add(btnRemoveBicycle);
		btnRemoveBicycle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i >= 0) {
					int ques = JOptionPane.showConfirmDialog(frame, "Xác nhận xóa thông tin xe đạp");
					if(ques == JOptionPane.YES_OPTION) {
						String result = bikeBLL.delbikeBLL(modelBicycle.getValueAt(i, 1).toString());
						System.out.println(modelBicycle.getValueAt(i, 1).toString());
						JOptionPane.showMessageDialog(frame, result);
						if(result.equals("success")) {
							modelBicycle.removeRow(i);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(frame, "Vui lòng chọn dòng dữ liệu để xóa không thì khỏi xóa");
				}
				
			}
		});
		
		//--------------------------------------RESET 
		
		JButton btnResetBicycle = new JButton("Reset");
		btnResetBicycle.setBounds(453, 368, 89, 33);
		frame.getContentPane().add(btnResetBicycle);
		btnResetBicycle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tfBicycleID.setEditable(true);
				
				tfBicycleID.setText("");
				tfBicycleName.setText("");
				cbStorebike.setSelectedItem(cbStorebike.getSelectedItem());
				typeBicycleBox.setSelectedItem(cbStorebike.getSelectedItem());
				tfBicyclePrice.setText("");
				statusBox.setSelectedItem(statusBox.getSelectedItem());
				
			}
		});
		
		//-------------------------------------MOUSE CLICK TABLE
				table.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						int i = table.getSelectedRow();
						if(i >= 0) {
							tfBicycleID.setEditable(false);
							
							tfBicycleID.setText(modelBicycle.getValueAt(i, 1).toString());
							tfBicycleName.setText(modelBicycle.getValueAt(i, 2).toString());
							cbStorebike.setSelectedItem(modelBicycle.getValueAt(i, 3).toString());
							typeBicycleBox.setSelectedItem(modelBicycle.getValueAt(i, 4).toString());
							tfBicyclePrice.setText(modelBicycle.getValueAt(i, 5).toString());
							statusBox.setSelectedItem(modelBicycle.getValueAt(i, 6).toString());
						}
					}
				});
				
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 980, 490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(frame);
		
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
		
		
		JLabel lblNewLabel_5 = new JLabel("Quản lý xe đạp");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(10, 8, 946, 41);
		frame.getContentPane().add(lblNewLabel_5);
		
		table = new JTable();
		table.setLayout(null);
		frame.getContentPane().add(table);
		
		table.setModel(modelBicycle);
		
		modelBicycle.addColumn("STT");
		modelBicycle.addColumn("Mã xe");
		modelBicycle.addColumn("Tên xe");
		modelBicycle.addColumn("Loại xe");
		modelBicycle.addColumn("Cửa hàng");
		modelBicycle.addColumn("Giá thuê");
		modelBicycle.addColumn("Trạng thái");
		
		JScrollPane sc = new JScrollPane(table);
		sc.setBounds(385, 87, 571, 234);
		frame.getContentPane().add(sc);
		
//		modelBicycle.addRow(new Object[] {
//				"###", "DUGD7ff", "Xe Vinfast điện", "Địa hình", "Còn trống", 200.89
//		});
		
		seachBicycle = new JTextField();
		seachBicycle.setBounds(385, 60, 171, 20);
		frame.getContentPane().add(seachBicycle);
		seachBicycle.setColumns(10);
		
		
		JButton btnExitBicycle = new JButton("Thoát");
		btnExitBicycle.setBounds(867, 368, 89, 33);
		frame.getContentPane().add(btnExitBicycle);
		
		JLabel lblCaHng = new JLabel("Cửa hàng");
		lblCaHng.setBounds(82, 62, 80, 17);
		frame.getContentPane().add(lblCaHng);
		
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
