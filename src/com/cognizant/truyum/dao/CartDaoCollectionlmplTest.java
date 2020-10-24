package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionlmplTest {
	public static void main(String[] args) {
		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();
	}

	public static void testAddCartItem() {
		CartDaoCollectionlmpl cartDaoCollectionImpl=new CartDaoCollectionlmpl();
		CartDao cartDao=cartDaoCollectionImpl;
		cartDao.addCartItem(1,1);
		List<MenuItem> cartItem = null;
		try {
			cartItem = cartDao.getAllCartItems(1);
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cartItem.forEach(System.out::println);
		
	}
	public static void testGetAllCartItems() {
		CartDaoCollectionlmpl cartDaoCollectionImpl=new CartDaoCollectionlmpl();
		CartDao cartDao=cartDaoCollectionImpl;
		List<MenuItem> cartItem = null;
		try {
			cartItem = cartDao.getAllCartItems(1);
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cartItem.forEach(System.out::println);
		
	}
	public static void testRemoveCartItem() {
		CartDaoCollectionlmpl cartDaoCollectionImpl=new CartDaoCollectionlmpl();
		CartDao cartDao=cartDaoCollectionImpl;
		cartDao.removeCartItem(1,1);
		List<MenuItem> cartItem;
		try {
			cartItem=cartDao.getAllCartItems(1);
			cartItem.forEach(System.out::println);
		}catch(CartEmptyException e) {
			e.printStackTrace();
		}
		
	}


}
