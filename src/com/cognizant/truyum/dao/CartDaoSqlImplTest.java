package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {
	private static CartDaoSqlImpl cartDao=new CartDaoSqlImpl();
	//private static CartDaoSqlImpl cartDao=new CartDaoSqlImpl();
	public static void main(String[] args) throws CartEmptyException {
		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();
	}

	public static void testRemoveCartItem() {
		cartDao.removeCartItem(1,2);
		cartDao.removeCartItem(2,2);
		
	
	}

	public static void testGetAllCartItems() throws CartEmptyException {
		// TODO Auto-generated method stub
		
		//@SuppressWarnings("unused")
		List<MenuItem> cartList=new ArrayList<>();
		cartList=cartDao.getAllCartItems(2);
		List<MenuItem> menuItemList = cartDao.getAllCartItems(2);
		for(MenuItem item : menuItemList) {
			System.out.println(item);
		}
		
	}

	public static void testAddCartItem() {
		// TODO Auto-generated method stub
		
		cartDao.addCartItem(1,2);
		cartDao.addCartItem(2,2);
		
	}


}
