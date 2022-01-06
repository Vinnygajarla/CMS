package com.java.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
 Connection connection;
 PreparedStatement pst;
 
 public List<Customer> showCustomer() throws ClassNotFoundException, SQLException{
	 connection=ConnectionHelper.getConnection();
	 String cmd="select * from Customer";
	 pst= connection.prepareStatement(cmd);
	 ResultSet rs=pst.executeQuery();
	 List<Customer> customerList=new ArrayList<Customer>();
	 Customer customer =null;
	 while(rs.next()) {
		 customer = new Customer();
		 customer.setCustomerId(rs.getInt("customerId"));
		 customer.setCustomerName(rs.getString("customername"));
		 customer.setCustomerState(rs.getString("Customerstate"));
		 customer.setCustomerCity(rs.getString("customercity"));
		 customer.setCustomerEmail(rs.getString("customeremail"));
		 customer.setCustomerMobile(rs.getInt("customermobile"));
		 customerList.add(customer); 
		 }
	return customerList;	 
 }
 
 public Customer searchCustomer(int CustomerId ) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Customer where CustomerId=? ";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1,CustomerId);
		ResultSet rs = pst.executeQuery();
		Customer customer =null;
		 if(rs.next()) {
			 customer = new Customer();
			 customer.setCustomerId(rs.getInt("customerId"));
			 customer.setCustomerName(rs.getString("customername"));
			 customer.setCustomerState(rs.getString("Customerstate"));
			 customer.setCustomerCity(rs.getString("customercity"));
			 customer.setCustomerEmail(rs.getString("customeremail"));
			 customer.setCustomerMobile(rs.getInt("customermobile"));
		 }
		return customer;	 
	
	}
 public String addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		connection= ConnectionHelper.getConnection();
		String cmd="Insert into Customer(customerid,customername,customerstate,customercity,customermail,customermobile)"+
		              "values (?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1,customer.getCustomerId());
		pst.setString(2,customer.getCustomerName());
		pst.setString(3,customer.getCustomerState());	
		pst.setString(4,customer .getCustomerCity());
		pst.setString(5,customer.getCustomerEmail());
		pst.setInt(6,customer.getCustomerMobile());
		
		return "Record Inserted";
  
}
}
