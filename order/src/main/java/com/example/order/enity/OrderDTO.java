package com.example.order.enity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="order")
public class OrderDTO 
{
	@Id
	private String orderId;
	private String customerId;
	private String orderDate;
	private DeliveryAddressDTO address;
	private double totalPrice;
	private double amountPaid;
	private String modeOfPayment;
	private String orderStatus;
	private List<ItemDTO> itemDTO;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public DeliveryAddressDTO getAddress() {
		return address;
	}
	public void setAddress(DeliveryAddressDTO address) {
		this.address = address;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public List<ItemDTO> getItemDTO() {
		return itemDTO;
	}
	public void setItemDTO(List<ItemDTO> itemDTO) {
		this.itemDTO = itemDTO;
	}
	public OrderDTO(String customerId, String orderDate, DeliveryAddressDTO address, double totalPrice, double amountPaid,
			String modeOfPayment, String orderStatus, List<ItemDTO> itemDTO) {
		
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.address = address;
		this.totalPrice = totalPrice;
		this.amountPaid = amountPaid;
		this.modeOfPayment = modeOfPayment;
		this.orderStatus = orderStatus;
		this.itemDTO = itemDTO;
	}


}	