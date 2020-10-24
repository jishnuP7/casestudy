package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionlmpl implements MenuItemDao{
	private static List<MenuItem> menuItemList;
	
	public MenuItemDaoCollectionlmpl() {
		super();
		List<MenuItem> lst=new ArrayList<>();
		if(this.menuItemList==null) {
			lst.add(new MenuItem(1,"Sandwich",99.00f,true,new DateUtil().convertToDate("15/03/2017"),"Main Course",true));
			lst.add(new MenuItem(2,"Burger",129.0f,true,new DateUtil().convertToDate("23/12/2017"),"Main Course",false));
			lst.add(new MenuItem(3,"Pizza",149.0f,true,new DateUtil().convertToDate("21/08/2018"),"Main Course",false));
			lst.add(new MenuItem(4,"French Fries",57.0f,false,new DateUtil().convertToDate("02/07/2017"),"Starters",true));
			lst.add(new MenuItem(5,"Chocolate Brownie",32.0f,true,new DateUtil().convertToDate("02/11/2022"),"Desert",true));
		}
		menuItemList=lst;
	}
	public static List<MenuItem> getMenuItemList() {
		return menuItemList;
	}
	public static void setMenuItemList(List<MenuItem> menuItemList) {
		MenuItemDaoCollectionlmpl.menuItemList = menuItemList;
	}
	public MenuItemDaoCollectionlmpl(List<MenuItem> menuItemList) {
		super();
		MenuItemDaoCollectionlmpl.menuItemList = menuItemList;
		
	}
	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;
	
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer(){
		List<MenuItem> cList=new ArrayList<>();
		new DateUtil();
		Date today= new Date(); 
		for(MenuItem itm:menuItemList) {
			if(itm.isActive() && (itm.getDateOfLaunch().getTime()<=today.getTime())) {
				cList.add(itm);
				
			}
		}
		return cList;
		
	}
	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		
		for(MenuItem itm:menuItemList) {
			if(itm.equals(menuItem)) {
				itm.setId(menuItem.getId());
				itm.setName(menuItem.getName());
				itm.setPrice(menuItem.getPrice());
				itm.setActive(menuItem.isActive());
				itm.setDateOfLaunch(menuItem.getDateOfLaunch());
				itm.setCategory(menuItem.getCategory());
				itm.setFreeDelivery(menuItem.isFreeDelivery());
				
				
				itm=menuItem;
				
				
			}
		}
		menuItemList.add(menuItem);
		
	}
	@Override
	public MenuItem getMenuItem(long menuItemId) {
		
		for(MenuItem itm:menuItemList) {
			if(itm.getId()==menuItemId) {
				return itm;
			}
		}
		
		
		return null;
		
	}


}
