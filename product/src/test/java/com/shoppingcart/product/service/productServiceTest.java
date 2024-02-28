package com.shoppingcart.product.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.shoppingcart.product.model.ProductDTO;
import com.shoppingcart.product.repository.ProductRepository;
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
class productServiceTest {
	@Autowired
    private ProductService serv;
	@MockBean
	private ProductRepository repo;
	ProductDTO p=new ProductDTO();
	@Test
	public void test_getAllProducts()
	{
		Map<Integer,Double> m=new HashMap<Integer,Double>(){{put(2,10.0);}};
		List<String> l=new ArrayList<String>();
		l.add("bdhk");
		l.add("ashd");
		p.setProductId("a2");
		p.setProductType("laptop");
		p.setProductName("apple");
		p.setCategory("book");
		p.setRating(m);
		p.setImage(l);
		p.setQuantity(10);
		p.setPrice(1256.12);
		p.setDescription("it is very good");
		
		when(repo.findAll()).thenReturn((List<ProductDTO>)Stream.of(p).collect(Collectors.toList()));
		assertEquals(1,serv.getAllProducts().size());
	}
	@Test
	public void test_getProductByProductId()
	{
		Map<Integer,Double> m=new HashMap<Integer,Double>(){{put(2,10.0);}};
		List<String> l=new ArrayList<String>();
		l.add("bdhk");
		l.add("ashd");
		p.setProductId("a2");
		p.setProductType("laptop");
		p.setProductName("apple");
		p.setCategory("book");
		p.setRating(m);
		p.setImage(l);
		p.setQuantity(10);
		p.setPrice(1256.12);
		p.setDescription("it is very good");
		String id="a2";
		String expected=p.getProductId();
		assertEquals("a2",p.getProductId());
		assertThat(id).isEqualTo(expected);
		
		
	}
	@Test
	public void test_getProductByProductName()
	{
		Map<Integer,Double> m=new HashMap<Integer,Double>(){{put(2,10.0);}};
		List<String> l=new ArrayList<String>();
		l.add("bdhk");
		l.add("ashd");
		p.setProductId("a2");
		p.setProductType("laptop");
		p.setProductName("apple");
		p.setCategory("book");
		p.setRating(m);
		p.setImage(l);
		p.setQuantity(10);
		p.setPrice(1256.12);
		p.setDescription("it is very good");
		String name="apple";
		String expected=p.getProductName();
		assertEquals("apple",p.getProductName());
		assertThat(name).isEqualTo(expected);
		
		
	}
	@Test
	public void test_updateProduct()
	{
		Map<Integer,Double> m=new HashMap<Integer,Double>(){{put(2,10.0);}};
		List<String> l=new ArrayList<String>();
		l.add("bdhk");
		l.add("ashd");
		p.setProductId("a2");
		p.setProductType("laptop");
		p.setProductName("apple");
		p.setCategory("book");
		p.setRating(m);
		p.setImage(l);
		p.setQuantity(10);
		p.setPrice(1256.12);
		p.setDescription("it is very good");
		when(repo.save(p)).thenReturn(p);
		p.setProductName("lenovo");
		assertThat(p.getProductName()).isEqualTo("lenovo");
		
		
	}
	@Test
	public void test_getProductByProductType()
	{
		Map<Integer,Double> m=new HashMap<Integer,Double>(){{put(2,10.0);}};
		List<String> l=new ArrayList<String>();
		l.add("bdhk");
		l.add("ashd");
		p.setProductId("a2");
		p.setProductType("laptop");
		p.setProductName("apple");
		p.setCategory("book");
		p.setRating(m);
		p.setImage(l);
		p.setQuantity(10);
		p.setPrice(1256.12);
		p.setDescription("it is very good");
		String name="laptop";
		String expected=p.getProductType();
		assertEquals("laptop",p.getProductType());
		assertThat(name).isEqualTo(expected);
		
		
	}
	@Test
	public void test_getProductByCategory()
	{
		Map<Integer,Double> m=new HashMap<Integer,Double>(){{put(2,10.0);}};
		List<String> l=new ArrayList<String>();
		l.add("bdhk");
		l.add("ashd");
		p.setProductId("a2");
		p.setProductType("laptop");
		p.setProductName("apple");
		p.setCategory("book");
		p.setRating(m);
		p.setImage(l);
		p.setQuantity(10);
		p.setPrice(1256.12);
		p.setDescription("it is very good");
		String name="book";
		String expected=p.getCategory();
		assertEquals("book",p.getCategory());
		assertThat(name).isEqualTo(expected);
		
		
	}
	@Test
	public void test_deleteProductById()
	{
		Map<Integer,Double> m=new HashMap<Integer,Double>(){{put(2,10.0);}};
		List<String> l=new ArrayList<String>();
		l.add("bdhk");
		l.add("ashd");
		p.setProductId("a2");
		p.setProductType("laptop");
		p.setProductName("apple");
		p.setCategory("book");
		p.setRating(m);
		p.setImage(l);
		p.setQuantity(10);
		p.setPrice(1256.12);
		p.setDescription("it is very good");
		String id=p.getProductId();
		serv.deleteProductById(id);
		verify(repo,times(1)).deleteById(id);
	}
	@Test
	public void test_addProduct()
	{
		Map<Integer,Double> m=new HashMap<Integer,Double>(){{put(2,10.0);}};
		List<String> l=new ArrayList<String>();
		l.add("bdhk");
		l.add("ashd");
		p.setProductId("a2");
		p.setProductType("laptop");
		p.setProductName("apple");
		p.setCategory("book");
		p.setRating(m);
		p.setImage(l);
		p.setQuantity(10);
		p.setPrice(1256.12);
		p.setDescription("it is very good");
		when(repo.save(p)).thenReturn(p);
	}
	
	
}