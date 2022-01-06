package com.java.cms;

public class Menu {
	public int menuid;
	public int restaurantid;
	public String itemname;
	public String menutype;
	public int calaroies;
	public int price;
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public int getRestaurantid() {
		return restaurantid;
	}
	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getMenutype() {
		return menutype;
	}
	public void setMenutype(String menutype) {
		this.menutype = menutype;
	}
	public int getCalaroies() {
		return calaroies;
	}
	public void setCalaroies(int calaroies) {
		this.calaroies = calaroies;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Menu [menuid=" + menuid + ", restaurantid=" + restaurantid + ", itemname=" + itemname + ", menutype="
				+ menutype + ", calaroies=" + calaroies + ", price=" + price + "]";
	}
}