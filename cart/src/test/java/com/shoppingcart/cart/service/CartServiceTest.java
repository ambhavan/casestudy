package com.shoppingcart.cart.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.shoppingcart.cart.model.CartDTO;
import com.shoppingcart.cart.model.ItemDTO;
import com.shoppingcart.cart.repository.CartRepository;
import com.shoppingcart.cart.repository.ItemRepository;
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
class CartServiceTest {
    @Autowired
    private CartService serv;
    @MockBean
    CartRepository repo;
    @MockBean
    ItemRepository repository;
	@Test
	public void test_getAllCart() {
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
		when(repo.findAll()).thenReturn((List<CartDTO>)Stream.of(c).collect(Collectors.toList()));
		assertEquals(1,serv.getAllCart().size());
	}
	@Test
	public void getCartByCartId()
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
		String expected="1";
		String actual=c.getCartId();
		assertEquals("1",c.getCartId());
		assertThat(actual).isEqualTo(expected);
	}
	@Test
	public void getCartByCustomerId()
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
		String expected="a1";
		String actual=c.getCustomerId();
		assertEquals("a1",c.getCustomerId());
		assertThat(actual).isEqualTo(expected);
	}
	@Test
	public void test_addCart()
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
		when(repo.save(c)).thenReturn(c);
	}
	@Test
	public void test_updateCart()
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
		when(repo.save(c)).thenReturn(c);
		c.setTotalPrice(4000.0);
		assertThat(c.getTotalPrice()).isEqualTo(4000.0);
		
		
	}


}