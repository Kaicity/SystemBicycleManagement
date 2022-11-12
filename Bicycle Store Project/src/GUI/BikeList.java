package src.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;

public class BikeList {

	private JFrame BikeList;
	private JTable table;
	private DefaultTableModel modelBicycle = new DefaultTableModel();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BikeList window = new BikeList();
					window.BikeList.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BikeList() {
		initialize();
		
		
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		BikeList = new JFrame();
		BikeList.setTitle("BikeList");
		BikeList.setBounds(100, 100, 461, 406);
		
		table = new JTable();
		BikeList.getContentPane().add(table, BorderLayout.CENTER);
		BikeList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		
		table.setModel(modelBicycle);
		
		modelBicycle.addColumn("STT");
		modelBicycle.addColumn("Mã xe");
		modelBicycle.addColumn("Tên xe");
		modelBicycle.addColumn("Loại xe");
		modelBicycle.addColumn("Giá thuê");
		
		modelBicycle.addRow(new Object[] {
				"1", "DUGD7ff", "Xe Vinfast điện", "Địa hình", 200.89
		});
		modelBicycle.addRow(new Object[] {
				"1", "DUGD7ff", "Xe Vinfast điện", "Địa hình", 200.89
		});
		modelBicycle.addRow(new Object[] {
				"1", "DUGD7ff", "Xe Vinfast điện", "Địa hình", 200.89
		});
		modelBicycle.addRow(new Object[] {
				"1", "DUGD7ff", "Xe Vinfast điện", "Địa hình", 200.89
		});

		
		JScrollPane sc = new JScrollPane(table);
		sc.setBounds(385, 87, 571, 234);
		BikeList.getContentPane().add(sc);
	}

}
