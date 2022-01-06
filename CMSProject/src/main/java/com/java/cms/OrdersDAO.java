package com.java.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class OrdersDAO {
	


		Connection connection;
		PreparedStatement pst;
		
		public Orders searchOrder(int orderId) throws ClassNotFoundException, SQLException {
			connection = ConnectionHelper.getConnection();
			String cmd = "select * from Orders where  OrderId=?";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, orderId);
			ResultSet rs = pst.executeQuery();
			Orders orderFound = null;
			if (rs.next()) {
				orderFound = new Orders();
				orderFound.setOrderId(rs.getInt("OrderId"));
				orderFound.setVendorId(rs.getInt("VendorId"));
				orderFound.setCustomerId(rs.getInt("CustomerId"));
				orderFound.setMenuId(rs.getInt("MenuId"));
				orderFound.setWalletId(rs.getInt("WalletId"));
				orderFound.setOrderDate(rs.getDate("OrderDate"));
				orderFound.setQuantityOrdered(rs.getInt("QuantityOrdered"));
				orderFound.setOrderStatus(rs.getString("OrderStatus"));
				orderFound.setBillAmount(rs.getInt("BillAmount"));
				orderFound.setComments(rs.getString("Comments"));
	
			
			}
			return orderFound;
		}
		
		public String acceptOrRejectOrder(int orderId, int vendorId, String status) throws ClassNotFoundException, SQLException {
			connection = ConnectionHelper.getConnection();
			Orders order = searchOrder(orderId);
			if (order.getVendorId()==vendorId) {
				if (status.toUpperCase().equals("YES")) {
					String cmd = "Update orders set OrderStatus='ACCEPTED' "
							+ " WHERE OrderID=?";
					pst = connection.prepareStatement(cmd);
					pst.setInt(1, orderId);
					pst.executeUpdate();
					return "Order Approved Successfully...";
				} else {
					String cmd = "Update orders set OrderStatus='REJECTED' "
							+ " WHERE OrderID=?";
					pst = connection.prepareStatement(cmd);
					pst.setInt(1, orderId);
					pst.executeUpdate();
					cmd = "Update Wallet set Amount=Amount+? where walletId=?";
					pst = connection.prepareStatement(cmd);
					pst.setInt(1, order.getBillAmount());
					pst.setInt(2, order.getWalletId());
					pst.executeUpdate();
					return "Order Rejected Amount Refunded...";
				}
			} 
			return "You are unauthorized vendor...";
		}
		
		public String placeOrder(Orders order) throws SQLException, ClassNotFoundException {
			int oid = generateOrderId();
			order.setOrderStatus("PENDING");
			Menu menu = new MenuDAO().searchMenu(order.getMenuId());
			int price = menu.getPrice();
			int  billAmount = order.getQuantityOrdered() * price;
			Wallet wallet = new WalletDAO().searchByWalletId(order.getWalletId());
			int amount = wallet.getAmount();
			if (amount - billAmount > 0) {
				order.setBillAmount(billAmount);
				order.setOrderId(oid);
				String cmd = "insert into Orders(orderId,VendorId,CustomerId,MenuID,"
						+ "WalletId,OrderDate,QuantityOrdered,OrderStatus,BillAmount,Comments) "
						+ "values(?,?,?,?,?,?,?,?,?,?)";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, order.getOrderId());
				pst.setInt(2, order.getVendorId());
				pst.setInt(3, order.getCustomerId());
				pst.setInt(4, order.getMenuId());
				pst.setInt(5, order.getWalletId());
				pst.setDate(6, order.getOrderDate()); 
				pst.setInt(7, order.getQuantityOrdered());
				pst.setString(8, order.getOrderStatus());
				pst.setInt(9, order.getBillAmount());
				pst.setString(10, order.getComments());
				pst.executeUpdate();
				new WalletDAO().deductBalance(order.getWalletId(), billAmount);
				return "Order Placed Successfully...Wallet Balance Deducted...";
			}
			return "Insufficient Funds...";
			//order.setBillAmount(billAmount);
		}
		
		public int generateOrderId() throws ClassNotFoundException, SQLException {
			connection = ConnectionHelper.getConnection();
			String cmd = "select case when max(ORDERID) is NULL THEN 1"
					+ " else max(ORDERID)+1 end oid from orders";
			pst = connection.prepareStatement(cmd);
			ResultSet rs = pst.executeQuery();
			rs.next();
			int id = rs.getInt("oid");
			return id;
		}
	}

	

