package mvcdemo.model;

import java.util.ArrayList;
import java.util.HashMap;

public class SessionCart {
	
	private HashMap<Integer, ItemInCart> itemsInMyCart;
	
	public SessionCart() 
	{
		itemsInMyCart = new HashMap<Integer, ItemInCart>();
	}

	public HashMap<Integer, ItemInCart> getCartItems_Hash() {
		return itemsInMyCart;
	}

	public void setCartItems(HashMap<Integer, ItemInCart> itemsInCart) {
		this.itemsInMyCart = itemsInCart;
	}
	
	public ItemInCart addMovieToCart(Movie m, int q){
		if(itemsInMyCart.containsKey(m.getId())){
			ItemInCart secondItemsInCart = itemsInMyCart.get(m.getId());
			secondItemsInCart.addQuantity(q);
			
			return secondItemsInCart;
		}
		else{
			ItemInCart secondItemsInCart = new ItemInCart(m,q);
			itemsInMyCart.put(m.getId(), secondItemsInCart);
			return secondItemsInCart;
		}
	}
	
	public void updateQuantity(ItemInCart cart_item,int q){
		if(itemsInMyCart.containsKey(cart_item.getMovie().getId())){
			ItemInCart secondItemsInCart = itemsInMyCart.get(cart_item.getMovie().getId());
			
			secondItemsInCart.setQuantity(q);
		}
	}
	
	public void updateQuantity(Movie m, int q){
		if(itemsInMyCart.containsKey(m.getId())){
			ItemInCart secondItemsInCart = itemsInMyCart.get(m.getId());
			
			secondItemsInCart.setQuantity(q);
		}
	}
	
	public void removeFromCart(ItemInCart cart_item){
		if(itemsInMyCart.containsKey(cart_item.getMovie().getId())){
			
			itemsInMyCart.remove(cart_item.getMovie().getId());
		}
	}
	
	public void removeFromCart(Movie m){
		if(itemsInMyCart.containsKey(m.getId())){
			
			itemsInMyCart.remove(m.getId());
		}
	}
	
	public void removeAll(){
		itemsInMyCart.clear();
	}
	
	public boolean exists(Movie m){
		if(itemsInMyCart.containsKey(m.getId())){
			return true;
		}
		else{
			return false;
		}
	}
	
	public ArrayList<ItemInCart> getCartItems_Array(){
		
		return new ArrayList<ItemInCart>(itemsInMyCart.values());
	}
	
	
	

}
