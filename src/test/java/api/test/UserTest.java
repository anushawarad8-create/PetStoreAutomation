package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {

	Faker faker;
	User userpayload;
	
	public Logger logger;
	
	@BeforeClass
	public void setUpData() 
	{
		faker = new Faker();
		userpayload = new User();
		
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setFirstname(faker.name().firstName());
		userpayload.setLastname(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5, 10));
		userpayload.setUsername(faker.name().username());
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
		logger = LogManager.getLogger(this.getClass());
		
	}
	
	@Test(priority = 1)
	
	public void testPostCreateUser()
	{
		logger.info("********* creating user ********");
		
		Response response =UserEndPoints.createUser(userpayload);
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200);
		
		logger.info("********* created user successfully ********");
	}
	
	@Test(priority = 2)
	
	public void testGetUserByName() {
		
		logger.info("********* getting user ********");
		
		Response response=UserEndPoints.readUser(userpayload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(),200);
		
		logger.info("********* getting user successfully ********");
		
	}
	
	@Test(priority=3)
	
	public void testUpdateUserByName()
	{
		logger.info("********* update user ********");
		
		userpayload.setFirstname(faker.name().firstName());
		userpayload.setLastname(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response = UserEndPoints.updateUser(this.userpayload.getUsername(), userpayload);
		response.then().log().body();
			
		Assert.assertEquals(response.statusCode(), 200);
			
		logger.info("********* update user successfully ********");
	}
	
	@Test(priority =4)
	
	public void testDeleteUserByName()
	{
		logger.info("********* delete user ********");
		
		Response response=UserEndPoints.deleteUser(this.userpayload.getUsername());
		
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200);
		
		logger.info("********* deleting user successfully********");
		
	}
}

