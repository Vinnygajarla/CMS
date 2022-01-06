package com.java.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class RestaurantDAO {
	Connection connection;
	PreparedStatement pst;

	public List<Restaurant> showRestaurant() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Restaurant";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Restaurant> restaurantList = new ArrayList<Restaurant>();
		Restaurant restaurant = null; 
		while(rs.next()) {
			restaurant = new Restaurant();
			restaurant.setRestaurantId(rs.getInt("restaurantid"));
			restaurant.setRestaurantName(rs.getString("restaurantname"));
			restaurant.setCity(rs.getString("city"));
			restaurant.setBranch(rs.getString("branch"));
			restaurant.setEmail(rs.getString("email"));
			restaurant.setContactno(rs.getInt("contactno"));
			restaurantList.add(restaurant);
		}
		return restaurantList ;
}
	public Restaurant searchRestaurant(int restaurantId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from restaurant where restaurantId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, restaurantId);
		ResultSet rs = pst.executeQuery();
		Restaurant restaurant = null;
		if(rs.next()) {
			restaurant = new Restaurant();
			restaurant.setRestaurantId(rs.getInt("restaurantid"));
			restaurant.setRestaurantName(rs.getString("restaurantname"));
			restaurant.setCity(rs.getString("city"));
			restaurant.setBranch(rs.getString("branch"));
			restaurant.setEmail(rs.getString("email"));
			restaurant.setContactno(rs.getInt("ContactNo"));
		}
		return restaurant;
}


	public String addRestaurant(Restaurant restaurant) throws SQLException, ClassNotFoundException {
		connection = ConnectionHelper.getConnection();
		String cmd="Insert into Restaurant(restaurantid,restaurantname,city,branch,email,ContactNo)" +
		                          "values(?,?,?,?,?,?)";
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, restaurant.getRestaurantId());
		pst.setString(2,restaurant.getRestaurantName());
		pst.setString(3,restaurant.getCity());
		pst.setString(4,restaurant.getBranch());
		pst.setString(5,restaurant.getEmail());
		pst.setInt(6, restaurant.getContactno());
		return "Record Inserted";		
	}
	
	
	
	
	
	
}