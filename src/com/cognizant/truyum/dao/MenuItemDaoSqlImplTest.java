package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {
	private static MenuItemDaoSqlImpl menuItemDao=new MenuItemDaoSqlImpl();
	public static void main(String[] args){
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
		testGetMenuItem();
		
	}

	public static void testGetMenuItem() {
		// TODO Auto-generated method stub
		MenuItem menuItem = menuItemDao.getMenuItem(2);
		if(menuItem==null) {
			System.out.println("No item");
		}
		System.out.println(menuItem);
		
		
	}

	public static void testModifyMenuItem() {
		// TODO Auto-generated method stub
		MenuItem menuItem=new MenuItem(1,"pizza",30.0f,true,new DateUtil().convertToDate("15/06/2020"),"Desert",true);
		menuItemDao.modifyMenuItem(menuItem );
		
	}

	public static void testGetMenuItemListCustomer() {
		// TODO Auto-generated method stub
		List<MenuItem> customerList=new ArrayList<>();
		customerList.forEach(System.out::println);
	}

	public static void testGetMenuItemListAdmin() {
		// TODO Auto-generated method stub
		List<MenuItem> adminList=new ArrayList<>();
		adminList.forEach(System.out::println);
		
	}

}
