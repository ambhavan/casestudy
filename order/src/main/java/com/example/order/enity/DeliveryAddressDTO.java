package com.example.order.enity;



import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class DeliveryAddressDTO 
{
	private String customerId;
	private String fullName;
	private long mobileNo;
	private int flatNo;
	private String city;
	private int pinCode;
	private String state;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public int getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(int flatNo) {
		this.flatNo = flatNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public DeliveryAddressDTO(String customerId, String fullName, long mobileNo, int flatNo, String city, int pinCode,
			String state) {
		super();
		this.customerId = customerId;
		this.fullName = fullName;
		this.mobileNo = mobileNo;
		this.flatNo = flatNo;
		this.city = city;
		this.pinCode = pinCode;
		this.state = state;
	}
	
	
	
	
}
