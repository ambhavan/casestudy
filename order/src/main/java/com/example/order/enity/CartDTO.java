package com.example.order.enity;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="cart")
public class CartDTO 
{
	@Id
	private String cartId;
	private String customerId;
	private double totalPrice;
	private List<ItemDTO> itemDTO;
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<ItemDTO> getItemDTO() {
		return itemDTO;
	}
	public void setItemDTO(List<ItemDTO> itemDTO) {
		this.itemDTO = itemDTO;
	}
	public CartDTO(String customerId, double totalPrice, List<ItemDTO> itemDTO) {
	
		this.customerId = customerId;
		this.totalPrice = totalPrice;
		this.itemDTO = itemDTO;
	}
	
}
	
	