package com.shoppingcart.cart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.shoppingcart.cart.model.ItemDTO;

public interface ItemRepository extends MongoRepository<ItemDTO, String>  {

}
