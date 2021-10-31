package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Product 
{
	private int productID;
	private String name;
	private String description;
	private int price;
	private int stock;
	
	public Product()
	{
		
	}
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
		PreparedStatement preparedStatement = connect.getPrepareStatement("INSERT INTO PRODUCT(PROD_NAME, PROD_DESC, PROD_PRICE, PROD_STOCK) VALUES(?, ?, ?, ?)");
		try {
			preparedStatement.setString(1, this.getName());
			preparedStatement.setString(2,  this.getDescription());
			preparedStatement.setInt(3, this.getPrice());
			preparedStatement.setInt(4, this.getStock());
			preparedStatement.execute();
			return this;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error occured while inserting data.", "ERROR", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Product> getAllProducts()
	{
		List<Product> allProducts = new ArrayList<>();
		ResultSet rs = Connect.getConnection().executeQuery("PRODUCT");
		
		try {
			while(rs.next())
			{
				Product p = new Product();
				p.setProductID(rs.getInt("PROD_ID"));
				p.setName(rs.getString("PROD_NAME"));
				p.setDescription(rs.getString("PROD_DESC"));
				p.setPrice(rs.getInt("PROD_PRICE"));
				p.setStock(rs.getInt("PROD_STOCK"));
				allProducts.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allProducts;
	}
	
	public Product getProduct(int productID)
	{
		Connect connect = Connect.getConnection();
		PreparedStatement preparedStatement = connect.getPrepareStatement("SELECT * FROM PRODUCT WHERE PROD_ID=?");
		try {
			preparedStatement.setInt(1, productID);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next())
			{
				Product p = new Product();
				p.setProductID(rs.getInt("PROD_ID"));
				p.setName(rs.getString("PROD_NAME"));
				p.setDescription(rs.getString("PROD_DESC"));
				p.setPrice(rs.getInt("PROD_PRICE"));
				p.setStock(rs.getInt("PROD_STOCK"));
				return p;
			}
			JOptionPane.showMessageDialog(null, "No Product found", "WARNING", JOptionPane.WARNING_MESSAGE);
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Product updateProduct() 
	{
		Connect connect = Connect.getConnection();
		PreparedStatement preparedStatement = connect.getPrepareStatement("UPDATE PRODUCT SET PROD_NAME =?, PROD_DESC=?, PROD_PRICE=?, PROD_STOCK=? WHERE PROD_ID=" + getProductID() +";");
		try {
			preparedStatement.setString(1, getName());
			preparedStatement.setString(2, getDescription());
			preparedStatement.setInt(3,  getPrice());
			preparedStatement.setInt(4,  getStock());
			preparedStatement.executeUpdate();
			return this;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean deleteProduct() 
	{
		Connect connect = Connect.getConnection();
		PreparedStatement preparedStatement = connect.getPrepareStatement("DELETE FROM PRODUCT WHERE PROD_ID=" + getProductID() + ";");
		try {
			return !preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
