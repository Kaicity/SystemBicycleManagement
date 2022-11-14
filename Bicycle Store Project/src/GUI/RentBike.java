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
import src.DTO.Store;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;


public class RentBike {

	public JFrame frmThu;
	private JTextField tfCccd;
	private JTable table;
	private JButton  exitBtn, btnRent;
	private JDateChooser rentDate, returnDate;
	
	
	private DefaultTableModel tableModel = new DefaultTableModel() {
		@Override
	    public boolean isCellEditable(int row, int column) {
	       //all cells false
	       return false;
	    }
	};
	private JTextField tfPhone;
	private JTextField tfHoten;
	
	//Truy xuat BLL
	private RentBLL rentBike = new RentBLL();
	private CustomerBLL cusBLL = new CustomerBLL();
	private final Action action = new SwingAction();

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
		
		for(int i = 0; i < listSTO.size(); i++) {
			Store st = listSTO.get(i);
			String id = st.getId();
			String name = st.getName();
			
			arrSTO.add(id);
		}
		
		JComboBox storeCb = new JComboBox(arrSTO);
		storeCb.setBounds(128, 262, 161, 28);
		frmThu.getContentPane().add(storeCb);
		
		JButton searchBtn = new JButton("");
		searchBtn.setSelectedIcon(new ImageIcon("C:\\Users\\ASUS\\Desktop\\sign-check-icon.png"));
		searchBtn.setIcon(new ImageIcon("C:\\Users\\ASUS\\Desktop\\sign-check-icon.png"));
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfCccd.getText().trim().equals(""))
					JOptionPane.showMessageDialog(frmThu, "Chưa điền CCCD/CMND !");
				
				else if(cusBLL.checkCus(tfCccd.getText())=="exists") {
					Customer cus = cusBLL.getInformation(tfCccd.getText());
					tfHoten.setText(cus.getName());
					tfPhone.setText(cus.getPhone());
				}
				else {
					int result = JOptionPane.showConfirmDialog(frmThu, "Đéo có CCCD/CMND trong hệ thống ok!, tạo thông tin "
							+ "khách hàng mới", "Thông báo",
							JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.YES_NO_OPTION) {
						tfHoten.setEditable(true);
						tfPhone.setEditable(true);
						
						
					}
				}
			}
			
		});
		searchBtn.setAction(action);
		searchBtn.setFont(new Font("Tahoma", Font.BOLD, 7));
		searchBtn.setBounds(259, 94, 30, 31);
		frmThu.getContentPane().add(searchBtn);
		
		
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
					String store = bike.getStoreId();
					String price = String.valueOf(bike.getPricePerH());
					String status = bike.getStatus();
					
					tableModel.addRow(new Object[] {
							count++, id, name, type, store, price, status
					});
				}
				
				//--------------------EVENT THUE LAY THONG TIN TU KHACH HANG NHAP VAO
				
				
				btnRent.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						int selectBike = table.getSelectedRow();
						
						java.util.Date d1, d2;
						d1 = rentDate.getDate();
						d2 = rentDate.getDate();
						
						if((d1 == null && d2 == null) || tfHoten.getText().trim().equals("") || tfPhone.getText().trim().equals("")
								|| tfCccd.getText().trim().equals("")) {
							
							JOptionPane.showMessageDialog(frmThu, "Vui lòng nhập đầy đủ thông tin khách hàng");
						}
						else if(tfCccd.getText().length() > 20) {
							JOptionPane.showMessageDialog(frmThu, "CCCD/CMND không được quá 20 kí tự");
						}
						else {
							
							SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
							String rentD, returnD;
							rentD = dcn.format(d1);
							returnD = dcn.format(d2);
							
							
							//Set thong tin khach hang nhap vao
							Customer newCus = new Customer();
							newCus.setCccd(tfCccd.getText());
							newCus.setName(tfHoten.getText());
							newCus.setPhone(tfPhone.getText());
							
							String result = cusBLL.addNewCustomer(newCus);
							System.out.println(result);
							JOptionPane.showMessageDialog(frmThu, result);
							
						}
					}
				});
				
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
		frmThu.setBounds(100, 100, 929, 516);
		frmThu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		tfCccd = new JTextField();
		tfCccd.setBounds(128, 96, 125, 28);
		frmThu.getContentPane().add(tfCccd);
		tfCccd.setColumns(10);
		tfCccd.requestFocusInWindow();
		
		
		
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

		
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		JScrollPane sp1 = new JScrollPane(table);
		sp1.setBounds(299, 81, 606, 327);
	    frmThu.getContentPane().add(sp1);
	    
	  
	    btnRent = new JButton("Thuê");
		btnRent.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRent.setBounds(721, 431, 101, 35);
		frmThu.getContentPane().add(btnRent);
		
		exitBtn = new JButton("Thoát");
		exitBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		exitBtn.setBounds(826, 431, 79, 35);
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
		lblNewLabel_2.setBounds(299, 57, 150, 17);
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
		rentDate.setBounds(128, 316, 161, 28);
		frmThu.getContentPane().add(rentDate);
		
		returnDate = new JDateChooser();
		returnDate.setBounds(128, 366, 161, 28);
		frmThu.getContentPane().add(returnDate);
		
		JLabel lblNewLabel_1_1 = new JLabel("Họ tên");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 145, 108, 28);
		frmThu.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(10, 199, 108, 28);
		frmThu.getContentPane().add(lblNewLabel_1_1_1);
		
		tfPhone = new JTextField();
		tfPhone.setEditable(false);
		tfPhone.setColumns(10);
		tfPhone.setBounds(128, 201, 161, 28);
		frmThu.getContentPane().add(tfPhone);
		
		tfHoten = new JTextField();
		tfHoten.setEditable(false);
		tfHoten.setColumns(10);
		tfHoten.setBounds(128, 147, 161, 28);
		frmThu.getContentPane().add(tfHoten);
		
	
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
};


