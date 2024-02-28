package com.shoppingcart.product.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.product.model.ProductDTO;
import com.shoppingcart.product.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/products/")
@RestController
public class ProductController
{
	@Autowired
	private ProductService productservice;
    
	@PostMapping()
	public ResponseEntity<?> addProduct(@RequestBody ProductDTO productDTO)
	{
		try
		{
			productservice.addProduct(new ProductDTO(productDTO.getProductType(),productDTO.getProductName(),productDTO.getCategory(),productDTO.getRating(),productDTO.getImage(),productDTO.getQuantity(),productDTO.getPrice(),productDTO.getDescription()));
			return new ResponseEntity<ProductDTO>(HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping()
	public ResponseEntity<?>getAllProducts()
	{
		try
		{
			
			List<ProductDTO> li=this.productservice.getAllProducts();
			return new ResponseEntity<>(li,HttpStatus.OK);
		}
			catch(Exception e)
			{
				return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	@GetMapping("{productId}")
				 
	public ResponseEntity<?>getProductByProductId(@PathVariable("productId") String productId)
	{
		try
		{
			ProductDTO p=this.productservice.getProductByProductId(productId);
			return new ResponseEntity<>(p,HttpStatus.OK);
		}
			catch(Exception e)
			{
				return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
	@GetMapping("/products/c/{productName}")
	public ResponseEntity<?>getProductByProductName(@PathVariable("productName") String productName)
	{
		try
		{
			ProductDTO p=this.productservice.getProductByProductName(productName);
			return new ResponseEntity<>(p,HttpStatus.OK);
		}
			catch(Exception e)
			{
				return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	@PutMapping("/products/{productId}")
	public ResponseEntity<?>updateProduct(@RequestBody ProductDTO productDTO,@PathVariable("productId") String productId)
	{
		try
		{
		ProductDTO p=this.productservice.updateProduct(productId, productDTO);
		return new ResponseEntity<>(p,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("{productId}")
	public ResponseEntity<?>deleteProduct(@PathVariable("productId") String productId)
	{
		try
		{
			this.productservice.deleteProductById(productId);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		}
	@GetMapping("/products/b/{productCategory}")
	public ResponseEntity<?>getByProductCategory(@PathVariable("productCategory") String productCategory)
	{
		try
		{
			List<ProductDTO> li=this.productservice.getProductByCategory(productCategory);
			return new ResponseEntity<>(li,HttpStatus.OK);
		}
			catch(Exception e)
			{
				return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
	@GetMapping("/products/a/{productType}")
	public ResponseEntity<?>getByProductType(@PathVariable("productType") String productType)
	{
		try
		{
			List<ProductDTO> li=this.productservice.getProductByProductType(productType);
			return new ResponseEntity<>(li,HttpStatus.OK);
		}
			catch(Exception e)
			{
				return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
	}

	

