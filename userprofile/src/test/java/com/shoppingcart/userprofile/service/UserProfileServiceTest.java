package com.shoppingcart.userprofile.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import com.shoppingcart.userprofile.model.UserProfileDTO;
import com.shoppingcart.userprofile.repository.UserProfileRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
class UserProfileServiceTest {

	
	@Autowired
	private UserProfileService userservice;
	@MockBean
	private UserProfileRepository userrepository;
	@Test
	public void getAllProfiles()
	{
		when(userrepository.findAll()).thenReturn((List<UserProfileDTO>) Stream.of( new UserProfileDTO("A1","Anshika","ancimage","anshika@gmail.com",7209364441L,"anshika123"),
				new UserProfileDTO("A2","Arjun","abcdmage","arjuna@gmail.com",8210933321L,"arjun123")).collect(Collectors.toList()));
		 assertEquals(2, userservice.getAllProfiles().size());
	}
	@Test
    public void addNewCustomerProfile()
    {
   	 UserProfileDTO profile=new UserProfileDTO("A1","Anshika","ancimage","anshika@gmail.com",7209364441L,"anshika@123");
   	 when(userrepository.save(profile)).thenReturn(profile);
    }
	@Test
	public void getByProfileId()
	{
		UserProfileDTO profile =new UserProfileDTO("A1","Anshika","ancimage","anshika@gmail.com", 7209364441L,"anshika@123");
		String expected = "A1";
		String actual = profile.getProfileId();
//		assertEquals("A1",profile.getProfileId());
		assertThat(actual).isEqualTo(expected);
	}
	
	@Test
	public void updateProfile()
	{
		UserProfileDTO profile =new UserProfileDTO("A1","Anshika","ancimage","anshika@gmail.com", 7209364441L,"anshika@123");
//		when(userrepository.save(profile)).thenReturn(profile);
		profile.setFullName("Rahul");
		assertThat(profile.getFullName()).isEqualTo("Rahul");
//		assertEquals(profile,userservice.updateProfile(profile));
	}
	 @Test
     public void deleteProfileIdTest()
     {
	   	 UserProfileDTO profile=new UserProfileDTO("A1","Anshika","ancimage","anshika@gmail.com",7209364441L,"anshika@123");
	   	 String profilId= profile.getProfileId();
	   	 userservice.deleteProfileId(profilId);
	   	verify(userrepository,times(1)).deleteById(profilId);
	   
     }
	 @Test
	 public void findByMobileNo()
	 {
		 UserProfileDTO profile =new UserProfileDTO("A1","Anshika","ancimage","anshika@gmail.com", 7209364441L,"anshika@123");
//		 long expected =7209364441L;
//		 long actual = profile.getMobileNumber();
//		 String message="true";
//		 assertEquals(expected,actual);
		 assertEquals(7209364441L, profile.getMobileNumber());
		 
	 }
	@Test
	public void getByUserName()
	{
		UserProfileDTO profile =new UserProfileDTO("A1","Anshika","ancimage","anshika@gmail.com",7209364441L,"anshika@123");
		String expected ="Anshika";
		String actual=profile.getFullName();
		 assertTrue(expected.equals(actual));
		 }
}

