package model;

public class TransactionItem {
	
	private int transcationID;
	private int productID;
	private int quantity;
	
	
	public TransactionItem() {
		super();
	}
	
	public TransactionItem(int transcationID, int productID, int quantity) {
		super();
		this.transcationID = transcationID;
		this.productID = productID;
		this.quantity = quantity;
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
}
