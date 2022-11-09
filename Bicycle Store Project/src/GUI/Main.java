package src.GUI;

import java.awt.EventQueue;

import src.DAL.ConnectDatabase;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserHomePage openPage = new UserHomePage();
					openPage.frame.setVisible(true);
					ConnectDatabase connect = new ConnectDatabase();
					if(connect.openConection()) {
						System.out.println("Ket noi database thanh cong");
					}
					else {
						System.out.println("Ket noi database that bai");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				//nguyen minh thong
				//huynh anh tuan
			}
		});
	}
}
