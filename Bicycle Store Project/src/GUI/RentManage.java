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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import src.BLL.QuanLyBLL;
import src.DTO.Rent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;


public class RentManage {

	public JFrame frmThu;
	private JTextField cccdTxt;
	private JTable table;
	private JButton rentBtn, exitBtn;
	
	QuanLyBLL quanly = new QuanLyBLL();

	
	
	
	private DefaultTableModel tableModel = new DefaultTableModel() {
		@Override
	    public boolean isCellEditable(int row, int column) {
	       //all cells false
	       return false;
	    }
	};
	private JTextField hdidTxt;
	private JTextField cuahangIdTxt;
	private JTextField searchTxt;
	
	private String cccd;
	

	//show hoa don
	private void allHoaDonList() {
		//quanly.allHoaDonList();
		showHoaDonList(quanly.allHoaDonList());
	}
	
	private void getHoaDonListByStatus(String status) {
		//quanly.getAllHoaDonListByStatus(status);
		showHoaDonList(quanly.getAllHoaDonListByStatus(status));
	}
	
	private void getHoaDonListById(String hdid) {
		//quanly.getHoaDonListById(hdid);
		showHoaDon(quanly.getHoaDonListById(hdid));
	}
	
	private void getHoaDonListByCccd(String cccd) {
		//quanly.getHoaDonListByCccd(cccd);
		showHoaDonList(quanly.getHoaDonListByCccd(cccd));
	}
	
	private void getHoaDonByCccdAndStatus(String cccd, String status) {
		//quanly.getHoaDonListByCccdAndStatus(cccd, status);
		showHoaDonList(quanly.getHoaDonListByCccdAndStatus(cccd, status));
	}

	
	
	//xu ly hoa don
	private void editHoaDon(Rent hoadon) {
		quanly.editHoaDon(hoadon);
	}
	
	
	private void huyHoaDon(Rent hoadon) {
		quanly.huyHoaDon(hoadon);
	}
	
	private void hoanthanhHoaDon(Rent hoadon) {
		quanly.hoanthanhHoaDon(hoadon);
	}
	
	private void showHoaDonList(Vector<Rent> hoadonlist) {
		
		tableModel.getDataVector().removeAllElements();
		for(int i = 0; i < hoadonlist.size() ; i++) {
			Rent rent = hoadonlist.get(i);
			String hdid = rent.getId();
			String cccd = rent.getCustomer();
			String bikeid = rent.getBicycle();
			String rentday = rent.getRentDate();
			String returnday = rent.getRentDate();
			String status = rent.getStatus();
			tableModel.addRow(new Object[] {
					i,	hdid,	cccd,	bikeid, 	rentday,	returnday,	status
			});
		}
	}
	
	
	private void showHoaDon(Rent rent) {
		tableModel.getDataVector().removeAllElements();
		
		String hdid = rent.getId();
		String cccd = rent.getCustomer();
		String bikeid = rent.getBicycle();
		String rentday = rent.getRentDate();
		String returnday = rent.getRentDate();
		String status = rent.getStatus();
		
		tableModel.addRow(new Object[] {
				1, hdid,	cccd,	bikeid, 	rentday,	returnday,	status
		});
	}


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
		
