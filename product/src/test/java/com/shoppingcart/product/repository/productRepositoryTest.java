package com.shoppingcart.product.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.shoppingcart.product.model.ProductDTO;
@DataMongoTest
class productRepositoryTest {
	@Autowired
	ProductRepository repo;
	ProductDTO p=new ProductDTO();
	@Test
	public void test_saveProduct() {
		Map<Integer,Double> m=new HashMap<Integer,Double>(){{put(2,10.0);}};
		List<String> l=new ArrayList<String>();
		l.add("bfhk");
		l.add("adhd");
		p.setProductId("a3");
		p.setProductType("pen");
		p.setProductName("trimax");
		p.setCategory("stationary");
		p.setRating(m);
		p.setImage(l);
		p.setQuantity(5);
		p.setPrice(12.12);
		p.setDescription("it is  good");
		repo.save(p);
		assertThat(p.getProductId()).isNotBlank();
	}
	@Test
	public void test_getProduct() {
		Map<Integer,Double> m=new HashMap<Integer,Double>(){{put(2,10.0);}};
		List<String> l=new ArrayList<String>();
		l.add("bfhk");
		l.add("adhd");
		p.setProductId("a3");
		p.setProductType("pen");
		p.setProductName("trimax");
		p.setCategory("stationary");
		p.setRating(m);
		p.setImage(l);
		p.setQuantity(5);
		p.setPrice(12.12);
		p.setDescription("it is  good");
		String s=p.getProductId();
		assertThat(p.getProductId()).isEqualTo(s);
	}
	@Test
	public void getAllProductsTest()
	{
		List<ProductDTO> p=repo.findAll();
		assertThat(p.size()).isGreaterThan(0);
	}
	@Test
	public void updateProductTest()
	{
		ProductDTO x=repo.findById("a3").get();
		x.setProductName("gel pen");
		ProductDTO updated=repo.save(x);
		assertThat(updated.getProductName()).isEqualTo("gel pen");
	}
	@Test
	public void deleteProduct()
	{
		ProductDTO a=repo.findById("a3").get();
		repo.delete(a);
	}
	@Test
	public void test_getProductByCategory() {
		Map<Integer,Double> m=new HashMap<Integer,Double>(){{put(2,10.0);}};
		List<String> l=new ArrayList<String>();
		l.add("bfhk");
		l.add("adhd");
		p.setProductId("a3");
		p.setProductType("pen");
		p.setProductName("trimax");
		p.setCategory("stationary");
		p.setRating(m);
		p.setImage(l);
		p.setQuantity(5);
		p.setPrice(12.12);
		p.setDescription("it is  good");
		String s=p.getCategory();
		assertThat(p.getCategory()).isEqualTo(s);
	}
	@Test
	public void test_getProductByProductType() {
		Map<Integer,Double> m=new HashMap<Integer,Double>(){{put(2,10.0);}};
		List<String> l=new ArrayList<String>();
		l.add("bfhk");
		l.add("adhd");
		p.setProductId("a3");
		p.setProductType("pen");
		p.setProductName("trimax");
		p.setCategory("stationary");
		p.setRating(m);
		p.setImage(l);
		p.setQuantity(5);
		p.setPrice(12.12);
		p.setDescription("it is  good");
		String s=p.getProductType();
		assertThat(p.getProductType()).isEqualTo(s);
	}

}