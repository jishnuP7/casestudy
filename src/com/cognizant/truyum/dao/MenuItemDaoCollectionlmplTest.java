package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoCollectionlmplTest {
	static MenuItemDao obj=new MenuItemDaoCollectionlmpl();
	public void main(String[] args) {
		testGetMenuItemListAdmin();
		testGetMenuListCustomer();
		testModifyMenuItem();
		
		
	}
	public static void testGetMenuItemListAdmin() {
		List<MenuItem> menuItemList =obj.getMenuItemListAdmin();
		
		for(MenuItem itm:menuItemList) {
			System.out.println(itm);
		}
	}
	public static void testGetMenuListCustomer() {
		List<MenuItem> menuItemList=obj.getMenuItemListCustomer();
		
		for(MenuItem itm:menuItemList) {
			System.out.println(itm);
		}
	}
	public static void testModifyMenuItem() {
		
	}
	
		


}
