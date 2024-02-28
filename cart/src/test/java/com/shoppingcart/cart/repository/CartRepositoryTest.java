package com.shoppingcart.cart.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.shoppingcart.cart.model.CartDTO;
import com.shoppingcart.cart.model.ItemDTO;
import com.shoppingcart.cart.repository.CartRepository;
import com.shoppingcart.cart.repository.ItemRepository;
@DataMongoTest
class CartRepositoryTest {
 @Autowired
 CartRepository cartrepo;
 @Autowired
 ItemRepository itemrepo;
	@Test
	public void test_saveCart() {
		ItemDTO d=new ItemDTO();
			d.setProductName("pen");
			d.setPrice(50);
			d.setQuantity(100);
			List<ItemDTO> l=new ArrayList<>();
			l.add(d);
			CartDTO c=new CartDTO();
			c.setCartId("1");
			c.setCustomerId("a1");
			c.setTotalPrice(5000.0);
			c.setItemDTO(l);
			cartrepo.save(c);
			assertThat(c.getCartId()).isNotBlank();
		
	}
	@Test
	public void test_getAllCarts()
	{
		
			List<CartDTO> l=cartrepo.findAll();
			assertThat(l.size()).isGreaterThan(0);
	}
	@Test
	public void test_getCartByCartId()
	{
		ItemDTO d=new ItemDTO();
		d.setProductName("pen");
		d.setPrice(50);
		d.setQuantity(100);
		List<ItemDTO> l=new ArrayList<>();
		l.add(d);
		CartDTO c=new CartDTO();
		c.setCartId("1");
		c.setCustomerId("a1");
		c.setTotalPrice(5000.0);
		c.setItemDTO(l);
		String p=c.getCartId();
		assertThat(c.getCartId()).isEqualTo(p);
	}
	@Test
	public void test_getCartByustomerId()
	{
		ItemDTO d=new ItemDTO();
		d.setProductName("pen");
		d.setPrice(50);
		d.setQuantity(100);
		List<ItemDTO> l=new ArrayList<>();
		l.add(d);
		CartDTO c=new CartDTO();
		c.setCartId("1");
		c.setCustomerId("a1");
		c.setTotalPrice(5000.0);
		c.setItemDTO(l);
		String p=c.getCustomerId();
		assertThat(c.getCustomerId()).isEqualTo(p);
	}
	@Test
	public void test_deleteCart()
	{
		CartDTO c= cartrepo.findById("1").get();
		cartrepo.delete(c);
	}
	@Test
	public void test_updateCart()
	{
		CartDTO c= cartrepo.findById("1").get();
	     c.setCustomerId("a2");;
	     CartDTO updated=cartrepo.save(c);
	}


}