package com.shoppingcart.userprofile.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import com.shoppingcart.userprofile.model.AddressDTO;
import com.shoppingcart.userprofile.model.Role;
import com.shoppingcart.userprofile.model.UserProfileDTO;
@DataMongoTest
class UserProfileRepositoryTest {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	@Autowired
	UserProfileRepository userrepository;
	
	@Test
	public void saveUserProfileTest()
	{
		 UserProfileDTO profile=new UserProfileDTO("A1","Anshika","ancimage","anshika@gmail.com",720139364441L,"anshika@123");
		 userrepository.save(profile);
		 assertThat(profile.getProfileId()).isGreaterThan("0");
	}
	@Test
	public void getProfileTest()
	{
		UserProfileDTO profile=new UserProfileDTO("A1","Anshika","ancimage","anshika@gmail.com",720139364441L,"anshika@123");
		String p=profile.getProfileId();
		assertThat(profile.getProfileId()).isEqualTo(p);
	}
	@Test
	public void getAllProfilesTest() 
	{
		List<UserProfileDTO> profile =userrepository.findAll();
		assertThat(profile.size()).isGreaterThan(0);
	}
	@Test
	public void updateProfileTest()
	{
		UserProfileDTO profile =userrepository.findById("A1").get();
		profile.setFullName("Rahul");
		UserProfileDTO updated=userrepository.save(profile);
		assertThat(updated.getFullName()).isEqualTo("Rahul");
	}
	@Test
	public void deletePerson()
	{
		UserProfileDTO profile =userrepository.findById("A1").get();
		userrepository.delete(profile);
	}
	@Test
	public void findAllByMobileNumber()
	{
		UserProfileDTO profile=new UserProfileDTO("A1","Anshika","ancimage","anshika@gmail.com",720139364441L,"anshika@123");
		long number =profile.getMobileNumber();
		assertThat(profile.getMobileNumber()).isEqualTo(number);
	}
//	@Test
//	public void  findByfullName()
//	{
//		UserProfileDTO profile =userrepository.findByfullName("Anshika");
//		assertThat(profile.getFullName()).isEqualTo(profile);
//	}
}
