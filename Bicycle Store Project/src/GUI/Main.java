package src.GUI;

import java.awt.EventQueue;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserHomePage openPage = new UserHomePage();
					openPage.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//nguyen minh thong
				//huynh anh tuan
			}
		});
	}
}
