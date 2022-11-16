package src.BLL;

import java.util.Vector;

import src.DAL.BicycleDAL;
import src.DAL.TransactionDAL;
import src.DTO.TransactionDTO;


public class TransactionBLL {
	TransactionDAL TransactionDAL = new TransactionDAL();
	
	
	public Vector<TransactionDTO> selectTransaction(){
		return TransactionDAL.selectTransaction();
	}
	
}

