package com.java.cms;

public class Restaurant {
	
	public int RestaurantId;
	public String RestaurantName;
	public String city;
	public String branch;
	public String email;
	public int contactno;
	public int getRestaurantId() {
		return RestaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		RestaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return RestaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		RestaurantName = restaurantName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getContactno() {
		return contactno;
	}
	public void setContactno(int contactno) {
		this.contactno = contactno;
	}
	@Override
	public String toString() {
		return "Restaurant [RestaurantId=" + RestaurantId + ", RestaurantName=" + RestaurantName + ", city=" + city
				+ ", branch=" + branch + ", email=" + email + ", contactno=" + contactno + "]";
	}
	
}
