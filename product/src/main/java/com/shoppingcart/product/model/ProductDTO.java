package com.shoppingcart.product.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="products")
public class ProductDTO {
	
	@Id
	private String productId;
	private String productType;
	private String productName;
	private String category;
	private Map<Integer,Double> rating = new HashMap<>();
	private List<String> image;
	private int quantity;
	private double price;
	private String description;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Map<Integer, Double> getRating() {
		return rating;
	}
	public void setRating(Map<Integer, Double> rating) {
		this.rating = rating;
	}
	public List<String> getImage() {
		return image;
	}
	public void setImage(List<String> image) {
		this.image = image;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public ProductDTO(String productType, String productName, String category, Map<Integer, Double> rating,
			List<String> image, int quantity, double price, String description) {
		
		this.productType = productType;
		this.productName = productName;
		this.category = category;
		this.rating = rating;
		this.image = image;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
	}
	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}
	
}
	