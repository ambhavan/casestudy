package com.example.order.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.order.enity.DeliveryAddressDTO;
import com.example.order.enity.OrderDTO;
import com.example.order.service.OrderService;


@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/api")
@RestController
public class OrderController 
{
	@Autowired
	private OrderService orderservice;
	@Autowired
	private RestTemplate restTemplate;
	
	
	@GetMapping("/cart")
	String Cart(){
		
	    String cart = restTemplate.getForObject("http://cart-microservice/cart", String.class);

	    return cart;
	}
	@GetMapping("/order/payment")
	public ResponseEntity<?>onlinePayment(@RequestBody OrderDTO order)
	{
		try
		{
			orderservice.onlinePayment(order);
			return new ResponseEntity<OrderDTO>(HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping("/order")
	public ResponseEntity<?> placeOrder(@RequestBody OrderDTO order)
	{
		try
		{
			orderservice.placeOrder(new OrderDTO(order.getCustomerId(),order.getOrderDate(),order.getAddress(),order.getTotalPrice(),order.getAmountPaid(),order.getModeOfPayment(),order.getOrderStatus(),order.getItemDTO()));
			return new ResponseEntity<OrderDTO>(HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/order")
	public ResponseEntity<?>getAllOrder()
	{
		try
		{
			List<OrderDTO> li=this.orderservice.getAllOrder();
			return new ResponseEntity<>(li , HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/order/{orderId}")
	public ResponseEntity<?>changeStatus(@RequestBody OrderDTO order, @PathVariable("orderId") String orderId)
			{
				try
				{
					OrderDTO o = this.orderservice.changeStatus(orderId, order);
					return new ResponseEntity<>(o, HttpStatus.OK);
				}
				catch(Exception e)
				{
					return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
				}
				
			}
	@DeleteMapping("/order/{orderId}")
	public ResponseEntity<?>deleteOrder(@PathVariable("orderId")String orderId)
	{
		try
		{
			this.orderservice.deleteOrder(orderId);
			return new ResponseEntity<>(HttpStatus.OK);		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/profile/{customerId}")
	public ResponseEntity<?>getOrderByCustomerId(@PathVariable("customerId") String customerId)
	{
		try
		{
			List<OrderDTO> li=this.orderservice.getOrderByCustomerId(customerId);
			return new ResponseEntity<>(li, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/order/address")
	public ResponseEntity<?>storeAddress(@RequestBody DeliveryAddressDTO address )
			{
				try
				{
					System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
					System.out.println(address);
					orderservice.storeAddress(new DeliveryAddressDTO(address.getCustomerId(),address.getFullName(),address.getMobileNo(),address.getFlatNo(),address.getCity(),address.getPinCode(),address.getState()));
					return new ResponseEntity<DeliveryAddressDTO>(HttpStatus.CREATED);
				}
				catch(Exception e)
				{
					return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
				}
				
			}
	@GetMapping("/profile/address/{customerId}")
	public ResponseEntity<?>getAddressByCustomerId(@PathVariable("customerId") String customerId)
	{
		try
		{
			List<DeliveryAddressDTO> li=this.orderservice.getAddressByCustomerId(customerId);
			return new ResponseEntity<>(li, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/order/address")
	public ResponseEntity<?>getAllAddress()
	{
		try
		{
			List<DeliveryAddressDTO> li=this.orderservice.getAllAddress();
			return new ResponseEntity<>(li , HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/order/{orderId}")
	public ResponseEntity<?>getOrderById(@PathVariable("orderId") String orderId)
	{
		try
		{
			OrderDTO o=this.orderservice.getOrderById(orderId);
			return new ResponseEntity<>(o , HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	}
	

