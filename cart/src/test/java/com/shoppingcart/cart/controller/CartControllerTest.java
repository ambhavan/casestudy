package com.shoppingcart.cart.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.shoppingcart.cart.model.CartDTO;
import com.shoppingcart.cart.model.ItemDTO;
import com.shoppingcart.cart.service.CartService;
@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes= {CartControllerTest.class})

class CartControllerTest {
 @Mock
 CartService serv;
 @InjectMocks
 CartController c;
 List<CartDTO> list=new ArrayList<CartDTO>();
	@Test
	public void test_getAllCart() {
		ItemDTO d=new ItemDTO();
		d.setProductName("pen");
		d.setPrice(50);
		d.setQuantity(100);
		List<ItemDTO> l=new ArrayList<>();
		l.add(d);
		CartDTO x=new CartDTO();
		x.setCartId("1");
		x.setCustomerId("a1");
		x.setTotalPrice(5000.0);
		x.setItemDTO(l);
		list.add(x);
		when(serv.getAllCart()).thenReturn(list);
		ResponseEntity<?> res=c.getAllCart();
		assertEquals(HttpStatus.OK,res.getStatusCode());
		assertEquals(1,((List<CartDTO>) res.getBody()).size());
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
		CartDTO x=new CartDTO();
		x.setCartId("1");
		x.setCustomerId("a1");
		x.setTotalPrice(5000.0);
		x.setItemDTO(l);
		list.add(x);
		String id="1";
		when(serv.getCartByCartId(id)).thenReturn(x);
		ResponseEntity<?> res=c.getProductBycartId(id);
		assertEquals(HttpStatus.OK,res.getStatusCode());
	}
	@Test
	public void test_getCartByCustomerId()
	{
		ItemDTO d=new ItemDTO();
		d.setProductName("pen");
		d.setPrice(50);
		d.setQuantity(100);
		List<ItemDTO> l=new ArrayList<>();
		l.add(d);
		CartDTO x=new CartDTO();
		x.setCartId("1");
		x.setCustomerId("a1");
		x.setTotalPrice(5000.0);
		x.setItemDTO(l);
		list.add(x);
		String id="a1";
		when(serv.getCartByCustomerId(id)).thenReturn(x);
		ResponseEntity<?> res=c.getCartByCustomerId(id);
		assertEquals(HttpStatus.OK,res.getStatusCode());
	}
	@Test
	public void test_updateProduct()
	{
		ItemDTO d=new ItemDTO();
		d.setProductName("pen");
		d.setPrice(50);
		d.setQuantity(100);
		List<ItemDTO> l=new ArrayList<>();
		l.add(d);
		CartDTO x=new CartDTO();
		x.setCartId("1");
		x.setCustomerId("a1");
		x.setTotalPrice(5000.0);
		x.setItemDTO(l);
		String id="a1";
		when(serv.updateCart(x, id)).thenReturn(x);
		ResponseEntity<?> res=c.updateProduct(x, id);
		assertEquals(HttpStatus.OK,res.getStatusCode());
	}
	@Test
	public void test_addProduct()
	{
		ItemDTO d=new ItemDTO();
		d.setProductName("pen");
		d.setPrice(50);
		d.setQuantity(100);
		List<ItemDTO> l=new ArrayList<>();
		l.add(d);
		CartDTO x=new CartDTO();
		x.setCartId("1");
		x.setCustomerId("a1");
		x.setTotalPrice(5000.0);
		x.setItemDTO(l);
		String id="a1";
		serv.addCart(x);
		ResponseEntity<?> res=c.addCart(x);
		assertEquals(HttpStatus.CREATED,res.getStatusCode());
	}

}