package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		if(name.trim().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Name can not be empty", "ERROR", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		if(description.trim().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "description can not be empty", "ERROR", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		if(price<1)
		{
			JOptionPane.showMessageDialog(null, "Price can not be empty or less <1", "ERROR", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		if(stock<0)
		{
			JOptionPane.showMessageDialog(null, "stock can not be empty or <0", "ERROR", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		Product p = new Product();
		p.setName(name);
		p.setDescription(description);
		p.setPrice(price);
		p.setStock(stock);
		return p.insertNewProdut();

	}
	
	public List<Product> getAllProducts()
	{
		Product p = new Product();
		List<Product> allProducts = p.getAllProducts();
		return allProducts;
	}
	
	public Product updateProduct(int productID, String name, String description, int price, int stock)
	{
		if(name.trim().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Name can not be empty", "ERROR", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		if(description.trim().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "description can not be empty", "ERROR", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		if(price<1)
		{
			JOptionPane.showMessageDialog(null, "Price can not be empty or less <1", "ERROR", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		if(stock<0)
		{
			JOptionPane.showMessageDialog(null, "stock can not be empty or <0", "ERROR", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		Product p = new Product();
		p.setProductID(productID);
		p.setName(name);
		p.setDescription(description);
		p.setPrice(price);
		p.setStock(stock);
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
		if(isDeleted) 
			return p;
		return null;
	}

}
