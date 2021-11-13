package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.CartItem;
import model.Product;

public class CartHandler 
{

	private List<CartItem> itemsList;
	private static CartHandler cartHandler;
	
	private CartHandler()
	{
		itemsList = new ArrayList<>();
	}
	
	public static CartHandler getInstance()
	{
		return (cartHandler == null) ? cartHandler = new CartHandler() : cartHandler;
	}
	public CartItem addToCart(int productID, int quantity)
	{
		if(quantity == 0)
		{
			JOptionPane.showMessageDialog(null, "Quantity can not be zero.");
			return null;
		}
		CartItem item = updateCartProductQuantity(productID, quantity);
		if(item != null)
			return item;
		
		itemsList.add(new CartItem(getProduct(productID), quantity));
		return itemsList.get(itemsList.size()-1);
	}
	
	public CartItem updateCartProductQuantity(int productID, int quantity)
	{
		for(int i = 0; i<itemsList.size(); i++)
		{
			if(itemsList.get(i).getProduct().getProductID() == productID)
			{
				int oldQuantity = itemsList.get(i).getQuantity();
				int newQuantity = oldQuantity + quantity;
				itemsList.get(i).setQuantity(newQuantity);
				return itemsList.get(i);
			}
		}
		
		return null;
	}
	public Product updateProductStock(int productID, int stock)
	{
		Product p = getProduct(productID);
		int pStock = p.getStock();
		p.setStock(pStock - stock);
		return p.updateProduct();
	}
	public void clearCart()
	{
		itemsList.clear();
	}
	public Product getProduct(int productID)
	{
		ProductHandler handler = ProductHandler.getInstance();
		return handler.getProduct(productID);
	}
	public boolean removeProductFromCart(int productID)
	{
		boolean isRemoved = false;
		for(int i = 0; i<=itemsList.size(); i++)
		{
			if(itemsList.get(i).getProduct().getProductID() == productID)
			{
				itemsList.remove(i);
				isRemoved = true;
				break;
			}
		}
		return isRemoved;
	}
	public List<CartItem> getList()
	{
		return itemsList;
	}
	
}
