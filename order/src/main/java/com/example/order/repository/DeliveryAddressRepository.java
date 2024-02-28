package com.example.order.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.order.enity.DeliveryAddressDTO;

public interface DeliveryAddressRepository extends MongoRepository<DeliveryAddressDTO ,String>
{
	List<DeliveryAddressDTO>findAddressByCustomerId(String customerId);
}
