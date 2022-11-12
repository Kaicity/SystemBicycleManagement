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

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import src.BLL.RentBLL;
import src.DTO.Store;


public class RentBike {

	public JFrame frmThu;
	private JTextField nameTxt;
	private JTable table;
	private JButton rentBtn, exitBtn;
	
	private RentBLL rentBike = new RentBLL();
	
	private DefaultTableModel tableModel = new DefaultTableModel() {
		@Override
	    public boolean isCellEditable(int row, int column) {
	       //all cells false
	       return false;
	    }
	};
	private JTextField textField;
	private JTextField textField_1;
	
	
	

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
        Vector<String> arrSTO = new Vector<String>();
		
		Vector<Store> listSTO = rentBike.getStoreList();
		
		for(int i = 0; i < listSTO.size(); i++) {
			Store st = listSTO.get(i);
			String id = st.getId();
			String name = st.getName();
			
			arrSTO.add(id);
		}
		
		
		
		JComboBox storeCb = new JComboBox(arrSTO);
		storeCb.setBounds(139, 262, 150, 28);
		frmThu.getContentPane().add(storeCb);
		
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
		
		nameTxt = new JTextField();
		nameTxt.setBounds(139, 96, 150, 28);
		frmThu.getContentPane().add(nameTxt);
		nameTxt.setColumns(10);
		
		
		
		table = new JTable();
		table.setRowHeight(30);
		frmThu.getContentPane().add(table);
		table.setModel(tableModel);
		tableModel.addColumn("STT");
		tableModel.addColumn("Mã Hóa Đơn");
		tableModel.addColumn("CCCD");
		tableModel.addColumn("DS Xe");
		tableModel.addColumn("Tỏng Giá");
		tableModel.addColumn("Tình Trạng");

		
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		JScrollPane sp1 = new JScrollPane(table);
		sp1.setBounds(299, 81, 606, 327);
	    frmThu.getContentPane().add(sp1);
	    
	  
	  
		
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
		
		 
		rentBtn = new JButton("Thuê");
		rentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rentBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		rentBtn.setBounds(681, 431, 135, 35);
		frmThu.getContentPane().add(rentBtn);
		
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
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(139, 316, 150, 28);
		frmThu.getContentPane().add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(139, 366, 150, 28);
		frmThu.getContentPane().add(dateChooser_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Họ tên");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 145, 108, 28);
		frmThu.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(10, 199, 108, 28);
		frmThu.getContentPane().add(lblNewLabel_1_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(139, 201, 150, 28);
		frmThu.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(139, 147, 150, 28);
		frmThu.getContentPane().add(textField_1);
		
		
		
		eventRent();
	}
	
	private void eventRent() {
		rentBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DetailRentBike inv = new DetailRentBike();
				inv.frmHoadon.setVisible(true);
				
			}
		});
		
	}
};


