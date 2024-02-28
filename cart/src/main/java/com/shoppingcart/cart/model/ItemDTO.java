package com.shoppingcart.cart.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class ItemDTO 
{
	private String productName;
	private double price;
	private int quantity;
	
	public String getProductName()
	{
		return productName;
	}
	public void setProductName(String productName)
	{
		this.productName = productName;
	}
	public double getPrice() 
	{
		return price;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	public ItemDTO(String productName, double price, int quantity) 
	{
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	public ItemDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
}
