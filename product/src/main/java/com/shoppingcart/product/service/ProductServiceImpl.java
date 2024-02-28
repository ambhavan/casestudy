package com.shoppingcart.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.product.model.ProductDTO;
import com.shoppingcart.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	private ProductRepository productrepository;

	@Override
	public void addProduct(ProductDTO productDTO) 
	{
		this.productrepository.save(productDTO);
		
	}

	@Override
	public List<ProductDTO> getAllProducts() 
	{
		return this.productrepository.findAll();
	}

	@Override
	public ProductDTO getProductByProductId(String productId)
	{
		return this.productrepository.findById(productId).get();
	}

	@Override
	public ProductDTO getProductByProductName(String productName)
	{
		return this.productrepository.findByProductName(productName);
		
	}

	@Override
	public ProductDTO updateProduct(String productId, ProductDTO productDTO) 
	{
		ProductDTO p=this.productrepository.findById(productId).get();
		p.setCategory(productDTO.getCategory());
		p.setDescription(productDTO.getDescription());
		p.setImage(productDTO.getImage());
		p.setQuantity(productDTO.getQuantity());
		p.setPrice(productDTO.getPrice());
		p.setProductName(productDTO.getProductName());
		p.setProductType(productDTO.getProductType());
		p.setRating(productDTO.getRating());
		return this.productrepository.save(p);
		
	}

	@Override
	public void deleteProductById(String productId) 
	{
		this.productrepository.deleteById(productId);
		
	}

	@Override
	public List<ProductDTO> getProductByCategory(String category) 
	{
		
		return this.productrepository.findByCategory(category);
	}

	@Override
	public List<ProductDTO> getProductByProductType(String productType) 
	{
		return this.productrepository.findByProductType(productType);
	}
}


	



