package com.shoppingcart.cart.service;

import java.util.HashMap;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shoppingcart.cart.model.CartDTO;
import com.shoppingcart.cart.model.ItemDTO;
import com.shoppingcart.cart.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService
{
	@Autowired
	private CartRepository cartrepository;
	@Override
	public void addCart(CartDTO cartDTO) 
	{
		CartDTO cart=this.cartrepository.findByCustomerId(cartDTO.getCustomerId());	
		if(cart == null)
		{
			this.cartrepository.save(cartDTO);
		}
		else
		{
			cart.setItemDTO(cartDTO.getItemDTO());
			this.cartrepository.save(cart);
		}
		
	}	

	@Override
	public CartDTO getCartByCartId(String cartId) 
	{
		CartDTO c=this.cartrepository.findById(cartId).get();
		List<ItemDTO> li=c.getItemDTO();
		double total= 0;
		for(int i=0;i<li.size();i++)
		{
			total += li.get(i).getPrice()*li.get(i).getQuantity();
		}
		c.setTotalPrice(total);	
		return c;
	}
	@Override
	public CartDTO getCartByCustomerId(String customerId) 
	{
		CartDTO cart=this.cartrepository.findByCustomerId(customerId);
		List<ItemDTO> li=cart.getItemDTO();
		double total= 0;
		if(li != null)
		{
			
			for(int i=0;i<li.size();i++)
			{
				total += li.get(i).getPrice()*li.get(i).getQuantity();
			}
			cart.setTotalPrice(total);
		}
		return cart;
		
	}

	@Override
	public CartDTO updateCart(CartDTO cartDTO, String cartId) 
	{
		CartDTO c=this.cartrepository.findById(cartId).get();
		c.setItemDTO(cartDTO.getItemDTO());
		return this.cartrepository.save(c) ;
	}

	@Override
	public List<CartDTO> getAllCart() 
	{
		List<CartDTO> c=this.cartrepository.findAll();
		for(int i=0;i<c.size();i++)
		{
			double total= 0;
			CartDTO cart=c.get(i);
			List<ItemDTO> li=cart.getItemDTO();
			if(li != null)
			{
				for(int j=0;j<li.size();j++)
				{
					total += li.get(j).getPrice()*li.get(j).getQuantity();
				}
				cart.setTotalPrice(total);
			}
		}
		return c;
	}

	@Override
	public Map<String, Double> cartTotal(String cartId) 
	{
		
		CartDTO c=this.cartrepository.findById(cartId).get();
		List<ItemDTO> li=c.getItemDTO();
		double total= 0;
		for(int i=0;i<li.size();i++)
		{
			total += li.get(i).getPrice()*li.get(i).getQuantity();
		}
		Map<String,Double> item = new HashMap<>();
		item.put("totalPrice", total);

		return item;
	
	}

	
       
}