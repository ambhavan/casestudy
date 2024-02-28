package com.example.order.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.order.enity.DeliveryAddressDTO;
import com.example.order.enity.CartDTO;
import com.example.order.enity.OrderDTO;
import com.example.order.repository.DeliveryAddressRepository;
import com.example.order.repository.OrderRepository;
@Service
public class OrderServiceImpl implements OrderService 
{
	@Autowired 
	private OrderRepository orderrepository;
	@Autowired 
	private DeliveryAddressRepository addressrepository;
	@Autowired 
	private RestTemplate restTemplate;

	@Override
	public List<OrderDTO> getAllOrder() 
	{
		return this.orderrepository.findAll();
	}

	@Override
	public OrderDTO changeStatus(String orderId, OrderDTO order) 
	{
		OrderDTO o=this.orderrepository.findById(orderId).get();
		o.setOrderStatus(order.getOrderStatus());
		return this.orderrepository.save(o);
	}

	@Override
	public void deleteOrder(String orderId) 
	{
		this.orderrepository.deleteById(orderId);
	}

	@Override
	public List<OrderDTO> getOrderByCustomerId(String customerId) 
	{
		
		return this.orderrepository.findByCustomerId(customerId);
	}

	@Override
	public void storeAddress(DeliveryAddressDTO address) 
	{
		
		this.addressrepository.save(address);
	}

	@Override
	public List<DeliveryAddressDTO> getAddressByCustomerId(String customerId) 
	{
		return this.addressrepository.findAddressByCustomerId(customerId);
	}

	@Override
	public List<DeliveryAddressDTO> getAllAddress() 
	{
		return this.addressrepository.findAll();
	}

	
	@Override
	public OrderDTO getOrderById(String orderId) 
	{
		return this.orderrepository.findById(orderId).get();
	}

	@Override
	public void placeOrder(OrderDTO order ) 
	{
		CartDTO cart = restTemplate.getForObject("http://cart-microservice/cart/a/"+order.getCustomerId(),CartDTO.class);
		order.setItemDTO(cart.getItemDTO());
		order.setTotalPrice(cart.getTotalPrice());
		this.orderrepository.save(order);
		cart.setItemDTO(null);
		restTemplate.postForObject("http://cart-microservice/cart/", cart, CartDTO.class);

	}

	@Override
	public void onlinePayment( OrderDTO order) 
	{
		CartDTO cart =restTemplate.getForObject("http://cart-microservice/cart/cartTotal", CartDTO.class);
		order.setTotalPrice(cart.getTotalPrice());
		this.orderrepository.save(order);
		
	}
	
}
