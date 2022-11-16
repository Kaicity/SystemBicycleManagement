package src.GUI;

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.lang.ProcessHandle.Info;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import src.BLL.CustomerBLL;
import src.BLL.RentBLL;
import src.DTO.Customer;
import src.DTO.Rent;
import src.DTO.Store;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;


public class RentBike {

	public JFrame frmThu;
	private JTextField tfCccdRent;
	private JTable table;
	private JButton  exitBtn, btnRent;
	private JDateChooser rentDate, returnDate;
	private JLabel checkSelectStore;
	
	private DefaultTableModel tableModel = new DefaultTableModel() {
		@Override
	    public boolean isCellEditable(int row, int column) {
	       //all cells false
	       return false;
	    }
	};
	private JTextField tfPhoneRent;
	private JTextField tfHotenRent;
	
	//Truy xuat BLL
	private RentBLL rentBike = new RentBLL();
	private CustomerBLL cusBLL = new CustomerBLL();
	private JLabel tfXedap;
	

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
		
		eventRentBike();
	}

	private void eventRentBike() {
		
		//DOAN CODE NAY CHI MANG TINH CHAT DEMO 
		
		//Form load 
//		frmThu.addWindowListener(new WindowListener() {
//			
//			@Override
//			public void windowOpened(WindowEvent e) {
//				String ques = "";
//				do {
//					 ques += JOptionPane.showInputDialog(frmThu,"Nhập CCCD/CMND để thuê xe");
//					 if(!(ques).equals("")) {
//						 tfCccd.setText(ques);
//					 }
//				}while(ques.isEmpty());
//				
//				
//				if(tfCccd.getText().trim().isEmpty() || tfCccd.getText().equals("null")) {
//					 UserHomePage back = new UserHomePage();
//					 back.frame.setVisible(true);
//					 frmThu.setVisible(false);
//				}else {
//					//kiem tra va dien thong tin khach hang neu khach hang da ton tai 
//					Customer info = new Customer();
//					
//					info = cusBLL.getInformation(tfCccd.getText());
//					
//					tfHoten.setText(info.getName());
//					tfPhone.setText(info.getPhone());
//					
//					if(tfHoten.getText().trim().toString().equals("") || tfPhone.getText().trim().toString().equals("")) {
//						JOptionPane.showMessageDialog(frmThu, "Khách hàng mới");
//						tfHoten.setEditable(true);
//						tfPhone.setEditable(true);
//						
//					}
//					
//				}
//				
//			}
//			
//			@Override
//			public void windowIconified(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void windowDeiconified(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void windowDeactivated(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void windowClosing(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void windowClosed(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void windowActivated(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		
		
		
		
		//----------------Lay danh sach cua hang trong combobox
        Vector<String> arrSTO = new Vector<String>();
		
		Vector<Store> listSTO = rentBike.getStoreList();
		
		String temp = " ";
		
		arrSTO.add(temp);
		
		for(int i = 0; i < listSTO.size(); i++) {
			Store st = listSTO.get(i);
			String id = st.getId();
			String name = st.getName();
		
			arrSTO.add(id);
		}
		
		
		JComboBox storeCb = new JComboBox(arrSTO);
		storeCb.setSelectedItem("");
		storeCb.setBounds(128, 262, 181, 28);
		frmThu.getContentPane().add(storeCb);
		
		
		//---------------------------------------------------------
		
		JButton searchBtn = new JButton("");
		searchBtn.setBackground(new Color(255, 255, 255));
		searchBtn.setSelectedIcon(new ImageIcon("C:\\Users\\ASUS\\Desktop\\sign-check-icon.png"));
		searchBtn.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\sign-check-icon.png"));
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfHotenRent.setEditable(true);
				tfPhoneRent.setEditable(true);
				
				tfHotenRent.setText("");
				tfPhoneRent.setText("");
				
				if(tfCccdRent.getText().trim().equals(""))
					JOptionPane.showMessageDialog(frmThu, "Chưa điền CCCD/CMND !");
				
				else if(cusBLL.checkCus(tfCccdRent.getText())=="exists") {
					Customer cus = cusBLL.getInformation(tfCccdRent.getText());
					tfHotenRent.setText(cus.getName());
					tfPhoneRent.setText(cus.getPhone());
					
					tfHotenRent.setEditable(false);
					tfPhoneRent.setEditable(false);
				}
				else {
					int result = JOptionPane.showConfirmDialog(frmThu, "Không có CCCD/CMND trong hệ thống "
							+ "khách hàng mới", "Thông báo",
							JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.YES_NO_OPTION) {
						tfHotenRent.setEditable(true);
						tfPhoneRent.setEditable(true);
						
					}
				}
			}
			
		});
		
		searchBtn.setFont(new Font("Tahoma", Font.BOLD, 7));
		searchBtn.setBounds(259, 94, 50, 31);
		frmThu.getContentPane().add(searchBtn);
		
		checkSelectStore = new JLabel("Chọn cửa hàng");
		checkSelectStore.setForeground(new Color(255, 0, 0));
		checkSelectStore.setBounds(128, 240, 125, 22);
		frmThu.getContentPane().add(checkSelectStore);
		
		
		
		
		storeCb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				String cbSelect = storeCb.getSelectedItem().toString();
				System.out.println(cbSelect);
				
				Vector<src.DTO.Bicycle> arr = rentBike.getBicyclesList(cbSelect);
				
				tableModel.getDataVector().removeAllElements();
						
				int count = 1;
				for(int i = 0;i < arr.size(); i++) {
					
					src.DTO.Bicycle bike = arr.get(i);
					String id = bike.getId();
					String name = bike.getName();
					String type = bike.getType();
					String price = String.valueOf(bike.getPricePerH());
					String status = bike.getStatus();
					
					tableModel.addRow(new Object[] {
							count++, id, name, type, price, status
					});
				}
				
				//--------------------EVENT THUE LAY THONG TIN TU KHACH HANG NHAP VAO
				System.out.println(storeCb.getSelectedItem().toString());
				if(!(storeCb.getSelectedItem().toString().equals(" "))) {
					checkSelectStore.setText("Đã chọn");
				
				}
				else {
					checkSelectStore.setText("Chọn cửa hàng");
				}
				
				btnRent.addActionListener(new ActionListener() {
			    	
					@SuppressWarnings("deprecation")
					@Override
					public void actionPerformed(ActionEvent e) {
						
						
						int selectBike = table.getSelectedRow();
						
						java.util.Date d1, d2;
						d1 = rentDate.getDate();
						d2 = rentDate.getDate();
						
						if(tfHotenRent.getText().trim().equals("") || tfPhoneRent.getText().trim().equals("")
								|| tfCccdRent.getText().trim().equals("")) {
							
							JOptionPane.showMessageDialog(frmThu, "Vui lòng nhập đầy đủ thông tin khách hàng");
						}
						else if(checkSelectStore.getText().equals("Chọn cửa hàng")) {
							JOptionPane.showMessageDialog(frmThu, "Chưa chọn cửa hàng" , "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						}
						else if(tfCccdRent.getText().length() > 20) {
							JOptionPane.showMessageDialog(frmThu, "CCCD/CMND không được quá 20 kí tự");
							System.out.println(storeCb.getSelectedItem().toString());
						}
						else if(d1 == null || d2 == null) {
							JOptionPane.showMessageDialog(frmThu, "Chưa chọn ngày thuê / ngày trả" , "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						}
						else if(tfXedap.getText().equals("")) {
							JOptionPane.showMessageDialog(frmThu, "Vui lòng chọn xe đạp để thuê");
						}
						else {
							
							SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
							String rentD, returnD;
							rentD = dcn.format(d1);
							returnD = dcn.format(d2);
							
							
							//Set thong tin khach hang nhap vao
							Customer newCus = new Customer();
							newCus.setCccd(tfCccdRent.getText());
							newCus.setName(tfHotenRent.getText());
							newCus.setPhone(tfPhoneRent.getText());
							
							Rent rent = new Rent();
							rent.setCustomer(newCus);
							
							rent.setStore(storeCb.getSelectedItem().toString());
							rent.setRentDate(d1);
							rent.setReturnDate(d2);
							
							
							
							
							
//							String result = cusBLL.addNewCustomer(newCus);
//							System.out.println(result);
//							JOptionPane.showMessageDialog(frmThu, result);
							
							DetailRentBike detailInv = new DetailRentBike();
							detailInv.frmHoadon.setVisible(true);
							
						    detailInv.tfCustomerName.setText(tfHotenRent.getText());
						    detailInv.tfPhoneCus.setText(tfPhoneRent.getText());
						    detailInv.tfStoreName.setText(storeCb.getSelectedItem().toString());
						    
						    
						    
						    int i = table.getSelectedRow();
						    
						    String id = tableModel.getValueAt(i, 1).toString();
						    String name = tableModel.getValueAt(i, 2).toString();
						    String type = tableModel.getValueAt(i, 3).toString();
						    String price = tableModel.getValueAt(i, 4).toString();
						
						    
						    
						    detailInv.bikeId.setText(id);
						    detailInv.bikeName.setText(name);
						    detailInv.bikePriceh.setText(price);
						    detailInv.howDay.setText(String.valueOf(d2.getTime() - d1.getTime()));					
						}
						
			    	
			        }
			    	
			    });
			}
		});
		
		//table mouse 
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				if(i >= 0) {
					tfXedap.setText(tableModel.getValueAt(i, 2).toString());
				}
			}
		});
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {
		frmThu = new JFrame();
		frmThu.setTitle("THUÊ");
		frmThu.setBounds(100, 100, 988, 516);
		frmThu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmThu.getContentPane().setLayout(null);
		frmThu.setLocationRelativeTo(frmThu);
		
		
		JLabel lblNewLabel = new JLabel("Thuê Xe");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 895, 46);
		frmThu.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CCCD/CMND");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 94, 108, 28);
		frmThu.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Cửa hàng");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(10, 260, 108, 28);
		frmThu.getContentPane().add(lblNewLabel_1_2_1);
		
		tfCccdRent = new JTextField();
		tfCccdRent.setBounds(128, 96, 125, 28);
		frmThu.getContentPane().add(tfCccdRent);
		tfCccdRent.setColumns(10);
		tfCccdRent.requestFocusInWindow();
		
		
		
		table = new JTable();
		table.setRowHeight(30);
		frmThu.getContentPane().add(table);
		table.setModel(tableModel);
		tableModel.addColumn("STT");
		tableModel.addColumn("Mã Xe Đạp");
		tableModel.addColumn("Tên Xe Đạp");
		tableModel.addColumn("Loại Xe Đạp");
		tableModel.addColumn("Giá/H");
		tableModel.addColumn("Tình Trạng");
		
	    tableModel.addRow( new Object[] {
	    		" ", " "
	    });

		
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		JScrollPane sp1 = new JScrollPane(table);
		sp1.setBounds(319, 81, 643, 327);
	    frmThu.getContentPane().add(sp1);
	    
	  
	    btnRent = new JButton("Thuê");
	    
	    
		btnRent.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRent.setBounds(772, 417, 101, 35);
		frmThu.getContentPane().add(btnRent);
		
		exitBtn = new JButton("Thoát");
		exitBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		exitBtn.setBounds(883, 417, 79, 35);
		frmThu.getContentPane().add(exitBtn);
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UserHomePage home = new UserHomePage();
				home.frame.setVisible(true);
				frmThu.setVisible(false);
				
			}
		});
		

		JLabel lblNewLabel_2 = new JLabel("Danh sách xe");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(318, 53, 150, 17);
		frmThu.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Ngày thuê");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1.setBounds(10, 316, 108, 28);
		frmThu.getContentPane().add(lblNewLabel_1_2_1_1);
		
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Ngày trả");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1_1.setBounds(10, 366, 108, 28);
		frmThu.getContentPane().add(lblNewLabel_1_2_1_1_1);
		
	    rentDate = new JDateChooser();
		rentDate.setBounds(128, 316, 181, 28);
		frmThu.getContentPane().add(rentDate);
		
		returnDate = new JDateChooser();
		returnDate.setBounds(128, 366, 181, 28);
		frmThu.getContentPane().add(returnDate);
		
		JLabel lblNewLabel_1_1 = new JLabel("Họ tên");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 145, 108, 28);
		frmThu.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(10, 199, 108, 28);
		frmThu.getContentPane().add(lblNewLabel_1_1_1);
		
		tfPhoneRent = new JTextField();
		tfPhoneRent.setEditable(false);
		tfPhoneRent.setColumns(10);
		tfPhoneRent.setBounds(128, 201, 181, 28);
		frmThu.getContentPane().add(tfPhoneRent);
		
		tfHotenRent = new JTextField();
		tfHotenRent.setEditable(false);
		tfHotenRent.setColumns(10);
		tfHotenRent.setBounds(128, 147, 181, 28);
		frmThu.getContentPane().add(tfHotenRent);
		
		tfXedap = new JLabel("");
		tfXedap.setBounds(318, 429, 204, 14);
		frmThu.getContentPane().add(tfXedap);
		
	
	}
};


