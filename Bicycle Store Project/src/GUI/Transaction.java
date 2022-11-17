package src.GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import src.BLL.TransactionBLL;
import src.DAL.TransactionDAL;
import src.DTO.Store;

public class Transaction {

	public JFrame frmlichsu;
	private JTable table;
	private TransactionBLL TransactionBLL = new TransactionBLL();
	private JButton btnCHECK;
	
	private DefaultTableModel dTable = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transaction window = new Transaction();
					window.frmlichsu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Transaction() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmlichsu = new JFrame();
		frmlichsu.setTitle("LỊCH SỬ GIAO DỊCH");
		frmlichsu.setBounds(100, 100, 796, 509);
		frmlichsu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmlichsu.getContentPane().setLayout(null);
		frmlichsu.setLocationRelativeTo(frmlichsu);
		
		JLabel lblNewLabel = new JLabel("LỊCH SỬ GIAO DỊCH");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(73, 11, 299, 39);
		frmlichsu.getContentPane().add(lblNewLabel);
		
		table = new JTable();
		table.setModel(dTable);
		dTable.addColumn("STT");
		dTable.addColumn("Mã HD ");
		dTable.addColumn("Mã Xe");
		dTable.addColumn("Status");
		dTable.addColumn("Ngày thuê");
		dTable.addColumn("Ngày trả");
		table.setBounds(100, 100, 500, 429);
		frmlichsu.getContentPane().add(table);
		
		
		
		JScrollPane sp1 = new JScrollPane(table);
		sp1.setBounds(10, 71, 762, 295);
		frmlichsu.getContentPane().add(sp1);
		
		JButton btnCHECK = new JButton("CHECK");
		btnCHECK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dTable.getDataVector().removeAllElements();
				Vector<src.DTO.Transaction> arr = TransactionBLL.selectTransaction();
				int count = 1;
				
				for(int i = 0;i < arr.size(); i++) {	
					src.DTO.Transaction Transaction =  arr.get(i);
					String id = Transaction.getId();
					String idxe = Transaction.getIdBicycle();
					String Status = Transaction.getStatus();
					String rentDate = Transaction.getRentDate();
					String returnDate = Transaction.getReturnDate();
					
					dTable.addRow(new Object[] {
							count++, id, idxe, Status, rentDate, returnDate
					});
				}
			}
			
		});
		
		
		btnCHECK.setBounds(33, 391, 200, 50);
		frmlichsu.getContentPane().add(btnCHECK);
		
		JButton btnCHECK_1 = new JButton("Thoát");
		btnCHECK_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserHomePage home = new UserHomePage();
				home.frame.setVisible(true);
				
				frmlichsu.setVisible(false);
				
			}
			
		});
		btnCHECK_1.setBounds(263, 391, 200, 50);
		frmlichsu.getContentPane().add(btnCHECK_1);
	}
}