		eventload();
	}
	
	

	private void eventload() {
		// TODO Auto-generated method stub
		frmThu.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				allHoaDonList();
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
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
		frmThu.setBounds(100, 100, 1080, 531);
		frmThu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmThu.getContentPane().setLayout(null);
		frmThu.setLocationRelativeTo(frmThu);
		
		
		JLabel lblNewLabel = new JLabel("Quản Lý Thuê Xe");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 1044, 62);
		frmThu.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CCCD/CMND");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 187, 108, 35);
		frmThu.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Trạng Thái");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(10, 398, 108, 35);
		frmThu.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Mã Cửa Hàng");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2_1.setBounds(10, 238, 108, 35);
		frmThu.getContentPane().add(lblNewLabel_1_2_1);
		
		cccdTxt = new JTextField();
		cccdTxt.setEditable(false);
		cccdTxt.setBounds(128, 186, 161, 35);
		frmThu.getContentPane().add(cccdTxt);
		cccdTxt.setColumns(10);
		
		String listCuaHang[] = {"cua hang 1", "cua hang 2", "cua hang 3"};
		
		
		table = new JTable();
		table.setRowHeight(30);
		frmThu.getContentPane().add(table);
		table.setModel(tableModel);
		tableModel.addColumn("STT");
		tableModel.addColumn("Mã Hóa Đơn");
		tableModel.addColumn("CCCD");
		tableModel.addColumn("Mã Xe Thuê");
		tableModel.addColumn("Ngày Thuê");
		tableModel.addColumn("Ngày Trả");
		tableModel.addColumn("Trạng Thái");
		

		
		
		
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		JScrollPane sp1 = new JScrollPane(table);
		sp1.setBounds(299, 130, 755, 308);
	    frmThu.getContentPane().add(sp1);

		
		exitBtn = new JButton("Thoát");
		exitBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		exitBtn.setBounds(975, 449, 79, 35);
		frmThu.getContentPane().add(exitBtn);
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				HomePage home = new HomePage();
				home.frame.setVisible(true);
				
				frmThu.setVisible(false);
				
			}
		});
		
		 
		rentBtn = new JButton("Lưu");
		rentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		rentBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		rentBtn.setBounds(695, 449, 152, 35);
		frmThu.getContentPane().add(rentBtn);
		
		JLabel lblNewLabel_2 = new JLabel("Danh Sách Hóa Đơn");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(299, 89, 202, 36);
		frmThu.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mã Hóa Đơn");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(10, 129, 108, 35);
		frmThu.getContentPane().add(lblNewLabel_1_2);
		
		hdidTxt = new JTextField();
		hdidTxt.setBounds(128, 128, 121, 35);
		frmThu.getContentPane().add(hdidTxt);
		hdidTxt.setColumns(10);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Ngày thuê");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2_1_1.setBounds(10, 292, 108, 35);
		frmThu.getContentPane().add(lblNewLabel_1_2_1_1);
		
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Ngày trả");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2_1_1_1.setBounds(10, 348, 108, 35);
		frmThu.getContentPane().add(lblNewLabel_1_2_1_1_1);
		
		JDateChooser ngaythueTxt = new JDateChooser();
		ngaythueTxt.setBounds(128, 292, 161, 35);
		frmThu.getContentPane().add(ngaythueTxt);
		
		JDateChooser ngaytraTxt = new JDateChooser();
		ngaytraTxt.setBounds(128, 348, 161, 35);
		frmThu.getContentPane().add(ngaytraTxt);
		
		JComboBox statusCb = new JComboBox(new Object[]{});
		statusCb.setFont(new Font("Tahoma", Font.BOLD, 14));
		statusCb.setModel(new DefaultComboBoxModel(new String[] {"Đang Thuê", "Chưa Thuê", "Đặt Trước"}));
		statusCb.setBounds(128, 398, 161, 35);
		frmThu.getContentPane().add(statusCb);
		
		cuahangIdTxt = new JTextField();
		cuahangIdTxt.setEditable(false);
		cuahangIdTxt.setColumns(10);
		cuahangIdTxt.setBounds(128, 240, 161, 35);
		frmThu.getContentPane().add(cuahangIdTxt);
		
		JButton datraBtn = new JButton("Đã Trả");
		datraBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		datraBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cccd == "") {
					getHoaDonListByStatus("Đã Trả");
				}
				getHoaDonByCccdAndStatus(cccd, "Đã trả");
			}
		});
		datraBtn.setBounds(862, 91, 87, 35);
		frmThu.getContentPane().add(datraBtn);
		
		JButton dangthueBtn = new JButton("Đang Thuê");
		dangthueBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cccd == "") {
					getHoaDonListByStatus("Đang Thuê");
				}
				getHoaDonByCccdAndStatus(cccd, "Đang Thuê");
			}
		});
		dangthueBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		dangthueBtn.setBounds(756, 91, 105, 35);
		frmThu.getContentPane().add(dangthueBtn);
		
		JButton dahuyBtn = new JButton("Đã Hủy");
		dahuyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cccd == "") {
					getHoaDonListByStatus("Đã Hủy");
				}
				getHoaDonByCccdAndStatus(cccd, "Đã Hủy");
			}
		});
		dahuyBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		dahuyBtn.setBounds(949, 91, 105, 35);
		frmThu.getContentPane().add(dahuyBtn);
		
		JButton btnSearchByHdid = new JButton("");
		btnSearchByHdid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hdidTxt.getText()=="") {
					allHoaDonList();
				}
				else if(quanly.checkHoaDon(hdidTxt.getText()) && hdidTxt.getText()=="") {
					getHoaDonListById(hdidTxt.getText());
				}
				else
					JOptionPane.showMessageDialog(btnSearchByHdid, "Không tồn tại mã hóa đơn");
			}
		});
		btnSearchByHdid.setBounds(249, 128, 40, 35);
		frmThu.getContentPane().add(btnSearchByHdid);
		
		searchTxt = new JTextField();
		searchTxt.setColumns(10);
		searchTxt.setBounds(511, 90, 195, 35);
		frmThu.getContentPane().add(searchTxt);
		
		JButton btnSearchByCccd = new JButton("");
		btnSearchByCccd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cccd = cccdTxt.getText();
				getHoaDonListByCccd(cccd);
			}
		});
		btnSearchByCccd.setBounds(706, 89, 40, 36);
		frmThu.getContentPane().add(btnSearchByCccd);
		
		JLabel lblNewLabel_3 = new JLabel("Tìm kiếm bằng CCCD/CMND");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_3.setBounds(511, 74, 195, 14);
		frmThu.getContentPane().add(lblNewLabel_3);
		
		JButton huyBtn = new JButton("Hủy");
		huyBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		huyBtn.setBounds(857, 449, 108, 35);
		frmThu.getContentPane().add(huyBtn);
		
		JLabel lblNewLabel_3_1 = new JLabel("-- Lọc Theo Trạng Thái --  ");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_3_1.setBounds(756, 74, 298, 14);
		frmThu.getContentPane().add(lblNewLabel_3_1);
		
		JButton traxeBtn = new JButton("Xác Nhận Trả Xe");
		traxeBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		traxeBtn.setBounds(299, 449, 161, 35);
		frmThu.getContentPane().add(traxeBtn);
		
	}
	

};


