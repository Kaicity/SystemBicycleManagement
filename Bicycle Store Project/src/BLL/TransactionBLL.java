package src.BLL;

import java.util.Vector;

import src.DAL.BicycleDAL;
import src.DAL.TransactionDAL;
import src.DTO.Transaction;


public class TransactionBLL {
	TransactionDAL TransactionDAL = new TransactionDAL();
	
	
	public Vector<Transaction> selectTransaction(){
		return TransactionDAL.selectTransaction();
	}
	
}

