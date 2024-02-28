package com.shoppingcart.cart.service;

import java.util.List;
import java.util.Map;

import com.shoppingcart.cart.model.CartDTO;
;

public interface CartService 
{
	void addCart(CartDTO cartDTO);
	CartDTO getCartByCustomerId(String customerId);
	CartDTO getCartByCartId(String cartId);
	CartDTO updateCart(CartDTO cartDTO, String cartId);
	List<CartDTO>getAllCart();
	Map<String, Double> cartTotal( String cartId);
	
}
