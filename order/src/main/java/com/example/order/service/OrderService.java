package com.example.order.service;

import java.util.List;
import com.example.order.enity.DeliveryAddressDTO;
import com.example.order.enity.OrderDTO;

public interface OrderService 
{
	
		List<OrderDTO> getAllOrder();
		void placeOrder(OrderDTO order);
		OrderDTO changeStatus(String orderId, OrderDTO order);
		void deleteOrder(String orderId);
		List<OrderDTO>getOrderByCustomerId(String customerId);
		void storeAddress(DeliveryAddressDTO address);
		List<DeliveryAddressDTO> getAllAddress();
		OrderDTO getOrderById(String orderId);
		List<DeliveryAddressDTO> getAddressByCustomerId(String customerId);
		void onlinePayment(OrderDTO order);

}
