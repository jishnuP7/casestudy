package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionlmpl implements CartDao{
	HashMap<Long, Cart> userCarts;
	
	public CartDaoCollectionlmpl() {
		super();
		if(userCarts==null) {
			userCarts=new HashMap<Long,Cart>();
		}
		
	}
	

	@Override
	public void addCartItem(long userId, long menuItemId) {
		MenuItemDaoCollectionlmpl menuCollection=new MenuItemDaoCollectionlmpl();
		MenuItemDao menuItemDao=menuCollection;
		Long id=new Long(userId);
		MenuItem menuItem= menuItemDao.getMenuItem(menuItemId);
		
		if(userCarts.containsKey(id)) {
			Cart cart=userCarts.get(id);
			List<MenuItem> menuItemList=cart.getMenuItemList();
			menuItemList.add(menuItem);
			userCarts.get(userId).setMenuItemList(menuItemList);
			
		}
		else {
			List<MenuItem> menuItemList=new ArrayList<>();
			menuItemList.add(menuItem);
			Cart cart = new Cart(menuItemList, menuItem.getPrice());
			userCarts.put(userId, cart);
		}
		
		
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException{
		
	
		Long id=new Long(userId);
		Cart cart=userCarts.get(id);
		List<MenuItem> menuItemList = cart.getMenuItemList();
		if (menuItemList.isEmpty()) {
			throw new CartEmptyException();
		}
		double total = 0.0;
		for (MenuItem menuItem : menuItemList) {
			total += menuItem.getPrice();

		}
		cart.setTotal(total);

		
		return menuItemList;
		
		//return null;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		
		Cart cart = userCarts.get(userId);
		List<MenuItem> cartItem=cart.getMenuItemList();
		List<MenuItem> rList=new ArrayList<>();
		
		for(MenuItem menuItem: cartItem) {
			if(menuItem.getId()==menuItemId) {
				rList.remove(menuItem);
			}
		}
		
		cartItem.removeAll(rList);
		userCarts.get(userId).setMenuItemList(cartItem);
		
		
	}
	

}
