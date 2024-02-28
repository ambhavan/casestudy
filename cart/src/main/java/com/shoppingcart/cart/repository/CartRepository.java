package com.shoppingcart.cart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shoppingcart.cart.model.CartDTO;

public interface CartRepository extends MongoRepository<CartDTO, String> 
{
	CartDTO findByCartId(String cartId);
	CartDTO findByCustomerId(String customerId);
}
