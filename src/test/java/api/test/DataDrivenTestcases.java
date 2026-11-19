package api.test;

import org.testng.Assert;

import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTestcases {
	
	@Test(priority = 1, dataProvider="Data",dataProviderClass=DataProviders.class)
	
	public void testCreateUserByDDT(String UID, String Uname, String Fname, String Lname, String Email,String Pass, String Pno)
	{
		User Upayload = new User();
		
		Upayload.setId(Integer.parseInt(UID));
		Upayload.setFirstname(Fname);
		Upayload.setLastname(Lname);
		Upayload.setUsername(Uname);
		Upayload.setPassword(Pass);
		Upayload.setPhone(Pno);
		Upayload.setEmail(Email);
		
		Response response =UserEndPoints.createUser(Upayload);
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	@Test(priority =2, dataProvider="UserNames", dataProviderClass = DataProviders.class)
	
	public void testDeleteUserByDDT(String Uname)
	{
	
		Response response=UserEndPoints.deleteUser(Uname);
		
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200);
		
		
	}

}
