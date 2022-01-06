package com.java.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO {

	Connection connection;
	PreparedStatement pst;
	
public List<Menu> showMenu(int restaurantid) throws ClassNotFoundException, SQLException {
	connection = ConnectionHelper.getConnection();
	String cmd = "select * from Menu where restaurantid=?";
	pst = connection.prepareStatement(cmd);
	pst.setInt(1, restaurantid);
	ResultSet rs = pst.executeQuery();
	List<Menu> menuList = new ArrayList<Menu>();
	Menu menu = null;
	while(rs.next()) {
		menu = new Menu();
		menu.setMenuid(rs.getInt("menuid"));
		menu.setRestaurantid(rs.getInt("restaurantid"));
		menu.setItemname(rs.getString("itemname"));
		menu.setMenutype(rs.getString("menutype"));	
		menu.setCalaroies(rs.getInt("calaroies"));
		menu.setPrice(rs.getInt("price"));
		menuList.add(menu);
		
	}
	return menuList;	
}

public Menu searchMenu(int menuid) throws ClassNotFoundException, SQLException {
	connection = ConnectionHelper.getConnection();
	String cmd = "select * from menu where menuid=? ";
	pst = connection.prepareStatement(cmd);
	pst.setInt(1,menuid);
	ResultSet rs = pst.executeQuery();
	Menu menu = null;
	if(rs.next()) {
		menu = new Menu();
		menu.setMenuid(rs.getInt("menuid"));
		menu.setRestaurantid(rs.getInt("restaurantid"));
		menu.setItemname(rs.getString("itemname"));
		menu.setMenutype(rs.getString("menutype"));	
		menu.setCalaroies(rs.getInt("calaroies"));
		menu.setPrice(rs.getInt("price"));
		}
	
	return menu;
}

public String addMenu(Menu menu) throws ClassNotFoundException, SQLException {
	connection= ConnectionHelper.getConnection();
	String cmd="Insert into Menu(menuid,restaurantid,itemname,menutype,caloroies,price)"+
	              "values (?,?,?,?,?,?)";
	pst = connection.prepareStatement(cmd);
	pst.setInt(1,menu.getMenuid());
	pst.setInt(2, menu.getRestaurantid());
	pst.setString(3,menu.getItemname());
	pst.setString(4, menu.getMenutype());
	pst.setInt(5, menu.getCalaroies());
	pst.setInt(6,menu.getPrice());
	
	return "Record Inserted";
	
}
}