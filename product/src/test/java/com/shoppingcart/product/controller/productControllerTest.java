package com.shoppingcart.product.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.shoppingcart.product.model.ProductDTO;
import com.shoppingcart.product.service.ProductService;
@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes= {productControllerTest.class})
class productControllerTest {
  @Mock
  ProductService serv;
  @InjectMocks
  ProductController c;
  List<ProductDTO> products;
  
	@Test
	public void test_getAllProducts() {
		Map<Integer,Double> m=new HashMap<Integer,Double>(){{put(2,10.0);}};
		List<String> l=new ArrayList<String>();
	  ProductDTO p = new ProductDTO();
	  
		l.add("bdhk");
		l.add("ashd");
		p.setProductId("a3");
		p.setProductType("laptop");
		p.setProductName("apple");
		p.setCategory("book");
		p.setRating(m);
		p.setImage(l);
		p.setQuantity(10);
		p.setPrice(1256.12);
		p.setDescription("it is very good");
	  
		products=new ArrayList<ProductDTO>();
		products.add(p);
		when(serv.getAllProducts()).thenReturn(products);
		ResponseEntity<?> res=c.getAllProducts();
		assertEquals(HttpStatus.OK,res.getStatusCode());
		
	}
	@Test
	public void test_getProductByProductId()
	{
		Map<Integer,Double> m=new HashMap<Integer,Double>(){{put(2,10.0);}};
		List<String> l=new ArrayList<String>();
	  ProductDTO p = new ProductDTO();
	  
		l.add("bdhk");
		l.add("ashd");
		p.setProductId("a3");
		p.setProductType("laptop");
		p.setProductName("apple");
		p.setCategory("book");
		p.setRating(m);
		p.setImage(l);
		p.setQuantity(10);
		p.setPrice(1256.12);
		p.setDescription("it is very good");
		String id="a3";
	    when(serv.getProductByProductId(id)).thenReturn(p);
	    ResponseEntity<?> res=c.getProductByProductId(id);
	    assertEquals(HttpStatus.OK,res.getStatusCode());
	}
	@Test
	public void test_getProductByProductName()
	{
		Map<Integer,Double> m=new HashMap<Integer,Double>(){{put(2,10.0);}};
		List<String> l=new ArrayList<String>();
	  ProductDTO p = new ProductDTO();
	  
		l.add("bdhk");
		l.add("ashd");
		p.setProductId("a3");
		p.setProductType("laptop");
		p.setProductName("apple");
		p.setCategory("book");
		p.setRating(m);
		p.setImage(l);
		p.setQuantity(10);
		p.setPrice(1256.12);
		p.setDescription("it is very good");
		String name="apple";
	    when(serv.getProductByProductName(name)).thenReturn(p);
	    ResponseEntity<?> res=c.getProductByProductName(name);
	    assertEquals(HttpStatus.OK,res.getStatusCode());
	}
	@Test
	public void test_getProductByCategory()
	{
		Map<Integer,Double> m=new HashMap<Integer,Double>(){{put(2,10.0);}};
		List<String> l=new ArrayList<String>();
	  ProductDTO p = new ProductDTO();
	  
		l.add("bdhk");
		l.add("ashd");
		p.setProductId("a3");
		p.setProductType("laptop");
		p.setProductName("apple");
		p.setCategory("book");
		p.setRating(m);
		p.setImage(l);
		p.setQuantity(10);
		p.setPrice(1256.12);
		p.setDescription("it is very good");
		products=new ArrayList<ProductDTO>();
		products.add(p);
		String category="book";
	    when(serv.getProductByCategory(category)).thenReturn(products);
	    ResponseEntity<?> res=c.getByProductCategory(category);
	    assertEquals(HttpStatus.OK,res.getStatusCode());
	}
	@Test
	public void test_getProductByProductType()
	{
		Map<Integer,Double> m=new HashMap<Integer,Double>(){{put(2,10.0);}};
		List<String> l=new ArrayList<String>();
	  ProductDTO p = new ProductDTO();
	  
		l.add("bdhk");
		l.add("ashd");
		p.setProductId("a3");
		p.setProductType("laptop");
		p.setProductName("apple");
		p.setCategory("book");
		p.setRating(m);
		p.setImage(l);
		p.setQuantity(10);
		p.setPrice(1256.12);
		p.setDescription("it is very good");
		products=new ArrayList<ProductDTO>();
		products.add(p);
		String type="laptop";
	    when(serv.getProductByProductType(type)).thenReturn(products);
	    ResponseEntity<?> res=c.getByProductType(type);
	    assertEquals(HttpStatus.OK,res.getStatusCode());
	}
	@Test
	public void test_deleteProduct()
	{
		Map<Integer,Double> m=new HashMap<Integer,Double>(){{put(2,10.0);}};
		List<String> l=new ArrayList<String>();
	  ProductDTO p = new ProductDTO();
	  
		l.add("bdhk");
		l.add("ashd");
		p.setProductId("a3");
		p.setProductType("laptop");
		p.setProductName("apple");
		p.setCategory("book");
		p.setRating(m);
		p.setImage(l);
		p.setQuantity(10);
		p.setPrice(1256.12);
		p.setDescription("it is very good");
		String id="a3";
		serv.deleteProductById(id);
		ResponseEntity<?> res=c.deleteProduct(id);
		assertEquals(HttpStatus.OK,res.getStatusCode());
	}
	@Test
	public void test_addProduct()
	{
		Map<Integer,Double> m=new HashMap<Integer,Double>(){{put(2,10.0);}};
		List<String> l=new ArrayList<String>();
	  ProductDTO p = new ProductDTO();
	  
		l.add("bdhk");
		l.add("ashd");
		p.setProductId("a3");
		p.setProductType("laptop");
		p.setProductName("apple");
		p.setCategory("book");
		p.setRating(m);
		p.setImage(l);
		p.setQuantity(10);
		p.setPrice(1256.12);
		p.setDescription("it is very good");
		serv.addProduct(p);
		ResponseEntity<?> r=c.addProduct(p);
		assertEquals(HttpStatus.CREATED,r.getStatusCode());
	}
	@Test
	public void test_updateProduct()
	{
		Map<Integer,Double> m=new HashMap<Integer,Double>(){{put(2,10.0);}};
		List<String> l=new ArrayList<String>();
	  ProductDTO p = new ProductDTO();
	  
		l.add("bdhk");
		l.add("ashd");
		p.setProductId("a3");
		p.setProductType("laptop");
		p.setProductName("apple");
		p.setCategory("book");
		p.setRating(m);
		p.setImage(l);
		p.setQuantity(10);
		p.setPrice(1256.12);
		p.setDescription("it is very good");
		String id="a3";
		when(serv.updateProduct(id, p)).thenReturn(p);
		ResponseEntity<?> res=c.updateProduct(p, id);
		assertEquals(HttpStatus.OK,res.getStatusCode());
	}

}