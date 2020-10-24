package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao{
	private static PreparedStatement preps=null;
	@Override
	public void addCartItem(long userId,long menuItemId){

		try {
			Connection con = ConnectionHandler.getConnection();
			String qry= "insert into cart (cart_user_id,cart_menu_id) values(?,?)";
			PreparedStatement preps=con.prepareStatement(qry);
			preps.setLong(1, userId);
			preps.setLong(2, menuItemId);
			preps.executeUpdate();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public List<MenuItem> getAllCartItems(long userId) {
		List<MenuItem> menuList=new ArrayList<>();
		Cart cart=new Cart(menuList,0);
		double total = 0;
		try {
			
			Connection con = ConnectionHandler.getConnection();
			String qry= "select * from menu_item where id in(selelect cart_menu_id from cart cart_user_id=?)";
			preps=con.prepareStatement(qry);
			preps.setLong(1, userId);
			ResultSet rs=preps.executeQuery();
			while(rs.next()) {
				long id=rs.getLong(1);
				String name=rs.getString(2);
				float price=rs.getFloat(3);
				total=total+price;
				boolean active=rs.getBoolean(4);
				Date dateOfLaunch=rs.getDate(5);
				String category=rs.getString(6);
				boolean freeDelivery=rs.getBoolean(7);
				MenuItem menuItem=new MenuItem(id,name,price,active,dateOfLaunch,category,freeDelivery);
				menuList.add(menuItem);
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cart.setMenuItemList(menuList);
		cart.setTotal(total);
		
		
		return menuList;
		
	}
	@Override
	public void removeCartItem(long userId,long menuItemId) {
		try {
			Connection con = ConnectionHandler.getConnection();
			String qry="delete from cart where cart_user_id=? and cart_menu_id=?";
			preps=con.prepareStatement(qry);
			preps.setLong(1, userId);
			preps.setLong(2, menuItemId);
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
