package com.shoppingcart.cart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shoppingcart.cart.model.CartDTO;
import com.shoppingcart.cart.service.CartService;



@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class CartController 
{
	@Autowired
	private CartService cartservice;

	@PostMapping("/cart")
	public ResponseEntity<?>addCart(@RequestBody CartDTO cartDTO)
	{
		try
		{
			cartservice.addCart(cartDTO);
			return new ResponseEntity<CartDTO>(HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/cart/a/{customerId}")
	 
	public ResponseEntity<?>getCartByCustomerId(@PathVariable("customerId") String customerId)
	{
		try
		{
			CartDTO c=this.cartservice.getCartByCustomerId(customerId);
			return new ResponseEntity<>(c,HttpStatus.OK);
		}
			catch(Exception e)
			{
				return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
	@GetMapping("/cart/{cartId}")
	 
	public ResponseEntity<?>getProductBycartId(@PathVariable("cartId") String cartId)
	{
		try
		{
			CartDTO c=this.cartservice.getCartByCartId(cartId);
			return new ResponseEntity<>(c,HttpStatus.OK);
		}
			catch(Exception e)
			{
				return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
	@PutMapping("/cart/{cartId}")
	public ResponseEntity<?>updateProduct(@RequestBody CartDTO cartDTO,@PathVariable("cartId") String cartId)
	{
		try
		{
		CartDTO c=this.cartservice.updateCart(cartDTO, cartId);
		return new ResponseEntity<>(c,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/cart")
	public ResponseEntity<?>getAllCart()
	{
		try
		{
			List<CartDTO> li=this.cartservice.getAllCart();
			return new ResponseEntity<>(li,HttpStatus.OK);
		}
			catch(Exception e)
			{
				return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	@GetMapping("/cart/cartTotal/{cartId}")
	public ResponseEntity<?>cartTotal(@PathVariable("cartId") String cartId)
	{
		try
		{
			Map<String, Double> c=this.cartservice.cartTotal( cartId);
					return new ResponseEntity<>(c,HttpStatus.OK);
		}
			catch(Exception e)
			{
				return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}
