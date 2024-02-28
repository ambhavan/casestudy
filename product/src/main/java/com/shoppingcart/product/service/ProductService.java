package com.shoppingcart.product.service;

import java.util.List;
import com.shoppingcart.product.model.ProductDTO;

public interface ProductService 
{
		void addProduct(ProductDTO productDTO);
		List<ProductDTO> getAllProducts();
		ProductDTO getProductByProductId(String productId); 
		ProductDTO getProductByProductName(String productName); 
		ProductDTO updateProduct(String productId, ProductDTO productDTO); 
		void deleteProductById(String productId) ;
		List<ProductDTO> getProductByCategory(String category);
		List<ProductDTO> getProductByProductType(String productType);
		
}