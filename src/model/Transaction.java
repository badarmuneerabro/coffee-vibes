package model;

import java.util.Date;
import java.util.List;

public class Transaction {
	
	private int transactionID;
	private Date purchaseDate;
	private int voucherID;
	private int employeeID;
	private int totalPrice;
	private List<TransactionItem> listTransactionItem;
	
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
	
	public int getVoucherID() 
	{
		return voucherID;
	}
	
	public void setVoucherID(int voucherID) 
	{
		this.voucherID = voucherID;
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
	
	public List<TransactionItem> getListTransactionItem() 
	{
		return listTransactionItem;
	}
	
	public void setListTransactionItem(List<TransactionItem> listTransactionItem) 
	{
		this.listTransactionItem = listTransactionItem;
	}
	
}
