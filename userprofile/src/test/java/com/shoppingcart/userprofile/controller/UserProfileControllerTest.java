package com.shoppingcart.userprofile.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.google.common.base.Optional;
import com.shoppingcart.userprofile.model.AddressDTO;
import com.shoppingcart.userprofile.model.Role;
import com.shoppingcart.userprofile.model.UserProfileDTO;
import com.shoppingcart.userprofile.repository.UserProfileRepository;
import com.shoppingcart.userprofile.service.UserProfileService;
@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes= {UserProfileControllerTest.class})
class UserProfileControllerTest
{
	@Mock
	UserProfileService userservice;
	@InjectMocks
	UserProfileController usercontroller;
	List<UserProfileDTO> profile;
	UserProfileDTO p;
	@Test
	public void test_getAllProfiles()
	{
		profile=new ArrayList<UserProfileDTO>();
		profile.add(new UserProfileDTO("A1","Anshika","ancimage","anshika@gmail.com",720139364441L,"anshika@123"));
		profile.add(new UserProfileDTO("A2","Abhijata","abhimage","abhi@gmail.com",730139364441L,"abhijata@123"));
		when(userservice.getAllProfiles()).thenReturn(profile);
		ResponseEntity<?> res=usercontroller.getAllProfiles();
		assertEquals(HttpStatus.OK,res.getStatusCode());
		assertEquals(2,((List<UserProfileDTO>) res.getBody()).size());
	}
	@Test
	public void test_getByProfileId()
	{
		UserProfileDTO user=new UserProfileDTO("A2","Abhijata","abhimage","abhi@gmail.com",730139364441L,"abhijata@123");
		String id="A2";
		when(userservice.getByProfileId(id)).thenReturn(user);
		ResponseEntity<?> res=usercontroller.getByProfileId(id);
		assertEquals(HttpStatus.OK,res.getStatusCode());
		
	}
	@Test
	public void test_getByUserName()
	{
		
		UserProfileDTO user=new UserProfileDTO("A2","Abhijata","abhimage","abhi@gmail.com",730139364441L,"abhijata@123");
		String name="Abhijata";
		when(userservice.getByUserName(name)).thenReturn(user);
		ResponseEntity<?> res=usercontroller.getByUserName(name);
		assertEquals(HttpStatus.OK,res.getStatusCode());
		
	}
	@Test
	public void test_findByMobileNo()
	{
		
		UserProfileDTO user=new UserProfileDTO("A2","Abhijata","abhimage","abhi@gmail.com",730139364441L,"abhijata@123");
		Long number=730139364441L;
		when(userservice.findByMobileNo(number)).thenReturn(user);
		ResponseEntity<?> res=usercontroller.findByMobileNo(number);
		assertEquals(HttpStatus.OK,res.getStatusCode());
		
	}
	
	@Test
	public void test_updateProfile()
	{
		UserProfileDTO x=new UserProfileDTO("A2","Abhijata","abhimage","abhi@gmail.com",730139364441L,"abhijata@123");
	    String id="A2";
	   
	    when(userservice.updateProfile(id, x)).thenReturn(x);
	    ResponseEntity<?> res=usercontroller.updateProfile(x, id);
	    assertEquals(HttpStatus.OK,res.getStatusCode());
	    
	}
	@Test
	public void test_deleteProfileId()
	{
		UserProfileDTO x=new UserProfileDTO("A2","Abhijata","abhimage","abhi@gmail.com",730139364441L,"abhijata@123");
	   String id="A2";
		
		userservice.deleteProfileId(id);
		ResponseEntity<?> res=usercontroller.deleteProfileId(id);
		assertEquals(HttpStatus.OK,res.getStatusCode());
	}
//	@Test
//	public void test_addNewCustomerProfile()
//	{
//		UserProfileDTO y=new UserProfileDTO("A2","Abhijata","abhimage","abhi@gmail.com",730139364441L,"abhijata@123");
////		UserProfileDTO k=new UserProfileDTO(null, null, null, null, null, null, null, null);
////		userservice.addNewCustomerProfile(k);
//		ResponseEntity<?> res=usercontroller.addNewCustomerProfile(y);
//		assertEquals(HttpStatus.OK,res.getStatusCode());
//		
//	}
//	
//	@Test
//	public void test_addNewMerchantProfile()
//	{
//		UserProfileDTO w=new UserProfileDTO("A4","Gaurav","gauravimage","gaurav@gmail.com",830139364441L,"gaurav@123");
////		userservice.addNewMerchantProfile(w);
//		ResponseEntity<?> res=usercontroller.addNewMerchantProfile(w);
//		assertEquals(w,res.getBody());
//	}
	
	

}