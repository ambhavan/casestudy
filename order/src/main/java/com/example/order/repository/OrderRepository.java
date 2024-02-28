package com.example.order.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.order.enity.OrderDTO;

public interface OrderRepository extends MongoRepository<OrderDTO, String> 
{
	List<OrderDTO>findByCustomerId(String customerId);
	OrderDTO findFirstByOrderByOrderId();
}

