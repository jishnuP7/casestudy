package com.cognizant.truyum.dao;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;
//import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionlmplTest {
	static MenuItemDao obj=new MenuItemDaoCollectionlmpl();
	public static void main(String[] args) {
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
		MenuItem menuItem = new MenuItem(1, "Pizza", 80.00f, true,new  DateUtil().convertToDate("11/12/2017"), "Main Course", false);
		MenuItemDaoCollectionlmpl menuItemDaoCollectionImpl = new MenuItemDaoCollectionlmpl();
		MenuItemDao menuItemDao = menuItemDaoCollectionImpl;
		menuItemDao.modifyMenuItem(menuItem);
		System.out.println(menuItemDao.getMenuItem(1));
		
	}
	
	
	}
	
		



