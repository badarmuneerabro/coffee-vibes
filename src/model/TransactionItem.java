package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionItem {
	
	private int transcationID;
	private int productID;
	private int quantity;
	private static Connect connection;
	
	public TransactionItem() {
	}

	
	public TransactionItem(int transcationID, int productID, int quantity) {
		super();
		this.transcationID = transcationID;
		this.productID = productID;
		this.quantity = quantity;
	}
	
	public TransactionItem(String[] item) {
		super();
		this.transcationID = Integer.parseInt(item[0]);
		this.productID = Integer.parseInt(item[1]);
		this.quantity = Integer.parseInt(item[2]);
	}

	public int getTranscationID() 
	{
		return transcationID;
	}
	
	public void setTranscationID(int transcationID) 
	{
		this.transcationID = transcationID;
	}
	
	public int getProductID() 
	{
		return productID;
	}
	
	public void setProductID(int productID) 
	{
		this.productID = productID;
	}
	
	public int getQuantity() 
	{
		return quantity;
	}
	
	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}
	
	public static List<TransactionItem> getAllTransactionItems(int transactionID) {
		List<TransactionItem> list = new ArrayList<TransactionItem>();
		try {
			connection = Connect.getConnection();
			ResultSet rs = connection.executeQuery("TRANS_DETAIL");
			while(rs.next()) {
				if(rs.getInt("TRANS_ID") == transactionID) {
					list.add(new TransactionItem(
							rs.getInt("TRANS_ID"),
							rs.getInt("PRODUCT_ID"),
							rs.getInt("QUANTITY")
							));
				}
			}
		}catch(Exception e) {
			System.out.println("Exception Raised in TransactionItem class saying : "+e.getMessage());
		}
		return list;		
	}
	public String toString() {
		return transcationID+" "+productID+" "+quantity;
	}
	
	/*
	 * 
	 * 
	 * ========================================================
	 * ========================================================
	 * 
	 * new method is defined
	 * 
	 * 
	 * =======================================================
	 * =======================================================
	 * 
	 * 
	 * 
	 */
	public void insertIntoTransactionDetails() {
		try {
			connection = Connect.getConnection();
			PreparedStatement prepareStatement = 
					connection.getPrepareStatement("INSERT INTO TRANS_DETAIL(TRANS_ID,PRODUCT_ID,QUANTITY) VALUES (?,?,?)");
			prepareStatement.setInt(1, this.getTranscationID());
			prepareStatement.setInt(2, this.getProductID());
			prepareStatement.setInt(3, this.getQuantity());	
			prepareStatement.execute();
		}catch(SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
