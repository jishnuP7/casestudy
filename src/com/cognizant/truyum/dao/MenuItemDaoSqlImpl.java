package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemDao{
	private static PreparedStatement preps=null;
	@Override
	public List<MenuItem> getMenuItemListAdmin(){
		List<MenuItem> menuItemList=new ArrayList<>();
		try {
			Connection con=ConnectionHandler.getConnection();
			String qry="select * from MENU_ITEM";
			preps=con.prepareStatement(qry);
			ResultSet rs=preps.executeQuery();
			while(rs.next()) {
				long id=rs.getLong(1);
				String name=rs.getString(2);
				float price=rs.getFloat(3);
				boolean active=rs.getBoolean(4);
				Date dateOfLaunch=rs.getDate(5);
				String category=rs.getString(6);
				boolean freeDelivery=rs.getBoolean(7);
				MenuItem menuItem=new MenuItem(id,name,price,active,dateOfLaunch,category,freeDelivery);
				menuItemList.add(menuItem);
				
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return menuItemList;
		
	}
	@Override
	public List<MenuItem> getMenuItemListCustomer(){
		List<MenuItem> menuItemList=new ArrayList<>();
		try {
			Connection con=ConnectionHandler.getConnection();
			String qry="select * from MENU_ITEM where active=TRUE && date_of_launch<now()";
			preps=con.prepareStatement(qry);
			ResultSet rs=preps.executeQuery();
			while(rs.next()) {
				long id=rs.getLong(1);
				String name=rs.getString(2);
				float price=rs.getFloat(3);
				boolean active=rs.getBoolean(4);
				Date dateOfLaunch=rs.getDate(5);
				String category=rs.getString(6);
				boolean freeDelivery=rs.getBoolean(7);
				MenuItem menuItem=new MenuItem(id,name,price,active,dateOfLaunch,category,freeDelivery);
				menuItemList.add(menuItem);
				
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return menuItemList;
		
		
		
	}
	@Override
	public MenuItem getMenuItem(long menuItemId){
		MenuItem menuItem=null;
		try {
			Connection con=ConnectionHandler.getConnection();
			String qry="select * from MENU_ITEM where id=?";
			preps=con.prepareStatement(qry);
			preps.setLong(1, menuItemId);
			
			ResultSet rs=preps.executeQuery();
			while(rs.next()) {
				long id=rs.getLong(1);
				String name=rs.getString(2);
				float price=rs.getFloat(3);
				boolean active=rs.getBoolean(4);
				Date dateOfLaunch=rs.getDate(5);
				String category=rs.getString(6);
				boolean freeDelivery=rs.getBoolean(7);
				menuItem=new MenuItem(id,name,price,active,dateOfLaunch,category,freeDelivery);
				
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return menuItem;
		
	}
	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		Connection con;
		try {
			con = ConnectionHandler.getConnection();
			String qry="update menu_item set item_name=?,price=?,active=?,date_of_launch=?,category=?,free_delivery=? where id=?";
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			preps=con.prepareStatement(qry);
			
			preps.setString(1, menuItem.getName());
			preps.setFloat(2, menuItem.getPrice());
			preps.setBoolean(3, menuItem.isActive());
			preps.setString(4, format.format(menuItem.getDateOfLaunch()));
			preps.setString(5, menuItem.getCategory());
			preps.setBoolean(6, menuItem.isFreeDelivery());
			preps.setLong(7, menuItem.getId());
			
			preps.executeUpdate();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
