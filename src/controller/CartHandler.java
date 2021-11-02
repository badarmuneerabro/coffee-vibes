package controller;

import java.util.List;

import model.CartItem;
import model.Product;

public class CartHandler 
{

	private List<CartItem> itemsList;
	private static CartHandler cartHandler;
	
	private CartHandler()
	{
		
	}
	
	public static CartHandler getInstance()
	{
		return (cartHandler == null) ? cartHandler = new CartHandler() : cartHandler;
	}
	public CartItem addToCart(int productID, int quantity)
	{
		CartItem item = updateCartProductQuantity(productID, quantity);
		if(item != null)
			return item;
		
		itemsList.add(new CartItem(getProduct(productID), 1));
		return itemsList.get(itemsList.size()-1);
	}
	
	public CartItem updateCartProductQuantity(int productID, int quantity)
	{
		for(int i = 0; i<itemsList.size(); i++)
		{
			if(itemsList.get(i).getProduct().getProductID() == productID)
			{
				itemsList.get(i).setQuantity(quantity);
				return itemsList.get(i);
			}
		}
		
		return null;
	}
	public Product updateProductStock(int productID, int stock)
	{
		Product p = getProduct(productID);
		p.setStock(stock);
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
	
}
