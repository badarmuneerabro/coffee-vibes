package controller;

import java.sql.PreparedStatement;
import java.util.List;

import javax.swing.JOptionPane;

import model.Connect;
import model.Product;

public class ProductHandler 
{
	private static ProductHandler productHandler;
	private ProductHandler()
	{
		
	}
	public static ProductHandler getInstance()
	{
		return ((productHandler == null) ? productHandler = new ProductHandler() : productHandler);
	}
	public Product  insertProdcut(String name, String description, int price, int stock)
	{
		if(name.trim().isEmpty() || description.trim().isEmpty() || price<1 || stock<0)
		{
			return null;
		}
		else
		{
			Product p = new Product();
			p.setName(name);
			p.setDescription(description);
			p.setPrice(price);
			p.setStock(stock);
			return p.insertNewProdut();
		}
	}
	
	public List<Product> getAllProducts()
	{
		return null;
	}
	
	public Product updateProduct(int productID, String name, String description, int price, int stock)
	{
		Product p = new Product();
		p.setProductID(productID);
		return p.updateProduct();
	}
	
	public Product getProduct(int productID)
	{
		return null;
	}
	
	public Product deleteProduct(int productID)
	{
		Product p = new Product();
		p.setProductID(productID);
		boolean isDeleted = p.deleteProduct();
		if(isDeleted) JOptionPane.showMessageDialog(null, "Employee Deleted Successfully...", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		return null;
	}

}
