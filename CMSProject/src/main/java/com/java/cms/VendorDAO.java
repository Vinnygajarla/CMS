package com.java.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendorDAO {
Connection connection;
PreparedStatement pst;

public List<Vendor> showVendor() throws ClassNotFoundException, SQLException{
	connection = ConnectionHelper.getConnection();
	String cmd="select * from Vendor";
	pst=connection.prepareStatement(cmd);
	ResultSet rs=pst.executeQuery();
	List<Vendor> vendorList=new ArrayList<Vendor>();
	Vendor vendor = null;
	while(rs.next()) {
		vendor = new Vendor();
		vendor.setVendorId(rs.getInt("vendorId"));
		vendor.setVendorName(rs.getString("vendorname"));
		vendor.setVendorState(rs.getString("vendorstate"));
		vendor.setVendorCity(rs.getString("vendorcity"));
		vendor.setVendorEmail(rs.getString("vendoremail"));
		vendor.setVendorMobile(rs.getInt("vendormobile"));
		vendorList.add(vendor);
	}
	return vendorList;
	
}
public Vendor searchVendor(int VendorId) throws ClassNotFoundException, SQLException {
	connection = ConnectionHelper.getConnection();
	String cmd = "select * from Vendor where VendorId=?";
	pst = connection.prepareStatement(cmd);
	pst.setInt(1, VendorId);
	ResultSet rs = pst.executeQuery();
	Vendor vendor = null;
	if(rs.next()) {
		vendor = new Vendor();
		vendor.setVendorId(rs.getInt("vendorId"));
		vendor.setVendorName(rs.getString("vendorname"));
		vendor.setVendorState(rs.getString("vendorstate"));
		vendor.setVendorCity(rs.getString("vendorcity"));
		vendor.setVendorEmail(rs.getString("vendoremail"));
		vendor.setVendorMobile(rs.getInt("vendormobile"));
		
	}
	return vendor;
}

public String addVendor(Vendor vendor) throws ClassNotFoundException, SQLException {
	connection= ConnectionHelper.getConnection();
	String cmd="Insert into Vendor(vendorId,vendorname,vendorstate,vendorcity,vendorcity,vendoremail,vendormoile)"+
	              "values (?,?,?,?,?,?)";
	pst = connection.prepareStatement(cmd);
	pst.setInt(1,vendor.getVendorId());
	pst.setString(2, vendor.getVendorName());
	pst.setString(3, vendor.getVendorState());
	pst.setString(4, vendor.getVendorCity());
	pst.setString(5, vendor.getVendorEmail());
	pst.setInt(6,vendor.getVendorMobile());
	return "Record Inserted";
	
}
}
