package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Product 
{
	private int productID;
	private String name;
	private String description;
	private int price;
	private int stock;
	public int getProductID() 
	{
		return productID;
	}
	public void setProductID(int productID) 
	{
		this.productID = productID;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getDescription() 
	{
		return description;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}
	public int getPrice() 
	{
		return price;
	}
	public void setPrice(int price) 
	{
		this.price = price;
	}
	public int getStock() 
	{
		return stock;
	}
	public void setStock(int stock) 
	{
		this.stock = stock;
	}
	
	public Product insertNewProdut()
	{
		Connect connect = Connect.getConnection();
		PreparedStatement preparedStatement = connect.getPrepareStatement("INSERT INTO PRODUCT(PROD_NAME, PROD_DESC, PROD_PRICE, PROD_STOCK) VALUES(?,?, ?, ?)");
		try {
			preparedStatement.setString(1, this.getName());
			preparedStatement.setString(2,  this.getDescription());
			preparedStatement.setInt(3, this.getPrice());
			preparedStatement.setInt(4, this.getStock());
			return this;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Product> getAllProducts()
	{
		return null;
	}
	
	public Product getProduct(int productID)
	{
		return null;
	}
	
	public Product updateProduct() 
	{
		return null;
	}
	
	public boolean deleteProduct() 
	{
		return false;
	}
}
