package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Transaction{
	
	private int transactionID;
	private Date purchaseDate;
	private String voucherCode;
	private int employeeID;
	private int totalPrice;
	private int transactionListItemNumber;
	
	private Connect connection;
	
	
	public Transaction() {
	}

	public Transaction(int transactionID, Date purchaseDate, String voucherCode, int employeeID, int totalPrice, int transactionListItemNumber) {
		super();
		this.transactionID = transactionID;
		this.purchaseDate = purchaseDate;
		this.voucherCode = voucherCode;
		this.employeeID = employeeID;
		this.totalPrice = totalPrice;		
		this.transactionListItemNumber = transactionListItemNumber;
	}

	
	public int getTransactionID() 
	{
		return transactionID;
	}
	
	public void setTransactionID(int transactionID) 
	{
		this.transactionID = transactionID;
	}
	
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	
	public void setPurchaseDate(Date purchaseDate) 
	{
		this.purchaseDate = purchaseDate;
	}
	
	public String getVoucherID() 
	{
		return voucherCode;
	}
	
	public void setVoucherID(String voucherCode) 
	{
		this.voucherCode = voucherCode;
	}
	
	public int getEmployeeID() 
	{
		return employeeID;
	}
	
	public void setEmployeeID(int employeeID) 
	{
		this.employeeID = employeeID;
	}
	
	public int getTotalPrice() 
	{
		return totalPrice;
	}
	
	public void setTotalPrice(int totalPrice) 
	{
		this.totalPrice = totalPrice;
	}
	
	public int getTransactionListItemNumber() {
		return transactionListItemNumber;
	}


	public void setTransactionListItemNumber(int transactionListItemNumber) {
		this.transactionListItemNumber = transactionListItemNumber;
	}
	
	
	public Transaction insertTransication() {
		try {
			connection = Connect.getConnection();
			PreparedStatement prepareStatement = 
					connection.getPrepareStatement("INSERT INTO TRANS_HEADER(VOUCHER_CODE,TOTAL_PRICE,EMP_ID,TRANS_ITEM) VALUES (?,?,?,?)");
			
			prepareStatement.setString(1,this.getVoucherID());
			prepareStatement.setInt(2, this.getTotalPrice());
			prepareStatement.setInt(3, this.getEmployeeID());	
			prepareStatement.setInt(4, this.getTransactionListItemNumber());
			prepareStatement.execute();
		}catch(SQLException e) 
		{
			e.printStackTrace();
		}
		return this;
	}
	
	
	public Transaction insertTransication1() {
		try {
			connection = Connect.getConnection();
			PreparedStatement prepareStatement = 
					connection.getPrepareStatement("INSERT INTO TRANS_HEADER(VOUCHER_CODE,TOTAL_PRICE,EMP_ID,TRANS_ITEM) VALUES (?,?,?,?)");
			
			prepareStatement.setString(1,this.getVoucherID());
			prepareStatement.setInt(2, this.getTotalPrice());
			prepareStatement.setInt(3, this.getEmployeeID());	
			prepareStatement.setInt(4, this.getTransactionListItemNumber());
			prepareStatement.execute();
		}catch(SQLException e) 
		{
			e.printStackTrace();
		}
		return this;
	}
	
//public Transaction insertTransication() {
//		
//		Transaction transcation = new Transaction(
//				this.getTransactionID(),
//				this.getPurchaseDate(),
//				this.getVoucherID(),
//				this.getEmployeeID(),
//				this.getTotalPrice()
//				);
//		
//		try {
//			connection = Connect.getConnection();
//			PreparedStatement prepareStatement = 
//					connection.getPrepareStatement("INSERT INTO TRANS_DETAIL(TRANS_ID,PURCH_DATE,VOUCHER_ID,TOTAL_PRICE,TRANS_ITEM,EMP_ID) VALUES (?,?,?,?,?)");
//			prepareStatement.setInt(1,this.getTransactionID());
//			prepareStatement.setDate(2, this.getPurchaseDate());
//			prepareStatement.setInt(3, this.getVoucherID());
//			prepareStatement.setInt(4, this.getTotalPrice());
//			prepareStatement.setInt(6, this.getEmployeeID());		
//			
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return transcation;
//	}
	
	
	
	public List<Transaction> getAllTransaction(){
		List<Transaction> transationList= new ArrayList<Transaction>();
		try {
			connection = Connect.getConnection();
			ResultSet resultSet = connection.executeQuery("TRANS_HEADER");
			while (resultSet.next()) {
				transationList.add(new Transaction(
						resultSet.getInt("TRANS_ID"),
						resultSet.getDate("PURCH_DATE"),
						resultSet.getString("VOUCHER_CODE"),
						resultSet.getInt("EMP_ID"),
						resultSet.getInt("TOTAL_PRICE"),
						resultSet.getInt("TRANS_ITEM")
								)
						);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return transationList;
	}
	
	
	public Transaction getTransactionDetails(int transactionID) {
		
		Transaction transicationData = null ;
		try {
			connection = Connect.getConnection();
			ResultSet resultSet = connection.executeQuery("TRANS_HEADER");
			while(resultSet.next()) {
				if(resultSet.getInt("TRANS_ID") == transactionID) {
					transicationData =  new Transaction(
							resultSet.getInt("TRANS_ID"),
							resultSet.getDate("PURCH_DATE"),
							resultSet.getString("VOUCHER_CODE"),
							resultSet.getInt("EMP_ID"),
							resultSet.getInt("TOTAL_PRICE"),
							resultSet.getInt("TRANS_ITEM")
					);
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return transicationData;
	}
	
}
