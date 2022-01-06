package com.java.cms;

public class Vendor {
	public int VendorId;
	public String VendorName;
	public String VendorState;
	public String VendorCity;
	public String VendorEmail;
	public int VendorMobile;
	public int getVendorId() {
		return VendorId;
	}
	public void setVendorId(int vendorId) {
		VendorId = vendorId;
	}
	public String getVendorName() {
		return VendorName;
	}
	public void setVendorName(String vendorName) {
		VendorName = vendorName;
	}
	public String getVendorState() {
		return VendorState;
	}
	public void setVendorState(String vendorState) {
		VendorState = vendorState;
	}
	public String getVendorCity() {
		return VendorCity;
	}
	public void setVendorCity(String vendorCity) {
		VendorCity = vendorCity;
	}
	public String getVendorEmail() {
		return VendorEmail;
	}
	public void setVendorEmail(String vendorEmail) {
		VendorEmail = vendorEmail;
	}
	public int getVendorMobile() {
		return VendorMobile;
	}
	public void setVendorMobile(int vendorMobile) {
		VendorMobile = vendorMobile;
	}
	@Override
	public String toString() {
		return "Vendor [VendorId=" + VendorId + ", VendorName=" + VendorName + ", VendorState=" + VendorState
				+ ", VendorCity=" + VendorCity + ", VendorEmail=" + VendorEmail + ", VendorMobile=" + VendorMobile
				+ "]";
    }
}
