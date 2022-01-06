package com.java.cms;

public class Customer {
 
	public int CustomerId;
	public String CustomerName;
	public String CustomerState;
	public String CustomerCity;
	public String CustomerEmail;
	public int CustomerMobile;
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getCustomerState() {
		return CustomerState;
	}
	public void setCustomerState(String customerState) {
		CustomerState = customerState;
	}
	public String getCustomerCity() {
		return CustomerCity;
	}
	public void setCustomerCity(String customerCity) {
		CustomerCity = customerCity;
	}
	public String getCustomerEmail() {
		return CustomerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		CustomerEmail = customerEmail;
	}
	public int getCustomerMobile() {
		return CustomerMobile;
	}
	public void setCustomerMobile(int customerMobile) {
		CustomerMobile = customerMobile;
	}
	@Override
	public String toString() {
		return "Customer [CustomerId=" + CustomerId + ", CustomerName=" + CustomerName + ", CustomerState="
				+ CustomerState + ", CustomerCity=" + CustomerCity + ", CustomerEmail=" + CustomerEmail
				+ ", CustomerMobile=" + CustomerMobile + "]";
	}
	
}