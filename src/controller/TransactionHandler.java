package controller;

import model.Connect;
import model.Transaction;
import model.TransactionItem;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class TransactionHandler {
	private static TransactionHandler instance;
	private TransactionHandler() {
		
	}
	
	public static synchronized TransactionHandler getInstance() {
		return (instance == null)? instance = new TransactionHandler() : instance;
	}
	private Connect connection;
	public void viewTransactionManagementForm() {
		
	}
	
	public Transaction insertTransaction(String voucherCode, int employeeID, int totalPayment) {
		Transaction transaction = new Transaction();
		transaction.setVoucherID(voucherCode);
		transaction.setEmployeeID(employeeID);
		transaction.setTotalPrice(totalPayment);
		
		return transaction.insertTransication();
		
	}
	
	public Transaction insertTransaction(String voucherCode, int employeeID, int totalPayment, int transItem) {
		
		System.out.println("Hello from inserTransaction().");
		Transaction transaction = new Transaction();
		transaction.setVoucherID(voucherCode);
		transaction.setEmployeeID(employeeID);
		transaction.setTotalPrice(totalPayment);
		transaction.setTransactionListItemNumber(transItem);
		return transaction.insertTransication();
	}
	
	public List<Transaction> getAllTransactions(){
		List<Transaction> list = new ArrayList<Transaction>();
		
		try {
			connection = Connect.getConnection();
			ResultSet resultSet = connection.executeQuery("TRANS_HEADER");
			

			while(resultSet.next()) 
			{
				list.add(new Transaction(
							resultSet.getInt("TRANS_ID"),
							resultSet.getDate("PURCH_DATE"),
							resultSet.getString("VOUCHER_CODE"),
							resultSet.getInt("EMP_ID"),
							resultSet.getInt("Total_PRICE"),
							resultSet.getInt("TRANS_ITEM")
						));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public TransactionItem getTransactionDetail(int transactionID) {
		Connect connection = null;
		TransactionItem transaction = null;
		try {
			connection = Connect.getConnection();
			ResultSet resultSet = connection.executeQuery("TRANS_DETAIL");
			
			while(resultSet.next()) {
				if(resultSet.getInt("TRANS_ID") == transactionID) {
					transaction = new TransactionItem(
					  resultSet.getInt("TRANS_ID"),
					  resultSet.getInt("PRODUCT_ID"),
					  resultSet.getInt("QUANTITY")
							);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return transaction;
	}
}
